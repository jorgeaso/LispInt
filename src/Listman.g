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
	:	list               { 
                                   }
		|('(' CAR sexpr ')' {
                                    LispIntRun.ps.println("Found CAR S-expression");
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
                | '(' CDR sexpr ')' { LispIntRun.ps.println("Found CDR S-expression");
                                        
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
                | '(' LENGTH sexpr ')' { LispIntRun.ps.println("Found LENGTH S-expression");
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
        :       '(' term+ ')'       { LispIntRun.ps.println("Found a LIST composed by one or more atoms");
                                    }
                                            
        ;

term                                             
	:	ATOM               { atomList.add($ATOM.text);  
                                     LispIntRun.ps.println("Found Atom");
                                   }          
	|	'(' sexpr ')'      { LispIntRun.ps.println("Found S-expression");}
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
