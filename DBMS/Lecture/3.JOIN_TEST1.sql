--예제 PART1
--1. EMP테이블의 모든 사원에 대해 사원명과 직속상사명을 출력하시오.
SELECT W.ENAME 사원명, M.ENAME 직속상사명
    FROM EMP W, EMP M
    WHERE W.MGR= M.EMPNO(+);
--2. 상사가 있는 직원에 대해 사원명, 급여, 직책, 직속상사명을 출력하시오.
SELECT W.ENAME 사원명, W.SAL, W.JOB, M.ENAME 직속상사명
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--3. 상사가 없는 직원과 상사가 있는 직원들 모두에 대해 사원명, 급여, 직책, 직속상사명을 출력하시오.
SELECT W.ENAME 사원명, W.SAL, W.JOB, M.ENAME 직속상사명
    FROM EMP W, EMP M
    WHERE W.MGR= M.EMPNO(+);
--4. 상사가 있는 직원에 대해 사원명, 급여, 부서명, 직속상사명을 출력하시오.
SELECT W.ENAME 사원명, W.SAL, W.JOB, M.ENAME 직속상사명
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--5. 상사가 없는 직원과 상사가 있는 직원 모두에 대해 사원명, 급여, 부서코드, 부서명, 근무지, 직속상사명을 출력하시오. 단, 직속상사가 없을 경우 직속상사명에는 ‘없음’으로 대신 출력하시오.
SELECT W.ENAME, W.SAL, W.DEPTNO, D.DNAME, LOC, (NVL(M.ENAME,'없음')) 직속상사명
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;
--6. 급여가 2000이상인 사원에 대해 사원명, 급여, 급여등급, 부서명, 직속상사명을 출력하시오.
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, (NVL(M.ENAME,'없음')) 직속상사명
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL AND W.SAL>=2000;
--7. 상사가 있는 직원과 상사가 없는 직원 모두에 대해 사원명, 급여, 급여등급, 부서명, 직속상사명을 부서명 알파벳 순으로 정렬하여 출력하시오.
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, (NVL(M.ENAME,'없음')) 직속상사명
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL
    ORDER BY D.DNAME;
--8. 사원명, 급여, 급여등급, 부서명, 연봉, 직속상사명을 출력하시오. 단 연봉은 (SAL+COMM)*12로 계산한다.
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME,(W.SAL+NVL(W.COMM,0)*12), (NVL(M.ENAME,'없음')) 직속상사명
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL;
--9. 위 8번을 부서명 알파벳 순으로 정렬하고 부서명이 같으면 급여가 큰 사원에서 작은 사원 순으로 정렬하여 출력하시오
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME,(W.SAL+NVL(W.COMM,0)*12), (NVL(M.ENAME,'없음')) 직속상사명
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL
    ORDER BY D.DNAME, W.SAL DESC;