package ComboBoxExample.domain;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxExample {
	private JFrame frame;
	
	public ComboBoxExample() {
		frame = new JFrame("ComboBox Example");
		//Create a String array of comboBox list items
		String countries[] = {"India", "Jamaica", "U.S.A", "England", "France"};
		JComboBox<String> comboBox = new JComboBox<>(countries);
		// Set one of the options (Jamaica) as selected
		comboBox.setSelectedIndex(1);
		//Indicate where to position the component of the frame
		comboBox.setBounds(100, 50, 0150, 20);
		//Add the ComboBox to the frame
		frame.add(comboBox);
		frame.setLayout(null);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
	
	public static void main(String[] arg) {
		new ComboBoxExample();
	}

}
