
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


	System.out.println("please enter an address:");
	Scanner scan = new Scanner(System.in);
	String address = scan.nextLine();
	try {
	    address = URLEncoder.encode(address, "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
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
	JSONObject geometry = resultsObj.getJSONObject("geometry");
	JSONObject location = geometry.getJSONObject("location");
	double lat = location.getDouble("lat");
	double lng = location.getDouble("lng");

	System.out.println("lat = " +lat);
	System.out.println("lng = "+ lng);

	in.close();

    }

}


