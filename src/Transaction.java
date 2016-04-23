import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;
public class Transaction {
public long acctNumber;
public static double balance = 0, depositBalance, withdrawBalance;
public String username, password, filepath, transInfo;
public static boolean login = false;
public static Scanner reader = new Scanner(System.in), in;
public static Writer write;
	public Transaction(long accountNumber, String username, String password, String filepath) {
		this.acctNumber = accountNumber;
		this.username = username;
		this.password = password;
		this.filepath = filepath;
	}
	public boolean credentialValidation() throws FileNotFoundException{
		File findFile = new File(filepath+username+acctNumber+".txt");
		if (findFile.exists() == true){
        try {
            in = new Scanner(findFile);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Password: ")){
                    if(line.contains(password)){
                    	login = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        } else {
        	JOptionPane.showMessageDialog(ATM2.ATMTransaction, "Incorrect credentials!", "Credentials Error", JOptionPane.ERROR_MESSAGE);
        }
		return login;
	}
	public void Deposit(Long amount) throws IOException{
		File readFile = new File(filepath+username+acctNumber+".txt");
		try {
            in = new Scanner(readFile);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Balance: ")){
                	balance = Double.parseDouble(line.substring(10));
                }
            }
            balance = balance + amount;
        	FileWriter writer = new FileWriter(readFile, true);
        	Date date = new Date() ;
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        	Writer output = new BufferedWriter(new FileWriter(readFile, true));
        	output.append("\n\nRecent Transaction: " + date + "\nDeposit: $" + amount + "\nBalance: $" + balance);
        	output.close();
        	ATM2.ATMTransaction.dispose();
        	TransactionComplete TransactionInformation  = new TransactionComplete();
        	TransactionInformation.TransactionInformation.setVisible(true);
        	TransactionInformation.textAreaTransInfo.setText("Recent Transaction: " + date + "\nDeposit: $" + amount + "\nBalance: $" + balance);
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	public void Withdraw(Long amount) throws IOException{
		File readFile = new File(filepath+username+acctNumber+".txt");
		try {
            in = new Scanner(readFile);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Balance: ")){
                	balance = Double.parseDouble(line.substring(10));
                }
            }
                	if(balance < amount){
                		JOptionPane.showMessageDialog(ATM2.ATMTransaction, "Insufficient Funds", "Error", JOptionPane.ERROR_MESSAGE);
                	} else {
                	balance = balance - amount;
                	FileWriter writer = new FileWriter(readFile, true);
                	Date date = new Date() ;
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
                	Writer output = new BufferedWriter(new FileWriter(readFile, true));
                	output.append("\n\nRecent Transaction: " + date + "\nWithdrawal: $" + amount + "\nBalance: $" + balance);
                	output.close();
                	ATM2.ATMTransaction.dispose();
                	TransactionComplete TransactionInformation = new TransactionComplete();
                	TransactionInformation.TransactionInformation.setVisible(true);
                	TransactionInformation.textAreaTransInfo.setText("Recent Transaction: " + date + "\nWithdrawal: $" + amount + "\nBalance: $" + balance);
                	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	public void TransferTo(Long amount, Transaction trans1, Transaction trans2) throws IOException{
		if (trans2.credentialValidation() == true){
		File readFile1 = new File(trans1.filepath+trans1.username+trans1.acctNumber+".txt");
		try {
            in = new Scanner(readFile1);
            TransactionComplete TransactionInformation = new TransactionComplete();
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Balance: ")){
                	balance = Double.parseDouble(line.substring(10));
                }
            }
                	if(balance < amount){
                		JOptionPane.showMessageDialog(ATM2.ATMTransaction, "Insufficient Funds", "Error", JOptionPane.ERROR_MESSAGE);
                	} else {
                	balance = balance - amount;
                	FileWriter writer = new FileWriter(readFile1, true);
                	Date date = new Date() ;
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
                	Writer output = new BufferedWriter(new FileWriter(readFile1, true));
                	output.append("\n\nRecent Transaction: " + date + "\nAccount transfered to: " + trans2.acctNumber + "\nAmount transfered: $" + amount + "\nBalance: $" + balance);
                	output.close();
                	transInfo = transInfo + "\n\nRecent Transaction: " + date + "\nAccount transfered to: " + trans2.acctNumber + "\nAmount transfered: $" + amount + "\nBalance: $" + balance;
                	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		File readFile2 = new File(trans2.filepath+trans2.username+trans2.acctNumber+".txt");
		try {
            in = new Scanner(readFile2);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Balance: ")){
                	balance = Double.parseDouble(line.substring(10));
                }
            }
                	balance = balance + amount;
                	FileWriter writer = new FileWriter(readFile2, true);
                	Date date = new Date() ;
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
                	Writer output = new BufferedWriter(new FileWriter(readFile2, true));
                	output.append("\n\nRecent Transaction: " + date + "\nAccount transfered from: " + trans1.acctNumber + "\nAmount transfered: $" + amount + "\nBalance: $" + balance);
                	output.close();
                	transInfo = transInfo + "\nBalance of Account Transfered to: $" + balance;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		ATM2.ATMTransaction.dispose();
    	TransactionComplete TransactionInformation = new TransactionComplete();
    	TransactionInformation.TransactionInformation.setVisible(true);
    	TransactionInformation.textAreaTransInfo.setText(transInfo);
		}
	}
	//WORK FROM HERE
	public void TransferFrom(Long amount, Transaction trans1, Transaction trans2) throws IOException{
		if (trans2.credentialValidation() == true){
		File readFile1 = new File(trans1.filepath+trans1.username+trans1.acctNumber+".txt");
		File readFile2 = new File(trans2.filepath+trans2.username+trans2.acctNumber+".txt");
		try {
            in = new Scanner(readFile2);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Balance: ")){
                	balance = Double.parseDouble(line.substring(10));
                }
            }
                	if(balance < amount){
                		JOptionPane.showMessageDialog(ATM2.ATMTransaction, "Insufficient Funds", "Error", JOptionPane.ERROR_MESSAGE);
                	} else {
                	balance = balance - amount;
                	FileWriter writer = new FileWriter(readFile2, true);
                	Date date = new Date() ;
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
                	Writer output = new BufferedWriter(new FileWriter(readFile2, true));
                	output.append("\n\nRecent Transaction: " + date + "\nAccount transfered to: " + trans2.acctNumber + "\nAmount transfered: $" + amount + "\nBalance: $" + balance);
                	output.close();
                	transInfo = transInfo + "\nRecent Transaction: " + date + "\nAccount transfered from: " + trans2.acctNumber + "\nAmount transfered: $" + amount + "\nBalance of Account Transfered From: $" + balance;
                	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		try {
            in = new Scanner(readFile1);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Balance: ")){
                	balance = Double.parseDouble(line.substring(10));
                }
            }
                	balance = balance + amount;
                	FileWriter writer = new FileWriter(readFile1, true);
                	Date date = new Date() ;
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
                	Writer output = new BufferedWriter(new FileWriter(readFile1, true));
                	output.append("\n\nRecent Transaction: " + date + "\nAccount transfered to: " + trans1.acctNumber + "\nAmount transfered: $" + amount + "\nBalance: $" + balance);
                	output.close();
                	transInfo = transInfo + "\nYour Current Balance: $" + balance;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		ATM2.ATMTransaction.dispose();
    	TransactionComplete TransactionInformation = new TransactionComplete();
    	TransactionInformation.TransactionInformation.setVisible(true);
    	TransactionInformation.textAreaTransInfo.setText(transInfo);
	}
	}
	public void accountInfo(){
		File readFile = new File(filepath+username+acctNumber+".txt");
		String acctInfo = "", balanceInfo = "";
		try {
            in = new Scanner(readFile);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("Name: "))
                    acctInfo = acctInfo + "\n" + line;
                if(line.contains("Account Number: "))
                	acctInfo = acctInfo + "\n" + line;
                if(line.contains("Balance: "))
                	balanceInfo = line;
            }
            acctInfo = acctInfo + "\n" + balanceInfo;
            JOptionPane.showMessageDialog(ATM2.ATMTransaction, acctInfo, "Account Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
