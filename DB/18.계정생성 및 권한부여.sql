/*
 계정 생성 방법 : 권한이 있는 계정만 다른 계정을 생성할 수 있다. 
 create user '아이디'@'접근방법'identified by '비번';
 - 접근 방법 : localhost 와 %
	- localhost : 내부 IP 에서만 접근 가능하도록 설정
    - % : 외부 IP에서도 접근 가능하도록 설정 
 */
 
 create user 'test'@'localhost' identified  by '1234';
  create user 'test1'@'localhost' identified  by '1234';
 
 /*
 권한부여 : 계정에 DB 및 테이블에 접근할 수 있는 권한을 설정 
 - 어떤 DB에 접근할 수 있게 할 것이지
 - 어떤 테이블에 접글할 수 ...
 - 어떤 작업을 수행(insert, update, delete, select) 할 수 ...
 
 모든작업을 수행할 수 잇는 권한을 부여하는 방법
 GRANT ALL PRIVILEGES ON DB명.테이블명 TO '아이디'@'접근방법'; 
 */
grant all privileges on test.* to 'test'@'localhost';
grant insert on test.* to 'test1'@'localhost';
grant select on test.* to 'test1'@'localhost';
grant delete on test.* to 'test1'@'localhost';


SELECT EMP_NAME, EMP_NO, DEPT_CODE, SALARY

FROM EMPLOYEE

WHERE DEPT_CODE='D9' OR DEPT_CODE='D6' AND SALARY > 3000000 -- 300 만원 이상 , 코드 in

AND EMAIL LIKE '____%' AND BONUS IS NULL; -- 성별 남성 , 보너스가 있고 , 이메일 주소











