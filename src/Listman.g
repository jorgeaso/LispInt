grammar Listman;

@header{
import java.io.*;
}

@members {
        
	private String[] store = new String[26]; 
	// ... storage for variables 'a', ..., 'z'
        
}

// Programs 

prog
	:	com* EOF   
	;

// Commands

com
	:	'(' CAR v=sexpr ')' EOL       { LispIntRun.output.println($v.value);} // PrintWriter
	|	'(' CDR v=sexpr ')' EOL       { LispIntRun.output.println($v.value);}
        |	'(' LENGTH v=sexpr ')' EOL    { LispIntRun.output.println($v.value);}
                                            /* { int a = $ID.text.charAt(0) - 'a'; 
                                            //   store[a] = $v.value;  
                                            // } */ 
                                            // Por el momento no es necesario almacenar los elementos de la lista en el array
	;

// Expressions

sexpr		                     returns [String value]
	:	'(' v1=term ')'       { $value = $v1.value; }
		|('(' CAR v1=term ')' {$value = store[0];}
                | '(' CDR v1=term ')' {$value = store[1];} 
                | '(' LENGTH v1=term ')' {int tmp = store.length; $value= ""+tmp;
                                         }
                )
	;

term		                     returns [String value]
	:	NUM                  { $value = $NUM.text; }
	|	ID                   { int a = $ID.text.charAt(0) - 'a';
                                       $value = store[a];}
	|	'(' v=sexpr ')'     { $value = $v.value; }
	;

// Lexer rules

ASSN	:	'=' ;
CAR	:	'car' ;
CDR	:	'cdr' ;
LENGTH	:	'length' ;   


LPAR	:	'(' ;
RPAR	:	')' ;

ID	:	('a'..'z'|'A'..'Z')+ ;
NUM	:	'0'..'9'+ ;

EOL	:	'\r'? '\n' ;

SPACE	:	(' ' | '\t')+        { skip(); } ;
