package project;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FilmReview2part {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Film Reviews");
		frame.setSize(800, 600);
		frame.setBackground(Color.black);
		
		
		JPanel mainPanel = new JPanel(); 
		frame.add(mainPanel);
		mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
	
		
		
		JPanel rightPanel = new JPanel();
		mainPanel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		JPanel RatePanel = new JPanel(); 
		mainPanel.add(RatePanel);
		RatePanel.setLayout((LayoutManager) new BoxLayout(RatePanel, BoxLayout.X_AXIS));
		
		
	
		JTextArea criticArea = new JTextArea();
		 frame.setVisible(true);
		criticArea.setBounds(420, 200, 400, 200);
		criticArea.setEditable(false);
		leftPanel.add(criticArea);
		File myObj = new File("filename.txt");
 		String text = "";
 		try {
 			Scanner myReader = new Scanner(myObj);
 			while (myReader.hasNextLine()) {
 				text += myReader.nextLine() + "\n";
 			}
 			myReader.close();
 		} catch (FileNotFoundException e) {
 			try {
 				myObj.createNewFile();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 		}
 		criticArea.setText(text);

	
		SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		rightPanel.add(currentDateLabel);
		
		
		JTextField filmnamertext1 = new JTextField();
		rightPanel.add(filmnamertext1);
		JTextField criticrtext1 = new JTextField();
		rightPanel.add(criticrtext1);
		
		
		rightPanel.add(RatePanel);
		
		JRadioButton firstButton = new JRadioButton("*");
		 firstButton.setMnemonic(KeyEvent.VK_B);
		    firstButton.setActionCommand("*");
		    firstButton.setSelected(false);
		    firstButton.setVisible(true);
		    RatePanel.add(firstButton);
		    
		    
		    JRadioButton secondButton = new JRadioButton("**");
		    secondButton.setMnemonic(KeyEvent.VK_B);
		    secondButton.setActionCommand("**");
		    secondButton.setSelected(false);
		    secondButton.setVisible(true);
		    RatePanel.add(secondButton);
		    
		    JRadioButton thirtButton = new JRadioButton("***");
		    thirtButton.setMnemonic(KeyEvent.VK_B);
		    thirtButton.setActionCommand("***");
		    thirtButton.setSelected(false);
		    thirtButton.setVisible(true);
		    RatePanel.add(thirtButton);
		    
		    JRadioButton forthButton = new JRadioButton("****");
		    forthButton.setMnemonic(KeyEvent.VK_B);
		    forthButton.setActionCommand("****");
		    forthButton.setSelected(false);
		    forthButton.setVisible(true);
		    RatePanel.add(forthButton);
		    
		    JRadioButton fifthButton = new JRadioButton("*****");
		    fifthButton.setMnemonic(KeyEvent.VK_B);
		    fifthButton.setActionCommand("*****");
		    fifthButton.setSelected(false);
		    fifthButton.setVisible(true);
		    RatePanel.add(fifthButton);
		    
		    ButtonGroup group = new ButtonGroup();
		    group.add(firstButton);
		    group.add(secondButton);
		    group.add(thirtButton);
		    group.add(forthButton);
		    group.add(fifthButton);
		    
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String filmname1 = filmnamertext1.getText();
 				String critic1 = criticrtext1.getText();
 				
 				if (critic1.isEmpty() && filmname1.isEmpty() ) {
 					return;
 				
		}
 				String text = 
 						currentDateLabel.getText() +"\n"
 				 				+ filmname1 + "\n"
 				 				+ critic1 + "\n" 
 				 				+ group.getSelection().getActionCommand();
 				try {
 					FileWriter myWriter = new FileWriter("filename.txt",true);
 					myWriter.write(text);
 					myWriter.close();

  				} catch (IOException e) {
 					System.out.println("An error occurred.");
 					e.printStackTrace();
 				}

  				File myObj = new File("filename.txt");
 				text = "";
 				try {
 					Scanner myReader = new Scanner(myObj);
 					while (myReader.hasNextLine()) {
 						text += myReader.nextLine() + "\n";
 					}
 					myReader.close();
 				} catch (FileNotFoundException e) {
 					try {
 						myObj.createNewFile();
 					} catch (IOException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
 				}
 				criticArea.setText(text);

  			}
 		});
		
		rightPanel.add(submitButton);

  		JLabel inspirationLabel = new JLabel("Who doesn't hate to watch a bad move twice? "
				+ "If you are bored,too. This is solution");
		rightPanel.add(inspirationLabel);

		frame.pack();
		// Setting the frame visibility to true
		frame.setVisible(true);
	}
		
	}


