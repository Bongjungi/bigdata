CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(4),
    MAJOR_NAME VARCHAR2(30),
    MAJOR_OFFICE_LOC VARCHAR2(20) NOT NULL,
    PRIMARY KEY(MAJOR_CODE),
    UNIQUE(MAJOR_NAME));
CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR2(10),
    STUDENT_NAME VARCHAR2(12) NOT NULL,
    SCORE NUMBER(3) CHECK(SCORE BETWEEN 0 AND 100),
    MAJOR_CODE NUMBER(4),
    PRIMARY KEY(STUDENT_CODE),
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE));
INSERT INTO MAJOR VALUES (1,'경영정보','3층 인문실');
INSERT INTO MAJOR VALUES (2,'소프트웨어공학','3층 인문실');
INSERT INTO MAJOR VALUES (3,'디자인','4층 과학실');
INSERT INTO MAJOR VALUES (4,'경제','4층 과학실');
INSERT INTO MAJOR VALUES ((SELECT MAX(MAJOR_CODE) FROM MAJOR)+1,'빅데이터','정보관 606호'); --이렇게 하면 안된다.4경제가 없어지면 5빅데이터가 아닌 4경제가 나옴.
INSERT INTO STUDENT VALUES ('A01','김길동',100,1);
INSERT INTO STUDENT VALUES ('A02','문길동',90,2);
INSERT INTO STUDENT VALUES ('A03','홍길동',95,3);
SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
DROP TABLE STUDENT;
DROP TABLE MAJOR;

    