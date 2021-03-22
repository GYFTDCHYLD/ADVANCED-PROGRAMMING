package client;

public class Driver {

	public static void main(String[] args) {
		Client client = new Client();
		Student student = new Student("1001", "John", "Public", "publicj@anemail.com");
		
		client.sendAction("Add Student");
		System.out.println("Message sent to server");
		client.sendStudent(student);
		System.out.println("Record sent to server");
		client.recieveResponse();
		System.out.println("Response recieved from server");
	}

}
