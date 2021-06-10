-- [VII] DDL, DML, DCL
-- DDL(테이블 생성, 테이블 삭제, 테이블구조변경, 테이블 모든 데이터 제거)
-- DML(SELECT, INSERT, UPDATE, DELETE) - 실행취소 가능
-- DCL(사용자계정생성, 사용자에게 권한부여, 권한박탈, 사용자계정삭제, 트랙잭션 명령어)
-- EXERD 빨간색 화살표는 기본키필드를 다른 테이블에 상속시킬때,
--      파란색 화살표는 새로운 필드를 만들어 관계를 새로 만든다.

--CREATE TABLE 테이블명 ( 구성 형태 조건, 구성 형태 조건,...);
-- ALTER TABLE 테이블명 ADD 구성 형태 조건                (구성 추가)
-- ALTER TABLE 테이블명 MODIFY 구성 형태                 (형태 변환)
-- ALTER TABLE 테이블명 DROP COLUMN 필드명                (필드 삭제)
-- ALTER TABLE 테이블명 SET UNUSED 필드명                 (이용 불가)
-- ALTER TABLE 테이블명 DROP UNUSED COLUMNS              (이용 불가 필드 삭제)
--DROP TABLE 테이블명                                   (테이블 삭제)
--TRUNCATE TABLE 테이블명                                (테이블 내의 필드 삭제)
--RENAME 테이블명1 TO 테이블명2                   (테이블명1을 테이블명2로 이름 바꿈)

--INSERT INTO 테이블명 ( 구성 ) VALUE (값)
--INSERT INTO 테이블명 (서브쿼리)
--UPDATE 테이블명 SET 원하는바 WHERE 변경할 필드의 조건
--SELECT 구성 FROM 테이블명 WHERE 조건
--DELETE FROM 테이블명 WHERE 조건

-- 데이터 딕셔너리(사용자 접근 불가) VS 데이터 딕셔너리 뷰(사용자 접근 가능)
-- 뷰의 종류
-- USER_XXX : 현 계정이 소유하고 있는 객체(테이블, 뷰, 인덱스, 제약조건...)
    -- USER_TABLES, USER_INDEXS, USER_CONSTRAINTS, USER_VIEWS
-- ALL_XXX : 현 계정이 접근 가능한 객체
    -- ALL_TABLES, ALL_INDEXS, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA(EX. scott)만 접근가능. DBMS의 모든 객체
    -- DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
--SELECT * FROM USER_TABLE                  (내 계정이 소유한 테이블 객체)
--SELECT * FROM ALL_INDEXS                   (내가 접근가능한 인덱스 객체)
--SELECT * FROM DBA_CONSTRAINTS                   (DBA가 소유한 제약조건들)

--CREATE USER smith IDENTIFIED BY tiger;      -- smith 계정 생성
-- 권한 부여(세션권한, scott.emp, scott.dept에 대한 모든 권한)
--GRANT CREATE SESSION TO smith; -- GRANT DBA TO scott;
--GRANT ALL ON EMP TO smith; -- 내 계정에 EMP테이블에 대한 모든 권한 부여(ALL이 아닌 SELECT면, SELECT 권한만 부여)
-- 권한 박탈( 권한 박탈할 ID가 접속해제 중)
-- REVOKE ALL ON EMP FROM smith; -- 내 계정의 EMP 테이블에 대한 모든 권한 박탈(SMITH계정이 접속 해제 되어 있어야 함.)
-- DROP USER smith CASCADE;
-- 제약조건
--(1) PRIMARY KEY : 유일하게 테이블의 각 행을 식별.
--(2) NOT NULL : NULL값을 포함하지 않음.
--(3) UNIQUE : 모든 행에 대해 유일해야 하며 NULL값을 허용.
--(4) FOREIGN KEY : 테이블의 열은 다른 테이블의 열을 참조.
--(5) CHECK(조건) : 해당 조건이 만족.
--(6) DEFAULT : 기본값 설정.



SELECT * FROM EMP;
DESC DEPT;

