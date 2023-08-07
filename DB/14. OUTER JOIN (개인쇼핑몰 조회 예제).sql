/*
INNER JOIN : 두 테이블이 외래키로 연결 되었을 때, 양쪽 다 데이터가 있는 경우
OUTER JOIN : 두 테이블이 외래키로 연결되었을 때, 한 테이블을 기준으로 연결할 때 사용 

- 상품별 리뷰 수를 조회하는 경우, 리뷰가 등록이 안된 상품들은 INNER JOIN을 이용하여 리뷰수를 알수 없음

- OUTER JOIN 문법 : 기준 테이블이 매우 중요.
 INNER JOIN은 기준 테이블이 바껴도 결과가 같지만 
 OUTER JOINDMS A B의 위치가 바뀌면 결과도 바뀜
 - 종류 : LEFT, RIGHT
 - LEFT JOIN : 기준 테이블을 기준으로 연결
 - RIGHT JOIN :  참조 테이블을 기준으로 연결
 
 A LEFT JOIN B == B RIGHT JOIN A
 
 SELECT * FROM 기준테이블
 JOIN 참조테이블
 ON 기준테이블.외래키 = 참조테이블.기본키
 [...];
*/

-- 제품 별 리뷰개수 조회하는 쿼리
SELECT OP_PR_CODE AS 제품코드, COUNT(RV_NUM) AS 리뷰갯수
 FROM `REVIEW` 
RIGHT JOIN `OPTION` 
ON `OPTION`.OP_NUM = RV_OP_NUM
GROUP BY OP_PR_CODE;


