USE SHOPPINGMALL;

-- 회원 아이디가 abc123, 비번이 1234, 번호가 011-1234-5678 
-- 주소 '서울시 강남구 KH빌딩' 상세주소 '6층 361반', 우편번호 01234 인 회원이 가입을 했을 때 쿼리 작성
-- 권한 admin, user 중 하나
insert into member 
values('abc123','1234','01112345678','서울시 강남구 KH빌딩','6층 361반','01234',0,'user','홍길동');

insert into member 
values('qwe123','qwe1234','01112122121','서울시 강남구 KH빌딩','1층 111반','01235',0,'user','김철수');

insert into member 
values('admin','admin','01111112222','서울시 강북구 KH빌딩','3층 101호','01231',0,'admin','임꺽정');

-- 제품코드가 ABC001, 제품명 KH무선마우스, 제품설명 'KH무선마우스입니다.', 가격 15000원
-- 종류 '무선 / 유선' 제품 등록 쿼리
INSERT INTO PRODUCT VALUES('ABC001','KH무선마우스','KH무선마우스입니다.',15000);

-- option 은 mysql 키워드라서 역따옴표가 필수로 들어가야함.
insert into `option`(OP_NAME, OP_PR_CODE) VALUES('무선','ABC001');
INSERT INTO `option`(OP_NAME,OP_PR_CODE) VALUES('유선','ABC001');

-- 제품코드가 ABC001인 제품의 제품정보와 옵션을 조회하는 쿼리
select product.*, `option`.op_name as 옵션
from `option`
join product on op_pr_code = pr_code
where pr_code = 'ABC001';


-- 제품코드가 ABC001인 제품 중에서 유선 제품이 10개 들어오고, 무선 제품이 5개 들어왔을 때의 쿼리
UPDATE `OPTION` 
SET op_amount = 10
WHERE op_pr_code = 'ABC001' AND op_name = '유선';

UPDATE `OPTION` 
SET op_amount = 5
WHERE op_pr_code = 'ABC001' AND op_name = '무선';


