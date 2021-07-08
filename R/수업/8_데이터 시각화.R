#-------------------------#
####8장. 데이터 시각화 ####
#-------------------------#
### 1. 시각화 개요 : 원본데이터나 분석된 결과 데이터를 그래프로 표현. 사용자에게 효과적으로 정보전달 목적 ###

##1.1 R의 그래픽 시스템
# (1) base graphics system : 전통적인 함수 이용(고수준 그래프 함수, 저수준 그래프 함수)
      # 그래프 종류별 함수가 각기 달라 정교한 그래프 이용시 노력 필요
# (2) grid graphic system - base graphic system의 한계 극복을 위해 만든 패키지(ggplot2)
      # 유연한 그래프 환결 제공

#ex. 
plot(mtcars$wt, mtcars$mpg) #고수준 그래프 함수(그래프 그릴 때마다 새로 그려짐)
boxplot(mtcars$mpg) #고수준 그래프 함수
fit<-lm(mtcars$mpg ~ mtcars$wt)
class(fit)  #lm
abline(fit, col='red')
plot(fit) #선형 회귀 모델의 진단 그래프

library(ggplot2)
ggplot(data=mtcars,aes(x=wt, y=mpg))+
  geom_point(col='blue', pch=2)+
  labs(title='첫 산점도 예제')+
  geom_smooth(method = "lm")

ggplot(data=iris, aes(x=Species, y=Sepal.Length))+
  geom_boxplot(col="blue", fill="red")

##1.2 그래프 함수
  #고수준 함수 : plot, barplot, boxplot, hist, pie, ...
    #호출 시 새로운 그래프를 그림.
  #저수준 함수 : lines, abline(회귀라인), point,text
    #호출 시 기존의 그래프에 포함됨.

##1.3 그래프 파라미터 : 그래프를 그리는 함수들은 다양한 파라미터가 존재. par()함수를 통해 변경
#(1) par() : 그래프를 조정하거나 특성을 지정 ex.bty(그래프박스유형), 선굵기, 색상...
  #par()함수의 리턴값은 실행전 특성 리턴
a<-tapply(cars$dist,cars$speed,mean)

cars
plot(cars)
oldPar<-par(bty="o") #파라미터 지정전 객체를 저장
plot(cars)#변경된 파라미터 대로 그래프가 그려짐
plot(iris)
par(oldPar) #oldPar 설정으로 복귀
plot(cars, xlab="x label", ylab="y label", main="제목")
fit<-lm(dist~speed, data=cars)
abline(fit, col="red", lwd=4, lty="dashed")

#par함수의 다른 파라미터 사용 예
x<-1:100
y1<-rnorm(100) #표준정규분포 만족하는 100개 추출
y2<-rnorm(100)+100
oldPar<-par(mar=c(5,5,5,5)) #그래프 여백(하,좌,상,우)
plot(x,y1, type = 'b', pch=2, col='red')
plot(x,y1, type = 'b', pch=23, col='red', bg="blue", ylim = c(-8,2), yaxt="n",bty="n", ylab="")
#xlim, ylim : x,y축 눈금 조정
#yaxt : y축 없애기
#bty : 그래프 박스 type : o, ], L, 7, C
axis(side=2, at=c(-2,0,2))
 #side : 1하 2좌 3상 4우
mtext("red_line(y1)", side = 2, line=2, at=0, col = 2)
par(new=T) # 기존그래프 지우지 않고 덧그림
plot(x,y2,pch=20,type="b",col="blue",yaxt="n",ylim=c(98,108),ylab = "", bty="n")
axis(side =4,at=c(98,100,102,108))
mtext("blue_line(y2)", side=4, line=2, at=100, col='blue')
par(oldPar) # 그래프 영역 설정 원상 복구

####2. 고수준 그래프 함수 #### (base graphic system)
## 2.1 plot : type에 따라 여러 유형의 그래프를 그림, 산점도 함수
#3행 2열로 그래프 영역 분리하고 type 속성에 따른 그래프
?par
oldPar <- par(mfrow=c(3,2))
plot(cars, type='p', main='p type')#일반적
plot(cars, type='l', main='l type')#추세선
plot(cars, type='b', main='b type')#선과점 안 겹치게
plot(cars, type='s', main='s type')#계단형
plot(cars, type='n', main='n type')#안 보여
plot(cars, type='o', main='o type')#선과 점 겹치게
par(oldPar)

plot(cars, main="speed and Stopping Distance of cars",xlab="speed(mph)",ylab="stopping distance(ft)",las=1)
#las : 축눈금라벨방향 - 0:축과평행, 1:가로 2:축과수직, 3:세로로

