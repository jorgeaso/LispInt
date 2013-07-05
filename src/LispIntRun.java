import java.io.*;
import org.antlr.runtime.*;
import javax.swing.*;



public class LispIntRun {

    
        public static PrintStream output;
        public static PrintStream filewriter;
        
        
    
	public static void main(String[] args) throws Exception {
		output=System.out;
                //filewriter=
                
                // Reads the specified name of the file through an input dialog box
                String FileName= JOptionPane.showInputDialog(null, "Enter source file name:");
                FileName =FileName.trim();
                String FilePath= "/Users/jorgejaso/NetBeansProjects/LispInt/src/"+FileName;
                System.out.println("Specified File Name:"+FileName);
                System.out.println(FilePath);
                if(FileName.equals("")|| FileName==null){
                    System.exit(0);
                } else {
                    LispIntGUI LispGUI = new LispIntGUI(FileName);
                    LispGUI.setVisible(true);
                }
                
                CharStream cs= new ANTLRFileStream(FilePath);
		LispLexer lexer = new LispLexer (cs);
            
                CommonTokenStream tokens = 
		   new CommonTokenStream(lexer);
		LispParser parser = new LispParser(tokens);
		parser.prog();
	}
        
        
}
        
        

 
