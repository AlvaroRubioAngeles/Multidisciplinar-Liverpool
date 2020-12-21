package liverpool;

import javax.swing.JOptionPane;
/**
 * Clase NarrowOptionPane
 * Descripci�n: Esta clase se usa para dar tama�o de caracteres al mensaje del JOptionPane.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class NarrowOptionPane extends JOptionPane {
	
	//Constructor de la clase NarrowOptionPane
	NarrowOptionPane() {
	}

	/*
	 * M�todo getMacCharactersPerLineCount
	 * Descripci�n: Ests m�todo retorna un n�mero entero que ser� en tama�o m�ximo de caracteres por l�nea que
	 * habr� en el mensaje del JOptionPane.
	 */
	public int getMaxCharactersPerLineCount() {
		return 500;
	}
}
