import java.io.*;
import org.antlr.runtime.*;

public class LispIntRun {

	public static void main(String[] args) throws Exception {
		//InputStream source = new FileInputStream(args[0]);
		//CalcLexer lexer = new CalcLexer(
		  // new ANTLRInputStream(source));
		
                CharStream cs= new ANTLRFileStream(args[0]);
		LispLexer lexer = new LispLexer (cs);
            
                CommonTokenStream tokens = 
		   new CommonTokenStream(lexer);
		LispParser parser = new LispParser(tokens);
		parser.prog();
	}

}	 
