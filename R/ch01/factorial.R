fact<-function(){
  wnum<-as.integer(readline('수입력 : '))
  a<<-1
  if(wnum==0){
    print(1)
  }else if(wnum<0){
    print('음수 입력 금지')
  }else{
    for(val in 1:wnum){
      a<<-a*val
    }
  }
  print(a)
}
