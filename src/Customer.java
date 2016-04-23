import java.util.*;
public class Customer extends Bank{
public String custName, custAddress, custPhNo, custEmail, bankName, custUsername;
private String custPassword;
public static ArrayList customerList = new ArrayList();
	public Customer(String bankName, String name, String address, String phno, String email, String username, String password) {
		super(bankName);
		this.custName = name;
		this.custAddress = address;
		this.custPhNo = phno;
		this.custEmail = email;
		this.custUsername = username;
		this.custPassword = password;
	}
	public String getCustName() {
		return custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public String getCustPhNo() {
		return custPhNo;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public ArrayList getCustomerList() {
		return customerList;
	}
	public String toString(){
		return "Name: " + custName + "\nAddress: " + custAddress + "\nPhone Number: " + custPhNo + 
				"\nEmail: " + custEmail + "\nUsername: " + custUsername + "\nPassword: " + custPassword;
	}
}
