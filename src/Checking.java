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
import java.io.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Checking {

	static JFrame checking;
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
	public Checking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		checking = new JFrame();
		checking.getContentPane().setBackground(new Color(30, 144, 255));
		checking.getContentPane().setLayout(null);
		
		JLabel lblBankName = new JLabel("BANK OF PROGRAMMERS");
		lblBankName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankName.setForeground(Color.WHITE);
		lblBankName.setFont(new Font("Silom", Font.PLAIN, 40));
		lblBankName.setBounds(0, 0, 520, 52);
		checking.getContentPane().add(lblBankName);
		
		JLabel lblChecking = new JLabel("Checking Account");
		lblChecking.setHorizontalAlignment(SwingConstants.CENTER);
		lblChecking.setForeground(Color.WHITE);
		lblChecking.setFont(new Font("Silom", Font.PLAIN, 30));
		lblChecking.setBounds(0, 43, 520, 45);
		checking.getContentPane().add(lblChecking);
		
		final JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Silom", Font.PLAIN, 16));
		lblName.setBounds(20, 90, 145, 30);
		checking.getContentPane().add(lblName);
		
		final JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Silom", Font.PLAIN, 16));
		lblAddress.setBounds(20, 120, 145, 30);
		checking.getContentPane().add(lblAddress);
		
		final JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Silom", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(20, 207, 145, 30);
		checking.getContentPane().add(lblPhoneNumber);
		
		final JLabel lblEmailId = new JLabel("Email Id:");
		lblEmailId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font("Silom", Font.PLAIN, 16));
		lblEmailId.setBounds(20, 238, 145, 30);
		checking.getContentPane().add(lblEmailId);
		
		final JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Silom", Font.PLAIN, 16));
		lblUsername.setBounds(20, 269, 145, 30);
		checking.getContentPane().add(lblUsername);
		
		final JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Silom", Font.PLAIN, 16));
		lblPassword.setBounds(20, 300, 145, 30);
		checking.getContentPane().add(lblPassword);
		
		final JLabel lblInitialAmount = new JLabel("Initial Amount: ");
		lblInitialAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInitialAmount.setForeground(Color.WHITE);
		lblInitialAmount.setFont(new Font("Silom", Font.PLAIN, 16));
		lblInitialAmount.setBounds(20, 331, 145, 30);
		checking.getContentPane().add(lblInitialAmount);
		
		txtName = new JTextField();
		txtName.setForeground(new Color(30, 144, 255));
		txtName.setFont(new Font("Silom", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(173, 91, 328, 28);
		checking.getContentPane().add(txtName);
		
		final JTextArea txtAddress = new JTextArea();
		txtAddress.setForeground(new Color(30, 144, 255));
		txtAddress.setFont(new Font("Silom", Font.PLAIN, 13));
		txtAddress.setBounds(177, 127, 320, 75);
		checking.getContentPane().add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setForeground(new Color(30, 144, 255));
		txtPhone.setFont(new Font("Silom", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(173, 208, 328, 28);
		checking.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(30, 144, 255));
		txtEmail.setFont(new Font("Silom", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(173, 239, 328, 28);
		checking.getContentPane().add(txtEmail);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(30, 144, 255));
		txtUsername.setFont(new Font("Silom", Font.PLAIN, 16));
		txtUsername.setColumns(10);
		txtUsername.setBounds(173, 270, 328, 28);
		checking.getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(new Color(30, 144, 255));
		txtPassword.setFont(new Font("Silom", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(173, 301, 328, 28);
		checking.getContentPane().add(txtPassword);
		
		txtInitialAmount = new JTextField();
		txtInitialAmount.setForeground(new Color(30, 144, 255));
		txtInitialAmount.setFont(new Font("Silom", Font.PLAIN, 16));
		txtInitialAmount.setColumns(10);
		txtInitialAmount.setBounds(173, 332, 328, 28);
		checking.getContentPane().add(txtInitialAmount);
		
		JButton btnCreateChecking = new JButton("Create Account");
		btnCreateChecking.setFont(new Font("Silom", Font.PLAIN, 13));
		btnCreateChecking.setForeground(new Color(30, 144, 255));
		btnCreateChecking.addActionListener(new ActionListener() {
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
				if(txtName.getText().equals("") && txtAddress.getText().equals("") && txtPhone.getText().equals("") && 
						(txtEmail.getText().equals("") || (BankAccount.validateEmail(txtEmail.getText()) == false)) &&
						txtUsername.getText().equals("") && txtPassword.getText().equals("") && 
						txtInitialAmount.getText().equals("")){
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
					if( balance <= 1499.9999){
						JOptionPane.showMessageDialog(checking, "Insufficient Funds!", "Bank of Programmers", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					} else {
						username = txtUsername.getText();
						password = txtPassword.getText();
						acctNo = BankAccount.acctNumberGenerate();
						Customer cust = new Customer("Bank of Programmers", name, address, phone, email, username, password);
						Customer.customerList.add(cust);
						CheckingAccount account = new CheckingAccount("Bank of Programmers", name, address, phone, email, username, password, acctNo, balance);
						CheckingAccount.addCheckingCustomer(account);
						account.createAccount();
					}
				
					
				}
			}
		});
		btnCreateChecking.setBounds(180, 421, 160, 40);
		checking.getContentPane().add(btnCreateChecking);
		
		
		checking.setTitle("Bank of Programmers - Checking");
		checking.setBounds(100, 100, 520, 500);
		checking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		checking.setLocation(dim.width/2-checking.getSize().width/2, dim.height/2-checking.getSize().height/2);
	
	}
	
	
}
