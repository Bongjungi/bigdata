PN<-function(num){
  number=abs(num)
  key=TRUE;
  if(number==0||number==1){
    return(FALSE)
  }else if(number==2||number==3){
    return(TRUE)
  }else{
    for(val in 2:as.integer(sqrt(number))){
      if(number%%val==0){
        key=FALSE;break;
      }
    }
  }
  return(key)
}
PN(3)
