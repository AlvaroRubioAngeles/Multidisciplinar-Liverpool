package liverpool;

public class CerrarSesionCorreo {
	private Representante repre;
	
	public CerrarSesionCorreo(Representante repre) {
		this.repre = repre;
	}
	
	public void cerrarSesionCorreo() {
		repre.getBtnCerrar().addActionListener(new ListenerCerrarSesionCorreo(repre));
	}
}
