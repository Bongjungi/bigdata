--FROM -WHERE-GROUP BY -HANING -SELECT -ORDER BY 순 실행
--ROLLBACK - DML 취소
--COMMIT - DML 적용
-- SELECT 1+1 FROM DUAL;
-- SELECT (DISTINCT) (별칭1).필드1 (AS 필드별칭), NVL(12*필드2,0), SUM(필드),  ... 
   -- FROM 테이블1 (별칭1), 테이블2 (별칭2),...
   -- WHERE 조인조건1(별칭1.필드=별칭2.필드(+)), 조건 AND (BETWEEN 1 AND 2) OR IN(10,20) 
   -- AND LIKE '%M%' OR LIKE '_M_' AND 필드 IS NOT NULL
   -- GROUP BY 필드
   -- HAVING 조건
   -- ORDER BY 필드 ASC, 필드 DESC;
--ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';            --시스템 날짜 형식 변경
--SELECT ENAME ||' 은(는) '|| JOB ||' 이다.' "EMPLOYEES" FROM EMP; -- 연결연산자 '||'

--4.단일행함수, 5. 그룹함수 참조

-- SELECT 필드명 ... FROM ... WHERE 필드명 =,>,!= (SELECT 필드명 FROM 테이블 WHERE 조건); - 단일행서브쿼리
-- SELECT 필드명 ... FROM ... WHERE (필드명1, 필드명2) = (SELECT (필드명1, 필드명2) FROM 테이블 WHERE 조건);
-- SELECT 필드명 ... FROM ... WHERE 필드명 IN(-안에있는지),ALL(-전부만족하는지),ANY(-하나라도만족하는지),SOME(-ANY) (SELECT 필드명 FROM 테이블 WHERE 조건); -다중행서브쿼리
-- SELECT 필드명 ... FROM ... WHERE EXISTS(-내용이 TRUE인것이 존재하는지) (SELECT 필드명 FROM 테이블 WHERE 조건);


--------------------------------------------------------------------------------------------------------------------------------
-- DDL(테이블 생성, 테이블 삭제, 테이블구조변경, 테이블 모든 데이터 제거)
-- DML(SELECT, INSERT, UPDATE, DELETE) - 실행취소 가능
-- DCL(사용자계정생성, 사용자에게 권한부여, 권한박탈, 사용자계정삭제, 트랙잭션 명령어)
-- EXERD 빨간색 화살표는 기본키필드를 다른 테이블에 상속시킬때,
--      파란색 화살표는 새로운 필드를 만들어 관계를 새로 만든다.

--CREATE TABLE 테이블명 ( 구성 형태 조건, 구성 형태 조건,...);
--ALTER 테이블명 ADD 구성 형태 조건                (구성 추가)
--ALTER 테이블명 MODIFY 구성 형태                 (형태 변환)
--ALTER 테이블명 DROP COLUMN 필드명                (필드 삭제)
--ALTER 테이블명 SET UNUSED 필드명                 (이용 불가)
--ALTER 테이블명 DROP UNUSED COLUMNS              (이용 불가 필드 삭제)
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
-----------------------------------------------------------------------------------------------------------------
--[SUQUENCE]--

-- CREATE SEQUENCE sequence_name
-- [INCREMENT BY n] [START WITH n]
-- [MAXVALUE n][MINVALUE n]
-- [CYCLE|NOCYCLE]
-- [CACHE n| NOCACHE];

-- DROP SEQUENCE sequence_name;    (삭제)
-- ALTER SEQUENCE sequence_name [INCREMENT BY n] [START WITH n][MAXVALUE n][MINVALUE n]
-- INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) VALUES (FRIEND_SEQ.NEXTVAL,' ',' ',' ');
----------------------------------------------------------------------------------------------------------------
--[VIEW]--

--CREATE OR REPLACE VIEW 뷰명 AS SELECT EMPNO, ENAME, JOB, DEPTNO 
   -- FROM EMP WHERE 조건 WITH CHECK OPTION                  --조건에 맞아야 실행
   -- FROM EMP WITH READ ONLY                               --읽기만 가능, 갱신 불가.
--VIEW는 가상의 테이블 (메모리 공간을 차지하지 않는다.)
--VIEW에 DML쓰면 원 테이블에도 적용된다.
-- C OR R VIEW 뷰명 AS SELECT (DISTICT) DEPTNO, SAL*12 YEARSAL ....처럼 필드명을 SAL*12로 조작하고 별칭을 달면 갱신 불가. 당연한듯..

-- C OR R VIEW ...
    --FROM VIEW, TABLE         --이런식으로 필드에 DEPTNO, DNAME 같은 것과 SUM(SAL), AVG(COMM) 같은 것을 함께 놓을 수 있다.
--INLINE VIEW -- FROM에 서브쿼리를 넣는 것.
--EX. SELECT ENAME, SAL, E.DEPTNO FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) S WHERE E.DEPTNO=S.DEPTNO AND SAL>AVGSAL;

-- TOP N
-- 이름을 알파벳 순서대로 정렬해서 6~10등까지 출력(등수, 이름, 사번, JOB, MGR, HIREDATE)
-- 1단계 : SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME;
-- 2단계 : SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME); --1단계를 FROM에
-- 3단계 : SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
            -- FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME))
            -- WHERE RN BETWEEN 6 AND 10;
