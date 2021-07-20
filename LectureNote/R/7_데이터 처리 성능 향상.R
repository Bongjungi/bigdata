#########################################
#######7장. 데이터 처리 성능 향상########
#########################################
#이 장의 내용 : plyr패키지(apply계열 함수 대치), 데이터 구조변경(melt,cast), 데이터테이블
#### 1. plyr 패키지####
install.packages("plyr")
library(plyr)
apply(iris[,1:4],2,mean)
apply(iris[,1:4],2,FUN=function(col){mean(col)})

x<-data.frame(v1=c(4,9,16),v2=c(16,81,196))
apply(x,2,FUN=function(col){sum(sqrt(col))})
adply(.data=x, .margins = 2, .fun=function(col){sum(sqrt(col))})

#종별 Sepal.Length평균, Sepal.Width 평균
library(doBy)
summaryBy(Sepal.Length+Sepal.Width~Species, data=iris, FUN = mean)
ddply(.data = iris, .(Species), function(group){
  data.frame(SL.mean=mean(group$Sepal.Length),
             SW.mean=mean(group$Sepal.Width))
})
#summarise : 명시된 변수들만 출력
ddply(.data=iris, .(Species), summarise, SL.mean=mean(Sepal.Length), SW.mean=mean(Sepal.Width))
#transform : 기존의 iris 변수 뒤에 명시된 변수가 추가되서 출력
ddply(.data=iris, .(Species),transform , SL.mean=mean(Sepal.Length), SW.mean=mean(Sepal.Width))

### 2. 데이터 구조 변경 (melt, cast함수) ###
View(airquality)
install.packages("reshape2")
library(reshape2)
airquality.melt<-melt(airquality,id=c('Month','Day'),value.name = "val")
head(airquality.melt)
airquality
#melt를 통해 바뀐 구조(5월 5일 데이터)
subset(airquality, Month==5&Day==5)
subset(airquality.melt, Month==5&Day==5)
airquality.melt
airquality.melt2<-melt(airquality, id=c('Month','Day'), na.rm = T)
subset(airquality.melt2, Month==5&Day==5)

#melt된 데이터를 원상 복구 : dcast vs. acast
airquality.dc <- dcast(airquality.melt2, Month+Day~variable)
airquality.dc[airquality.dc$Month==5 & airquality.dc$Day==1,]

airquality.ac <- acast(airquality.melt2, Month+Day~variable)
airquality.ac['5_1',]

###데이터 구조 변경 예
df1<-read.csv(file = 'D:\\Bigdata\\download\\sharedBigdata\\전국 평균 평당 분양가격(2013년 9월부터 2015년 8월까지).csv')
df2<-read.csv(file = 'D:\\Bigdata\\download\\sharedBigdata\\주택도시보증공사_전국 신규 민간아파트 분양가격 동향_20210531.csv')
df1.melt<-melt(df1, id=c('지역'),value.name='price')
class(df1.melt$variable)
df1.melt$variable<-as.character(df1.melt$variable)
#variable에서 년도 뽑기
df1.melt$연도<-as.integer(substr(df1.melt$variable,2,5))
#variable에서 월 뽑기
#(1)
df1.melt$월<-as.integer(strsplit(strsplit(df1.melt$variable,'년')[[1]][2],'월')[[1]][1])
df1.melt$variable<-NULL
df1.melt
#(2)
var
(monthstr<-strsplit(var,'년')[[1]][2])
(monthstr<-substr(monthstr,1,nchar(monthstr)-1))
#####################
df2
df2<-df2[df2$규모구분=='모든면적',]
df2$규모구분<-NULL
df2
df1.melt
colnames(df2)<-c('지역','연도','월','price')
df2[df2$price=="",]
colSums(is.na(df2))
df2
str(df2)
df2$price<-as.integer(df2$price)
df2$price<-df2$price*3.3
head(df1.melt)
head(df2)
df<-rbind(df1.melt,df2)
df

#### 3. 데이터 테이블 : 짧고 유연한 빠른 구문을 사용하기 위해 데이터프레임에서 상속받음###

flightDF<-read.csv('ch01/inData/flights14.csv', header = T)
head(flightDF)
table(flightDF)
class(flightDF)
install.packages('data.table')
library('data.table')
flights<-fread('ch01/inData/flights14.csv')
head(flights)


# 1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다
resul<-flightDF[flightDF$origin=='JFK' & flightDF$month==5, ]
resul<-flights[origin=='JFK' & month==5]
resul
# 2. 처음 두 행을 resul에 얻는다
resul<-head(flightDF,2)
# 3. origin으로 오름차순, dest로 내림차순으로 정렬하여 출력
flightDF[order(flightDF$origin),][order(flightDF[order(flightDF$origin),]$dest, decreasing = T),]

