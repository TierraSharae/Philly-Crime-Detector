import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *  this class computes all the possible probabilities of crimes then stores the value in a 2D array 
 *  so the user may retrieve results quickly from their given input
 *  
 * @author TamaraPrabhakar
 *
 */

public class IncidentReporter {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		IncidentReader ir = new IncidentReader("new_data_grid.csv");
		ArrayList<CrimeIncident> crimes = ir.readIncidentFile();
		final int HOURS = 24;
		final int ZONES = 10;	
		double[][] crimeMap = new double[HOURS][ZONES];
		IncidentAnalysis incident = new IncidentAnalysis(crimes); 

			for (int i = 0; i < HOURS; i++) {
				   for (int j = 0; j < ZONES; j++) {
				    
				   crimeMap[i][j] = incident.getCrimeProbability(i, j);
				   
				   }

				}
			
			
		
			//returning percentage output from user input
			DecimalFormat df = new DecimalFormat("#%");
		    System.out.println(df.format(crimeMap[18][7]));

	}

}
