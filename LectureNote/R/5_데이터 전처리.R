###5장. 데이터 전처리
##1. 파일 입출력

#1.1시스템 인코딩 조회
#A(65) 가
Sys.getlocale() #Windows는 CP949

#1.2 write.table : 데이터를 파일에 저장
iris
class(iris)
getwd()
write.table(iris,file='ch01/outData/iris.csv', sep = ",", row.names = FALSE)
InsectSprays
summary(InsectSprays)
str(InsectSprays)

#1.3 read.table : 파일의 내용을 데이터 프레임 형태로 읽어옴.
irisData<-read.table(file = "ch01/outData/iris.csv", sep = ',', header = TRUE, encoding = 'utf-8')#엑셀1번줄 열이름,  모든 내용 문자열로 읽어들임
irisData<-read.table(file = "ch01/outData/iris.csv", sep = ',', header = TRUE, encoding = 'utf-8', stringsAsFactors = TRUE)
str(irisData)
emp<-read.table('ch01/indata/emp.csv',sep = ',',header = TRUE, stringsAsFactors = TRUE)
str(emp)

#1.4 write.csv
write.csv(iris, file='ch01/outData/iris.csv')
write.csv(iris, file='ch01/outData/iris1.csv', quote=FALSE, row.names = FALSE)

#1.5 read.csv
newiris <- read.csv(file='ch01/outData/iris1.csv', header = TRUE)
str(newiris)
newiris$Species<-factor(newiris$Species, levels=unique(newiris$Species))

#1.6 cat을 이용한 text 출력
cat('Hello,R','\n', file='ch01/outData/irisSummary.txt', append = TRUE)
irisSummary<-summary(iris)
class(irisSummary)
dim(irisSummary)
irisSummary[1,]
irisSummary[2,]
cat('iris 통계 요약치','\n', file='ch01/outData/irisSummary.txt')
for(i in 1:nrow(irisSummary)){
  cat(irisSummary[i,],'\n', file='ch01/outData/irisSummary.txt', append = TRUE)
}





###2. apply 계열 함수 적용
##2.1 apply - 벡터로 반환
# iris 데이터의 열별 평균(합계, 표준편차, 최소값, 최대값, 중앙값)
# apply(대상자료, 1(행기준)또는2(열기준), 함수)


iris[,-5]
apply(iris[,1:4], 2, FUN=mean) #열별 평균
apply(iris[,1:4], 1, mean) #행별 평균
apply(iris[,1:4], 2, sum)
apply(iris[,1:4], 2, sd)
apply(iris[,1:4], 2, min)
apply(iris[,1:4], 2, max)
apply(iris[,1:4], 2, median)

unique(iris$Species)
levels(iris$Species)[1]
 #종별 열별 평균 구하기
MeanSpe<-function(){
  sum<-data.frame()
  for(i in 1:length(levels(iris$Species))){
    a<-apply(subset(iris,iris$Species==levels(iris$Species)[i], select = -5), 2, mean)
    sum<-rbind(sum,a)
  }
  dimnames(sum)<-list(levels(iris$Species),colnames(iris[-5]))
  return(sum)
}
MeanSpe()

a1<-apply(subset(iris,iris$Species==levels(iris$Species)[1], select = -5), 2, mean)
a2<-apply(subset(iris,iris$Species==levels(iris$Species)[2], select = -5), 2, mean)
a3<-apply(subset(iris,iris$Species==levels(iris$Species)[3], select = -5), 2, mean)
data.frame(a1,a2,a3)
#학생
name<-c('김','이','박','최','윤')
kor<-c(90,91,92,95,94)
eng<-c(91,92,93,94,95)
mat<-c(93,94,95,96,97)
student<-data.frame(name, kor, eng, mat)
student
#학생별 평균
m<- apply(student[,-1],1,mean)
names(m)<-name
m
#과목별 평균
apply(student[,-1],2,mean)

#2.2 lapply : list apply (결과도 list)
lapply(iris[1:4], mean)
list.iris<-as.list(iris[1:4])
list.iris
lapply(list.iris, mean)
x<-list(a=1:10, beta=exp(-3:3),logic=c(T,F,F,T,T,F))
lapply(x, mean)
lapply(x, quantile)
#2.3 sapply : lapply와 유사하나 형식이 다름
sapply(iris[1:4], mean)
sapply(x,mean)
sapply(x,quantile)
sapply(x,quantile, 1:3/4)
fivenum(1:100)
seq(1,100,length.out=5)
i39<-sapply(c(3:9),seq)
i39
sapply(seq(6,24,6),seq)
?seq
(i40<-sapply(c(3:5),seq))
?sapply
lapply(i39, fivenum)
sapply(i39, fivenum)
x2<-list(c('서울시', '서대문구', '홍제3동'), c('경기도', '안산시'),c('경기도', '안산시'),c('경기도', '안산시'))
sapply(x2,paste)
sapply(x2,paste0, collapse=" ")
#2.4 vapply : sapply와 유사하나 FUN의 모든 값이 FUN.VALUE와 호환되는지 확인
vapply(i39, FUN=fivenum, FUN.VALUE = c(numeric(1),numeric(1),numeric(1),numeric(1),numeric(1)))
sapply(iris[1:4], mean)
vapply(iris[1:4], mean, FUN.VALUE = numeric(1))

