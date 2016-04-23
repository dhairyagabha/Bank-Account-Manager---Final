import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class ForgotPasswordEmail {

	public static void Email(String recepient, String retrievedPassword)
	{
		final String username = "darthbot.bankofprogrammers@gmail.com";
		final String password = "darthbot";
		final String signature = "\nThank you,"
				+ "\nDarthBot"
				+ "\nBank of Programmers"
				+ "\nTech Support";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("darthbot.bankofprogrammers@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recepient));
			message.setSubject("Password Retrieval");
			message.setText("Dear Customer,"
				+ "\n\n Your password is: " + retrievedPassword +
				"\nThank you for chosing Bank of Programmers.\n\n\n"
				+ signature);
			Transport.send(message);
			ForgotPassword.lblRetrievedPassword.setText("An email has been sent to you with your password!");
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(ForgotPassword.contentPanel, "Invalid email on your file! Please"
					+ " update information on your file." + "\n\nPlease email your concerns at darthbot.bankofprogrammers@gmail.com", "Invalid Email!", JOptionPane.ERROR_MESSAGE);
		}
	}
}