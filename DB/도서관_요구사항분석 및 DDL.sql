/*
도서 대출 사이트 (도서관)를 구축하기 위한 요구사항 명세서
- 반드시 회원 가입을 통해 대출이 진행되어야함. 
- 대출 기간은 14일 , 연체할때마다 연체기간만큼 도서 대출 불가 
- 도서는 대출/예약 가능, 대출 중, 예약 중 만 존재 
- 같은 도서는 도서번호 마지막 숫자만 다름 
- 분류번호 3자리 , 도서번호(영문,숫자, 최대 7자리) V1(시리즈로 된 경우) 2(같은 도서 중 2번째 도서)
- 101.a123b v1 1 시리즈와 도서는 띄어쓰기로 구분
*/
/*
-- 내가 --

회원
회원가입 시 아이디, 비번, 이름, 핸드폰번호를 작성한다.
회원을 조회하면 아이디, 비번, 이름, 핸드폰 번호, 대출상태(대출중, default 대출가능), 연체상태(연체기간, 연체 없으면 default 0)

분류
도서 분류는 총류000, 철학 100, 종교 200, 사회과학 300, 자연과학 400, 기술과학 500, 예술 600, 언어 700, 문학 800, 역사 900 으로 나눈다.

도서종류를 등록할 때 도서이름, 도서 분류, 출판사, 저자, 도서상태(대출가능, 대출중), 총권수, 대출가능 권수 를 작성한다.

도서는 도서번호, 도서이름, 도서상태(default 대출가능)를 등록한다.
같은 도서가 여러권이어도 도서 썸네일은 대표 하나만 등록한다

대출
대출시 대출번호, 대출총권수, 대출날짜, 대출기한, 상태(대출 중, 반납완료), 대출인아이디 을 작성한다.
대출리스트에는 대출리스트번호, 대출도서번호, 대출도서명, 대출권수, 대출번호(외래)를 작성한다.
*/

/*
-- 강사님

사이트 이용은 회원만 가능
회원가입은 아이디, 비번, 전화번호, 생년월일을 입력하여 가입한다.
회원은 회원과 관리자로 구분

도서 등록은 관리자만 가능
도서 등록시 도서명 도서번호 저자 분류 출판사를 입력하여 등록한다8
분류는 도서분류로 3자리의 숫자로 구성 
저자는 한번에 같이 입력(저자가 여러명이거나 저자, 옮긴이, 엮은이 처럼 여러명인경우 다 같이 저장)

회원은 도서번호를 이용하여 예약이 가능하다
회원은 최대 3권의 도서를 대출할 수 있다

도서 연체시 연체 기간만큼 도서를 대출할 수 없다 

예약된 도서는 최대 3일까지 예약으로 표시되고 이후에는 예약이 취소된다 

예약은 대출가능한 도서나 대출중이지만 예약되지 않은 도서만 가능하다.
특정 도서는 대출 여부에 상관없이 예약이 불가능하다 
*/


DROP DATABASE IF EXISTS BOOK;
CREATE DATABASE IF NOT EXISTS BOOK;
USE BOOK;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL PRIMARY KEY,
	`me_pw`	varchar(255)	NOT NULL,
	`me_phone`	char(13 )	NOT NULL,
	`me_birthday`	date	NOT NULL,
	`me_authority`	varchar(5)	NOT NULL DEFAULT 'USER',
	`me_book_count`	int NOT	NULL DEFAULT 0,
	`me_total_overdue`	int	NOT NULL DEFAULT 0,
	`me_apply_overdue`	date	NULL
);

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
	`bo_num`	varchar(20)	NOT NULL PRIMARY KEY,
	`bo_name`	varchar(255)	NOT NULL,
	`bo_type`	varchar(10)	NOT NULL,
	`bo_publisher`	varchar(30)	NOT NULL,
	`bo_author`	varchar(255)	NOT NULL,
	`bo_possible_loan`	int	NOT NULL,
	`bo_possible_reserv`	int	NOT NULL
);

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
	`lo_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`lo_me_id`	varchar(15)	NOT NULL,
	`lo_bo_num`	varchar(20)	NOT NULL,
	`lo_date`	datetime	NOT NULL,
	`lo_expected_date`	date	NOT NULL,
	`lo_return_date`	date	NULL
);

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
	`re_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`re_date`	date	NOT NULL,
	`re_me_id`	varchar(15)	NOT NULL,
	`re_bo_num`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `book_state`;

CREATE TABLE `book_state` (
	`bs_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`bs_desc`	varchar(20)	NOT NULL
);


ALTER TABLE `book` ADD CONSTRAINT `FK_book_state_TO_book_1` FOREIGN KEY (
	`bo_possible_loan`
)
REFERENCES `book_state` (
	`bs_num`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_book_state_TO_book_2` FOREIGN KEY (
	`bo_possible_reserv`
)
REFERENCES `book_state` (
	`bs_num`
);

ALTER TABLE `loan` ADD CONSTRAINT `FK_member_TO_loan_1` FOREIGN KEY (
	`lo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `loan` ADD CONSTRAINT `FK_book_TO_loan_1` FOREIGN KEY (
	`lo_bo_num`
)
REFERENCES `book` (
	`bo_num`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_member_TO_reservation_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_book_TO_reservation_1` FOREIGN KEY (
	`re_bo_num`
)
REFERENCES `book` (
	`bo_num`
);






