package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Clase ListenerVerFichero
 * Descripción: Esta clase se usa para controlar al pulsar el botón se visualiza el filechooser que
 * se encargara de las acciones correspondientes de ver los ficheros.
 * @author Gabriel Vizcaino Sánchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class ListenerVerFichero implements ActionListener {
	private Representante repre;
	/**
	 * Constructor parametrizado de la clase ListenerVerFichero
	 * @param repre - tipo JFrame Representante
	 */
	public ListenerVerFichero(Representante repre) {
		this.repre = repre;
	}
	
	//Evento del botón ver, con lo que se vera el filechooser alojado en el panel_1 de la ventana
	//Representante, y se buscará el fichero a visualizar subido por el dirigente.
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == repre.getBtnVer()) {
			repre.getLblEscudo().setVisible(false);
			repre.getPanel_1().setVisible(true);
			//int result = repre.getFileChooser().showSaveDialog(repre);
			if(1 == repre.getFileChooser().CANCEL_OPTION) {
				System.out.println("hola");
			}
		}

	}

}