citys<- c('Seoul','Busan','New York','Tokyo')
nchar(citys)

#2.5 mapply : 함수 적용시 여러개의 인자를 함수에 전달

mapply(rep, x=1:4, times=4:1)
mapply(rep, x=c(1:4,2:5), times=4:1)
mapply(rep, x=1:4, each=c(4,3,2,1))
#직업별 수입
job<-c(3,3,5,2,2,3,5,3,4,4,6,3)
income<- c(4879,6509,4183,0,3894,0,3611,6454,4975,8780,0,4362)
cust
cust<-data.frame(job, income)
income.avg<-c(862,0,3806,3990,3891,3359,3556,2199,227)
names(income.avg)<-0:8
income.avg[2]
income.avg['2']

zero2mean<-function(job,income){
  if(income==0&job!=1){
    #return(income.avg[as.character(job)])
    return(income.avg[job+1])
  }else{
    return(income)
  }
}
cust$income.new<-mapply(zero2mean,cust$job, cust$income)
cust
cust[1]
cust[,1]
a<-unique(iris$Species)
b<-levels(iris$Species)
class(a)
class(b)
a
b

### 3. 데이터 그룹화 함수 적용
##3.1 tapply : 1개열에 대해 그룹화 처리를 위한 apply
tapply(iris$Sepal.Length, iris$Species, FUN=mean)
tapply(iris$Sepal.Width, iris$Species, FUN=mean)
tapply(c(iris$Sepal.Length,iris$Sepal.Width), c(iris$Species,iris$Species), FUN=mean)
boxplot(iris$Sepal.Length ~ iris$Species)
library(vioplot)
install.packages('vioplot')
vioplot(iris$Sepal.Length~ iris$Species)

#직업군별
str(cust)
tapply(cust$income.new, cust$job, FUN=mean)
cust$job<-factor(cust$job, levels=0:8)
levels(cust$job)
unique(cust$job)
tapply(cust$income.new, cust$job, FUN=mean, default=-1) #NA대체값 -1

datasets::InsectSprays
str(InsectSprays)
#spray 종류에 따른 살충효과 점검해 보세요
tapply(InsectSprays$count, InsectSprays$spray, mean)
tapply(InsectSprays$count, InsectSprays$spray, sd)
vioplot(InsectSprays$count~InsectSprays$spray)

##3.2 by : 1개 이상의 열에 대해 1개의 함수로 그룹화 처리
by(iris[,c('Sepal.Length','Sepal.Width')], iris['Species'], sum)
by(iris[,c('Sepal.Length','Sepal.Width')], iris['Species'], mean) #에러- 나누기가 필요하지 않아야함
#cust 직업별 평균, 중위수, 1,3사분위수, 최소값, 최대값을 income과 income2를 한꺼번에
by(cust[,c('income','income.new')], cust$job, summary)
iris


##3.3 doBy 패키지
#   summaryBy : 1개 이상의 열에 대해, 1개 이상의 함수로 1개 이상의 그룹화 처리

summaryBy(formula=Sepal.Length~Species, data=iris, FUN=mean)#FUN기본값 mean
install.packages('doBy')
library(doBy)
?summaryBy
summaryBy(Sepal.Length+Petal.Length~Species, iris, FUN = c(mean,sd))
summaryBy(Sepal.Length+Petal.Length~Species, iris, FUN = c(mean,sd))
#문 emp.csv 파일의 데이터를 받아, 부서별 급여와 상여금을 비교(mean,sd)하시오
getwd()
str(emp)
unique(emp$job)
emp1
emp1<-emp
emp1$deptno<-factor(emp$deptno,levels=c(10,20,30,40))
emp1$job<-factor(emp$job, levels = c("CLERK","SALESMAN","MANAGER","ANALYST","PRESIDENT"))
emp<-read.csv(file = "ch01/inData/emp.csv", header=TRUE)
summaryBy(sal+comm~deptno, emp1, FUN=c(mean,sd))
summaryBy(sal+comm~deptno, emp1, FUN=c(mean,sd), na.rm=TRUE)
#문 emp.csv 파일의 데이터를 받아, 부서별 job별 급여와 상여금 비교(mean,sd)하시오
summaryBy(sal+comm~deptno+job, emp1, FUN=c(mean,sd), na.rm=TRUE)
summaryBy(sal+comm~deptno+job, emp, FUN=c(mean,sd), na.rm=TRUE)

