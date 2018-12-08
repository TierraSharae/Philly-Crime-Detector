
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;


public class Geocoder {


    public static void main(String[] args) throws IOException {

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
	while ((inputLine = in.readLine()) != null)
	    System.out.println(inputLine);       
	in.close();


    }

}


