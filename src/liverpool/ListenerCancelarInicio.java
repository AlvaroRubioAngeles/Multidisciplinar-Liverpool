package liverpool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerCancelarInicio implements ActionListener {
	private Representante repre;
	
	public ListenerCancelarInicio(Representante repre) {
		this.repre = repre;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repre.getPanel_7().setVisible(false);
		repre.getLblEscudo().setVisible(true);
	}

}
