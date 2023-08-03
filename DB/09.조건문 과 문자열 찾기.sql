/*
- if(수식,참,거짓)
- ifnull(속성,값) : 속성값 null이 아니면 속성값을 반환하고, null이면 값을 반환 (속성 대신 수식도 가능함)
- nullif
- case when else...
	case when 조건1 then 값1 when 조건2 then 값2 else 값3 and
    : 
*/
select num,if(major='컴퓨터공학과','컴공','컴공아님') as 전공 from student;
select title as 과목명,ifnull(time,0) as 시수 from subject;
select num as 학번, case
when major='방송학과' then '방송'
when major='컴퓨터공학과' then '컴공'
else '기타'
end as 학과 from student;



/*
instr(기준문자열, 찾을문자열)
: 기준문자열에서 찾을 문자열이 몇번째에 있는지 알려주는 함수, 없으면 0
  1부터 시작
*/
select instr(title,'개론') as 대학위치, title from subject;