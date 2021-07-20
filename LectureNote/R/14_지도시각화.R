#_____________________________#
###    14장.지도 시각화     ###
#_____________________________#
## 1. 정적 이미지 지도시각화 ##
install.packages('ggmap')
library(ggmap)
seoul<-c(left=126.77, right=127.17, top=37.7, bottom=37.4)
?get_stamenmap
map<-get_stamenmap(seoul,zoom=12,maptype = 'terrain')
map1<-get_stamenmap(seoul,zoom=12,maptype = 'toner')
ggmap(map)
ggmap(map1)
data<-read.csv("ch01/inData/population201901.csv") 
library(stringr)
region<-data$'지역명'
lon<-data$LON
lat<-data$LAT
tot_data<-as.numeric(gsub(',','',data$총인구수))

#지역명, 위도, 경도, 인구수를 데이터프레임 생성
df<- data.frame(region, lon, lat, tot_data)
df<-df[1:17,]
df

#정적 지도 이미지
daegu<-c(left=123.4423013, right=131.601445, top=38.8714354, bottom=32.828306)
map<-get_stamenmap(daegu,zoom=7,maptype = 'terrain')
layer1<-ggmap(map)
layer1
layer2<-layer1+
  geom_point(data=df, aes(x=lon, y=lat, color=factor(tot_data), size=factor(tot_data)))
layer2
layer3<-layer2+
  geom_text(data=df,aes(x=lon, y=lat, label=region), size=2)
layer3

### 2. ggiraphExtra 패키지를 이용한 인터렉티브한 지도 시각화 ###
##2.1 미국 주별 강력 범죄율 시각화
# (1) 패키지 준비
install.packages('ggiraphExtra') #지도시각화를 위한 패키지(인터랙티브 지도)
install.packages('mapproj') #ggChoropleth 함수 사용을 위한 패키지
install.packages('maps') #지도 정보 이용 mapproj인스톨하면 같이 됨
library(ggiraphExtra)
library(mapproj)
library(maps)
library(tibble) #행이름을 변수로 하기 위한 작업
library(ggplot2) #map_data("")
head(USArrests)
.libPaths()
# (2) rownames을 변수로
crime<-rownames_to_column(USArrests, var="state")
map_data("state")
crime$state<-tolower(crime$state) #state를 소문자로
# (3) 미국 지도 주의 위도 경도 가져오기
state_map<-map_data("state")
# (4) 지도 시각화
ggChoropleth(data=crime, #지도에 표현할 데이터
             aes(fill=Murder, map_id=state, tooltip=state), #지도에 채워질 변수, 나타날 지역
             map = state_map, #위도, 경도 지도 데이터
             interactive = T)

##2.2 대한민국 시도별 인구 구분도 시각화
library(stringi)
library(devtools)
devtools::install_github("cardiomoon/kormaps2014")
#에러나면 Rtools 4.0을 설치
library(kormaps2014)
library(dplyr)
library(ggiraphExtra)
library(ggplot2)
head(korpop1,2) #2015년 센서스 데이터(시도별)
head(kormap1,2)
str(korpop1)#에러
str(changeCode(korpop1))
korpop1<-rename(korpop1, name=행정구역별_읍면동,
                pop=총인구_명)
head(korpop1)
korpop1$name<-iconv(korpop1$name, 'UTF-8', 'CP949')
head(korpop1[,c('name','pop','code')])
#지도 시각화
ggChoropleth(data=korpop1,       #지도에 표현할 데이터 셋
             aes(fill=pop,       #지도에 채워질 변수
                 map_id=code,
                 tooltip=name),   #지역 구분 변수
             map=kormap1,        #위도 경도 지도 데이터
             interactive=T)
