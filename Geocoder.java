
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Geocoder {

    public static void main(String[] args) throws IOException {

	System.out.println("pls enter an address:");
	Scanner scan = new Scanner(System.in);
	String address = scan.nextLine();
	address = address.replaceAll(" ", "+"); //necessary to build url in api
	
	URL oracle = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" +address+ "&key=" +SecretFile.key);
	URLConnection yc = oracle.openConnection();
	BufferedReader in = new BufferedReader(new InputStreamReader(
		yc.getInputStream()));       
	String inputLine;       
	while ((inputLine = in.readLine()) != null)
	    System.out.println(inputLine);       
	in.close();


    }

}


