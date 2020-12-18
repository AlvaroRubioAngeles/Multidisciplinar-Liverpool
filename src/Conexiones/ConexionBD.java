package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import liverpool.VentanaError;

public class ConexionBD {
	private Connection conexion;
	private Statement sentencia;

	public ConexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.11.158/liverpool", "Fran", "1");
			sentencia = conexion.createStatement();
		} catch (ClassNotFoundException e) {
			VentanaError ventana = new VentanaError("<html><body>Driver de conexión incorrecto<br>Contacte con el administrador del sistema</body></html>");
		} catch (SQLException e) {
			VentanaError ventana = new VentanaError("Error al conectar con la base de datos");
		}

	}

	// MÃ©todo que comprueba si los datos son correctos, devuelve un Booleano falso
	// si no existe ese usuario y verdadero si existe.
	public String comprobarNombrePass(String nombre, String pass) {
		try {
			System.out.println(nombre + " " + pass);
			ResultSet resul = sentencia.executeQuery("SELECT Tipo_usuario FROM usuarios WHERE Usuario LIKE '" + nombre
					+ "' AND Password LIKE '" + pass + "'");
			String tipo = "";
			while (resul.next()) {
				tipo = resul.getString(1);
				System.out.println(tipo);
			}
			return tipo;
		} catch (SQLException e) {
			//Usuario y contraseña no existen
			return "*";
		}
	}
}
