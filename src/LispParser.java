// $ANTLR 3.5 /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g 2013-07-04 14:09:19

import java.util.HashMap;
import java.io.*;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LispParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSN", "EOL", "ID", "LPAR", "MINUS", 
		"NUM", "PLUS", "PUT", "QUOTIENT", "RPAR", "SETQ", "SPACE", "TIMES"
	};
	public static final int EOF=-1;
	public static final int ASSN=4;
	public static final int EOL=5;
	public static final int ID=6;
	public static final int LPAR=7;
	public static final int MINUS=8;
	public static final int NUM=9;
	public static final int PLUS=10;
	public static final int PUT=11;
	public static final int QUOTIENT=12;
	public static final int RPAR=13;
	public static final int SETQ=14;
	public static final int SPACE=15;
	public static final int TIMES=16;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public LispParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public LispParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return LispParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g"; }


	        
		private int[] store = new int[26]; // implement hashmap
		// ... storage for variables 'a', ..., 'z'
	        // HashMap store = new HashMap(); // implementation of hashmap



	// $ANTLR start "prog"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:21:1: prog : ( com )* EOF ;
	public final void prog() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:22:2: ( ( com )* EOF )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:22:4: ( com )* EOF
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:22:4: ( com )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==LPAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:22:4: com
					{
					pushFollow(FOLLOW_com_in_prog27);
					com();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_prog30); 
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



	// $ANTLR start "com"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:27:1: com : ( '(' PUT v= sexpr ')' EOL | '(' SETQ ID v= sexpr ')' EOL );
	public final void com() throws RecognitionException {
		Token ID1=null;
		int v =0;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:28:2: ( '(' PUT v= sexpr ')' EOL | '(' SETQ ID v= sexpr ')' EOL )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==LPAR) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==PUT) ) {
					alt2=1;
				}
				else if ( (LA2_1==SETQ) ) {
					alt2=2;
				}

				else {
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
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:28:4: '(' PUT v= sexpr ')' EOL
					{
					match(input,LPAR,FOLLOW_LPAR_in_com46); 
					match(input,PUT,FOLLOW_PUT_in_com48); 
					pushFollow(FOLLOW_sexpr_in_com52);
					v=sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_com54); 
					match(input,EOL,FOLLOW_EOL_in_com56); 
					 LispIntRun.output.println(v); 
					                                                try
					                                                {
					                                                PrintWriter writerout = null; 
					                                                writerout = new PrintWriter(new BufferedWriter(new FileWriter("LispOutput", true))); // write to a file and appends the results in case there are more than 1 line
					                                                writerout.println(v);
					                                                writerout.close();
					                                                }
					                                                catch (IOException ioe)
					                                                {
					                                                        System.out.println("File I/O error: ");
					                                                        ioe.printStackTrace(); // print out details of where exception occurred			
					                                                }
					                                              
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:42:4: '(' SETQ ID v= sexpr ')' EOL
					{
					match(input,LPAR,FOLLOW_LPAR_in_com69); 
					match(input,SETQ,FOLLOW_SETQ_in_com71); 
					ID1=(Token)match(input,ID,FOLLOW_ID_in_com73); 
					pushFollow(FOLLOW_sexpr_in_com77);
					v=sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_com79); 
					match(input,EOL,FOLLOW_EOL_in_com81); 
					 int a = (ID1!=null?ID1.getText():null).charAt(0) - 'a'; 
					                                                    store[a] = v; 
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
	// $ANTLR end "com"



	// $ANTLR start "sexpr"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:48:1: sexpr returns [int value] : (v1= term | ( '(' PLUS v1= sexpr v2= sexpr ')' | '(' MINUS v1= sexpr v2= sexpr ')' | '(' TIMES v1= sexpr v2= sexpr ')' | '(' QUOTIENT v1= sexpr v2= sexpr ')' ) );
	public final int sexpr() throws RecognitionException {
		int value = 0;


		int v1 =0;
		int v2 =0;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:49:2: (v1= term | ( '(' PLUS v1= sexpr v2= sexpr ')' | '(' MINUS v1= sexpr v2= sexpr ')' | '(' TIMES v1= sexpr v2= sexpr ')' | '(' QUOTIENT v1= sexpr v2= sexpr ')' ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID||LA4_0==NUM) ) {
				alt4=1;
			}
			else if ( (LA4_0==LPAR) ) {
				int LA4_2 = input.LA(2);
				if ( (LA4_2==MINUS||LA4_2==PLUS||LA4_2==QUOTIENT||LA4_2==TIMES) ) {
					alt4=2;
				}
				else if ( ((LA4_2 >= ID && LA4_2 <= LPAR)||LA4_2==NUM) ) {
					alt4=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:49:4: v1= term
					{
					pushFollow(FOLLOW_term_in_sexpr130);
					v1=term();
					state._fsp--;

					 value = v1; 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:50:4: ( '(' PLUS v1= sexpr v2= sexpr ')' | '(' MINUS v1= sexpr v2= sexpr ')' | '(' TIMES v1= sexpr v2= sexpr ')' | '(' QUOTIENT v1= sexpr v2= sexpr ')' )
					{
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:50:4: ( '(' PLUS v1= sexpr v2= sexpr ')' | '(' MINUS v1= sexpr v2= sexpr ')' | '(' TIMES v1= sexpr v2= sexpr ')' | '(' QUOTIENT v1= sexpr v2= sexpr ')' )
					int alt3=4;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==LPAR) ) {
						switch ( input.LA(2) ) {
						case PLUS:
							{
							alt3=1;
							}
							break;
						case MINUS:
							{
							alt3=2;
							}
							break;
						case TIMES:
							{
							alt3=3;
							}
							break;
						case QUOTIENT:
							{
							alt3=4;
							}
							break;
						default:
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
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:50:5: '(' PLUS v1= sexpr v2= sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr151); 
							match(input,PLUS,FOLLOW_PLUS_in_sexpr169); 
							pushFollow(FOLLOW_sexpr_in_sexpr173);
							v1=sexpr();
							state._fsp--;

							pushFollow(FOLLOW_sexpr_in_sexpr177);
							v2=sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr179); 
							value = v1 + v2;
							}
							break;
						case 2 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:52:19: '(' MINUS v1= sexpr v2= sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr201); 
							match(input,MINUS,FOLLOW_MINUS_in_sexpr203); 
							pushFollow(FOLLOW_sexpr_in_sexpr207);
							v1=sexpr();
							state._fsp--;

							pushFollow(FOLLOW_sexpr_in_sexpr211);
							v2=sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr213); 
							value = v1 - v2;
							}
							break;
						case 3 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:53:19: '(' TIMES v1= sexpr v2= sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr236); 
							match(input,TIMES,FOLLOW_TIMES_in_sexpr238); 
							pushFollow(FOLLOW_sexpr_in_sexpr242);
							v1=sexpr();
							state._fsp--;

							pushFollow(FOLLOW_sexpr_in_sexpr246);
							v2=sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr248); 
							value = v1 * v2;
							}
							break;
						case 4 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:54:19: '(' QUOTIENT v1= sexpr v2= sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr270); 
							match(input,QUOTIENT,FOLLOW_QUOTIENT_in_sexpr272); 
							pushFollow(FOLLOW_sexpr_in_sexpr276);
							v1=sexpr();
							state._fsp--;

							pushFollow(FOLLOW_sexpr_in_sexpr280);
							v2=sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr282); 
							value = v1 / v2;
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
		return value;
	}
	// $ANTLR end "sexpr"



	// $ANTLR start "term"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:58:1: term returns [int value] : ( NUM | ID | LPAR v= sexpr RPAR );
	public final int term() throws RecognitionException {
		int value = 0;


		Token NUM2=null;
		Token ID3=null;
		int v =0;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:59:2: ( NUM | ID | LPAR v= sexpr RPAR )
			int alt5=3;
			switch ( input.LA(1) ) {
			case NUM:
				{
				alt5=1;
				}
				break;
			case ID:
				{
				alt5=2;
				}
				break;
			case LPAR:
				{
				alt5=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:59:4: NUM
					{
					NUM2=(Token)match(input,NUM,FOLLOW_NUM_in_term339); 
					 value = Integer.parseInt(
							                         (NUM2!=null?NUM2.getText():null)); 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:61:4: ID
					{
					ID3=(Token)match(input,ID,FOLLOW_ID_in_term363); 
					 int a =
							                         (ID3!=null?ID3.getText():null).charAt(0) - 'a'; 
							                       value = store[a]; 
					}
					break;
				case 3 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:64:4: LPAR v= sexpr RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_term388); 
					pushFollow(FOLLOW_sexpr_in_term392);
					v=sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_term394); 
					 value = v; 
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
		return value;
	}
	// $ANTLR end "term"

	// Delegated rules



	public static final BitSet FOLLOW_com_in_prog27 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EOF_in_prog30 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_com46 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_PUT_in_com48 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_com52 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_com54 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EOL_in_com56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_com69 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_SETQ_in_com71 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_com73 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_com77 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_com79 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EOL_in_com81 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_sexpr130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr151 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_PLUS_in_sexpr169 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr173 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr177 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr201 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_MINUS_in_sexpr203 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr207 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr211 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr236 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_TIMES_in_sexpr238 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr242 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr246 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr270 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_QUOTIENT_in_sexpr272 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr276 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_sexpr280 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_term339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_term363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_term388 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_sexpr_in_term392 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_term394 = new BitSet(new long[]{0x0000000000000002L});
}
