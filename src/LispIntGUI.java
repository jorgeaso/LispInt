import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

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
    /** Name of input file */
    //private final String SrcInFile = "/Users/jorgejaso/NetBeansProjects/LispInt/src/arith.lisp";
 
    String lispFile;
	
    public LispIntGUI(String FN) {
            String FileName = FN;
            System.out.println("Este es FileName desde GUI: "+FileName);
            SourceCode SourceCodeObject =new SourceCode(FileName);
            String Code=SourceCodeObject.DisplaySource();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Lisp Interpreter");
            setSize(700, 400);
            layoutTop();
            layoutMiddle(Code);
            layoutBottom();	
    } 
                
    // JPanel containing Select Button
    public void layoutTop() {
            JPanel topJPanel = new JPanel();
            topJPanel.setLayout(new BorderLayout());
            JPanel MiddleTop = new JPanel();
            selectButton= new JButton("Select File");
            MiddleTop.add(selectButton);
            topJPanel.add(MiddleTop, BorderLayout.CENTER);
            add(topJPanel, BorderLayout.NORTH);
    } // End layoutTop
    
      // JPanel containing Label, JTextArea and Execute Button
    public void layoutMiddle(String Code) {
            JPanel middleJPanel = new JPanel();
            middleJPanel.setLayout(new BorderLayout());
            JPanel UpperMiddle = new JPanel();
            JPanel MiddleMiddle = new JPanel();
            JPanel LowerMiddle = new JPanel();
            
            SourceLabel= new JLabel("Source Lisp Code:");
            UpperMiddle.add(SourceLabel, BorderLayout.NORTH);
            
            CodeTextArea = new JTextArea(7,75);
            CodeTextArea.setFont(new Font("Courier", Font.PLAIN, 14));
            CodeTextArea.setEditable(false);
            CodeTextArea.setText(Code);
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
     * JPanel containing Label, JTextArea and Exit Button
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
		if(ae.getSource()==selectButton)
                {
                    // Code to choose the source file
                    FileChooser choose= new FileChooser();
                    // choose.setVisible(true);
                    String chosen=choose.ChooseFile();
                    System.out.println("Seleccionaste: "+chosen);
                }
            
            
                if (ae.getSource()==executeButton)
                {
                    // Execute selected file
                    SourceCode SourceCodeObject =new SourceCode();
                    String Results=SourceCodeObject.DisplayOutput();
                    OutputTextArea.setText(Results);	
                } 
            
                if (ae.getSource()==exitButton)
                {	    	
                    // Closing the application
                    System.exit(0);		
                }
     	
    } // end actionPerformed
  
    
}
