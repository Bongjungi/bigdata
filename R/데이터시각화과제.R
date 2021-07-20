
#11
library(ggplot2)
cars
ggplot(cars, aes(x=speed, y=dist))+
  geom_point()+
  coord_cartesian(xlim = c(5,20), ylim = c(0,100))+
  geom_smooth(method="lm")
png('ex11.png')
dev.off()
#12
library(ggplot2)
library(gapminder)
ggplot(gapminder, aes(x=gdpPercap, y=lifeExp, col=continent))+
  geom_point()
png('ex12.png')
dev.off()
#13
library(ggplot2)
library(gapminder)
library(dplyr)
gapminder %>% 
  filter(lifeExp>70) %>% 
  ggplot(aes(x=continent, fill=continent))+
  geom_bar()+
  labs(title="기대수명이 70을 초과하는 데이터 빈도(대륙별)",
       x="대륙",y="빈도")
png('ex13.png')
dev.off()
#14
library(ggplot2)
library(gapminder)
library(dplyr)
gapminder %>% 
  filter(lifeExp>70) %>%
  group_by(continent) %>% 
  count(country) %>% 
  group_by(continent) %>% 
  summarise(cnt=n()) %>% 
  ggplot(aes(x=continent,y=cnt, fill=continent))+
  geom_col()+
  labs(title="기대수명이 70을 초과하는 대륙별 나라 빈도",
       x="continent",y="나라 빈도")
png('ex14.png')
dev.off()
#15
library(ggplot2)
library(gapminder)
ggplot(gapminder[gapminder$year==2007,], aes(x=continent, y=lifeExp, col=continent))+
  geom_boxplot()+
  labs(title="대륙별 기대수명의 사분위수")
png('ex15.png')
dev.off()
#16
library(ggplot2)
library(gapminder)
ggplot(gapminder,aes(x=gdpPercap,y=lifeExp,col=continent))+
  geom_point()+
  facet_wrap(~year)+
  labs(title="GDP와 기대수명과의 관계")+
  scale_x_log10()
png('ex16.png')
dev.off()


#17
library(ggplot2)
library(gapminder)
ggplot(gapminder[substr(gapminder$country,1,5)=="Korea",],aes(x=year,y=gdpPercap,col=country,shape=country))+
  geom_point()+
  scale_color_manual(values = c("red","blue"), breaks = c('Korea, Rep.','Korea, Dem. Rep.'))+
  scale_shape_manual(values=c(3,19), breaks = c('Korea, Rep.','Korea, Dem. Rep.'))+
  labs(title = "GDP의 변화(한국과 북한)")+
  theme(legend.position = c(0.2,0.8))

png('ex17.png')
dev.off()

#18
library(ggplot2)
library(gapminder)
ggplot(gapminder[gapminder$country%in%c('China','Japan','Korea, Rep.','Korea, Dem. Rep.'),],aes(x=year,y=gdpPercap,col=country))+
  geom_point()+
  geom_line()+
  labs(title = "한중일 4개국의 GDP변화의 산점도와 추세선")

png('ex18.png')
dev.off()

#19
library(ggplot2)
library(gapminder)
library(gridExtra)
g1<-ggplot(gapminder[gapminder$country%in%c('China','Japan','Korea, Rep.','Korea, Dem. Rep.'),],aes(x=year,y=pop,col=country))+
  geom_point()+
  geom_line()+
  labs(title = "한중일 4개국의 인구 변화의 산점도와 추세선")
g2<-ggplot(gapminder[gapminder$country%in%c('China','Japan','Korea, Rep.','Korea, Dem. Rep.'),],aes(x=year,y=pop,col=country))+
  geom_point()+
  geom_line()+
  labs(title = "한중일 4개국의 인구 변화의 산점도와 추세선")+
  scale_y_continuous(labels = scales::comma)
grid.arrange(g1,g2,ncol=2,nrow=1)


png('ex19.png')
dev.off()

#20  
library(ggplot2)
ggplot(economics,aes(x=date, y=psavert))+
  geom_line(col="red",size=2)+
  geom_smooth(col="red")+
  labs(title = "개인저축률 시계열 그래프")
png('ex20.png')
dev.off()


#21
dim(economics)
View(economics[,c('date','psavert','unemploy')])


v_psa<-max(economics$psavert)-min(economics$psavert)
v_une<-max(economics$unemploy)-min(economics$unemploy)
val<-v_une/v_psa

ggplot(economics,aes(x=date))+
  geom_line(aes(y=psavert),col="red", size=2)+
  geom_smooth(aes(y=psavert),col="red")+
  scale_y_continuous(sec.axis = sec_axis(~.*val, name = "unemploy"))+
  geom_line(aes(y=unemploy/val))+
  geom_smooth(aes(y=unemploy/val),col="lightgray")