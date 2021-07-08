####3장. R 데이터 종류 및 구조

##1. 데이터의 종류
#기본 데이터 타입 : 문자,숫자,논리,복소수 - 스칼라타입
#Factor(정해진 자료형 ex)남,여), vector(동일 자료형), list(자료형) matrix,array,data.frame, 날짜, 특별한 값(결측치...)
a<-10+1i;
class(a)
kor<-c('한국','')
##2. 기본 데이터 타입 : character, numeric, logical(T,F), COMPLEX
#character
a<-"Hello"
a<-'Hello'
a<-'I say, "hello"'
a<-'hello
r'
?cat
cat("dkdk","dkdk", sep = "")
cat(a)
class(a)
mode(a)
typeof(a)
methods(is) #is로 시작하는 함수들
is.character(a) # a변수가 character인지 여부
as.character(100) # 100을 character로 형변환한 결과 반환

#numeric :정수, 실수
b<-10.1
is.numeric(b)
as.character(b)
methods(as)
as.integer(10.9) #매개변수를 정수로(내림)

#logical
c<-TRUE;
is.logical(c)
class(c)
as.numeric(c)
as.character(c)

str(a)
str(b)
str(c)

#3. 특별한 값 (NULL, NA: 결측치, NaN, Inf)
as.integer("A")
result=0;

add <- function(a, b){
  result<<-2*a+b
  return ();
}
(temp<-add(1,2))
(temp<-add(b=1,a=2))
is.null(temp)
d<-c(2,4,NA,6,NaN,10/0)
mean(d) #NA
mean(d, na.rm=TRUE) #INF

#결측치(NA) 관련함수
#is.na(d): 결측치인지 아닌지 여부 반환
#complete.cases(d) : d변수에 결측치가 없으면 TRUE
#na.omit(d): 결측치 제외
#na.pass(d): NA 여부와 상관없이 처리
is.na(d)
is.na(d[4])
complete.cases(d)
#d에서 결측치가 아닌 값만 뽑아내기
d[c(1,2,4,6)]
d[c(TRUE,TRUE,FALSE,TRUE,FALSE,TRUE)]
d[complete.cases(d)]
na.omit(d)
boxplot(d)
x=1:100
boxplot(x)

##팩터(factor) : 범주형데이터, 순서식(미리 정해진 여러개 값 중 하나)
gender1 <- c('남','여','여','남')
gender1[5] <- '중성'
class(gender1) #vector변수의 타입은 요소 하나하나의 타입
gender2 <- factor(c('남','여','여','남'), levels=c('남','여'))
gender2
gender2[5]<-'중성' #에러
class(gender2) #factor변수의 타입은 factor
str(gender1)
str(gender2)
na.omit(gender2)
nlevels(gender2) #카테고리 개수
levels(gender2) #카테고리 출력력

level <- factor(c('좋음','보통','보통'), levels=c('매우싫음','싫음','보통','좋음','매우좋음'), ordered=TRUE)
level[4]='매우좋음음'
level[4]='매우좋음'
gender2<-c('남','남','여','NA')
class(gender2)
gender2<-factor(gender2, levels=c('남','여'))

## 5. 구조형 변수와 복합형 변수 : 변수 하나에 여러 값 할당
#(1) 구조형 변수 : 동일 자료형
#                  (ex)벡터, 행렬(회귀분석 용이))
#(2) 복합형 변수 : 서로 다른 자료형을 가질 수 있음
#                  (ex)리스트, 데이터프레임(cvs)

##6. 벡터 : 동일 자료형
data <-c(11,22,33,'TEST') #전부 문자로
data <-c(11,22,33,TRUE) #전부 숫자로로
data <-1:5
names(data)
names(data) <-c('a','b','c','d','e')
data
data[1]
data[c(1,2)]
data[c("a","b")]
data[1:4]
data[-2] #2번째만 제외
data[-c(2,3)]
data[data>4]
data[names(data)=='c']
names(data)<-NULL
?nrow
?NROW
#항목개수 
length(data)
NROW(data)
nrow(data) #1차는 null임
2 %in% data #data에 2가 포함되어 있는지 여부 T/F

#Q. (1) 시험점수 변수를 만들어 출력하고 
#   (2) 전체 평균을 구한 후 출력(평균 = xx)
#yi 80,kim 100, yun 90,lim 미응시 lee 70, park 70


