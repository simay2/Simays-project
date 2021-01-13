package project;

import java.awt.LayoutManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FilmReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Film Reviews");
		frame.setSize(800, 600);
		
		JPanel mainPanel = new JPanel(); 
		frame.add(mainPanel);
		mainPanel.setLayout((LayoutManager) new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		JPanel rightPanel = new JPanel();
		mainPanel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		JTextArea criticArea = new JTextArea();
		criticArea.setBounds(420, 200, 400, 200);
		criticArea.setEditable(false);
		criticArea.setText("Here are the critics from movies you've watched before...");
		leftPanel.add(criticArea);
		
		SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		rightPanel.add(currentDateLabel);
		
		JTextField criticrtext1 = new JTextField();
		rightPanel.add(criticrtext1);
		
		JButton submitButton = new JButton("Submit");
		rightPanel.add(submitButton);

		JLabel inspirationLabel = new JLabel("Who doesn't hate to watch a bad move twice? "
				+ "If you are bored,too. This is solution");
		rightPanel.add(inspirationLabel);

		frame.pack();
		// Setting the frame visibility to true
		frame.setVisible(true);
	}

}
