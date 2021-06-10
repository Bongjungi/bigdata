--[V] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV, VARIANCE
SELECT ENAME, ROUND(SAL, -3)
    FROM EMP;
SELECT MAX(SAL) 
    FROM EMP;
--SELECT ENAME, MAX(SAL) FROM EMP; --> VI�� ������������ �ذ�    
SELECT DEPTNO, MAX(SAL) 
    FROM EMP 
    GROUP BY DEPTNO;
-- 1. �׷��Լ��� �ǽ�
SELECT ROUND(AVG(SAL),2) 
    FROM EMP;
SELECT COUNT(*) 
    FROM EMP; -- EMP���̺��� ��(ROW)��
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) 
    FROM EMP;
SELECT AVG(COMM), SUM(COMM), COUNT(COMM), SUM(COMM)/COUNT(COMM)
    FROM EMP;
-- SAL�� ���, ��, �ּҰ�, �ִ밪, �л�, ǥ������
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), ROUND(VARIANCE(SAL)), ROUND(STDDEV(SAL)), ROUND(SQRT(VARIANCE(SAL)))
    FROM EMP;
-- �׷��Լ� MAX, MIN, COUNT�� ������, ������, ��¥�� ��� ��밡��.
--  ���� �ֱٿ� �Ի��� ����� �Ի��ϰ� �Ի����� ���� ������ ����� �Ի���
SELECT HIREDATE
    FROM EMP
    WHERE HIREDATE='83/01/12' OR HIREDATE='80/12/17';
 -- WHERE HIREDATE=MAX(HIREDATE) OR HIREDATE = MIN(HIREDATE);�ȉ�
SELECT MAX(HIREDATE)||' �ֱ� �Ի� : '||TO_CHAR(MIN(TRUNC((SYSDATE-HIREDATE))),'99,999')|| '�� �ٹ�, '|| MIN(HIREDATE)||' �����Ի� :' ||TO_CHAR(MAX(TRUNC((SYSDATE-HIREDATE))),'99,999')||'�� �ٹ�'
    FROM EMP;
--10�� �μ� �Ҽ��� ��� �޿� ���
SELECT AVG(SAL)
    FROM EMP
    WHERE DEPTNO=10;
    
-- 2. GROUP BY ��
--�μ���ȣ�� �ִ�޿�
SELECT DEPTNO, MAX(SAL)
    FROM EMP 
    GROUP BY DEPTNO;
--�μ���ȣ�� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�(�Ҽ��� 2�ڸ�)
SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)
    FROM EMP
    GROUP BY DEPTNO;
--SAL�� 5000�̸��� ����� ���ؼ��� �μ���ȣ�� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�
SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)
    FROM EMP
    WHERE SAL<5000
    GROUP BY DEPTNO;
-- �μ��� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�
SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;
--3. HAVING ��
--�μ���ȣ�� ��� �޿�(��ձ޿��� 2000�̻��� �μ��� ���)
SELECT DEPTNO, AVG(SAL) 
    FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL)>=2000; --�ʵ��� ��Ī�� ORDER BY �������� ��� ����(HAVING������ ����.)
SELECT DEPTNO,SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO;
SELECT DEPTNO,SUM(SAL)
    FROM EMP
    GROUP BY ROLLUP(DEPTNO); --ROLLUP �׷캰�� ����Ͽ� ���
SELECT DEPTNO, JOB, SUM(SAL) 
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO;
SELECT DEPTNO, JOB, SUM(SAL) 
    FROM EMP
    GROUP BY ROLLUP(DEPTNO, JOB);