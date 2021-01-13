package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerCerrarSesionCorreo implements ActionListener {
	private Representante repre;
	
	public ListenerCerrarSesionCorreo(Representante repre) {
		this.repre = repre;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//Cerrar sesion en el correo del representante alfredo
		repre.getPanel_4().setVisible(false);
		repre.getLblEscudo().setVisible(true);

	}

}
