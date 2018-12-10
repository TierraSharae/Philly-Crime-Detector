
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Geocoder {

    public static void main(String[] args) throws IOException, JSONException {

	System.out.print("Where are you? ");
	Scanner scan = new Scanner(System.in);
	String address = scan.nextLine();
	try {
	    address = URLEncoder.encode(address, "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}

	URL oracle = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" +address+ "&key=" +SecretFile.key);
	URLConnection yc = oracle.openConnection();
	BufferedReader in = new BufferedReader(new InputStreamReader(
		yc.getInputStream()));       
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
	    response.append(inputLine + "\n");     
	}
	String responseString = response.toString();

	JSONObject jObj = new JSONObject(responseString);
	JSONArray results = jObj.getJSONArray("results");
	JSONObject resultsObj = results.getJSONObject(0);
	String formatted_address = results.getJSONObject(0).getString("formatted_address");
	JSONObject geometry = resultsObj.getJSONObject("geometry");
	JSONObject location = geometry.getJSONObject("location");
	double lat = location.getDouble("lat");
	double lng = location.getDouble("lng");
	int zone = 0;

	System.out.println("lat = " +lat);
	System.out.println("lng = "+ lng);


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
	    zone = 10; //will change this
	} else {
	    System.out.print("Sorry, we do not currently have data for "+formatted_address+". ");
	    if(!formatted_address.contains("Philadelphia")){
		System.out.println("Please try a location in Philadelphia.");
	    }
	}

	System.out.println("zone = " +zone);
	in.close();

    }

}