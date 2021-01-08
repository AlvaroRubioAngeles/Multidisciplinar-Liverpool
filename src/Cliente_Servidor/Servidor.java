package Cliente_Servidor;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Tuberia.Tuberia;
import liverpool.VentanaError;

public class Servidor {

	public static void main(String[] args) {
		//Definicion de variables de clase, que se usaran posteriormente
		Tuberia tuberia = new Tuberia();
		ServerSocket servidor;
		DataInputStream dataIn;
		try {
			//Inicio del servidor.
			servidor = new ServerSocket(6000);
			System.out.println("Servidor iniciado en el puerto: " + servidor.getLocalPort());
			//Bucle que atiende a las solicitudes de los clientes al servidor para establecer la comunicacion.
			while (true) {
				Socket cliente = servidor.accept();
				System.out.println("Conexion entrante desde: " + cliente.getInetAddress());
				HiloServidor Hilo = new HiloServidor(tuberia, cliente);//Creacion de un hilo que atendera al cliente
				Hilo.start();
			}
		} catch (Exception e) {
			VentanaError ventana = new VentanaError("Servidor ya en uso");
		}
	}

}
