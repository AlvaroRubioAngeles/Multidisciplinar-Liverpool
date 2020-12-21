package liverpool;
/**
 * Clase VerArchivos
 * Descripción: Esta clase se usa para ver los archivos subidos por el dirigente, por lo que le daremos evento
 * a dicho botón.
 * @author Gabriel Vizcaino Sánchez
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
	
	//Método verFichero
	//Este método le da el evento al botón que gestionará las acciones para ver los archivos subidos por el dirigente.
	public void verFicheros() {
		repre.getBtnVer().addActionListener(new ListenerVerFichero(repre));
	}
}
