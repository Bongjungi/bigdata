###################################################
###########6장. 데이터베이스 및 SQL 이용###########
###################################################
# 이 장의 내용 : SQL문으로 데이터프레임과 DB(oracle, mySql) 테이블을 이용

#Mysql형식

### 1. SQL문으로 데이터 프레임 처리
install.packages('sqldf')
library(sqldf) #sqldf() 함수를 통해 데이터프레임을 DB의 테이블처럼 사용
sqldf('select * from iris')

#중복행 제거하면 한 행만 출력
sqldf('select distinct Species from iris')
#행 제한 조건
sqldf("select * from iris where Species='setosa'")
iris[iris$Species=='setosa',]
#컬럼에 .이 있으면
sqldf("select `Sepal.Length` from iris") #  `` 1 옆에있는거 
sqldf("select 'Sepal.Length' from iris") #  '' enter 옆에 있는거
#종별 Sepal.Length+Sepal.Width 평균
library(doBy)
summaryBy(Sepal.Length+Sepal.Width~Species, data=iris, FUN=mean)
sqldf("select Species, avg(`Sepal.length`),avg(`Sepal.width`) from iris group by Species")

#iris를 Sepal.Length 기준으로 내림차순 정렬해서 11~15등까지 출력
sqldf("select * from iris order by `Sepal.Length` desc limit 10,5")


####2. 오라클 데이터베이스 연결 ########
#전작업 : ojdbc6.jar이용하므로 자바설치->환경변수설정(JAVA_HOME)
getwd()
#패키지 설치 및 로드 : RJDBC
install.packages('RJDBC')
require(RJDBC)
#드라이버 클래스 로드
drv<-JDBC("oracle.jdbc.driver.OracleDriver",classPath = "ch01/ojdbc6.jar")
#데이터 베이스 연결
conn<-dbConnect(drv,"jdbc:oracle:thin:@127.0.0.1:1521:xe","scott","tiger")
#sql문 전송, 결과 받기 1방법
rs<- dbSendQuery(conn,"select * from emp")
emp<-fetch(rs,n=-1)
emp
#sql문 전송 + 결과 받기를 한꺼번에 하는 방법
dept<-dbGetQuery(conn, "select * from dept")
dept

dept[dept$deptno<30,]
colnames(dept)<- c('deptno','dname','loc')

#DB 데이터 수정 SQL 전송(update, insert,delete)
dbSendUpdate(conn,"insert into dept values (50, 'it','seoul')")



#데이터 연결 해제
dbDisconnect(conn)
#드라이버 언로드 : db연결 해제하면 자동으로 언로드됨
dbUnloadDriver(drv)

#RJDBC 패키지 언로드
detach('package:RJDBC',unload = TRUE)

######3.MySQL 데이터 베이스 연결 ######
#전작업: 외부에서 액세스 허용
#mysql 주인계정으로 접속(root계정)
#alter user 'root'@'localhost' identified with mysql_native_password by 'mysql';입력

install.packages("RMySQL")
library(RMySQL)
#드라이버 로드
drv<-dbDriver('MySQL')
#데이터베이스 연결
conn<-dbConnect(drv, host="127.0.0.1", dbname="kimdb", user='root', password='mysql')
#sql전송+결과받기
rs<-dbSendQuery(conn, 'select * from personal')
personal<-fetch(rs,n=-1)
personal
#SQL전송과 결과받기를 한번에
division<-dbGetQuery(conn, 'select * from personal')
division
#테이블 전체 데이터를 한꺼번에 조회
person<-dbReadTable(conn,"personal")
person
#데이터 베이스 연결 해제
dbDisconnect(conn)
#드라이버 언로드
dbUnloadDriver(drv)
