/*
다음 학생 정보를 추가하는 쿼리를 작성해서 추가하세요.
학번: 2023160001 , 이름 : 홍길동, 전공 :컴퓨터 공학과
학번: 2023160002 , 이름 : 임꺽정, 전공 :컴퓨터 공학과
학번: 2023160003 , 이름 : 고길동, 전공 :컴퓨터 공학과
학번: 2023160004 , 이름 : 이하니, 전공 :컴퓨터 공학과
학번: 2023150001 , 이름 : 영심이, 전공 :방송학과
학번: 2023150002 , 이름 : 유재석, 전공 :방송학과
학번: 2023150003 , 이름 : 유하하, 전공 :방송학과
*/

insert into student 
values('2023160001','홍길동','컴퓨터공학과'),
('2023160002','임꺽정','컴퓨터공학과'),
('2023160003','고길동','컴퓨터공학과'),
('2023160004','이하니','컴퓨터공학과'),
('2023150001','영심이','방송학과'),
('2023150002','유재석','방송학과'),
('2023150003','유하하','방송학과');


/*
다음 과목 정보를 추가하는 쿼리를 작성하고 실행하세요.
코드 : MSC001 , 학점 3 시수 4, 대학수학기초
*/
insert into subject
values('MSC001','대학수학기초',3,4),
('MSC002','대학물리',3,3),
('BSE001','영어',2,3),
('BSE002','글쓰기',2,3),
('COM001','컴퓨터개론',3,4),
('MED001','미디어개론',3,4);


insert into course(num, subject_code, student_num, schedule, year, semester) 
values(1,'MSC001','2023160001','월1,2,수1,2',2023,'1'),
(2,'MSC001','2023160002','월1,2,수1,2',2023,'1'),
(3,'MSC001','2023160003','월1,2,수1,2',2023,'1'),
(4,'MSC001','2023160004','월1,2,수1,2',2023,'1');
/*
상단의 쿼리를 다음과 같이 요약하여 작성할 수 있음
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester) 
select 'MSC001', num, '미정', '미정','월1,2,수1,2',2023,'1' from student where major = '컴퓨터공학과';
*/



insert into course values(5,'MSC002','2023160001','361','이순신','월3,4,5',2023,'1'),
(6,'MSC002','2023160002','361','이순신','월3,4,5',2023,'1');



insert into course values(7,'BSE001','2023160001','본관 101호','김영철','화1,2,3',2023,'1'),
(8,'BSE001','2023160002','본관 101호','김영철','화1,2,3',2023,'1'),
(9,'BSE001','2023160003','본관 101호','김영철','화1,2,3',2023,'1'),
(10,'BSE001','2023160004','본관 101호','김영철','화1,2,3',2023,'1'),
(11,'BSE001','2023150001','본관 101호','김영철','화1,2,3',2023,'1'),
(12,'BSE001','2023150002','본관 101호','김영철','화1,2,3',2023,'1'),
(13,'BSE001','2023150003','본관 101호','김영철','화1,2,3',2023,'1');
/*
상단의 쿼리를 다음과 같이 요약하여 작성할 수 있음
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester) 
select 'BSE001', num, '본관 101호','김영철','화1,2,3',2023,'1' from student;
*/


insert into course values(14,'BSE002','2023150002','미디어관 201호','한석봉','화1,2,3',2023,'1');

/*
모든 컴퓨터공학과 학생이 컴퓨터개론을 수강
*/
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester) 
select 'COM001', num, '컴퓨터관 301호','이수지','목2,3,4',2023,'1' from student where major = '컴퓨터공학과';


/*
모든 방송학과 학생이 미디어 개론을 수강
*/
insert into course(subject_code, student_num, room, professor_name, schedule, year, semester) 
select 'MED001', num, '미디어관 101호','김영철','목3,4',2023,'1' from student where major = '방송학과';












