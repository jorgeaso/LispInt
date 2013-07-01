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
        /** GUI Buttons */
        private JButton selectButton, executeButton, exitButton;
    	/** GUI JTextFields */
	private JTextField pathIn;

	/** Display of lisp code and output */
	private JTextArea displayFile, displayOutput;
        
        /** Name of input file */
	private final String SrcInFile = "/Users/jorgejaso/NetBeansProjects/LispInt/src/arith.lisp";    
	String top="";
	String middle="";
	String bottom="";
	String lispFile;
	
   public LispIntGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lisp Interpreter");
		setSize(700, 300);
                layoutTop();
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
				//System.out.println(classReport); // test
				System.out.println(top); // test
				System.out.println(middle); // test
				System.out.println(bottom); // test
				reader.close();
				//System.out.print(top+"\n"+middle+"\n"+bottom);
			}
			catch (IOException e) {
				System.out.println("File not found");
			}
		}		    		
		
	}

	/**
	 * adds labels, text fields and buttons to bottom of GUI
	 */
	public void layoutTop() {
		// instantiate panel for bottom of display
		JPanel topJPanel = new JPanel(new GridLayout(1, 3));
		// label, text field and button
		JLabel srcLabel = new JLabel("Enter Source File Path:");
		topJPanel.add(srcLabel);
		pathIn = new JTextField();
		topJPanel.add(pathIn);
		JPanel panel1 = new JPanel();
		selectButton = new JButton("Select");
		selectButton.addActionListener(this);
		panel1.add(selectButton);
		topJPanel.add(panel1);
                add(topJPanel, BorderLayout.NORTH);
	}

        /**
	 * adds button to bottom of GUI
	 */
	public void layoutBottom() {
		JPanel bottomJPanel = new JPanel();
                displayFile = new JTextArea();
                displayFile.setFont(new Font("Courier", Font.PLAIN, 14));
                add(displayFile, BorderLayout.NORTH);
                
                displayOutput = new JTextArea();
                displayOutput.setFont(new Font("Courier", Font.PLAIN, 14));
		add(displayOutput, BorderLayout.CENTER);
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
