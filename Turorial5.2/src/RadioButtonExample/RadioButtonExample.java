package RadioButtonExample;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class RadioButtonExample extends JFrame implements ActionListener
{
	private static final long serialVersionUID= 1L;
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	private JButton button;
	
	public RadioButtonExample()
	{
		rbtnMale = new JRadioButton("Male");
		rbtnMale.setBounds(100,50,100,30);
		rbtnFemale = new JRadioButton("Female");
		rbtnFemale.setBounds(100,100,100,30);
		//Create a Button Group for the Radio Buttons
		ButtonGroup bg = new ButtonGroup();
		//Add the radio buttons to the button group
		bg.add(rbtnMale);
		bg.add(rbtnFemale);
		button = new JButton("click");
		button.setBounds(100,150,80,30);
		//Add the action listener to the button ;
		button.addActionListener( this);
		
		//Add all components to the frame
		this.add(rbtnMale);
		this.add(rbtnFemale);
		this.add(button);
		
		this.setSize(300,300);
		setLayout(null);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(rbtnMale.isSelected()) {
			JOptionPane.showMessageDialog(this, "Male selected");
		}else if(rbtnFemale.isSelected()) {
			JOptionPane.showMessageDialog(this, "Female selected");
		}
	}
	
	
	public static void main(String[] args) {
		new RadioButtonExample();

	}

}