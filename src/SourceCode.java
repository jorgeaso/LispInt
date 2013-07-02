import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jorgejaso
 */
public class SourceCode {
    // instance variables
    private String SourceFile;
    // default constructor
    public SourceCode(String sf)
    {
        this.SourceFile = ""; //initializing the name of the file
    }
    // Method that display the source code
    public String DisplaySource() {
                        
			String lispFile;
                        lispFile="/Users/jorgejaso/NetBeansProjects/LispInt/src/test2.lisp";                            
                        String line="";
                        try {
				FileReader reader = new FileReader(lispFile);
				Scanner in = new Scanner(reader);
				while (in.hasNextLine()) { 
					line += in.nextLine();
                                        line += "\n";
				}
                                //displayCode.setText(line);
				reader.close();
			}
			catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "File not found. \n", "Error Message", JOptionPane.ERROR_MESSAGE); 
				System.out.println("File not found");
                                System.exit(0);
			}
	return line;		
    }
    
    // Accesor method
    public String getFileContents() {   
	      return SourceFile;
    }
	

    
    
}
