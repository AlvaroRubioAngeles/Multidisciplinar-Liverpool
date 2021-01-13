package liverpool;

public class OperacionRedactarCorreo {
	private Representante repre;
	
	public OperacionRedactarCorreo(Representante repre) {
		this.repre = repre;
	}
	
	public void redactarCorreoRepresentante() {
		repre.getBtnRedactar().addActionListener(new ListenerRedactar(repre));
	}
}
