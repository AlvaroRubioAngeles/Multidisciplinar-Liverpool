package liverpool;
/**
 * Clase Correo
 * Descripción: Esta clase se usa para controlar el correo del representante.
 * @author Gabriel Vizcaino Sánchez
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
	
	//Método correoRepresentante
	//Este método le da evento al botón correo.
	public void correoRepresentante() {
		repre.getBtnCorreo().addActionListener(new ListenerCorrero(repre));
	}

}
