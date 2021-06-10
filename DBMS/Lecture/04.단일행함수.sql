--[IV] 단일행함수, 내장함수
--함수 = 단일행함수 + 그룹함수(집계함수)
-- 단일행함수 = INPUT 1 --> OUTPUT 1
-- 그룹함수 = INPUT N --> OUTPUT 1
SELECT HIREDATE, TO_CHAR(HIREDATE,'YY"년" MM"월" DD"일"') 
    FROM EMP;
SELECT ENAME, INITCAP(ENAME)
    FROM EMP;--INITCAP 첫글자 대문자로 변형 - 단일행함수
SELECT SUM(SAL) 
    FROM EMP; --그룹함수(집계함수)
SELECT DEPTNO, SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO;
SELECT * 
    FROM DUAL
    WHERE DUMMY='X';
    
    
--EX. 숫자관련함수, 문자관련함수, 날짜관련함수, 형변환함수, NVL(), ETC...

-- 1. 숫자함수
SELECT ABS(-9) 
    FROM DUAL; --테스트용 테이블 DUAL
SELECT FLOOR(34.5478) 
    FROM DUAL; --34
SELECT TRUNC(34.5478,2) 
    FROM DUAL;
SELECT LOG(EXP(1),EXP(2)) 
    FROM DUAL;
SELECT TAN(0) 
    FROM DUAL;
SELECT POWER(2,3) 
    FROM DUAL;
SELECT SIGN(3) 
    FROM DUAL; -- 0보다 작으면 -1, 0이면 0, 0보다 크면 1
-- EMP 테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, SAL, TRUNC(SAL, -2) 
    FROM EMP;
SELECT CEIL(34.4567) 
    FROM DUAL;
SELECT ROUND(34.5678) 
    FROM DUAL;
SELECT MOD(5,3)
    FROM DUAL; -- 5MOD(3)인듯.
SELECT *
    FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE,'MM'),2)=1;
    
    
--2. 문자처리함수
SELECT LOWER('A') 
    FROM DUAL;
SELECT UPPER('Welcome') 
    FROM DUAL;
SELECT INITCAP('asd') 
    FROM DUAL;
SELECT 'AB'||'CD'||'EF'
    FROM DUAL;
SELECT CONCAT(CONCAT(ENAME,'은 '),CONCAT(JOB,'이다.')) 
    FROM EMP;
SELECT CONCAT('ASD','SDF')
    FROM DUAL;--ASDSDF
SELECT SUBSTR(HIREDATE,1,2), SUBSTR(HIREDATE,4,2)
    FROM EMP;
SELECT SUBSTR('오라클오라클',1,3) 
    FROM DUAL;--1부터 3글자 추출
SELECT SUBSTRB('오라클오라클',1,7)
    FROM DUAL;--1부터 3BYTE 추출 (-- 영어는 한 글자당 1BYTE, 한글은 한 글자당 3BYTE-오라클버전마다 다르다.) 
SELECT LENGTH('ASDF가가') 
    FROM DUAL;--6
SELECT LENGTHB('ASDF가가') 
    FROM DUAL;--10
SELECT INSTR('SDFAADSAADAADFA','A',1,3) 
    FROM DUAL;--8; A가 1항부터 찾아서 3번째 있는 곳이 어딘가?
SELECT RPAD(SUBSTR(ENAME,1,2),LENGTH(ENAME),'*')
    FROM EMP; --????????????????
SELECT TRIM(ENAME) 
    FROM EMP; -- 좌우공백 사라짐 LTRIM은 좌공백 RTRIM은 우공백
SELECT CONVERT(ENAME,'US7ASCII','UTF8') 
    FROM EMP;--CHAR SET을 변환
SELECT CHR(65) 
    FROM DUAL; --아스키코드값으로 'A' 입력.
SELECT ASCII('A') 
    FROM DUAL; --'A'를 아스키코드값으로
SELECT REPLACE(ENAME,'I','A') 
    FROM EMP;
--JOB이 MANAGER인 직원의 모든 필드
SELECT * 
    FROM EMP
    WHERE UPPER(JOB)='MANAGER';
--9월에 입사한 사원을 출력해 보시오
SELECT * 
    FROM EMP 
    WHERE SUBSTR(HIREDATE,4,2)=09;
--83년도에 입사한 직원
SELECT *
    FROM EMP
    WHERE SUBSTR(HIREDATE,1,2)=83;
--이름이 E로 끝나는 사원
SELECT *
    FROM EMP
    WHERE UPPER(SUBSTR(ENAME,-1,1))='E';
--사번,이름,직책(이름의 문자수만큼 표시)
SELECT EMPNO, ENAME, SUBSTR(JOB,1,LENGTH(ENAME))
    FROM EMP;
--HIREDATE의 형식을 날짜에서 문자열로 바꿔라
--SELECT TO_CHAR(HIREDATE) FROM EMP;
SELECT SUBSTR(HIREDATE, 1, LENGTH(HIREDATE))
    FROM EMP;
SELECT INSTR('ABCDABCDABCD','B')
    FROM DUAL;--B가 처음 나오는 위치
SELECT INSTR('ABCABC','B',-3) 
    FROM DUAL;-- -3부터 시작하여 왼쪽방향으로 'B'를 찾아라
SELECT INSTR('ACCABC','B',-3)
    FROM DUAL; -- 0 (한방향으로 한번만 확인한다.)
SELECT INSTR('ABCDABCDABCD','B',3,2) 
    FROM DUAL;--B가 3번인덱스부터 시작하여 2번째로 나오는 인덱스
SELECT INSTR('데이터베이스','이',3,1), INSTRB('데이터베이스','이',3,1)
    FROM DUAL;
