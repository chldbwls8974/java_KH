/*
프로시저
- 일련의 쿼리를 마치 하나의 함수처럼 실행하기 위한 쿼리의 집합 
- 예시
	- 대학생 학번을 생성하기 위한 프로시저 : 입학년도, 학과번호를 이용하여 학번을 생성할 수 있다.alter

			 함수 			프로시저
매개변수	   여러개(입력)		여러개(입력|출력|입출력)
리턴값	   1개, 필수	 		여러개, 선택
SELECT문 	사용가능			사용불가능 
처리장소	   클라이언트			  서버

- 정의
	DELIMITER // -- 문자의 끝을 // 로 인식하게 해줌
	CREATE PROCEDURE 프로시저명 (
    [	(IN | OUT | INOUT) 매개변수명 타입 
    
    ]
    )
    BEGIN
		-- 프로시저 코드 구현 
        -- 변수 선언
        DECLARE 변수명 타입;
        DECLARE 변수명 타입 DEFAULT 초기값;
        -- 변수에 값을 수정
        SET 변수명 = 값;
        -- 조건문 : CASE WHEN
        CASE 
			WHEN 조건식1 THEN
            실행문1;
            WHEN 조건식2 THEN
            실행문2;
            ELSE
				실행문3;
		END;
        -- 조건문 : IF
        IF 조검식 THEN
			실행문1
		ELSE
			실행문2
		END IF; 
    END //
    DELIMITER ;
    
프로시저 호출
CALL 프로시저명(매개변수들);
*/
-- DROP PROCEDURE IF EXISTS RESERVATION_MOVIE;
-- 영화를 예매하는 프로시저
DELIMITER //
CREATE PROCEDURE RESERVATION_MOVIE(
	-- 스케쥴 번호 
    IN _SD_NUM INT,
    -- 예약 아이디명
    IN _ID VARCHAR(15),
    -- 성인 수 
    IN _ADULT_COUNT INT,
    -- 청소년 수
    IN _CHILD_COUNT INT,
    -- 좌석명
    IN _SEAT_LIST TEXT
)
BEGIN
-- 프로시저 변수는 무조건 최상단에서 선언

	DECLARE _ADULT_TOTAL_PRICE INT DEFAULT 0;
	DECLARE _CHILD_TOTAL_PRICE INT DEFAULT 0;
	DECLARE _TOTAL_PRICE INT DEFAULT 0;
	DECLARE  _IS_DISCOUNT CHAR(1);
    DECLARE _SE_NUM INT;
    DECLARE _PR_NUM INT;
    DECLARE _RV_NUM VARCHAR(20);
    DECLARE DONE INT DEFAULT 0;
    DECLARE SEAT_NAME VARCHAR(4);

    -- 좌석 리스트를 CURSOR로 선언
    DECLARE CUR CURSOR FOR
		SELECT *
        FROM JSON_TABLE(_SEAT_LIST, '$[*]'
			COLUMNS(SEAT_NAME VARCHAR(4) PATH '$.SEAT_NAME')
            ) AS A;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1;
    
    -- 예약번호 생성 형태: 202308090604MS008001
    SET _RV_NUM = CONCAT(
				DATE_FORMAT(NOW(), '%Y%m%d%H%i'),
				'MS',
				LPAD(_SD_NUM,3,0),
				LPAD((SELECT COUNT(*)+1 FROM RESERVATION WHERE RV_SD_NUM = SD_NUM),3,0)
				);
    
	-- 예약 테이블에 정보를 추가
	-- 조조할인 적용 여부 _IS_DISCOUNT 에 저장
	SET _IS_DISCOUNT = (SELECT SD_DC FROM SCHEDULE WHERE SD_NUM = _SD_NUM);
	-- 조조 할인 여부에 따라 성인 전체 요금과 아동 전체요금 계산
	IF _IS_DISCOUNT = 'Y' THEN
		SET _ADULT_TOTAL_PRICE 
		= (SELECT PR_DC_PRICE FROM PRICE WHERE PR_TYPE = '성인')*_ADULT_COUNT;
		SET _CHILD_TOTAL_PRICE 
		= (SELECT PR_DC_PRICE FROM PRICE WHERE PR_TYPE = '아동')*_CHILD_COUNT;
	ELSE 
		SET _ADULT_TOTAL_PRICE 
		= (SELECT PR_PRICE FROM PRICE WHERE PR_TYPE = '성인')*_ADULT_COUNT;
		SET _CHILD_TOTAL_PRICE 
		= (SELECT PR_PRICE FROM PRICE WHERE PR_TYPE = '아동')*_CHILD_COUNT;
	END IF;

	-- 전체 요금 계산
	SET _TOTAL_PRICE= _ADULT_TOTAL_PRICE + _CHILD_TOTAL_PRICE;
		
    -- 예약 정보를 테이블에 추가
   INSERT INTO RESERVATION(RV_SD_NUM, RV_ME_ID, RV_ADULT, RV_CHILD,RV_PRICE)
   VALUES(_SD_NUM, _ID ,_ADULT_COUNT, _CHILD_COUNT, _TOTAL_PRICE);
   
    -- 예약 리스트에 좌석 정보를 추가
    -- CURSOR를 열음 
    OPEN CUR;
    READ_LOOP:LOOP
		FETCH CUR INTO SEAT_NAME; -- 커서에서 꺼내서 SE_NAME으로 가져옴
        
		-- 반복을 멈추는 작업
        IF DONE THEN
			LEAVE READ_LOOP;
        END IF;
        
        -- 좌석정보를 이용하여 예약 리스트에 추가하는 작업 
        -- 영화 스케줄과 좌석이름을 이용하여 좌석 번호를 가져옴
        SET _SE_NUM =(
			SELECT SE_NUM FROM SEAT 
			JOIN SCREEN ON SE_SC_NUM = SC_NUM
			JOIN SCHEDULE ON SD_SC_NUM = SC_NUM
			WHERE SD_NUM = _SD_NUM AND SE_NAME = SEAT_NAME
		);
        IF _ADULT_COUNT != 0 THEN
			SET _PR_NUM = (SELECT PR_NUM FROM PRICE WHERE PR_TYPE = '성인');
            SET _ADULT_COUNT = _ADULT_COUNT - 1;
		ELSE 
			SET _PR_NUM = (SELECT PR_NUM FROM PRICE WHERE PR_TYPE = '청소년');
            SET _CHILD_COUNT = _CHILD_COUNT - 1;
		END IF;
        
        INSERT INTO RESERVATION_LIST(RL_RV_NUM, RL_SE_NUM, RL_PR_NUM)
        VALUES(_RV_NUM, _SE_NUM, _PR_NUM);
	END LOOP;
    CLOSE CUR;
        
    -- 영화 스ㅔ줄에 예약 가능 좟거을 업대이트alter
    
    -- 모든 영화 에매율 업데이트
    
 END //
 DELIMITER ; 
 
 
/* Json형태
{
	"속성명" : 값
}
*/
CALL RESERVATION_MOVIE(1,'admin',1,1,'[{"SEAT_NAME" : "A1"},{"SEAT_NAME" : "A2"}]');















