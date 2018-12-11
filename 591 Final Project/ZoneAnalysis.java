

/**
 *  this class defines the method to solve for which zone has the highest probability, least probability  of crime in each time 
 *  
 * @author BeatrizGo
 *
 */

public class ZoneAnalysis {
    //zone with the most crime 
    public static int getZoneWithMostCrime(int[][] crimemap) {
    	int value = 0;
        if (crimemap.length <= 0) {
            throw new IllegalArgumentException("Array is empty.");
        }

        for (int i = 0; i < crimemap.length; i++) {
        	for (int j = 0; j<crimemap[i].length; j++){
	            if (crimemap[i][j] > value) {
	                value = crimemap[i][j];
	            }
        	}
        }
		return value;
    }
    
    //zone with the least crime 
    public static int getZoneWithLeastCrime(int[][] crimemap) {
    	int value = 10000;
        if (crimemap.length <= 0) {
            throw new IllegalArgumentException("Array is empty.");
        }

        for (int i = 0; i < crimemap.length; i++) {
        	for (int j = 0; j <crimemap[i].length; j++){
	            if (crimemap[i][j] < value) {
	                value = crimemap[i][j];
	            }
        	}
        }
		return value;
    }



  

}