data<-c(80,100,90,'미응시',70,70)
names(data)<-c("yi",'kim','yun','lim','lee','park')
data2<-as.numeric(data)
data2
complete.cases(data2)
complete.cases(as.numeric(data)) #이건 안됨 에러처리먼저해야됌
as.numeric(data)
mean(data2[complete.cases(data2)])
mean(data2, na.rm = TRUE)
mean(na.omit(data2))

#######함수##############
ax2_b.add<-function(a=0,b=0){
  return(2*a+b)
}
ax2_b.add() #a=0,b=0
ax2_b.add(10) #a=10 b=0
ax2_b.add(b=2,a=3)
#########################

#6.1 character() : character 벡터 생성하는 함수
charVec <- character() #길이0인 문자벡터
charVec
is.vector(charVec)
class(charVec)
length(charVec)
charVec[1]='R'
charVec<- character(5) # 지금은 길이가 0 값하나들어가면 길이가 5
charVec[1]="안녕";charVec[2]="안녕";charVec[6]='so'
rm(charVec[6])
charVec[6] <- NULL
charVec
#6.2 numeric()
intVec <-numeric() #길이0인 숫자벡터
intVec1 <- numeric(5) #기본적으로 0값입력됌
#6.3 logical()
logicVec <- logical() #길이0인 로직벡터
logicVec1 <-logical(5) # 기본적으로 false값입력됌
#6.4 seq
?seq
(a<-seq(from=1, to=10, by=1)) #by는 기본값이 1
seq(1,10) #1,2,3,4,5,6,7,8,9,10
seq(1,3,0.5) #1, 1.5, 2, 2.5, 3
seq(from=1, to=100, length.out=11)#1부터 100까지 중에 11개 선택
is.vector(a)
pi=3;
pi
rm(pi)
?character()
#6.5 rep()
?rep
#rep(x, times=1, length.out = NA, each=1)
rep(1:4,2) #12341234
rep(1:4, times=2) #12341234
rep(1:4, each=2)  #11223344
rep(1:4, 2, 5, 2) # 1:4를 2번 뿌리고 2번 반복하는데 length는 5이다.
rep(1:4, times=2, length.out=5, each=2)

#6.6 벡터의 연산 (+,-,*,/(나누기),%%(나머지) 결합, 교집합, 합집합, 차집합, 벡터비교연산)
a<-c(1,2,3)
b<-c(10,20,30,3)
#벡터의 사칙연산은 요소별 연산
length(c(a,b))
a<-c(1,2,3)
b<-c(1,2,3)
c<-c(1,2,3)
a<-append(a,b)
# 벡터의 집합 연산 : 합집합(union), 교집합(intersect), 차집합(setdiff), 비교(setequal)
a<-c(1,2,3,4,5,6)
b<-c(2,4,6,8,10,12)
union(a,b)
intersect(a,b)
setdiff(a,b)
setdiff(b,a)
setequal(a,b)
setequal(c(1,2,1),c(1,2))#벡터를 집합처럼 비교한다.

##7. 리스트 : 복합 구조형(키값 형태로 데이터를 담는 복합 구조형)
student<-list(name='홍길동', age=25)
student
student['name']
student$name 
student[1]
student[[1]]
student$age<-NULL
student$age<-25
NROW(student)
studentVect <- unlist(student)
is.vector(studentVect)
student2<-list(studentVect)
student3<-as.list(studentVect)
student3

## 8.행렬
(colMatrix <- matrix(1:15,nrow = 5, ncol = 3))
(rowMatrix <- matrix(1:15, nrow= 5, ncol= 3, byrow=TRUE, dimnames = list(c('R1','R2','R3','R4','R5'),c('C1','C2','C3'))))
rowMatrix['R1','C3']
rowMatrix[1:3,1:2]  
rowMatrix[c(1,3,5),c(1,3)]
rowMatrix[c('R1','R3','R5'),]
rowMatrix[c(1,3,5)]
dim(rowMatrix)
nrow(rowMatrix)
ncol(rowMatrix)
dimnames(rowMatrix)
dimnames(rowMatrix)<-list(c('1행','2행','3행','4행','5행'),c('1열','2열','3열'))
rownames(rowMatrix) <-c('1월','2월','3월','4월','5월')
colnames(rowMatrix)<-c('kim', 'park', 'lee')
rowMatrix
#행렬 값 조회
rowMatrix['1월','kim',drop=FALSE] #1월kim열의 데이터를 Matrix형태로 반환
rowMatrix['1월',] #1월 데이터가 벡터형태로 반환
rowMatrix['1월', , drop=FALSE]#1월 데이터가 MATRIX형태로 반환
rowMatrix[-3,]
rowMatrix[-3]

