--[III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�
--RDB
-- EQUI JOIN : ������ �ķ��� �������� ����
-- NON EQUI JOIN : ������ �÷����� �ٸ� ������ ����Ͽ� ����
-- OUTER JOIN : ���� ���ǿ� �������� �ʴ� �൵ ��Ÿ���� ����
-- SELF JOIN : �� ���̺� ������ ����
SELECT * 
    FROM EMP 
    WHERE NOT ENAME = 'SCOTT'; -- DEPTNO : 20;
SELECT * 
    FROM DEPT;
-- CROSS JOIN (FROM���� ���̺� 2�� �̻�)
SELECT * 
    FROM EMP, DEPT 
    WHERE ENAME ='SCOTT'; -- 4�� = EMP�� 1�� * DEPT�� 4��
SELECT * 
FROM EMP, DEPT; -- 56�� >> EMP�� 14��, DEPT�� 4��



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
-- �μ���ȣ�� 10�̰ų� 20���� ����� �̸�(ENAME),����(JOB), �ٹ���(LOC). �޿���
SELECT * 
    FROM EMP, DEPT;
SELECT ENAME, JOB, LOC 
    FROM EMP, DEPT
    WHERE emp.deptno=dept.deptno AND EMP.DEPTNO IN (10,20) ORDER BY SAL;
-- JOB�� SALESMAN�̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����, �μ���, �ٹ���. ������ ū ������ ����
SELECT ENAME �̸�, SAL �޿�, COMM ��, (SAL*12+NVL(COMM,0)) ����, DNAME �μ���, LOC �ٹ���  
    FROM EMP, DEPT
    WHERE emp.deptno = dept.deptno AND JOB IN ('SALESMAN', 'MANAGER')
    ORDER BY (SAL*12+NVL(COMM,0)) DESC;
--COMM�� NULL�̰� �޿��� 1200�̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ���. �μ����, �޿�ū������ ����
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE e.deptno = d.deptno AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME, SAL DESC;
-- 'NEW YORK'���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT ENAME, SAL 
    FROM EMP E, DEPT D
    WHERE e.deptno = d.deptno AND LOC='NEW YORK';
--  ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT * FROM EMP, DEPT;
SELECT ENAME, HIREDATE
    FROM EMP E , DEPT D
    WHERE e.deptno = d.deptno AND DNAME='ACCOUNTING';
--  ������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME
    FROM EMP E , DEPT D
    WHERE e.deptno = d.deptno AND JOB='MANAGER';
--  Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, d.deptno, LOC
    FROM EMP E , DEPT D
    WHERE e.deptno = d.deptno AND COMM IS NOT NULL;


-- NON EQUI JOIN(����� �ʵ尡 ���� ��)
SELECT *
    FROM EMP
    WHERE ENAME = 'SCOTT';
SELECT *
    FROM SALGRADE;
SELECT * 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- ��� ����� ���, �̸� ,JOB, �����, �޿�, �޿����(1���, 2���)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'���'
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- COMM�� NULL�� �ƴ� ����� �̸�, �޿�, �޿����, �μ���ȣ, �μ��̸�, �ٹ���
SELECT ENAME, SAL, GRADE, DEPT.DEPTNO, DNAME, LOC
    FROM EMP, DEPT, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND EMP.DEPTNO = DEPT.DEPTNO AND COMM IS NOT NULL;
-- �̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- �̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, SALGRADE S, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO;
-- �̸�, �޿� ,�޿����, ����(�μ��� ����, �μ��� ������ ������, ����=(SAL*12+COMM)
SELECT ENAME, SAL, GRADE, (SAL*12+NVL(COMM,0))
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY DEPTNO, (SAL*12+NVL(COMM,0)) DESC;
-- �̸�, ����, �޿�, �޿����, �μ���ȣ, �μ���(�޿��� 1000~3000����, �μ��� ,������, �޿�ū�� ����)
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO AND SAL BETWEEN 1000 AND 3000
    ORDER BY E.DEPTNO, JOB, SAL DESC;
-- �̸�, �޿� ,���, �Ի���, �ٹ���(81�⿡ �Ի��� ����� ���. ��� ū �� ����)
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO AND TO_CHAR(HIREDATE,'RRRR')=1981
    ORDER BY GRADE DESC;


-- SELF JOIN
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M;
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M WHERE W.ENAME='SMITH';
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME 
    FROM EMP W, EMP M 
    WHERE W.MGR=M.EMPNO; -- KING�� MRG�� NULL�̶� ����� �ȉ�
-- 'SMITH�� ���� FORD��.' ���
SELECT W.ENAME||'�� ���� '||M.ENAME||'��.'
    FROM EMP W, EMP M 
    WHERE W.MGR=M.EMPNO AND W.ENAME = 'SMITH';
-- �Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�
SELECT * FROM EMP;
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';    
-- SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT M.ENAME
    FROM EMP W, EMP M
    WHERE W.DEPTNO=M.DEPTNO AND W.ENAME ='SCOTT' AND M.ENAME<>'SCOTT';
-- SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
INSERT INTO EMP VALUES (9999,'ȫ',NULL,NULL,NULL,9000,NULL,50);
SELECT * FROM DEPT;
SELECT M.ENAME
    FROM EMP W, EMP M, DEPT DW, DEPT DM 
    WHERE W.DEPTNO = DW.DEPTNO AND M.DEPTNO= DM.DEPTNO AND DW.LOC=DM.LOC AND W.ENAME='SCOTT' AND M.ENAME<>'SCOTT';
ROLLBACK;



-- OUTER JOIN( ���� �� ���ǿ� �������� �ʴ� ����� ��Ÿ���� �Ѵ�.)
--(+)�� ���ʿ��� �� �� �ִ�.

SELECT W.ENAME, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR= M.EMPNO(+);--KING�� �߰���.(MGR���� �ִµ� EMPNO���� ���°� �ִ´�.)
--���ܻ�� ����Ʈ
SELECT W.ENAME, M.ENAME 
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO  AND W.ENAME IS NULL ORDER BY W.ENAME;
--�̸�, ����, �μ��ڵ�, �μ��� (������ ���� �μ��� ���)
SELECT * FROM EMP;
SELECT ENAME, JOB, D.DEPTNO, DNAME
    FROM EMP E , DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO;
--�̸�, ����, �μ���, �޿� (������ ���� �μ��� ���) �μ����, �޿��� ����
SELECT ENAME, JOB, D.DEPTNO, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO
    ORDER BY DNAME, SAL DESC;
    
--	������ ���� ����� ���� SQL���� �ۼ��Ͻÿ�.
--FORD�� �Ŵ����� JONES�Դϴ�.
SELECT W.ENAME ||'�� �Ŵ����� '|| M.ENAME||'�Դϴ�.'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND W.ENAME='FORD';
--KING�� �Ŵ����� ���Դϴ�.
SELECT W.ENAME ||'�� �Ŵ����� '|| (NVL(M.ENAME,'��'))||'�Դϴ�.'
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+) AND W.ENAME = 'KING';
-- ��� ���̺�� �μ� ���̺��� �����Ͽ� ����̸��� �μ���ȣ�� �μ����� ����ϵ��� �սô�. 
-- �μ� ���̺��� 40�� �μ��� ������ ��� ���̺��� �μ���ȣ�� ������, 40�� �μ��� �μ� �̸��� ��µǵ��� �������� �ۼ��� ���ÿ�.
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO;


    

