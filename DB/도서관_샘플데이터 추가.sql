-- 도서 상태 샘플 데이터를 추가
INSERT INTO BOOK_STATE (BS_DESC)
VALUES('예약 가능'),('예약 중'),('도서 상태에 의한 예약 불가능'),('대출 가능'),('대출 중'),('도서 상태에 의한 대출 불가능');

-- 도서 샘플 데이터 추가
-- 101.1ABC12 자바의 정석 남궁성 도우출판 , 일반도서(예약/대출 모두 가능)
-- 103.987DD Do it! 점프 투 파이썬 박응용 이지스퍼블리싱,특정도서(예약 불가능한 도서)
-- 500.abc123 v1 1 해리포터와 마법사의 돌 1 j.k. 롤링저자 / 강동혁 엮은이 문학수첩, 일반도서
INSERT INTO BOOK(BO_NUM, BO_TYPE, BO_NAME, BO_AUTHOR, BO_PUBLISHER, BO_POSSIBLE_LOAN, BO_POSSIBLE_RESERV) 
VALUES('101.1ABC12','코딩', '자바의 정석','저자 : 남궁성','도우출판',4,1 ),
('103.987DD','코딩', 'Do it! 점프 투 파이썬','저자 : 박응용', '이지스퍼블리싱', 4,3 ),
('500.abc123 v1 1','외국 소설', '해리포터와 마법사의 돌 1', '저자 : j.k.롤링 / 엮은이 : 강동혁','문학수첩',4,1);

INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_BIRTHDAY, ME_AUTHORITY)
VALUES ('ADMIN','ADMIN','011-1234-5678','2000-01-01','ADMIN'),
('QWE123','QWE123','010-1111-2222','2002-02-02','USER');

-- QWE123 회원이 자바의 정석을 예약했을 때
INSERT INTO RESERVATION(RE_DATE,RE_ME_ID,RE_BO_NUM)
SELECT DATE_FORMAT(NOW(),'%Y-%m%d'),'QWE123', BO_NUM FROM BOOK WHERE BO_NAME = '자바의 정석';

UPDATE BOOK
SET BO_POSSIBLE_RESERV = (
	SELECT BS_NUM FROM BOOK_STATE
	WHERE BS_DESC = '예약 중')
WHERE BO_NUM = '101.1ABC12';
-- 예약가능한 도서를 조회하는 쿼리



-- 대출 가능한 도서를 조회하는 쿼리 >> 예약이 되어있으면 대출을 못함
SELECT * FROM book
WHERE BO_POSSIBLE_LOAN = (
SELECT BS_NUM FROM BOOK_STATE
WHERE BS_DESC = '대출 가능' ) AND
BO_POSSIBLE_RESERV IN (
SELECT BS_NUM FROM BOOK_STATE
WHERE BS_DESC != '예약 중' );



-- QWE123 회원이 대출 가능한 도서를 조회 
SELECT * 
	FROM book
	LEFT JOIN RESERVATION ON RE_BO_NUM = BO_NUM
    WHERE 
		BO_POSSIBLE_LOAN = (
			SELECT BS_NUM
            FROM BOOK_STATE
            WHERE BS_DESC = '대출 가능')
		AND (RE_NUM IS NULL OR RE_ME_ID = 'QWE123');


-- QWE123 회원이 예약한 자바의 정석을 대출했을 때 적용해야하는 쿼리
INSERT INTO LOAN(LO_ME_ID, LO_BO_NUM, LO_DATE, LO_EXPECTED_DATE)
SELECT RE_ME_ID, RE_BO_NUM, DATE_FORMAT(NOW(),'%Y-%m-%d'), adddate(NOW(), interval 14 day)
FROM RESERVATION 
WHERE RE_ME_ID = 'QWE123'
AND RE_BO_NUM =(
SELECT BO_NUM
FROM BOOK
WHERE BO_NAME = '자바의 정석');

DELETE FROM RESERVATION WHERE RE_ME_ID = 'QWE123'
AND RE_BO_NUM =(
SELECT BO_NUM
FROM BOOK
WHERE BO_NAME = '자바의 정석');

UPDATE BOOK
SET BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출 중'),
BO_POSSIBLE_RESERV = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약 가능')
WHERE BO_NUM = '101.1ABC12';