--DDL
-- 1.테이블 생성(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4), --도서번호 BOOKID 필드의 타입은 숫자4자리
    BOOKNAME VARCHAR2(20), -- 도서이름 BOOKNAME 필드의 타입은 문자20BYTE
    PUBLISHER VARCHAR2(20), -- 출판사
    RDATE DATE, -- 출판일 RDATE의 필드 타입은 DATE
    PRICE NUMBER(8),
    PRIMARY KEY(BOOKID)); -- 주키(기본키) 설정 (유일, NOT NULL)
SELECT * 
    FROM BOOK;
DROP TABLE BOOK; --테이블 삭제
CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY, --도서번호 BOOKID 필드의 타입은 숫자4자리, 기본키
    BOOKNAME VARCHAR2(100), -- 도서이름 BOOKNAME 필드의 타입은 문자100BYTE
    PUBLISHER VARCHAR2(20), -- 출판사
    RDATE DATE, -- 출판일 RDATE의 필드 타입은 DATE
    PRICE NUMBER(8));
--EMP와 유사한 EMP01 : EMPNO(숫자4), ENAME(문자20), SAL(숫자7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)); -- 전체 7자리(정수5자리, 소수2자리)
SELECT * 
    FROM EMP01;    
--DEPT와 유사한 DEPT01 : DEPTNO(숫자2), DNAME(문자14), LOC(문자13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13));
--서브쿼리를 이용한 테이블 생성
CREATE TABLE EMP02
    AS
    SELECT * FROM EMP; -- 서브쿼리 결과만 테이블에 들어감. PRIMARY KEY 등의 제약조건 미포함.
DESC EMP02;
CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, DEPTNO 
    FROM EMP;
-- EMP에서 10번 부서만 추출
CREATE TABLE EMP04 AS SELECT * 
    FROM EMP 
    WHERE DEPTNO=10;
-- EMP구조만 추출
CREATE TABLE EMP05 AS SELECT * 
    FROM EMP 
    WHERE 1=0;

SELECT ROWNUM, EMPNO, ENAME 
    FROM EMP; -- ROWNUM 행의 논리적 순서
SELECT ROWID, EMPNO, ENAME 
    FROM EMP; --ROWID행의 논리적 주소
