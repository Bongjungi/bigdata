-- DCL (계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (제약조건, 시퀀스없음)
-- DML (OUTER JOIN, AND(&&), OR(||), 일부단일행함수) - 연결연산자가 없다. nvl대신 ifnull을 씀.
show databases; -- database들의 리스트
use sakila;
show tables;  -- select * from tab;
use world;

-- DCL
create user user01 identified by 'password';
grant all on *.* to user01;
grant all privileges on *.* to user01;
flush privileges;     -- 이미 위의 명령으로도 괜찮지만, 확실한 입력을 위해 사용한다.
revoke all privileges on *.* from user01;  -- 권한박탈
drop user user01;
 
-- DDL
-- sql 실행 전 데이터베이스로 들어감
show databases;
create database kimdb;  -- 데이터베이스 생성
use kimdb; -- 데이터베이스로 들어감
select database(); -- 현재 들어와 있는 데이터베이스 출력
show tables; -- 들어와 있는 데이터베이스 내의 테이블들
drop table if exists emp;
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,
    sal numeric(7,2) check(sal>0),
    hiredate datetime default now(),
    comm	numeric(7,2) default 0);
select * from emp;
insert into emp (empno, ename, nickname, sal) values (1000,'홍','홍홍',9000);   
drop table if exists emp;
create table emp(
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),
    sal numeric(7,2),
    hiredate datetime default now(),
    comm	numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    check(sal>0));
drop table if exists emp;
-- major 테이블(mCode:시퀀스를 순차번호로 pk, mName, mOffice)
-- student 테이블(sNo, sName, mCode:foreign key)
create table major(
		mCode int primary key auto_increment, -- auto_increment일 경우 무조건 int
        mName varchar(20),
        mOffice varchar(30));
insert into major (mName, mOffice) values ('컴공','707호');
insert into major (mName, mOffice) values ('경영','705호');
insert into major (mName, mOffice) values ('빅데이터','701호');
insert into major (mName, mOffice) values ('기계','704호');
select * from major;
create table student(
			sNo int primary key,
            sName varchar(20),
            mCode int references major(mCode));
insert into student values (1111,'홍',1);
insert into student values (1115,'홍',5);
select * from student;       
select * from student s, major m where s.mCode=m.mCode;  
select * from student s left join major m on s.mCode=m.mCode; -- (+)를 오른쪽에 붙일거면 left join.
drop table if exists student;
drop table if exists major;
create table major(
		mCode int auto_increment, -- auto_increment일 경우 무조건 int
        mName varchar(20),
        mOffice varchar(30),
        primary key(mCode));
insert into major (mName, mOffice) values ('컴공','707호');
insert into major (mName, mOffice) values ('경영','705호');
insert into major (mName, mOffice) values ('빅데이터','701호');
insert into major (mName, mOffice) values ('기계','704호');        
create table student(
			sNo numeric(4),
            sName varchar(20),
            mCode int,
            primary key(sNo),
            foreign key(mCode) references major(mCode));
insert into student values (1111,'홍',1);
insert into student values (1112,'김',2);
insert into student values (1115,'홍',5);
delete from student where sNo=1111;
select * from student s, major m where s.mCode=m.mCode;
select * from student s right outer join major m on s.mCode=m.mCode;
select * from student s right join major m on s.mCode=m.mCode;

-- java 시간과 python 시간에 쓸 테이블과 데이터 insert
drop table if exists personal; -- 사원 테이블
drop table if exists division; -- 부서 테이블
create table division(
	dno  int , -- 부서번호
    dname varchar(20), -- 부서이름
    phone varchar(20), -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno));
show tables;
create table personal(
	pno int,                      -- 사번
    pname varchar(20) not null,   -- 사원명
    job varchar(20) not null,     -- 직책
    manager int,                  -- 상사의 사번
    startdate date,               -- 입사일
    pay int,                      -- 급여
    bonus int,                    -- 상여금
    dno int,                      -- 부서번호
    primary key(pno),
    foreign key(dno) references division(dno));
insert into division values (10,'finance','02-716-1006','신촌');
insert into division values (20,'research','02-717-1007','용산');
insert into division values (30,'sales','02-718-1008','강남');
insert into division values (40,'marketing','02-719-1009','명동'); 
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10); 
select * from division;
select * from personal;
commit;
use kimdb;

-- Oracle에서 단일행함수와 mysql에서 컬럼함수의 다른 부분
select pname, length(pname) from personal; -- length 바이트 수 셈(bill이니까 4지, 홍길동이면 9다.)
select concat(pname, '은 ', job, '이다.') from personal; -- concat은 계속 연결된다.
select round(34.5678,1); -- from dual이 필요가 없다.
select year(startdate), month(startdate), day(startdate) from personal;
select monthname(startdate), startdate from personal;
-- date_format에서 포맷 글자 %y (년도 2자리)
	-- %y(년도 2자리), %Y(년도 4자리), %M(월이름 january...), %m(01월...), %b (짧은 월이름 Jan,Feb...) %c월수(1,2,...) %e 일(1,2,3) %d 일(01,02)
	-- %H(24시간) %h(12시간) %p(오전,오후) %i분 %s초
select date_format(sysdate(), '%Y년 %m월 %d일 %p %h시 %i분 %s초');
select format(pay,0) from personal; -- 3자리마다 콤마
select format(pay,2) from personal; -- 3자리마다 콤마, 소수점 2자리.
-- 시스템으로부터 현재 날짜와 시간
select sysdate(); select now();
-- 시스템으로부터 현재 날짜
select current_date();
-- 시스템으로부터 현재 시간
select current_time();
select curtime();
-- Top-N 구문
select pname, pay from personal order by pay desc;
-- 1~N등까지
select pname, pay from personal order by pay desc limit 5;
-- limit n1, n2(n1부터 n2개 가져와라) 첫번째는 0부터 시작 
select pname, pay from personal order by pay desc limit 5,5; -- (6등(012345)부터 10등까지
select pname, pay from personal order by pay desc limit 3,6; -- 4등부터 9등까지