--9일이 아닌 다른 날에 입사한 사원
SELECT * 
    FROM EMP 
    WHERE INSTR(HIREDATE,'09',6)=0;
--이름의 세 번째 자리가 R인 사원을 검색
SELECT ENAME 
    FROM EMP 
    WHERE ENAME LIKE '__R%';
SELECT ENAME 
    FROM EMP
    WHERE SUBSTR(ENAME,3,1)='R';
SELECT ENAME 
    FROM EMP 
    WHERE INSTR(ENAME,'R',3,1)=3;
SELECT LPAD('ORACLE',20,'#') 
    FROM DUAL;
SELECT LTRIM(' ORACLE ') 
    FROM DUAL;
SELECT TRIM('a' FROM 'aaaaaaaaaaORACLEaBBaaaaaaa') 
    FROM DUAL;
--이름의 첫 글자만 나오고 나머지는 *로 출력
SELECT RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*')
    FROM EMP;
SELECT * 
    FROM EMP 
    WHERE SUBSTR(HIREDATE,-2,2)=09;
--사번 S****(이름은 앞 한글자만 출력하고 나머지는*)
SELECT RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*')
    FROM EMP;
--사번 _****H 80/12/**
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME,-1,1),LENGTH(ENAME),'*'),10,'_'), RPAD(SUBSTR(HIREDATE,1,6),LENGTH(HIREDATE),'*')
    FROM EMP;


--3. 날짜함수
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';
SELECT SYSDATE, SYSDATE+14 
    FROM DUAL;
-- 근무월수
SELECT TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE),2) 
    FROM EMP;
SELECT ADD_MONTHS('2021/01/05',3) 
    FROM DUAL;
SELECT NEXT_DAY(SYSDATE,'수요일') 
    FROM DUAL ;-- 1-일요일 2-월 ...
SELECT LAST_DAY(SYSDATE) 
    FROM DUAL; --기입한 날짜의 달의 마지막 날짜
SELECT SYSDATE, ROUND(SYSDATE,'DAY'), ROUND(SYSDATE, 'MONTH'), TRUNC(SYSDATE, 'MONTH')
    FROM DUAL; --DAY기준 반올림 21/06/03, 21/06/06(가까운 일요일로 반올림), MONTH로 반올림(1~15일까지는 이번달1일), 해당월의 1일
--사원들의 근무일수
SELECT TRUNC(SYSDATE-HIREDATE)
    FROM EMP;
-- 첫 월급날(말일)
SELECT LAST_DAY(HIREDATE) 
    FROM EMP;
-- 첫 월급날(1일)
SELECT LAST_DAY(HIREDATE)+1, ROUND(HIREDATE+15,'MONTH') 
    FROM EMP;
--이름, 입사일, 근무주수, 근무년수
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE)/7), TRUNC((SYSDATE-HIREDATE)/365) 
    FROM EMP;
--이름, 입사한 이후 받은 급여와 상여(급여는 매달 SAL을 받고 상여금은 2번 COMM을 받음)
SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*SAL, TRUNC((SYSDATE-HIREDATE)/365)*2*NVL(COMM,0)
    FROM EMP;
--이름, 입사일, 입사한달의 5일
SELECT ENAME, HIREDATE,TRUNC(HIREDATE,'MONTH')+4
    FROM EMP;
--이름, 입사일, 월급날(5일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11,'MONTH')+4
    FROM EMP;
SELECT ROUND(TO_DATE('81/04/04','YYYY/MM/DD')+11,'MONTH')+4
    FROM DUAL;
--이름, 입사일, 월급날(25일)   
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9,'MONTH')+24
    FROM EMP;

-- 4. 형변환함수
--오라클 타입 : 문자, 숫자, DATE

--(1) 날짜형 혹은 숫자형을 문자형으로 변환
-- YYYY(4자리), YY(2자리),MM(월을 숫자로), MON(월을 알파벳으로 표현), DD(일) DAY(요일) DY(요일을약어로) AM, PM, A.M(오전 시각표시) P.M
-- HH12(12시간표현) HH24(24시간표현) MI(분) SS(초)
SELECT TO_CHAR(SYSDATE,'YYYY"년"MM"월"DD"일"'), TO_CHAR(SYSDATE,'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS') 
    FROM DUAL;
-- 출력형식
-- 0(자릿수가 맞지 않으면 0으로 채움) 9(자릿수가 맞지 않으면 비움) L(각 지역 통화 기호)
SELECT ENAME, SAL, TO_CHAR(SAL,'L909,999')
    FROM EMP;
--(2) 문자형을 날짜형으로 변환
SELECT TO_DATE(20180605,'YYYYMMDD')
    FROM EMP; --18/06/05
--(3) 문자형을 숫자형으로 변환
SELECT TO_NUMBER('10,000','99,999'), TO_NUMBER('20,000','99,999')
    FROM EMP;
SELECT TO_NUMBER('3,456.78','9,999.99')+1 
    FROM DUAL;
SELECT '3456.78'+1
    FROM DUAL;
    
--5. NULL 값 변환 함수 NVL - 매개변수 2개는 타입이 일치해야 한다.
SELECT TO_CHAR(NVL(COMM,0),'L900,000')
    FROM EMP;
--이름, 상사의 사번(MGR) 출력. 직속상사 없을 경우 'CEO'로 출력
SELECT ENAME, NVL(TO_CHAR(MGR),'CEO')
    FROM EMP;
    
 
--6. ETC
--(1) EXTRACT : 년도나 월만 추출하고자 할 때
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;

--(2) 레벨별 출력 : LEVEL, START WITH 조건, CONNECT BY PRIOR 조건
SELECT LEVEL,ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;
SELECT LEVEL,LPAD(' ',LEVEL*2)||ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;