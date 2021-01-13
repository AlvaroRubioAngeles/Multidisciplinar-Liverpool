package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerInicioSesionCorreo implements ActionListener {
	private Representante repre;
	
	public ListenerInicioSesionCorreo(Representante repre) {
		this.repre = repre;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repre.getPanel_7().setVisible(false);
		repre.getPanel_4().setVisible(true);
	}

}
