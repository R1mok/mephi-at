/*
  This example comes from a short article series in the Linux 
  Gazette by Richard A. Sevenich and Christopher Lopes, titled
  "Compiler Construction Tools". The article series starts at

  http://www.linuxgazette.com/issue39/sevenich.html

  Small changes and updates to newest JFlex+Cup versions 
  by Gerwin Klein
*/

/*
  Commented By: Christopher Lopes
  File Name: lcalc.flex
  To Create: > jflex lcalc.flex

  and then after the parser is created
  > javac Lexer.java
*/
   
/* --------------------------Usercode Section------------------------ */
   
import java_cup.runtime.*;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
/* 
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java. 
*/
%class Lexer

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column
    
/* 
   Will switch to a CUP compatibility mode to interface with a CUP
   generated parser.
*/
%cup
   
/*
  Declarations
   
  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.  
*/
%{   
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

/*
  Macro Declarations
  
  These declarations are regular expressions that will be used latter
  in the Lexical Rules Section.  
*/
   
/* A line terminator is a \r (carriage return), \n (line feed), or
   \r\n. */
LineTerminator = \r|\n|\r\n
LineTrans = \n
/* White space is a line terminator, space, tab, or line feed. */
WhiteSpace     = {LineTerminator} | [ \t\f]
   
/* A literal integer is is a number beginning with a number between
   one and nine followed by zero or more numbers between zero and nine
   or just a zero.  */
dec_int_lit = 0 | [1-9][0-9]*
   
/* A identifier integer is a word beginning a letter between A and
   Z, a and z, or an underscore followed by zero or more letters
   between A and Z, a and z, zero and nine, or an underscore. */
name = [A-Za-z_]*[0-9]*

   
%%
/* ------------------------Lexical Rules Section---------------------- */
   
/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */
   
   /* YYINITIAL is the state at which the lexer begins scanning.  So
   these regular expressions will only be matched if the scanner is in
   the start state YYINITIAL. */
   
<YYINITIAL> {
    /* Return the token SEMI declared in the class sym that was found. */
    ";"                { return symbol(sym.SEMI); }
   
    /* Print the token found that was declared in the class sym and then
       return it. */
    "+"                { return symbol(sym.PLUS); }
    "-"                { return symbol(sym.MINUS); }
    "*"                { return symbol(sym.TIMES); }
    "/"                { return symbol(sym.DIVIDE); }
    "%"                { return symbol(sym.MOD); }
    "("                { return symbol(sym.LPAREN); }
    ")"                { return symbol(sym.RPAREN); }
    "value"            { return symbol(sym.VALUE, new String(yytext()));}
    "const"            { return symbol(sym.CONST, new String(yytext())); }
    "="                { return symbol(sym.ASSIGN);}
    " "                { }
    ">="               { return symbol(sym.GTE); }
    "<="               { return symbol(sym.LTE); }
    "!="               { return symbol(sym.NE); }
    "{"                { return symbol(sym.LBRACE);}
    "}"                { return symbol(sym.RBRACE);}
    "]"                { return symbol(sym.RSQUARE); }
    "["                { return symbol(sym.LSQUARE); }
    "pointer"          { return symbol(sym.POINTER, new String(yytext()));}
    "array of"         { return symbol(sym.ARRAY_OF, new String(yytext()));}
    ","                { return symbol(sym.COMMA);}
    "return"           { return symbol(sym.RETURN, new String(yytext())); }
    "while"            { return symbol(sym.WHILE); }
    "zero?"            { return symbol(sym.ZERO); }
    "notzero?"         { return symbol(sym.NOTZERO); }
    "foreach"          { return symbol(sym.FOREACH); }
    "finish"           { return symbol(sym.FINISH); }
    "break"            { return symbol(sym.BREAK); }
    "top"              { return symbol(sym.TOP); }
    "bottom"           { return symbol(sym.BOTTOM); }
    "left"             { return symbol(sym.LEFT); }
    "right"            { return symbol(sym.RIGHT); }
    "portal"           { return symbol(sym.PORTAL); }
    "teleport"         { return symbol(sym.TELEPORT); }
    /* If an integer is found print it out, return the token NUMBER
       that represents an integer and the value of the integer that is
       held in the string yytext which will get turned into an integer
       before returning */
    {dec_int_lit}      { return symbol(sym.NUMBER, new Integer(yytext())); }
    //{LineTerminator}        { return symbol(sym.LT);}
   
    /* If an identifier is found print it out, return the token ID
       that represents an identifier and the default value one that is
       given to all identifiers. */
    {name}       { return symbol(sym.NAME  , new String(yytext())); }
    {WhiteSpace} { }
}


/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]              { throw new Error("Illegal character <"+yytext()+">"); }
