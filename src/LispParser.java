// $ANTLR 3.5 /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g 2013-06-28 01:28:09

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



	// $ANTLR start "prog"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:10:1: prog : ( com )* EOF ;
	public final void prog() throws RecognitionException {
		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:11:2: ( ( com )* EOF )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:11:4: ( com )* EOF
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:11:4: ( com )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==LPAR||LA1_0==PUT) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:11:4: com
					{
					pushFollow(FOLLOW_com_in_prog19);
					com();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_prog22); 
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
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:16:1: com : ( PUT v= expr EOL | '(' SETQ ID v= expr ')' EOL );
	public final void com() throws RecognitionException {
		Token ID1=null;
		int v =0;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:17:2: ( PUT v= expr EOL | '(' SETQ ID v= expr ')' EOL )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==PUT) ) {
				alt2=1;
			}
			else if ( (LA2_0==LPAR) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:17:4: PUT v= expr EOL
					{
					match(input,PUT,FOLLOW_PUT_in_com38); 
					pushFollow(FOLLOW_expr_in_com42);
					v=expr();
					state._fsp--;

					match(input,EOL,FOLLOW_EOL_in_com44); 
					 System.out.println(v); 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:18:4: '(' SETQ ID v= expr ')' EOL
					{
					match(input,LPAR,FOLLOW_LPAR_in_com57); 
					match(input,SETQ,FOLLOW_SETQ_in_com59); 
					ID1=(Token)match(input,ID,FOLLOW_ID_in_com61); 
					pushFollow(FOLLOW_expr_in_com65);
					v=expr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_com67); 
					match(input,EOL,FOLLOW_EOL_in_com69); 
					 int a =
							                         (ID1!=null?ID1.getText():null).charAt(0) - 'a'; 
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



	// $ANTLR start "expr"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:25:1: expr returns [int value] : v1= term ( PLUS v2= term | MINUS v2= term | TIMES v2= term | QUOTIENT v2= term )* ;
	public final int expr() throws RecognitionException {
		int value = 0;


		int v1 =0;
		int v2 =0;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:26:2: (v1= term ( PLUS v2= term | MINUS v2= term | TIMES v2= term | QUOTIENT v2= term )* )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:26:4: v1= term ( PLUS v2= term | MINUS v2= term | TIMES v2= term | QUOTIENT v2= term )*
			{
			pushFollow(FOLLOW_term_in_expr120);
			v1=term();
			state._fsp--;

			 value = v1; 
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:27:3: ( PLUS v2= term | MINUS v2= term | TIMES v2= term | QUOTIENT v2= term )*
			loop3:
			while (true) {
				int alt3=5;
				switch ( input.LA(1) ) {
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
				}
				switch (alt3) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:27:5: PLUS v2= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_expr141); 
					pushFollow(FOLLOW_term_in_expr145);
					v2=term();
					state._fsp--;

					 value += v2; 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:28:5: MINUS v2= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_expr159); 
					pushFollow(FOLLOW_term_in_expr163);
					v2=term();
					state._fsp--;

					 value -= v2; 
					}
					break;
				case 3 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:29:5: TIMES v2= term
					{
					match(input,TIMES,FOLLOW_TIMES_in_expr176); 
					pushFollow(FOLLOW_term_in_expr180);
					v2=term();
					state._fsp--;

					 value *= v2; 
					}
					break;
				case 4 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:30:19: QUOTIENT v2= term
					{
					match(input,QUOTIENT,FOLLOW_QUOTIENT_in_expr207); 
					pushFollow(FOLLOW_term_in_expr211);
					v2=term();
					state._fsp--;

					 value /= v2; 
					}
					break;

				default :
					break loop3;
				}
			}

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
	// $ANTLR end "expr"



	// $ANTLR start "term"
	// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:34:1: term returns [int value] : ( NUM | ID | LPAR v= expr RPAR );
	public final int term() throws RecognitionException {
		int value = 0;


		Token NUM2=null;
		Token ID3=null;
		int v =0;

		try {
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:35:2: ( NUM | ID | LPAR v= expr RPAR )
			int alt4=3;
			switch ( input.LA(1) ) {
			case NUM:
				{
				alt4=1;
				}
				break;
			case ID:
				{
				alt4=2;
				}
				break;
			case LPAR:
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:35:4: NUM
					{
					NUM2=(Token)match(input,NUM,FOLLOW_NUM_in_term257); 
					 value = Integer.parseInt(
							                         (NUM2!=null?NUM2.getText():null)); 
					}
					break;
				case 2 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:37:4: ID
					{
					ID3=(Token)match(input,ID,FOLLOW_ID_in_term281); 
					 int a =
							                         (ID3!=null?ID3.getText():null).charAt(0) - 'a'; 
							                       value = store[a]; 
					}
					break;
				case 3 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Lisp.g:40:4: LPAR v= expr RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_term306); 
					pushFollow(FOLLOW_expr_in_term310);
					v=expr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_term312); 
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



	public static final BitSet FOLLOW_com_in_prog19 = new BitSet(new long[]{0x0000000000000880L});
	public static final BitSet FOLLOW_EOF_in_prog22 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PUT_in_com38 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_expr_in_com42 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EOL_in_com44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_com57 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_SETQ_in_com59 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_com61 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_expr_in_com65 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_com67 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EOL_in_com69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr120 = new BitSet(new long[]{0x0000000000011502L});
	public static final BitSet FOLLOW_PLUS_in_expr141 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_term_in_expr145 = new BitSet(new long[]{0x0000000000011502L});
	public static final BitSet FOLLOW_MINUS_in_expr159 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_term_in_expr163 = new BitSet(new long[]{0x0000000000011502L});
	public static final BitSet FOLLOW_TIMES_in_expr176 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_term_in_expr180 = new BitSet(new long[]{0x0000000000011502L});
	public static final BitSet FOLLOW_QUOTIENT_in_expr207 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_term_in_expr211 = new BitSet(new long[]{0x0000000000011502L});
	public static final BitSet FOLLOW_NUM_in_term257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_term281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_term306 = new BitSet(new long[]{0x00000000000002C0L});
	public static final BitSet FOLLOW_expr_in_term310 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RPAR_in_term312 = new BitSet(new long[]{0x0000000000000002L});
}
