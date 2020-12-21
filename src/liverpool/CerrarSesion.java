package liverpool;
/**
 * Clase CerrarSesion
 * Descripci�n: Esta clase se usa para controlar el cierre de sesi�n del representante.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class CerrarSesion {
	private Representante repre;
	private login login;
	
	/**
	 * Constructor parametrizado de la clase CerrarSesion
	 * @param repre - tipo JFrame Representante
	 * @param login - tipo JFrame login
	 */
	public CerrarSesion(Representante repre, login login) {
		this.repre = repre;
		this.login = login;
	}
	
	//M�todo cerrarSesion
	//Este m�todo le da evento al bot�n de cerrar sesi�n, el cu�l la finalizara.
	public void cerrarSesion() {
		repre.getBtnCerrarSesion().addActionListener(new ListenerCerrarSesion(repre, login));
	}

}
