#_______________________#
### 12. 텍스트마이닝  ###
#_______________________#

# 문자로 된 비정형 텍스트 데이터로부터 가치있는 정보를 얻어내는 분석 : 텍스트 마이닝에서 가장 먼저 할 일은 형태소 분석

install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP") # not available for this version of R

#google "KoNLP" 검색-> cran 접속 -> archive -> 제일 밑

#우측 packages 탭에서 수동으로 install 하기 위해
install.packages("devtools")

#KoNLP가 의존하는 package 미리 install(install.packages(konlp)하면 필요한거 나옴)
install.packages('hash')
install.packages('tau')
install.packages('Sejong')
##위의 3개 install 했는데 konlp가 install 안되면, RSQLite도 install 해준다.

#우측의 package탭의 install 도구를 이용하여 KoNLP install
#fail 뜬 scala-library-2.11.8.jar 구글 검색, 설치 후
#C:/Program Files/R/R-4.1.0/library/KoNLP/java에 가져다 놓는다.

library(KoNLP)
useNIADic() #사전 설정하기

extractNoun("삶 그리고 죽음")
extractNoun("장면은 그리는 나는 죽음이 삶가")
#힙합 가사 텍스트 마이닝
txt<-readLines('ch01/inData/hiphop.txt')
head(txt)
length(txt)

# 특수문자 제거(trim, 특수문자 제거)
# gsub(oldStr, newStr, string); string에서 oldStr을 newStr로 바꿈
# str_replace_all(string, oldStr, newStr); 위와 같은 결과 

library(stringr)
trim<-function(str){
  gsub('^\\s+|\\s+$','',str) #정규표현식-  ^:맨앞, \\s: space, $:맨뒤 , +:모두
}
trim('    hello   ')
temp<-gsub('\\W',' ',txt) # \\W : 특수문자
txt<-str_replace_all(txt, '\\W',' ')
txt<-trim(txt)
table(temp==txt)
head(txt)

##1.3 명사 추출
nouns<-extractNoun(txt)
class(nouns)
length(nouns) #라인수
head(nouns)
length(unlist(nouns)) #추출된 명사 갯수
wordcount<-table(unlist(nouns)) #워드 카운트(단어별 빈도표) 생성
class(wordcount)
wordcount[order(-wordcount)]

library(dplyr)
df_word<-as.data.frame(wordcount, stringsAsFactors = FALSE)
head(df_word)
df_word<-rename(df_word, word=Var1, freq=Freq)
df_word$word<-trim(df_word$word)
head(df_word)
# 한 글자 이상의 단어만 추출
df_word<-df_word %>% 
  filter(nchar(word)>1)
df_word<-filter(df_word, nchar(word)>1)
head(df_word)
#자주 사용되는 단어 빈도표 top20 그래프 그리기
library(ggplot2)
top20<- df_word[order(-df_word$freq),][1:20,]
ggplot(top20,aes(x=reorder(word,-freq),y=freq))+
  geom_col()+
  coord_flip()+
  geom_text(aes(label=freq),col='red',nudge_x = 0, nudge_y = -1.5)

# 워드 클라우드
  # 1) 비정형 text 데이터 확보
  # 2) 패키지 설치 및 데이터 로드
  # 3) 확보된 text 데이터 읽어오기 (벡터형태)
  # 4) 명사 추출
  # 5) 필요없는 데이터 삭제(특수문자, zz, ㅋㅋ, ㅎㅎ ...)
  # 6) 워드 클라우드 생성 (dataFrame)
  # 7) wordcloud 함수 이용해서 워드클라우드 생성
install.packages("wordcloud")
library(wordcloud)
display.brewer.all()
pal<-brewer.pal(9,"Blues")[5:9]

set.seed(1234) #난수 생성 결과를 일치시키려고
round(runif(6,min=1, max=45))

#wordcloud 함수 에러시 : install.packages('Rcpp')
wordcloud(words=df_word$word, # 뿌려질 단어
          freq =df_word$freq, # 단어 출현 빈도
          min.freq = 2, # 최소 단어 빈도
          max.words = 200, # 표현될 최대 단어 수
          random.order = F, # 최빈단어가 중앙 배치
          rot.per = 0.1, # 회전 단어 비율
          scale = c(4,0.3), # 단어 크기 범위
          colors=pal)
install.packages('Rcpp')
library(wordcloud)

#### 2. 국정원 트윗 데이터 텍스트 마이닝

library(KoNLP)
library(stringr)
library(dplyr)
library(ggplot2)
library(wordcloud)

twitter<-read.csv('ch01/inData/twitter.csv',header = TRUE, stringsAsFactors = FALSE)## 에러 (cp949를 utf8로 바꿔야 함)
twitter<-read.csv('ch01/inData/twitter.csv',header = TRUE, stringsAsFactors = FALSE, fileEncoding = 'utf-8')
View(twitter)

twitter<-rename(twitter,no=번호,id=계정이름, date=작성일, tw=내용)

# 필요없는 문자 삭제
twitter$tw<-str_replace_all(twitter$tw,'\\W',' ')
twitter$tw<-str_replace_all(twitter$tw,'[ㄱ-ㅎ]',' ')
twitter$tw<-trim(twitter$tw)
View(twitter)

#명사 추출
class(twitter$tw)
nouns<-extractNoun(twitter$tw)
#wordcount 생성
wordcount<-table(unlist(nouns))
head(sort(wordcount,decreasing = T))
length(unlist(nouns)) #추출된 명사 수 : 84957
length(wordcount)     #(중복제거) 명사 수 : 10186
df_word<-as.data.frame(wordcount,stringsAsFactors = FALSE)
# 출현단어 중 2글자 이상만 분석
df_word<-filter(df_word, nchar(Var1)>1)

# 최빈 단어 top20개 그래프
top20<-head(df_word[order(df_word$Freq, decreasing = T),],20)
top20 %>% 
  ggplot(aes(x=Freq,y=reorder(Var1,Freq)))+
  geom_col()+
  geom_text(aes(label=Freq), hjust=1, col="yellow", size=2)

#워드 클라우드
pal<-brewer.pal(8,'Dark2')
wordcloud(words=df_word$Var1, freq = df_word$Freq, min.freq = 5, max.words = 400, random.order=F, #최빈 단어를 가운데로
          rot.per = 0.1, scale=c(3,0.2),colors = pal)

# 글 게시 횟수가 150회 이상 트윗한 게시물에 대해 시각화
idCount<-as.data.frame(table(twitter$id))
colnames(idCount)<-c('id','count')
head(idCount,1)
head(twitter,1)

twitter1<-left_join(twitter,idCount, by='id')

head(twitter1)

# 150회 이상 트윗한 계정의 정보만 추출
twitter1<-subset(twitter1,count>150)
table(twitter1$id)

#필요없는 문자 삭제 - 완료
#명사 추출
nouns <- extractNoun((twitter1$tw))
#워드카운트
wordcount<-table(unlist(nouns))
df_word<-as.data.frame(wordcount,stringsAsFactors = F)
df_word<-rename(df_word, word=Var1, freq=Freq)
head(df_word)
df_word<-filter(df_word, nchar(word)>1)
wordcloud(words=df_word$word,
          freq=df_word$freq,
          min.freq = 5,
          max.words = 200,
          random.order = F,
          rot.per = 0.1,
          scale=c(2,0.2),
          colors = pal)
