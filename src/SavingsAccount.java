import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class SavingsAccount extends BankAccount{
private double savingsBalance;
private long acctNumber;
public static ArrayList <SavingsAccount> SavingsCustomerList = new ArrayList<SavingsAccount>();

	public SavingsAccount(String bankName, String name, String address, String phno, String email, String username, String password, double balance) {
		super(bankName, name, address, phno, email, username, password);
		this.savingsBalance = balance;
	}
	static void addSavingsCustomer(SavingsAccount customer){
		SavingsCustomerList.add(customer);
	}
	public static ArrayList<SavingsAccount> getSavingsCustomerList() {
		return SavingsCustomerList;
	}
	public String toString(){
		return super.toString() + "\nAccount Number: " + acctNumber + "\nBalance: $" + savingsBalance;
	}
	public void createAccount(){
		acctNumber = BankAccount.acctNumberGenerate();
		try
	    {
	        File file = new File("Saving Accounts/", super.custUsername+acctNumber+".txt");
	        file.createNewFile();
	        PrintWriter writer = new PrintWriter(file);
	        writer.println(this.toString());
	        writer.close();
	        Savings.SAVINGACCOUNT.dispose();
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
