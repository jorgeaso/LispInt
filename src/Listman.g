// List Manipulation Grammar File
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
         private static final boolean DEBUG = true;         
}

// Programs 

prog
	:	sexpr* (EOF | EOL)         
	;

// Expressions

sexpr		                     
	:	list               { LispIntRun.output.println("Found sexpr - LIST: term+."); }
		|('(' CAR sexpr ')' {LispIntRun.output.println("S-expression: CAR");
                                    resultcar= atomList.get(0);
                                    atomList.clear();
                                    atomList.add(resultcar);
                                    try{
                                        PrintWriter writerout = null; 
                                        writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
                                        writerout.print(atomList.get(0)); // LispIntRun.filewriter.println();
                                        writerout.close();
                                    }
                                    catch (IOException ioe){
                                        System.out.println("File I/O error: ");
                                        ioe.printStackTrace(); // print out details of where exception occurred			
                                    }
                                    // LispIntRun.output.println("this is the result of car : "+atomList.get(0));
                                    }
                | '(' CDR sexpr ')' { LispIntRun.output.println("S-expression: CDR");
                                        
                                        atomList.remove(0);
                                        for (int i=0; i<atomList.size();i++ ){
                                            resultcdr= atomList.get(i);
                                            try{
                                                PrintWriter writerout = null; 
                                                writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
                                                writerout.print(resultcdr+" "); // LispIntRun.filewriter.println();
                                                writerout.close();
                                            }
                                            catch (IOException ioe){
                                                System.out.println("File I/O error: ");
                                                ioe.printStackTrace(); // print out details of where exception occurred			
                                            }
                                            //LispIntRun.output.println("This is the result of cdr: "+resultcdr);
                                        }   

                                    }                         
                | '(' LENGTH sexpr ')' { LispIntRun.output.println("S-expression: LENGTH");
                                        resultlen=atomList.size();
                                        try{
                                            PrintWriter writerout = null; 
                                            writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
                                            writerout.print("\n"+resultlen); // LispIntRun.filewriter.println();
                                            writerout.close();
                                        }
                                        catch (IOException ioe){
                                            System.out.println("File I/O error: ");
                                            ioe.printStackTrace(); // print out details of where exception occurred			
                                        }
                                        //LispIntRun.output.println("This is the result of length: "+resultlen);
                                    }                         
                )
	;

list                                returns [ArrayList<String> atomList]
        :       '(' term+ ')'       { LispIntRun.output.println("List of term+: ATOM | sexpr");
                                    }
                                            
        ;

term                                             
	:	ATOM               { atomList.add($ATOM.text);  
                                     LispIntRun.output.println("Term found: ATOM");
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
