######################################################
##### 5-1장. dplyr 패키지를 이용한 데이터 전처리 #####
######################################################
#### 1. 외부파일 read / write ####
## 1.1 엑셀파일 읽어오기 - readxl 패키지 이용
install.packages("readxl")
library(readxl)
getwd()
exam <- read_excel('C:/bigdata/src/06_R/inData/exam.xlsx') #첫번째 sheet의 값을 read
exam <- read_excel('C:\\bigdata\\src\\06_R\\inData\\exam.xlsx')
exam <- read_excel('inData/exam.xlsx')
head(exam)
class(exam)
exam <- as.data.frame(exam)
class(exam)
head(exam)

exam2 <- read_excel('inData/exam.xlsx', sheet=2)
?read_excel
exam2 <- as.data.frame(exam)

# 데이터 파일에 컬럼명이 없는 경우
city <- read_excel('inData/data_ex.xls', col_names = F)
city <- as.data.frame(city)
colnames(city) <- c('id','gender','age','area')
head(city,3)

## 1.2 데이터 쓰기 (파일(csv)로 쓰기, 변수로 쓰기)
write.csv(exam, 'outData/exam.csv', row.names = TRUE) # csv에 쓰기
write.csv(exam, 'outData/exam.csv', row.names = FALSE)

save(exam, file='outData/exam.rda') # exam변수를 파일에 저장
rm(list=ls(all.names = TRUE)) # 히든 변수까지 모두 삭제
exam
load('outData/exam.rda') # 환경창에 변수 추가됨
head(exam)

#### 2. dplyr 패키지 이용을 위한 데이터 준비 & 데이터 파악하기 ####
# data(mpg, package = "ggplot2")
## 데이터 준비
mpg <- as.data.frame(ggplot2::mpg)
midwest <- as.data.frame(ggplot2::midwest)
## 데이터 파악하기
head(mpg)
tail(mpg, 1)
edit(mpg) # 확인용
View(mpg)
# dim() 차원  str() 구조 summary() 통계치 파악
dim(mpg)
str(mpg)
summary(mpg)

# 변수명(열이름) (cty->city, hwy->highway)
library(dplyr)
# mpg <- rename(mpg, city=cty)
mpg <- rename(mpg, c(city=cty, highway=hwy))
colnames(mpg)
# 파생변수 (total = (city+highway)/2 )
mpg$total <- (mpg$city + mpg$highway ) / 2
head(mpg, 3)
# 파생변수 (test = total연비가 평균보다 높은 pass, 평균보다 낮으면 fail)
boxplot(mpg$total) # (1)박스플롯(1,2,3사분위수, 이상치)
hist(mpg$total) # (2)히스토그램(연속된데이터의 빈도)
library(vioplot)
vioplot(mpg$total) # (3) 바이올릿플롯

mpg$test <- ifelse(mpg$total >= mean(mpg$total), 'pass', 'fail')
table(mpg$test) # 빈도표(결측치 미포함)
head(mpg)
library(ggplot2)
dev.off() # qplot이 에러날때
qplot(mpg$test) # 막대그래프(카테고리컬데이터의 빈도)

## 분석도전 ex(note p.1)
# 문제1. ggplot2의 midwest 데이터를 데이터 프레임 형태로 불러와서 데이터의 특성을 파악하세요.
midwest <- as.data.frame(ggplot2::midwest)

class(midwest)
dim(midwest) #차원 437행 28열

head(midwest,2)
tail(midwest,2)
View(midwest)
edit(midwest)
colnames(midwest) # 열이름
names(midwest) # 열이름

table(is.na(midwest)) # 결측치 갯수 파악
is.na(midwest)# 437행 28열
colSums(is.na(midwest))  # 열별 결측치 갯수

# 문제2. poptotal(전체 인구)을 total로, popasian(아시아 인구)을 asian으로 변수명을 수정하세요.
?midwest
# midwest <- rename(midwest, total=poptotal) 변수 하나만 수정
midwest <- rename(midwest, c(total=poptotal, asian=popasian))
colnames(midwest)
# 문제3. total, asian 변수를 이용해 '전체 인구 대비 아시아 인구 백분율' 파생변수를 만들고, 히스토그램을 만들어 도시들이 어떻게 분포하는지 살펴보세요.
midwest$ratioasian <- midwest$asian / midwest$total * 100 # 아시아인구 백분율율
head(midwest[,c('state', 'total', 'asian', 'ratioasian')])
hist(midwest$ratioasian)
# 문제4. 아시아 인구 백분율 전체 평균을 구하고, 평균을 초과하면 "large", 그 외에는 "small"을 부여하는 파생변수를 만들어 보세요.
midwest$group <- ifelse(midwest$ratioasian>mean(midwest$ratioasian), 
                        "large", "small")
# 문제 5. 빈도표, 빈도그래프(히스토그램-연속변수, 막대그래프-카테고리컬변수)
table(midwest$group) # 빈도표
dev.off()
qplot(midwest$group, fill=midwest$group) 

