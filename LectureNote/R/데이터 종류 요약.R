
###종류(벡터, 리스트, 행렬, 배열, 데이터프레임)
a<-c(1,2,3) #1.벡터
list(c(1,2,3),c(1,3)) #2.리스트
m<-matrix(c(c(1,2,3),c(4,5,6)),nrow = 2,ncol=NROW(a), byrow = TRUE) #3.행렬
t(m) #m의 전치행렬
diag(3) #단위행렬
solve(m) #m의 역행렬
dataArray<- array(1:24,dim=c(3,4,2)) #4.#3차원 numeric 배열 (3행4열2면)

student_id <- c('20211','20212','20213','20214')
student_name <- c('jin','eric','den','kei')
student<-data.frame(student_id,student_name) #5.데이터프레임

###데이터 타입
str(iris) #num num num num factor
factor(c('남','여','남','남','여'), levels=c('남','여'))
class(1)
integer(1)+1
class('남')
class(TRUE)
#NULL,NA,NAN,Inf
#결측치(NA) 관련함수
#is.na(d): 결측치인지 아닌지 여부 반환
#complete.cases(d) : d변수에 결측치가 없으면 TRUE
#na.omit(d): 결측치 제외
#na.pass(d): NA 여부와 상관없이 처리


####문자열
LETTERS
letters
month.name
#문자길이
length(c('akak','asd')) #2
nchar(c('akak','asd')) #4 3
#문자추출
substr('ABCDEF', 4, 16) #4~16번째 문자 추출. 없는 문자는 ""로 처리
substring('ABCDEF', c(1,2), c(1,3)) #1~1번째 문자 추출, 2~3번째 문자 추출
#문자결합
names<-c(1,2,3)
paste(names, 'loves', 'stars.', sep='★', collapse='/')
cat('a','b','c', sep = "")
#문자 분할 (구분자로 분할하기)
path <- 'home/hadoop/data/speech.csv'
strsplit(path,'/')

customers <- c('jin@gmail.com,010-8888-8888,seoul Korea','yis@gmail.com,010-9999-9999,Inchon Korea','kim@naver.com,010-7777-7777, Mapo')
strsplit(customers, ',[0-9]{2,3}-[0-9]{3,4}-[0-9]{4},')

#문자열 대체 sub(oldStr, newStr, string) 처음 나오는 oldStr을 newStr로 바꿈
#            gsub(oldStr, newStr, string) 다 바꿈
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