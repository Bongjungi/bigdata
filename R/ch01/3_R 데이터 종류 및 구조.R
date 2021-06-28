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

