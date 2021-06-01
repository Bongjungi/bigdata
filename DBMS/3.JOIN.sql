--[III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�
--RDB
SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- DEPTNO : 20;
SELECT * FROM DEPT;
-- CROSS JOIN (FROM���� ���̺� 2�� �̻�)
SELECT * FROM EMP, DEPT WHERE ENAME ='SCOTT'; -- 4�� = EMP�� 1�� * DEPT�� 4��
SELECT * FROM EMP, DEPT; -- 56�� >> EMP�� 14��, DEPT�� 4��
-- EQUI JOIN (���� �ʵ��� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)
SELECT EMPNO, ENAME, D.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D -- AS�� ""���� �ȵȴ�. 
    WHERE E.DEPTNO=D.DEPTNO;

SELECT EMPNO NO, ENAME, E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO -- EMP.DEPTNO �̷��� �ȵȴ�. ���̺� ��Ī�� �Է��ϸ� ��Ī�� ��� �Ѵ�.
    ORDER BY EMPNO;

-- �޿��� 2000�̻��� ������ �̸�, ����(JOB), �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;
-- LOC�� CHICAGO�� ����� �̸�, ����, �޿��� ���
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE LOC='CHICAGO' AND E.DEPTNO=D.DEPTNO;
