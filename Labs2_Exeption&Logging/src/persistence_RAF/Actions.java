package persistence_RAF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Actions {
	private static  final Logger logger = LogManager.getLogger(Actions.class);
	Employee emp = null; 
    File file = new File("Employees.dat");
    File temp_file = new File("temp/temp_file.dat"); 
    RandomAccessFile raFile = null;
    RandomAccessFile tempFile = null;
    
	public void addEmployee(){   
	    emp = new Employee();
	    try {
			raFile = new RandomAccessFile(file, "rw");
			long fileSize = raFile.length();
			emp.getEmployeeData();
		    raFile.seek(fileSize); //Go to end of file
			raFile.writeInt(emp.getEmployeeNum()); 
			raFile.writeUTF(emp.getFirstName()); 
			raFile.writeUTF(emp.getLastName());
			raFile.writeUTF(emp.getAddress());
			raFile.writeDouble(emp.getBasicPay());
			raFile.writeDouble(emp.getAllowance());
			//raFile.writeUTF("\n");
		} catch (FileNotFoundException e1) {
			//System.out.println("File could not be opened or created: " + e1.getMessage());
			logger.error("File could not be opened or created: " + e1.getMessage());
		} catch (IOException e) {
			//System.out.println("Error: "+e.getMessage());
			logger.error("Error: "+e.getMessage());
		}finally {
			try {
				raFile.close();
			} catch (IOException e) {
				//System.out.println("There was an error closing the file: " + e.getMessage());
				logger.error("There was an error closing the file: " + e.getMessage());
			}
		}
	    
	} //End of addEmployee()
	
	public boolean createDatabase() {
		int max = 100; 
		Employee emp = new Employee();//object created using default constructor 
		RandomAccessFile raFile = null; 
		try{ 
			raFile = new RandomAccessFile(file, "rw"); 
			for(int idx = 1; idx <= max; idx++){ 
				raFile.seek( (idx - 1) * (4 + (40*3) + (8*3)));
				raFile.writeInt(emp.getEmployeeNum()); 
				raFile.writeUTF(emp.getFirstName()); 
				raFile.writeUTF(emp.getLastName());
				raFile.writeUTF(emp.getAddress());
				raFile.writeDouble(emp.getBasicPay());
				raFile.writeDouble(emp.getAllowance());
			}			
		}catch(IOException e){
			e.printStackTrace(); 
			return false;
		}finally{ 
			try{ 
				raFile.close(); 
			}catch(IOException e){
			}
		}
		return true;
	}
	
	public void modifyRecord(int emp_id){
		boolean found = false;
		emp = new Employee();
	    try {
			raFile = new RandomAccessFile(file, "rw");
			long fileSize = raFile.length();
			long recordCount = 0;
			
			while(true){
				raFile.seek(recordCount);
				try{
					int empid = raFile.readInt();
					if (empid == emp_id) { // If a matching id number is found
						emp.getModifiedData(); //Get the modified data						
						raFile.writeUTF(emp.getFirstName()); //Write the modified data to the file
						raFile.writeUTF(emp.getLastName());
						raFile.writeUTF(emp.getAddress());
						raFile.writeDouble(emp.getBasicPay());
						raFile.writeDouble(emp.getAllowance());
						//raFile.writeUTF("\n");
						break;
					}else {
			    		recordCount++;
			    		continue;
			    	}
				} catch (IOException e) {
					break;
				}				
			}
		} catch (FileNotFoundException e1) {
			//System.out.println("File could not be opend or created: " + e1.getMessage());
			logger.error("File could not be opend or created: " + e1.getMessage());
		} catch (IOException e) {
			logger.error("Error: "+e.getMessage());
			//System.out.println("Error: "+e.getMessage());
		}finally {
			try {
				raFile.close();
				//System.out.println("Record updated");
				logger.info("Record updated");
				
			} catch (IOException e) {
				//System.out.println("There was an error closing the file: " + e.getMessage());
				logger.error("There was an error closing the file: " + e.getMessage());
			}
		}		
		if(found==false){
			logger.error("\n\n Record Not Found \n");
			//System.out.println("\n\n Record Not Found ");
		}		
	} // End of modifyRecord()
	
	public void findRecord(int emp_id){
		boolean found = false;
		emp = new Employee();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			long recordCount = 0;
						
		    while(true){
		    	raf.seek(recordCount);
		    	try {
			    	int empid = raf.readInt();
			    	if(empid == emp_id) {
			    		found = true;
				    	emp.setEmployeeNum(empid);
				    	String f_name = raf.readUTF();
				    	emp.setFirstName(f_name);
				    	String l_name = raf.readUTF();
				    	emp.setLastName(l_name);
				    	String address = raf.readUTF();
				    	emp.setAddress(address);
				    	double basic_pay = raf.readDouble();
				    	emp.setBasicPay(basic_pay);
				    	double allowance = raf.readDouble();
				    	emp.setAllowance(allowance);
				    	emp.printData();	
				    	break;
			    	} else {
			    		recordCount++;
			    		continue;
			    	}			    	
		    	}catch (IOException e) {
		    		//System.out.println("End of file reached");
		    		logger.warn("End of file reached");
		    		break;
		    	}		    	
		    }		    
		} catch (FileNotFoundException e) {
			//System.out.println("\nFile could not be opened for reading: " + e.getMessage());
			logger.error("\nFile could not be opened for reading: " + e.getMessage());
		} catch (IOException e) {
			logger.error("IO Exception: " + e.getMessage());
			//System.out.println("IO Exception: ");e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(found==false){
			logger.error("\n\n Record Not Found \n");
			//System.out.println("\n\n Record Not Found \n");
		}		
	}// End of findRecord()

	public void displayAllRecords(){
		emp = new Employee();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			long recordCount = 0;
			raf.seek(recordCount);
			long fileSize = raf.length();
			System.out.println("\n\t\tEMPLOYEES LIST\n" );
			System.out.println("=====================================================================================================================\n");
			System.out.println("ID no. |\tName\t\t | Address\t\t| Basic pay | Allowance | Gross Pay | Deductions | Net pay\n");
			System.out.println("=====================================================================================================================\n");
		    while(true){
		    	try {
			    	int empid = raf.readInt();
			    	emp.setEmployeeNum(empid);
			    	String f_name = raf.readUTF();
			    	emp.setFirstName(f_name);
			    	String l_name = raf.readUTF();
			    	emp.setLastName(l_name);
			    	String address = raf.readUTF();
			    	emp.setAddress(address);
			    	double basic_pay = raf.readDouble();
			    	emp.setBasicPay(basic_pay);
			    	double allowance = raf.readDouble();
			    	emp.setAllowance(allowance);
			    	emp.report();	
			    	recordCount++;
		    	}catch (IOException e) {
		    		//System.out.println("End of file reached");
		    		break;
		    	}
		    }		    
		} catch (FileNotFoundException e) {
			logger.error("\nFile could not be opened for reading: " + e.getMessage());
			//System.out.println("\nFile could not be opened for reading: " + e.getMessage());			
		} catch (IOException e) {
			logger.error("IO Exception: "+e.getMessage());
			//System.out.println("IO Exception: ");e.printStackTrace();
		}catch (NullPointerException e) {
			logger.error("NullPEx: " + e.getMessage());
			//System.out.println("NullPEx: " + e.getMessage());
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//End of displayAllRecords()
	
	public void deleteEmployee(int emp_id){
		int empid=0;
		boolean found = false;
		long recordCount = 0;
		try {			
			long fileSize = 0;
			raFile = new RandomAccessFile(file, "rw");
			raFile.seek(recordCount);		    	
		    while(true){	
		    	emp = new Employee();	    
		    	tempFile = new RandomAccessFile(temp_file, "rw");
		    	fileSize = tempFile.length();
		    	
		    	try {		    		
			    	empid = raFile.readInt();
			    	emp.setEmployeeNum(empid);
			    	String f_name = raFile.readUTF();
			    	emp.setFirstName(f_name);
			    	String l_name = raFile.readUTF();
			    	emp.setLastName(l_name);
			    	String address = raFile.readUTF();
			    	emp.setAddress(address);
			    	double basic_pay = raFile.readDouble();
			    	emp.setBasicPay(basic_pay);
			    	double allowance = raFile.readDouble();
			    	emp.setAllowance(allowance);
			    	
			    	if(!(empid == emp_id)) { System.out.println("ID:->"+empid);			    		
				    	//Write the data to the temporary file				    	
					    tempFile.seek(fileSize); //Use the file size to go to end of file for insertion
					    tempFile.writeInt(emp.getEmployeeNum()); 
					    tempFile.writeUTF(emp.getFirstName()); 
					    tempFile.writeUTF(emp.getLastName());
					    tempFile.writeUTF(emp.getAddress());
					    tempFile.writeDouble(emp.getBasicPay());
					    tempFile.writeDouble(emp.getAllowance());
					    recordCount++;
					    try {
							tempFile.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
			    	}else if(empid == emp_id) {
			    		recordCount++;
			    		continue;
			    	}
			    	
		    	}catch (NullPointerException e ) {
		    		logger.error("NullPointer Exception" + e.getMessage());
		    		//System.out.println("NullPointer Exception");
		    		//e.printStackTrace();
		    		break;
		    	}catch (IOException e ) {
		    		//System.out.println("End of file reached");
		    		break;
		    	}		    		    	
		    }//END OF WHILE LOOP
		    
			raFile.close();
			tempFile.close();
			logger.info("Files closed");
			//System.out.println("Files closed");
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			try {
				// Ensure that the files are closed
				raFile.close();
				tempFile.close();	
				if (recordCount > 0) { 
					//Rename the temporary file
			    	boolean isRenamed = temp_file.renameTo(new File("Employees.dat"));
			    	
			    	if (isRenamed) { // If temporary file was successfully renamed
			    		System.out.println("File Renamed!!");
						boolean isDeleted = file.delete(); // Delete the old file 
						if (isDeleted) {
							logger.info("Record deleted successfully ");
							//System.out.println("Record deleted successfully");
						}
					}else {
						logger.warn("Not Renamed!!");
						//System.out.println("Not Renamed!!");
					}
			        
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
