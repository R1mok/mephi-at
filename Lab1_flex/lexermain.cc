int main (){
yyFlexLexer ftp;
while (std::cin.good())
	if (ftp.yylex())
		std::cout << "good" << std::endl;
	else
		std::cout << "bad" << std::endl;
return 0;
}

 /* 
 ftp://user@server.domain.zone
 
 
    sms:+79123493262,+79123493262;?
 -- sms:+79123493212;?body=text
 -- sms:+79832142348,+32323232312,+79123432124;?body=text
 -+ tel:+79123493262;?
 ++ fax:+79123493262,+79123493262;?
 -+ sms:+70123403272;?
 
 
 blablabla
 tel:+793231;?
 tel:dsad
 fax:+79123493262;?body=text
 sms:+79123432124;?body=dsad*2))



 */
