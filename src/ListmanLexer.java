// $ANTLR 3.5 /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g 2013-07-10 17:30:19

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ListmanLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ListmanLexer() {} 
	public ListmanLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ListmanLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g"; }

	// $ANTLR start "ASSN"
	public final void mASSN() throws RecognitionException {
		try {
			int _type = ASSN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:52:6: ( '=' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:52:8: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSN"

	// $ANTLR start "CAR"
	public final void mCAR() throws RecognitionException {
		try {
			int _type = CAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:53:5: ( 'car' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:53:7: 'car'
			{
			match("car"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CAR"

	// $ANTLR start "CDR"
	public final void mCDR() throws RecognitionException {
		try {
			int _type = CDR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:54:5: ( 'cdr' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:54:7: 'cdr'
			{
			match("cdr"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CDR"

	// $ANTLR start "LENGTH"
	public final void mLENGTH() throws RecognitionException {
		try {
			int _type = LENGTH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:55:8: ( 'length' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:55:10: 'length'
			{
			match("length"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LENGTH"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:58:6: ( '(' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:58:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:59:6: ( ')' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:59:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:61:4: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:61:6: ( 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:61:6: ( 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:62:5: ( ( '0' .. '9' )+ )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:62:7: ( '0' .. '9' )+
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:62:7: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM"

	// $ANTLR start "EOL"
	public final void mEOL() throws RecognitionException {
		try {
			int _type = EOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:64:5: ( ( '\\r' )? '\\n' )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:64:7: ( '\\r' )? '\\n'
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:64:7: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:64:7: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EOL"

	// $ANTLR start "SPACE"
	public final void mSPACE() throws RecognitionException {
		try {
			int _type = SPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:66:7: ( ( ' ' | '\\t' )+ )
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:66:9: ( ' ' | '\\t' )+
			{
			// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:66:9: ( ' ' | '\\t' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\t'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SPACE"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:8: ( ASSN | CAR | CDR | LENGTH | LPAR | RPAR | ID | NUM | EOL | SPACE )
		int alt5=10;
		switch ( input.LA(1) ) {
		case '=':
			{
			alt5=1;
			}
			break;
		case 'c':
			{
			switch ( input.LA(2) ) {
			case 'a':
				{
				int LA5_10 = input.LA(3);
				if ( (LA5_10=='r') ) {
					int LA5_13 = input.LA(4);
					if ( ((LA5_13 >= 'A' && LA5_13 <= 'Z')||(LA5_13 >= 'a' && LA5_13 <= 'z')) ) {
						alt5=7;
					}

					else {
						alt5=2;
					}

				}

				else {
					alt5=7;
				}

				}
				break;
			case 'd':
				{
				int LA5_11 = input.LA(3);
				if ( (LA5_11=='r') ) {
					int LA5_14 = input.LA(4);
					if ( ((LA5_14 >= 'A' && LA5_14 <= 'Z')||(LA5_14 >= 'a' && LA5_14 <= 'z')) ) {
						alt5=7;
					}

					else {
						alt5=3;
					}

				}

				else {
					alt5=7;
				}

				}
				break;
			default:
				alt5=7;
			}
			}
			break;
		case 'l':
			{
			int LA5_3 = input.LA(2);
			if ( (LA5_3=='e') ) {
				int LA5_12 = input.LA(3);
				if ( (LA5_12=='n') ) {
					int LA5_15 = input.LA(4);
					if ( (LA5_15=='g') ) {
						int LA5_18 = input.LA(5);
						if ( (LA5_18=='t') ) {
							int LA5_19 = input.LA(6);
							if ( (LA5_19=='h') ) {
								int LA5_20 = input.LA(7);
								if ( ((LA5_20 >= 'A' && LA5_20 <= 'Z')||(LA5_20 >= 'a' && LA5_20 <= 'z')) ) {
									alt5=7;
								}

								else {
									alt5=4;
								}

							}

							else {
								alt5=7;
							}

						}

						else {
							alt5=7;
						}

					}

					else {
						alt5=7;
					}

				}

				else {
					alt5=7;
				}

			}

			else {
				alt5=7;
			}

			}
			break;
		case '(':
			{
			alt5=5;
			}
			break;
		case ')':
			{
			alt5=6;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt5=7;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt5=8;
			}
			break;
		case '\n':
		case '\r':
			{
			alt5=9;
			}
			break;
		case '\t':
		case ' ':
			{
			alt5=10;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}
		switch (alt5) {
			case 1 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:10: ASSN
				{
				mASSN(); 

				}
				break;
			case 2 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:15: CAR
				{
				mCAR(); 

				}
				break;
			case 3 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:19: CDR
				{
				mCDR(); 

				}
				break;
			case 4 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:23: LENGTH
				{
				mLENGTH(); 

				}
				break;
			case 5 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:30: LPAR
				{
				mLPAR(); 

				}
				break;
			case 6 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:35: RPAR
				{
				mRPAR(); 

				}
				break;
			case 7 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:40: ID
				{
				mID(); 

				}
				break;
			case 8 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:43: NUM
				{
				mNUM(); 

				}
				break;
			case 9 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:47: EOL
				{
				mEOL(); 

				}
				break;
			case 10 :
				// /Users/jorgejaso/NetBeansProjects/LispInt/src/Listman.g:1:51: SPACE
				{
				mSPACE(); 

				}
				break;

		}
	}



}
