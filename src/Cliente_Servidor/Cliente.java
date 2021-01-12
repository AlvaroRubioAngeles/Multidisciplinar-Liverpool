package Cliente_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import liverpool.login;

public class Cliente {
	private static DataOutputStream dataOut;
	private static DataInputStream dataIn;
	private static login L;

	public static void main(String[] args) {
		Socket socket;
		try {
			socket = conectarServidor();
			// Creacion de los flujos de datos con el servidor
			dataOut = new DataOutputStream(socket.getOutputStream());
			dataIn = new DataInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Instanciamiento de la ventana con la cual interactuara el usuario
		L = new login();
		// Implementacion de listenner al boton para loggear
		L.getBtnInicio().addActionListener(new ListennerLogin(dataOut, dataIn, L));
	}
/*
 * Método de conexion al servidor.
 */
	private static Socket conectarServidor(){
		String host = "localhost";
		int puerto = 6000;
		Socket socket;
		try {
			socket = new Socket(host, puerto);
			return socket;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
