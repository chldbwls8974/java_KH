USE SHOPPINGMALL;

-- 회원 아이디가 abc123, 비번이 1234, 번호가 011-1234-5678 
-- 주소 '서울시 강남구 KH빌딩' 상세주소 '6층 361반', 우편번호 01234 인 회원이 가입을 했을 때 쿼리 작성
-- 권한 admin, user 중 하나
insert into member 
values('abc123','1234','01112345678','서울시 강남구 KH빌딩','6층 361반','01234',0,'user','홍길동');

insert into member 
values('qwe123','qwe1234','01112122121','서울시 강남구 KH빌딩','1층 111반','01235',0,'user','김철수');

insert into member 
values('admin','admin','01111112222','서울시 강북구 KH빌딩','3층 101호','01231',0,'admin','임꺽정');

-- 제품코드가 ABC001, 제품명 KH무선마우스, 제품설명 'KH무선마우스입니다.', 가격 15000원
-- 종류 '무선 / 유선' 제품 등록 쿼리
INSERT INTO PRODUCT VALUES('ABC001','KH무선마우스','KH무선마우스입니다.',15000);

-- option 은 mysql 키워드라서 역따옴표가 필수로 들어가야함.
insert into `option`(OP_NAME, OP_PR_CODE) VALUES('무선','ABC001');
INSERT INTO `option`(OP_NAME,OP_PR_CODE) VALUES('유선','ABC001');

-- 제품코드가 ABC001인 제품의 제품정보와 옵션을 조회하는 쿼리
select product.*, `option`.op_name as 옵션
from `option`
join product on op_pr_code = pr_code
where pr_code = 'ABC001';
