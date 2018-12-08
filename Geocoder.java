
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Geocoder {

    public static void main(String[] args) throws IOException {


	URL oracle = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=3101+Walnut+St+Philadelphia,+Pa+19104&key=KEYGOESHERE\n" + 
		"");
	URLConnection yc = oracle.openConnection();
	BufferedReader in = new BufferedReader(new InputStreamReader(
		yc.getInputStream()));       
	String inputLine;       
	while ((inputLine = in.readLine()) != null)
	    System.out.println(inputLine);       
	in.close();


    }

}