#### 3. 파악한 데이터를 dplyr 패키지를 이용하여 전처리 및 분석하기 ####
## 3.1 조건에 맞는 데이터 추출하기 : filter() ; '%>%' ctrol+shift+m 핫키
getwd()
exam <- read.csv('ch01/inData/exam.csv', header=TRUE)
library(dplyr)
# class가 1인 행만 추출
exam %>% filter(class==1)
exam
subset(exam, class==1)
exam[exam$class==1,]

# class가 1이거나 2이거나 3인 데이터 추출
exam %>% 
  filter(class==1 | class==2 | class==3)
exam %>% 
  filter(class %in% c(1,2,3))

# class가 1이거나 2이고, english가 80이상인 데이터 추출
exam %>% 
  filter(class %in% c(1,2) & english>=80)

## 3.2 필요한 변수 추출하기 : select()
exam %>% 
  select(class, english, math) # 추출하고자 하는 변수만 select함수 안에
# subset(exam, select=c('class', 'english', 'math')) 과 동일한 결과 
exam %>% 
  select(-math) # math변수만 제외하고 다 출력력
# class가 1이거나 2인 행중에서 영어,수학데이터만 출력
exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(english, math)
exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(3,4)
# class가 1이거나 2인 행중에서 수학(3번째열),영어(4번째열),과학(5번째열)데이터만 출력
exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(math, english, science)

exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(math:science)

exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(3:5)

# class가 1,2,3인 행에서 영어,수학 데이터만 앞 5개만 추출
exam %>% 
  filter(class %in% c(1,2,3)) %>% 
  select(english, math) %>% 
  head(5) # 앞 5개

exam %>% 
  filter(class %in% c(1,2,3)) %>% 
  select(english, math) %>% 
  head # 앞6개 cf. 뒤6개는 tail

## 3.3 정렬하기 : arrange()
exam %>% arrange(math) # math기준으로 오름차순 정렬
exam %>% arrange(desc(math)) # math기준으로 내림차순 정렬
exam %>% arrange(-math)      # math기준으로 내림차순 정렬
exam %>% arrange(class, desc(math)) #class 오름차순, math내림차순 정렬
exam %>% arrange(class, -math)      #class 오름차순, math내림차순 정렬
# id가 1부터 10인 학생의 영어, 수학성적을 영어성적 기준으로 오름차순 정렬하여 top 6만
exam %>% 
  filter(id %in% c(1:10)) %>% 
  select(english, math) %>% 
  arrange(english) %>% 
  head
## 3.4 파생변수 추가 : mutate()
exam %>% 
  mutate(total = math+english+science) %>% 
  filter(total >= 150) %>% 
  arrange(total) %>% 
  head
head(exam)
exam <- exam %>% mutate(total=math+english+science)
head(exam)
exam$total <- NULL # total변수 삭제
head(exam)

exam %>%  # 파생변수를 한꺼번에 두개이상 추가해서 분석하기
  mutate(total = math+english+science ,
         avg = round(math+english+science),
         group = ifelse(total>180, 'A','B'))

## 3.5 요약하기 : summarise()
# summarise 안에 들어갈 통계치 함수 : mean, sd, min, max, median, n(갯수)
exam %>% 
  summarise(mean_math=mean(math))
exam %>% 
  summarise(mean_math = mean(math),
            sd_math   = sd(math),
            mean_eng  = mean(english),
            sd_eng    = sd(english),
            cnt       = n())

## 3.6 집단별로 요약하기 : group_by() + summarise()
exam %>% 
  group_by(class) %>% 
  summarise(mean_math = mean(math),
            sd_math   = sd(math),
            mean_eng  = mean(english),
            sd_eng    = sd(english),
            cnt       = n())
# summaryBy을 이용하여 위의 식과 동일하게 만들기
library(doBy)
result1 <- summaryBy(math+english ~ class, data=exam, FUN=c(mean, sd)) # 집단별 요약
result2 <- table(exam$class) # 집단별 빈도수
result2 <- data.frame(result2) # 데이터프레임으로 형변환
names(result2) <- c('class','cnt')
merge(result1, result2)
# mpg데이터에서 회사별로 "suv 자동차의 도시와 고속도로 통합 연비 평균을 구해 내림차순으로 정렬하고 1~5위까지 출력하기
mpg = as.data.frame(ggplot2::mpg)
class(mpg)
head(mpg)
table(mpg$class)
#방법1. dplyr패키지
mpg %>% 
  filter(class=='suv') %>% 
  group_by(manufacturer) %>% 
  mutate(total = (cty+hwy)/2) %>% 
  summarise(tot_mean = mean(total)) %>% 
  arrange(desc(tot_mean)) %>% 
  head(5)
#방법2
df <- mpg[mpg$class=='suv',]
df$total <- (df$cty+df$hwy)/2
head(sort(tapply(df$total, df$manufacturer, mean), decreasing = T), 5)
sort(tapply(df$total, df$manufacturer, mean), decreasing = T)[1:5]

###데이터 합치기###
##열합치기 : cbind, left_join()(dplyr 패키지 함수)
##행합치기 : rbind, bind_rows()

