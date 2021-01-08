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
=======
package Cliente_Servidor;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import liverpool.Login;
import liverpool.VentanaError;

public class Cliente {
	private static DataOutputStream dataOut;
	private static DataInputStream dataIn;
	private static Login L;

	public static void main(String[] args) {
		Socket socket;
		try {
			socket = conectarServidor();
			// Creacion de los flujos de datos con el servidor
			dataOut = new DataOutputStream(socket.getOutputStream());
			dataIn = new DataInputStream(socket.getInputStream());
			
			// Instanciamiento de la ventana con la cual interactuara el usuario
			L = new Login();
			// Implementacion de listenner al boton para loggear
			L.getBtnInicio().addActionListener(new ListennerLogin(dataOut, dataIn, L));
		} catch (Exception e) {
			//Llamada a la ventana que muestra el error
			VentanaError ventana = new VentanaError("Error al conectar con el servidor");
		}
	}
/*
 * Método de conexion al servidor.
 */
	private static Socket conectarServidor() throws IOException{
		String host = "localhost";
		int puerto = 6000;
		Socket socket;
		socket = new Socket(host, puerto);
		return socket;
	}
}
