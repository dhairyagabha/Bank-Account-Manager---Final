import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Savings {

	static JFrame SAVINGACCOUNT;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtInitialAmount;
	public String name, address, phone, email, username, password;
	public long acctNo;
	public double balance;
	
	/**
	 * Create the application.
	 */
	public Savings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SAVINGACCOUNT = new JFrame();
		SAVINGACCOUNT.getContentPane().setFont(new Font("Silom", Font.PLAIN, 13));
		SAVINGACCOUNT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SAVINGACCOUNT.setTitle("Bank of Programmers - Saving");
		SAVINGACCOUNT.getContentPane().setBackground(new Color(30, 144, 255));
		SAVINGACCOUNT.setBounds(100, 100, 520, 500);
		SAVINGACCOUNT.getContentPane().setLayout(null);
		
		JLabel lblBankName = new JLabel("BANK OF PROGRAMMERS");
		lblBankName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankName.setForeground(Color.WHITE);
		lblBankName.setFont(new Font("Silom", Font.PLAIN, 40));
		lblBankName.setBounds(0, 0, 520, 52);
		SAVINGACCOUNT.getContentPane().add(lblBankName);
		
		JLabel lblSaving = new JLabel("Saving Account");
		lblSaving.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaving.setForeground(Color.WHITE);
		lblSaving.setFont(new Font("Silom", Font.PLAIN, 30));
		lblSaving.setBounds(0, 43, 520, 45);
		SAVINGACCOUNT.getContentPane().add(lblSaving);
		
		final JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Silom", Font.PLAIN, 16));
		lblName.setBounds(20, 88, 145, 30);
		SAVINGACCOUNT.getContentPane().add(lblName);
		
		final JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Silom", Font.PLAIN, 16));
		lblAddress.setBounds(20, 118, 145, 30);
		SAVINGACCOUNT.getContentPane().add(lblAddress);
		
		final JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Silom", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(20, 205, 145, 30);
		SAVINGACCOUNT.getContentPane().add(lblPhoneNumber);
		
		final JLabel lblEmailId = new JLabel("Email Id:");
		lblEmailId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font("Silom", Font.PLAIN, 16));
		lblEmailId.setBounds(20, 236, 145, 30);
		SAVINGACCOUNT.getContentPane().add(lblEmailId);
		
		final JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Silom", Font.PLAIN, 16));
		lblUsername.setBounds(20, 267, 145, 30);
		SAVINGACCOUNT.getContentPane().add(lblUsername);
		
		final JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Silom", Font.PLAIN, 16));
		lblPassword.setBounds(20, 298, 145, 30);
		SAVINGACCOUNT.getContentPane().add(lblPassword);
		
		final JLabel lblInitialAmount = new JLabel("Initial Amount: ");
		lblInitialAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInitialAmount.setForeground(Color.WHITE);
		lblInitialAmount.setFont(new Font("Silom", Font.PLAIN, 16));
		lblInitialAmount.setBounds(20, 329, 145, 30);
		SAVINGACCOUNT.getContentPane().add(lblInitialAmount);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Silom", Font.PLAIN, 16));
		txtName.setBounds(173, 89, 328, 28);
		SAVINGACCOUNT.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		final JTextArea txtAddress = new JTextArea();
		txtAddress.setFont(new Font("Silom", Font.PLAIN, 13));
		txtAddress.setBounds(177, 125, 320, 75);
		SAVINGACCOUNT.getContentPane().add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Silom", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(173, 206, 328, 28);
		SAVINGACCOUNT.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Silom", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(173, 237, 328, 28);
		SAVINGACCOUNT.getContentPane().add(txtEmail);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Silom", Font.PLAIN, 16));
		txtUsername.setColumns(10);
		txtUsername.setBounds(173, 268, 328, 28);
		SAVINGACCOUNT.getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Silom", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(173, 299, 328, 28);
		SAVINGACCOUNT.getContentPane().add(txtPassword);
		
		txtInitialAmount = new JTextField();
		txtInitialAmount.setFont(new Font("Silom", Font.PLAIN, 16));
		txtInitialAmount.setColumns(10);
		txtInitialAmount.setBounds(173, 330, 328, 28);
		SAVINGACCOUNT.getContentPane().add(txtInitialAmount);
		
		JButton btnSavingCreate = new JButton("Create Account");
		btnSavingCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().equals(""))
					lblName.setForeground(Color.RED);
				if(txtAddress.getText().equals(""))
					lblAddress.setForeground(Color.RED);
				if(txtPhone.getText().equals(""))
					lblPhoneNumber.setForeground(Color.RED);
				if(txtEmail.getText().equals("") || (BankAccount.validateEmail(txtEmail.getText()) == false))
					lblEmailId.setForeground(Color.RED);
				if(txtUsername.getText().equals(""))
					lblUsername.setForeground(Color.RED);
				if(txtPassword.getText().equals(""))
					lblPassword.setForeground(Color.RED);
				if(txtInitialAmount.getText().equals(""))
					lblInitialAmount.setForeground(Color.RED);
				if(txtName.getText().equals("") && txtAddress.getText().equals("") && txtPhone.getText().equals("") && (txtEmail.getText().equals("") || (BankAccount.validateEmail(txtEmail.getText()) == false)) &&
						txtUsername.getText().equals("") && txtPassword.getText().equals("") && txtInitialAmount.getText().equals("")){
					lblName.setForeground(Color.RED);
					lblAddress.setForeground(Color.RED);
					lblPhoneNumber.setForeground(Color.RED);
					lblEmailId.setForeground(Color.RED);
					lblUsername.setForeground(Color.RED);
					lblPassword.setForeground(Color.RED);
					lblInitialAmount.setForeground(Color.RED);
				} else {
					name = txtName.getText();
					address = txtAddress.getText();
					phone = txtPhone.getText();
					email = txtEmail.getText();
					balance = Double.parseDouble(txtInitialAmount.getText());
					if( balance <= 399.9999){
						JOptionPane.showMessageDialog(SAVINGACCOUNT, "Insufficient Funds!", "Bank of Programmers", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					} else {
						username = txtUsername.getText();
						password = txtPassword.getText();
						Customer cust = new Customer("Bank of Programmers", name, address, phone, email, username, password);
						Customer.customerList.add(cust);
						SavingsAccount account = new SavingsAccount("Bank of Programmers", name, address, phone, email, username, password, balance);
						SavingsAccount.addSavingsCustomer(account);
						account.createAccount();
					}
				}
			}
		});
		btnSavingCreate.setBounds(180, 419, 160, 40);
		SAVINGACCOUNT.getContentPane().add(btnSavingCreate);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		SAVINGACCOUNT.setLocation(dim.width/2-SAVINGACCOUNT.getSize().width/2, dim.height/2-SAVINGACCOUNT.getSize().height/2);
	
	}

}