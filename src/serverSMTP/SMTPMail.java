package serverSMTP;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * Author: Álvaro Rubio Ángeles
 * 
 * Fecha: 13/01/2021
 * 
 * Descripción: Clase que permite enviar un correo.
 * 
 * Versión: 1.0
 */
public class SMTPMail {

	String correoEmi, correoDes, asunto, contenido, nombre;

	public SMTPMail(String correoEmi, String correoDes, String asunto, String contenido, String nombre)
			throws Exception {
		this.correoEmi = correoEmi;
		this.correoDes = correoDes;
		this.asunto = asunto;
		this.contenido = contenido;
		this.nombre = nombre;

		final String FROM = this.correoEmi;
		final String FROMNAME = this.nombre;

		// Este es el destinatario.
		final String TO = this.correoDes;

		// Host del server SMTP
		final String SMTP_USERNAME = "";

		// Contraseña del server SMTP.
		final String SMTP_PASSWORD = "";

		final String CONFIGSET = "ConfigSet";

		final String HOST = "localhost";

		// Puerto del SMTP.
		final int PORT = 25;

		// Asunto del mensaje.
		final String SUBJECT = this.asunto;

		// Mensaje.
		final String BODY = String.join(System.getProperty("line.separator"), this.contenido);

		// Estos son el correo y el nombre de donde quieres que se mande el correo.

		// Propiedades de la conexión.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		// Crea la sesión con las propiedades.
		Session session = Session.getDefaultInstance(props);

		// Crea el mensaje con la información.
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(FROM, FROMNAME));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
		msg.setSubject(SUBJECT);
		msg.setContent(BODY, "text/html");

		// Añade la configuración a la cabecera.
		msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

		// Crea el transporte
		Transport transport = session.getTransport();

		// Se envía el mensaje.
		try {
			System.out.println("Enviando...");

			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Email enviado.");
		} catch (Exception ex) {
			System.out.println("El Email no se ha enviado.");
			System.out.println("Error: " + ex.getMessage());
		} finally {

			transport.close();
		}
	}
}
