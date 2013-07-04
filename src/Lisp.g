grammar Lisp;

@header{
import java.util.HashMap;
import java.io.*;

}

// To include a header to lexer @lexer::header {package pkg.name;}


@members {
        
	private int[] store = new int[26]; // implement hashmap
	// ... storage for variables 'a', ..., 'z'
        // HashMap store = new HashMap(); // implementation of hashmap
}

// Programs 

prog
	:	com* EOF   
	;

// Commands

com
	:	'(' PUT v=sexpr ')' EOL       { LispIntRun.output.println($v.value); 
                                                try
                                                {
                                                PrintWriter writerout = null; 
                                                writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
                                                writerout.println($v.value);
                                                writerout.close();
                                                }
                                                catch (IOException ioe)
                                                {
                                                        System.out.println("File I/O error: ");
                                                        ioe.printStackTrace(); // print out details of where exception occurred			
                                                }
                                              }
	|	'(' SETQ ID v=sexpr ')' EOL       { int a = $ID.text.charAt(0) - 'a'; 
                                                    store[a] = $v.value; }
	;

// Expressions

sexpr		                     returns [int value]
	:	v1=term              { $value = $v1.value; }
		|('('
                PLUS v1=sexpr v2=sexpr ')' {$value = $v1.value + $v2.value;}
                | '(' MINUS v1=sexpr v2=sexpr ')' {$value = $v1.value - $v2.value;} 
                | '(' TIMES v1=sexpr v2=sexpr ')' {$value = $v1.value * $v2.value;}
                | '(' QUOTIENT v1=sexpr v2=sexpr ')' {$value = $v1.value / $v2.value;}
                )
	;

term		                     returns [int value]
	:	NUM                  { $value = Integer.parseInt(
		                         $NUM.text); }
	|	ID                   { int a =
		                         $ID.text.charAt(0) - 'a'; 
		                       $value = store[a]; }
	|	LPAR v=sexpr RPAR     { $value = $v.value; }
	;

// Lexicon

PUT	:	'put' ;
SETQ	:	'setq' ;

ASSN	:	'=' ;
PLUS	:	'+' ;
MINUS	:	'-' ;
TIMES	:	'*' ;
QUOTIENT    :   '/' ;
LPAR	:	'(' ;
RPAR	:	')' ;

ID	:	'a'..'z'+ ;
NUM	:	'0'..'9'+ ;

EOL	:	'\r'? '\n' ;

SPACE	:	(' ' | '\t')+        { skip(); } ;
