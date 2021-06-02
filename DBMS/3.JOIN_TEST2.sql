--예제PART2
--1. EMP테이블의 모든 사원에 대해 사원명, 부서번호 부서명을 출력하시오.
SELECT ENAME, EMP.DEPTNO, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
--2. EMP테이블에서 NEW YORK에서 근무하고 있는 사원에 대해 사원명, 직책, 급여, 부서명을 출력하시오.
SELECT ENAME, JOB, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND LOC='NEW YORK';
--3. EMP테이블에서 상여(COMM)를 받는 사원에 대해 사원명, 부서명, 위치를 출력하시오.
SELECT ENAME, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND COMM IS NOT NULL AND COMM<>0;
--4. EMP테이블에서 사원명에 알파벳 L이 있는 사원에 대해 사원명, 직책, 부서명, 근무지를 출력하시오.
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO AND ENAME LIKE '%L%';
--5. EMP테이블에서 사번, 사원명, 부서번호, 부서명을 출력하되 사원명 알파벳 순으로 출력하시오.
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;
--6. 급여가 2000이상인 사원에 대해 사번, 사원명, 급여, 부서명을 급여기준으로 내림차순 정렬하여 출력하시오.
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000
    ORDER BY SAL DESC;
--7. 직책이 MANAGER이며 급여가 2500이상인 사원에 대해 사번, 사원명, 직책, 급여, 부서명을 사번기준으로 모름차순 정렬하여 출력하시오.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2500 AND JOB='MANAGER'
    ORDER BY EMPNO;
--8. 사번, 사원명, 직책, 급여, 급여등급을 급여기준으로 내림차순 정렬하여 출력하시오
SELECT EMPNO, ENAME, JOB, SAL , GRADE
    FROM EMP E, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
--9. 상사가 없는 직원과 상사가 있는 직원 모두에 대해, 사원명, 직속상사명을 출력하시오.
SELECT W.ENAME 사원명, M.ENAME 직속상사명
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--10.상사가 없는 직원과 상사가 있는 직원 모두에 대해, 사원명, 상사명, 상사의 상사명을 출력하시오
SELECT W.ENAME 사원명, M.ENAME 상사명, MM.ENAME "상사의 상사명"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO(+) AND M.MGR=MM.EMPNO(+);