#행렬의 곱(%*%), 전치행렬(행과 열을 교환), 대각행렬(cf. 단위행렬), 역행렬
payMatrix
payMatrix<-matrix(c(c(12000,26000,18000), c(24000,52000,36000)), ncol = 3, nrow = 2)

payMatrix
dimnames(payMatrix)<-list(c('시간당 수당','시간당 수당2'),c('철수','영희','길동'))
workerMatrix<-matrix(c(5,4,9), c(7,3,2), ncol=2, nrow=3)
payMatrix%*%workerMatrix

#전치행렬
rowMatrix <- matrix(1:15, nrow=5, ncol=3, byrow=T)
rowMatrix

gooMatrix<-matrix(c(c(1,2,3),c(4,5,7),c(11,12,13)), nrow = 3, ncol = 3, byrow = TRUE,
                  dimnames = list(c('ㅁ','ㄴ','ㅇ'),c('ㅋ','ㅌ','ㅊ')))


t(rowMatrix) #전치행렬

#역행렬
rowMatrix<-matrix(1:4,nrow = 2)
solve(rowMatrix) #역행렬
solve(rowMatrix)%*%rowMatrix
#단위행렬
diag(c(1,1))
diag(rep(1,2))
diag(rep(1,3))

#행렬의 곱을 이용한 선형회귀식 도출
x<-c(2,4) #독립변수 : 공부량
y<-c(40,60) #종속변수 : 점수
X<- matrix(c(x,rep(1,NROW(x))), nrow=NROW(x), ncol = 2, byrow = FALSE)
Y<-matrix(y,ncol=1)
X
ab<-solve(X)%*%Y
ab
plot(x,y)
lines(x, x*ab[1]+ab[2], col=2, lty='dotdash', lwd = 4)
?lines

#행렬의 곱을 이용한 선형회귀식 도출 (데이터가 8개)
x<- c(32,64,96,118,126,144,152.5,158)
y<- c(18,24,61.5,49,52,105,130.3,125)
X<-matrix(c(x,rep(1,NROW(x))), nrow=NROW(x), ncol=2)
Y<-matrix(y,ncol=1)
X
Y
solve(t(X)%*%X)
ab
# X%*%ab=Y,
# t(X) %*% X %*% ab =t(X) %*% Y solve를 사용하기 위해
ab<- solve(t(X) %*% X) %*% t(X) %*% Y
lm(y~x)
solve(X,Y)
plot(x,y)
lines(x, x*ab[1]+ab[2], col=2)
x<-c(1,2,3)
y<-c(18,32,40)
X<-matrix(c(x,rep(1,NROW(x))),nrow=NROW(x), ncol=2)
Y<-matrix(y,ncol=1)
lm(y~x)
X1<-matrix(c(1,0,0,0,1,1), nrow = 3, ncol = 2)
Y1<-matrix(c(14,4,-2))
ab<-solve(t(X1) %*% X1) %*% t(X1) %*% Y1
ab
##EX
x1=c(60,65,55)
x2=c(5.5,5,6)
x3=c(1,0,1)
y=c(66,74,78)
Y<-matrix(y,ncol=1)
X<-matrix(c(x1,x2,x3), nrow = 3)
b<-solve(X)%*%y
solve(a,y)

#행렬을 데이터프레임으로 변환
X
dimnames(X) <- list(c('lee','park','kim'),c('흡','키','몸'))
dataFrame <- as.data.frame(X)
class(dataFrame)
class(X)

#행렬연산()
(a<-matrix(1:4,nrow=2,ncol=2))
(b<-matrix(seq(10,40,10),nrow = 2,ncol = 2))
a%*%b #행렬의 곱
a*b #행렬 요소별 연산
a+b #+-*/^(승수)%%(나머지)


b1=function(a1){
  a1*a1*a1-2*a1*a1-a1+2
}
p=-10:10
q=b1(p)
lm(q~p)
lm
plot(p,q)
lines(p,64.8*p-71.33,col=2, lty='dotdash')
lines(p,-p+2,col=3,lty='solid')
lines(p,-2*p*p-p+2, col=4, lty= 'solid')
lines(p,p*p*p-2*p*p-p+2, col=5, lty= 'solid')
?lm

