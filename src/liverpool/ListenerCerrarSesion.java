package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Clase ListenerCerrarSesion
 * Descripci�n: Esta clase se usa para controlar el cierre de sesi�n del representante.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class ListenerCerrarSesion implements ActionListener {
	private Representante repre;
	private login login;
	
	/**
	 * Constructor parametrizado de la clase ListenerCerrarSesion
	 * @param repre - tipo JFrame Representante
	 * @param login - tipo JFrame login
	 */
	public ListenerCerrarSesion(Representante repre, login login) {
		this.repre = repre;
		this.login = login;
	}
	
	//Evento del bot�n cerrar sesion
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == repre.getBtnCerrarSesion()) {
			repre.dispose();
			login.setVisible(true);
		}

	}

}
