makematx<-function(x){
  ans<-matrix(1:(length(x)*length(x)), nrow = length(x))
  k<-1
  for(val in x){
    a<-c(1)
    for(v in 1:(length(x)-1)){
      a[v+1]<-a[v]*val
    }
    ans[k,]<-a
    k<-k+1
  }
  return(ans)
}
makematx(c(2,3,4,5,6))

x1<-c(1,2,2,3,3,4,5,5,6,7,8,7,5)
y1<-c(0,1,2,2,3,4,4,5,6,6,7,7,9)
x2<-c(1,   2,   3, 4,   5, 6,   7, 8)
y2<-c(0, 1.5, 2.5, 4,   6, 6, 6.5, 7)
library(vioplot)
lm(y1~x1)
lm(y2~x2)
vioplot(x1,y1)
plot(x1,y1)
plot(x2,y2)
lines(x1,1.0511*x1-0.3817, col='red')
lines(x2,1.0298*x2-0.4464, col='blue')
