#__________________________________________#
### 13장. 웹 데이터 수집(정적 웹크롤링)  ###
#__________________________________________#
install.packages('rvest')
installed.packages()
library(rvest)
url <-'https://movie.naver.com/movie/point/af/list.nhn?&page=1'
html <-read_html(url, encoding = 'uft-8')
html
#selectgadget사용
#영화제목 : .title .movie
nodes<-html_nodes(html,'.title .movie')
as.character(nodes)
title<-html_text(nodes)
title
#해당 영화 안내 페이지 : 
movieInfo<-html_attr(nodes,'href')
movieInfo<-paste0(url,movieInfo)
movieInfo
#평점 : ".list_netizen_score em"
nodes<-html_nodes(html,".list_netizen_score em")
nodes
point<-html_text(nodes)
point
#영화 리뷰 : td.title
nodes<-html_nodes(html,'td.title')
text<-html_text(nodes)
text<-gsub("\n|\t","",text)
text
review<-unlist(strsplit(text,'점 중[0-9]{1,2}'))[seq(2,20,2)]
review<-gsub('신고','',review)
review

df<-data.frame(title, movieInfo, point, review)
View(df)

page<- cbind(title, movieInfo)
page<-cbind(page,point)
page<-cbind(page,review)
View(page)

write.csv(page, 'ch01/outData/movie_review.csv')


## 여러 페이지 정적 웹 크롤링(영화리뷰 1~100페이지까지)
home<-'https://movie.naver.com/movie/point/af/list.nhn'
site<-'https://movie.naver.com/movie/point/af/list.nhn?&page='
movie.review<-NULL

for(i in 1:100){
  url<-paste0(site,i)
  html <-read_html(url, encoding = 'uft-8')
  #selectgadget사용
  #영화제목 : .title .movie
  nodes<-html_nodes(html,'.title .movie')
  title<-html_text(nodes)
  #해당 영화 안내 페이지 : 
  movieInfo<-html_attr(nodes,'href')
  movieInfo<-paste0(home,movieInfo)
  #평점 : ".list_netizen_score em"
  nodes<-html_nodes(html,".list_netizen_score em")
  point<-html_text(nodes)
  #영화 리뷰 : td.title
  nodes<-html_nodes(html,'td.title')
  text<-html_text(nodes)
  text<-gsub("\n|\t","",text)
  review<-unlist(strsplit(text,'점 중[0-9]{1,2}'))[seq(2,20,2)]
  review<-gsub('신고','',review)
  
  df<-data.frame(title, movieInfo, point, review)
  movie.review<-rbind(movie.review,df)
}
View(movie.review)
write.csv(movie.review,'ch01/outData/movie_review100page.csv', row.names = F)

##영화 리뷰 내용만 뽑아서 최빈 단어 10개. 워드클라우드
library(KoNLP)
library(ggplot2)
library(wordcloud)
library(dplyr)
data<-read.csv('ch01/outData/movie_review100page.csv',header = T)
data$point<-as.numeric(data$point)
result<-data %>% 
  group_by(title) %>% 
  summarise(point.mean=mean(point),
            point.sum=sum(point),
            n=n()) %>%
  filter(n>10) %>% 
  arrange(desc(point.mean),desc(point.sum)) %>% 
  head(7)
ggplot(result, aes(x=point.mean,y=reorder(title,point.mean)))+
  geom_col(aes(fill=title))+
  geom_text(aes(label=paste("총점 : ",point.sum," 평균 : ",round(point.mean,1))),hjust=1)+
  theme(legend.position = 'none')
#평점평균이 높은 영화 7개의 리뷰 내용만 뽑아 최빈 단어 & 워드클라우드
data1<-data[data$title %in% result$title,]
nrow(data1)
useNIADic()
data1$review<-gsub('\\W',' ',data1$review)
data1$review<-gsub('[ㄱ-ㅎㅏ-ㅣ]','',data1$review)
View(data1)
#명사 추출
nouns<-extractNoun(data1$review)
wordcount<-table(unlist(nouns))
df_word<-as.data.frame(wordcount,stringsAsFactors = F)
df_word<-rename(df_word, word=Var1, freq=Freq)
df_word<-filter(df_word, nchar(word)>1 & word!="영화")

#최빈 단어 10개 뽑기
top10<-df_word[order(df_word$freq, decreasing = T),][1:10,]
top10
#워드클라우드
pal<-brewer.pal(8,'Dark2')
wordcloud(words=df_word$word,
          freq = df_word$freq,
          min.freq = 5,
          max.words = 150,
          random.order = F,
          rot.per = 0.1,
          scale=c(2,0.3),
          colors = pal)
