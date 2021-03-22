package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import client.Student;

public class Server {
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private static Connection dBConn = null;
	private Statement stmt;
	private ResultSet result = null;
	
	public Server() {
		this.createConnection();
		this.waitForRequests();
	}

	private void createConnection() {
		try {
			/*  Crate new instance of the ServerScoket listening on port 8888          */
			serverSocket = new ServerSocket(8888);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	private void configureStreams() {
		try {
			/*                  
			 Instantiate the output stream, using the getOutputStream method
			 of the Socket object as argument to the constructor
			 */
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
			/*                  
			 Instantiate the input stream, using the getInputStream method
			 of the Socket object as argument to the constructor
			 */
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static Connection getDatabaseConnection() {
		if(dBConn == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/dblab";
				dBConn = DriverManager.getConnection(url, "root", "");
				JOptionPane.showMessageDialog(null, "DB Connection Established  " , "CONNECTION STATUS", JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Could not connect to database \n" + ex, "Connection Failure", JOptionPane.ERROR_MESSAGE);
			}
		}
		return dBConn;
	}

	private void closeConnection() {
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void addStudentToFile(Student student) {
		String sql = "INSERT INTO dblab. `students` (id, studentID, firstName, lastName, email)"
				   + "VALUES (" + null + ", '" + student.getStudentID() + "', '" + student.getFirstName() + "', '" + student.getLastName() + "', '" + student.getEmail() + "');";
		try {
			stmt = dBConn.createStatement();
			if((stmt.executeUpdate(sql)) == 1)
				objOs.writeObject(true);// Return true to client if successful
			else
				objOs.writeObject(false);
		}catch(IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// Ideally you want to save errors to a log file
			e.printStackTrace();
		}
	}
	
	private Student findStudentById(String studentID) {
		Student stuObj = new Student();
		String query = "SELECT * FROM dblab.students WHERE studentID = " + studentID;
		try {
			stmt = dBConn.createStatement();
			result = stmt.executeQuery(query);
			if(result.next()) {
				stuObj.setStudentID(result.getString(2));
				stuObj.setFirstName(result.getString(3));
				stuObj.setLastName(result.getString(4));
				stuObj.setEmail(result.getString(5));
			}
		} catch (SQLException e) {
			// Ideally you want to save errors to a log file
			e.printStackTrace();
		}
		return stuObj;
	}
	
	private void waitForRequests() {
		String action = "";
		getDatabaseConnection();
		Student stuObj = null;
		try {
			while(true) {
				connectionSocket = serverSocket.accept();
				this.configureStreams();
				try {
					action = (String) objIs.readObject();
					
					if(action.equalsIgnoreCase("Add Student")) {
						stuObj = (Student) objIs.readObject();
						addStudentToFile(stuObj);
						objOs.writeObject(true); 
					}else if(action.equalsIgnoreCase("Find Student")) {
						String studentID = (String) objIs.readObject();
						// Call method to find student based on the id number
						
						stuObj = findStudentById(studentID);
						objOs.writeObject(stuObj);
					}
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}catch(ClassCastException e) {
					e.printStackTrace();
				}
				this.closeConnection();
			}
		}catch(EOFException e) {
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
