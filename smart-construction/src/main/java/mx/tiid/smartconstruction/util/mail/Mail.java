package mx.tiid.smartconstruction.util.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class Mail {

//	@Autowired
	private JavaMailSender mailSender;

	public void send(String toAddress, String fromAddress, String subject, String msgBody) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			message.setSubject(subject);

			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);

			helper.setFrom(fromAddress);
			helper.setTo(toAddress);
			helper.setText(msgBody, true);
			mailSender.send(message);
		} catch (MessagingException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
