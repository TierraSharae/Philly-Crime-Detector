import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests methods on the Geocoder class
 * @author tierra
 *
 */

class GeocoderTest {

    private final static double EPSILON = 0.001;

    Geocoder myGeo;

    @BeforeEach
    public void setUp() {
	myGeo = new Geocoder();
    }

    //Test Purpose: tests location in philadelphia
    @Test 
    void makeCallPA() throws JSONException, IOException {
	assertTrue(myGeo.makeCall("Rittenhouse Square").contains("Philadelphia"));
    }

    //Test Purpose: tests location in that sounds 
    //like it's in philadelphia but is not, per google
    @Test 
    void makeCallNotInPA() throws JSONException, IOException {
	assertTrue(!myGeo.makeCall("Rittenhouse").contains("Philadelphia"));
    }

    //Test Purpose: tests location using zip code
    @Test
    void makeCallZip() throws JSONException, IOException {
	assertTrue(myGeo.makeCall("19104").contains("Philadelphia"));
    }

    //Test Purpose: tests latitude of location in Philadelphia
    @Test
    void getLatTest() throws IOException, JSONException {
	String response = myGeo.makeCall("Center City");
	assertEquals(39.9509, myGeo.getLat(response), EPSILON);
    }

    //Test Purpose: tests longitude of location in Philadelphia
    @Test
    void getLngTest() throws IOException, JSONException {
	String address = "Fishtown";
	Geocoder myGeo = new Geocoder();
	String response = myGeo.makeCall(address);
	assertEquals(-75.1280, myGeo.getLng(response), EPSILON);
    }

    //Test Purpose: gets zone for region in philadelphia
    @Test
    void getZoneTest() {
	assertEquals(8, myGeo.getZone(40.0, -75.28));
    }
    
    //Test Purpose: gets zone for region outside of philadelphia
    @Test 
    void getInvalidZoneTest() {
	assertEquals(0, myGeo.getZone(38.9, -77));
    }
    
}
