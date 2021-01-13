package liverpool;

public class CancelarInicioSesion {
	private Representante repre;
	
	public CancelarInicioSesion(Representante repre) {
		this.repre = repre;
	}
	
	public void cancelarOperacion() {
		repre.getBtnCancelar().addActionListener(new ListenerCancelarInicio(repre));
	}
}
