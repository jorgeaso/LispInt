grammar Lisp;

@members {
        
	private int[] store = new int[26]; // implement hashmap
	// ... storage for variables 'a', ..., 'z'
}

// Programs 

prog
	:	com* EOF   
	;

// Commands

com
	:	'(' PUT v=expr ')' EOL       { System.out.println($v.value); }
	|	'(' SETQ ID v=expr ')' EOL       { int a =
		                         $ID.text.charAt(0) - 'a'; 
		                       store[a] = $v.value; }
	;

// Expressions

expr		                     returns [int value]
	:	v1=term              { $value = $v1.value; }
		|('('
                PLUS v1=expr v2=expr ')' {$value = $v1.value + $v2.value;}
                | '(' MINUS v1=expr v2=expr ')' {$value = $v1.value - $v2.value;} 
                | '(' TIMES v1=expr v2=expr ')' {$value = $v1.value * $v2.value;}
                | '(' QUOTIENT v1=expr v2=expr ')' {$value = $v1.value - $v2.value;}
                )
	;

term		                     returns [int value]
	:	NUM                  { $value = Integer.parseInt(
		                         $NUM.text); }
	|	ID                   { int a =
		                         $ID.text.charAt(0) - 'a'; 
		                       $value = store[a]; }
	|	LPAR v=expr RPAR     { $value = $v.value; }
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