## 2.2 barplot : 막대그래프
datasets::VADeaths
VADeaths
?plot
barplot(VADeaths,main = "title", font=2, border='red', legend=rownames(VADeaths), density = 50, angle=c(10,30,50,70,120), col=c(1,2,3,4,5))
#font : 1.기본값, 2.굵게 3이텔릭체 4굵은이텔릭체
#legend : 오른쪽 상단 범례
#density : 막대그래프 안에 칠할 선의 수
#angle : 빗금 각도
barplot(VADeaths, main = 'title', font=2, border='red', legend=rownames(VADeaths),beside = T,col=rainbow(5))
barplot(VADeaths, main = 'title', font=2, border='red', legend=rownames(VADeaths),beside = T,col=pal)
#파레트 패키지 이용
install.packages("RColorBrewer")
library(RColorBrewer)
display.brewer.all()
pal<-brewer.pal(5,"Set1")

##2.3 boxplot : 상자그림(상자도표, 사분위수 그래프)
InsectSprays
boxplot(InsectSprays$count)
boxplot(count~spray,data = InsectSprays, col=pal)
by(InsectSprays$count,InsectSprays$spray,summary)

##2.4 hist : 히스토그램(도수분포표 - 연속된 데이터의 도수분포)
x<-c(1,1,2,2,2,3,4,4)
hist(x)
hist(x, breaks = c(1,2,3,4))#구간설정 : 1이상2미만, 2이상3미만, ...
h<-hist(x, breaks = c(0.5,1.5,2.5,3.5,4.5))

text(h$mids, h$counts, paste(h$counts, "개", sep=""),col="blue")
text(h$mids, h$counts, paste(h$counts, "개", sep=""),adj=c(0.5,-0.5),col="red")#왼쪽으로0.5만큼 아래로 -0.5만큼
#list를 히스토그램으로
h1<-list(breaks=c(0.5,1.5,2.5,3.5,4.5),counts=c(2,3,1,2),density=c(0.25,0.375,0.125,0.25),mids=c(1,2,3,4),xnames="x",equidist=TRUE)

class(h1)<-'histogram'
plot(h1)
islands #1만 평방마일을 초과하는 주요대륙 넓이 정보
hist(islands)
hist(sqrt(islands),breaks = c(2,30,70,100,140))
set.seed(14)
x<-rnorm(1000)
hist(x)

##2.5 pie 
x<- c(20,30,30,20,15,5)
pie.lang<-x/sum(x)
names(pie.lang)<-c('c','java','python','R','Oracle','Hadoop')
pie(pie.lang) #반시계방향
pie(pie.lang, clockwise = TRUE, col=brewer.pal(6, 'Set3'))

##2.6 mosaicplot : 배열형식의 표를 이용해 모자이크 플롯 출력
class(Titanic)
mosaicplot(~Sex+Age+Survived, data=Titanic, color=T)
mosaicplot(~Class+Age+Survived, data=Titanic, color=T)



#### 3. 저수준 그래프 함수 ####
## 3.1 points
plot(-4:4, -4:4, type="n")
points(rnorm(100),rnorm(100))
points(4,4)
## 3.2 lines : 선
plot(cars$dist,cars$speed)
abline(lm(cars$speed~cars$dist),col='red')
lines(cars$dist,0.1655676*cars$dist+8.2839056,col='blue',lty="dashed",lwd=2)
## 3.3 text(x, y, 출력할 텍스트, 그 외 옵션들)
plot(-1:1, -1:1, type = "n", xlab = "X")
points(0,0,pch=3, cex=4, lwd=3) #cex크기
text(0,0,'hello')
text(0,0,"red", col="red", font=2, cex=3, adj=c(0,0))
text(0,0,"red", col="blue", font=2, cex=3, adj=c(0,0),pos=1)#pos쓰면 adj끝나는듯
text(0,0,"red", col="blue", font=2, cex=3, adj=c(0,0),pos=2)
text(0,0,"blue", col="red", font=2, cex=3, adj=c(1,0))
text(0,0,"blue", col="blue", font=2, cex=3, adj=c(1,0),pos=3)
text(0,0,"yellow", col="red", font=2, cex=3, adj=c(0,1))
text(0,0,"green", col="red", font=2, cex=3, adj=c(1,1))

#수식 출력
plot(1:5,1:5, type="n")
text(3,3,"A", pos=1)
text(4,4,".")
text(4,4,expression(hat(beta)==(X^t)*X^{-1}*X^t*y),pos=3)

