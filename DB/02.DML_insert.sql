/*
DML : 데이터를 추가 / 수정 / 삭제 / 조회할 때 사용
CRUD 
insert : 데이터를 추가 

insert 방법 1: insert ... values: 추가할 데이터를 다 알고 있는 경우


-- 테이블명만 입력하는 경우 : 속성 순서에 맞춰서 값들을 넣어줘야 함 
insert into 테이블명 values(값1, 값2...);
insert into 테이블명 values(값1, 값2... ),(값1, 값2...);
-- 테이블명 옆에 속성을 작성하는 경우 작성한 속성 순서에 맡게 값을 지정
-- 조건부로 일부 속성 생략가능
1. null 허용
2. not null이면서 default가 설정된 속성 
insert into 테이블명(속성1, 속성2,...) values(값1, 값2);
*/

-- 학번이 2023160001인 컴퓨터공학과 홍길동 학생을 추가하는 쿼리 
insert into student values('2023160001','홍길동','컴퓨터공학과');
-- student 테이블에 있는 속성 순서에 맞지 않게 데이터를 잘못 추가하는 경우
insert into student values('홍길동','2023160001','컴퓨터공학과');
-- 학번이 2023160002인 컴퓨터공학과 임꺽정 을 추가
insert into student(major, name, num) values('컴퓨터공학과','임꺽정','2023160002');
-- 과목코드가 MSC001이고, 과목명이 대학수학기초인 과목을 추가하는 쿼리 작성
insert into subject(code,title) values('MSC001','대학수학기초');

/*
insert 방법 2: insert ... select: 데이터 일부를 검색해서 추가해야 하는 경우
insert into 테이블명(속성명1, ...,);
	select 속성1, ...속성n from 테이블명
    [where 조건]

*/
-- 과목코드가 MSC002이고 과목명이 영어I 학점2학점 시수가 3시간인 과목을 추가하는 쿼리 작성
insert into subject values('MSC002','영어I','2','3');














