
##혼자서 해보기1 
# • Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. displ(배기량)이 4
# 이하인 자동차와 5 이상인 자동차 중 어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지
# 알아보세요.
mpg%>%
  mutate(group=ifelse(displ<=4,'배기량4이하', ifelse(displ>=5,'배기량5이상', NA)))%>%
  group_by(group)%>%
  summarise(mean_total=mean(hwy))%>%
  filter(!is.na(group))
  



# • Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다. "audi"와 "toyota"
# 중 어느 manufacturer(자동차 제조 회사)의 cty(도시 연비)가 평균적으로 더 높은지
# 알아보세요.
mpg%>%group_by(manufacturer)%>%summarise(mean_cty=mean(cty))%>%filter(manufacturer=='audi'|manufacturer=='toyota')


# • Q3. "chevrolet"
# , "ford", 
# "honda" 자동차의 고속도로 연비 평균을 알아보려고
# 합니다. 이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요
mpg%>%filter(manufacturer=='ford'|manufacturer=='honda')%>%group_by(manufacturer)%>%summarise(mean_high=mean(hwy))






##혼자서 해보기 2 
# • Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서 분석에
# 활용하려고 합니다. mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해
# 새로운 데이터를 만드세요. 새로 만든 데이터의 일부를 출력해서 두 변수로만 구성되어
# 있는지 확인하세요.
df<-mpg%>%select(class,cty)

# • Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 앞에서 추출한 데이터를
# 이용해서 class(자동차 종류)가 "suv"인 자동차와 "compact"인 자동차 중 어떤
# 자동차의 cty(도시 연비)가 더 높은지 알아보세요.
table(mpg$class)
df%>%group_by(class)%>%summarise(mean_city=mean(cty))%>%filter(class %in% c('suv','compact'))
# • Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가 높은지
# 알아보려고 합니다. "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 자동차의
# 데이터를 출력하세요
mpg %>%
  filter(manufacturer=='audi') %>% 
  arrange(desc(hwy)) %>% 
  head(5)

(d<-mpg%>%filter(manufacturer=='audi')%>%arrange(desc(hwy)))
d[1:10,]



##혼자서 3####
# mpg 데이터는 연비를 나타내는 변수가 hwy(고속도로 연비), cty(도시 연비) 두 종류
# 로 분리되어 있습니다. 두 변수를 각각 활용하는 대신 하나의 통합 연비 변수를 만들어
# 분석하려고 합니다.


# • Q1. mpg 데이터 복사본을 만들고, cty와 hwy를 더한 '합산 연비 변수'를
# 추가하세요.
mpg1<-mpg
mpg1$ch<-mpg1$cty+mpg1$hwy
# • Q2. 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가세요.
mpg1$avgch<-mpg1$ch/2
# • Q3. '평균 연비 변수'가 가장 높은 자동차 3종의 데이터를 출력하세요.
mpg1%>%arrange(desc(mpg1$avgch))%>%head(3)
# • Q4. 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr 구문을 만들어
# 출력하세요. 데이터는 복사본 대신 mpg 원본을 이용하세요.
mpg%>%mutate(mpg1=mpg)%>%select(mpg1)%>%mutate(sumch=mpg1$cty+mpg1$hwy, avgch=(mpg1$cty+mpg1$hwy)/2)%>%arrange(desc(avgch))%>%head(3)



###혼자서 4###
# • Q1. mpg 데이터의 class는 "suv"
# , "compact" 등 자동차를 특징에 따라
# 일곱 종류로 분류한 변수입니다. 어떤 차종의 연비가 높은지 비교해보려고 합니다. 
# class별 cty 평균을 구해보세요.
mpg%>%group_by(class)%>%summarise(mean_cty=mean(cty))

# • Q2. 앞 문제의 출력 결과는 class 값 알파벳 순으로 정렬되어 있습니다. 어떤
# 차종의 도시 연비가 높은지 쉽게 알아볼 수 있도록 cty 평균이 높은 순으로
# 정렬해 출력하세요.
mpg%>%group_by(class)%>%summarise(mean_cty=mean(cty))%>%arrange(desc(mean_cty))

# • Q3. 어떤 회사 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다. 
# hwy 평균이 가장 높은 회사 세 곳을 출력하세요.
mpg%>%group_by(company)%>%summarise(mean_cty=mean(cty))%>%arrange(desc(mean_cty))%>%head(3)

# • Q4. 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 알아보려고
# 합니다. 각 회사별 "compact" 차종 수를 내림차순으로 정렬해 출력하세요.
mpg%>%filter(class=='compact')%>%group_by(manufacturer)%>%summarise(cnt=n())%>%arrange(desc(cnt))


##################
## 혼자해보기(5)##
##################

fuel<-data.frame(fl=c('c','d','e','p','r'),kind=c('CNG','diesel','ethanol E85','premium','regular'), price=c(2.35, 2.38, 2.11, 2.76, 2.22))
merge(mpg, fuel[,c('fl','price')])

#1. 연료 가격 변수가 잘 추가됐는지 확인하기 위해서 model, fl, 
# price_fl 변수를 추출해 앞부분 5행을 출력해 보세요.

