/*
create table 테이블명(
	속성명 타입,...., 속성명 타입
);

-- 기존 테이블을 잉요하여 새 테이블 생성
create table 테이블명 (select 테이블에 추갇할 속성을 form 테이블ㅁ여);
*/

create table if not exists course_abstract(select num, subject_code, student_num from course);