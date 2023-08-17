/*
이벤트 스케줄러 : 일정 주기마다 이벤트를 발생시켜서 등록된 이벤트를 실행하는 것 

CREATE EVENT 이벤트명 
ON SCHEDULE EVERY 숫자 단위 (하루 > 1 DAY ,, 한시간 > 1 HOUR )
[STARTS 시간] -- 언제부터 이벤트가 동작하게 할건지 설정
DO
	작업할 코드; -- 작업할 코드는 한줄로 된 INSERT / UPDATE / DELETE 나 프로시저 이용 
*/

-- 이벤트 스케쥴러의 ON/OFF 를 조회하는 쿼리
SHOW VARIABLES LIKE 'EVENT%';

-- 등록된 이벤트 스케줄러 조회
-- SHOW EVENTS;

USE TEST;

DROP EVENT IF EXISTS TEST_EVENT;

CREATE EVENT TEST_EVENT
ON SCHEDULE EVERY 1 MINUTE
DO 
	UPDATE DASH_BOARD SET DB_MEMBER = DB_MEMBER + 1 ;
	