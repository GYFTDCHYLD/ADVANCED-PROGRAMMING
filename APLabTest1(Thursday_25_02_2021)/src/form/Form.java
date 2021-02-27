package form;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Aplabt1.Student;

public class Form {
	JFrame frame;
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel dobLabel;
	private JTextField dobTextField;
	private JPanel idPanel;
	private JPanel namePanel;
	private JPanel emailPanel;
	private JPanel dobPanel;
	private JPanel buttonPanel;
	
	private JButton button;

	public Form() {
		frame = new JFrame("Student Data Form");
		
		JLabel idLabel = new JLabel("ID No");
		JTextField idTextField = new JTextField(10);
		idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel nameLabel = new JLabel("Name");
		JTextField nameTextField = new JTextField(20);
		nameTextField.setEditable(false);// disable the field
		namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel emailLabel = new JLabel("Email");
		JTextField emailTextField = new JTextField(20);
		emailTextField.setEditable(false);// disable the field
		emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel dobLabel = new JLabel("D.O.B");
		JTextField dobTextField = new JTextField(20);
		dobTextField.setEditable(false);// disable the field
		dobPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		button = new JButton("Search");
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Student Student = new Student();
					Student = Student.readFromFile(Integer.valueOf(idTextField.getText()));
					nameTextField.setText(Student.getName());
					emailTextField.setText(Student.getEmail());
					dobTextField.setText(Student.getDOB().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		idPanel.setSize(new Dimension(450,30));
		idPanel.add(idLabel);
		idPanel.add(idTextField);
		frame.add(idPanel);
		
		namePanel.setSize(new Dimension(450,30));
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		frame.add(namePanel);
		
		emailPanel.setSize(new Dimension(450,30)); 
		emailPanel.add(emailLabel);
		emailPanel.add(emailTextField);
		frame.add(emailPanel);
		
		dobPanel.setSize(new Dimension(450,30));
		dobPanel.add(dobLabel);
		dobPanel.add(dobTextField);
		frame.add(dobPanel);
		
		buttonPanel.setSize(new Dimension(450,30));
		buttonPanel.add(button);
		frame.add(buttonPanel);
		
		
		frame.setSize(new Dimension(400,250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	
	

}