library(dplyr)
flightDF[order(flightDF$origin, desc(flightDF$dest)),]

flights[order(origin, -dest)]
# 4. arr_delay열만 출력
colnames(flightDF)
flightDF['arr_delay']

flights[, .(arr_delay)] #데이터 프레임(테이블) 형태로 출력
flights[, c('arr_delay')] #데이터 프레임 형태
flights[, c(arr_delay)] #벡터형태
flights[, list(arr_delay)]#데이터 프레임
# 5. year열부터 dep_time열까지 출력
flightDF[,1:4]

subset(flights, select=c(year:dep_time))
flights[, year:dep_time]
# 6. year열과 dep_time열 출력
flightDF[,c('year','dep_time')]

flights[, list(year,dep_time)]
flights[, .(year,dep_time)]

# 7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경
rename(flightDF[,c('arr_delay','dep_delay'),],delay_arr=arr_delay,delay_dep=dep_delay)

flights[, .(delay_arr=arr_delay,delay_dep=dep_delay)]
# 8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
nrow(flightDF[flightDF$arr_delay<0 & flightDF$dep_delay<0,])

flights[arr_delay<0 & dep_delay<0, .(cnt=.N)] #.N:갯수수
flights[, sum(arr_delay<0 & dep_delay<0)]
#         8-1 지연시간의 합이 0미만인 비행이 몇 번인지 출력
nrow(flightDF[(flightDF$arr_delay+flightDF$dep_delay)<0,])

flights[arr_delay+dep_delay<0, .(.N)]
flights[arr_delay+dep_delay<0, .N]
#         9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
sapply(flightDF[flightDF$month==6 & flightDF$origin=='JFK', ][,c('dep_delay','arr_delay')],mean)

flights[origin=='JFK' & month==6, .(mean_arr=mean(arr_delay),mean_dep=mean(dep_delay))]
#         10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
c<-sapply(flightDF[flightDF$month==6 & flightDF$origin=='JFK', ][,c('dep_delay','arr_delay')],mean)
names(c)<-c('mean_dep','mean_arr')
c
#         11. JFK 공항의 6월 운항 횟수
nrow(flightDF[(flightDF$origin=='JFK' | flightDF$dest=='JFK') & flightDF$month==6, ])

flights[origin=='JFK'&month==6, .(.N)]
#         12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
flightDF[(flightDF$origin=='JFK' | flightDF$dest=='JFK') & flightDF$month==6, ][,c('arr_delay','dep_delay')]

flights[origin=='JFK'&month==6, .(arr_delay,dep_delay)]
#         13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
flightDF[(flightDF$origin=='JFK' | flightDF$dest=='JFK') & flightDF$month==6,c(-5,-7)]

flights[origin=='JFK'&month==6, -c("arr_delay","dep_delay")]
#         14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
by(flightDF, flightDF$origin, NROW)
table(flightDF$origin)
flights[, .(.N), by=.(origin)]
#         15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
by(flightDF[flightDF$carrier=='AA',][,], flightDF[flightDF$carrier=='AA',][,'origin'], NROW)
table(flightDF[flightDF$carrier=='AA',]$origin)
flights[flights$carrier=='AA', .N, by=.(origin)]
#         16. origin, dest별로 비행횟수 출력
aggregate(flightDF[,1],by=flightDF[,12:13],FUN=NROW)
table(flightDF$origin, flightDF$dest)
flights[, .N, by=.(origin,dest)]
#         17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
aggregate(flightDF[flightDF$carrier=='AA',][,1],by=flightDF[flightDF$carrier=='AA',][,12:13],FUN=NROW)

flights[carrier=="AA", .N, by=.(origin,dest)]
#         18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
aggregate(flightDF[flightDF$carrier=='AA',][,c("arr_delay","dep_delay")],by=flightDF[flightDF$carrier=='AA',][,c("origin","dest","month")],FUN=mean)

flights[carrier=="AA", .(mean_arr_delay=mean(arr_delay),mean_dep_delay=mean(dep_delay)), by=.(origin,dest,month)]
#         19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
flightDF1<-flightDF
flightDF1$depbool<-ifelse(flightDF1$dep_delay>0,'참','거짓')
flightDF1$arrbool<-ifelse(flightDF1$arr_delay>0,'참','거짓')
aggregate(flightDF1[,1], by=flightDF1[,c('depbool',"arrbool")], FUN=NROW)

table(flightDF$dep_delay>0, flightDF$arr_delay>0)

flights[, .N, by=.(dep_delay>0,arr_delay>0)]
#         20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
tapply(flightDF[flightDF$origin=='JFK',]$dep_delay,flightDF[flightDF$origin=='JFK',]$month,max)

flights[origin=="JFK",.(max_arr=max(dep_delay)), by=.(month)]
