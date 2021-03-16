package form;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Aplabt1.Student;

public class Form  extends JFrame implements ActionListener{
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
	private JPanel radioButtonPanel;
	private JPanel buttonPanel;
	Student Student = new Student();
	
	//private static final long serialVersionUID= 1L;
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	
	
	private JButton button;

	public Form() {
		setTitle("Student Data Form");
		
		rbtnMale = new JRadioButton("Male");
		rbtnMale.setBounds(100,50,100,30);
		rbtnFemale = new JRadioButton("Female");
		rbtnFemale.setBounds(100,100,100,30);
		//Create a Button Group for the Radio Buttons
		ButtonGroup bg = new ButtonGroup();
		//Add the radio buttons to the button group
		bg.add(rbtnMale);
		bg.add(rbtnFemale);;
		//Add the action listener to the button ;
		//button.addActionListener( this);
		
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
		button.setSize(200, 300); 
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		button.addActionListener(this);

		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		idPanel.setSize(450,30);
		idPanel.add(idLabel);
		idPanel.add(idTextField);
		this.add(idPanel);
		
		namePanel.setSize(450,30);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		this.add(namePanel);
		
		emailPanel.setSize(450,30); 
		emailPanel.add(emailLabel);
		emailPanel.add(emailTextField);
		this.add(emailPanel);
		
		dobPanel.setSize(450,30);
		dobPanel.add(dobLabel);
		dobPanel.add(dobTextField);
		this.add(dobPanel);
		
		radioButtonPanel.setSize(450,30);
		radioButtonPanel.add(rbtnMale);
		radioButtonPanel.add(rbtnFemale);
		this.add(radioButtonPanel);
		
		buttonPanel.setSize(500,30);
		buttonPanel.add(button);
		this.add(buttonPanel);
		
		
		this.setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {/*
			if(rbtnMale.isSelected()) {
				JOptionPane.showMessageDialog(button, this, "Male selected", 0);
			}
			if(rbtnFemale.isSelected()) {
				JOptionPane.showMessageDialog(button, this, "Female selected", 0);
			}*/
				try {
					Student = Student.readFromFile(idTextField.getText().trim());
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nameTextField.setText(Student.getName());
				emailTextField.setText(Student.getEmail());
				dobTextField.setText(Student.getDOB().toString());
		
			/**/
	}
}