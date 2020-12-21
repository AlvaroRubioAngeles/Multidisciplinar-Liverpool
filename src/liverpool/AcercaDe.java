package liverpool;
/**
 * Clase AcercaDe
 * Descripci�n: Esta clase se usa para la informaci�n del software.
 * @author Gabriel Vizcaino S�nchez
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
	
	//M�todo acercaDe
	//Este m�todo da evento al bot�n acercaDe, que se encarga de dar informaci�n del software.
	public void acercaDe() {
		login.getBtnAcerca().addActionListener(new ListenerAcercaDe());
	}
	
}
