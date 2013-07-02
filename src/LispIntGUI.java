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
    private JButton executeButton, exitButton;
    /** GUI TextArea to display source lisp code and output */
    private JTextArea displayCode, displayOutput;
    /** GUI Label output */
    private JLabel SourceLabel, EmptyLabel, OutputLabel;
    /** Name of input file */
    //private final String SrcInFile = "/Users/jorgejaso/NetBeansProjects/LispInt/src/arith.lisp";    
    String lispFile;
	
    public LispIntGUI(String SF) {
		String SourceFile = SF;
                SourceCode SourceCodeObject =new SourceCode(SourceFile);
                String Code=SourceCodeObject.DisplaySource();
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lisp Interpreter");
		setSize(700, 400);
                layoutTop(Code);
                layoutMiddle();
                layoutBottom();	
    }
                
    // JPanel containing JTextArea and Execute Button
    public void layoutTop(String Code) {
            JPanel topJPanel = new JPanel(new GridLayout(3, 1));
            //topJPanel.setBackground(Color.red);
            SourceLabel= new JLabel("Source Lisp Code:");
            topJPanel.add(SourceLabel);
            displayCode = new JTextArea();
            displayCode.setFont(new Font("Courier", Font.PLAIN, 14));
            displayCode.setEditable(false);
            displayCode.setText(Code);
            topJPanel.add(displayCode);

            executeButton = new JButton("Execute");
            executeButton.addActionListener(this);
            topJPanel.add(executeButton);
            
            add(topJPanel, BorderLayout.NORTH);
    }
    
      // JPanel containing JTextArea and Execute Button
    public void layoutMiddle() {
            JPanel middleJPanel = new JPanel((new GridLayout(1, 1)));
            middleJPanel.setSize(0, 0);
            //middleJPanel.setBackground(Color.yellow);
            EmptyLabel= new JLabel("");
            middleJPanel.add(EmptyLabel);
            add(middleJPanel, BorderLayout.CENTER);
    }
    
    
    /**
     * JPanel containing Label, JTextArea and Exit Button
     */
    public void layoutBottom() {
            JPanel bottomJPanel = new JPanel((new GridLayout(3, 1)));
            //bottomJPanel.setBackground(Color.blue);
            OutputLabel= new JLabel("Output:");
            bottomJPanel.add(OutputLabel);
            displayOutput = new JTextArea();
            displayOutput.setFont(new Font("Courier", Font.PLAIN, 14));
            displayOutput.setEditable(false);
            bottomJPanel.add(displayOutput);
            //add(displayOutput, BorderLayout.NORTH);
            exitButton = new JButton("Exit");
            exitButton.addActionListener(this);
            bottomJPanel.add(exitButton);

            add(bottomJPanel, BorderLayout.SOUTH);
    }
        
    	/**
	 * Process button clicks.
	 * @param ae the ActionEvent
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==exitButton)
                {	    	
                    // Closing the application
                    System.exit(0);		
                }
		
                if (ae.getSource()==executeButton)
                {
                    // Execute selected file
                    	
                } 
	   
	    	
	}
    
    
    
}
