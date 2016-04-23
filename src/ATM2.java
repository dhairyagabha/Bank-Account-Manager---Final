import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ATM2 {

	public static JFrame ATMTransaction;
	private JTextField txtAccountNo;
	private JTextField txtAmount;
	private JTextField txtTransUser;
	private JPasswordField passwordField;
	static Transaction transTransfer;
	String filePath;
	/**
	 * Create the application.
	 */
	public ATM2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ATMTransaction = new JFrame();
		ATMTransaction.setTitle("Bank of Programmers - Transactions");
		ATMTransaction.getContentPane().setBackground(new Color(30, 144, 255));
		ATMTransaction.getContentPane().setLayout(null);
		
		JLabel lblBankName = new JLabel("BANK OF PROGRAMMERS");
		lblBankName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankName.setForeground(Color.WHITE);
		lblBankName.setFont(new Font("Silom", Font.PLAIN, 40));
		lblBankName.setBounds(0, 0, 520, 52);
		ATMTransaction.getContentPane().add(lblBankName);
		
		JLabel lblTransaction = new JLabel("Transactions");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setForeground(Color.WHITE);
		lblTransaction.setFont(new Font("Silom", Font.PLAIN, 40));
		lblTransaction.setBounds(0, 50, 520, 52);
		ATMTransaction.getContentPane().add(lblTransaction);
		
		final JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setEnabled(false);
		lblAccountNumber.setForeground(new Color(255, 255, 255));
		lblAccountNumber.setFont(new Font("Silom", Font.PLAIN, 20));
		lblAccountNumber.setBounds(30, 276, 190, 32);
		ATMTransaction.getContentPane().add(lblAccountNumber);
		
		final JLabel lblEnterAmount = new JLabel("Enter Amount:");
		lblEnterAmount.setForeground(Color.WHITE);
		lblEnterAmount.setFont(new Font("Silom", Font.PLAIN, 20));
		lblEnterAmount.setBounds(30, 337, 190, 32);
		ATMTransaction.getContentPane().add(lblEnterAmount);
		
		txtAccountNo = new JTextField();
		txtAccountNo.setForeground(new Color(30, 144, 255));
		txtAccountNo.setFont(new Font("Silom", Font.PLAIN, 14));
		txtAccountNo.setEditable(false);
		txtAccountNo.setBounds(30, 303, 190, 28);
		ATMTransaction.getContentPane().add(txtAccountNo);
		txtAccountNo.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setForeground(new Color(30, 144, 255));
		txtAmount.setFont(new Font("Silom", Font.PLAIN, 14));
		txtAmount.setColumns(10);
		txtAmount.setBounds(30, 366, 462, 28);
		ATMTransaction.getContentPane().add(txtAmount);
		
		final JRadioButton rdbDeposit = new JRadioButton("Deposit");
		rdbDeposit.setForeground(new Color(255, 255, 255));
		rdbDeposit.setFont(new Font("Silom", Font.PLAIN, 20));
		rdbDeposit.setBounds(10, 118, 141, 32);
		ATMTransaction.getContentPane().add(rdbDeposit);
		
		final JRadioButton rdbWithdraw = new JRadioButton("Withdraw");
		rdbWithdraw.setForeground(Color.WHITE);
		rdbWithdraw.setFont(new Font("Silom", Font.PLAIN, 20));
		rdbWithdraw.setBounds(10, 153, 141, 32);
		ATMTransaction.getContentPane().add(rdbWithdraw);
		
		final JLabel lblTransUser = new JLabel("Username:");
		lblTransUser.setForeground(Color.WHITE);
		lblTransUser.setFont(new Font("Silom", Font.PLAIN, 20));
		lblTransUser.setEnabled(false);
		lblTransUser.setBounds(30, 217, 190, 32);
		ATMTransaction.getContentPane().add(lblTransUser);
		
		txtTransUser = new JTextField();
		txtTransUser.setForeground(new Color(30, 144, 255));
		txtTransUser.setFont(new Font("Silom", Font.PLAIN, 14));
		txtTransUser.setEditable(false);
		txtTransUser.setColumns(10);
		txtTransUser.setBounds(30, 250, 190, 28);
		ATMTransaction.getContentPane().add(txtTransUser);
		
		final JLabel lblTransPassword = new JLabel("Password:");
		lblTransPassword.setForeground(Color.WHITE);
		lblTransPassword.setFont(new Font("Silom", Font.PLAIN, 20));
		lblTransPassword.setEnabled(false);
		lblTransPassword.setBounds(232, 217, 260, 32);
		ATMTransaction.getContentPane().add(lblTransPassword);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(30, 144, 255));
		passwordField.setFont(new Font("Silom", Font.PLAIN, 14));
		passwordField.setEditable(false);
		passwordField.setBounds(232, 250, 260, 28);
		ATMTransaction.getContentPane().add(passwordField);
		
		JButton btnAccountInfo = new JButton("Account Info");
		btnAccountInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM.trans.accountInfo();
			}
		});
		btnAccountInfo.setForeground(new Color(30, 144, 255));
		btnAccountInfo.setFont(new Font("Silom", Font.PLAIN, 16));
		btnAccountInfo.setBounds(30, 406, 158, 42);
		ATMTransaction.getContentPane().add(btnAccountInfo);
		
		final JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setForeground(Color.WHITE);
		lblAccountType.setFont(new Font("Silom", Font.PLAIN, 20));
		lblAccountType.setEnabled(false);
		lblAccountType.setBounds(232, 276, 190, 32);
		ATMTransaction.getContentPane().add(lblAccountType);
		
		final JComboBox cbAccountType = new JComboBox();
		cbAccountType.setForeground(new Color(30, 144, 255));
		cbAccountType.setEnabled(false);
		cbAccountType.setFont(new Font("Silom", Font.PLAIN, 14));
		cbAccountType.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "SAVING ACCOUNT", "CHECKING ACCOUNT", "BUSINESS ACCOUNT"}));
		cbAccountType.setBounds(232, 305, 260, 27);
		ATMTransaction.getContentPane().add(cbAccountType);
		
		final JRadioButton rdbTransferTo = new JRadioButton("Transfer Money To");
		rdbTransferTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbTransferTo.isSelected() == true){
					lblAccountNumber.setEnabled(true);
					lblAccountNumber.setEnabled(true);
					lblTransUser.setEnabled(true);
					lblTransPassword.setEnabled(true);
					lblAccountType.setEnabled(true);
					txtAccountNo.setEditable(true);
					txtAccountNo.setEditable(true); 
					txtTransUser.setEditable(true);
					passwordField.setEditable(true);
					cbAccountType.setEnabled(true);
				}
			}
		});
		rdbTransferTo.setForeground(Color.WHITE);
		rdbTransferTo.setFont(new Font("Silom", Font.PLAIN, 20));
		rdbTransferTo.setBounds(214, 118, 228, 32);
		ATMTransaction.getContentPane().add(rdbTransferTo);
		
		final JRadioButton rdbTransferFrom = new JRadioButton("Transfer Money From");
		rdbTransferFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbTransferFrom.isSelected() == true){
					lblAccountNumber.setEnabled(true);
					lblAccountNumber.setEnabled(true);
					lblTransUser.setEnabled(true);
					lblTransPassword.setEnabled(true);
					lblAccountType.setEnabled(true);
					txtAccountNo.setEditable(true);
					txtAccountNo.setEditable(true); 
					txtTransUser.setEditable(true);
					passwordField.setEditable(true);
					cbAccountType.setEnabled(true);
				}
			}
		});
		rdbTransferFrom.setForeground(Color.WHITE);
		rdbTransferFrom.setFont(new Font("Silom", Font.PLAIN, 20));
		rdbTransferFrom.setBounds(214, 153, 260, 32);
		ATMTransaction.getContentPane().add(rdbTransferFrom);
		
		ButtonGroup transactions = new ButtonGroup();
		transactions.add(rdbDeposit);
		transactions.add(rdbWithdraw);
		transactions.add(rdbTransferTo);
		transactions.add(rdbTransferFrom);
		
		JButton btnTransact = new JButton("Complete Transaction");
		btnTransact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbTransferTo.isSelected() == false && rdbTransferFrom.isSelected() == false && rdbDeposit.isSelected() == false && rdbWithdraw.isSelected() == false){
					rdbDeposit.setForeground(Color.RED);
					rdbWithdraw.setForeground(Color.RED);
					rdbTransferFrom.setForeground(Color.RED);
					rdbTransferTo.setForeground(Color.RED);
				}
				if(((rdbTransferTo.isSelected() == false || rdbTransferFrom.isSelected() == false) && (rdbDeposit.isSelected() == true || rdbWithdraw.isSelected() == true)
						&& txtAmount.getText().equals(""))){
					lblEnterAmount.setForeground(Color.RED);
				}
				if((rdbTransferTo.isSelected() == true || rdbTransferFrom.isSelected() == true)&&(txtAccountNo.getText().equals("")&& txtTransUser.getText().equals("")&& passwordField.getPassword().equals("") && cbAccountType.getSelectedItem().equals("SELECT"))){
					lblAccountNumber.setForeground(Color.RED);
					lblTransUser.setForeground(Color.RED);
					lblTransPassword.setForeground(Color.RED);
					lblAccountType.setForeground(Color.RED);
				}
				if(rdbTransferTo.isSelected() == false && rdbTransferFrom.isSelected() == false && rdbDeposit.isSelected() == false && rdbWithdraw.isSelected() == false && txtAmount.getText().equals("") && (txtAccountNo.isEditable() == false && txtTransUser.isEditable() == false && passwordField.isEditable() == false && cbAccountType.isEnabled() == false) ){
					rdbDeposit.setForeground(Color.RED);
					rdbWithdraw.setForeground(Color.RED);
					rdbTransferFrom.setForeground(Color.RED);
					rdbTransferTo.setForeground(Color.RED);
					lblEnterAmount.setForeground(Color.RED);
					lblAccountNumber.setForeground(Color.RED);
					lblTransUser.setForeground(Color.RED);
					lblTransPassword.setForeground(Color.RED);
					lblAccountType.setForeground(Color.RED);
				} else {
					if(rdbDeposit.isSelected() == true){
						try {
							ATM.trans.Deposit(Long.parseLong(txtAmount.getText()));
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
					if(rdbWithdraw.isSelected() == true){
						try {
							ATM.trans.Withdraw(Long.parseLong(txtAmount.getText()));
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
					if(rdbTransferTo.isSelected() == true){
						if(cbAccountType.getSelectedIndex() == 1){
							filePath = "Savings Account/";
						} else if (cbAccountType.getSelectedIndex() == 2){
							filePath = "Checking Account/";
						} else if(cbAccountType.getSelectedIndex() == 3) {
							filePath = "Business Account/";
						}
						transTransfer = new Transaction(Long.parseLong(txtAccountNo.getText()), txtTransUser.getText(), new String (passwordField.getPassword()), filePath);
						try {
							ATM.trans.TransferTo(Long.parseLong(txtAmount.getText()), ATM.trans, transTransfer);
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
					if(rdbTransferFrom.isSelected() == true){
						if(cbAccountType.getSelectedIndex() == 1){
							filePath = "Savings Account/";
						} else if (cbAccountType.getSelectedIndex() == 2){
							filePath = "Checking Account/";
						} else if(cbAccountType.getSelectedIndex() == 3) {
							filePath = "Business Account/";
						}
						transTransfer = new Transaction(Long.parseLong(txtAccountNo.getText()), txtTransUser.getText(), new String (passwordField.getPassword()), filePath);
						try {
							ATM.trans.TransferFrom(Long.parseLong(txtAmount.getText()), ATM.trans, transTransfer);
							ATMTransaction.dispose();
							TransactionComplete.TransactionInformation.setVisible(true);
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
				}
			}
		});
		btnTransact.setForeground(new Color(30, 144, 255));
		btnTransact.setFont(new Font("Silom", Font.PLAIN, 16));
		btnTransact.setBounds(214, 406, 278, 42);
		ATMTransaction.getContentPane().add(btnTransact);
		
		ATMTransaction.setBounds(100, 100, 520, 500);
		ATMTransaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ATMTransaction.setLocation(dim.width/2-ATMTransaction.getSize().width/2, dim.height/2-ATMTransaction.getSize().height/2);
		
	}
}
