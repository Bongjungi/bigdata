library(rvest)
url<-'https://finance.naver.com/'
html <- read_html(url, encoding='euc-kr')
html
#1
nodes<-html_nodes(html,'.group2 .tbl_home a')
title<-html_text(nodes)
title
#2
nodes<-html_nodes(html,'.bu_p .blind')
ch1<-html_text(nodes)
ch1
#3
nodes<-html_nodes(html,'.up td')
ch2<-html_text(nodes)
ch2
