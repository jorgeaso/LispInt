// $ANTLR 3.5 /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g 2013-07-10 17:30:18

import java.io.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ListmanParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSN", "CAR", "CDR", "EOL", "ID", 
		"LENGTH", "LPAR", "NUM", "RPAR", "SPACE"
	};
	public static final int EOF=-1;
	public static final int ASSN=4;
	public static final int CAR=5;
	public static final int CDR=6;
	public static final int EOL=7;
	public static final int ID=8;
	public static final int LENGTH=9;
	public static final int LPAR=10;
	public static final int NUM=11;
	public static final int RPAR=12;
	public static final int SPACE=13;

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


	        
		private String[] store = new String[26]; 
		// ... storage for variables 'a', ..., 'z'
	        



	// $ANTLR start "prog"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:16:1: prog : ( com )* EOF ;
	public final void prog() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:17:2: ( ( com )* EOF )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:17:4: ( com )* EOF
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:17:4: ( com )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==LPAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:17:4: com
					{
					pushFollow(FOLLOW_com_in_prog24);
					com();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_prog27); 
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
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:22:1: com : ( '(' CAR v= sexpr ')' EOL | '(' CDR v= sexpr ')' EOL | '(' LENGTH v= sexpr ')' EOL );
	public final void com() throws RecognitionException {
		String v =null;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:23:2: ( '(' CAR v= sexpr ')' EOL | '(' CDR v= sexpr ')' EOL | '(' LENGTH v= sexpr ')' EOL )
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
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:23:4: '(' CAR v= sexpr ')' EOL
					{
					match(input,LPAR,FOLLOW_LPAR_in_com43); 
					match(input,CAR,FOLLOW_CAR_in_com45); 
					pushFollow(FOLLOW_sexpr_in_com49);
					v=sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_com51); 
					match(input,EOL,FOLLOW_EOL_in_com53); 
					 LispIntRun.output.println(v);
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:24:4: '(' CDR v= sexpr ')' EOL
					{
					match(input,LPAR,FOLLOW_LPAR_in_com67); 
					match(input,CDR,FOLLOW_CDR_in_com69); 
					pushFollow(FOLLOW_sexpr_in_com73);
					v=sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_com75); 
					match(input,EOL,FOLLOW_EOL_in_com77); 
					 LispIntRun.output.println(v);
					}
					break;
				case 3 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:25:11: '(' LENGTH v= sexpr ')' EOL
					{
					match(input,LPAR,FOLLOW_LPAR_in_com97); 
					match(input,LENGTH,FOLLOW_LENGTH_in_com99); 
					pushFollow(FOLLOW_sexpr_in_com103);
					v=sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_com105); 
					match(input,EOL,FOLLOW_EOL_in_com107); 
					 LispIntRun.output.println(v);
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
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:34:1: sexpr returns [String value] : ( '(' v1= term ')' | ( '(' CAR v1= term ')' | '(' CDR v1= term ')' | '(' LENGTH v1= term ')' ) );
	public final String sexpr() throws RecognitionException {
		String value = null;


		String v1 =null;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:35:2: ( '(' v1= term ')' | ( '(' CAR v1= term ')' | '(' CDR v1= term ')' | '(' LENGTH v1= term ')' ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==LPAR) ) {
				int LA4_1 = input.LA(2);
				if ( ((LA4_1 >= CAR && LA4_1 <= CDR)||LA4_1==LENGTH) ) {
					alt4=2;
				}
				else if ( (LA4_1==ID||(LA4_1 >= LPAR && LA4_1 <= NUM)) ) {
					alt4=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
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
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:35:4: '(' v1= term ')'
					{
					match(input,LPAR,FOLLOW_LPAR_in_sexpr243); 
					pushFollow(FOLLOW_term_in_sexpr247);
					v1=term();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_sexpr249); 
					 value = v1; 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:36:4: ( '(' CAR v1= term ')' | '(' CDR v1= term ')' | '(' LENGTH v1= term ')' )
					{
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:36:4: ( '(' CAR v1= term ')' | '(' CDR v1= term ')' | '(' LENGTH v1= term ')' )
					int alt3=3;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==LPAR) ) {
						switch ( input.LA(2) ) {
						case CAR:
							{
							alt3=1;
							}
							break;
						case CDR:
							{
							alt3=2;
							}
							break;
						case LENGTH:
							{
							alt3=3;
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
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:36:5: '(' CAR v1= term ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr263); 
							match(input,CAR,FOLLOW_CAR_in_sexpr265); 
							pushFollow(FOLLOW_term_in_sexpr269);
							v1=term();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr271); 
							value = store[0];
							}
							break;
						case 2 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:37:19: '(' CDR v1= term ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr293); 
							match(input,CDR,FOLLOW_CDR_in_sexpr295); 
							pushFollow(FOLLOW_term_in_sexpr299);
							v1=term();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr301); 
							value = v1 + v1;
							}
							break;
						case 3 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:38:19: '(' LENGTH v1= term ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr324); 
							match(input,LENGTH,FOLLOW_LENGTH_in_sexpr326); 
							pushFollow(FOLLOW_term_in_sexpr330);
							v1=term();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr332); 
							int tmp = store.length; value = ""+tmp;
							                                         
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
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:43:1: term returns [String value] : ( NUM | ID | '(' v= sexpr ')' );
	public final String term() throws RecognitionException {
		String value = null;


		Token NUM1=null;
		Token ID2=null;
		String v =null;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:44:2: ( NUM | ID | '(' v= sexpr ')' )
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
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:44:4: NUM
					{
					NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_term389); 
					 value = (NUM1!=null?NUM1.getText():null); 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:45:4: ID
					{
					ID2=(Token)match(input,ID,FOLLOW_ID_in_term413); 
					 int a = (ID2!=null?ID2.getText():null).charAt(0) - 'a';
					                                       value = store[a];
					}
					break;
				case 3 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:47:4: '(' v= sexpr ')'
					{
					match(input,LPAR,FOLLOW_LPAR_in_term438); 
					pushFollow(FOLLOW_sexpr_in_term442);
					v=sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_term444); 
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



	public static final BitSet FOLLOW_com_in_prog24 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_prog27 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_com43 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_CAR_in_com45 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_com49 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_com51 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EOL_in_com53 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_com67 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CDR_in_com69 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_com73 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_com75 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EOL_in_com77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_com97 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_LENGTH_in_com99 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_com103 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_com105 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EOL_in_com107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr243 = new BitSet(new long[]{0x0000000000000D00L});
	public static final BitSet FOLLOW_term_in_sexpr247 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr263 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_CAR_in_sexpr265 = new BitSet(new long[]{0x0000000000000D00L});
	public static final BitSet FOLLOW_term_in_sexpr269 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr293 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CDR_in_sexpr295 = new BitSet(new long[]{0x0000000000000D00L});
	public static final BitSet FOLLOW_term_in_sexpr299 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr324 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_LENGTH_in_sexpr326 = new BitSet(new long[]{0x0000000000000D00L});
	public static final BitSet FOLLOW_term_in_sexpr330 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_sexpr332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_term389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_term413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_term438 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_sexpr_in_term442 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_term444 = new BitSet(new long[]{0x0000000000000002L});
}
