import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class BusinessAccount extends Customer{
public int busTaxId;
public double busBalance;
public Long acctNumber;
public static ArrayList <BusinessAccount> BusinessAccountsList = new ArrayList<BusinessAccount>();
	
	public BusinessAccount(String bankName, String name, String address, String PhNo, String email, String username, String password, int TaxId, double Balance) {
		super(bankName, name, address, PhNo, email, username, password);
		this.busTaxId = TaxId;
		this.busBalance = Balance;
	}
	
	/*public static void addBusinessCustomer(BusinessAccount customer){
		BusinessAccountsList.add(customer);
	}*/
	/*public static ArrayList<BusinessAccount> getBusinessAccountsList() {
		return BusinessAccountsList;
	}*/
	public String toString(){
		return super.toString() + "\nAccount Number: " + acctNumber + "\nFederal Tax Id: " + busTaxId + "\nBalance: $" + busBalance;
	}
	public void createAccount(){
		acctNumber = BankAccount.acctNumberGenerate();
		try
	    {
	        File file = new File("Business Account/", super.custUsername+acctNumber+".txt");
	        file.createNewFile();
	        PrintWriter writer = new PrintWriter(file);
	        writer.println(this.toString());
	        writer.close();
	        Business.business.dispose();
	        AccountInfo AcctInfo = new AccountInfo();
	        AcctInfo.AccountInfo.setVisible(true);
	        AcctInfo.txtAccountInfo.setText(this.toString());
			/*try {
				String line = "";
	            Scanner in = new Scanner(file);
	            while(in.hasNext())
	            {
	                line=in.nextLine();
	                
	            }
	            
	        } catch (FileNotFoundException z) {
	            z.printStackTrace();
	        }*/
		}
	    catch(Exception y)
	    {
	        y.printStackTrace();
	        System.out.println("Failed to create file");
	    }
	}
}
