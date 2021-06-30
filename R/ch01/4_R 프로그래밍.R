#4장 R 프로그래밍
#-- 제어문, 연산자, function
num<-9
##조건문
#(1)if
if(num%%2==0){
  print(paste(num,'은(는) 짝수입니다.'))  
}else{
  cat(num,"은(는) 홀수", sep="")
}
#(2)ifelse() : 자바 삼항연산자
ifelse(num%%2==0,"짝수","홀수")
(nums<-c(10,9,16,17,20))
result<-ifelse(nums%%2==0,"짝",'홀')
matrix(c(nums,result),nrow = NROW(nums))
matrix(c(nums,result),ncol = NROW(nums), byrow = TRUE)
##(3) switch() :
switch (2,"green","red")   #red
switch (4,"a","a")         #NULL
switch("cc", a=1, cc=,cd=,d=2)
##(4) 사용자로부터 color값을 받아 해당 color를 출력
?readline
rm(color)
color<-switch(readline(prompt='컬러값은(red:1, green:2, blue:3)'), '1'="red",'2'="green",'3'="blue")
#사용자로부터 점수(0~100사이의 정수)를 입력받아 학점을 출력

cat('점수는', as.integer(readline("점수(0~100)는 : ")),' / 등급은',switch(as.integer(score/10)+1,"f","f","f","f","f","f","d","c","b","a","PERFECT"))

getGrade<-function(){
  score<-as.integer(readline("점수(50~100)는 : "))
  grade<-switch(as.integer(score/10)-4,"f","d","c","b","a","PERFECT")
  print(paste('점수는 ', score, " / 학점은 ",grade))
}

##반복문
#(1) for문
1:5
c(1,2,3,4)
seq(1,10)
rep(1:4,2)
x<-c(-2,5,4,8)
a<-0
for(val in x){
  if(val%%2==0){
    a<-a+1
  }
}
for( i in 1:10){
  cat(i, '안녕하세요','\n')
}
#문. factorial 계산 함수를 작성하시오
#fact(3) 결과: 3!=6
#fact(-3) 결과: 음수값을 위한 팩토리얼은 존재하지 않습니다.
#fact(0) 결과: 0!=1
getwd() #워킹디렉토리
setwd("D:/Bigdata/src/R") 
source('factorial.R') #한글UTF-8로 인코딩된 한글 부분 출력
Sys.getlocale() #내 OS의 기본 인코딩 체계(Windows의 기본 인코딩 CP949)
source('ch01/factorial.R',encoding = "UTF-8") #파일이 있는 주소를 입력


fact<-function(){
  wnum<-as.integer(readline('수입력 : '))
  b<-1
  if(wnum==0){
    print(1)
  }else if(wnum<0){
    print('음수 입력 금지')
  }else{
    for(val in wnum:1){
      b<-b*val ##b=b*val로 하면 편하다
    }
    print(b)
  }
}
fact()
fact1<-function(){
  wnum<-as.integer(readline('수입력 : '))
  a<<-1
  if(wnum==0){
    print(1)
  }else if(wnum<0){
    print('음수 입력 금지')
  }else{
    for(val in 1:wnum){
      a<<-a*val
    }
  }
  print(a)
}
fact1()
fact2<-function(){
  wnum<-as.integer(readline('수입력 : '))
  a<-1
  if(wnum==0){
    print(1)
  }else if(wnum<0){
    print('음수 입력 금지')
  }else{
    for(val in 1:wnum){
      a<<-a*val         ##전역변수a<-지역변수a * val
      cat(val, ' ')
    }
  }
  print(a)
}
fact2()

realfact<-function(){
  w<-readline('수 입력 : ')
  if(is.na(as.integer(w))){    ##############에러
    return('숫자를 입력하시오')
  }else{
    wnum<-as.integer(w)
    b<-1
    if(wnum==0){
      return(1)
    }else if(wnum<0){
      return('음수 입력 금지')
    }else{
      for(val in wnum:1){
        b<-b*val ##b=b*val로 하면 편하다
      }
      return(b)
    }
  }
}
realfact()



##(2) while
i<-1

while(i<6){
  print(i)
  i=i+1
  }

##(3) repeat
i<-1
repeat{
  if(i>=6)break;
  print(i)
  i=i+1
}

##break, next(자바에서의 continue)
x<-0
while(x<7){
  x=x+1
  if(x==3)break;
  cat(x,' ')
}
x<-0
while(x<7){
  x=x+1
  if(x==3)next;
  cat(x, " ")
}

##3. 연산자
x<-c(11,2,13)
y<-c(1,12,3)
x+y
x>y
x^y
x%/%y
x<-c(11,2,13,1,1) #5개짜리
y<-c(1,12,3) #3개짜리
x + y ##(1번+1번,2번+2번,3번+3번,4번+1번,5번+2번)
x+1

##3.2 논리 연산자 &, &&, |, ||
TRUE && TRUE
TRUE & TRUE
x<-c(T,T,F,F)
y<-c(T,F,T,F)
x&y #모든 요소끼리 다 체크
x|y #모든 요소끼리 다 체크
x && y # 첫번째 요소끼리만 체크
x || y 

##3.3 중위 연산자
5+8
'+'(5,8)
'%@%' <- function(a,b){
  return(2*a+2*b)
}
10%@%20
10%in%c(10,20,30)
rm(list=ls())

# %o% 외적
# %*% 내적
c(10,20,30)%*%c(10,20,30)
c(2,5,7)%o%c(10,20,30)
a<-c('1','2','3')
b<-c('a','b','c')
outer(a,b,FUN=paste)
matrix.a <-matrix(1:6, nrow = 3) #3x2
matrix.b <-matrix(1:6, nrow = 2) #2x3
matrix.a %*% matrix.b
solve(matrix.a)

## 4.함수
pow <- function(x,y=1){
  return(x^y)
}
pow(2)
pow(2,3)
pow(y=2,x=3)
pow1 <- function(x=1,y){
  return(x^y)
}
pow1(2) ##에러, 초기화 안한 변수를 앞쪽에 놓는 것이 좋다.
pow1(y=2)
pow1(y=2,2)
#명시적으로 return()을 사용할 경우 NULL이 return 
check <- function(x){
  if(x>0){
    result<-'양수'
    return(result)
  }else if(x<0){
    result<-'음수'
  }else{
  }
}
check(-1)
(temp<-check(-1))
(temp1<-check(0))

#가변인자함수
total()
total(1)
total(1,2,3,4,5)
total<- function(...){
  args<-c(...)
  sum<-0
  for(val in args){
    sum<-sum + val
  }
  return(sum)
}

#재귀함수 : 함수 내에서 함수를 호출
#recurse.fact(n)=recurse.fact(n-1)*n
recurse.fact <- function(num){
  if(num<0){
    cat('음수 금지')
    return()
  }else if(num==0){
    return(1)
  }else{
    return(num*recurse.fact(num-1))
  }
}
recurse.fact(3)

##5. R 환경과 유효범위
environment()
ls()
f<-function(f_x){
  g<-function(g_x){
    print('g 함수 안')
    print(environment())
    print(paste('g 함수 영역에서의 변수들 :', ls()))
  }
  g(5)
  print('f 함수 안')
  print(environment())
  print(paste('f 함수 영역에서의 변수들 :', ls()))
}
f(10)
