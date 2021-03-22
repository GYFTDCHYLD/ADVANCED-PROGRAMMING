package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private Socket connectionSocket;
	private String action = "";
	
	
	public Client() {
		this.createConnection();
		this.configureStream();
	}

	private void createConnection() {
		
		try {
			//Create a socket to connect to the server
			connectionSocket = new Socket("127.0.0.1", 8888);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void configureStream() {
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

	private void closeConnection() {
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendAction(String action) { 
		this.action = action;
		try {
			objOs.writeObject(action);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendStudent(Student stuObj) {
		try {
			objOs.writeObject(stuObj);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendStudent(String studentID) {
		try {
			objOs.writeObject(studentID);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void recieveResponse() {
		try {
			if(action.equalsIgnoreCase("Add Student")) {
				boolean flag = (boolean) objIs.readObject();
				if(flag) {
					JOptionPane.showMessageDialog(null, "Record added Successfully  " , "Add Record Status", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(action.equalsIgnoreCase("Find Student")) {
				Student student = new Student();
				student = (Student) objIs.readObject();
				if(student == null) {
					JOptionPane.showMessageDialog(null, "Record could not be found ", "Find Record Status", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}catch(ClassCastException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
