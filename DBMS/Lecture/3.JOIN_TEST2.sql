--����PART2
--1. EMP���̺��� ��� ����� ���� �����, �μ���ȣ �μ����� ����Ͻÿ�.
SELECT ENAME, EMP.DEPTNO, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
--2. EMP���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���� �����, ��å, �޿�, �μ����� ����Ͻÿ�.
SELECT ENAME, JOB, SAL, DNAME
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND LOC='NEW YORK';
--3. EMP���̺��� ��(COMM)�� �޴� ����� ���� �����, �μ���, ��ġ�� ����Ͻÿ�.
SELECT ENAME, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO AND COMM IS NOT NULL AND COMM<>0;
--4. EMP���̺��� ����� ���ĺ� L�� �ִ� ����� ���� �����, ��å, �μ���, �ٹ����� ����Ͻÿ�.
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO AND ENAME LIKE '%L%';
--5. EMP���̺��� ���, �����, �μ���ȣ, �μ����� ����ϵ� ����� ���ĺ� ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;
--6. �޿��� 2000�̻��� ����� ���� ���, �����, �޿�, �μ����� �޿��������� �������� �����Ͽ� ����Ͻÿ�.
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000
    ORDER BY SAL DESC;
--7. ��å�� MANAGER�̸� �޿��� 2500�̻��� ����� ���� ���, �����, ��å, �޿�, �μ����� ����������� ������ �����Ͽ� ����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2500 AND JOB='MANAGER'
    ORDER BY EMPNO;
--8. ���, �����, ��å, �޿�, �޿������ �޿��������� �������� �����Ͽ� ����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL , GRADE
    FROM EMP E, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
--9. ��簡 ���� ������ ��簡 �ִ� ���� ��ο� ����, �����, ���ӻ����� ����Ͻÿ�.
SELECT W.ENAME �����, M.ENAME ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--10.��簡 ���� ������ ��簡 �ִ� ���� ��ο� ����, �����, ����, ����� ������ ����Ͻÿ�
SELECT W.ENAME �����, M.ENAME ����, MM.ENAME "����� ����"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO(+) AND M.MGR=MM.EMPNO(+);