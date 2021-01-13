package liverpool;

public class EnviarCorreo {
	private RedactarCorreo redactar;
	private Representante repre;
	
	public EnviarCorreo(RedactarCorreo redactar, Representante repre) {
		this.redactar = redactar;
		this.repre = repre;
	}
	
	public void envioCorreo() {
		redactar.getBtnEnviar().addActionListener(new ListenerEnviarCorreo(redactar, repre));
	}
}
