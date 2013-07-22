grammar Listman;

@header{
import java.io.*;
import java.util.HashMap;
}

@members {
	 //HashMap store = new HashMap();
}

// Programs 

prog
	:	sexpr* EOF   
	;

// Expressions

sexpr		                     
	:	list               { LispIntRun.output.println("This is a sexpr-list: term+."); }
		|('(' CAR sexpr ')' {LispIntRun.output.println("This is a sexpr-CAR.");}
                | '(' CDR sexpr ')' { LispIntRun.output.println("This is a sexpr-CDR.");}                         
                | '(' LENGTH sexpr ')' { LispIntRun.output.println("This is a sexpr-LENGTH.");}                         
                )
	;

list                                
        :       '(' term+ ')'       { LispIntRun.output.println("This is a list of term+: ATOM | sexpr");}
                                             
        ;

term                                             
	:    NUM                {LispIntRun.output.println("This is a term-NUM");}	
        |    ID                  { LispIntRun.output.println("This is a term-ID");}          
	|	'(' sexpr ')'       { LispIntRun.output.println("This is a term-sexpr");}
	;

// Lexer rules

CAR	:	'car' ;
CDR	:	'cdr' ;
LENGTH	:	'length' ;   


LPAR	:	'(' ;
RPAR	:	')' ;

ID	:	('a'..'z'|'A'..'Z')+ ;
NUM     :       '0'..'9'+ ;

EOL	:	'\r'? '\n' ;

SPACE	:	(' ' | '\t')+           { skip(); } ;
