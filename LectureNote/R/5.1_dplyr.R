################################################
###5-1장. dplyr 패키지를 이용한 데이터 전처리###
################################################
###1.외부파일 read / write
##1.1 엑셀파일 읽어오기 read
install.packages("readxl")
library(readxl)
getwd()
exam<-read_excel("D:/Bigdata/src/R/ch01/inData/exam.xlsx") #첫번째 sheet의 값을 read
class(exam)
exam<- as.data.frame(exam)
exam
exam2<-as.data.frame(read_excel("D:/Bigdata/src/R/ch01/inData/exam.xlsx",sheet = 2))
exam2
?read_excel
#데이터 파일에 컬럼명이 없는 경우
city<-as.data.frame(read_excel("D:/Bigdata/src/R/ch01/inData/data_ex.xls", col_names = F))
colnames(city)<-c('id','gender','age','area')
##1.2 데이터 쓰기(파일(csv)로 쓰기, 변수로쓰기)
.libPaths()
write.csv(exam,'ch01/outData/exam.csv',row.names = T) #csv에 쓰기
save(exam,file='ch01/outData/exam.rda') #exam변수를 파일에 저장
rm(list = ls(all.names=T))
exam
load('ch01/outData/exam.rda')

#데이터 준비, 패키지 준비
data(mpg,package='ggplot2') #1번 방법
mpg<-as.data.frame(ggplot2::mpg) #2번 방법
midwest<-as.data.frame(ggplot2::midwest)
?ggplot2
library(dplyr)
library(ggplot2)
#데이터 파악
head(mpg)
tail(mpg)
edit(mpg)
View(mpg)
dim(mpg)
str(mpg)
summary(mpg)
names(mpg)
#변수명 수정
#reshape의 rename은 rename(데이터, c('원래이름'='이름', , ,))
#이건 dplyr의 rename
mpg<-rename(mpg, company=manufacturer, city=cty, highway=hwy) ##manufacturer를 company로 변경
#파생변수 생성
mpg$total<-(mpg$city+mpg$highway)/2
#변수 조합
mpg$test<-ifelse(mpg$total>=mean(mpg$total), "pass","fail")
#빈도 확인
hist(mpg$total)
boxplot(mpg$total) #IQR보다 1사, 3사에서 1.5배 떨어져 있으면 이상치
table(mpg$test)
qplot(mpg$test)
str(midwest)
midwest<-rename(midwest, total=poptotal, asian=popasian)
midwest$perasian<-midwest$asian/midwest$total
hist(midwest$perasian)
midwest$asiaAvg<-ifelse(midwest$perasian>mean(midwest$perasian),'large','small')
table(midwest$asiaAvg)

#######dplyr전처리
#1.filter(행 선택)-조건에 맞는 데이터 추출하기
filter(mpg,company=='audi' | year==1999)
filter(mpg,company=='audi', year==1999) # ',' '&'
filter(mpg,company %in% c('audi','dodge'))
filter(mpg,grepl('au',company))
mpg%>%filter(company=='audi', year==1999)

#2.select(열 선택)
mpg%>%filter(company=='audi')%>%select(model)
mpg%>%select(model)

#3.arrange(정렬)
mpg%>%arrange(displ)
mpg%>%arrange(desc(displ))
mpg%>%arrange(displ,year)
mpg%>%filter(company=='audi')%>%arrange(desc(displ))%>%head(3)

#4. mutate(변수 추가(새 필드))
mutate(mpg,cyl2=cyl*2)
mpg%>%mutate(cyl2=cyl*3)
mpg
#5. group by, summarise(통계치 산출)
summarise(mpg,mean_cyl=mean(cyl))
group_by(mpg,company)
mpg%>%group_by(company)%>%summarize(mean_year=mean(year, na.rm=TRUE))
mpg%>%group_by(company,model)%>%summarize(mean_year=mean(year, na.rm=TRUE),min_cyl=min(cyl))%>%print(n=15)
mpg%>%group_by(company)%>%tally()#그룹별개수
mpg%>%group_by(company)%>%summarise(mean_year=mean(year, na.rm=TRUE))
#compact클래스를 가장 많이 생산하는 회사 #dist_count=n_distinct()
mpg%>%group_by(company)%>%filter(class=='compact')%>%summarise(count=n())%>%arrange(desc(count))



