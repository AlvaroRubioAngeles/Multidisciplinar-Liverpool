package liverpool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
/**
 * Clase CrearContrato
 * Descripción: Esta clase le da evento al botón de crear contrato.
 * @author Gabriel Vizcaino Sánchez
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
	public CrearContrato(DataInputStream dataIn, DataOutputStream dataOut, Representante repre) {
		this.dataIn = dataIn;
		this.dataOut = dataOut;
		this.repre = repre;
	}
	
	//Método botónCrearContrato
	//Este método da evento al botón de crear, con lo que se creará el contrato del jugador.
	public void botónCrearContrato() {
		repre.getBtnCrear().addActionListener(new ListenerRepresentante(dataIn, dataOut, repre));
	}
}
