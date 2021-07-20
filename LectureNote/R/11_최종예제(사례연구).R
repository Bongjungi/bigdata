#----------------------------#
###11장. 최종예제(사례연구)###
#============================#

### 0. 패키지 설치 및 로드하기
install.packages("foreign")
library(foreign) #SPSS 파일 불러오기
library(dplyr)
library(doBy)
library(ggplot2)
library(readxl) #code_job의 데이터
rm(list=ls())


## 1. 데이터를 불러와 원하는 필드만 추출 ##

# (1) SPSS파일을 데이터 프레임으로


raw_Welfare <-read.spss(file="Koweps/Koweps_hpc10_2015_beta1.sav", to.data.frame = TRUE)
dim(raw_Welfare)
View(raw_Welfare)
raw_welfare<-read.spss(file = "Koweps/Koweps_hpc10_2015_beta6.sav", to.data.frame = TRUE, reencode = "utf-8")
View(raw_welfare)

# (2) 필요한 필드만 select
welfare<-raw_welfare[,c("h10_g3","h10_g4","h10_g10","h10_g11","h10_eco9","p1002_8aq1","h10_reg7")]

# (3) 변수명 변경
welfare<-rename(welfare,gender=h10_g3,birth=h10_g4,marriage=h10_g10, religion=h10_g11,
                code_job=h10_eco9,income=p1002_8aq1, code_region=h10_reg7)
welfare


table(is.na(welfare))
colSums(is.na(welfare))
str(welfare)
## 2. 성별에 따른 월급 차이 분석 ##
# (1) gender 필드에 이상이 있는지 확인, 이상치 처리
table(welfare$gender, useNA = "ifany")
# (2) gender 필드 결측치 확인
table(is.na(welfare$gender))
# (3) gender의 값이 1은 male로 2는 female로 변경하고 gender의 타입을 factor로 변경
welfare$gender<-ifelse(welfare$gender==1,"male","female")
welfare$gender<-factor(welfare$gender,levels = c('male','female'))
# (4) 성별 비율을 도표로 나타내고 그래프로 시각화
gender.ratio<-welfare %>% 
  group_by(gender) %>% 
  summarise(ratio = n()/nrow(welfare))
pie(gender.ratio$ratio, labels =paste(gender.ratio$gender,round(gender.ratio$ratio,1),"%"),clockwise = TRUE, col = c("skyblue","pink"))

ggplot(gender.ratio,aes(x=gender, y=ratio, fill=gender))+
  geom_col()+
  scale_x_discrete(limits=c('female','male'))+
  scale_fill_discrete(limits=c('female','male'))+
  theme(legend.position = c(.8,.9),
        legend.title = element_text(face=3, color='red'))

ggplot(gender.ratio,aes(x="",y=ratio, fill=gender))+
  geom_col()+
  coord_polar("y")
# (5) income의 최소값, 1분위수, 중위수, 3분위수, 최대값, 결측치 등을 탐색하고, boxplot과 월급의 빈도그래프를 시각화한다, 
summary(welfare$income)
boxplot(welfare$income)
ggplot(welfare, aes(y=income))+
  geom_boxplot()
ggplot(welfare, aes(income))+
  geom_histogram()+
  coord_cartesian(xlim=c(0,1200))
# (6) income이 0인 데이터는 이상치로 정하고, 이상치를 결측 처리한다
a<-boxplot(welfare$income)$stat
welfare$income<-ifelse(welfare$income<=a[1] | welfare$income>=a[5],NA,welfare$income)
table(welfare$income<=a[1], useNA = "ifany")
table(welfare$income>a[5], exclude = NULL)
# 결측치 처리
temp<- welfare[, c('gender','income')]
m<-tapply(temp$income, temp$gender, median, na.rm=T)
m
temp$income<-ifelse(is.na(temp$income), m[temp$gender], temp$income)
# (7) 결측치를 제외한 데이터를 이용하여 성별에 따른 월급차이가 있는지를 분석
summaryBy(income~gender, data = welfare, FUN=c(mean,sd), na.rm=T)
temp<-na.omit(welfare[,c('gender','income')])
summaryBy(income~gender, data=temp, FUN=c(mean,sd))

