--���� PART1
--1. EMP���̺��� ��� ����� ���� ������ ���ӻ����� ����Ͻÿ�.
SELECT W.ENAME �����, M.ENAME ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR= M.EMPNO(+);
--2. ��簡 �ִ� ������ ���� �����, �޿�, ��å, ���ӻ����� ����Ͻÿ�.
SELECT W.ENAME �����, W.SAL, W.JOB, M.ENAME ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--3. ��簡 ���� ������ ��簡 �ִ� ������ ��ο� ���� �����, �޿�, ��å, ���ӻ����� ����Ͻÿ�.
SELECT W.ENAME �����, W.SAL, W.JOB, M.ENAME ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR= M.EMPNO(+);
--4. ��簡 �ִ� ������ ���� �����, �޿�, �μ���, ���ӻ����� ����Ͻÿ�.
SELECT W.ENAME �����, W.SAL, W.JOB, M.ENAME ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--5. ��簡 ���� ������ ��簡 �ִ� ���� ��ο� ���� �����, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ����� ����Ͻÿ�. ��, ���ӻ�簡 ���� ��� ���ӻ����� ������������ ��� ����Ͻÿ�.
SELECT W.ENAME, W.SAL, W.DEPTNO, D.DNAME, LOC, (NVL(M.ENAME,'����')) ���ӻ���
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;
--6. �޿��� 2000�̻��� ����� ���� �����, �޿�, �޿����, �μ���, ���ӻ����� ����Ͻÿ�.
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, (NVL(M.ENAME,'����')) ���ӻ���
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL AND W.SAL>=2000;
--7. ��簡 �ִ� ������ ��簡 ���� ���� ��ο� ���� �����, �޿�, �޿����, �μ���, ���ӻ����� �μ��� ���ĺ� ������ �����Ͽ� ����Ͻÿ�.
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, (NVL(M.ENAME,'����')) ���ӻ���
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL
    ORDER BY D.DNAME;
--8. �����, �޿�, �޿����, �μ���, ����, ���ӻ����� ����Ͻÿ�. �� ������ (SAL+COMM)*12�� ����Ѵ�.
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME,(W.SAL+NVL(W.COMM,0)*12), (NVL(M.ENAME,'����')) ���ӻ���
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL;
--9. �� 8���� �μ��� ���ĺ� ������ �����ϰ� �μ����� ������ �޿��� ū ������� ���� ��� ������ �����Ͽ� ����Ͻÿ�
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME,(W.SAL+NVL(W.COMM,0)*12), (NVL(M.ENAME,'����')) ���ӻ���
    FROM EMP W, EMP M, SALGRADE S, DEPT D
    WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN S.LOSAL AND S.HISAL
    ORDER BY D.DNAME, W.SAL DESC;