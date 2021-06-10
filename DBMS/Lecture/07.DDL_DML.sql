-- [VII] DDL, DML, DCL
-- DDL(���̺� ����, ���̺� ����, ���̺�������, ���̺� ��� ������ ����)
-- DML(SELECT, INSERT, UPDATE, DELETE) - ������� ����
-- DCL(����ڰ�������, ����ڿ��� ���Ѻο�, ���ѹ�Ż, ����ڰ�������, Ʈ����� ��ɾ�)
-- EXERD ������ ȭ��ǥ�� �⺻Ű�ʵ带 �ٸ� ���̺� ��ӽ�ų��,
--      �Ķ��� ȭ��ǥ�� ���ο� �ʵ带 ����� ���踦 ���� �����.

--CREATE TABLE ���̺�� ( ���� ���� ����, ���� ���� ����,...);
-- ALTER TABLE ���̺�� ADD ���� ���� ����                (���� �߰�)
-- ALTER TABLE ���̺�� MODIFY ���� ����                 (���� ��ȯ)
-- ALTER TABLE ���̺�� DROP COLUMN �ʵ��                (�ʵ� ����)
-- ALTER TABLE ���̺�� SET UNUSED �ʵ��                 (�̿� �Ұ�)
-- ALTER TABLE ���̺�� DROP UNUSED COLUMNS              (�̿� �Ұ� �ʵ� ����)
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



SELECT * FROM EMP;
DESC DEPT;

--DDL
-- 1.���̺� ����(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4), --������ȣ BOOKID �ʵ��� Ÿ���� ����4�ڸ�
    BOOKNAME VARCHAR2(20), -- �����̸� BOOKNAME �ʵ��� Ÿ���� ����20BYTE
    PUBLISHER VARCHAR2(20), -- ���ǻ�
    RDATE DATE, -- ������ RDATE�� �ʵ� Ÿ���� DATE
    PRICE NUMBER(8),
    PRIMARY KEY(BOOKID)); -- ��Ű(�⺻Ű) ���� (����, NOT NULL)
SELECT * 
    FROM BOOK;
DROP TABLE BOOK; --���̺� ����
CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY, --������ȣ BOOKID �ʵ��� Ÿ���� ����4�ڸ�, �⺻Ű
    BOOKNAME VARCHAR2(100), -- �����̸� BOOKNAME �ʵ��� Ÿ���� ����100BYTE
    PUBLISHER VARCHAR2(20), -- ���ǻ�
    RDATE DATE, -- ������ RDATE�� �ʵ� Ÿ���� DATE
    PRICE NUMBER(8));
--EMP�� ������ EMP01 : EMPNO(����4), ENAME(����20), SAL(����7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)); -- ��ü 7�ڸ�(����5�ڸ�, �Ҽ�2�ڸ�)
SELECT * 
    FROM EMP01;    
--DEPT�� ������ DEPT01 : DEPTNO(����2), DNAME(����14), LOC(����13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13));
--���������� �̿��� ���̺� ����
CREATE TABLE EMP02
    AS
    SELECT * FROM EMP; -- �������� ����� ���̺� ��. PRIMARY KEY ���� �������� ������.
DESC EMP02;
CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, DEPTNO 
    FROM EMP;
-- EMP���� 10�� �μ��� ����
CREATE TABLE EMP04 AS SELECT * 
    FROM EMP 
    WHERE DEPTNO=10;
-- EMP������ ����
CREATE TABLE EMP05 AS SELECT * 
    FROM EMP 
    WHERE 1=0;

SELECT ROWNUM, EMPNO, ENAME 
    FROM EMP; -- ROWNUM ���� ���� ����
SELECT ROWID, EMPNO, ENAME 
    FROM EMP; --ROWID���� ���� �ּ�
--2. ���̺� ���� ����(ALTER TABLE)
--(1) �ʵ� �߰� (ADD)
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20) , SAL NUMBER(7,2)); -- �ʵ� 2�� �߰�
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));
--(2) �ʵ� Ÿ�� ����(MODIFY)
SELECT * FROM EMP03; -- EMPNO,ENAME,DEPTNO �� ����, JOB,SAL,COMM �� ����
--ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR(5)); -- ����(���ڵ����Ͱ� ����־ ���ڷθ� ���� ����)
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(20)); -- ���氡��.
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(20)); -- NULL���̸� �ƹ� ���·� ���氡��
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4));
-- (3) �ʵ� ����(DROP)
ALTER TABLE EMP03 DROP COLUMN JOB; -- JOB �ʵ� ����
ALTER TABLE EMP03 DROP COLUMN DEPTNO; -- DEPTNO�ʵ� ����(�����ͱ��� ����)
-- �������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED (COMM); -- COMM ���ٺҰ�
-- �������� ���� �Ұ��ߴ� �ʵ带 ����
ALTER TABLE EMP03 DROP UNUSED COLUMNS;
--3. ���̺� ����(DROP TABLE)
DROP TABLE EMP01;
SELECT * FROM EMP01;
DROP TABLE DEPT; -- ���� �Ұ�.( DEPT���̺��� �θ� ���̺��̰� EMP���̺��� �ڽ� ���̺��̴�. DEPT���̺��� DEPTNO�� EMP���̺��� �����ϰ� �ֱ� ������ EMP�� DEPTNO�� �����ؾ� DEPT�� ���� �� �ִ�. CASCADE���� �����ϱ� �ϴ�.
SELECT * FROM EMP;
--4.���̺��� ��� ���� ����(TRUNCATE)
TRUNCATE TABLE EMP03; -- EMP03���� ������ ����(��ҺҰ�)
SELECT * FROM EMP03;
--5. ���̺�� ����(RENAME)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2; --EMP02�� EMP2�� ���̺�� ����
--6. ������ ��ųʸ�(����� ���� �Ұ�) VS ������ ��ųʸ� ��(����� ���� ����)
-- ���� ����
-- USER_XXX : �� ������ �����ϰ� �ִ� ��ü(���̺�, ��, �ε���, ��������...)
    -- USER_TABLES, USER_INDEXS, USER_CONSTRAINTS, USER_VIEWS
-- ALL_XXX : �� ������ ���� ������ ��ü
    -- ALL_TABLES, ALL_INDEXS, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA(EX. scott)�� ���ٰ���. DBMS�� ��� ��ü
    -- DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
SHOW USER;
SELECT * FROM USER_TABLES; -- �� ������ ������ ���̺� ��ü
SELECT * FROM USER_INDEXES; -- �� ������ ������ �ε��� ��ü
SELECT * FROM USER_CONSTRAINTS; -- �� ������ ������ �������ǵ�
SELECT * FROM USER_VIEWS; -- �� ������ ������ ��
SELECT * FROM ALL_TABLES; -- �� ������ ���� ������ ���̺� ��ü
SELECT * FROM ALL_TABLES WHERE TABLE_NAME = 'EMP';
SELECT * FROM ALL_INDEXES; -- �� ������ ���� ������ �ε��� ��ü
SELECT * FROM ALL_CONSTRAINTS; -- �� ������ ���� ������ �������ǵ�
SELECT * FROM ALL_VIEWS; -- �� ������ ���� ������ ��
SELECT * FROM DBA_TABLES;


-- DCL(����� ���� ����, ����� ���� ���� �ο�, ���� ��Ż, ���� ����)
CREATE USER smith IDENTIFIED BY tiger; -- smith ���� ����
-- ���� �ο�(���Ǳ���, scott.emp, scott.dept�� ���� ��� ����)
GRANT CREATE SESSION TO smith; -- GRANT DBA TO scott;
GRANT ALL ON EMP TO smith; -- �� ������ EMP���̺� ���� ��� ���� �ο�(ALL�� �ƴ� SELECT��, SELECT ���Ѹ� �ο�)
-- ���� ��Ż( ���� ������ ID�� �������� ��)
REVOKE ALL ON EMP FROM smith; -- �� ������ EMP ���̺� ���� ��� ���� ��Ż
DROP USER smith CASCADE;

--DML(SELECT, INSERT, UPDATE, DELETE)
-- 1. INSERT INTO ���̺�� VALUES (��1, ��2, ...), INSERT INTO ���̺�� (�ʵ��1,�ʵ��2,...) VALUES(��1,��2,...)
SELECT * FROM DEPT01;
INSERT INTO DEPT01 (DEPTNO,DNAME,LOC) VALUES (10,'ACCOUNTING','NEW YORK'); -- Ʈ����� 1���� �ö�. ��� ����.(SQL���� Ŀ������ �ѹ����������
INSERT INTO DEPT01 (DEPTNO,LOC) VALUES (30,'NEW YORK');
UPDATE DEPT01 SET LOC=NULL, DNAME='IT' WHERE DEPTNO=30;
-- ���������� �̿��� INSERT
    --DEPT���̺��� 10~30�μ��� INSERT
TRUNCATE TABLE DEPT01;
INSERT INTO DEPT01 SELECT * FROM DEPT;
--BOOK���̺��� 11(å��ȣ)�� '����������', '�Ѽ�����', �������� ����, ������ 90000;
SELECT * FROM BOOK;
INSERT INTO BOOK VALUES (11,'����������', '�Ѽ�����',SYSDATE,90000);
--Ʈ����� ��ɾ�(DML��ɾ ����)
COMMIT; -- Ʈ����� ������ ����. �� Ʈ������� �۾��� DB�� �ݿ�
ROLLBACK;
--2. UPDATE ���̺�� SET �ʵ��1==��1,... WHERE ����;
CREATE TABLE EMP01 AS SELECT * FROM EMP; 
UPDATE EMP01 SET DEPTNO =30; -- ��� DEPTNO�� 30����
UPDATE EMP01 SET SAL = SAL*1.1;
-- 10�� �μ� ������ �Ի����� ���÷�, �μ���ȣ�� 30�� �μ��� �����Ͻÿ�.
SELECT * FROM EMP01;
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO=30 WHERE DEPTNO=10;
--SAL�� 3000�̻��� ����� �޿��� 10% �λ�
UPDATE EMP01 SET SAL=SAL*1.1 WHERE SAL>=3000;
--DALLAS�� �ٹ��Ѵ� ������ �޿��� 1000�� �λ�
UPDATE EMP01 SET SAL=SAL+1000 WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
--SCOTT�� �μ���ȣ 20, MANEGER,SAL�� COMM�� 500 �λ�, ���� KING���� ����
UPDATE EMP01 
    SET DEPTNO=20, JOB='MANAGER', SAL=SAL+500, COMM=NVL(COMM,0)+500, MGR= (SELECT EMPNO FROM EMP WHERE ENAME='KING')
    WHERE ENAME='SCOTT';
--DEPT01���� 20�μ��� �������� 40�μ��� ���������� ����
SELECT * 
    FROM DEPT01;
UPDATE DEPT01 
    SET LOC = (SELECT LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=20;
--EMP01���̺��� ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����
UPDATE EMP01 
    SET (SAL, HIREDATE)= (SELECT SAL, HIREDATE FROM EMP WHERE ENAME='KING');
COMMIT;
--3. DELETE FROM ���̺�� WHERE ����
SELECT * 
    FROM EMP01;
DELETE 
    FROM EMP01;
ROLLBACK;
--EMP01���̺��� 30�� �μ� ������ ����
DELETE 
    FROM EMP01 
    WHERE DEPTNO=30;
--EMP01���̺��� ������� 'FORD'�� ����� ����
DELETE 
    FROM EMP01 
    WHERE ENAME='FORD';
--EMP01���̺��� �μ����� SALES�� ����� ����
DELETE 
    FROM EMP01 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
--EMP01���� RESEARCH �μ� �Ҽ��� ����� ����
DELETE
    FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH');
COMMIT;

-- ��������
--(1) PRIMARY KEY : �����ϰ� ���̺��� �� ���� �ĺ�.
--(2) NOT NULL : NULL���� �������� ����.
--(3) UNIQUE : ��� �࿡ ���� �����ؾ� �ϸ� NULL���� ���.
--(4) FOREIGN KEY : ���̺��� ���� �ٸ� ���̺��� ���� ����.
--(5) CHECK(����) : �ش� ������ ����.
--(6) DEFAULT : �⺻�� ����.
CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR(14) UNIQUE,
    LOC VARCHAR(13) NOT NULL);
DROP TABLE DEPT1;    
CREATE TABLE DEP1(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) NOT NULL,
    PRIMARY KEY(DEPTNO),
    UNIQUE(DNAME));
DESC DEP1;
CREATE TABLE EMP1(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    MGR NUMBER(4),
    SAL NUMBER(7,2) CHECK(SAL>0),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) REFERENCES DEP1(DEPTNO), --�ܷ�Ű ��������
    JOB VARCHAR2(9),
    HIREDATE DATE DEFAULT SYSDATE);