-- 회원이 대출한 도서 수 증가
UPDATE MEMBER
SET ME_BOOK_COUNT = ME_BOOK_COUNT + 1
WHERE ME_ID = 'QWE123';


-- QWE123 회원이 현재 대출한 도서를 조회하는 쿼리
SELECT BO_NAME FROM LOAN
JOIN BOOK ON LO_BO_NUM = BO_NUM
WHERE LO_ME_ID = 'QWE123' AND LO_RETURN_DATE IS NULL;


-- QWE123회원이 자바의 정석을 반납했을 때 필요한 쿼리 
UPDATE LOAN
SET LO_RETURN_DATE = NOW()
WHERE LO_ME_ID = 'QWE123' AND LO_BO_NUM = (
	SELECT BO_NUM FROM BOOK WHERE BO_NAME = '자바의 정석');
    
UPDATE BOOK
SET BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출 가능')
WHERE BO_NUM = '101.1ABC12';

UPDATE MEMBER
SET ME_BOOK_COUNT = ME_BOOK_COUNT -1
WHERE ME_ID = 'QWE123';

-- 연체일 추가
UPDATE MEMBER 
SET ME_TOTAL_OVERDUE = ME_TOTAL_OVERDUE + (SELECT 
CASE 
	WHEN DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE) < 1 THEN
		0
	ELSE 
		DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE)
	END AS 연체일
FROM LOAN
WHERE LO_ME_ID = 'QWE123' AND LO_BO_NUM  ='101.1ABC12')
WHERE ME_ID = 'QWE123';




-- 연체일 계산 하는 쿼리 
SELECT 
CASE 
	WHEN DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE) < 1 THEN
		0
	ELSE 
		DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE)
	END AS 연체일
FROM LOAN;


-- 회원이 대출한 모든 도서가 반납됐을 때 연체일이 있으면 다음날부터 연체 적용이 되도록 수정
UPDATE MEMBER 
SET 
    ME_APPLY_OVERDUE = (SELECT 
            CASE
                    WHEN
                        ME_BOOK_COUNT = 0
                            AND ME_TOTAL_OVERDUE != 0
                    THEN
                        DATE_FORMAT(ADDDATE(NOW(),
                                    INTERVAL ME_TOTAL_OVERDUE DAY),
                                '%Y-%m-%d')
                    ELSE NULL
                END AS T
        FROM
            (SELECT * FROM MEMBER) AS TMP  -- 문법 상 오류 이슈로 서브쿼리로 사용하는 테이블을 새로운 이름으로 불러오는 방법
        WHERE
            ME_ID = 'QWE123')
WHERE
    ME_ID = 'QWE123';



-- 연체적용일 계산하는 쿼리 
SELECT 
	CASE 
		WHEN ME_BOOK_COUNT = 0 AND ME_TOTAL_OVERDUE != 0 THEN 
			DATE_FORMAT(ADDDATE(NOW(),INTERVAL ME_TOTAL_OVERDUE DAY), '%Y-%m-%d')
		ELSE NULL 
	END AS T
FROM
	MEMBER;


-- 각 회원들의 대출이 불가능한 기간을 조회하는 쿼리
-- 대출이 가능한 최원은 대출 가능으로 표시하고
-- 불가능한 회원은 언제까지인지를 표시하도록 
SELECT ME_ID, IFNULL(ME_APPLY_OVERDUE,'대출 가능') AS 기간
FROM MEMBER;


-- 각 도서별 대출 횟수를 조회하는 쿼리
SELECT BO_NAME, COUNT(LO_NUM) AS 대출횟수
FROM book
LEFT JOIN LOAN ON LO_BO_NUM = BO_NUM
GROUP BY BO_NUM;

-- 회원 별 연체 횟수
SELECT ME_ID, COUNT(LO_EXPECTED_DATE < LO_RETURN_DATE) AS 연체
FROM MEMBER
LEFT JOIN LOAN ON LO_ME_ID = ME_ID
GROUP BY ME_ID;


-- 도서를 가장 많이 대여한 회원을 조회하는 쿼리 
-- 대출 수가 같은 경우 아이디 순으로 정렬 후 첫번째 회원 선택
SELECT ME_ID, COUNT(LO_NUM)
FROM MEMBER
LEFT JOIN LOAN ON LO_ME_ID = ME_ID
GROUP BY ME_ID
ORDER BY COUNT(LO_NUM) DESC, ME_ID DESC
LIMIT 1;








