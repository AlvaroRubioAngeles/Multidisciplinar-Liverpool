package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private Connection conexion;
	private Statement sentencia;

	public ConexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://25.74.69.11/liverpool", "Fran", "1");
			sentencia = conexion.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Método que comprueba si los datos son correctos, devuelve un Booleano falso
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "*";
		}
	}
}