# orderBy : 열기준 정렬한 데이터 프레임
orderBy(~Sepal.Length, data=iris) #Sepal.Length기준으로 오름차순 정렬
orderBy(~Sepal.Length+Petal.Length, data=iris)
orderBy(~Species+Sepal.Length, data=iris)
orderBy(~-Sepal.Length,data=iris)#Sepal.Length기준으로 내림차순
orderBy(~-Sepal.Length+Species, data=iris)
orderBy(~-Sepal.Length-Species,data = iris)#SL내림S내림
#종별, Sepal.Length 오름차순으로 정렬한 데이터의 Sepal.Length, Species열만 출력
orderBy(~Sepal.Length, data=iris)[,c('Sepal.Length','Species')]
orderBy(~Sepal.Length, data=iris[,c('Sepal.Length','Species')])

#문1 emp데이터셋에서 월급이 적은 순으로 ename과 sal을 추출
orderBy(~sal,emp[c('ename','sal')])
#문2 emp데이터셋에서 월급이 적은 순으로 5명만 ename sal 추출
head(orderBy(~sal,emp[c('ename','sal')]),5)
orderBy(~sal,emp[c('ename','sal')])[1:5,]

# sampleBy :  그룹별 데이터를 sampling
library(doBy)
sampleBy(~Species, data=iris, frac=0.2) #종별로 50씩 있으니, 종별로 50*0.2=10개씩 비복원추출
sampleBy(~Species, data=iris, frac=0.2, replace = TRUE) #종별로 10개씩 복원추출
sampleBy(~Species, data=iris, frac = 0.2, systematic = TRUE)#계층적 추출
sample(1:45,6)
iris[sample(1:nrow(iris),10),]

### 4. formula : ~ +
##lm() 선형회귀식 도출 함수(종속변수 ~ 독립변수)
x<-c(1,2,3,4,5)
y<-c(20,45,55,82,94)
plot(x,y)
fit<-lm(y~x)
x<--5:5
fit
lines(x,18.5*x+3.7, col='red')
a<-c(1,1,1,1,1)
b<-c(16,8,4,2,1)
c<-c(81,27,9,3,1)
d<-c(256,64,16,4,1)
e<-c(625,125,25,5,1)
?matrix
Amatrix<-matrix(c(a,b,c,d,e), nrow=5, byrow = TRUE)
Bmatrix<-matrix(y, ncol=1)
ANSmatrix<-solve(Amatrix)%*%Bmatrix
ANSmatrix
lines(x,ANSmatrix[1]*x^4+ANSmatrix[2]*x^3+ANSmatrix[3]*x^2+ANSmatrix[4]*x+ANSmatrix[5], col='blue')

#독립변수가 2개
x1<- c(1,2,3,4,5)#독립변수
x2<- c(10,20,3,4,5)# 양 독립변수는 독립적
y1<-c(60,80,63,84,95)
lm(y1 ~ x1 + x2)
#datasets::cars
cars #속도에 따른 제동거리의 관계를 선형회귀식으로 도출하시오
lm(cars$dist~cars$speed)
lm(dist~speed, data=cars)
plot(cars)
lines(cars$speed,cars$speed*3.932-17.579, col='red')

### 5. 데이터분리
##5.1 split
iris.species <- split(iris, iris$Species) #종별 분리해서 반환
m<-mean(iris$Sepal.Length)
iris.sepal<-split(iris,iris$Sepal.Length>m)
iris.sepal$'TRUE'  #SL이 평균보다 큰 그룹
iris.sepal$'FALSE' #SL이 평균보다 작은 그룹
##5.2 subset
#Sepal.Length가 4이상인 데이터만 추출(Sepal.Length, Petal.Length,Species)
subset(iris, subset=Sepal.Length>=4, select=c('Sepal.Length', 'Petal.Length','Species'))
iris[iris$Sepal.Length>=4,c(1,3,5)]
a<-matrix(1:25, nrow=5)
for(val in 1:5){
  a[val,]<-c(2,3,4,5,6)
}
a

