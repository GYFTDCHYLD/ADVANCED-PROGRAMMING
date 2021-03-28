package driver;
import java.sql.*;

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/";
		Connection myConn = null;
		try {
			//1. Get Connection to localhost/xampp server
			myConn = DriverManager.getConnection(url, "root", "");
		
			
			if(myConn != null) {
				JOptionPane.showMessageDialog(null, "Connected to Local Server", "JDBC Connection Status",JOptionPane.INFORMATION_MESSAGE );
			}
			//2. Create a statement
			
			
			//3. Execute SQL Query
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
