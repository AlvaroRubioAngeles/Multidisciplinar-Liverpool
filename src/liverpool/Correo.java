package liverpool;
/**
 * Clase Correo
 * Descripci�n: Esta clase se usa para controlar el correo del representante.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class Correo {
	private Representante repre;
	/**
	 * Constructor parametrizado de la clase Correo
	 * @param repre - tipo JFrame Representante
	 */
	public Correo(Representante repre) {
		this.repre = repre;
	}
	
	//M�todo correoRepresentante
	//Este m�todo le da evento al bot�n correo.
	public void correoRepresentante() {
		repre.getBtnCorreo().addActionListener(new ListenerCorrero(repre));
	}

}
