package Conexiones;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class ConexionFtp {
	private String servFTP = "localhost";
	FTPClient ClienteFtp;

	public void conectarServidor() {
		ClienteFtp = new FTPClient();
		System.out.println("Conectando a " + servFTP);
		try {
			ClienteFtp.connect(servFTP);
			System.out.println(ClienteFtp.getReplyString());
			int respuesta = ClienteFtp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(respuesta)) {
				ClienteFtp.disconnect();
				System.out.println("Conexion rechazada: " + respuesta);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void desconectarServidor() {
		try {
			ClienteFtp.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciarSesion(String nombre, String passwd) {
		try {
			ClienteFtp.login(nombre, passwd);
			System.out.println(ClienteFtp.getReplyString());
			int respuesta = ClienteFtp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(respuesta)) {
				ClienteFtp.disconnect();
				System.out.println("Conexion rechazada: " + respuesta);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FTPFile[] obtenerListado(String ruta) {
		FTPFile[] ficheros = null;
		try {
			ficheros = ClienteFtp.listFiles(ruta);
			System.out.println(ClienteFtp.printWorkingDirectory());
			for (int i = 0; i < ficheros.length; i++) {
				System.out.println(ficheros[i].getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ficheros;
	}

	public String obtenerDireccionActual() {
		try {
			String ruta = ClienteFtp.printWorkingDirectory();
			System.out.println(ruta);
			return ruta;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	public void cambiarDirectoriO(String ruta) {
		try {
			ClienteFtp.changeWorkingDirectory(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void volverAtras() {
		try {
			ClienteFtp.changeToParentDirectory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void subirArchivo(File fichero) {
		BufferedInputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(fichero));
			ClienteFtp.storeFile(fichero.getName(), in);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void descargarArchivo(String ruta, String archivoSeleccionado) {
		BufferedOutputStream out;
		try {
			out = new BufferedOutputStream(new FileOutputStream(ruta));
			if (ClienteFtp.retrieveFile(archivoSeleccionado, out)) {
				System.out.println("SI");
			}
			else {
				System.out.println("no");
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void renombrarDocumento(String ruta, String nuevoNombre) {
		try {
			System.out.println(ruta + "    " + nuevoNombre);
			ClienteFtp.rename(ruta, nuevoNombre);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearCarpeta(String ruta) {
		try {
			ClienteFtp.makeDirectory(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean borrar(String tipo, String ruta) {
		try {
			if (tipo.equals("Directorio")) {
				return ClienteFtp.removeDirectory(ruta);
			}
			else if (tipo.equals("Fichero")) {
				ClienteFtp.deleteFile(ruta);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
