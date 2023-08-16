/*
트리거 : 이벤트(insert, update, delete)에 반응해 자동으로 실행되는 작업
사용하는 이유 => 데이터 일관성을 유지하기 위해

트리거 특징
- OLD 와 NEW 를 통해 이벤트를 발생된 데이터를 접근할 수 있다.
	- INSERT 이벤트에는 이전 데이터가 없기 때문에 NEW를 통해서만 추가된 데이터에 접근할 수 있다.
    - DELETE 이벤트에는 새로운 데이터가 없기 때문에 OLD 를 통해서만 삭제된 데이터에 접근할 수 있다.
    - UPDATE 이벤트에서는 수정되기 전 데이터는 OLD로, 수정된 데이터는 NEW로 접근할 수 있다.
    - OLD.속성명, NEW.속성명 
- 이벤트가 발생된 데이터는 수정할 수 없다. 

트리거 사용 예시
- 쇼핑몰에서 회원이 주문을 완료하면 주문 리스트테이블에 데이터가 추가 => 옵션 수량이 변경



[기본 문법]
DROP TRIGGER IF EXISTS 트리거명;
DELIMITER // 
CREATE TRIGGER 트리거명 트리거시간 이벤트명 ON 테이블명
FOR EACH ROW 
BEGIN
//구현
END //
DELIMITER ;

트리거 시간 : BEFORE | AFTER
이벤트명 : INSERT | UPDATE | DELETE
*/

USE `TEST`;

DROP TRIGGER IF EXISTS INSERT_MEMBER;

-- MEMBER 테이블에 사람이 추가될 때 마다 DASH_BOARD 테이블의 DB_MEMBER에 사람인원 수 증가시키는 트리거 
DELIMITER //
CREATE TRIGGER INSERT_MEMBER AFTER INSERT ON MEMBER
FOR EACH ROW -- 각행마다 적용
BEGIN
	UPDATE dash_board
    SET 
		db_member = db_member + 1;
END //
DELIMITER ;

INSERT INTO MEMBER(ME_ID, ME_PW) VALUES('ABC123','ABC123'),('ADMIN','ADMIN');



-- 회원이 게시글을 작성하면 회원의 작성된 게시글 수가 증가하는 트리거 
DROP TRIGGER IF EXISTS INSERT_BOARD;

DELIMITER //
CREATE TRIGGER INSERT_BOARD AFTER INSERT ON BOARD
FOR EACH ROW
BEGIN
	UPDATE member
    SET 
		me_board_count = me_board_count + 1
	WHERE 
		me_id = NEW.BO_ME_ID; -- 새로 추가된 BOARD의 ME_ID 값만 가져와서 그 아이디와 같은 것만 count 증가 
END //
DELIMITER ;

INSERT INTO BOARD(BO_TITLE, BO_ME_ID) VALUES ('게시글','ABC123');


-- 게시글에 삭제됐을 때 해당 게시글을 작성한 회원의 게시글 수를 1 줄이는 트리거
DROP TRIGGER IF EXISTS DELETE_BOARD;

DELIMITER //
CREATE TRIGGER DELETE_BOARD AFTER DELETE ON BOARD
FOR EACH ROW
BEGIN
	UPDATE member
    SET 
		me_board_count = me_board_count - 1
	WHERE 
		me_id = OLD.BO_ME_ID; -- 새로 추가된 BOARD의 ME_ID 값만 가져와서 그 아이디와 같은 것만 count 증가 
END //
DELIMITER ;

DELETE FROM BOARD WHERE BO_NUMBER =1;






USE SHOPPINGMALL;

-- 회원이 제품을 주문했을 때 필요한 트리거
 -- 주문 테이블에 데이터가 추가가 됨 => 주문 리스트에 데이터 추가 => 각 주문 리스트에 맞는 옵션에 수량이 변경
 -- 주문 리스트에 데이터가 추가될 때 각 주문 리스트에 맞는 옵션 수량이 변경되는 트리거

DROP TRIGGER IF EXISTS UPDATE_OPTION;

DELIMITER //
CREATE TRIGGER UPDATE_OPTION AFTER INSERT ON `ORDER_LIST`
FOR EACH ROW
BEGIN
	UPDATE `OPTION`
    SET OP_AMOUNT = OP_AMOUNT - NEW.OL_AMOUNT
    WHERE OP_NUM = NEW.OL_OP_NUM ;
END //
DELIMITER ;
		
INSERT INTO `ORDER` (OR_NUM,OR_TOTAL, OR_PRICE, OR_USE_POINT, OR_SAVE_POINT, OR_ME_ID, OR_AD_NUM)
VALUES(3,45000, 45000,0,4500,'qwe123',2);

INSERT INTO ORDER_LIST(OL_AMOUNT, OL_PRICE, OL_OR_NUM, OL_OP_NUM)
VALUES(1,15000,3,1),(1,30000,3,3);


INSERT INTO `ORDER` (OR_NUM,OR_TOTAL, OR_PRICE, OR_USE_POINT, OR_SAVE_POINT, OR_ME_ID, OR_AD_NUM)
VALUES(4,60000, 60000,0,6000,'qwe123',2);

INSERT INTO ORDER_LIST(OL_AMOUNT, OL_PRICE, OL_OR_NUM, OL_OP_NUM)
VALUES(2,30000,4,1),(2,60000,4,3);


-- 회원이 주문한 내역을  구매확정으로 바꾸면 포인트가 적립
DROP TRIGGER IF EXISTS INSERT_POINT;

DELIMITER //
CREATE TRIGGER INSERT_POINT AFTER UPDATE ON `ORDER`
FOR EACH ROW
BEGIN
	IF NEW.OR_STATE = '구매확정' THEN
		UPDATE MEMBER
        SET
			ME_POINT = ME_POINT + NEW.OR_SAVE_POINT
		WHERE
			ME_ID = NEW.OR_ME_ID;
    END IF;
END //
DELIMITER ;

UPDATE `ORDER` SET OR_STATE = '구매확정' WHERE OR_NUM =3;
UPDATE `ORDER` SET OR_STATE = '구매확정' WHERE OR_NUM =4;



