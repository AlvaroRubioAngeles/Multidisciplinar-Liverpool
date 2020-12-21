package liverpool;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;
/**
 * Clase ListenerAcercaDe
 * Descripci�n: Esta clase se usa para controlar la informaci�n del software.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class ListenerAcercaDe implements ActionListener {

	//Evento del bot�n Acerca de
	@Override
	public void actionPerformed(ActionEvent ae) {
		JOptionPane optionPane = new NarrowOptionPane();
	    optionPane.setMessage("<html>Software Liverpool<br>Miembros<br>David Casado - Desarrollador<br>Mario Vega - Analista/Desarrollador"
	    		+ "<br>�lvaro Rubio - Desarrollador<br>Francisco Coronado - Desarrollador/Colaborador<br>Gabriel Vizcaino - Gestor<br>Versi�n. 1"
	    		+ "<br>Fecha: 17-12-2020<br>Copyrigth. Liverpool");
	    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);	
	    JDialog dialog = optionPane.createDialog(null, "Acerca de");
	    dialog.setVisible(true);
	}

}
