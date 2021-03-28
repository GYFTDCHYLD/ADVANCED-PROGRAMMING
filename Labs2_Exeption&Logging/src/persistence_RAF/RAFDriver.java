package persistence_RAF;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class RAFDriver {
	private static final Logger logger = LogManager.getLogger(RAFDriver.class);
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
	    int emp_id;
	    boolean dbExists = false;
	    Actions action = new Actions();   
	    do{	    	
	    	if(!dbExists) {
	    		//dbExists = action.createDatabase();
	    	}
	    	System.out.println("\n===== Main Menu =====\n\n"		    
		    +"1 -> Add Record \n"
		    +"2 -> Display All Record\n"
		    +"3 -> Delete A Record\n"
		    +"4 -> Update A Record\n"
		    +"5 -> Find Employee Record\n"
		    +"0 -> Exit\n"
		    +"Select an option (0 - 5) ->");
	    	if(input.hasNextInt()) {	    	
	    		choice = input.nextInt();
	    	} else {
	    		choice = input.nextInt();
	    	}
		    
		    switch(choice){
		        case 0: break;
		        case 1:    
					action.addEmployee(); 					
				break;
		        case 2:    
				    action.displayAllRecords(); 				 
				break;
		        case 3:   
		        	System.out.println("\nEnter The Employee ID No: "); emp_id = input.nextInt(); 
		        	//logger.info("Delete A Record: " + emp_id);
					action.deleteEmployee(emp_id);
				break;
		        case 4: 
		        	System.out.println("\nPlease enter employee ID No: "); emp_id = input.nextInt();   
		        	//logger.info("Update A Record: " + emp_id);
		        	action.modifyRecord(emp_id);
				break;
				case 5:
					System.out.println("\nPlease enter employee ID No: "); emp_id = input.nextInt();
					//logger.info("Find Employee Record: " + emp_id);
					action.findRecord(emp_id);
				break;
		    }
		     
	    }while(choice != 0);
	   input.close();
	}

}
