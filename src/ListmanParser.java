// $ANTLR 3.5 /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g 2013-07-22 19:07:10

import java.io.*;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ListmanParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CAR", "CDR", "EOL", "ID", "LENGTH", 
		"LPAR", "NUM", "RPAR", "SPACE"
	};
	public static final int EOF=-1;
	public static final int CAR=4;
	public static final int CDR=5;
	public static final int EOL=6;
	public static final int ID=7;
	public static final int LENGTH=8;
	public static final int LPAR=9;
	public static final int NUM=10;
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


		 //HashMap store = new HashMap();



	// $ANTLR start "prog"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:14:1: prog : ( sexpr )* EOF ;
	public final void prog() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:15:2: ( ( sexpr )* EOF )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:15:4: ( sexpr )* EOF
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:15:4: ( sexpr )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==LPAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:15:4: sexpr
					{
					pushFollow(FOLLOW_sexpr_in_prog24);
					sexpr();
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



	// $ANTLR start "sexpr"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:20:1: sexpr : ( list | ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' ) );
	public final void sexpr() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:21:2: ( list | ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==LPAR) ) {
				int LA3_1 = input.LA(2);
				if ( ((LA3_1 >= CAR && LA3_1 <= CDR)||LA3_1==LENGTH) ) {
					alt3=2;
				}
				else if ( (LA3_1==ID||(LA3_1 >= LPAR && LA3_1 <= NUM)) ) {
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
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:21:4: list
					{
					pushFollow(FOLLOW_list_in_sexpr66);
					list();
					state._fsp--;

					 LispIntRun.output.println("This is a sexpr-list: term+."); 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:22:4: ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' )
					{
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:22:4: ( '(' CAR sexpr ')' | '(' CDR sexpr ')' | '(' LENGTH sexpr ')' )
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
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:22:5: '(' CAR sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr88); 
							match(input,CAR,FOLLOW_CAR_in_sexpr90); 
							pushFollow(FOLLOW_sexpr_in_sexpr92);
							sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr94); 
							LispIntRun.output.println("This is a sexpr-CAR.");
							}
							break;
						case 2 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:23:19: '(' CDR sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr116); 
							match(input,CDR,FOLLOW_CDR_in_sexpr118); 
							pushFollow(FOLLOW_sexpr_in_sexpr120);
							sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr122); 
							 LispIntRun.output.println("This is a sexpr-CDR.");
							}
							break;
						case 3 :
							// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:24:19: '(' LENGTH sexpr ')'
							{
							match(input,LPAR,FOLLOW_LPAR_in_sexpr169); 
							match(input,LENGTH,FOLLOW_LENGTH_in_sexpr171); 
							pushFollow(FOLLOW_sexpr_in_sexpr173);
							sexpr();
							state._fsp--;

							match(input,RPAR,FOLLOW_RPAR_in_sexpr175); 
							 LispIntRun.output.println("This is a sexpr-LENGTH.");
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
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:28:1: list : '(' ( term )+ ')' ;
	public final void list() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:29:9: ( '(' ( term )+ ')' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:29:17: '(' ( term )+ ')'
			{
			match(input,LPAR,FOLLOW_LPAR_in_list276); 
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:29:21: ( term )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ID||(LA4_0 >= LPAR && LA4_0 <= NUM)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:29:21: term
					{
					pushFollow(FOLLOW_term_in_list278);
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

			match(input,RPAR,FOLLOW_RPAR_in_list281); 
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
	}
	// $ANTLR end "list"



	// $ANTLR start "term"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:33:1: term : ( NUM | ID | '(' sexpr ')' );
	public final void term() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:34:2: ( NUM | ID | '(' sexpr ')' )
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
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:34:7: NUM
					{
					match(input,NUM,FOLLOW_NUM_in_term401); 
					LispIntRun.output.println("This is a term-NUM");
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:35:14: ID
					{
					match(input,ID,FOLLOW_ID_in_term434); 
					 LispIntRun.output.println("This is a term-ID");
					}
					break;
				case 3 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:36:4: '(' sexpr ')'
					{
					match(input,LPAR,FOLLOW_LPAR_in_term468); 
					pushFollow(FOLLOW_sexpr_in_term470);
					sexpr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_term472); 
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



	public static final BitSet FOLLOW_sexpr_in_prog24 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_EOF_in_prog27 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_list_in_sexpr66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr88 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CAR_in_sexpr90 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_sexpr_in_sexpr92 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_sexpr94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr116 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_CDR_in_sexpr118 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_sexpr_in_sexpr120 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_sexpr122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_sexpr169 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_LENGTH_in_sexpr171 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_sexpr_in_sexpr173 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_sexpr175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_list276 = new BitSet(new long[]{0x0000000000000680L});
	public static final BitSet FOLLOW_term_in_list278 = new BitSet(new long[]{0x0000000000000E80L});
	public static final BitSet FOLLOW_RPAR_in_list281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_term401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_term434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_term468 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_sexpr_in_term470 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_RPAR_in_term472 = new BitSet(new long[]{0x0000000000000002L});
}
