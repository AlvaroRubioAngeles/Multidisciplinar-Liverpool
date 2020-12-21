package liverpool;
/**
 * Clase AcercaDe
 * Descripción: Esta clase se usa para la información del software.
 * @author Gabriel Vizcaino Sánchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class AcercaDe {
	login login;
	
	/**
	 * Constructor parametrizado de la clase AcercaDe
	 * @param login - tipo JFrame login
	 */
	public AcercaDe(login login) {
		this.login = login;
	}
	
	//Método acercaDe
	//Este método da evento al botón acercaDe, que se encarga de dar información del software.
	public void acercaDe() {
		login.getBtnAcerca().addActionListener(new ListenerAcercaDe());
	}
	
}
