package liverpool;
/**
 * Clase CerrarSesion
 * Descripción: Esta clase se usa para controlar el cierre de sesión del representante.
 * @author Gabriel Vizcaino Sánchez
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
	
	//Método cerrarSesion
	//Este método le da evento al botón de cerrar sesión, el cuál la finalizara.
	public void cerrarSesion() {
		repre.getBtnCerrarSesión().addActionListener(new ListenerCerrarSesion(repre, login));
	}

}
