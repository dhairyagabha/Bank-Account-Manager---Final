import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ATM {

	static JFrame ATMLogIn;
	private JTextField txtUsername;
	private JTextField txtAccountNo;
	private JPasswordField passwordField;
	public String username, password;
	public long acctNo;
	static Transaction trans;
	/**
	 * Create the application.
	 */
	public ATM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ATMLogIn = new JFrame();
		ATMLogIn.setType(Type.POPUP);
		ATMLogIn.setFont(new Font("Silom", Font.PLAIN, 12));
		ATMLogIn.setTitle("Bank of Programmers - ATM");
		ATMLogIn.getContentPane().setBackground(new Color(30, 144, 255));
		ATMLogIn.getContentPane().setLayout(null);
		ATMLogIn.setVisible(true);
		
		JLabel lblBankNameLabel = new JLabel("BANK OF PROGRAMMERS");
		lblBankNameLabel.setBounds(0, 0, 520, 52);
		lblBankNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankNameLabel.setForeground(Color.WHITE);
		lblBankNameLabel.setFont(new Font("Silom", Font.PLAIN, 40));
		ATMLogIn.getContentPane().add(lblBankNameLabel);
		
		JLabel lblATM = new JLabel("ATM");
		lblATM.setHorizontalAlignment(SwingConstants.CENTER);
		lblATM.setForeground(Color.WHITE);
		lblATM.setFont(new Font("Silom", Font.PLAIN, 40));
		lblATM.setBounds(0, 53, 520, 52);
		ATMLogIn.getContentPane().add(lblATM);
		
		JLabel lblUserId = new JLabel("Username:");
		lblUserId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUserId.setForeground(new Color(255, 255, 255));
		lblUserId.setFont(new Font("Silom", Font.PLAIN, 20));
		lblUserId.setBounds(10, 117, 172, 36);
		ATMLogIn.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Silom", Font.PLAIN, 20));
		lblPassword.setBounds(10, 165, 172, 36);
		ATMLogIn.getContentPane().add(lblPassword);
		
		JLabel lblActNo = new JLabel("Account No.:");
		lblActNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblActNo.setForeground(Color.WHITE);
		lblActNo.setFont(new Font("Silom", Font.PLAIN, 20));
		lblActNo.setBounds(10, 213, 172, 36);
		ATMLogIn.getContentPane().add(lblActNo);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(30, 144, 255));
		txtUsername.setFont(new Font("Silom", Font.PLAIN, 15));
		txtUsername.setBounds(194, 117, 274, 36);
		ATMLogIn.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtAccountNo = new JTextField();
		txtAccountNo.setText("Account Number");
		txtAccountNo.setForeground(new Color(30, 144, 255));
		txtAccountNo.setFont(new Font("Silom", Font.PLAIN, 18));
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(194, 213, 274, 36);
		ATMLogIn.getContentPane().add(txtAccountNo);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(30, 144, 255));
		passwordField.setFont(new Font("Silom", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBounds(194, 165, 274, 36);
		ATMLogIn.getContentPane().add(passwordField);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAccountType.setForeground(Color.WHITE);
		lblAccountType.setFont(new Font("Silom", Font.PLAIN, 20));
		lblAccountType.setBounds(10, 261, 172, 36);
		ATMLogIn.getContentPane().add(lblAccountType);
		
		final JComboBox cbAccountType = new JComboBox();
		cbAccountType.setForeground(new Color(30, 144, 255));
		cbAccountType.setBackground(new Color(255, 255, 255));
		cbAccountType.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "SAVING ACCOUNT", "CHECKING ACCOUNT", "BUSINESS ACCOUNT"}));
		cbAccountType.setFont(new Font("Silom", Font.PLAIN, 14));
		cbAccountType.setBounds(194, 261, 274, 36);
		ATMLogIn.getContentPane().add(cbAccountType);
		
		JLabel lblForgotPassword = new JLabel("Forgot password?");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPassword forgotPassword = new ForgotPassword();
				forgotPassword.setVisible(true);
			}
		});
		lblForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setFont(new Font("Silom", Font.PLAIN, 12));
		lblForgotPassword.setBounds(176, 368, 172, 28);
		ATMLogIn.getContentPane().add(lblForgotPassword);
		
		final JLabel lblUserNameError = new JLabel("*");
		lblUserNameError.setForeground(new Color(255, 182, 193));
		lblUserNameError.setFont(new Font("Silom", Font.PLAIN, 40));
		lblUserNameError.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserNameError.setBounds(467, 117, 36, 36);
		lblUserNameError.setVisible(false);
		ATMLogIn.getContentPane().add(lblUserNameError);
		
		final JLabel lblPasswordError = new JLabel("*");
		lblPasswordError.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordError.setForeground(new Color(255, 182, 193));
		lblPasswordError.setFont(new Font("Silom", Font.PLAIN, 40));
		lblPasswordError.setBounds(467, 165, 36, 36);
		lblPasswordError.setVisible(false);
		ATMLogIn.getContentPane().add(lblPasswordError);
		
		final JLabel lblAccountNoError = new JLabel("*");
		lblAccountNoError.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountNoError.setForeground(new Color(255, 182, 193));
		lblAccountNoError.setFont(new Font("Silom", Font.PLAIN, 40));
		lblAccountNoError.setBounds(467, 213, 36, 36);
		lblAccountNoError.setVisible(false);
		ATMLogIn.getContentPane().add(lblAccountNoError);
		
		final JLabel lblAccountTypeError = new JLabel("*");
		lblAccountTypeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountTypeError.setForeground(new Color(255, 182, 193));
		lblAccountTypeError.setFont(new Font("Silom", Font.PLAIN, 40));
		lblAccountTypeError.setBounds(467, 261, 36, 36);
		lblAccountTypeError.setVisible(false);
		ATMLogIn.getContentPane().add(lblAccountTypeError);
		
		final JLabel lblCredentialsError = new JLabel("*Credentials Entered Are Incorrect!");
		lblCredentialsError.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredentialsError.setForeground(new Color(255, 182, 193));
		lblCredentialsError.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCredentialsError.setBounds(0, 293, 520, 36);
		lblCredentialsError.setVisible(false);
		ATMLogIn.getContentPane().add(lblCredentialsError);
		ATMLogIn.setBounds(100, 100, 520, 500);
		ATMLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("LOG-IN");
		btnNewButton.setForeground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Silom", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtUsername.getText().equals(""))
					lblUserNameError.setVisible(true);
				if (passwordField.getPassword().equals(""))
					lblPasswordError.setVisible(true);
				if (txtAccountNo.getText().equals("") || txtAccountNo.getText().equals("Account Number"))
					lblAccountNoError.setVisible(true);
				if (cbAccountType.getSelectedItem().equals("SELECT"))
					lblAccountTypeError.setVisible(true);
				if((txtUsername.getText().equals("")) && (passwordField.getPassword().length == 0) && 
						(txtAccountNo.getText().equals("Account Number") || txtAccountNo.getText().equals("")) && (cbAccountType.getSelectedItem().equals("SELECT"))){
					lblUserNameError.setVisible(true);
					lblPasswordError.setVisible(true);
					lblAccountNoError.setVisible(true);
					lblAccountTypeError.setVisible(true);
					lblCredentialsError.setVisible(true);
				} else {
					username = txtUsername.getText();
					password = new String (passwordField.getPassword());
					acctNo = Long.parseLong(txtAccountNo.getText());
					if(cbAccountType.getSelectedItem().equals("SAVING ACCOUNT"))
						trans = new Transaction(acctNo, username, password, "Savings Account/");
					if(cbAccountType.getSelectedItem().equals("CHECKING ACCOUNT"))
						trans = new Transaction(acctNo, username, password, "Checking Account/");
					if(cbAccountType.getSelectedItem().equals("BUSINESS ACCOUNT"))
						trans = new Transaction(acctNo, username, password, "Business Account/");
					try {
						if(trans.credentialValidation() == true){
							ATMLogIn.dispose();
							ATM2 transCont = new ATM2();
							transCont.ATMTransaction.setVisible(true);
						} else {
							lblCredentialsError.setVisible(true);
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(176, 334, 172, 36);
		ATMLogIn.getContentPane().add(btnNewButton);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ATMLogIn.setLocation(dim.width/2-ATMLogIn.getSize().width/2, dim.height/2-ATMLogIn.getSize().height/2);
		
	}
}