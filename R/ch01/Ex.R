dat<-read.csv(file="D:/근로복지공단_항만하역 재해자 보험급여지급현황_20201231.csv", header=T)
summary(dat)
dat[601:800,]
dat1<-cbind(dat,c(rep(1,nrow(dat))))
dat1
dat1[6]=NULL
num<-c(1:nrow(dat))
dat1<-cbind(dat1,num)
?dat1
dat1<-rbind(dat1,c(0,208008,20800905,789789789,789789789789))
summary(dat1)
?help
?order
class(dat)
