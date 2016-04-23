import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class TransactionComplete {
	 public static JTextArea textAreaTransInfo = new JTextArea();
	 public static JFrame TransactionInformation = new JFrame();
	/**
	 * Create the application.
	 */
	public TransactionComplete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TransactionInformation = new JFrame();
		TransactionInformation.setTitle("Bank of Programmers - Transaction Complete");
		TransactionInformation.getContentPane().setBackground(new Color(30, 144, 255));
		TransactionInformation.getContentPane().setLayout(null);
		TransactionInformation.setBounds(100, 100, 520, 500);
		TransactionInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		TransactionInformation.setLocation(dim.width/2-TransactionInformation.getSize().width/2, dim.height/2-TransactionInformation.getSize().height/2);
		
		JLabel label = new JLabel("BANK OF PROGRAMMERS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Silom", Font.PLAIN, 40));
		label.setBounds(0, 0, 520, 52);
		TransactionInformation.getContentPane().add(label);
		
		JLabel lblTanInfo = new JLabel("Transaction Info");
		lblTanInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTanInfo.setForeground(Color.WHITE);
		lblTanInfo.setFont(new Font("Silom", Font.PLAIN, 40));
		lblTanInfo.setBounds(0, 52, 520, 52);
		TransactionInformation.getContentPane().add(lblTanInfo);
		
		textAreaTransInfo = new JTextArea();
		textAreaTransInfo.setForeground(new Color(30, 144, 255));
		textAreaTransInfo.setFont(new Font("Silom", Font.PLAIN, 18));
		textAreaTransInfo.setEditable(false);
		textAreaTransInfo.setBounds(14, 116, 493, 276);
		TransactionInformation.getContentPane().add(textAreaTransInfo);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(new Color(30, 144, 255));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Silom", Font.PLAIN, 20));
		btnExit.setBounds(173, 404, 173, 52);
		TransactionInformation.getContentPane().add(btnExit);
		
	}
}
