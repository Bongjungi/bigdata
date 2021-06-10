SHOW USER;
SELECT * FROM USER_TABLES; --내 계정이 소유한 테이블.
SELECT * FROM ALL_TABLES WHERE TABLE_NAME IN ('DEPT', 'EMP'); -- 내 계정이 접근 가능한 테이블.
SELECT * FROM DBA_TABLES; -- 일반계정에서는 불가.
SELECT ENAME, DNAME, LOC
    FROM SCOTT.EMP E, SCOTT.DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM SCOTT.EMP;
EXIT; -- 접속해제
QUIT;