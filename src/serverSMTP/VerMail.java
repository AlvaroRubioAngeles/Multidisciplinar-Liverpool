package serverSMTP;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.*;

public class VerMail {

	String nombreCorreo, contrasenya;
	ArrayList<String> fecha;
	ArrayList<String> asunto;
	ArrayList<String> contenido;
	
	public VerMail(String nombreCorreo, String contrasenya) throws Exception {

		this.nombreCorreo = nombreCorreo;
		this.contrasenya = contrasenya;
		
		Session session = Session.getDefaultInstance(new Properties());
		Store store = session.getStore("imaps");
		store.connect("imap.googlemail.com", 993, this.nombreCorreo, this.contrasenya);
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		// Fetch unseen messages from inbox folder
		Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.RECENT), false));

		// Sort messages from recent to oldest
		Arrays.sort(messages, (m1, m2) -> {
			try {
				return m2.getSentDate().compareTo(m1.getSentDate());
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		});

		for (Message message : messages) {
			System.out.println("sendDate: " + message.getSentDate() + " subject:" + message.getSubject()
					+ " contenido: " + message.getContent().toString());
			
			fecha.add(message.getSentDate().toString());
			asunto.add(message.getSubject());
			contenido.add(message.getContent().toString());
		}
		
	}

	public ArrayList<String> getFecha() {
		return fecha;
	}

	public void setFecha(ArrayList<String> fecha) {
		this.fecha = fecha;
	}

	public ArrayList<String> getAsunto() {
		return asunto;
	}

	public void setAsunto(ArrayList<String> asunto) {
		this.asunto = asunto;
	}

	public ArrayList<String> getContenido() {
		return contenido;
	}

	public void setContenido(ArrayList<String> contenido) {
		this.contenido = contenido;
	}

	
}
