--[II] SELECT �� - �˻���
SELECT * FROM TAB; -- SCOTT�� ������ �ִ� ���̺�
SELECT * FROM DEPT; -- DEPT ���̺��� ��� ��(�ʵ�), ��� ��
SELECT * FROM EMP;
--DEPT ���̺��� ����
DESC DEPT;
-- 2. SQL�� ����(Ư�� �ʵ常 ���)
SELECT ENAME,DEPTNO FROM EMP;
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�",JOB AS "��å" FROM EMP;--��Ī
SELECT EMPNO AS ���, ENAME AS �̸�, SAL AS �޿�,JOB AS ��å FROM EMP;--��Ī
SELECT EMPNO ���, ENAME �̸�, SAL �޿�,JOB ��å FROM EMP;--��Ī
SELECT EMPNO "�� ��", ENAME "�� ��", SAL "�� ��",JOB "�� å" FROM EMP;--��Ī
SELECT EMPNO NO, ENAME NAME, SAL SALARY,JOB JOB FROM EMP;--��Ī
-- 3. WHERE��(����); �񱳿����� �̿�
SELECT EMPNO "���" , ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL = 3000;
SELECT EMPNO "���" , ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL != 3000; -- != <> ^= "�ٸ���"
SELECT * FROM EMP WHERE DEPTNO=10;
--�̸��� FORD�� ������ EMPNO. ENAME,MGR�� ���
SELECT EMPNO, ENAME,MGR FROM EMP WHERE ENAME='SMITH';
-- 4. �� ������
SELECT * FROM EMP WHERE SAL BETWEEN 2500 AND 3000;
-- �񱳿����� ����,����,DATE�� �ʵ� ��� �����ϴ�.
-- ����� �̸�(ENAME)�� 'A','B','C'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME<'D';
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
DESC EMP;
--5. ��¥ ǥ��� ����(���� : RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT ENAME, JOB, HIREDATE FROM EMP 
WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD') AND TO_DATE('1981/05/01')
ORDER BY HIREDATE;

SELECT *FROM EMP WHERE TO_CHAR(HIREDATE,'RRRR')=1982;

SELECT HIREDATE FROM EMP;
--������ 24000 �̻��� ������ ENAME, SAL, ���� ���(���� = SAL*12)
SELECT ENAME, SAL, SAL*12 ���� FROM EMP WHERE SAL*12>=24000 ORDER BY ����;
--�۵� ���� FROM -> WHERE -> SELECT -> ORDER BY
SELECT * FROM EMP WHERE DEPTNO=10 AND JOB='MANAGER';
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
SELECT * FROM EMP WHERE DEPTNO<>10;
SELECT ENAME, SAL, COMM FROM EMP;
SELECT ENAME, SAL, NVL(COMM,0) FROM EMP; --NVL(A,B) A�� B�� ���� Ÿ���̾�� ��. 
SELECT ENAME, COMM, NVL(COMM,0) ��, COMM+1 FROM EMP; -- ��+100�� �ٷ� ������ �ȉ�.
--6. ���Ῥ����(||)
SELECT ENAME ||' ��(��) '|| JOB ||' �̴�.' "EMPLOYEES" FROM EMP;
--7. �ߺ�����
SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;
--8. SQL������(BETWEEN, IN, LIKE, IS NULL)
    --(1)BETWEEN
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
    --��� �̸��� 'B','C'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME != 'D';
    --(2)IN
    --�μ���ȣ�� 10,20,40�μ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20 OR DEPTNO = 40;
SELECT * FROM EMP WHERE NOT  (DEPTNO = 10 OR DEPTNO = 20 OR DEPTNO = 40);
SELECT * FROM EMP WHERE DEPTNO IN (10, 20, 40);
    --�μ���ȣ�� 10,20,40�� �μ��� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
    --(3) LIKE ����
    --�̸��� M���� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
    --�̸��� N�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%';
    --�̸��� S�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';



INSERT INTO EMP VALUES (9999,'LISA%',NULL,NULL,NULL,9000,9000,40);
 --�̸��� %�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
ROLLBACK;--DML(������ ���۾�)�� ���





    --SAL�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';
    --82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
    --1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
    --82�⵵�� �ƴ� �⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';
    --(4) IS NULL
    --�󿩱��� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL;
    --�󿩱��� �ִ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM!=0;
    --9.����(��������,��������)
SELECT ENAME ,SAL FROM EMP ORDER BY SAL; -- �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; -- �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY HIREDATE; --�Ի� ������ ����
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE DESC;
    --�̸�, ����(SAL*12+COMM)�� ���(������ ���� ������, ������ ���� ��� �̸�������)
SELECT ENAME �̸�, (SAL*12+NVL(COMM,0)) ���� FROM EMP ORDER BY ���� DESC, �̸�;
    --���, �̸�, SAL ���(�μ���, �μ��� ������ �Ի��ϼ����� ����
SELECT EMPNO, ENAME, HIREDATE, SAL FROM EMP ORDER BY DEPTNO,HIREDATE; 

--EX
SELECT * FROM EMP;
SHOW USER;
SELECT * FROM TAB;
SELECT EMPNO ���, ENAME �̸�, SAL �޿�,JOB ����, HIREDATE �Ի��� FROM EMP;
SELECT EMPNO ���, ENAME �̸�, SAL �޿� FROM EMP WHERE SAL<2000;
SELECT EMPNO ���, ENAME �̸�, JOB ����, HIREDATE �Ի��� FROM EMP WHERE HIREDATE>'81/02/28';
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
SELECT EMPNO ���, ENAME �̸�, SAL �޿� FROM EMP WHERE SAL<=3000 AND SAL>=1500;
SELECT EMPNO ���, ENAME �̸�, JOB ����, DEPTNO �μ��ڵ� FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
SELECT EMPNO ���, ENAME �̸�, JOB ����, DEPTNO �μ��ڵ� FROM EMP WHERE SAL>=3000 OR JOB = 'SALESMAN';
SELECT  EMPNO ���, ENAME �̸�, JOB ����, SAL �޿� FROM EMP WHERE SAL>=2500 AND JOB = 'MANAGER';
-- ������ ���� �켱������ �����Ͽ� (SAL*12+NVL(COMM,0))ó�� ��ȣ�� �ִ´�.
SELECT ENAME ||'�� '|| JOB ||' �����̰� ������ '|| (SAL*12+NVL(COMM,0)) ||'��.' AS "��Ÿ��" FROM EMP;
