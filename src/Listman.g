grammar Listman;

@header{
import java.io.*;
import java.util.ArrayList;
}

@members {

	private String[] store = new String[5];
        // private List<String> List1 = new ArrayList<String>();

}

// Programs 

prog
	:	sexpr* EOF   
	;

// Commands


// Expressions

sexpr		                     
	:	list               { LispIntRun.output.println("This is a sexpr composed by list: term+."); }
		|('(' CAR sexpr ')' {LispIntRun.output.println("This is a sexpr composed by CAR.");}
                | '(' CDR sexpr ')' { LispIntRun.output.println("This is a sexpr composed by CDR.");}                         
                | '(' LENGTH sexpr ')' { LispIntRun.output.println("This is a sexpr composed by LENGTH.");}                         
                )
	;

list
        :       '(' term+ ')'       { LispIntRun.output.println("This is a list composed by term+: ATOM | sexpr");}
                                       // New array list
                                       // Array[0]= v;
                
;

term                                returns [String value]                
	:	v=ATOM              { 
                                      LispIntRun.output.println("This is a term composed by an ATOM");}          
	|	'(' sexpr ')'        { LispIntRun.output.println("This is a term composed by a sexpr");}
	;

// Lexer rules

ASSN	:	'=' ;
CAR	:	'car' ;
CDR	:	'cdr' ;
LENGTH	:	'length' ;   


LPAR	:	'(' ;
RPAR	:	')' ;

ATOM	:	('a'..'z'|'A'..'Z'|'0'..'9')+ ;


EOL	:	'\r'? '\n' ;

SPACE	:	(' ' | '\t')+           { skip(); } 
;
