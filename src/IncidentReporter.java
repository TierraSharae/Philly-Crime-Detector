
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *  this class computes all the possible probabilities of crimes then stores the value in a 2D array 
 *  so the user may retrieve results quickly from their given input
 *  
 * @author TamaraPrabhakar, TierraSharae
 *
 */

public class IncidentReporter {


    public static void main(String[] args) throws FileNotFoundException, JSONException, IOException {

	System.out.print("Where are you? ");
	Scanner scan = new Scanner(System.in);
	String addressRaw = scan.nextLine();
	String address = null;
	try {
	    address = URLEncoder.encode(addressRaw, "UTF-8"); 
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
	} else {
	    System.out.print("Sorry, we do not currently have data for "+formatted_address+". ");
	    if(!formatted_address.contains("Philadelphia")){
		System.out.println("Please try a location in Philadelphia.");
		return;
	    }
	}
	in.close();

	System.out.print("Using \"Military Time,\" what time is it? (hh:mm) ");
	Scanner scanTime = new Scanner(System.in);
	String timeString = scanTime.nextLine();
	String [] timeArr=timeString.split(":");
	int time = Integer.valueOf(timeArr[0]);
	if(time > 23) {
	    System.out.println("The time you entered is invalid.");
	    return;
	}

	System.out.println("Calculating relative likelihood of violent crime for " +addressRaw+ " in the " +time+" o'clock hour...");

	IncidentReader ir = new IncidentReader("new_data_grid.csv");
	ArrayList<CrimeIncident> crimes = ir.readIncidentFile();
	final int HOURS = 24;
	final int ZONES = 11;	
	double[][] crimeMap = new double[HOURS][ZONES];
	IncidentAnalysis incident = new IncidentAnalysis(crimes); 

	for (int i = 0; i < HOURS; i++) {
	    for (int j = 0; j < ZONES; j++) {

		crimeMap[i][j] = incident.getCrimeProbability(i, j);
	    }
	}

	//returning percentage output from user input
	DecimalFormat df = new DecimalFormat("#%");
	System.out.println(df.format(crimeMap[time][zone]));
	if((crimeMap[time][zone])*100 < 5){
	    System.out.println("This means "+addressRaw+ " is very safe in the " +time+" o'clock hour.");
	}
	if((crimeMap[time][zone])*100 > 5 && (crimeMap[time][zone])*100 < 10){
	    System.out.println("This means "+addressRaw+ " is safe in the " +time+" o'clock hour.");
	}
	if((crimeMap[time][zone])*100 >= 10 && (crimeMap[time][zone])*100 < 20){
	    System.out.println("This means "+addressRaw+ " is pretty safe in the " +time+" o'clock hour.");
	}
	if((crimeMap[time][zone])*100 >= 20 && (crimeMap[time][zone])*100 < 30){
	    System.out.println("This means "+addressRaw+ " is relatively unsafe in the " +time+" o'clock hour.");
	}
	if((crimeMap[time][zone])*100 >= 30 && (crimeMap[time][zone])*100 < 40){
	    System.out.println("This means "+addressRaw+ " is relatively unsafe in the " +time+" o'clock hour.");
	}
	if((crimeMap[time][zone])*100 > 40){
	    System.out.println("This means "+addressRaw+ " is pretty unsafe in the " +time+" o'clock hour.");
	}

    }
}
