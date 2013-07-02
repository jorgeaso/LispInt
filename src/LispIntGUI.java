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
    private JTextArea CodeTextArea, OutputTextArea;
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
            JPanel topJPanel = new JPanel();
            topJPanel.setLayout(new BorderLayout());
            JPanel UpperTop = new JPanel();
            JPanel MiddleTop = new JPanel();
            JPanel LowerTop = new JPanel();
            //topJPanel.setBackground(Color.red);
            SourceLabel= new JLabel("Source Lisp Code:");
            UpperTop.add(SourceLabel, BorderLayout.NORTH);
            //UpperTop.add(SourceLabel);
            //topJPanel.add(SourceLabel);
            
            CodeTextArea = new JTextArea(7,75);
            CodeTextArea.setFont(new Font("Courier", Font.PLAIN, 14));
            CodeTextArea.setEditable(false);
            CodeTextArea.setText(Code);
            JScrollPane scrollPane = new JScrollPane(CodeTextArea);
            MiddleTop.add(scrollPane,BorderLayout.CENTER);
            //topJPanel.add(scrollPane);

            executeButton = new JButton("Execute");
            executeButton.addActionListener(this);
            //topJPanel.add(executeButton);
            LowerTop.add(executeButton, BorderLayout.SOUTH);

            topJPanel.add(UpperTop, BorderLayout.NORTH);
            topJPanel.add(MiddleTop, BorderLayout.CENTER);
            topJPanel.add(LowerTop, BorderLayout.SOUTH);
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
            JPanel bottomJPanel = new JPanel();
            bottomJPanel.setLayout(new BorderLayout());
            JPanel UpperBottom = new JPanel();
            JPanel MiddleBottom = new JPanel();
            JPanel LowerBottom = new JPanel();
            //bottomJPanel.setBackground(Color.blue);
            OutputLabel= new JLabel("Output:");
            UpperBottom.add(OutputLabel, BorderLayout.NORTH);
            //bottomJPanel.add(OutputLabel);
            OutputTextArea = new JTextArea(7,75);
            OutputTextArea.setFont(new Font("Courier", Font.PLAIN, 14));
            OutputTextArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(OutputTextArea);
            MiddleBottom.add(scrollPane,BorderLayout.CENTER);
            //bottomJPanel.add(scrollPane);
            //add(displayOutput, BorderLayout.NORTH);
            exitButton = new JButton("Exit");
            exitButton.addActionListener(this);
            LowerBottom.add(exitButton, BorderLayout.SOUTH);
            //bottomJPanel.add(exitButton);

            bottomJPanel.add(UpperBottom, BorderLayout.NORTH);
            bottomJPanel.add(MiddleBottom, BorderLayout.CENTER);
            bottomJPanel.add(LowerBottom, BorderLayout.SOUTH);
            add(bottomJPanel, BorderLayout.SOUTH);
            //add(bottomJPanel, BorderLayout.SOUTH);
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
