SELECT * FROM EMP;
--1. 사원 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;
--2. 사원테이블에서 업무별 인원수를 구하여 출력
SELECT COUNT(*)
    FROM EMP
    GROUP BY JOB;
--3. 사원테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL)-MIN(SAL)
    FROM EMP;
--4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력하되 급여의 합이 많은 순으로 출력
SELECT COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
--5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의합을 구하여 출력하라(출력결과는 부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;
--6. 업무별, 부서별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의합을 구하여 출력하라.(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;
--7. 사원수가 5명이상 넘는 부서번호와 사원수 출력
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=5;
--8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(*)
    FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*)>=5;
--9. 사원 테이블에서 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 구하여 출력
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL)>=3000;
--10. 사원테이블에서 전체 급여가 5000을 초과하는 각 업무에 대해서 업무와 급여합계를 출력하라 단, 급여 합계로 내림차순 정렬
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL)>5000;
--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT AVG(SAL), SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;
--12. 위의 11번에서 나온, 부서별 급여평균들 최대치, 부서별 급여합들의 최대치, 부서별 최소급여들의 최대치를 출력하라
SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;
--13. 사원 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.
SELECT TO_CHAR(HIREDATE,'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YY')
    ORDER BY TO_CHAR(HIREDATE,'YY');
--14. 사원 테이블에서 아래의 결과를 출력하는 SELECT 문 작성
SELECT NVL(TO_CHAR(HIREDATE,'YYYY'),'TOTAL') H_YEAR, COUNT(*)
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'))
    ORDER BY TO_CHAR(HIREDATE,'YYYY');
--15. 사원테이블에서 최대급여, 최소급여, 전체급여합, 평균을 구하시오
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL)
    FROM EMP;
--16. 사원테이블에서 부서별 인원수를 구하시오
SELECT COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;
--17. 사원 테이블에서 부서별 인원수가 6명이상인 부서코드를 구하시오
SELECT DEPTNO
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=6;
--18. 사원테이블에서 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. (힌트 self join, outer join, group by, count사용)
SELECT W.ENAME, COUNT(M.ENAME) 등수
    FROM EMP W, EMP M
    WHERE W.SAL<M.SAL OR W.ENAME=M.ENAME
    GROUP BY W.ENAME
    HAVING COUNT(M.ENAME)<=4
    ORDER BY COUNT(M.ENAME);
--18. 사원테이블에서 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. (힌트 self join, outer join, group by, count사용)
SELECT W.ENAME, COUNT(M.ENAME)+1 등수
    FROM EMP W, EMP M
    WHERE W.SAL<M.SAL(+)
    GROUP BY W.ENAME
    HAVING COUNT(M.ENAME)<=3
    ORDER BY COUNT(M.ENAME);    
--18. 사원테이블에서 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. (힌트 self join, outer join, group by, count사용)
SELECT ENAME, 
        RANK() OVER(ORDER BY SAL DESC),
        DENSE_RANK() OVER(ORDER BY SAL DESC),
        ROW_NUMBER() OVER(ORDER BY SAL DESC)
    FROM EMP;
    