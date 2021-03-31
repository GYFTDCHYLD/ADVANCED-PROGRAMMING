package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MultiThreadClient {

	private Socket connectionSocket;
	private  ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	
	
	public MultiThreadClient() {
		this.createConnection();
		this.configureStreams();
	}
	
	private void createConnection() {
		try {
			connectionSocket = new Socket("127.0.0.1",8000);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendRadius(Double radius) {
		try {
			objOs.writeObject(radius);
			System.out.println("Radius sent is "+radius);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void receiveArea() {
		Double area = null; 
		try {
			area = (Double) objIs.readObject();
			if (area == null) {
				System.out.println("No area received");
			}
			else {
				System.out.println("Area is "+ area);
			}
		}
		catch (ClassCastException ex) 
		{
			ex.printStackTrace();
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