-- abc123 회원이 배송지를 다음과 같이 등록 ( 배송지명 : '집', 주소 : '서울시 강남구 123번지'
-- 상세 :'KH아파트 101동 101호' , 우편번호:'12345) 하는 쿼리
insert into address(ad_name, ad_addr, ad_addr_detail, ad_post, ad_me_id)
values('집','서울시 강남구 123번지','KH아파트 101동 101호','12345','abc123');


-- abc123 회원이 ABC001 제품 중 유선 3개를 장바구니에 담았을 때 쿼리
insert INTO CART(ca_amount, ca_op_num,ca_me_id)
values(3,2,'abc123');

-- num을 검색해서 넣는 쿼리
insert INTO CART(ca_amount, ca_me_id, ca_op_num)
select 3,'abc123', op_num
from `option` 
where op_pr_code = 'ABC001' AND OP_NAME='유선';

-- 위의 상황에서 abc123 회원이 ABC001 제품 중 유선 1개를 장바구니에 담았을 때 쿼리
update cart
set ca_amount = 1
where ca_op_num = (select op_num
from `option` 
where op_pr_code = 'ABC001' AND OP_NAME='유선');

-- abc123회원이 abc001 제품 중 무선2개를 구매하고 배송지로 집을 선택햇을때
-- (order 테이블 - total : 총 금액, price : 결제금액)
-- 1. 주문 내역을 추가 >> 주문 리스트에서 주문 내역 번호가 필요하기 때문 (영수증으로 생각)
insert into `order`(or_total, or_price, or_use_point, or_save_point, or_me_id, or_ad_num)
values(15000*2, 15000*2, 0, 3000, 'abc123',1);

-- 2. 주문 리스트에 구매 목록을 추가
insert into `order_list`(ol_amount, ol_price, ol_or_num, ol_op_num)
values(2,15000*2,1,1);

-- 3. 제품 수량을 수정
update `option` set op_amount = op_amount -2 where op_num=1;
-- 4. 포인트 적립
-- 4-1. 포인트 내역 추가
insert into point(po_content, po_amount, po_me_id) 
values('제품 구매에 의한 적립', 3000, 'abc123');
-- 4-2. 회원 정보에 포인트 수정
UPDATE member 
SET 
    me_point = me_point + 3000
WHERE
    me_id = 'abc123';


-- 제품코드가 ABC002, 제품명이 KH키보드, 제품상세가 혁신적인 KH키보드, 제품가격 30000원
-- 제품 종류 '기계식','일반'인 제품을 등록
INSERT INTO PRODUCT VALUES('ABC002','KH키보드','혁신적인 KH키보드',30000);
INSERT INTO `OPTION` (OP_NAME, OP_PR_CODE) 
VALUES('기계식','ABC002');
INSERT INTO `OPTION` (OP_NAME, OP_PR_CODE) 
VALUES('일반','ABC002');
 
 
 
 -- 제품코드가 ABC002, 종류가 기계식인 제품이 100개
 --  제품코드가 ABC002, 종류가 일반인 제품이 50개 입고 되었을 때 쿼리
 UPDATE `OPTION` 
SET 
    OP_AMOUNT = OP_AMOUNT + 100
WHERE
    OP_NAME = '기계식'
        AND OP_PR_CODE = 'ABC002';
 
 UPDATE `OPTION` 
SET 
    OP_AMOUNT = OP_AMOUNT + 50
WHERE
    OP_NAME = '일반' AND OP_PR_CODE = 'ABC002';


-- qwe123 회원이 ABC001 제품 중 무선을 2개 장바구니에 담고, 
-- 이어서 ABC002 제품 중 기계식을 3개 장바구니에 담았을 때 쿼리
INSERT INTO CART(CA_AMOUNT, CA_ME_ID, CA_OP_NUM)
SELECT 2,'qwe123',OP_NUM
FROM `OPTION`
WHERE OP_NAME = '무선' AND OP_PR_CODE = 'ABC001';

INSERT INTO CART(CA_AMOUNT, CA_ME_ID, CA_OP_NUM)
SELECT 2,'qwe123',OP_NUM
FROM `OPTION`
WHERE OP_NAME = '기계식' AND OP_PR_CODE = 'ABC002';


-- qwe123 회원이 장바구니에 담긴 모든 제품을 구매했을 때 (구매시 포인트 사용은 x)
insert into address(ad_name, ad_addr, ad_addr_detail, ad_post, ad_me_id)
select '직장', me_addr, me_addr_detail, me_post, me_id
from `member`
where me_id = 'qwe123';

insert into `order`(or_num, or_total, or_price, or_use_point, or_save_point, or_me_id, or_ad_num)
values(2, 15000*2 + 30000*2, 15000*2 + 30000*2, 0, (15000*2 + 30000*2)*0.1, 'qwe123',2);

-- 2. 주문 리스트에 구매 목록을 추가
insert into `order_list`(ol_amount, ol_price, ol_or_num, ol_op_num)
values(2,15000*2,2,1);
	-- 찾아서 입력하기
	insert into `order_list`(ol_amount, ol_price, ol_or_num, ol_op_num)
	select 2, pr_price*2, 2, op_num
	from `option`
	join product
	on op_pr_code = pr_code
	where op_pr_code = 'ABC001' AND OP_NAME = '무선';

insert into `order_list`(ol_amount, ol_price, ol_or_num, ol_op_num)
values(2,30000*2,2,3);

-- 3. 제품 수량을 수정
update `option` set op_amount = op_amount -2 where op_num=1;
update `option` set op_amount = op_amount -2 where op_num=3;

-- 4. 포인트 적립
-- 4-1. 포인트 내역 추가
insert into point(po_content, po_amount, po_me_id) 
values('제품 구매에 의한 적립', 9000, 'qwe123');
-- 4-2. 회원 정보에 포인트 수정
UPDATE member 
SET 
    me_point = me_point + 9000
WHERE
    me_id = 'qwe123';


-- qwe123 회원이 구매(환불, 반품을 제외한)한 제품명과 옵션명 목록을 확인하는 쿼리
SELECT PR_NAME AS 제품명, OP_NAME AS 옵션명
FROM PRODUCT
JOIN `OPTION` ON PR_CODE = OP_PR_CODE
WHERE op_num 
in(SELECT ol_op_num
FROM `ORDER` 
JOIN ORDER_LIST ON OL_OR_NUM = OR_NUM
WHERE OR_STATE NOT IN('환불','반품') and or_me_id='qwe123');


SELECT OR_ME_ID AS 주문아이디,
		PR_NAME AS 제품명,
		OP_NAME AS 옵션명,
		PR_PRICE AS 제품가격,
		OL_AMOUNT AS 구매수량
FROM `ORDER` 
JOIN ORDER_LIST ON OL_OR_NUM = OR_NUM
JOIN `OPTION` ON OL_OP_NUM = OP_NUM
JOIN PRODUCT ON OP_PR_CODE = PR_CODE
WHERE OR_STATE NOT IN('환불','반품') and OR_ME_ID='qwe123';


-- abc123 회원이 장바구니에 담은 제품명과 옵션명, 수량을 확인하는 쿼리
SELECT CA_ME_ID AS 구매자명,
PR_NAME AS 제품명,
OP_NAME AS 옵션명,
CA_AMOUNT AS 수량
FROM CART 
JOIN `OPTION` ON CA_OP_NUM = OP_NUM
JOIN PRODUCT ON OP_PR_CODE = PR_CODE
WHERE CA_ME_ID = 'abc123';


-- abc123 회원이 등록한 배송지 정보를 조회하는 쿼리
SELECT 
    *
FROM
    ADDRESS
WHERE
    AD_ME_ID = 'abc123';
    
    
-- 등록된 모든 제품 검색
SELECT 
    *
FROM
    PRODUCT
        JOIN
    `OPTION` ON PR_CODE = OP_PR_CODE;
    

-- KH가 제품명에 포함된 제품들을 검색하는 쿼리
SELECT * FROM PRODUCT WHERE PR_NAME LIKE CONCAT('%','KH','%');

-- KH가 제품명에 포함된 제품들 중에서 1페이지에 해당하는 제품들을 검색하는 쿼리 (페이지 당 제품 5개
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_NAME LIKE CONCAT('%', 'KH', '%')
LIMIT 5,5;


-- abc123 회원이 제품을 받고 구매 확정을 눌렀을 때 쿼리
UPDATE `ORDER` SET OR_STATE = '확정' WHERE OR_ME_ID = 'abc123';

-- abc123 회원이 구매 확정한 ABC001 제품 중 무선인 제품에 '좋은 마우스 입니다' 라고
-- 리뷰를 등록했을 때 쿼리
INSERT INTO `REVIEW`(RV_CONTENT,RV_THUMB, OP_NUM, ME_ID) 
VALUES('좋은 마우스 입니다',NULL,1,'abc123');

-- abc123 회원이 작성한 리뷰가 있는 제품명 조회
SELECT me_id AS 구매자명, PR_NAME AS '구매한 제품' 
FROM REVIEW 
JOIN `OPTION` ON `OPTION`.OP_NUM = review.OP_NUM
JOIN PRODUCT ON OP_PR_CODE = PR_CODE
WHERE me_id = 'abc123';

-- 제품 코드가 ABC001이고, 옵션명이 무선인 제품에 달린 리뷰를 조회
SELECT RV_CONTENT AS 리뷰내용 FROM `REVIEW` 
JOIN `OPTION` 
ON `OPTION`.OP_NUM = review.OP_NUM
WHERE OP_NAME = '무선' AND OP_PR_CODE = 'ABC001';

-- 제품명이 KH무선 마우스인 제품의 리뷰 개수를 조회하는 쿼리
SELECT PR_NAME AS 제품명, COUNT(*) AS 리뷰갯수 FROM `REVIEW` 
JOIN `OPTION` 
ON `OPTION`.OP_NUM = review.OP_NUM
JOIN PRODUCT
ON OP_PR_CODE = PR_CODE
WHERE PR_NAME = 'KH무선마우스';


-- 제품별 리뷰개수
SELECT OP_PR_CODE AS 제품코드, COUNT(*) AS 리뷰갯수
 FROM `REVIEW` 
JOIN `OPTION` 
ON `OPTION`.OP_NUM = RV_OP_NUM
GROUP BY OP_PR_CODE;

-- 제품별 옵션의 개수 조회하는 쿼리
SELECT PR_NAME AS 제품명 ,COUNT(OP_NUM) AS 옵션개수
FROM `OPTION`
JOIN PRODUCT ON PR_CODE = OP_PR_CODE
GROUP BY PR_CODE;


-- 제품별 판매량(반품, 환불을 제외한)을 조회하는 쿼리
SELECT PR_NAME AS 제품명, SUM(OL_AMOUNT) AS 판매량
FROM PRODUCT
JOIN `OPTION` ON OP_PR_CODE = PR_CODE
LEFT JOIN ORDER_LIST ON OL_OP_NUM = OP_NUM
LEFT JOIN `ORDER` ON OR_NUM = OL_OR_NUM
WHERE OR_STATE IS NULL OR OR_STATE NOT IN('반품','환불')
GROUP BY PR_CODE;


-- 제품 옵션별 판매량
SELECT PR_NAME AS 제품명, OP_NAME AS 옵션명, IFNULL(SUM(OL_AMOUNT),0) AS 판매량
FROM PRODUCT
JOIN `OPTION` ON OP_PR_CODE = PR_CODE
LEFT JOIN ORDER_LIST ON OL_OP_NUM = OP_NUM
LEFT JOIN `ORDER` ON OR_NUM = OL_OR_NUM
WHERE OR_STATE IS NULL OR OR_STATE NOT IN('반품','환불')
GROUP BY OP_NUM;


-- 제품별 판매금액
SELECT PR_NAME AS 제품명, OP_NAME AS 옵션명, PR_PRICE * IFNULL(SUM(OL_AMOUNT),0) AS 판매금액
FROM PRODUCT
JOIN `OPTION` ON OP_PR_CODE = PR_CODE
LEFT JOIN ORDER_LIST ON OL_OP_NUM = OP_NUM
LEFT JOIN `ORDER` ON OR_NUM = OL_OR_NUM
WHERE OR_STATE IS NULL OR OR_STATE NOT IN('반품','환불')
GROUP BY OP_NUM;


-- 옵션별 리뷰수 (제품별, 옵션명, 리뷰수)
SELECT PR_NAME AS 제품명, OP_NAME AS 옵션명, IFNULL(COUNT(RV_NUM),0) AS 리뷰수 
FROM `OPTION`
LEFT JOIN REVIEW ON RV_OP_NUM = OP_NUM
JOIN PRODUCT ON OP_PR_CODE = PR_CODE -- NULL 요소가 있는 테이블을 JOIN 시킬때에는 OUTER. 없으면 후에 INNER JOIN 이 들어가도 됨.
GROUP BY OP_NUM;















