
grammar Listman;

@header{
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
}

@members {
	 Object resultcar, resultcdr;
         int i=0, resultlen;
         ArrayList atomList = new ArrayList( );
}

// Programs 

prog
	:	sexpr* EOF   
	;


// Expressions

sexpr		                     
	:	list               { LispIntRun.output.println("This is a sexpr-list: term+."); }
		|('(' CAR sexpr ')' {LispIntRun.output.println("This is a sexpr-CAR.");
                                    resultcar= atomList.get(0);
                                    atomList.clear();
                                    atomList.add(resultcar);
                                    LispIntRun.output.println("this is the result of car : "+atomList.get(0));
                                    }
                | '(' CDR sexpr ')' { LispIntRun.output.println("This is a sexpr-CDR.");
                                        LispIntRun.output.println(atomList.size());
                                        atomList.remove(0);
                                        for (int i=0; i<atomList.size();i++ ){
                                            resultcdr= atomList.get(i);
                                            LispIntRun.output.println("This is the result of cdr: "+resultcdr);
                                        }
                                        LispIntRun.output.println("This is the length of array: "+atomList.size());

                                    }                         
                | '(' LENGTH sexpr ')' { LispIntRun.output.println("This is a sexpr-LENGTH.");
                                        resultlen=atomList.size();
                                        LispIntRun.output.println("This is the result of length: "+resultlen);
                                    }                         
                )
	;

list                                returns [ArrayList<String> atomList]
        :       '(' term+ ')'       { LispIntRun.output.println("This is a list of term+: ATOM | sexpr");
                                    }
                                            
        ;

term                                             
	:	ATOM                 { atomList.add($ATOM.text);  
                                     LispIntRun.output.println("This is a term-ATOM");
                                   }          
	|	'(' sexpr ')'      { LispIntRun.output.println("This is a term-sexpr");}
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