##9.배열 (n차원 동일 자료형의 집합)
dataArray<- array(1:24,dim=c(3,4,2)) #3차원 numeric 배열 (3행4열2면)
dataArray[3,2,1]#3행2열1면
dim(dataArray) #차원
nrow(dataArray) #행수
NROW(dataArray)
length(dataArray) #요소의 갯수
dimnames(dataArray) <- list(c('1행','2행','3행'),c('1열','2열','3열','4열'),c('x면','y면'))
dim(dataArray) <-c(3,8)
dataArray
attr(dataArray,'dim')<-c(3,4,2) #reshape

#10.데이터 프레임
#(1) 데이터 프레임 생성
student_id <- c('20211','20212','20213','20214')
student_name <- c('jin','eric','den','kei')
student_kor <- c(100,95,90,85)
student_eng <- c(99,94,98,84)
student_gender <- c('남','여','남','여')
student_data <- data.frame(student_id,student_name,student_kor,student_eng, student_gender)
edit(student_data)
student_data



child<-c(61.7,61.7,61.7,61.7,61.7,62.2,62.2,62.2,62.2,62.2)
parent<-c(70.5,68.5,65.5,64.5,64.0,67.5,67.5,67.5,66.5,66.5)
galton <- data.frame(child,parent)
galton
str(galton) #구조보기
summary(galton) #통계치보기
lm(formula = child~parent, data= galton)
galton[3,]=NULL

#(2) 데이터 프레임에 열 추가 및 삭제
student_data$math<-c(100,80,90,80) # 열 추가
student_data$age<-c(20,21,22,23)
student_data$age<-NULL 
#(3) 데이터 프레임의 열 형 변환
str(student_data)
student_data$student_id<-as.numeric(student_data$student_id)
student_data$student_gender <- as.factor(student_data$student_gender)
student_data$student_gender <- as.character(student_data$student_gender)
student_data$student_gender <- factor(student_data$student_gender, levels=c('남','여'))
#(4) 데이터프레임의 열이름 변경 (모든 열이름 변경, 특정열의 열이름만 변경)
#library(reshape) #error
.libPaths() #인스톨한 패키지가 설치된 폴더
install.packages("reshape")
require(reshape)
library(reshape)
rename(student_data, c('student_id'='id'))
student<-rename(student_data, c('student_id'='id'))
student<-rename(student,c('student_name'='name','student_kor'='kor','student_eng'='eng','student_gender'='gender')) #특정 열이름 변경
names(student_data) #열들의 이름
#모든 열이름 변경
names(student_data)<-c('id','name','kor','eng','gender','math')

#(5) 데이터 프레임 합치기 :cbind, rbind
#rbind : 행 합치기
newStudent<-rbind(student, student_data)
#cbind : 열 합치기
add_data <- data.frame(age=c(30,31,35,28), nickname=c('개똥','말똥','길똥','소똥'))
add_data
cbind(student,add_data)

#(6) 데이터프레임의 부분 데이터 조회
student<- rbind(student,student)
nrow(student)
ncol(student)
names(student)
student
#1행 1열
student[1,1]
#1행 'id'열
student[1,'id']
#1행 모든 열 데이터
student[1,]
#모든 행의 1열 데이터
student[,1]
student['id']
student[,1, drop=FALSE]
#1~3행가지의 모든 열 데이터
student[1:3,]
#모든 행의 2,3,4,5열 데이터
student[,2:5]
#2,4,6행 외의 모든 데이터
student[seq(-2,-6,-2),]
#1~3행 데이터에서 1열과 5열을 제외한 데이터
student[1:3,c(-1,-5)]
#kor점수가 90점 이상인 데이터
student[student$kor>=90,]
student[student$kor>=90, c('name','kor')]
#subset함수 : 데이터프레임의 부분 데이터 조회
subset(student, subset = (student$kor>=90)) # kor이 90이상인 모든 열 데이터
subset(student, student$kor>=90)
#kor이 90이상인 남자의 모든 열 데이터
subset(student, subset=(student$kor>=90 & student$gender=='남'))
subset(student, select = c(1,4))
subset(student, select = c(-1,-4))
#math가 99점 이상인 여학생 데이터(id, name, math, kor열만 출력)
subset(student, subset = (math>=80 & gender=='여'), select=c('id','name','math','kor'))
#처음 6행만
student[1:6,]
student[c(1:6),]
head(student)
head(student,3)
student[c(nrow(student)-3:nrow(student)),]
student[c((nrow(student)-3):nrow(student)),]
tail(student,3) #마지막 3행만
tail(student)

