package Cliente_Servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import liverpool.login;
import ventanaDirigente.Dirigente;

public class ListenerDirigente implements ActionListener{

	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	private login l;
	private Dirigente d;
	
	public ListenerDirigente(DataOutputStream dataOut, DataInputStream dataIn, Dirigente d, login l) {
		super();
		this.dataOut = dataOut;
		this.dataIn = dataIn;
		this.d = d;
		this.l = l;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}
