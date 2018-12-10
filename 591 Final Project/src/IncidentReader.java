import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *  this class reads in information from crime data excel sheet, stores information in arraylist, 
 *  then sorts information based on the hour and location of the crime 
 * @author TamaraPrabhakar
 *
 */

public class IncidentReader {
	
	//instance variables
			File fileName;	
			
			//constructor
			IncidentReader(String fileName) {
			
				this.fileName = new File(fileName);
						
			}

			//methods
		
			public ArrayList<CrimeIncident> readIncidentFile() {
				
				ArrayList<CrimeIncident> crimes = new ArrayList<>();		
										
					try  {
						Scanner scan= new Scanner(new File("new_data_grid.csv"));
						scan.nextLine();	
					    while (scan.hasNext()) {			
					    	String incidentLine = scan.nextLine();

					    	String[] crimeInfo = incidentLine.split(",");		   

					    	int hour = Integer.parseInt(crimeInfo[0]);
					    	int zone = Integer.parseInt(crimeInfo[1]);
					    	
					    	CrimeIncident incident = new CrimeIncident(hour, zone); 
					    	
					    	crimes.add(incident);
					    	
					    	Collections.sort(crimes, CrimeIncident.ZoneComparator);		    			    	
					    	Collections.sort(crimes, CrimeIncident.TimeComparator);
					    }
					    scan.close();
					 } catch(IOException e) {
						  e.printStackTrace();
						  
					 	}
					   
				return crimes;
			}

}
