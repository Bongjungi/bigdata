--[IV] �������Լ�, �����Լ�
--�Լ� = �������Լ� + �׷��Լ�(�����Լ�)
-- �������Լ� = INPUT 1 --> OUTPUT 1
-- �׷��Լ� = INPUT N --> OUTPUT 1
SELECT HIREDATE, TO_CHAR(HIREDATE,'YY"��" MM"��" DD"��"') 
    FROM EMP;
SELECT ENAME, INITCAP(ENAME)
    FROM EMP;--INITCAP ù���� �빮�ڷ� ���� - �������Լ�
SELECT SUM(SAL) 
    FROM EMP; --�׷��Լ�(�����Լ�)
SELECT DEPTNO, SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO;
SELECT * 
    FROM DUAL
    WHERE DUMMY='X';
    
    
--EX. ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ�, ����ȯ�Լ�, NVL(), ETC...

-- 1. �����Լ�
SELECT ABS(-9) 
    FROM DUAL; --�׽�Ʈ�� ���̺� DUAL
SELECT FLOOR(34.5478) 
    FROM DUAL; --34
SELECT TRUNC(34.5478,2) 
    FROM DUAL;
SELECT LOG(EXP(1),EXP(2)) 
    FROM DUAL;
SELECT TAN(0) 
    FROM DUAL;
SELECT POWER(2,3) 
    FROM DUAL;
SELECT SIGN(3) 
    FROM DUAL; -- 0���� ������ -1, 0�̸� 0, 0���� ũ�� 1
-- EMP ���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, SAL, TRUNC(SAL, -2) 
    FROM EMP;
SELECT CEIL(34.4567) 
    FROM DUAL;
SELECT ROUND(34.5678) 
    FROM DUAL;
SELECT MOD(5,3)
    FROM DUAL; -- 5MOD(3)�ε�.
SELECT *
    FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE,'MM'),2)=1;
    
    
--2. ����ó���Լ�
SELECT LOWER('A') 
    FROM DUAL;
SELECT UPPER('Welcome') 
    FROM DUAL;
SELECT INITCAP('asd') 
    FROM DUAL;
SELECT 'AB'||'CD'||'EF'
    FROM DUAL;
SELECT CONCAT(CONCAT(ENAME,'�� '),CONCAT(JOB,'�̴�.')) 
    FROM EMP;
SELECT CONCAT('ASD','SDF')
    FROM DUAL;--ASDSDF
SELECT SUBSTR(HIREDATE,1,2), SUBSTR(HIREDATE,4,2)
    FROM EMP;
SELECT SUBSTR('����Ŭ����Ŭ',1,3) 
    FROM DUAL;--1���� 3���� ����
SELECT SUBSTRB('����Ŭ����Ŭ',1,7)
    FROM DUAL;--1���� 3BYTE ���� (-- ����� �� ���ڴ� 1BYTE, �ѱ��� �� ���ڴ� 3BYTE-����Ŭ�������� �ٸ���.) 
SELECT LENGTH('ASDF����') 
    FROM DUAL;--6
SELECT LENGTHB('ASDF����') 
    FROM DUAL;--10
SELECT INSTR('SDFAADSAADAADFA','A',1,3) 
    FROM DUAL;--8; A�� 1�׺��� ã�Ƽ� 3��° �ִ� ���� ���?
SELECT RPAD(SUBSTR(ENAME,1,2),LENGTH(ENAME),'*')
    FROM EMP; --????????????????
SELECT TRIM(ENAME) 
    FROM EMP; -- �¿���� ����� LTRIM�� �°��� RTRIM�� �����
SELECT CONVERT(ENAME,'US7ASCII','UTF8') 
    FROM EMP;--CHAR SET�� ��ȯ
SELECT CHR(65) 
    FROM DUAL; --�ƽ�Ű�ڵ尪���� 'A' �Է�.
SELECT ASCII('A') 
    FROM DUAL; --'A'�� �ƽ�Ű�ڵ尪����
