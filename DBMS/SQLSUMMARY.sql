--FROM -WHERE-GROUP BY -HANING -SELECT -ORDER BY �� ����
--ROLLBACK - DML ���
--COMMIT - DML ����
-- SELECT 1+1 FROM DUAL;
-- SELECT (DISTINCT) (��Ī1).�ʵ�1 (AS �ʵ庰Ī), NVL(12*�ʵ�2,0), SUM(�ʵ�),  ... 
   -- FROM ���̺�1 (��Ī1), ���̺�2 (��Ī2),...
   -- WHERE ��������1(��Ī1.�ʵ�=��Ī2.�ʵ�(+)), ���� AND (BETWEEN 1 AND 2) OR IN(10,20) 
   -- AND LIKE '%M%' OR LIKE '_M_' AND �ʵ� IS NOT NULL
   -- GROUP BY �ʵ�
   -- HAVING ����
   -- ORDER BY �ʵ� ASC, �ʵ� DESC;
--ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';            --�ý��� ��¥ ���� ����
--SELECT ENAME ||' ��(��) '|| JOB ||' �̴�.' "EMPLOYEES" FROM EMP; -- ���Ῥ���� '||'

--4.�������Լ�, 5. �׷��Լ� ����

-- SELECT �ʵ�� ... FROM ... WHERE �ʵ�� =,>,!= (SELECT �ʵ�� FROM ���̺� WHERE ����); - �����༭������
-- SELECT �ʵ�� ... FROM ... WHERE (�ʵ��1, �ʵ��2) = (SELECT (�ʵ��1, �ʵ��2) FROM ���̺� WHERE ����);
-- SELECT �ʵ�� ... FROM ... WHERE �ʵ�� IN(-�ȿ��ִ���),ALL(-���θ����ϴ���),ANY(-�ϳ��󵵸����ϴ���),SOME(-ANY) (SELECT �ʵ�� FROM ���̺� WHERE ����); -�����༭������
-- SELECT �ʵ�� ... FROM ... WHERE EXISTS(-������ TRUE�ΰ��� �����ϴ���) (SELECT �ʵ�� FROM ���̺� WHERE ����);


--------------------------------------------------------------------------------------------------------------------------------
-- DDL(���̺� ����, ���̺� ����, ���̺�������, ���̺� ��� ������ ����)
-- DML(SELECT, INSERT, UPDATE, DELETE) - ������� ����
-- DCL(����ڰ�������, ����ڿ��� ���Ѻο�, ���ѹ�Ż, ����ڰ�������, Ʈ����� ��ɾ�)
-- EXERD ������ ȭ��ǥ�� �⺻Ű�ʵ带 �ٸ� ���̺� ��ӽ�ų��,
--      �Ķ��� ȭ��ǥ�� ���ο� �ʵ带 ����� ���踦 ���� �����.

--CREATE TABLE ���̺�� ( ���� ���� ����, ���� ���� ����,...);
--ALTER ���̺�� ADD ���� ���� ����                (���� �߰�)
--ALTER ���̺�� MODIFY ���� ����                 (���� ��ȯ)
--ALTER ���̺�� DROP COLUMN �ʵ��                (�ʵ� ����)
--ALTER ���̺�� SET UNUSED �ʵ��                 (�̿� �Ұ�)
--ALTER ���̺�� DROP UNUSED COLUMNS              (�̿� �Ұ� �ʵ� ����)
--DROP TABLE ���̺��                                   (���̺� ����)
--TRUNCATE TABLE ���̺��                                (���̺� ���� �ʵ� ����)
--RENAME ���̺��1 TO ���̺��2                   (���̺��1�� ���̺��2�� �̸� �ٲ�)

--INSERT INTO ���̺�� ( ���� ) VALUE (��)
--INSERT INTO ���̺�� (��������)
--UPDATE ���̺�� SET ���ϴ¹� WHERE ������ �ʵ��� ����
--SELECT ���� FROM ���̺�� WHERE ����
--DELETE FROM ���̺�� WHERE ����

-- ������ ��ųʸ�(����� ���� �Ұ�) VS ������ ��ųʸ� ��(����� ���� ����)
-- ���� ����
-- USER_XXX : �� ������ �����ϰ� �ִ� ��ü(���̺�, ��, �ε���, ��������...)
    -- USER_TABLES, USER_INDEXS, USER_CONSTRAINTS, USER_VIEWS
