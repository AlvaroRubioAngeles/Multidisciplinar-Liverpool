package liverpool;
/**
 * Clase InicioSesionCorreo
 * Descripción: Esta clase se usa para inciar sesión en el correo del representante.
 * @author Gabriel Vizcaino Sánchez
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
