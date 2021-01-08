package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.annotation.Repeatable;

import javax.swing.JOptionPane;
/**
 * Clase ListenerRepresentante
 * Descripci�n: Esta clase anade los listeners a los botones de crear contrato y guardar datos, que
 * se guardan en el fichero.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class ListenerRepresentante implements ActionListener {
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	Representante repre;

	/**
	 * Constructor parametrizado ListenerRepresentante
	 * @param dataIn - tipo DataInputStream
	 * @param dataOut - tipo DataOutputStream
	 * @param login - tipo JFrame login
	 * @param repre - tipo JFrame Representante 
	 */
	public ListenerRepresentante(DataInputStream dataIn, DataOutputStream dataOut, Representante repre) {
		this.dataIn = dataIn;
		this.dataOut = dataOut;
		this.repre = repre;
	}

	//Listener del bot�n Crear contrato
	@Override
	public void actionPerformed(ActionEvent e) {
		repre.getPanel_1().setVisible(false);
		repre.getLblEscudo().setVisible(false);
		repre.getPanel_2().setVisible(true);
		repre.getPanel_3().setVisible(true);
		repre.getBtnCrear().addActionListener(this);
		repre.getBtnCrearCont().addActionListener(this);
		//Listener del bot�n guardar
		if(e.getSource() == repre.getBtnCrearCont()) {
			for (int i = 0; i < repre.getCajas().size(); i++) {
				if (repre.getCajas().get(i).getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Error. Los campos no pueden estar vac�os", "Datos contrato", JOptionPane.WARNING_MESSAGE);
					repre.getCajas().get(i).setText("");
				} else {
					//Esta l�nea guarda los datos en un fichero los datos del contrato del jugador
					repre.getCajas().get(i).setText("");
					repre.getLblEscudo().setVisible(true);
					repre.getPanel_2().setVisible(false);
					repre.getPanel_3().setVisible(false);
				}
			}
		}
		
	}

}