-- ALL_XXX : �� ������ ���� ������ ��ü
    -- ALL_TABLES, ALL_INDEXS, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA(EX. scott)�� ���ٰ���. DBMS�� ��� ��ü
    -- DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
--SELECT * FROM USER_TABLE                  (�� ������ ������ ���̺� ��ü)
--SELECT * FROM ALL_INDEXS                   (���� ���ٰ����� �ε��� ��ü)
--SELECT * FROM DBA_CONSTRAINTS                   (DBA�� ������ �������ǵ�)

--CREATE USER smith IDENTIFIED BY tiger;      -- smith ���� ����
-- ���� �ο�(���Ǳ���, scott.emp, scott.dept�� ���� ��� ����)
--GRANT CREATE SESSION TO smith; -- GRANT DBA TO scott;
--GRANT ALL ON EMP TO smith; -- �� ������ EMP���̺� ���� ��� ���� �ο�(ALL�� �ƴ� SELECT��, SELECT ���Ѹ� �ο�)
-- ���� ��Ż( ���� ��Ż�� ID�� �������� ��)
-- REVOKE ALL ON EMP FROM smith; -- �� ������ EMP ���̺� ���� ��� ���� ��Ż(SMITH������ ���� ���� �Ǿ� �־�� ��.)
-- DROP USER smith CASCADE;
-- ��������
--(1) PRIMARY KEY : �����ϰ� ���̺��� �� ���� �ĺ�.
--(2) NOT NULL : NULL���� �������� ����.
--(3) UNIQUE : ��� �࿡ ���� �����ؾ� �ϸ� NULL���� ���.
--(4) FOREIGN KEY : ���̺��� ���� �ٸ� ���̺��� ���� ����.
--(5) CHECK(����) : �ش� ������ ����.
--(6) DEFAULT : �⺻�� ����.
-----------------------------------------------------------------------------------------------------------------
--[SUQUENCE]--

-- CREATE SEQUENCE sequence_name
-- [INCREMENT BY n] [START WITH n]
-- [MAXVALUE n][MINVALUE n]
-- [CYCLE|NOCYCLE]
-- [CACHE n| NOCACHE];

-- DROP SEQUENCE sequence_name;    (����)
-- ALTER SEQUENCE sequence_name [INCREMENT BY n] [START WITH n][MAXVALUE n][MINVALUE n]
-- INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) VALUES (FRIEND_SEQ.NEXTVAL,' ',' ',' ');
----------------------------------------------------------------------------------------------------------------
--[VIEW]--

--CREATE OR REPLACE VIEW ��� AS SELECT EMPNO, ENAME, JOB, DEPTNO 
   -- FROM EMP WHERE ���� WITH CHECK OPTION                  --���ǿ� �¾ƾ� ����
   -- FROM EMP WITH READ ONLY                               --�б⸸ ����, ���� �Ұ�.
--VIEW�� ������ ���̺� (�޸� ������ �������� �ʴ´�.)
--VIEW�� DML���� �� ���̺��� ����ȴ�.
-- C OR R VIEW ��� AS SELECT (DISTICT) DEPTNO, SAL*12 YEARSAL ....ó�� �ʵ���� SAL*12�� �����ϰ� ��Ī�� �޸� ���� �Ұ�. �翬�ѵ�..

-- C OR R VIEW ...
    --FROM VIEW, TABLE         --�̷������� �ʵ忡 DEPTNO, DNAME ���� �Ͱ� SUM(SAL), AVG(COMM) ���� ���� �Բ� ���� �� �ִ�.
--INLINE VIEW -- FROM�� ���������� �ִ� ��.
--EX. SELECT ENAME, SAL, E.DEPTNO FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) S WHERE E.DEPTNO=S.DEPTNO AND SAL>AVGSAL;

-- TOP N
-- �̸��� ���ĺ� ������� �����ؼ� 6~10����� ���(���, �̸�, ���, JOB, MGR, HIREDATE)
-- 1�ܰ� : SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME;
-- 2�ܰ� : SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME); --1�ܰ踦 FROM��
-- 3�ܰ� : SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
            -- FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME))
            -- WHERE RN BETWEEN 6 AND 10;
