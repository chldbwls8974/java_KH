/*
select 문 기본
select 속성명,...,속성명
from 테이블명;
=> 테이블에서 속성명들의 값들을 조회 
=> 전체를 조회 하려면 속성에 *를 넣어주면 됨
*/
use course;

-- 등록된 모든 학생의 모든 정보를 조회하는 쿼리 
select *
from student;

-- 등록된 모든 학생의 학번을 조회하는 쿼리
select num as '학번' from student;

/*
where 조건문에서...
~가 아닌 : <> , !=
like : 와일드 카드와 함게 사용
[와일드카드]
- _ : 한글자를 의미하는 와일드카드
- % : 0글자 이상을 의미
*/

-- 컴퓨터공학과 학생들을 조회하는 쿼리
SELECT 
    *
FROM
    student
WHERE
    major = '컴퓨터공학과';

-- 학점이 3학점인 과목의 과목명을 조회하는 쿼리
SELECT 
    title AS '과목명'
FROM
    subject
WHERE
    time = 3;


-- 이름이 3자인 학생 정보를 조회하는 쿼리
SELECT 
    *
FROM
    student
WHERE
    name LIKE '___';


-- 성이 유씨인 학생 정보
SELECT 
    *
FROM
    student
WHERE
    name LIKE '유%';


-- 학생의 학번은 입학년도 4자 + 학과코드 3자 + 반호3자
-- 23학번 학생을 조회하는 쿼리
SELECT 
    *
FROM
    student
WHERE
    num LIKE '2023%';


-- 방송학과 코드는 150, 방송학과 조회
SELECT 
    *
FROM
    student
WHERE
    num LIKE '____150%';


-- 학점이 2학점 이상 3학점 이하인 과목 조회
SELECT 
    *
FROM
    subject
WHERE
    point BETWEEN 2 AND 3;
    


-- 이순신 교수님과 한석봉 교수님이 강의하는 수강정보를 조회하는 쿼리
select * from course where professor_name in('이순신','한석봉');


/*
select distinct 속성명 from 테이블명
*/
-- 2023년에 수강하는 과목들의 과목코드를 조회하는 쿼리
SELECT DISTINCT
    subject_code AS '과목코드'
FROM
    course
WHERE
    year = 2023;

-- 과목명이 글쓰기인 과목의 수강정보 조회
SELECT 
    *
FROM
    course
WHERE
    subject_code = 
    (SELECT 
            code
        FROM
            subject
        WHERE
            title = '글쓰기');


/*
where 속성명 any(서브쿼리);
=> 속성이 서브쿼리 결과 중 하나라도 만족하면 조회
*/
-- 학점이 2학점 또는 3학점 이상인 과목의 수강 정보 조회
SELECT 
    *
FROM
    course
WHERE
    subject_code = ANY (SELECT 
            code
        FROM
            subject
        WHERE
            point IN (2 , 3));


-- 글쓰기와 영어가 아닌 모든 과목의 수강 정보를 조회
select * from course where subject_code != all(select code from subject where title in('글쓰기','영어'));
select * from course where subject_code in (select code from subject where title != '글쓰기' && title != '영어');



/*
ORDER BY : 정렬
- ASC : 오름차순
- DESC : 

위치는 where /  group by 절 뒤
order by 속성명 정렬방법;
*/
-- 학생 정보를 전공, 이름 순으로 
select * from student order by major asc, name asc;


-- 학생들이 소속된 과를 조회
select distinct major from student;


/*
LIMIT : 행(튜플)을 원하는 위치부터 원하는 개수를 가져옴
- 위치가 order by절 뒤
limit A;
=> 0번지부터 A개 가져옴
limit A, B;
=> A번지 부터 B개 가져옴 
*/

-- 학생 정보를 학번 순으로 오름차순 정렬 후 위에서 2명
select * from student order by num asc limit 2;

-- 학생 정보를 학번 순으로 오름차순 정렬 후 3,4번째 조회
select * from student limit 2, 2;

-- 학생 정보를 학번 순으로 오름차순 정렬 후, 2명씩 보여줄 때 3번째 페이지에 있는 학생 정보를 조회
select * from student limit 4, 2;


/*
group by : 같은 값을 가지는 행들을 묶어서 평균을 내거나 개수를 세는 등의 작업을 할 때 사용
having :  집계함수의 조건 
[집계함수]
sum()
count
avg()
mean()
max()
*/
-- mysql에서 groupby를 쓰고 싶을 때 써주는 쿼리
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- 각 과별 학생 수 조회
select major as 학과, count(num) as 학생수 from student group by major;
-- 과목별 수강 학생수를 과목 코드, 수강생수로 조회하는 쿼리
select subject_code as 과목코드, count(num) as 학생수 from course group by subject_code;
-- 과목별 수강 학생수가 4명 이상인 과목의  과목 코드, 수강생수로 조회하는 쿼리
select subject_code as 과목코드, count(num) as 학생수 from course group by subject_code having count(num) >3;







