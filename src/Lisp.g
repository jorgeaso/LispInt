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
	:	PUT v=expr EOL       { System.out.println($v.value); }
	|	'(' SETQ ID v=expr ')' EOL         { int a =
		                         $ID.text.charAt(0) - 'a'; 
		                       store[a] = $v.value; }
	;

// Expressions

expr		                     returns [int value]
	:	
		( PLUS      { $operator = '+'; }
		| MINUS     { $operator = '-'; }
		| TIMES     { $operator = '*'; }
                | QUOTIENT  { $operator = '/'; }
		)*
                v1=term              { $v1 = $v1.value; }
                v2=term              { $v2 = $v2.value; }
                                     { $value = $v1 $operator $v2; }
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
