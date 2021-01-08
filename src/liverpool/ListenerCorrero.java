package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Clase ListenerCorreo
 * Descripci�n: Esta clase se usa para controlar el evento del bot�n correo.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class ListenerCorrero implements ActionListener {
	Representante repre;
	
	/**
	 * Contructor parametrizado de la clase ListenerCorreo
	 * @param repre - tipo JFrame Representante
	 */
	public ListenerCorrero(Representante repre) {
		this.repre = repre;
	}
	
	//Evento del bot�n correo
	@Override
	public void actionPerformed(ActionEvent ae) {
			repre.getLblEscudo().setVisible(false);
			repre.getPanel_1().setVisible(true);
	}

}
