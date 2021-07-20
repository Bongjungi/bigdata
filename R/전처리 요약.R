##############################################################################################
getwd() 

#파일주소 getwd()/ch01/outData.iris.csv

#write
write.table(iris,file='ch01/outData/iris.csv', sep = ",", row.names = FALSE)
write.csv(iris, file='ch01/outData/iris1.csv', quote=FALSE, row.names = FALSE)

#read
irisData<-read.table(file = "ch01/outData/iris.csv", sep = ',', header = TRUE, encoding = 'utf-8')
newiris <- read.csv(file='ch01/outData/iris1.csv', header = TRUE)

#read append
for(i in 1:nrow(irisSummary)){
  cat(irisSummary[i,],'\n', file='ch01/outData/irisSummary.txt', append = TRUE)
}
##############################################################################################
##apply계열
# apply(대상자료, 1(행기준)또는2(열기준), 함수)
apply(iris[,1:4], 2, FUN=mean) #열별 평균

# lapply(대상자료, 함수)
lapply(iris[1:4], mean)

# sapply(대상자료, 함수)
lapply(iris[1:4], mean)

# vapply(대상자료,함수,형식)
vapply(iris[1:4], mean, FUN.VALUE = numeric(1))
vapply(sapply(c(3:9),seq), FUN=fivenum, FUN.VALUE = c(numeric(1),numeric(1),numeric(1),numeric(1),numeric(1)))

# mapply
mapply(rep, x=1:4, times=4:1)
###############################################################################################
#plot
x<--10:10
x1<--5:15
y<-seq(-20,20,2)
plot(x,y)
lm(y~x+x1)
lines(x,2*x)
boxplot(iris$Sepal.Length ~ iris$Species)
vioplot(iris$Sepal.Length ~ iris$Species)
################################################################################################
###데이터 그룹화 함수
# tapply(값, 그룹별, 함수)
tapply(iris$Sepal.Length, iris$Species, FUN=mean)

#by(여러값, 그룹별, 함수(나누기포함된것X))
by(iris[,c('Sepal.Length','Sepal.Width')], iris['Species'], sum)

#aggregate(여러값, 여러 그룹별, 함수1)
aggregate(iris[,1:4],by=list(iris[,5]),FUN=mean)


## doBy 패키지
install.packages('doBy')
library(doBy)
# summaryBy(여러값, 그룹별, 여러함수)
summaryBy(Sepal.Length+Petal.Length~Species, iris, FUN = c(mean,sd))

# orderBy(~정렬기준, 데이터목록) 
orderBy(~-Sepal.Length, data=iris) # - 붙이면 내림차순

# sampleBy :  그룹별 데이터를 sampling
sampleBy(~Species, data=iris, frac=0.2) #종별로 50씩 있으니, 종별로 50*0.2=10개씩 비복원추출
sampleBy(~Species, data=iris, frac=0.2, replace = TRUE) #종별로 10개씩 복원추출
sampleBy(~Species, data=iris, frac = 0.2, systematic = TRUE)#계층적 추출

sample(1:45,6)
################################################################################################
### 데이터 분리
#split(데이터, 분리단위 또는 조건)
split(iris,iris$Species)
split(iris,iris$Sepal.Length>5)

#subset(데이터목록, 조건, 표시목록)
subset(iris, subset=Sepal.Length>=4, select=c('Sepal.Length', 'Petal.Length','Species'))

### 데이터합치기
## 열합치기 cbind( , )
## 행합치기 rbind( , )
## 결합하기 merge( , )
(student<-merge(student.a,student.b, all = T))
############################################################################################
###데이터 정렬
##sort() : 정렬된 데이터 반환 / order() : 정렬된 데이터의 index를 반환
data[order(data)]

###with,within,which
##with(data, expression)
with(iris, {print(mean(Sepal.Length))})
##within(data, expression) --- with기능에 수정기능포함
eng <- data.frame(name = c("Lee", "Choi", "Park", "You"), eng = c(93,73,83,73)) 
math <- data.frame(name = c("You", "Kawk", "Lee", "Park"), math = c(89,79,69,99)) 
score <- merge(eng, math, by = 'name', all = T) 
within(score, { 
  eng = ifelse(is.na(eng), median(eng, na.rm = T), eng)
}) 
##which(x, arr.ind = FALSE)
which(iris$Sepal.Length==max(iris$Sepal.Length))
which.max(iris$Sepal.Length)

##데이터 생략 함수
attach(iris) #이제부터 iris생략가능
detach(iris) #다시 iris생략불가능

###데이터 집계 함수
## table()
table(iris$Species) #종별 갯수

