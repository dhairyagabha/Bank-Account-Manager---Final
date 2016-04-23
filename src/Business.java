import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
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

public class Business {

	static JFrame business;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtTaxId;
	private JTextField txtUsername;
	private JTextField txtPassword;
	public String name, address, phone, email, username, password;
	int fedId;
	public double balance;
	private JTextField txtBalance;

	/**
	 * Create the application.
	 */
	public Business() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		business = new JFrame();
		business.getContentPane().setBackground(new Color(30, 144, 255));
		business.getContentPane().setLayout(null);
		
		JLabel lblBankName = new JLabel("BANK OF PROGRAMMERS");
		lblBankName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankName.setForeground(Color.WHITE);
		lblBankName.setFont(new Font("Silom", Font.PLAIN, 40));
		lblBankName.setBounds(0, 0, 520, 52);
		business.getContentPane().add(lblBankName);
		
		JLabel lblBusiness = new JLabel("Business Account");
		lblBusiness.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusiness.setForeground(Color.WHITE);
		lblBusiness.setFont(new Font("Silom", Font.PLAIN, 30));
		lblBusiness.setBounds(0, 43, 520, 45);
		business.getContentPane().add(lblBusiness);
		
		final JLabel lblName = new JLabel("Business Corp.:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Silom", Font.PLAIN, 16));
		lblName.setBounds(20, 90, 145, 30);
		business.getContentPane().add(lblName);
		
		final JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Silom", Font.PLAIN, 16));
		lblAddress.setBounds(20, 120, 145, 30);
		business.getContentPane().add(lblAddress);
		
		final JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Silom", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(20, 207, 145, 30);
		business.getContentPane().add(lblPhoneNumber);
		
		final JLabel lblEmailId = new JLabel("Email Id:");
		lblEmailId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font("Silom", Font.PLAIN, 16));
		lblEmailId.setBounds(20, 238, 145, 30);
		business.getContentPane().add(lblEmailId);
		
		final JLabel lblTaxIdNo = new JLabel("Tax Id No.:");
		lblTaxIdNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTaxIdNo.setForeground(Color.WHITE);
		lblTaxIdNo.setFont(new Font("Silom", Font.PLAIN, 16));
		lblTaxIdNo.setBounds(20, 269, 145, 30);
		business.getContentPane().add(lblTaxIdNo);
		
		final JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Silom", Font.PLAIN, 16));
		lblUsername.setBounds(20, 300, 145, 30);
		business.getContentPane().add(lblUsername);
		
		final JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Silom", Font.PLAIN, 16));
		lblPassword.setBounds(20, 331, 145, 30);
		business.getContentPane().add(lblPassword);
		
		txtName = new JTextField();
		txtName.setForeground(new Color(30, 144, 255));
		txtName.setFont(new Font("Silom", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(173, 91, 328, 28);
		business.getContentPane().add(txtName);
		
		final JTextArea txtAddress = new JTextArea();
		txtAddress.setForeground(new Color(30, 144, 255));
		txtAddress.setFont(new Font("Silom", Font.PLAIN, 13));
		txtAddress.setBounds(177, 127, 320, 75);
		business.getContentPane().add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setForeground(new Color(30, 144, 255));
		txtPhone.setFont(new Font("Silom", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(173, 208, 328, 28);
		business.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(30, 144, 255));
		txtEmail.setFont(new Font("Silom", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(173, 239, 328, 28);
		business.getContentPane().add(txtEmail);
		
		txtTaxId = new JTextField();
		txtTaxId.setForeground(new Color(30, 144, 255));
		txtTaxId.setFont(new Font("Silom", Font.PLAIN, 16));
		txtTaxId.setColumns(10);
		txtTaxId.setBounds(173, 270, 328, 28);
		business.getContentPane().add(txtTaxId);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(30, 144, 255));
		txtUsername.setFont(new Font("Silom", Font.PLAIN, 16));
		txtUsername.setColumns(10);
		txtUsername.setBounds(173, 301, 328, 28);
		business.getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(new Color(30, 144, 255));
		txtPassword.setFont(new Font("Silom", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(173, 332, 328, 28);
		business.getContentPane().add(txtPassword);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Silom", Font.PLAIN, 16));
		lblBalance.setBounds(20, 361, 145, 30);
		business.getContentPane().add(lblBalance);
		
		txtBalance = new JTextField();
		txtBalance.setForeground(new Color(30, 144, 255));
		txtBalance.setFont(new Font("Silom", Font.PLAIN, 16));
		txtBalance.setColumns(10);
		txtBalance.setBounds(173, 363, 328, 28);
		business.getContentPane().add(txtBalance);
		
		JButton btnCreateBusiness = new JButton("Create Account");
		btnCreateBusiness.setFont(new Font("Silom", Font.PLAIN, 13));
		btnCreateBusiness.setForeground(new Color(30, 144, 255));
		btnCreateBusiness.addActionListener(new ActionListener() {
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
				if(txtTaxId.getText().equals(""))
					lblTaxIdNo.setForeground(Color.RED);
				if(txtName.getText().equals("") && txtAddress.getText().equals("") && txtPhone.getText().equals("") && (txtEmail.getText().equals("") || (BankAccount.validateEmail(txtEmail.getText()) == false))&&
						txtUsername.getText().equals("") && txtPassword.getText().equals("") && txtTaxId.getText().equals("")){
					lblName.setForeground(Color.RED);
					lblAddress.setForeground(Color.RED);
					lblPhoneNumber.setForeground(Color.RED);
					lblEmailId.setForeground(Color.RED);
					lblUsername.setForeground(Color.RED);
					lblPassword.setForeground(Color.RED);
					lblTaxIdNo.setForeground(Color.RED);
				} else {
					name = txtName.getText();
					address = txtAddress.getText();
					phone = txtPhone.getText();
					email = txtEmail.getText();
					username = txtUsername.getText();
					password = txtPassword.getText();
					fedId = Integer.parseInt(txtTaxId.getText());
					balance = Double.parseDouble(txtBalance.getText());
					Customer cust = new Customer("Bank of Programmers", name, address, phone, email, username, password);
					Customer.customerList.add(cust);
					BusinessAccount account = new BusinessAccount("Bank of Programmers", name, address, phone, email, username, password, fedId, balance);
					account.createAccount();
				}
			}
		});
		btnCreateBusiness.setBounds(180, 421, 160, 40);
		business.getContentPane().add(btnCreateBusiness);
		
		business.setTitle("Bank of Programmers - Business");
		business.setBounds(100, 100, 520, 500);
		business.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		business.setLocation(dim.width/2-business.getSize().width/2, dim.height/2-business.getSize().height/2);
	
	}
}
