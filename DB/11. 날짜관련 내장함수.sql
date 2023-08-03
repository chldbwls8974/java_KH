/*
now(), current_timestamp(), sysdate();
: 현재시간을 년-월-일 시:분:초로 알려주는 함수

adddate(날짜,차이) / subdate(날짜,차이)
: 날짜로부터 차이만큼 더한 날짜 / 뺀 날짜
 ** 차이 : interval 숫자 단위(day,month,year, hour, minute, second) 로 표현 

addtime(날짜,차이) / subtime(날짜,차이);
: 날짜로부터 차이만큼 더한 시간 / 뺀 시간
 ** 차이 : 'yyyy-MM-dd hh:mm:ss' 형식
*/
select adddate(now(), interval 1 day);
select adddate(now(), interval 1 month);
select adddate(now(), interval 1 year);
select subdate(now(), interval 1 day);
select addtime(now(), '1 00:00:00');

/*
datediff(날짜1, 날짜2);
: 날짜1과 날짜2 사이의 날짜 차이 (날짜로 표현)

timediff(날짜1, 날짜2);
: 날짜1과 날짜2 사이의 시간 차이 (시간으로 표현)
*/
select datediff(now(), '2023-07-19');
select timediff(now(), '2023-07-19 23:33:14');








