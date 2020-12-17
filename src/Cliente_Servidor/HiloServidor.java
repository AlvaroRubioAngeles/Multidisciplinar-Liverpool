package Cliente_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Conexiones.ConexionBD;
import Tuberia.Tuberia;

public class HiloServidor extends Thread {
	private Tuberia tuberia;
	private Socket socket;

	public HiloServidor(Tuberia tuberia, Socket socket) {
		super();
		this.tuberia = tuberia;
		this.socket = socket;
	}

	public void run() {
		ConexionBD C = new ConexionBD();// Conexion a la base de datos MySql
		try {
			// Creacion de los flujos de datos
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			/*
			 * Bucle que espera a que el usuario envie sus credenciales para comprobarlas
			 */
			while (true) {
				String recibido = "";
				recibido = dataIn.readUTF();
				if (recibido.substring(recibido.lastIndexOf("%") + 1).equals("1")) {
					String nombre = recibido.substring(0, recibido.indexOf("%"));
					String pass = recibido.substring(recibido.indexOf("%") + 1, recibido.lastIndexOf("%"));
					String tipoUsuario = C.comprobarNombrePass(nombre, pass);
					if (!tipoUsuario.equals("*") | !tipoUsuario.equals("")) {// Comprobacion de credenciales en la base
																				// de datos MySql
						dataOut.writeUTF(tipoUsuario);
					} else if (tipoUsuario == "*") {
						dataOut.writeUTF("*");
					}
				}
				else if (recibido.substring(recibido.lastIndexOf("%") + 1).equals("2")) {
					
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