SELECT REPLACE(ENAME,'I','A') 
    FROM EMP;
--JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * 
    FROM EMP
    WHERE UPPER(JOB)='MANAGER';
--9���� �Ի��� ����� ����� ���ÿ�
SELECT * 
    FROM EMP 
    WHERE SUBSTR(HIREDATE,4,2)=09;
--83�⵵�� �Ի��� ����
SELECT *
    FROM EMP
    WHERE SUBSTR(HIREDATE,1,2)=83;
--�̸��� E�� ������ ���
SELECT *
    FROM EMP
    WHERE UPPER(SUBSTR(ENAME,-1,1))='E';
--���,�̸�,��å(�̸��� ���ڼ���ŭ ǥ��)
SELECT EMPNO, ENAME, SUBSTR(JOB,1,LENGTH(ENAME))
    FROM EMP;
--HIREDATE�� ������ ��¥���� ���ڿ��� �ٲ��
--SELECT TO_CHAR(HIREDATE) FROM EMP;
SELECT SUBSTR(HIREDATE, 1, LENGTH(HIREDATE))
    FROM EMP;
SELECT INSTR('ABCDABCDABCD','B')
    FROM DUAL;--B�� ó�� ������ ��ġ
SELECT INSTR('ABCABC','B',-3) 
    FROM DUAL;-- -3���� �����Ͽ� ���ʹ������� 'B'�� ã�ƶ�
SELECT INSTR('ACCABC','B',-3)
    FROM DUAL; -- 0 (�ѹ������� �ѹ��� Ȯ���Ѵ�.)
SELECT INSTR('ABCDABCDABCD','B',3,2) 
    FROM DUAL;--B�� 3���ε������� �����Ͽ� 2��°�� ������ �ε���
SELECT INSTR('�����ͺ��̽�','��',3,1), INSTRB('�����ͺ��̽�','��',3,1)
    FROM DUAL;
--9���� �ƴ� �ٸ� ���� �Ի��� ���
SELECT * 
    FROM EMP 
    WHERE INSTR(HIREDATE,'09',6)=0;
--�̸��� �� ��° �ڸ��� R�� ����� �˻�
SELECT ENAME 
    FROM EMP 
    WHERE ENAME LIKE '__R%';
SELECT ENAME 
    FROM EMP
    WHERE SUBSTR(ENAME,3,1)='R';
SELECT ENAME 
    FROM EMP 
    WHERE INSTR(ENAME,'R',3,1)=3;
SELECT LPAD('ORACLE',20,'#') 
    FROM DUAL;
SELECT LTRIM(' ORACLE ') 
    FROM DUAL;
SELECT TRIM('a' FROM 'aaaaaaaaaaORACLEaBBaaaaaaa') 
    FROM DUAL;
--�̸��� ù ���ڸ� ������ �������� *�� ���
SELECT RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*')
    FROM EMP;
SELECT * 
    FROM EMP 
    WHERE SUBSTR(HIREDATE,-2,2)=09;
--��� S****(�̸��� �� �ѱ��ڸ� ����ϰ� ��������*)
SELECT RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*')
    FROM EMP;
