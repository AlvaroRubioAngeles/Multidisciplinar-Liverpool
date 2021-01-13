package liverpool;
/**
 * Clase InicioSesionCorreo
 * Descripci�n: Esta clase se usa para inciar sesi�n en el correo del representante.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 13/01/2021
 */
public class InicioSesionCorreo {
	private Representante repre;
	
	public InicioSesionCorreo(Representante repre) {
		this.repre = repre;
	}
	
	public void inicioSesionRepresentante() {
		repre.getBtnIniciarSesion().addActionListener(new ListenerInicioSesionCorreo(repre));
	}
}
