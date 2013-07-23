
grammar Listman;

@header{
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
}

@members {
	 Object resultcar, resultcdr;
         int i=0, resultlen;
         ArrayList listTest = new ArrayList( );
}

// Programs 

prog
	:	sexpr* EOF   
	;


// Expressions

sexpr		                     
	:	list               { LispIntRun.output.println("This is a sexpr-list: term+."); }
		|('(' CAR sexpr ')' {LispIntRun.output.println("This is a sexpr-CAR.");
                                    resultcar= listTest.get(0);
                                    listTest.clear();
                                    listTest.add(resultcar);
                                    LispIntRun.output.println("this is the result of car : "+listTest.get(0));
                                    }
                | '(' CDR sexpr ')' { LispIntRun.output.println("This is a sexpr-CDR.");
                                        LispIntRun.output.println(listTest.size());
                                        for (int i=1; i<listTest.size();i++ ){
                                            resultcdr= listTest.get(i);
                                            LispIntRun.output.println("This is the result of cdr: "+resultcdr);
                                        }
                                    }                         
                | '(' LENGTH sexpr ')' { LispIntRun.output.println("This is a sexpr-LENGTH.");
                                        resultlen=listTest.size();
                                        LispIntRun.output.println("This is the result of length: "+resultlen);
                                    }                         
                )
	;

list                                returns [ArrayList<String> listTest]
        :       '(' term+ ')'       { LispIntRun.output.println("This is a list of term+: ATOM | sexpr");
                                      
                                      //listTest.add( "first" );
                                      //listTest.add( "second");
                                      //listTest.add("third");
                                     
                                    }
                                            
        ;

term                                             
	:	ID                {  listTest.add($ID.text);
                                       
                                     LispIntRun.output.println("This is a term-ATOM");
                                   }          
	|	'(' sexpr ')'        { LispIntRun.output.println("This is a term-sexpr");}
	;

// Lexer rules

ASSN	:	'=' ;
CAR	:	'car' ;
CDR	:	'cdr' ;
LENGTH	:	'length' ;   


LPAR	:	'(' ;
RPAR	:	')' ;

ID	:	('a'..'z'|'A'..'Z'|'0'..'9')+ ;


EOL	:	'\r'? '\n' ;

SPACE	:	(' ' | '\t')+           { skip(); } 
;