welfare %>% 
  group_by(gender) %>% 
  summarise(income.mean=mean(income, na.rm=T)) %>% 
  ggplot(aes(x=gender, y=income.mean))+
  geom_bar(stat="identity")
ggplot(welfare,aes(x=gender, y=income))+
  geom_point(position = "jitter", alpha=.2)+
  geom_violin()+
  geom_boxplot(aes(fill=gender), width=0.2, notch = T)


head(welfare)
q<-welfare[welfare$gender=="male",'income']
w<-welfare[welfare$gender=="female",'income']
t.test(q,w)
t.test(income~gender, data=welfare)

## 3. 나이와 월급의 관계 - 몇살 때 월급이 가장 많을까
#(1) birth, income 필드 변수의 이상치와 결측치를 확인
class(welfare$birth)
table(is.na(welfare$birth),useNA="ifany")
boxplot(welfare$birth)$stat
class(welfare$income)
table(is.na(welfare$income),useNA="ifany")
boxplot(welfare$income)$stat

#(2)  birth변수를 이용하여 나이를 계산하고 이 값을 age 필드로 추가
welfare$age<-2015-welfare$birth+1
#(3) x축을 나이, y축을 월급으로 지정하고 나이에 따른 월급의 변화가 표현되도록 막대그래프나 선 그래프로 시각화
ggplot(welfare, aes(x=age, y=income))+
  geom_col()
#(평균시각화)
welfare %>% 
  filter(!is.na(income)) %>%
  group_by(age) %>% 
  summarise(income.mean=mean(income)) %>% 
  ggplot(aes(x=age, y=income.mean))+
  geom_line()
#(4) 나이에 따른 월급의 차이가 있는지 관계를 분석
fit<-lm(income~age, data=welfare)
anova(fit)


## 4. 연령대에 따른 월급의 차이가 있는지, 있으면 어떤 연령대가 월급이 가장 많은지 분석
#(1) 파생변수 agegrade를 필드로 추가
welfare<-welfare %>% 
  mutate(
    agegrade=ifelse(age<=30,"young",ifelse(age<=60,"middle","old"))
  )
#(2) agegrade 의 분포를 도표와 그래프로 시각화
table(welfare$agegrade)
ggplot(welfare, aes(x=agegrade))+
  geom_bar()
#(3)연령대 별 월급의 boxplot을 시각화
ggplot(welfare, aes(x=agegrade, y=income))+
  geom_boxplot()
#(4) 실제로 연령대에 따른 월급 차이가 있는지 분석
fit<-aov(income~agegrade, data=welfare)
summary(fit)


## 5. 성별에 따른 월급의 차이는 연령대 별로 다른지 분석
#(1) 성별, 연령대, 월급 데이터의 결측치를 확인
colSums(is.na(welfare[,c('gender','agegrade','income')]))
#(2) 연령대별, 성별 월급의 평균과 표준편차, 빈도를 출력
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade, gender) %>% 
  summarise(income_mean=mean(income),
            income_sd=sd(income),
            cnt= n(), .group="drop") ##.group="drop" 하면 warning 없어짐(근데 안해도 됨)
#(3) 성별에 따른 월급의 차이가 연령대별로 다른지 시각화
welfare %>% 
  filter(!is.na(income)) %>% 
  ggplot(aes(x=gender, y=income, fill=agegrade))+
  geom_col()+
  facet_grid(agegrade~.)

