SELECT * FROM EMP;
--1. ��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;
--2. ������̺��� ������ �ο����� ���Ͽ� ���
SELECT COUNT(*)
    FROM EMP
    GROUP BY JOB;
--3. ������̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL)-MIN(SAL)
    FROM EMP;
--4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� �޿��� ���� ���� ������ ���
SELECT COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
--5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿������� ���Ͽ� ����϶�(��°���� �μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;
--6. ������, �μ��� �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿������� ���Ͽ� ����϶�.(��°���� ������, �μ���ȣ �� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;
--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ����� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=5;
--8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*)
    FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*)>=5;
--9. ��� ���̺��� ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���Ͽ� ���
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL)>=3000;
--10. ������̺��� ��ü �޿��� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ����϶� ��, �޿� �հ�� �������� ����
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL)>5000;
--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT AVG(SAL), SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;
--12. ���� 11������ ����, �μ��� �޿���յ� �ִ�ġ, �μ��� �޿��յ��� �ִ�ġ, �μ��� �ּұ޿����� �ִ�ġ�� ����϶�
SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;
--13. ��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT TO_CHAR(HIREDATE,'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'YY')
    ORDER BY TO_CHAR(HIREDATE,'YY');
--14. ��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�
SELECT NVL(TO_CHAR(HIREDATE,'YYYY'),'TOTAL') H_YEAR, COUNT(*)
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'))
    ORDER BY TO_CHAR(HIREDATE,'YYYY');
--15. ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL)
    FROM EMP;
--16. ������̺��� �μ��� �ο����� ���Ͻÿ�
SELECT COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;
--17. ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�
SELECT DEPTNO
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=6;
--18. ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. (��Ʈ self join, outer join, group by, count���)
SELECT W.ENAME, COUNT(M.ENAME) ���
    FROM EMP W, EMP M
    WHERE W.SAL<M.SAL OR W.ENAME=M.ENAME
    GROUP BY W.ENAME
    HAVING COUNT(M.ENAME)<=4
    ORDER BY COUNT(M.ENAME);
--18. ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. (��Ʈ self join, outer join, group by, count���)
SELECT W.ENAME, COUNT(M.ENAME)+1 ���
    FROM EMP W, EMP M
    WHERE W.SAL<M.SAL(+)
    GROUP BY W.ENAME
    HAVING COUNT(M.ENAME)<=3
    ORDER BY COUNT(M.ENAME);    
--18. ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. (��Ʈ self join, outer join, group by, count���)
SELECT ENAME, 
        RANK() OVER(ORDER BY SAL DESC),
        DENSE_RANK() OVER(ORDER BY SAL DESC),
        ROW_NUMBER() OVER(ORDER BY SAL DESC)
    FROM EMP;
    