## 4.1 열합치기(가로합치기)
test1<-data.frame(id=c(1,2,3,4,5),midterm=c(100,90,80,70,60))
test2<-data.frame(id=c(1,2,3,4,5),final=c(99,88,77,66,55),teacherid=c(1,1,2,2,3))
teacher<-data.frame(teacherid=c(1,2,3),teachername=c('Kim','Park','Bai'))
cbind(test1,test2) # 공통된 열이 중복 생성
merge(test1,test2)
left_join(test1,test2, by='id')
test2
cbind(test2,teacher) ##에러## 행의 수가 다름름
left_join(test2,teacher)
left_join(teacher,test2)
merge(test2, teacher, by='teacherid')
teacher2<-data.frame(teacherid=c(1,2,4),teachername=c('Kim','Park','Bai'))
left_join(test2,teacher2)
merge(test2,teacher2, by='teacherid',all=TRUE)

## 4.2 행합치기(세로합치기)
group.a<-data.frame(id=c(1,2,3,4,5),test=c(100,90,80,70,60))
group.b<-data.frame(id=c(6,7,8,9,10),test=c(50,55,60,65,100))
rbind(group.a,group.b) #두 데이터프레임 변수(열이름이 같을 경우)
bind_rows(group.a,group.b)
group.a<-data.frame(id=c(1,2,3,4,5),test1=c(100,90,80,70,60))
group.b<-data.frame(id=c(6,7,8,9,10),test2=c(50,55,60,65,100))
rbind(group.a,group.b) #에러
bind_rows(group.a,group.b)


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


#####5. 데이터 정제하기 (결측치, 이상치)#####
##5.1 결측치 정제하기
df<-data.frame(name=c('kim','yi','yun','ma','park'),gender=c('m','f',NA,'m','f'), score=c(5,4,3,4,NA), income=c(2000,3000,4000,5000,6000))
df
df$gender<-as.factor(df$gender)##팩터가 1개면 asfactor쓰면 안됨
is.na(df)
apply(is.na(df),2, sum)
colSums(is.na(df)) ##열별결측치 개수

na.omit(df)## 결측치가 하나의 열이라도 있으면 그행은 모두 제거, 간편하지만, 같은행의 분석
           ## 편하기는 하나 잘 안 씀(필요한 열의 정보까지 손실되는 단점)
library(dplyr)

df %>% 
  filter(!is.na(score)) %>% 
  summarise(mean_score=mean(score))

##결측치 대체체
x<-c(1,1,1,2,2,2,2,3,3,3,3,3,NA,4,4,4,4,5,5,5,100)
exam[c(3,8,15),'math']<-NA
exam[1:2,'english']<-NA
colSums(is.na(exam))
#결측치 중앙값 대체
#1
median(exam$math, na.rm = T)
exam$math<-ifelse(is.na(exam$math),median(exam$math, na.rm = T),exam$math)
exam$english<-ifelse(is.na(exam$english),median(exam$english, na.rm = T),exam$english)
table(is.na(exam))

#2 within
table(is.na(exam))
colSums(is.na(exam))
m<-apply(exam[,3:4],2,median, na.rm=T)
exam<-within(exam, {
  math<-ifelse(is.na(math),m['math'],math)
  english<-ifelse(is.na(english),m['english'],english)
})
exam
#3 dplyr
exam<- exam %>%
  mutate(
    math = ifelse(is.na(math),m['math'],math),
    english = ifelse(is.na(english),m['english'],english)
  )
exam

##5.2 이상치(=극단치, outlier) 정체
 #논리적인 이상치(Ex 성별에 남여가 아닌 값)
 #극단적인 이상치(정상적인 범위에서 벗어난 값)
 #이상치는 결측치로 대체

#(1) 논리적인 이상치
outlier <-data.frame(gender=c(1,2,1,3,2), #1은 남, 2는 여
                     score=c(90,95,100,99,101))
outlier$gender<-ifelse(outlier$gender!=1& outlier$gender!=2,NA,outlier$gender)
outlier$gender<-factor(outlier$gender, labels = c('남','여'), levels = c(1,2))
outlier$score<-ifelse(outlier$score>100,NA,outlier$score)
outlier
#(2) 정상범위 기준으로 많이 벗어난 이상치 : (상하위 0.3%) 또는 평균+-2.75*표준편차
?ggplot
mpg<-as.data.frame(ggplot2::mpg)
sort(mpg$hwy)
highlimit<-mean(mpg$hwy)+2.75*sd(mpg$hwy)
lowlimit<-mean(mpg$hwy)-2.75*sd(mpg$hwy)
mpg$hwy[mpg$hwy>highlimit]
result<-boxplot(mpg$hwy)
result[[1]][1]
result[[1]][5]
result[5]
mpg$hwy[mpg$hwy>result$stats[5]]
mpg$hwy[mpg$hwy<result$stats[1]]
#이상치를 결측치로 대체
mpg$hwy<-ifelse(mpg$hwy>result$stats[5]|mpg$hwy<result$stats[1],NA, mpg$hwy)
mpg$hwy
sum(is.na(mpg$hwy))
rm(list=ls())

