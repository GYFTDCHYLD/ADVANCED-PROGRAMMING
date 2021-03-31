package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class MultiThreadServer {

	ServerSocket serverSocket;
	Socket connectionSocket;
	Calendar date;
	int clientCount;
	
	public MultiThreadServer() {
		
		try {
			this.serverSocket = new ServerSocket(8000);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		this.date = Calendar.getInstance();
		this.clientCount = 0;
		
		System.out.println("Server has started at "+ date.getTime());	

		while(true) {
			try {
				connectionSocket = serverSocket.accept();
				date = Calendar.getInstance();
				clientCount+= 1;
				System.out.println("Starting a thread for a client at "+ date.getTime()+"\nClient Count: "+clientCount);
				ClientHandler clientHandler = new ClientHandler(connectionSocket);
				Thread thread = new Thread((Runnable) clientHandler);
				thread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public class ClientHandler implements Runnable{

		Socket clientHandlerSocket;
		ObjectOutputStream objOs;
		ObjectInputStream objIs;

		public ClientHandler (Socket socket) {
			this.clientHandlerSocket = socket;
			try {
				this.objOs = new ObjectOutputStream(clientHandlerSocket.getOutputStream());
				this.objIs = new ObjectInputStream(clientHandlerSocket.getInputStream());
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Double radius = null;
					Double area = null;
					radius = (Double) objIs.readObject();
					System.out.println(radius);
					System.out.println("Radius received is "+radius);
					area = 3.14 * (radius * radius);
					objOs.writeObject((Double) area);
				}
				catch(NullPointerException npex) {
					npex.printStackTrace();
				}
				
				catch(IOException ioex) {
					break;
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
		}
		
	}
	
}
