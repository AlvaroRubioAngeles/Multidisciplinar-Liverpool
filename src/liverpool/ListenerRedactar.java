package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRedactar implements ActionListener {
	private Representante repre;
	
	public ListenerRedactar(Representante repre) {
		this.repre = repre;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repre.setVisible(false);
		RedactarCorreo redactar = new RedactarCorreo();

	}

}
