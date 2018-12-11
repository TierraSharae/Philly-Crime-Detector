import static org.junit.Assert.assertEquals;


/**
 *  these JUnit Tests check if the getZoneWithMostCrime and getZoneWithLeastCrime of ZoneAnalysis 
 *  is done correctly
 *  
 * @author BeatrizGo
 *
 */

import org.junit.Test;

public class ZoneAnalysisTest {

	int[][] array = new int[][]{
		  { 1, 2, 10, 11, 25, 86, 50, 32, 34, 5 },
		  { 6, 36, 42, 29, 31, 52, 46, 23, 9, 7 }
		};

	    @Test
	    public void shouldBeMaxValue() {
	        int maxValue = ZoneAnalysis.getZoneWithMostCrime(array);
	        assertEquals(86, maxValue);
	        
	    }



		@Test
	    public void shouldBeMinValue() {
	        int minValue = ZoneAnalysis.getZoneWithLeastCrime(array);
	        assertEquals(1, minValue);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void shouldBeIllegalArgumentException() {
	        int[][] emptyArray = new int[][] {};
	        int maxValue = ZoneAnalysis.getZoneWithMostCrime(emptyArray);
	        int minValue = ZoneAnalysis.getZoneWithLeastCrime(emptyArray);

	    }
}

