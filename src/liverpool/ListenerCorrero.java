package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Clase ListenerCorreo
 * Descripción: Esta clase se usa para controlar el evento del botón correo.
 * @author Gabriel Vizcaino Sánchez
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
	
	//Evento del botón correo
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == repre.getBtnCorreo()) {
			repre.getLblEscudo().setVisible(false);
			repre.getPanel_1().setVisible(true);
		}

	}

}
