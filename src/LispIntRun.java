import java.io.*;
import org.antlr.runtime.*;


public class LispIntRun {

	public static void main(String[] args) throws Exception {
		// Reads the specified name of the file provided in argument 0
                CharStream cs= new ANTLRFileStream(args[0]);
		LispLexer lexer = new LispLexer (cs);
            
                CommonTokenStream tokens = 
		   new CommonTokenStream(lexer);
		LispParser parser = new LispParser(tokens);
		parser.prog();
	}

}	 
