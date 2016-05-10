package mx.tiid.smartconstruction.util.mail;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Spring Bean file you specified in /src/main/resources folder
				String crunchifyConfFile = "applicationContext.xml";
				ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
		 
				// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
				Mail mail = (Mail) context.getBean("mail");
				String toAddr = "juancarlosbucio@gmail.com";
				String fromAddr = "test@crunchify.com";
		 
				// email subject
				String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";
		 
				// email body
				String body = "<!DOCTYPE html><html><body><table style=\"width:100%\">  <tr>    <td>Jill</td>    <td>Smith</td>	    <td>50</td>  </tr>  <tr>    <td>Eve</td>    <td>Jackson</td>	    <td>94</td>  </tr>  <tr>    <td>John</td>    <td>Doe</td>	    <td>80</td>  </tr></table></body></html>";
				mail.send(toAddr, fromAddr, subject, body);
			

	}

}
