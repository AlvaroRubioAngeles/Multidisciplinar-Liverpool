package liverpool;

public class CancelarEnvioCorreo {
	Representante repre;
	RedactarCorreo redactar;
	
	public CancelarEnvioCorreo(Representante repre, RedactarCorreo redactar) {
		this.repre = repre;
		this.redactar = redactar;
	}
	
	public void cancelarEnvio() {
		redactar.getBtnCancelar().addActionListener(new ListenerCancelarEnvioCorreo(repre, redactar));
	}
}
