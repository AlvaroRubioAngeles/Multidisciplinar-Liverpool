package liverpool;
/**
 * Clase VerArchivos
 * Descripci�n: Esta clase se usa para ver los archivos subidos por el dirigente, por lo que le daremos evento
 * a dicho bot�n.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 17/12/2020
 */
public class VerArchivos {
	private Representante repre;
	/**
	 * Consturctor parametrizado de la clase VerArchivos
	 * @param repre - tipo JFrame Representante
	 */
	public VerArchivos(Representante repre) {
		this.repre = repre;
	}
	
	//M�todo verFichero
	//Este m�todo le da el evento al bot�n que gestionar� las acciones para ver los archivos subidos por el dirigente.
	public void verFicheros() {
		repre.getBtnVer().addActionListener(new ListenerVerFichero(repre));
	}
}
