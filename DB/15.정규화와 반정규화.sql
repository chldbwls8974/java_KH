/*
정규화 : 테이블을 쪼개는 과정
- 데이터의 중복을 최소화하고, 데이터의 일관성과 무결성을 보장하는 방법
제 1정규화
	- 각 열은 도메인(원자값)으로만 구성
	- 각 행은 기본키  
	- 중복된 데이터를 제거해서 복수개의 행으로 구성한다.
제 2정규화
	- 제 1정규화 만족
	- 주요 속성에 완전 종속되어야 한다. (부분 종속)
제 3정규화
	- 이행 종속성을 제거해야 한다. 
    - A->C : A를 통해 C를 알 수 있는 테이블을 A->B, B->C를 통해 알 수 있도록 테이블을 추가해서 구성
제 4정규화
	- 결정 
B 정규화
	- 다중 종속 
제 5정규화
	- 조인 


반정규화 : 테이블을 합치는 과정 
 
*/