## 6. 나이에 따른 월급 변화를 성별을 분리하여 시각화
#(1) 나이와 성별로 group_by하여 월급평균, 월급표준편차, 월급중앙값, 최소값과 최대값, 빈도을 산출한다
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(age,gender) %>% 
  summarise(income_mean=mean(income),
            income_sd=sd(income),
            income_median=median(income),
            income_max=max(income),
            income_min=min(income),
            cnt=n())
#(2) 나이에 따른 월급평균의 추이를 아래와 같은 그래프를 시각화하고, 아래의 그래프를 파일로도 출력
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(age,gender) %>% 
  summarise(income_mean=mean(income)) %>% 
  ggplot(aes(x=age,y=income_mean,col=gender))+
  geom_line()+
  scale_color_discrete(limits=c('female','male'))

## 7. 어떤 직업이 월급이 가장 많은지 상위 10개 직업군만 시각화
#(1) 직업별 월급 평균, 표준편차, 빈도를 평균월급 순으로 정렬하여 출력하여 직업별 월급의 추이를 분석
ex<-read_excel("Koweps/Koweps_Codebook.xlsx", col_names = TRUE, sheet="직종 코드")
left_join(welfare,ex, by="code_job") %>% 
  filter(!is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income_mean=mean(income),
            income_sd =sd(income),
            cnt=n()) %>% 
  arrange(desc(income_mean))
#(2) 직업별 월급의 차이를 분석한 후, 상위 소득 10개 직업군을 도표로 출력하고, 아래와 같은 그래프로 시각화한다. 시각화한 그래프는 ggsave함수를 이용하여 top10.png라는 그림파일로 저장
income_aov<-aov(income~code_job, data=welfare)
summary(income_aov)
ex<-read_excel("Koweps/Koweps_Codebook.xlsx", col_names = TRUE, sheet="직종 코드")
left_join(welfare,ex, by="code_job") %>% 
  filter(!is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income_mean=mean(income)) %>% 
  arrange(desc(income_mean)) %>% 
  head(10)
left_join(welfare,ex, by="code_job") %>% 
  filter(!is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income_mean=mean(income)) %>% 
  arrange(desc(income_mean)) %>% 
  head(10) %>% 
  ggplot(aes(x=reorder(job,income_mean),y=income_mean))+
  geom_col()+
  labs(title="상위 소득 10개 직업군", x="직업", y="평균소득")+
  coord_flip()

left_join(welfare,ex, by="code_job") %>% 
  filter(!is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income_mean=mean(income)) %>% 
  arrange(desc(income_mean)) %>% 
  head(10) %>% 
  ggplot(aes(x=income_mean, y=reorder(job, income_mean))) +
  geom_bar(stat="identity")+
  labs(title = "상위 소득 10개 직업군", x="평균소득", 
       y="직업") 


ggsave("top10.png")
#(3) 하위 소득 10개 직업군도 도표로 출력하고 시각화
ex<-read_excel("Koweps/Koweps_Codebook.xlsx", col_names = TRUE, sheet="직종 코드")
left_join(welfare,ex, by="code_job") %>% 
  filter(!is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income_mean=mean(income)) %>% 
  arrange(income_mean) %>% 
  head(10)
left_join(welfare,ex, by="code_job") %>% 
  filter(!is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income_mean=mean(income)) %>% 
  arrange(income_mean) %>% 
  head(10) %>% 
  ggplot(aes(x=reorder(job,income_mean),y=income_mean))+
  geom_col()+
  labs(title="하위 소득 10개 직업군", x="직업", y="평균소득")+
  coord_flip()

##8.data.frame변수를 이용하여 성별로 어떤 직업이 가장 많을지 분석
ex<-read_excel("Koweps/Koweps_Codebook.xlsx", col_names = TRUE, sheet="직종 코드")
#(1)여성 최빈 직업 상위 10를 추출
left_join(welfare,ex, by="code_job") %>% 
  filter(gender=="female" & !is.na(code_job)) %>% 
  group_by(job) %>% 
  summarise(cnt=n()) %>% 
  arrange(desc(cnt)) %>% 
  head(10)
