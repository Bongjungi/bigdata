--[VI] SUB QUERY; QUERY�ȿ� QUERY�� ����
-- 1. ���� ���� ����
-- ������ ���� ������ F9Ű ������ �װ͸� �����. 
-- �޿��� ���� ���� �޴� ����� �̸��� �޿�
SELECT ENAME, MAX(SAL) 
    FROM EMP 
    GROUP BY ENAME; --���ǹ�
SELECT ENAME, SAL --��������
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP);--��������(������ ����)  -- �ݵ�� ��ȣ�� ���ξ� �Ѵ�.
--���������� ���� : (1) �����༭������(������) = > >= < <= <> .............. 
--                (2) �����༭������(2���̻�)
--	SCOTT�� ���� �μ����� �ٹ��ϴ� ����� �̸��� �μ���ȣ�� ���
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');
-- JOB�� �Ŵ����� ����� �μ��̸�
SELECT DNAME
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'); --DEPTNO IN (10,20,30) ���������� �������� ������ IN�����ڸ� ��� �Ѵ�.
INSERT INTO DEPT VALUES (50,'IT','DALLAS'); --50 �⺻Ű
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'ȫ',50);-- 50�ڸ����� ��������(S DEPTNO F W) �� �� ����.
-- SCOTT�� ���� �ٹ����� ����� �̸��� �޿�
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC=(SELECT LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT');
ROLLBACK;
-- SCOTT�� ������ ��å�� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');
-- ���߿���������
--SCOTT �� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ� ���
SELECT *
    FROM EMP
    WHERE (JOB,DEPTNO)=(SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT');
-- �����༭������ : IN ALL ANY(SOME) EXISTS
SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO,HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
    
SELECT * 
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30);
SELECT * 
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30); 
--���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE EXISTS (SELECT * FROM EMP WHERE E.EMPNO=MGR);
--EX1. ������ MANAGER�� ����� ���� �μ��� �μ���ȣ�� ������
SELECT DISTINCT D.DEPTNO, D.LOC
    FROM DEPT D
    WHERE D.DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'); 
--EX2. ������ 3000�̻��� ����� �� ������޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿����
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP E, SALGRADE S
    WHERE SAL BETWEEN LOSAL AND HISAL 
        AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000 GROUP BY GRADE);
--EX3. �Ի� �б⺰ �ְ������ �޴� ����� �б�, ���, �̸�, JOB, �����, �Ի�, �޿�, ��
SELECT  CEIL(TO_CHAR(HIREDATE,'MM')/3), EMPNO, ENAME, JOB, MGR, HIREDATE, SAL ,COMM
    FROM EMP
    WHERE (CEIL(TO_CHAR(HIREDATE,'MM')/3),SAL) IN (SELECT CEIL(TO_CHAR(HIREDATE,'MM')/3),MAX(SAL) FROM EMP GROUP BY CEIL(TO_CHAR(HIREDATE,'MM')/3));
--EX4. SALESMAN�� ��� ����麸�� �޿��� ���� �޴� ����� �̸�, �޿�    (ALL)
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL>ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');
--EX5. �޿��� 3000�̸��� ����� �ֱ� �Ի��� ����� ���, �̸�,����, �Ի���
SELECT EMPNO, ENAME, SAL*12+NVL(COMM,0), HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);