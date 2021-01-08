package liverpool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
/**
 * Clase CrearContrato
 * Descripci�n: Esta clase le da evento al bot�n de crear contrato.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class CrearContrato {
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private Representante repre;
	
	/**
	 * Contructor parametrizado de la clase CrearContrato
	 * @param dataIn - tipo DataInputStream
	 * @param dataOut - tipo DataOutputStream
	 * @param login - tipo JFrame login
	 * @param repre - tipo JFrame Representante
	 */
	public CrearContrato(Representante repre) {
		this.repre = repre;
	}
	
	//M�todo bot�nCrearContrato
	//Este m�todo da evento al bot�n de crear, con lo que se crear� el contrato del jugador.
	public void botonCrearContrato() {
		repre.getBtnCrear().addActionListener(new ListenerRepresentante(dataIn, dataOut, repre));
	}
}
