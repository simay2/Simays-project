package project;

  import java.awt.BorderLayout;
  import java.awt.Container;
 import java.awt.event.ActionListener;
 import java.awt.Color;
import java.awt.Font;
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

import javax.swing.BorderFactory;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument.Content;
import java.awt.Component;


  public class FilmReview2part {


  	public static void main(String[] args) {
 		// TODO Auto-generated method stub
  	// main containers and Layouts
 		JFrame frame = new JFrame("Film Reviews");
 		frame.setBackground(Color.black);
 
  		JPanel mainPanel = new JPanel(); 
 		frame.getContentPane().add(mainPanel);
 		mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.X_AXIS));
 		mainPanel.setBackground(Color.WHITE);
 		
		JPanel leftPanel = new JPanel();
 		mainPanel.add(leftPanel);
 		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
 		leftPanel.setBackground(Color.WHITE);	 
 		
 		JPanel rightPanel = new JPanel();
 		mainPanel.add(rightPanel);
 		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
 		rightPanel.setBackground(Color.WHITE);
 		
 		JLabel titleLabel  = new JLabel("Film Review");
 		titleLabel.setBackground(Color.white);
 		titleLabel.setOpaque(true);
 		titleLabel.setForeground(Color.pink);
 		leftPanel.add( titleLabel, "push, align center" );
 		titleLabel.setFont(new Font("Copperplate", Font.BOLD, 26 ));

 		
  		JTextArea criticArea = new JTextArea(15,10);
 		 frame.setVisible(true);
 		criticArea.setEditable(false);
 		  criticArea.setLineWrap(true);
 		 criticArea.setEditable(false);
 		criticArea.setVisible(true);
 		
 		JScrollPane scroll = new JScrollPane(criticArea);
 		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        leftPanel.add(scroll);
        leftPanel.setVisible(true);
 		
        
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
 		currentDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
 		
 		rightPanel.add(currentDateLabel);
 		

 
  		JTextField filmnamertext1 = new JTextField();
 		rightPanel.add(filmnamertext1);
 		JTextField criticrtext1 = new JTextField();
 		rightPanel.add(criticrtext1);
  		  		    
  		JPanel RatePanel = new JPanel();
  		RatePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
  		RatePanel.setBackground(Color.WHITE);
 		rightPanel.add(RatePanel);
 		RatePanel.setLayout((LayoutManager) new BoxLayout(RatePanel, BoxLayout.X_AXIS));
  		  		 ButtonGroup group = new ButtonGroup();
  		
  
  		  		
  		
  		  		JRadioButton firstButton = new JRadioButton("*");
  		  	RatePanel.add(firstButton);
  		  		firstButton.setMnemonic(KeyEvent.VK_B);
  		  		firstButton.setActionCommand("*");
  		  		firstButton.setSelected(false);
  		  		firstButton.setVisible(true);
  		  		group.add(firstButton);
  		
  		
  		 
  		    JRadioButton secondButton = new JRadioButton("**");
  		    RatePanel.add(secondButton);
  		    secondButton.setMnemonic(KeyEvent.VK_RIGHT);
  		    secondButton.setActionCommand("**");
  		    secondButton.setSelected(false);
  		    secondButton.setVisible(true);
  		    group.add(secondButton);
  		
  		
  		JRadioButton forthButton = new JRadioButton("****");
  		RatePanel.add(forthButton);
  		forthButton.setMnemonic(KeyEvent.VK_B);
  		forthButton.setActionCommand("****");
  		forthButton.setSelected(false);
  		forthButton.setVisible(true);
  		group.add(forthButton);
  		
  		
  		JRadioButton thirtButton = new JRadioButton("***");
  		RatePanel.add(thirtButton);
  		thirtButton.setMnemonic(KeyEvent.VK_B);
  		thirtButton.setActionCommand("***");
  		thirtButton.setSelected(false);
  		thirtButton.setVisible(true);
  		group.add(thirtButton);
  		
  		
  		JRadioButton fifthButton = new JRadioButton("*****");
  		RatePanel.add(fifthButton);
  		fifthButton.setMnemonic(KeyEvent.VK_B);
  		fifthButton.setActionCommand("*****");
  		fifthButton.setSelected(false);
  		fifthButton.setVisible(true);
  		group.add(fifthButton);

  		JButton submitButton = new JButton("Submit");
  		submitButton.setHorizontalAlignment(SwingConstants.LEADING);
  		submitButton.setForeground(Color.pink);
  		rightPanel.add( submitButton, "push, align center" );
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
  				 				+ group.getSelection().getActionCommand() + "\n" ;
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
  						e1.printStackTrace();
  					}
  				}
  				criticArea.setText(text);

    			}
  		});

  		rightPanel.add(submitButton);
  		  		      		      	
  		
  		JLabel inspirationLabel = new JLabel("Who doesn't hate to watch a bad move twice? "
 				+ "If you are bored,too. This is solution!");
  		inspirationLabel.setBackground(Color.white);
  		inspirationLabel.setOpaque(true);
  		inspirationLabel.setForeground(Color.pink);
 		rightPanel.add( inspirationLabel, "align center" );
 		inspirationLabel.setFont(new Font("Copperplate", Font.BOLD, 14 ));
    		
 		rightPanel.add(inspirationLabel);
   

  		frame.pack();
 		frame.setVisible(true);
 	
 	}

  	}

 

