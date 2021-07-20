#시계열 데이터를 인터랙티브 시계열 그래프 만들기
library(ggplot2)
data(economics, package = "ggplot2") #economics= ggplot2::economics
head(economics)
ggplot(economics, aes(x=date, y= unemploy))+
  geom_line()+
  geom_smooth()
install.packages("dygraphs")
library(xts)
library(dygraphs)
eco<-xts(economics$unemploy, order.by = economics$date)
dygraph(eco)
dygraph(eco) %>% dyRangeSelector()
head(economics[,c('psavert','unemploy')])
#여러값을 표현한 인터랙티브 시계열 그래프
eco_a<-xts(economics$unemploy, order.by = economics$date)
eco_b<-xts(economics$psavert, order.by = economics$date)

eco2<-cbind(eco_a,eco_b)

dygraph(eco2) %>% 
  dySeries("unemploy", axis="y2")

#########
temperature <- ts(frequency = 12, start = c(1980, 1),
                  data = c(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 
                           25.2, 26.5, 23.3, 18.3, 13.9, 9.6))
rainfall <- ts(frequency = 12, start = c(1980, 1),
               data = c(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 
                        135.6, 148.5, 216.4, 194.1, 95.6, 54.4))
class(rainfall)

weather <- cbind(rainfall, temperature)
class(weather)
str(weather)
dygraph(weather) %>%
  dySeries("rainfall", axis = 'y2')


#----------------------------------------#
###10. 10장, t-test분석 vs. ANOVA 분석 ###
# 두 그룹간의 평균 차이가 통계적으로 유의한지 검증 : t-test분석
# 세 그룹 이상의 집단 간의 평균 차이가 유의한지 검증 : ANOVA분석

### 1. 두 그룹간의 평균 차이가 유의한지 분석 ###
ToothGrowth
table(ToothGrowth, useNA = "ifany")
#1 도표로 차이의 유의성을 표현(tapply, by, summaryBy, aggregate를 이용해서 mean,sd)
#2 그래프로 시각화된 유의성 표현(vioplot, geom_point, boxplot or (1)의 결과를 barplot)
#3 통계적으로 유의한지 검증

##비타민의 종류가 기니피그 성장에 영향을 미치는가.
#데이터 뻥튀기
ToothGrowth<-rbind(ToothGrowth,ToothGrowth) #3번 실행 ->480행
table(is.na(ToothGrowth))
colSums(is.na(ToothGrowth))
#1
len.mean<-tapply(ToothGrowth$len,ToothGrowth$supp,mean)
len.sd<-tapply(ToothGrowth$len,ToothGrowth$supp,sd)
data.frame(len.mean,len.sd)
library(doBy)
summaryBy(len~supp,data=ToothGrowth,FUN=c(mean,sd))
#2
library(dplyr)
ToothGrowth %>% 
  group_by(supp) %>%
  summarise(len.mean=mean(len),len.sd=sd(len)) %>% 
  ggplot(aes(x=supp,y=len.mean, fill=supp))+
  geom_bar(stat="identity", width=0.6)+
  theme(legend.position = "none")
ggplot(data=ToothGrowth, aes(x=supp,y=len))+
  geom_violin(fill="lightyellow")+
  geom_boxplot(aes(fill=supp),width=0.2, notch = T)+
  geom_point(position = "jitter", color="orange",alpha=.2)+
  theme(legend.position = "none")
#3 통계적 분석 ( 일원표본 t-test < 이원표본 t-test)
# 일원표본 t-test
a<-ToothGrowth[ToothGrowth$supp=="OJ",'len']
b<-ToothGrowth[ToothGrowth$supp=="VC",'len']
t.test(a,b)
#p value가 0.05보다 작은 경우 두 그룹 간의 귀무가설(두 그룹이 평균이 같다.)을 기각한다.
#p value가 0.05보다 큰 경우 귀무가설을 기각하지 못한다.

# 이원표본 t-test(등분산성 테스트 -> t-test)
var.test(len~supp, data=ToothGrowth)

 #p-value가 0.05보다 작은 경우 귀무가설(두 그룹의 분산이 같다.)을 기각함 - 등분산성이 성립되지 않음.
t.test(len~supp, data=ToothGrowth, car.equal=F) #car.equal 등분산성
t.test(len~supp, data=ToothGrowth, car.equal=T)
## 예제 : datasets:sleep - extra(수면량), group(수면제종류)
  ##수면제 group에 따라 수면량의 변화가 있는지를 분석하시오
sleep %>% 
  group_by(group) %>% 
  summarise(extra.mean = mean(extra)) %>% 
  ggplot(aes(x=reorder(group, extra.mean),y=extra.mean))+
  geom_col()
plot(lm(extra~group, data=sleep))
var.test(extra~group, data=sleep)  
t.test(extra~group, data=sleep, car.equal=T)
t.test(extra~group, data=sleep, car.equal=F)



a<-data.frame(Sp=c('a','b','a','b','a','b','a','b'),Num=c(1,3,4,2,5,7,8,6))
var.test(Num~Sp, data=a)
t.test(Num~Sp, data=a, car.equal=F)

# (1) aov()
 # ex. iris데이터 셋에서 종에 따라 SL의 평균이 다른지
table(iris$Species)
result<- aov(Sepal.Length ~ Species, data=iris)
summary(result)
#F값이 0.05보다 작으면 귀무가설(그룹간 평균이 같다)을 기각할 수 있다.
#F값이 0.05보다 크면 귀무가설을 기각할 수 없다.

# (2) anova()
  # ex. datasets::mtcars 데이터셋에서 cyl
#cyl에 따른 연비의 차이가 있는지 분석하시오
fit<- lm(mpg~cyl, data=mtcars)
fit
anova(fit) #F가 0.05보다 작으면 귀무가설을 기각할 수 있다.


## 예제 : datasets:: Orange - tree, age, circumference
 ##오렌지 나무의 연령의 따른 둘레가 상이한지 분석하시오
result<-aov(circumference~age,data=Orange)
summary(result)
fit<-lm(circumference~age,data=Orange)
anova(fit)
