package Cliente_Servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import liverpool.Representante;
import liverpool.login;
import ventanaDirigente.Dirigente;

public class ListennerLogin implements ActionListener {
	private String nombreUsuario, pass;
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	private login L;

	public ListennerLogin(DataOutputStream dataOut, DataInputStream dataIn, login L) {
		this.dataOut = dataOut;
		this.dataIn = dataIn;
		this.L = L;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Obtencion de las credenciales introducidas por el usuario
		nombreUsuario = L.getTextUsuario().getText();
		pass = L.getTextPassword().getText();
		// Envio de credenciales al servidor en forma de una cadena de texto separada
		// por una barra de porcentaje.
		try {
			dataOut.writeUTF(nombreUsuario + "%" + pass + "%1");
			// Bucle que espera que el servidor le responda con la comprobacion de las
			// credenciales
			String tipoUsuario;
			while (true) {
				tipoUsuario = dataIn.readUTF();
				if (tipoUsuario.equals("Dirigente")) {
					// Mostrar nueva ventana
					L.hacerInvisible();
					Dirigente D = new Dirigente();
					break;
				} else if (tipoUsuario.equals("Representante")) {
					// Mostrar nueva ventana
					L.hacerInvisible();
					Representante R = new Representante();
					break;
				}
				else if (tipoUsuario.equals("*") | tipoUsuario.equals("")) {
					// Mostrar errores
					L.mostrarError();
					L.limpiarTextos();
					break;
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