#(2) 남성 최빈 직업 상위 10을 추출
left_join(welfare,ex, by="code_job") %>% 
  filter(gender=="male" & !is.na(code_job)) %>% 
  group_by(job) %>% 
  summarise(cnt=n()) %>% 
  arrange(desc(cnt)) %>% 
  head(10)
 
##9. 종교 유무에 따른 이혼률을 분석
#(1)종교 데이터인 religion 필드의 이상치 및 결측치를 확인
table(welfare$religion, useNA = "ifany")
#(2)religion 필드가 1이면 “종교-유”, 2이면 “종교-무”로 데이터를 변경
welfare$religion<-ifelse(welfare$religion==1,"종교-유","종교-무")
#(3)종교 유무의 빈도를 시각화
ggplot(welfare, aes(x=religion))+
  geom_bar()
#(4) 혼인 상태 데이터인 marriage 필드가 1이면 “기혼”, 3이면 “이혼”으로, 그 외는 NA로 값을 같은 marriage_group 파생변수를 추가

welfare$marriage_group<-ifelse(welfare$marriage==1,"기혼",
                               ifelse(welfare$marriage==3,"이혼",NA))

#(5)종교 유무에 따른 이혼률을 분석

welfare %>% 
  filter(!is.na(marriage_group)) %>% 
  group_by(religion, marriage_group) %>% 
  summarise(cnt=n()) %>% 
  group_by(religion) %>% 
  mutate(tot= sum(cnt)) %>% 
  mutate(ratio=round(cnt/tot*100,1))



temp<-welfare %>% 
  filter(!is.na(marriage_group)) %>% 
  mutate(marr=ifelse(marriage_group=="기혼",0,1)) %>% 
  select(religion,marr,marriage)
var.test(data=temp, marr~religion)
t.test(data=temp, marr~religion, var.equal=F)

#(6) 분석한 결과를 도표와 그래프로 시각화한다
welfare %>% 
  filter(!is.na(marriage_group)) %>% 
  group_by(religion, marriage_group) %>% 
  summarise(cnt=n()) %>% 
  group_by(religion) %>% 
  mutate(tot= sum(cnt)) %>% 
  mutate(ratio=cnt/tot) %>% 
  filter(marriage_group=="이혼") %>% 
  ggplot(aes(x=religion,y=ratio))+
  geom_col()
##10. 노년층이 많은 지역은 어디인지 출력
#(1)  결측치를 확인
colSums(is.na(welfare))
table(welfare$code_region)
#(2) region 파생변수를 지역명으로 추가
region<-data.frame(code_region=c(1,2,3,4,5,6,7), region=c('서울','수도권(인천/경기)','부산/경남/울산','대구/경북','대전/충남','강원/충북','광주/전남/전북/제주도'))
welfare<-left_join(welfare,region, by="code_region")
#(3) 지역별 연령대 비율을 분석한 도표 및 그래프를 시각화
welfare %>% 
  group_by(region,agegrade) %>% 
  summarise(c=n()) %>% 
  group_by(region) %>% 
  summarise(agegrade=agegrade,cnt=c/sum(c))
welfare %>% 
  group_by(region,agegrade) %>% 
  summarise(c=n()) %>% 
  group_by(region) %>% 
  summarise(agegrade=agegrade,cnt=c/sum(c)) %>% 
  ggplot(aes(x="",y=cnt, fill=agegrade))+
  geom_col()+
  coord_polar("y")+
  facet_wrap(region~.)
#(4)노년층이 많은 지역이 어디인지 시각화
welfare %>% 
  group_by(region,agegrade) %>% 
  filter(agegrade=="old") %>% 
  summarise(n=n()) %>% 
  arrange(desc(n)) %>% 
  head(1) %>% 
  ggplot(aes(x=region,y=n))+
  geom_col()
  