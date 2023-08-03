-- 유재석 학생이 수강하는 수강정보를 조회하는 쿼리
SELECT 
    *
FROM
    course
WHERE
    student_num = 
    (SELECT 
            num
        FROM
            student
        WHERE
            name = '유재석');
            
            
-- 영어를 수강하는 컴공과 학생들의 수강정보를 조회하는 쿼리
SELECT 
    *
FROM
    course
WHERE
    subject_code IN 
    (SELECT 
            code
        FROM
            subject
        WHERE
            title = '영어')
        AND student_num IN 
        (SELECT 
            num
        FROM
            student
        WHERE
            major = '컴퓨터공학과');
            
            

-- 수강생이 3명 이상인 과목의 과목 코드를 조회
 select subject_code from course group by subject_code having count(*)>2;