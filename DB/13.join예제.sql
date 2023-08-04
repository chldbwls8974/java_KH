/*
[join 문법]
-- 테이블1의 외래키가 테이블2의 기본키를 참조하는 경우 
-- join은 일반적으로 외래키와 기본키를 연결하지만, 상황에 따라서는 외래키가 아닌 속성을 기본키와 연결할 수 있음
select 테이블1.속성명1,테이블1.속성명2...,테이블2.속성명1..
from  테이블1
join 테이블2
on 테이블1.외래키 = 테이블2.기본
[where 검색조건]
[group by]
[having]
[order by]
[limit]
*/
SELECT 
    course.num
FROM
    course
        JOIN
    subject ON course.subject_code = subject.code;

-- 대학물리를 수강하는 학생들 수를 조회하는 쿼리
select subject_code, count(*) as 학생수
from course
join subject on subject_code = code
where title='대학물리';

-- 유재석 학생이 수강하는 과목의 수를 조회
select student_num as 학생코드, count(*) as 과목수
from course
join student on course.student_num = student.num
where name='유재석'
group by student_num;


-- 유재석이 수강하는 과목묭을 조회하는 쿼리
SELECT 
    title AS 과목명
FROM
    course
        JOIN
    student ON course.student_num = student.num
        JOIN
    subject ON subject_code = code
WHERE
    name = '유재석';


-- 이순신 교수님이 강의하는 과목명 조회
SELECT distinct
    title
FROM
    course
        JOIN
    subject ON subject_code = code
WHERE
    professor_name = '이순신';




