//Craig Reid
//1806394
package form;

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

import Labtest1_2_2021.Address;
import Labtest1_2_2021.Employee;
import driver.Driver;


public class Form implements ActionListener{
	private JFrame frame;
	
	private JLabel idLabel;
	private JTextField idTextField;
	private JPanel idPanel;
	
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JPanel namePanel;
	
	private JLabel streetLabel;
	private JTextField streetTextField; 
	private JPanel streetPanel;
	
	private JLabel parishLabel; 
	private JTextField parishTextField; 
	private JPanel parishPanel;
	
	private JButton button;
	private JPanel buttonPanel;


	public Form() {
		frame = new JFrame("Employee Data Form");
		idLabel = new JLabel("ID No.");
		idTextField = new JTextField(10);
		idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		nameLabel = new JLabel("Name");
		nameTextField = new JTextField(20);
		namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		streetLabel = new JLabel("Street");
		streetTextField = new JTextField(20);
		streetPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		parishLabel = new JLabel("Parish");
		parishTextField= new JTextField(20);
		parishPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		button = new JButton("Submit");
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		Init();
	}
	
	
	public void Init() {
		frame.setLayout(new FlowLayout(FlowLayout.LEADING));
		idPanel.setSize(450,30);
		idPanel.add(idLabel);
		idPanel.add(idTextField);
		frame.add(idPanel);
		
		namePanel.setSize(450,30);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		frame.add(namePanel);
		
		streetPanel.setSize(450,30); 
		streetPanel.add(streetLabel);
		streetPanel.add(streetTextField);
		frame.add(streetPanel);
		
		parishPanel.setSize(450,30);
		parishPanel.add(parishLabel);
		parishPanel.add(parishTextField);
		frame.add(parishPanel);
		
		buttonPanel.setSize(500,30);
		buttonPanel.add(button);
		frame.add(buttonPanel);
		
		
		button.addActionListener(this);
		
		frame.setSize(400,300);
		frame.setVisible(true);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Employee employee = new Employee(idTextField.getText(), nameTextField.getText(), new Address(streetTextField.getText(), parishTextField.getText()));
		
		Driver.getEmployeeList().add(employee);// get the employee list from the driver class and add the object created above from the form
		try {
			employee.writeToFile(Driver.getEmployeeList());
		} catch (FileNotFoundException err) {
			System.err.println(" Employee class could not be found!!");
		} catch (IOException err) {
			System.err.println(" IO Exception caught!!");
		} catch (Exception err) {
			System.err.println(" Unidentified Exception caught!!");
		}
		idTextField.setText("");// clear textfleld
		nameTextField.setText("");
		streetTextField.setText("");
		parishTextField.setText("");
		
	}
}