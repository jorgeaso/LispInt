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
    /** GUI JTextFields */
    private JTextField sourceInbox;
    /** GUI TextArea to display source lisp code and output */
    private JTextArea displayCode, displayOutput;
    /** GUI Label output */
    private JLabel OutputLabel;
    /** Name of input file */
    private final String SrcInFile = "/Users/jorgejaso/NetBeansProjects/LispInt/src/arith.lisp";    
    String lispFile;
	
    public LispIntGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lisp Interpreter");
		setSize(700, 300);
                layoutTop();
                layoutMiddle();
                layoutBottom();	
    }
        
    // Read Source File and Display
    public void DisplaySource() {
		{
			try {
				FileReader reader = new FileReader("/Users/jorgejaso/NetBeansProjects/LispInt/src/arith.lisp");
				Scanner in = new Scanner(reader);
				while (in.hasNextLine()) { 
					String line = in.nextLine();
					System.out.println(line);
				}
				reader.close();
			}
			catch (IOException e) {
				System.out.println("File not found");
			}
		}		    		
		
	}

    /**
    * JPanel containing labels and text field to specify source path and Select Button
    **/
    public void layoutTop() {
            // instantiate panel for bottom of display
            JPanel topJPanel = new JPanel(new GridLayout(1, 3));
            topJPanel.setBackground(Color.yellow);
            // label to specify source path
            JLabel srcLabel = new JLabel("Enter Source File Path:");
            topJPanel.add(srcLabel);
            // textfield to enter source path
            sourceInbox = new JTextField();
            topJPanel.add(sourceInbox);
            //JPanel panel1 = new JPanel();
            // button to select file
            selectButton = new JButton("Select");
            selectButton.addActionListener(this);
            //panel1.add(selectButton);
            topJPanel.add(selectButton);
            //topJPanel.add(panel1);
            add(topJPanel, BorderLayout.NORTH);
    }
        
    // JPanel containing JTextArea and Execute Button
    public void layoutMiddle() {
            JPanel middleJPanel = new JPanel(new GridLayout(2, 1));
            middleJPanel.setBackground(Color.red);
            displayCode = new JTextArea();
            displayCode.setFont(new Font("Courier", Font.PLAIN, 14));
            middleJPanel.add(displayCode);

            executeButton = new JButton("Execute");
            executeButton.setEnabled(false);
            executeButton.addActionListener(this);
            middleJPanel.add(executeButton);
            
            add(middleJPanel, BorderLayout.CENTER);
    }
        

    /**
     * JPanel containing Label, JTextArea and Exit Button
     */
    public void layoutBottom() {
            JPanel bottomJPanel = new JPanel(new GridLayout(3, 1));
            bottomJPanel.setBackground(Color.blue);
            displayOutput = new JTextArea();
            displayOutput.setFont(new Font("Courier", Font.PLAIN, 14));
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
		if (ae.getSource()==selectButton)
                {	    	
		// Display selected lisp source file
		System.exit(0);		
                }
	    
	   
	    	
	}
    
    
    
}