#### 4. ggplot2 패키지 함수
install.packages("ggplot2")
library(ggplot2)
## 1. 그래프 초기화(데이터셋, 변수설정)하는 ggplot - 그 자체로는 그래프 표현 X
## 2. 그래프의 결과물에 대응하는 geom 함수
## 3. 부가 요소를 추가 함수
## +  기호를 이용해서 함수들을 연결하는 방식으로 그래프 생성

# ggplot(data,aes(x= , y= )) +
#   geom_(어떤 그래프를 그릴지)+
#   labs(제목, x축, y축, label, 서브제목, 출처)+
#   scale함수()+
#   theme()+
#   coord_cartesian()

ggplot(data=mtcars, aes(x=wt, y=mpg))+
  geom_point(aes(size=wt, col=cyl))+
  labs(title="wt & mpg",
      subtitle="차량 무게와 연비와의 관계",
       x="weight(1,000lbs)",
      y="Fuel consumption(miles per gallon)",
      caption="source : mpg datasets")+
  geom_smooth()
## 4.1 산점도, 적합도
# x축에 Sepal.Length, y축에 Sepal.Width의 산점도(점의 색은 종에 따라 다르게) 그리시오
ggplot(data=iris, aes(x=Petal.Length, y=Petal.Width))+
  geom_point(aes(col=Species))+
  scale_color_manual(values=brewer.pal(3,'Set1'))+
  labs(title = "iris",x="꽃잎길이", y="꽃잎너비")+
  coord_cartesian(ylim=c(0,2.25))+
  geom_smooth(method = "lm")+
  geom_smooth() #데이터 1000개 미만 기본값 loess
?geom_smooth

#airquality연습
airquality
table(airquality$Month, useNA = "ifany")
airquality$Month<-as.factor(airquality$Month)
ggplot(data=airquality, aes(x=Ozone, y=Solar.R))+
  geom_point(aes(col=Month))
#mtcars데이터의 wt,mpg
ggplot(mtcars, aes(x=wt,y=mpg))+
  geom_point(shape=23,col="blue",bg="red",size=2, stroke=2)+
  geom_smooth(method = "loess",col="red")+
  geom_text(label=rownames(mtcars), hjust=0, vjust=0, nudge_y = 0.3, size=3)+
  labs(title = "차량 무게와 연비와의 관계", subtitle="부제목", x="차량무게(1,000lbs)", y="연비", caption="출처 : datasets::mtcars")
#vjust(0위,1아래),hjust(0우,1좌)
head(mtcars)

##4.2 히스토그램 : 연속형 자료형에서 도수분포표
mtcars$mpg
cat(min(mtcars$mpg),max(mtcars$mpg))
ggplot(mtcars, aes(x=mpg))+
  geom_histogram()
#cyl 별로 히스토그램
table(mtcars$cyl)
ggplot(mtcars, aes(x=mpg))+
  geom_histogram()+
  facet_grid(cyl~.)
mtcars$cyl<- factor(mtcars$cyl,levels=c(4,6,8),labels=c('4 cyl','6 cyl','8 cyl'))

##ggplot22::mpg의 displ의 도수분포표(class에 따라 색상을 달리)
ggplot(mpg, aes(x=displ, fill=class))+
  geom_histogram(bins=20,col='black')+  #빈의 개수를 지정하지 않으면 자동 30 # binwidth를 지정하면 binwidth에 따라 빈의 개수 결정
  theme(legend.position = "bottom",
        axis.text.x = element_text(color="red",size=5),
        axis.line= element_line(color='black', size=0.5),
        axis.text.y = element_blank(),
        panel.background = element_rect(fill="lightblue",linetype = "dotted",color = "black"),
        plot.background = element_rect(fill = "lightgreen"))

## 4.3 boxplot
boxplot(iris$Sepal.Length)$stat
ggplot(iris, aes(y=Sepal.Length))+
  geom_boxplot()+
  theme(axis.text.x = element_blank())
#종별 Sepal.Length의 boxplot : 종별 차이가 있는지
ggplot(iris, aes(x=Species, y=Sepal.Length, fill=Species))+
  geom_boxplot(col="red")+
  scale_fill_manual(values=brewer.pal(3,"Pastel1"))
brewer.pal


#gapminder::gapminder 대륙별(contient) GDP의 차이가 있는지 boxplot
install.packages("gapminder")
library(gapminder)
gapminder
ggplot(gapminder, aes(x=continent, y=gdpPercap))+
  geom_boxplot(aes(fill=continent))+
  coord_cartesian(ylim=c(0,90000))+
  theme(axis.text.x = element_text(angle = 45, vjust = 0.6))

