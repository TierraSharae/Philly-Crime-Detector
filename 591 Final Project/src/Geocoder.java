
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Geocoder {


    public String makeCall(String address) throws IOException {
	try {
	    address = URLEncoder.encode(address, "UTF-8"); 
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	URL geoCoderURL;
	URLConnection yc;
	BufferedReader in;

	geoCoderURL = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" +address+ "&key=" +SecretFile.key);
	yc = geoCoderURL.openConnection();
	in = new BufferedReader(new InputStreamReader(
		yc.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();
	while ((inputLine = in.readLine()) != null) {
	    response.append(inputLine);
	}
	in.close();

	return response.toString();
    }



    public double getLat(String response) throws JSONException {
	JSONObject jObj = new JSONObject(response);
	JSONArray results = jObj.getJSONArray("results");
	JSONObject resultsObj = results.getJSONObject(0);
	JSONObject geometry = resultsObj.getJSONObject("geometry");
	JSONObject location = geometry.getJSONObject("location");
	double lat = location.getDouble("lat");
	return lat;

    }

    public double getLng(String response) throws JSONException {
	JSONObject jObj = new JSONObject(response);
	JSONArray results = jObj.getJSONArray("results");
	JSONObject resultsObj = results.getJSONObject(0);
	JSONObject geometry = resultsObj.getJSONObject("geometry");
	JSONObject location = geometry.getJSONObject("location");
	double lng = location.getDouble("lng");
	return lng;

    }
    
 
    
    public int getZone(double lat, double lng) {
	int zone = 0;

	if (lat < 40.140689 && lat > 40.089990 && lng > -75.071930 && lng < -74.952492){ 
	    zone =  1;
	} else if (lat < 40.089990 && lat > 40.032053 && lng > -75.012725 && lng < -74.955568) {
	    zone = 2;
	} else if (lat < 40.089990 && lat > 40.032053 && lng > -75.012725 && lng < -75.071930) {
	    zone = 3;
	} else if (lat < 40.089990 && lat > 40.032053 && lng > -75.186205 && lng < -75.071930) {
	    zone = 4;
	} else if (lat < 40.089990 && lat > 40.032053 && lng > -75.268087 && lng < -75.186205) {
	    zone = 5;
	} else if (lat < 40.032053 && lat > 39.963886 && lng > -75.073577 && lng < -75.00477) {
	    zone = 6;
	} else if (lat < 40.032053 && lat > 39.963886 && lng > -75.198035 && lng < -75.073577) {
	    zone = 7;
	} else if (lat < 40.032053 && lat > 39.963886 && lng > -75.281930 && lng < -75.198035) {
	    zone = 8;
	} else if (lat < 39.963886 && lat > 39.869780 && lng > -75.200314 && lng < -75.130312) {
	    zone = 9;
	} else if (lat < 39.963886 && lat > 39.869780 && lng > -75.281930 && lng < -75.198035) {
	    zone = 10;
	}
	return zone;
	
    }
    
    public static void main(String[] args) throws IOException, JSONException {
	String address = "Rittenhouse square";
	Geocoder myGeo = new Geocoder();
	String response = myGeo.makeCall(address);
	myGeo.getZone(40.0, -75.28);
//	JSONObject jObj = new JSONObject(response);
//	jObj.ge
    }

}