--2. 테이블 구조 변경(ALTER TABLE)
--(1) 필드 추가 (ADD)
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20) , SAL NUMBER(7,2)); -- 필드 2개 추가
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));
--(2) 필드 타입 수정(MODIFY)
SELECT * FROM EMP03; -- EMPNO,ENAME,DEPTNO 값 있음, JOB,SAL,COMM 값 없음
--ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR(5)); -- 오류(숫자데이터가 들어있어서 숫자로만 변경 가능)
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(20)); -- 변경가능.
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(20)); -- NULL값이면 아무 형태로 변경가능
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4));
-- (3) 필드 삭제(DROP)
ALTER TABLE EMP03 DROP COLUMN JOB; -- JOB 필드 삭제
ALTER TABLE EMP03 DROP COLUMN DEPTNO; -- DEPTNO필드 삭제(데이터까지 제거)
-- 논리적으로 특정 필드를 접근 못하도록 (낮)
ALTER TABLE EMP03 SET UNUSED (COMM); -- COMM 접근불가
-- 논리적으로 접근 불가했던 필드를 삭제
ALTER TABLE EMP03 DROP UNUSED COLUMNS;
--3. 테이블 삭제(DROP TABLE)
DROP TABLE EMP01;
SELECT * FROM EMP01;
DROP TABLE DEPT; -- 삭제 불가.( DEPT테이블이 부모 테이블이고 EMP테이블이 자식 테이블이다. DEPT테이블의 DEPTNO를 EMP테이블이 참조하고 있기 때문에 EMP의 DEPTNO를 조작해야 DEPT를 지울 수 있다. CASCADE쓰면 가능하긴 하다.
SELECT * FROM EMP;
--4.테이블의 모든 행을 제거(TRUNCATE)
TRUNCATE TABLE EMP03; -- EMP03안의 데이터 제거(취소불가)
SELECT * FROM EMP03;
--5. 테이블명 변경(RENAME)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2; --EMP02를 EMP2로 테이블명 변경
--6. 데이터 딕셔너리(사용자 접근 불가) VS 데이터 딕셔너리 뷰(사용자 접근 가능)
-- 뷰의 종류
-- USER_XXX : 현 계정이 소유하고 있는 객체(테이블, 뷰, 인덱스, 제약조건...)
    -- USER_TABLES, USER_INDEXS, USER_CONSTRAINTS, USER_VIEWS
-- ALL_XXX : 현 계정이 접근 가능한 객체
    -- ALL_TABLES, ALL_INDEXS, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA(EX. scott)만 접근가능. DBMS의 모든 객체
    -- DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
SHOW USER;
SELECT * FROM USER_TABLES; -- 내 계정이 소유한 테이블 객체
SELECT * FROM USER_INDEXES; -- 내 계정이 소유한 인덱스 객체
SELECT * FROM USER_CONSTRAINTS; -- 내 계정이 소유한 제약조건들
SELECT * FROM USER_VIEWS; -- 내 계정이 소유한 뷰
SELECT * FROM ALL_TABLES; -- 내 계정이 접근 가능한 테이블 객체
SELECT * FROM ALL_TABLES WHERE TABLE_NAME = 'EMP';
SELECT * FROM ALL_INDEXES; -- 내 계정이 접근 가능한 인덱스 객체
SELECT * FROM ALL_CONSTRAINTS; -- 내 계정이 접근 가능한 제약조건들
SELECT * FROM ALL_VIEWS; -- 내 계정이 접근 가능한 뷰
SELECT * FROM DBA_TABLES;


-- DCL(사용자 계정 생성, 사용자 계정 권한 부여, 권한 박탈, 계정 삭제)
CREATE USER smith IDENTIFIED BY tiger; -- smith 계정 생성
-- 권한 부여(세션권한, scott.emp, scott.dept에 대한 모든 권한)
GRANT CREATE SESSION TO smith; -- GRANT DBA TO scott;
GRANT ALL ON EMP TO smith; -- 내 계정에 EMP테이블에 대한 모든 권한 부여(ALL이 아닌 SELECT면, SELECT 권한만 부여)
-- 권한 박탈( 권한 박판할 ID가 접속해제 중)
REVOKE ALL ON EMP FROM smith; -- 내 계정의 EMP 테이블에 대한 모든 권한 박탈
DROP USER smith CASCADE;

--DML(SELECT, INSERT, UPDATE, DELETE)
-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, ...), INSERT INTO 테이블명 (필드명1,필드명2,...) VALUES(값1,값2,...)
SELECT * FROM DEPT01;
INSERT INTO DEPT01 (DEPTNO,DNAME,LOC) VALUES (10,'ACCOUNTING','NEW YORK'); -- 트랜잭션 1개가 올라감. 취소 가능.(SQL끄면 커밋할지 롤백할지물어볼것
INSERT INTO DEPT01 (DEPTNO,LOC) VALUES (30,'NEW YORK');
UPDATE DEPT01 SET LOC=NULL, DNAME='IT' WHERE DEPTNO=30;
-- 서브쿼리를 이용한 INSERT
    --DEPT테이블에서 10~30부서를 INSERT
TRUNCATE TABLE DEPT01;
INSERT INTO DEPT01 SELECT * FROM DEPT;
--BOOK테이블에서 11(책번호)번 '스포츠의학', '한솔출판', 출판일은 오늘, 가격은 90000;
SELECT * FROM BOOK;
INSERT INTO BOOK VALUES (11,'스포츠의학', '한솔출판',SYSDATE,90000);
--트랜잭션 명령어(DML명령어만 적용)
COMMIT; -- 트랜잭션 단위로 진행. 현 트랜잭션의 작업을 DB에 반영
ROLLBACK;
--2. UPDATE 테이블명 SET 필드명1==값1,... WHERE 조건;
CREATE TABLE EMP01 AS SELECT * FROM EMP; 
UPDATE EMP01 SET DEPTNO =30; -- 모든 DEPTNO가 30으로
UPDATE EMP01 SET SAL = SAL*1.1;
-- 10번 부서 직원의 입사일을 오늘로, 부서번호는 30번 부서로 수정하시오.
SELECT * FROM EMP01;
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO=30 WHERE DEPTNO=10;
--SAL이 3000이상인 사원만 급여를 10% 인상
UPDATE EMP01 SET SAL=SAL*1.1 WHERE SAL>=3000;
--DALLAS에 근무한느 직원의 급여를 1000씩 인상
UPDATE EMP01 SET SAL=SAL+1000 WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
--SCOTT을 부서번호 20, MANEGER,SAL과 COMM을 500 인상, 상사는 KING으로 수정
UPDATE EMP01 
    SET DEPTNO=20, JOB='MANAGER', SAL=SAL+500, COMM=NVL(COMM,0)+500, MGR= (SELECT EMPNO FROM EMP WHERE ENAME='KING')
    WHERE ENAME='SCOTT';
--DEPT01에서 20부서의 지역명을 40부서의 지역명으로 변경
SELECT * 
    FROM DEPT01;
UPDATE DEPT01 
    SET LOC = (SELECT LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=20;
--EMP01테이블에서 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정
UPDATE EMP01 
    SET (SAL, HIREDATE)= (SELECT SAL, HIREDATE FROM EMP WHERE ENAME='KING');
COMMIT;
--3. DELETE FROM 테이블명 WHERE 조건
SELECT * 
    FROM EMP01;
DELETE 
    FROM EMP01;
ROLLBACK;
--EMP01테이블에서 30번 부서 직원만 삭제
DELETE 
    FROM EMP01 
    WHERE DEPTNO=30;
--EMP01테이블에서 사원명이 'FORD'인 사원을 삭제
DELETE 
    FROM EMP01 
    WHERE ENAME='FORD';
--EMP01테이블에서 부서명이 SALES인 사원을 삭제
DELETE 
    FROM EMP01 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
--EMP01에서 RESEARCH 부서 소속인 사원을 삭제
DELETE
    FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH');
COMMIT;

-- 제약조건
--(1) PRIMARY KEY : 유일하게 테이블의 각 행을 식별.
--(2) NOT NULL : NULL값을 포함하지 않음.
--(3) UNIQUE : 모든 행에 대해 유일해야 하며 NULL값을 허용.
--(4) FOREIGN KEY : 테이블의 열은 다른 테이블의 열을 참조.
--(5) CHECK(조건) : 해당 조건이 만족.
--(6) DEFAULT : 기본값 설정.
CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR(14) UNIQUE,
    LOC VARCHAR(13) NOT NULL);
DROP TABLE DEPT1;    
CREATE TABLE DEP1(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) NOT NULL,
    PRIMARY KEY(DEPTNO),
    UNIQUE(DNAME));
