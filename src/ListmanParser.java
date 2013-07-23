// $ANTLR 3.5 /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g 2013-07-23 04:50:36

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ListmanParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSN", "ATOM", "CAR", "CDR", 
		"EOL", "LENGTH", "LPAR", "RPAR", "SPACE"
	};
	public static final int EOF=-1;
	public static final int ASSN=4;
	public static final int ATOM=5;
	public static final int CAR=6;
	public static final int CDR=7;
	public static final int EOL=8;
	public static final int LENGTH=9;
	public static final int LPAR=10;
	public static final int RPAR=11;
	public static final int SPACE=12;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ListmanParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ListmanParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ListmanParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g"; }


		 Object resultcar, resultcdr;
	         int i=0, resultlen;
	         ArrayList atomList = new ArrayList( );



	// $ANTLR start "prog"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:18:1: prog : ( sexpr )* EOF ;
	public final void prog() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:19:2: ( ( sexpr )* EOF )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:19:4: ( sexpr )* EOF
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:19:4: ( sexpr )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==LPAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:19:4: sexpr
					{
					pushFollow(FOLLOW_sexpr_in_prog25);
					sexpr();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_prog28); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "sexpr"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:25:1: sexpr : ( list | ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' ) );
	public final void sexpr() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:26:2: ( list | ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==LPAR) ) {
				int LA3_1 = input.LA(2);
				if ( ((LA3_1 >= CAR && LA3_1 <= CDR)||LA3_1==LENGTH) ) {
					alt3=2;
				}
				else if ( (LA3_1==ATOM||LA3_1==LPAR) ) {
					alt3=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:26:4: list
					{
					pushFollow(FOLLOW_list_in_sexpr68);
					list();
					state._fsp--;

					 LispIntRun.output.println("Found sexpr-list: term+."); 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:27:4: ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' )
					{
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:27:4: ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' )
					int alt2=3;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==LPAR) ) {
						switch ( input.LA(2) ) {
						case CAR:
							{
							alt2=1;
							}
							break;
						case CDR:
							{
							alt2=2;
							}
							break;
						case LENGTH:
							{
							alt2=3;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 2, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						throw nvae;
					}

					switch (alt2) {
						case 1 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:27:5: '(' CAR sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr90); 
							match(input,CAR,FOLLOW_CAR_in_sexpr92); 
							pushFollow(FOLLOW_sexpr_in_sexpr94);
							sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr96); 
							LispIntRun.output.println("Found sexpr-CAR.");
							                                    resultcar= atomList.get(0);
							                                    atomList.clear();
							                                    atomList.add(resultcar);
							                                    try{
							                                    PrintWriter writerout = null; 
							                                    writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
							                                    writerout.println(atomList.get(0)); // LispIntRun.filewriter.println();
							                                    writerout.close();
							                                    }
							                                    catch (IOException ioe){
							                                            System.out.println("File I/O error: ");
							                                            ioe.printStackTrace(); // print out details of where exception occurred			
							                                    }
							                                    // LispIntRun.output.println("this is the result of car : "+atomList.get(0));
							                                    
							}
							break;
						case 2 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:43:19: '(' CDR sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr118); 
							match(input,CDR,FOLLOW_CDR_in_sexpr120); 
							pushFollow(FOLLOW_sexpr_in_sexpr122);
							sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr124); 
							 LispIntRun.output.println("This is a sexpr-CDR.");
							                                        
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
							break;
						case 3 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:63:19: '(' LENGTH sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr171); 
							match(input,LENGTH,FOLLOW_LENGTH_in_sexpr173); 
							pushFollow(FOLLOW_sexpr_in_sexpr175);
							sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr177); 
							 LispIntRun.output.println("This is a sexpr-LENGTH.");
							                                        resultlen=atomList.size();
							                                        try{
							                                            PrintWriter writerout = null; 
							                                            writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
							                                            writerout.print(resultlen); // LispIntRun.filewriter.println();
							                                            writerout.close();
							                                        }
							                                        catch (IOException ioe){
							                                            System.out.println("File I/O error: ");
							                                            ioe.printStackTrace(); // print out details of where exception occurred			
							                                        }
							                                        //LispIntRun.output.println("This is the result of length: "+resultlen);
							                                    
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "sexpr"



	// $ANTLR start "list"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:80:1: list returns [ArrayList<String> atomList] : '(' ( term )+ ')' ;
	public final ArrayList<String> list() throws RecognitionException {
		ArrayList<String> atomList = null;


		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:81:9: ( '(' ( term )+ ')' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:81:17: '(' ( term )+ ')'
			{
			match(input,LPAR,FOLLOW_LPAR_in_list281); 
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:81:21: ( term )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ATOM||LA4_0==LPAR) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:81:21: term
					{
					pushFollow(FOLLOW_term_in_list283);
					term();
					state._fsp--;

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			match(input,RPAR,FOLLOW_RPAR_in_list286); 
			 LispIntRun.output.println("This is a list of term+: ATOM | sexpr");
			                                    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return atomList;
	}
	// $ANTLR end "list"



	// $ANTLR start "term"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:86:1: term : ( ATOM | '(' sexpr ')' );
	public final void term() throws RecognitionException {
		Token ATOM1=null;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:87:2: ( ATOM | '(' sexpr ')' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ATOM) ) {
				alt5=1;
			}
			else if ( (LA5_0==LPAR) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:87:4: ATOM
					{
					ATOM1=(Token)match(input,ATOM,FOLLOW_ATOM_in_term402); 
					 atomList.add((ATOM1!=null?ATOM1.getText():null));  
					                                     LispIntRun.output.println("This is a term-ATOM");
					                                   
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:90:4: '(' sexpr ')'
					{
					match(input,LPAR,FOLLOW_LPAR_in_term435); 
					pushFollow(FOLLOW_sexpr_in_term437);
					sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_term439); 
					 LispIntRun.output.println("This is a term-sexpr");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "term"

	// Delegated rules



	public static final BitSet FOLLOW_sexpr_in_prog25 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_prog28 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_list_in_sexpr68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr90 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CAR_in_sexpr92 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_sexpr94 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_sexpr96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr118 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CDR_in_sexpr120 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_sexpr122 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_sexpr124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr171 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_LENGTH_in_sexpr173 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_sexpr175 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_sexpr177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_list281 = new BitSet(new long[]{0x0000000000000420L});
	public static final BitSet FOLLOW_term_in_list283 = new BitSet(new long[]{0x0000000000000C20L});
	public static final BitSet FOLLOW_RPAR_in_list286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATOM_in_term402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_term435 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_term437 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_term439 = new BitSet(new long[]{0x0000000000000002L});
}
