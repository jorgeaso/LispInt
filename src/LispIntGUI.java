import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.runtime.*;

/**
 *
 * @author jorgejaso
 */

public class LispIntGUI extends JFrame implements ActionListener {
    /** GUI Buttons **/
    private JButton selectButton, executeButton, exitButton;
    /** GUI TextArea to display source lisp code and output */
    private JTextArea CodeTextArea, OutputTextArea;
    /** GUI Label output */
    private JLabel SourceLabel, SelectLabel, OutputLabel;
    /** GUI Label output */
    private JFileChooser FileChooser;
    private String FilePath="";
    private DisplayCode SourceCodeObject =new DisplayCode(FilePath);
 
    String lispFile; 
    
    // Constructor for a new GUI
    public LispIntGUI() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Lisp Interpreter");
            setSize(700, 400);
            layoutTop();
            layoutMiddle();
            layoutBottom();	
    } 
                
    // Class JPanel containing Select Button
    public void layoutTop() {
            JPanel topJPanel = new JPanel();
            topJPanel.setLayout(new BorderLayout());
            JPanel MiddleTop = new JPanel();
            selectButton= new JButton("Select File");
            selectButton.addActionListener(this);
            MiddleTop.add(selectButton);
            topJPanel.add(MiddleTop, BorderLayout.CENTER);
            add(topJPanel, BorderLayout.NORTH);
    } // End layoutTop
    
    // Class JPanel containing Label, JTextArea and Execute Button
    public void layoutMiddle() {
            JPanel middleJPanel = new JPanel();
            middleJPanel.setLayout(new BorderLayout());
            JPanel UpperMiddle = new JPanel();
            JPanel MiddleMiddle = new JPanel();
            JPanel LowerMiddle = new JPanel();
            
            SourceLabel= new JLabel("Source Lisp Code:");
            UpperMiddle.add(SourceLabel, BorderLayout.NORTH);
            
            CodeTextArea = new JTextArea(7,75);
            CodeTextArea.setFont(new Font("Courier", Font.PLAIN, 14));
            CodeTextArea.setEditable(true);
            CodeTextArea.setText("");
            JScrollPane scrollPane = new JScrollPane(CodeTextArea);
            MiddleMiddle.add(scrollPane,BorderLayout.CENTER);

            executeButton = new JButton("Execute");
            executeButton.addActionListener(this);
            LowerMiddle.add(executeButton, BorderLayout.SOUTH);

            middleJPanel.add(UpperMiddle, BorderLayout.NORTH);
            middleJPanel.add(MiddleMiddle, BorderLayout.CENTER);
            middleJPanel.add(LowerMiddle, BorderLayout.SOUTH);
            add(middleJPanel, BorderLayout.CENTER);           
    } // End layoutMiddle
    
    /**
     * Class JPanel containing Label, JTextArea and Exit Button
     */
    public void layoutBottom() {
            JPanel bottomJPanel = new JPanel();
            bottomJPanel.setLayout(new BorderLayout());
            JPanel UpperBottom = new JPanel();
            JPanel MiddleBottom = new JPanel();
            JPanel LowerBottom = new JPanel();
            
            OutputLabel= new JLabel("Output:");
            UpperBottom.add(OutputLabel, BorderLayout.NORTH);

            OutputTextArea = new JTextArea(7,75);
            OutputTextArea.setFont(new Font("Courier", Font.PLAIN, 14));
            OutputTextArea.setEditable(false);
            OutputTextArea.setText("");
            JScrollPane scrollPane = new JScrollPane(OutputTextArea);
            MiddleBottom.add(scrollPane,BorderLayout.CENTER);
            
            exitButton = new JButton("Exit");
            exitButton.addActionListener(this);
            LowerBottom.add(exitButton, BorderLayout.SOUTH);

            bottomJPanel.add(UpperBottom, BorderLayout.NORTH);
            bottomJPanel.add(MiddleBottom, BorderLayout.CENTER);
            bottomJPanel.add(LowerBottom, BorderLayout.SOUTH);
            add(bottomJPanel, BorderLayout.SOUTH);
    } // End layoutBottom
        
    /**
     * Process button clicks.
     * @param ae the ActionEvent
     */
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==selectButton){
                // Code to choose the source file
                JFileChooser chooser = new JFileChooser("/Users/jorgejaso/NetBeansProjects/LispInt/LispCode");
                //chooser.setFileFilter(".lisp");
                int returnVal = chooser.showOpenDialog(LispIntGUI.this);
                // if file chosen, display file contents
                if (returnVal == JFileChooser.APPROVE_OPTION){
                  FilePath = chooser.getSelectedFile().getPath();
                  // System.out.println(FilePath);
                  DisplayCode SourceCodeObject =new DisplayCode(FilePath);
                  String Code=SourceCodeObject.DisplaySource();
                  CodeTextArea.setText(Code);
                }
            } // End if selectButton
            
            
            if (ae.getSource()==executeButton){
                // Execute selected file
                try {
                    System.out.println("valor de FilePath en Executebutton: "+FilePath);
                    CharStream cs= new ANTLRFileStream(FilePath);
                    ListmanLexer lexer = new ListmanLexer (cs); // Modify for new grammar
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    ListmanParser parser = new ListmanParser(tokens); // Modify for new grammar
                    try {
                        parser.prog();
                    }catch(RecognitionException ex) {
                        Logger.getLogger(LispIntGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null, "File not found. \n", "Error Message", JOptionPane.ERROR_MESSAGE); 
                    System.out.println("File not found");
                    System.exit(0);
                }

                //Display Results in text field
                DisplayCode SourceCodeObject =new DisplayCode();
                String Results=SourceCodeObject.DisplayOutput();
                OutputTextArea.setText(Results);	   
            } // End if executeButton 

            if (ae.getSource()==exitButton)
            {	    	
                // Closing the application
                System.exit(0);		
            }
     	
    } // end actionPerformed
  
    
}
