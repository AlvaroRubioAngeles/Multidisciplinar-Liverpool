package liverpool;

import javax.swing.JOptionPane;
/**
 * Clase NarrowOptionPane
 * Descripción: Esta clase se usa para dar tamaño de caracteres al mensaje del JOptionPane.
 * @author Gabriel Vizcaino Sánchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class NarrowOptionPane extends JOptionPane {
	
	//Constructor de la clase NarrowOptionPane
	NarrowOptionPane() {
	}

	/*
	 * Método getMacCharactersPerLineCount
	 * Descripción: Ests método retorna un número entero que será en tamaño máximo de caracteres por línea que
	 * habrá en el mensaje del JOptionPane.
	 */
	public int getMaxCharactersPerLineCount() {
		return 500;
	}
}
