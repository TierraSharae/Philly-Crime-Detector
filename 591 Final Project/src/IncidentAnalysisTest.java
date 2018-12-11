import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class Junit tests the getCrimeProbability method with different types of inputs
 * 
 * @author TamaraPrabhakar
 *
 */



class IncidentAnalysisTest {
	private final static double EPSILON = 0.00001;
	IncidentReader ir = new IncidentReader("new_data_grid.csv");
	ArrayList<CrimeIncident> crimes = ir.readIncidentFile();
	IncidentAnalysis incident;
	
	@BeforeEach
	void setUp() {
	 
		incident = new IncidentAnalysis(crimes); 

	}
	
	
	@Test
	void testGetCrimeProbability() {
		assertEquals(.16915290356952584, incident.getCrimeProbability(18,10), EPSILON);
		
	}
	
	
	@Test
	void testInvalidHour() {
		incident.getCrimeProbability(32,10);
		assertFalse(false);
		
	}

	@Test
	void testInvalidZone() {
		incident.getCrimeProbability(10,32);
		assertFalse(false);
		
	}


}