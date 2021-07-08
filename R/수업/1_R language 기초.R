#################################################
#######2장 . R Language 기초#####################
#################################################
#1.도움말 기능
#1.1 도움말
iris
edit(iris)
?iris
help(iris)
#1.2 검색기능
??iris
help.search('iris')
#1.3 패키지 도움말
library(help="datasets")
co2
#1.4 함수 도움말
methods(as)
as.integer(1.25)
?as.integer
x<-pi*c(-1:1,10)
x1<--10:10
as.integer(x)
example("as.integer") #예제 출력

data <-c(10,20,30)
mean(data) #data 벡터 변수의 평균
?mean