#문
emp <- read.csv(file.choose()) #탐색기에서 선택한 csv파일을 emp변수 할당
emp

#1. 직원이름만 (벡터형식, 데이터프레임형식)
emp['ename']
emp[,2]
subset(emp, select = 'ename', drop=TRUE) #벡터 형태로 반환
subset(emp, select = 'ename') #데이터 프레임 형태로 반환
?subset
#2. 직원이름, job, sal
emp[c('ename','job','sal')]
#3. 이름이 KING인 직원의 empno, job, hiredate, sal
emp[emp$ename=='KING', c('empno','job','hiredate','sal')]
subset(emp,ename=='KING', select=c('empno','job','hiredate','sal'))
subset(emp, subset = (ename=='KING'), select=c('empno','job','hiredate','sal'))
#4. sal이 2000~3000사이인 직원의 ename, sal
subset(emp, subset = (sal>=2000 & sal<=3000), select = c('ename','sal'))
emp[emp$sal>=2000 & emp$sal<=3000 , c('ename','sal')]


#11.타입 판별 및 타입 변환
class(iris)
class(iris$Species)
edit(iris)
is.factor(iris$Species)
str(iris)
a<-c(1,2,3)
class(a) #타입 판별
mode(a) #타입 판별
typeof(a) #타입 판별

#형변환
a<- as.integer(a)
typeof(a)
class(a)
mode(a)
class(emp$deptno)<-factor(emp$deptno, levels=c(10,20,30,40)) ##이러면 망함
str(emp)
class(emp$deptno)<-NULL # 복구
emp$deptno<-as.factor(emp$deptno)#데이터를 다운받을 경우 NA로
emp$deptno <-factor(emp$deptno, levels=c(10,20,30,40))


#12. 문자열과 날짜
name<-'Eric'
length(name) # 1
nchar(name) #name의 문자 길이
names<- c('Eric','Larray','Curly')
length(names) #요소의 개수 : 3
nchar(names) #요소 하나 하나의 문자 길이 : 4 6 5

#하위 문자열 추출하기 : substr
?substr
substr('ABCDEF', 1, 4) # 1~4번째 문자 추출
substr('ABCDEF', 4, 16) #4~16번째 문자 추출. 없는 문자는 ""로 처리
substring('ABCDEF', c(1,2), c(1,3)) #1~1번째 문자 추출, 2~3번째 문자 추출
substr(names,1,2)
#names 안에 각각의 이름의 맨 마지막자리 앞글자부터 맨 마지막 글자
# 결과 : "ic", "ay", "ly"
substr(names,nchar(names)-1,nchar(names))

#문자열 연결하기 : paste() paste0()
paste(names, 'loves', 'stars.')
paste(names, 'loves', 'stars.', sep='★', collapse='/')

#문
name<-c('Yi','Lim','Kim'); hobby<-c('swim','sleep','eat');
cat(paste(name, hobby, sep="의 취미는 ", collapse="이고, "),"이다.")

#문자 분할 (구분자로 분할하기)
path <- 'home/hadoop/data/speech.csv'
strsplit(path,'/')
customerInfo<-'jin@gmail.com,010-8888-8888,seoul Korea'
strsplit(customerInfo,',010-8888-8888,')
customers <- c('jin@gmail.com,010-8888-8888,seoul Korea','yis@gmail.com,010-9999-9999,Inchon Korea','kim@naver.com,010-7777-7777, Mapo')
strsplit(customers, ',[0-9]{2,3}-[0-9]{3,4}-[0-9]{4},')

#문자열 대체 sub(oldStr, newStr, string) 처음 나오는 oldStr을 newStr로 바꿈
#            gsub(oldStr, newStr, string) 다 바꿈
s <- 'Curly\\ is the smart one. 



Curly is funny, too.★'
sub('Curly','Kim',s)
gsub('Curly','Kim',s)
gsub('[★\n]','',s)
s
#외적 : outer; 문자열의 모든 쌍별 조합 만들기
a<-c('aa','bb','cc')
b<-c('11','22','33')
outer(a,b, FUN='paste')

#날짜
today<-Sys.Date()
thatday<-as.Date('21-06-28', '%y-%m-%d') 
# %Y 년도 4자리 %y 년도 2자리 %m 월 %d 일
thisday<-as.Date('06/09/2021','%m/%d/%Y')
if(thatday<today){
  cat('thatday보다 today가 훗날')
}
today

