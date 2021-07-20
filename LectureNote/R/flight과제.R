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
#         8-1 지연시간의 합이 0미만인 비행이 몇 번인지 출력
nrow(flightDF[flightDF$arr_delay+flightDF$dep_delay<0,])
#         9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
sapply(flightDF[flightDF$month==6 & flightDF$origin=='JFK', ][,c('dep_delay','arr_delay')],mean)
#         10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
c<-sapply(flightDF[flightDF$month==6 & flightDF$origin=='JFK', ][,c('dep_delay','arr_delay')],mean)
names(c)<-c('mean_dep','mean_arr')
c
#         11. JFK 공항의 6월 운항 횟수
nrow(flightDF[(flightDF$origin=='JFK' | flightDF$dest=='JFK') & flightDF$month==6, ])
#         12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
flightDF[(flightDF$origin=='JFK' | flightDF$dest=='JFK') & flightDF$month==6, ][,c('arr_delay','dep_delay')]
#         13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
flightDF[(flightDF$origin=='JFK' | flightDF$dest=='JFK') & flightDF$month==6, ][,c(-5,-7)]
#         14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
by(flightDF, flightDF$origin, NROW)
#         15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
by(flightDF[flightDF$carrier=='AA',][,], flightDF[flightDF$carrier=='AA',][,'origin'], NROW)

#         16. origin, dest별로 비행횟수 출력
aggregate(flightDF[,1],by=flightDF[,12:13],FUN=NROW)

#         17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
aggregate(flightDF[flightDF$carrier=='AA',][,1],by=flightDF[flightDF$carrier=='AA',][,12:13],FUN=NROW)

#         18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
aggregate(flightDF[flightDF$carrier=='AA',][,c("arr_delay","dep_delay")],by=flightDF[flightDF$carrier=='AA',][,c("origin","dest","month")],FUN=mean)

#         19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
flightDF1<-flightDF
flightDF1$depbool<-ifelse(flightDF1$dep_delay>0,'참','거짓')
flightDF1$arrbool<-ifelse(flightDF1$arr_delay>0,'참','거짓')
aggregate(flightDF1[,1], by=flightDF1[,c('depbool',"arrbool")], FUN=NROW)

#         20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
tapply(flightDF[flightDF$origin=='JFK',]$arr_delay,flightDF[flightDF$origin=='JFK',]$month,max)



