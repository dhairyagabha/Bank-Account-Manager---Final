import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class CheckingAccount extends BankAccount{
private double checkingBalance;
public static ArrayList <CheckingAccount> CheckingCustomerList = new ArrayList<CheckingAccount>();
private Long acctNumber;
	public CheckingAccount(String bankName, String name, String address, String phno, String email, String username, String password, Long acctNumber, double balance) {
		super(bankName, name, address, phno, email, username, password);
		this.acctNumber = acctNumber;
		this.checkingBalance = balance;
	}
	static void addCheckingCustomer(CheckingAccount customer){
		CheckingCustomerList.add(customer);
	}
	public String toString(){
		return super.toString() + "\nAccount Number: " + acctNumber + "\nBalance: $" + checkingBalance;
	}
	public static ArrayList<CheckingAccount> getCheckingCustomerList() {
		return CheckingCustomerList;
	}
	public void createAccount(){
		try
	    {
	        File file = new File("Checking Account/", super.custUsername+acctNumber+".txt");
	        file.createNewFile();
	        PrintWriter writer = new PrintWriter(file);
	        writer.println(this.toString());
	        writer.close();
	        Checking.checking.dispose();
	        AccountInfo AcctInfo = new AccountInfo();
	        AcctInfo.AccountInfo.setVisible(true);
			try {
				String line = "";
	            Scanner in = new Scanner(file);
	            while(in.hasNext())
	            {
	                line=in.nextLine();
	                AcctInfo.txtAccountInfo.setText(this.toString());
	            }
	            
	        } catch (FileNotFoundException z) {
	            z.printStackTrace();
	        }
		}
	    catch(Exception y)
	    {
	        y.printStackTrace();
	        System.out.println("Failed to create file");
	    }
	}
}