DESC DEP1;
CREATE TABLE EMP1(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    MGR NUMBER(4),
    SAL NUMBER(7,2) CHECK(SAL>0),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEP1(DEPTNO), --외래키 제약조건
    JOB VARCHAR2(9),
    HIREDATE DATE DEFAULT SYSDATE);
DROP TABLE EMP1;
CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    MGR NUMBER(4),
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    JOB VARCHAR2(9) NOT NULL,
    HIREDATE DATE DEFAULT SYSDATE,
    PRIMARY KEY(EMPNO),
    CHECK(SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEP1(DEPTNO));
INSERT INTO DEP1 SELECT * FROM DEPT;
SELECT * FROM DEP1;
INSERT INTO DEP1 (DEPTNO, DNAME, LOC) VALUES (50,'IT','MAPO');
INSERT INTO DEP1 VALUES (60,'PLANNING','MAPO');
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) 
        VALUES (1001,'KIM','MANAGER',1000,0,50); --DEFAULT SYSDATE
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO)
        VALUES (1002, 'PARK', 'MANAGER', 60);-- PK
INSERT INTO EMP1 (EMPNO, JOB, DEPTNO)
        VALUES (1003, 'MANAGER', 40); --NOT NULL
INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL, DEPTNO)
        VALUES (1004, 'YUN', 'MANAGER', 0, 30); --CHECK(SAL>0)
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO) 
        VALUES (1005, 'YI', 'MANAGER', 80); --FOREIGNKEY(DEPTNO) REFERENCES DEP1


    


--연습문제
SELECT * FROM SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2));
INSERT INTO SAM01 VALUES (1000,'APPLE','POLICE',10000);    
INSERT INTO SAM01 VALUES (1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 VALUES (1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030,'VERY',25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1040,'CAT',2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;
DELETE FROM SAM01 WHERE JOB IS NULL;
DELETE FROM SAM01 WHERE ENAME = 'ORANGE';

