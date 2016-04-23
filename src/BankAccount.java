import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class BankAccount extends Customer{
	public static Random rand = new Random();
	public BankAccount(String bankName, String name, String address, String phno, String email, String username, String password) {
		super( bankName,  name,  address,  phno,  email,  username,  password);
	}
	static long acctNumberGenerate(){
	    char[] digits = new char[12];
	    digits[0] = (char) (rand.nextInt(9) + '1');
	    for (int i = 1; i < 12; i++) {
	        digits[i] = (char) (rand.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String (digits));
	}
	static boolean validateEmail (String email){
		if(email.indexOf("@") >= 1)
			return true;
		else
			return false;
	}
	static void forgotPassword(long acctNumber, String user, String accountType){
		String filePath = "";
		String password = "";
		String email = "";
		if(accountType.equals("SAVING ACCOUNT"))
			filePath = "Savings Account/" + user+acctNumber+".txt";
		if(accountType.equals("CHECKING ACCOUNT"))
			filePath = "Checking Account/" + user+acctNumber+".txt";
		if(accountType.equals("BUSINESS ACCOUNT"))
			filePath = "Business Account/" + user+acctNumber+".txt";
		File readFile = new File(filePath);
		try {
            Scanner in = new Scanner(readFile);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Password: "))
                	password = line.substring(10);
                
            }
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		try {
            Scanner in = new Scanner(readFile);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Email: "))
                	email = line.substring(7);
                
            }
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		ForgotPasswordEmail.Email(email, password);
	}
}
