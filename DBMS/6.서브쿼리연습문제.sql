--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP);
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL=(SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL<=(SELECT AVG(SAL) FROM EMP);
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP E, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE S, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT') AND D.DEPTNO=E.DEPTNO;
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='BLAKE');
--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE>(SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');
--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);
--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
        AND DNAME=(SELECT DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') 
        AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT ENAME, HIREDATE
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME=(SELECT DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO AND ENAME='BLAKE');
--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL>=(SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;
-- ���⼭���ʹ� �����༭�������� �����༭������, ������ �����༭������
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;
-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�

SELECT ENAME, SAL
    FROM EMP
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING');
-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE SAL>(SELECT MIN(SAL) FROM EMP E GROUP BY DEPTNO HAVING DEPTNO=30);
-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO=10 AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);
-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE (JOB, SAL)=(SELECT JOB,SAL FROM EMP WHERE ENAME='FORD');
-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
    WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='JONES') OR SAL>=(SELECT SAL FROM EMP WHERE ENAME='FORD')
    ORDER BY JOB, SAL DESC;
-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD'); 
-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='CHICAGO');
-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL 
    FROM EMP E
    WHERE SAL>(SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING E.DEPTNO=DEPTNO);
-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT EMPNO, ENAME, SAL 
    FROM EMP E
    WHERE SAL<(SELECT AVG(SAL) FROM EMP GROUP BY JOB HAVING E.JOB=JOB);
-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP E
    WHERE EXISTS (SELECT * FROM EMP WHERE MGR= E.EMPNO)
    ORDER BY DEPTNO;
-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP E
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MGR=E.EMPNO);