### 6. 데이터합치기
## 열합치기 cbind()
## 행합치기 rbind()
## 결합하기 merge()
(student.a<-data.frame(id=c(101,102),score=c(100,90)))
(student.b<-data.frame(id=c(101,102),score=c(101,90)))
(student<-cbind(student.a,student.b))
(student<-rbind(student.a,student.b)) #열 이름이 맞아야됨
(student.a<-data.frame(name=c('l','p'),kor=c(100,90)))
(student.b<-data.frame(name=c('l','c'),eng=c(101,90)))
(student<-merge(student.a,student.b, all = T))

###7.데이터 정렬
##sort() : 정렬된 데이터 반환 / order() : 정렬된 데이터의 index를 반환
data<-c(10,30,100,1,3)
sort(data, decreasing = TRUE)
names(data)<-c('1번째','2번째','3번째','4번째','5번째')
data
sort(data) #값을 정렬해서 값을 표시
order(data)#값을 정렬해서 인덱스를 표시
data[order(data)]
#iris데이터를 SL기준으로 내림차순 정렬
orderBy(~-Sepal.Length, data=iris)
sort(iris$Sepal.Length, decreasing = T)
order(iris$Sepal.Length, decreasing = T)
iris[order(iris$Sepal.Length, decreasing = T),]

#문1 emp데이터셋에서 월급이 많은 순으로 ename, sal을 추출
emp<-read.csv(file='ch01/inData/emp.csv',header = TRUE)
emp
order(emp$sal, decreasing = T)
emp[order(emp$sal, decreasing = T),][c('ename','sal')]
#문2 emp데이터셋에서 월급이 많은 top 5의 ename, sal 추출
emp[order(emp$sal, decreasing = T),][1:5,c('ename','sal')]


q1<-c(1,2,1,2,1)
q2<-c(2,1,2,1,2)
q3<-ifelse(q1>q2,q1,q2)
###8. 데이터 프레임 이름 생략하기
##8.1 with절, within절
iris.temp<-iris
iris.temp[c(1,3),1]<-NA
head(iris.temp)
#SL의 종별 중앙값
mps<-tapply(iris.temp$Sepal.Length, iris.temp$Species, FUN=median, na.rm=T)
mps[iris.temp$Species]
iris.temp$Sepal.Length2<-iris.temp$Sepal.Length
iris.temp$Sepal.Length3<-mps[iris.temp$Species]
iris.temp$Sepal.Length2<-ifelse(is.na(iris.temp$Sepal.Length),mps[iris.temp$Species],iris.temp$Sepal.Length)
head(iris.temp[,c('Sepal.Length','Sepal.Length2')],3)
iris.temp

## with절
iris.temp$Sepal.Length2 <- with(iris.temp,{
  Sepal.Length<-ifelse(is.na(Sepal.Length), mps[Species],Sepal.Length)
})
head(iris.temp)
iris.temp <- within(iris.temp,{
  Sepal.Length<-ifelse(is.na(Sepal.Length), mps[Species],Sepal.Length)
})

##8.2 attach()
attach(iris) #지금부터는 iris$ 생략해도 됨
summary(Species)
detach(iris) #지금부터는 iris$ 생략하면 안됨

###9. 데이터 집계 함수
##9.1 table()
table(iris$Species) #종별 갯수

# InsectSprays 데이터 셋에서 spray별 집계
table(InsectSprays$spray)

# emp데이터 셋에서 deptno별 집계
table(emp$deptno)

##9.2 aggregate() : 1개 이상의 열에 대해, 1개 이상의 그룹화 처리(적용함수는 1개)
aggregate(iris[,1:4],by=list(iris[,5]),FUN=mean)
tapply(iris$Sepal.Length, iris$Species, mean)
summaryBy(Sepal.Length+Petal.Length~Species, data=iris, FUN=mean)

#보험회사의 고객들의 보험금 청구 데이터에서 고객별 입원일 조회
cust_id<- c(1001,1002,1001,1003,1002,1004,1005,1001,1002,1001)
hos_day<- c(2,3,20,5,1,8,2,2,3,2)
data<-data.frame(cust_id, hos_day)
data
day_per_cust<-aggregate(data$hos_day, by=list(data$cust_id), FUN=sum)
day_per_cust
names(day_per_cust)<-c('cust_id','hos_day')
order(-day_per_cust$hos_day)
day_per_cust[order(-day_per_cust$hos_day),]

#조건으로 색인찾기 : which(), which.min(), which.max()
which(iris$Species=='setosa') # setosa의 데이터 색인
iris[which(iris$Species=='setosa'),]
which.min(iris$Sepal.Length) #SL의 최소값이 있는 데이터 색인
which.max(iris$Sepal.Length) #SL의 최대값이 있는 데이터 색인인