--��� _****H 80/12/**
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME,-1,1),LENGTH(ENAME),'*'),10,'_'), RPAD(SUBSTR(HIREDATE,1,6),LENGTH(HIREDATE),'*')
    FROM EMP;


--3. ��¥�Լ�
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';
SELECT SYSDATE, SYSDATE+14 
    FROM DUAL;
-- �ٹ�����
SELECT TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE),2) 
    FROM EMP;
SELECT ADD_MONTHS('2021/01/05',3) 
    FROM DUAL;
SELECT NEXT_DAY(SYSDATE,'������') 
    FROM DUAL ;-- 1-�Ͽ��� 2-�� ...
SELECT LAST_DAY(SYSDATE) 
    FROM DUAL; --������ ��¥�� ���� ������ ��¥
SELECT SYSDATE, ROUND(SYSDATE,'DAY'), ROUND(SYSDATE, 'MONTH'), TRUNC(SYSDATE, 'MONTH')
    FROM DUAL; --DAY���� �ݿø� 21/06/03, 21/06/06(����� �Ͽ��Ϸ� �ݿø�), MONTH�� �ݿø�(1~15�ϱ����� �̹���1��), �ش���� 1��
--������� �ٹ��ϼ�
SELECT TRUNC(SYSDATE-HIREDATE)
    FROM EMP;
-- ù ���޳�(����)
SELECT LAST_DAY(HIREDATE) 
    FROM EMP;
-- ù ���޳�(1��)
SELECT LAST_DAY(HIREDATE)+1, ROUND(HIREDATE+15,'MONTH') 
    FROM EMP;
--�̸�, �Ի���, �ٹ��ּ�, �ٹ����
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE)/7), TRUNC((SYSDATE-HIREDATE)/365) 
    FROM EMP;
--�̸�, �Ի��� ���� ���� �޿��� ��(�޿��� �Ŵ� SAL�� �ް� �󿩱��� 2�� COMM�� ����)
SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*SAL, TRUNC((SYSDATE-HIREDATE)/365)*2*NVL(COMM,0)
    FROM EMP;
--�̸�, �Ի���, �Ի��Ѵ��� 5��
SELECT ENAME, HIREDATE,TRUNC(HIREDATE,'MONTH')+4
    FROM EMP;
--�̸�, �Ի���, ���޳�(5��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11,'MONTH')+4
    FROM EMP;
SELECT ROUND(TO_DATE('81/04/04','YYYY/MM/DD')+11,'MONTH')+4
    FROM DUAL;
--�̸�, �Ի���, ���޳�(25��)   
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9,'MONTH')+24
    FROM EMP;

-- 4. ����ȯ�Լ�
--����Ŭ Ÿ�� : ����, ����, DATE

--(1) ��¥�� Ȥ�� �������� ���������� ��ȯ
-- YYYY(4�ڸ�), YY(2�ڸ�),MM(���� ���ڷ�), MON(���� ���ĺ����� ǥ��), DD(��) DAY(����) DY(����������) AM, PM, A.M(���� �ð�ǥ��) P.M
-- HH12(12�ð�ǥ��) HH24(24�ð�ǥ��) MI(��) SS(��)
SELECT TO_CHAR(SYSDATE,'YYYY"��"MM"��"DD"��"'), TO_CHAR(SYSDATE,'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS') 
    FROM DUAL;
-- �������
-- 0(�ڸ����� ���� ������ 0���� ä��) 9(�ڸ����� ���� ������ ���) L(�� ���� ��ȭ ��ȣ)
SELECT ENAME, SAL, TO_CHAR(SAL,'L909,999')
    FROM EMP;
--(2) �������� ��¥������ ��ȯ
SELECT TO_DATE(20180605,'YYYYMMDD')
    FROM EMP; --18/06/05
--(3) �������� ���������� ��ȯ
SELECT TO_NUMBER('10,000','99,999'), TO_NUMBER('20,000','99,999')
    FROM EMP;
SELECT TO_NUMBER('3,456.78','9,999.99')+1 
    FROM DUAL;
SELECT '3456.78'+1
    FROM DUAL;
    
--5. NULL �� ��ȯ �Լ� NVL - �Ű����� 2���� Ÿ���� ��ġ�ؾ� �Ѵ�.
SELECT TO_CHAR(NVL(COMM,0),'L900,000')
    FROM EMP;
--�̸�, ����� ���(MGR) ���. ���ӻ�� ���� ��� 'CEO'�� ���
SELECT ENAME, NVL(TO_CHAR(MGR),'CEO')
    FROM EMP;
    
 
--6. ETC
--(1) EXTRACT : �⵵�� ���� �����ϰ��� �� ��
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;

--(2) ������ ��� : LEVEL, START WITH ����, CONNECT BY PRIOR ����
SELECT LEVEL,ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;
SELECT LEVEL,LPAD(' ',LEVEL*2)||ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;