#car::Salaries에서 교수의 직급(rank)별 연봉(Salary)의 boxplot
install.packages("car")
library(car)
Salaries
ggplot(Salaries, aes(x=rank,y=salary, col=rank))+
  geom_boxplot(fill='lightyellow', notch = TRUE)+
  geom_point(position="jitter",alpha=0.3, col="brown", pch=20)+
  geom_rug(sides='l', col='dimgray')
#notch=TRUE : 중위수에 대해 95% 신뢰구간을 표현.
?geom_point

#mtcars데이터 cyl개수에 따른 연비(mpg)의 95% 중위수 신뢰구간을 시각화하시오.
ggplot(mtcars,aes(x=cyl,y=mpg))+
  geom_boxplot(notch = TRUE)


## 4.4 바이올린 도표 : boxplot과 밀도도표를 합쳐
install.packages('lattice')
library(lattice)
singer
ggplot(singer, aes(x=voice.part,y=height))+
  geom_violin(fill='red')+
  geom_boxplot(width=0.3, fill='green')+
  geom_point(position = "jitter")


## 4.5 밀도도표
#실린더수(cyl)에 따른 연비를 밀도도표
ggplot(mtcars, aes(x=mpg))+
  geom_density()
ggplot(mtcars, aes(x=mpg, fill=cyl))+
  geom_density()
ggplot(mtcars, aes(x=mpg,fill=cyl))+
  geom_density()+
  facet_wrap(~cyl)
## 4.6 추세선 (시계열에서 데이터의 흐름 표현)
dim(economics)
head(economics)
#시간에 따른 실업률의 추세선
ggplot(economics, aes(x=date,y=unemploy))+
  geom_line()+
  geom_point()+
  geom_smooth(method='lm')

## 4.7 막대그래프(geom_bar()함수, geom_col()함수)
  # 도수분포표 시각화 : 히스토그램(연속데이터), 막대그래프(범주형데이터)
  # 히스토그램 : 연속된 자료를 계급으로 나눠 계급별 도수 geom_histogram()
  # 막대그래프 : 범주형 데이터의 빈도를 나타냄 geom_bar()
  # (cf) x, y 축이 다 존재할 경우 geom_bar(), geom_col()

## 4.8 그래프를 파일에 저장
#(1) basic graph, ggplot 패키지 모두 저장
jpeg('iris.jpg')
boxplot(iris$Sepal.Length)
dev.off()
png("ch01/outData/iris.png", width = 300, height = 150)
ggplot(iris, aes(x=Petal.Length, y=Petal.Width))+
  geom_point()+
  facet_wrap(~Species)
dev.off()

#(2) ggplot2 패키지 그래프 함수에서만 저장할 수 있는 방법
ggplot(iris, aes(x=Petal.Length, y=Petal.Width, col=Species))+
  geom_point(aes(size=Petal.Width), pch=2, alpha=0.5)
ggsave('ch01/outData/iris.jpg')

## 4.9 ggplot2에서 차트 분할 출력
install.packages("gridExtra")
library(gridExtra)
g1<-ggplot(iris, aes(x=Petal.Width, y=Petal.Length))+
  geom_point()
g2<-ggplot(iris, aes(x=Sepal.Width, y=Sepal.Length))+
  geom_point()

g2
png('i.png')
grid.arrange(g1,g2,ncol=2, nrow=1)
dev.off()
###### 5. 산점도 행렬 ######
plot(iris[-5])
pairs(iris[-5], panel = panel.smooth)





############################
dnorm(0,mean = 0,sd=1) #확률밀도함수
rnorm(5,mean=100,sd=5) #(100,5)인 난수 5개
pnorm(1) #확률누적함수
qnorm(0.85) #분위수함수

x<-seq(-3,3,length=200)
q<-(1:4)/5
plot(x, dnorm(x))
abline(v=qnorm(q,0,1), col='green')
axis(side=1,at=qnorm(q,0,1), labels=round(qnorm(q,0,1),2))

(x<-runif(20,min = 0, max = 100))
x
mean(x)
sd(x)
(x-mean(x))/sd(x)
qqnorm(x) 

qqline(x) #정규분포의 25%,75% 점과 input x의 25%, 75%를 지나는 선
abline(v=qnorm(0.25,0,1))
abline(v=qnorm(0.75,0,1))
#선형회귀
#dist=-17.579+3.932speed+e
fit<-lm(dist~speed, data=cars)
plot(fit)
cars
coef(fit)
a<-fitted(fit)#   =e값 제외 회귀식에 speed값을 넣을때의 dist값 #fitted value
cars$speed
b<-residuals(fit)#   =dist+fitted=e   #residuals
rstandard(fit) #standard residuals

confint(fit)
plot(a,b)
qqplot(a,b)

plot(dnorm, xlim=c(-1,1))

############################



