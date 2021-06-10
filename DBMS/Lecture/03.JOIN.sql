--[III] JOIN : 테이블 2개 이상을 연결하여 검색
--RDB
-- EQUI JOIN : 동일한 컴럼을 기준으로 조인
-- NON EQUI JOIN : 동일한 컬럼없이 다른 조건을 사용하여 조인
-- OUTER JOIN : 조인 조건에 만족하지 않는 행도 나타나는 조인
-- SELF JOIN : 한 테이블에 내에서 조인
SELECT * 
    FROM EMP 
    WHERE NOT ENAME = 'SCOTT'; -- DEPTNO : 20;
SELECT * 
    FROM DEPT;
-- CROSS JOIN (FROM절에 테이블 2개 이상)
SELECT * 
    FROM EMP, DEPT 
    WHERE ENAME ='SCOTT'; -- 4행 = EMP의 1행 * DEPT의 4행
SELECT * 
FROM EMP, DEPT; -- 56행 >> EMP의 14행, DEPT의 4행



-- EQUI JOIN (공통 필드인 DEPTNO값이 일치되는 조건만 JOIN)
SELECT EMPNO, ENAME, D.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D -- AS나 ""쓰면 안된다. 
    WHERE E.DEPTNO=D.DEPTNO;
SELECT EMPNO NO, ENAME, E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO -- EMP.DEPTNO 이런거 안된다. 테이블에 별칭을 입력하면 별칭만 써야 한다.
    ORDER BY EMPNO;
-- 급여가 2000이상인 직원만 이름, 업무(JOB), 급여, 부서명, 근무지 출력
SELECT ENAME, JOB, SAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;
-- LOC이 CHICAGO인 사람의 이름, 업무, 급여를 출력
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE LOC='CHICAGO' AND E.DEPTNO=D.DEPTNO;
-- 부서번호가 10이거나 20번인 사원의 이름(ENAME),업무(JOB), 근무지(LOC). 급여순
SELECT * 
    FROM EMP, DEPT;
SELECT ENAME, JOB, LOC 
    FROM EMP, DEPT
    WHERE emp.deptno=dept.deptno AND EMP.DEPTNO IN (10,20) ORDER BY SAL;
-- JOB이 SALESMAN이거나 MANAGER인 사원의 이름, 급여, 상여, 연봉, 부서명, 근무지. 연봉이 큰 순으로 정렬
SELECT ENAME 이름, SAL 급여, COMM 상여, (SAL*12+NVL(COMM,0)) 연봉, DNAME 부서명, LOC 근무지  
    FROM EMP, DEPT
    WHERE emp.deptno = dept.deptno AND JOB IN ('SALESMAN', 'MANAGER')
    ORDER BY (SAL*12+NVL(COMM,0)) DESC;
--COMM이 NULL이고 급여가 1200이상인 사원의 이름, 급여, 입사일, 부서번호, 부서명. 부서명순, 급여큰순으로 정렬
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE e.deptno = d.deptno AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME, SAL DESC;
-- 'NEW YORK'에서 근무하는 사원의 이름과 급여 출력
SELECT ENAME, SAL 
    FROM EMP E, DEPT D
    WHERE e.deptno = d.deptno AND LOC='NEW YORK';
--  ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오
SELECT * FROM EMP, DEPT;
SELECT ENAME, HIREDATE
    FROM EMP E , DEPT D
    WHERE e.deptno = d.deptno AND DNAME='ACCOUNTING';
--  직급이 MANAGER인 사원의 이름, 부서명을 출력하시오
SELECT ENAME, DNAME
    FROM EMP E , DEPT D
    WHERE e.deptno = d.deptno AND JOB='MANAGER';
--  Comm이 null이 아닌 사원의 이름, 급여, 부서코드, 근무지를 출력하시오.
SELECT ENAME, SAL, d.deptno, LOC
    FROM EMP E , DEPT D
    WHERE e.deptno = d.deptno AND COMM IS NOT NULL;


-- NON EQUI JOIN(공통된 필드가 없을 때)
SELECT *
    FROM EMP
    WHERE ENAME = 'SCOTT';
SELECT *
    FROM SALGRADE;
SELECT * 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- 모든 사원의 사번, 이름 ,JOB, 상사사번, 급여, 급여등급(1등급, 2등급)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'등급'
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- COMM이 NULL이 아닌 사원의 이름, 급여, 급여등급, 부서번호, 부서이름, 근무지
SELECT ENAME, SAL, GRADE, DEPT.DEPTNO, DNAME, LOC
    FROM EMP, DEPT, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND EMP.DEPTNO = DEPT.DEPTNO AND COMM IS NOT NULL;
