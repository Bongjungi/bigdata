SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO AND W.DEPTNO= D.DEPTNO AND DNAME = 'ACCOUNTING';
    
--부서 추가
INSERT INTO DEPT VALUES (40,'IT', 'MAPO');
commit;
select * from dept;


DELETE FROM DEPT WHERE DEPTNO IN (45,51,50,64,70,91,65);

--수정
UPDATE DEPT SET DNAME = 'IT', LOC='MAPO' WHERE DEPTNO = 50;

--삭제
DELETE FROM DEPT WHERE DEPTNO=50;

--pstmt
select * from dept where deptno=50;
insert into dept values (50,'IT','SEOUL');
commit;
select * from dept where dname='SALES';
select w.empno, w.ename, w.sal, m.ename
    from emp w, emp m, dept d
    where w.mgr=m.empno and d.deptno=w.deptno and dname='sales'

