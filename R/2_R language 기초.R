#1.5주석
#자동완성 : Tab
R.version
#1.6 정보
iris
edit(iris)
attributes(iris)




## 2. 패키지
# R 내의 기본 패키지외의 패키지는 다운받는다.
# 1. 패키지 설치 :
      #install.packages("패키지명")
      #설치된 패키지를 메모리에 로드 : library("패키지명")
      #로드된 패키지 안의 데이터나 함수 사용 가능
      #패키지 언로드 : detach("package:패키지명", unload=TRUE)
dim(available.packages()) #CRAN site에 업로드된 패키지 갯수
available.packages()
install.packages("stringr") #1. 패키지 설치
library(stringr) #2. 메모리 로드
?str_extract() 
data <- '홍길동 35 이순신 45 김말동 12'
str_extract(data, '[1-9]{2}')   #3.
str_extract_all(data, '[1-9]{2}')
detach("package:stringr", unload = TRUE)
iris #datasets(기본 패키지) 내의 데이터
detach("package:datasets", unload = TRUE)

#메모리에 로드 없이 데이터 사용
rm(data) #data 변수 삭제
data(iris, package="datasets") #변수 data에 함수를 넣을 수 없다??





##3.변수
result<-0
result<-10
result<-10:20
result<-c(10:20)
lm(result)
rm(result)
result=c(10,20)
result<-30 #전역변수result
add <- function(a,b){
  result<-a+b #전역변수 값 변경 X, 지역변수 result
  result<<-a+b #전역변수 값도 변경
  return(result)
}
add(20,20)
print(result)
rm(x,x1)
#변수 목록 조회
.a<-10 #히든변수
a<-20
b<-30
c<-a+b
ls() #히든 변수를 제외한 변수 목록 출력
?ls
ls(all.names = TRUE) #히든 변수를 포함한 변수 목록 출력
ls.str() #변수 이름과 구조를 함께 보여줌

##4. 출력
#(1) print
print(result)
(a<-10)
msg<-"Hello, R
Hello, Python"
print(msg)
#(2) cat
cat(msg)
cat("\"메세지는 ",msg,"\"")
cat("result = ",result)
fibo<-c(1,1,2,3,5,8,13) #벡터(동일자료형의 집합)
cat("fibo의 length는 : ",fibo,"\n")

#(3) paste
?paste
paste("Hello","World")
paste0("hello","world")
paste("hello","world","",sep="//")
paste("result 값은 ",fibo)

temp<-paste(c(1,2,3,4),c('하나','둘'), sep='은 ')

month.abb #월이름 약자
month.name#월이름름
nth<-paste(1:12,c('st','nd','rd',rep('th',9)),sep = "")
paste(month.name, nth, sep=':')

##5.변수 삭제
ls(all.names = TRUE)
#특정 변수만 삭제
rm(nth)
#일반 변수 목록의 변수들 삭제
rm(list = ls())
rm(list=ls(all.names = TRUE))

a<-10
.a<-10

#####문1. kor변수에 한국,일본,미국 eng변수에 korea,japan,usa
#####    출력: 한국:korea ...
kor<-c('한국','일본','미국')
eng<-c('korea','japan','usa')
paste(kor,eng,sep = ":", collapse = ", ")
#####문2. MASS::Cars93 데이터를 출력해 보시오.
.libPaths() #내 시스템 R패키지가 설치된 폴더
iris
##install.packages('MASS') 이미 있어서 안해도 됌
##library(MASS)            이미 있어서 안해도 됌require(MASS)로 대체가능
edit(Cars93)
head(Cars93) #1행부터 #6행까지만
head(Cars93,5) #1행부터 #5행까지만
tail(Cars93,3) #끝에서 3행
detach('package:MASS', unload = "TRUE")
#####문3. 도움말
?mean #함수 도움말
help(mean)
library(help="MASS") #라이브러리(패키지) 도움말
