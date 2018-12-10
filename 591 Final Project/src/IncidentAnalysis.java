import java.util.ArrayList;

/**
 *  this class defines the method to solve the probability of a crime at a given time and location
 *  
 * @author TamaraPrabhakar
 *
 */

public class IncidentAnalysis {

    //instance variables	
    ArrayList<CrimeIncident> crimes;

    //constructor

    IncidentAnalysis(ArrayList<CrimeIncident> crimes) {

	this.crimes = crimes;
    }

    //methods

    //overall probability of crime
    public double getCrimeProbability(int hour, int zone) {

	ArrayList<CrimeIncident> timeRange = new ArrayList<>();
	for (CrimeIncident ci : crimes) {
	    if(ci.getHour() ==  hour) {
		timeRange.add(ci);
	    }
	}

	ArrayList<CrimeIncident> zoneRange = new ArrayList<>();
	for (CrimeIncident tr : timeRange) {
	    if(tr.getZone() ==  zone) {
		zoneRange.add(tr);
	    }	

	}

	double probability = ((double)zoneRange.size())/(timeRange.size()); 

	return probability;

    }	
}