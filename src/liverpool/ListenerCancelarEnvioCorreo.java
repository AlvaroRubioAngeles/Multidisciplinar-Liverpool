package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerCancelarEnvioCorreo implements ActionListener {
	private Representante repre;
	private RedactarCorreo redactar;
	
	public ListenerCancelarEnvioCorreo(Representante repre, RedactarCorreo redactar) {
		this.repre = repre;
		this.redactar = redactar;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		redactar.dispose();
		repre.setVisible(true);
	}

}
