package serverSMTP;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * Author: �lvaro Rubio �ngeles
 * 
 * Fecha: 13/01/2021
 * 
 * Descripci�n: Clase que permite enviar un correo.
 * 
 * Versi�n: 1.0
 */
public class SMTPMail {
	// Estos son el correo y el nombre de donde quieres que se mande el correo.
	static final String FROM = "Sara0234TM@gmail.com";
	static final String FROMNAME = "Sender Name";

	// Este es el destinatario.
	static final String TO = "AlfredoRG0987@gmail.com";

	// Host del server SMTP
	static final String SMTP_USERNAME = "";

	// Contrase�a del server SMTP.
	static final String SMTP_PASSWORD = "";

	static final String CONFIGSET = "ConfigSet";

	static final String HOST = "localhost";

	// Puerto del SMTP.
	static final int PORT = 25;

	// Asunto del mensaje.
	static final String SUBJECT = "Pon aqu� el asunto";

	// Mensaje.
	static final String BODY = String.join(System.getProperty("line.separator"), "Aqu� el mensaje");

	public static void main(String[] args) throws Exception {

		// Propiedades de la conexi�n.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		// Crea la sesi�n con las propiedades.
		Session session = Session.getDefaultInstance(props);

		// Crea el mensaje con la informaci�n.
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(FROM, FROMNAME));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
		msg.setSubject(SUBJECT);
		msg.setContent(BODY, "text/html");

		// A�ade la configuraci�n a la cabecera.
		msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

		// Crea el transporte
		Transport transport = session.getTransport();

		// Se env�a el mensaje.
		try {
			System.out.println("Enviando...");

			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Email enviado");
		} catch (Exception ex) {
			System.out.println("El email no fue enviado.");
			System.out.println("Error: " + ex.getMessage());
		} finally {

			transport.close();
		}
	}
}