-- 이름, 급여, 입사일, 급여등급
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- 이름, 급여, 입사일, 급여등급, 부서명, 근무지
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, SALGRADE S, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO;
-- 이름, 급여 ,급여등급, 연봉(부서별 정렬, 부서가 같으면 연봉순, 연봉=(SAL*12+COMM)
SELECT ENAME, SAL, GRADE, (SAL*12+NVL(COMM,0))
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY DEPTNO, (SAL*12+NVL(COMM,0)) DESC;
-- 이름, 업무, 급여, 급여등급, 부서번호, 부서명(급여가 1000~3000사이, 부서별 ,업무별, 급여큰순 정렬)
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO AND SAL BETWEEN 1000 AND 3000
    ORDER BY E.DEPTNO, JOB, SAL DESC;
-- 이름, 급여 ,등급, 입사일, 근무지(81년에 입사한 사람만 출력. 등급 큰 순 정렬)
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO AND TO_CHAR(HIREDATE,'RRRR')=1981
    ORDER BY GRADE DESC;


-- SELF JOIN
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M;
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M WHERE W.ENAME='SMITH';
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME 
    FROM EMP W, EMP M 
    WHERE W.MGR=M.EMPNO; -- KING의 MRG이 NULL이라서 출력이 안됌
-- 'SMITH의 상사는 FORD다.' 출력
SELECT W.ENAME||'의 상사는 '||M.ENAME||'다.'
    FROM EMP W, EMP M 
    WHERE W.MGR=M.EMPNO AND W.ENAME = 'SMITH';
-- 매니저가 KING인 사원들의 이름과 직급을 출력하시오
SELECT * FROM EMP;
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';    
-- SCOTT과 동일한 부서번호에서 근무하는 사원의 이름을 출력하시오
SELECT M.ENAME
    FROM EMP W, EMP M
    WHERE W.DEPTNO=M.DEPTNO AND W.ENAME ='SCOTT' AND M.ENAME<>'SCOTT';
-- SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하시오
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
INSERT INTO EMP VALUES (9999,'홍',NULL,NULL,NULL,9000,NULL,50);
SELECT * FROM DEPT;
SELECT M.ENAME
    FROM EMP W, EMP M, DEPT DW, DEPT DM 
    WHERE W.DEPTNO = DW.DEPTNO AND M.DEPTNO= DM.DEPTNO AND DW.LOC=DM.LOC AND W.ENAME='SCOTT' AND M.ENAME<>'SCOTT';
ROLLBACK;



-- OUTER JOIN( 조인 시 조건에 만족하지 않는 행까지 나타나게 한다.)
--(+)는 한쪽에만 쓸 수 있다.

SELECT W.ENAME, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR= M.EMPNO(+);--KING도 추가됌.(MGR에는 있는데 EMPNO에는 없는걸 넣는다.)
--말단사원 리스트
SELECT W.ENAME, M.ENAME 
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO  AND W.ENAME IS NULL ORDER BY W.ENAME;
--이름, 업무, 부서코드, 부서명 (직원이 없는 부서명도 출력)
SELECT * FROM EMP;
SELECT ENAME, JOB, D.DEPTNO, DNAME
    FROM EMP E , DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO;
--이름, 업무, 부서명, 급여 (직원이 없는 부서명도 출력) 부서명순, 급여순 정렬
SELECT ENAME, JOB, D.DEPTNO, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO
    ORDER BY DNAME, SAL DESC;
    
--	다음과 같은 결과를 같은 SQL문을 작성하시오.
--FORD의 매니저는 JONES입니다.
SELECT W.ENAME ||'의 매니저는 '|| M.ENAME||'입니다.'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND W.ENAME='FORD';
--KING의 매니저는 無입니다.
SELECT W.ENAME ||'의 매니저는 '|| (NVL(M.ENAME,'無'))||'입니다.'
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+) AND W.ENAME = 'KING';
-- 사원 테이블과 부서 테이블을 조인하여 사원이름과 부서번호와 부서명을 출력하도록 합시다. 
-- 부서 테이블의 40번 부서와 조인할 사원 테이블의 부서번호가 없지만, 40번 부서의 부서 이름도 출력되도록 쿼리문을 작성해 보시오.
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO;


    

