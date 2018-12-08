import java.util.Scanner;

public class UserInputAddress {

    //this will imitate the user input 
    
    public static void main(String[] args) {

	System.out.println("pls enter an address:");
	Scanner scan = new Scanner(System.in);
	String address = scan.nextLine();
	address = address.replaceAll(" ", "+"); //necessary to build url in api
	System.out.println(address); //test
    }
}
