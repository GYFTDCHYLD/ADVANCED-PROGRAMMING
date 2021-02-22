package FlowLayoutExample.domain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FlowLayoutExample {
	private JFrame frame;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameTextField;
	private JTextField passwordField;
	private JButton button;
	private JPanel namePanel;
	private JPanel passwordPanel;
	private JPanel buttonPanel;
	
	public FlowLayoutExample() {
		frame = new JFrame("FlowLayout Example");
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel();
		usernameTextField = new JTextField(20);
		passwordField = new JTextField(20);
		button = new JButton("Sign In");
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Sign in button clicked..", "Flowlayout Example", JOptionPane.INFORMATION_MESSAGE);	 
			}
		});
		
		button.setSize(new Dimension(450,30)); 
		namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		layoutComponents();
	}
	
	private void layoutComponents() {
		frame.setLayout(new FlowLayout(FlowLayout.LEADING));
		// set up the first panel
		namePanel.setSize(new Dimension(450,30));
		namePanel.add(usernameLabel);
		namePanel.add(usernameTextField);
		frame.add(namePanel);// add the panel to the frame
		//set up the  second panel
		passwordPanel.setSize(new Dimension(450,30));
		passwordLabel.setText("Password: "); 
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		frame.add(passwordPanel);// add the panel to the frame
		
		buttonPanel.setSize(new Dimension(450,30));
		buttonPanel.add(button); // add the button to the panel
		frame .add(buttonPanel); // add the panel to the frame
		
		frame.setSize(new Dimension(420,150));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
	}
}