merge(mpg, fuel[,c('fl','price')]) %>% 
  select(model, fl, price) %>% 
  head(5)
#2. mpg에 kind 변수도 추가
merge(mpg, fuel)
left_join(mpg, fuel)
fuel[fuel$fl=='p', 'kind']
mpg[,'fl',drop=FALSE]





# • 혼자서 해보기6. mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# • 우선 mpg 데이터를 불러와서 일부러 이상치를 만들겠습니다. drv(구동
#                                         방식) 변수의 값은 4(사륜구동), f(전륜구동), r(후륜구동) 세 종류로 되어
# 있습니다. 몇 개의 행에 존재할 수 없는 값 k를 할당하겠습니다. cty(도
#                                          시 연비) 변수도 몇 개의 행에 극단적으로 크거나 작은 값을 할당하겠습
# 니다.
# • mpg <- as.data.frame(ggplot2::mpg) # mpg 데이터 불러오기
# mpg[c(10, 14, 58, 93), "drv"] <- "k" # drv 이상치 할당
# mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42) # cty 이상치 할당
# • 이상치가 들어있는 mpg 데이터를 활용해서 문제를 해결해보세요.
# • 구동방식별로 도시 연비가 다른지 알아보려고 합니다. 분석을 하려면
# 우선 두 변수에 이상치가 있는지 확인하려고 합니다
mpg<-as.data.frame(ggplot2::mpg)
mpg[c(10,14,58,93),'drv']<-'k'
mpg[c(29,43,129,203),'cty']<-c(3,4,39,42)
# • Q1. drv에 이상치가 있는지 확인하세요. 이상치를 결측 처리한 다음
# 이상치가 사라졌는지 확인하세요. 결측 처리 할 때는 %in% 기호를
# 활용하세요.

colSums(is.na(mpg))
table(mpg$drv)
sum(is.integer(mpg$drv))
mpg$drv<-ifelse(mpg$drv %in% c(4,'f','r'),mpg$drv,NA)
table(mpg$drv, useNA = 'ifany')
table(mpg$drv, exclude = NULL)
sum(is.na(mpg$drv))
# • Q2. 상자 그림을 이용해서 cty에 이상치가 있는지 확인하세요. 상자
# 그림의 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시
# 상자 그림을 만들어 이상치가 사라졌는지 확인하세요.
table(mpg$cty)
boxplot(mpg$cty)
mpg$cty<-ifelse(mpg$cty>boxplot(mpg$cty)[[1]][5] | mpg$cty<boxplot(mpg$cty)[[1]][1],NA,mpg$cty)
boxplot(mpg$cty)
mpg$cty
sum(is.na(mpg$cty))
table(is.na(mpg$cty))
str(mpg$cty)
is.numeric(mpg$cty)

# • Q3. 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 이상
# 치를 제외한 다음 drv별로 cty 평균이 어떻게 다른지 알아보세요. 하나
# 의 dplyr 구문으로 만들어야 합니다
mpg %>% 
  filter(!is.na(cty))%>%
  group_by(drv) %>% 
  summarise(mean_cty=mean(cty))

tapply(mpg$cty,mpg$drv,mean,na.rm=T)
library(doBy)
summaryBy(cty~drv, mpg, FUN=mean, na.rm=T)


########################################################################################
# 분석 도전
# • 미국 동북중부 437개 지역의 인구통계 정보를 담고 있는 midwest 데이터를 사용해
# 데이터 분석 문제를 해결해 보세요. midwest는 ggplot2 패키지에 들어 있습니다.
midwest<-as.data.frame(ggplot2::midwest)
# • 문제1. popadults는 해당 지역의 성인 인구, poptotal은 전체 인구를 나타냅니다. 
# midwest 데이터에 '전체 인구 대비 미성년 인구 백분율' 변수를 추가하세요.
midwest$perchild <-(midwest$poptotal-midwest$popadults)/midwest$poptotal
# • 문제2. 미성년 인구 백분율이 가장 높은 상위 5개 county(지역)의 미성년 인구
# 백분율을 출력하세요.
midwest %>%
  arrange(desc(perchild))%>%
  select(perchild)%>%
  head(5)
# • 문제3. 분류표의 기준에 따라 미성년 비율 등급 변수를 추가하고, 각 등급에 몇 개의
# 지역이 있는지 알아보세요.
midwest<-midwest %>% 
  mutate(
    rategrade = ifelse(perchild>=0.4,'large',ifelse(perchild>=0.3,'middle','small'))
  )
table(midwest$rategrade)
# • 문제4. popasian은 해당 지역의 아시아인 인구를 나타냅니다. '전체 인구 대비
# 아시아인 인구 백분율' 변수를 추가하고, 하위 10개 지역의 state(주), 
# county(지역명), 아시아인 인구 백분율을 출력하세요
midwest$perasian<-midwest$popasian/midwest$poptotal
midwest %>% 
  arrange(perasian)%>%
  head(10)%>%
  select(state,county,perasian)
    


(a<-c('a',1,2,3,4,NA,'가'))

sum(is.na(a)) #NA의 개수
d<-as.numeric(a)
sum(is.na(d))-sum(is.na(a)) #스트링의 개수



