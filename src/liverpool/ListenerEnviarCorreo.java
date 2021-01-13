package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ListenerEnviarCorreo implements ActionListener {
	private RedactarCorreo redactar;
	private Representante repre;
	
	public ListenerEnviarCorreo(RedactarCorreo redactar, Representante repre) {
		this.redactar = redactar;
		this.repre = repre;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// se enviara el correo al dirigente o a cualquiera
		JOptionPane.showMessageDialog(null, "Mensaje enviado");
		redactar.dispose();
		repre.setVisible(true);		
	}

}