DROP TABLE EMP1;
CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    MGR NUMBER(4),
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    JOB VARCHAR2(9) NOT NULL,
    HIREDATE DATE DEFAULT SYSDATE,
    PRIMARY KEY(EMPNO),
    CHECK(SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEP1(DEPTNO));
INSERT INTO DEP1 SELECT * FROM DEPT;
SELECT * FROM DEP1;
INSERT INTO DEP1 (DEPTNO, DNAME, LOC) VALUES (50,'IT','MAPO');
INSERT INTO DEP1 VALUES (60,'PLANNING','MAPO');
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) 
        VALUES (1001,'KIM','MANAGER',1000,0,50); --DEFAULT SYSDATE
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO)
        VALUES (1002, 'PARK', 'MANAGER', 60);-- PK
INSERT INTO EMP1 (EMPNO, JOB, DEPTNO)
        VALUES (1003, 'MANAGER', 40); --NOT NULL
INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL, DEPTNO)
        VALUES (1004, 'YUN', 'MANAGER', 0, 30); --CHECK(SAL>0)
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO) 
        VALUES (1005, 'YI', 'MANAGER', 80); --FOREIGNKEY(DEPTNO) REFERENCES DEP1


    


--��������
SELECT * FROM SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2));
INSERT INTO SAM01 VALUES (1000,'APPLE','POLICE',10000);    
INSERT INTO SAM01 VALUES (1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 VALUES (1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030,'VERY',25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1040,'CAT',2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;
DELETE FROM SAM01 WHERE JOB IS NULL;
DELETE FROM SAM01 WHERE ENAME = 'ORANGE';

