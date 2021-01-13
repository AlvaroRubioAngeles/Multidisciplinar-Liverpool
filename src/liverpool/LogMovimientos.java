package liverpool;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LogMovimientos {
	
	private Connection conexion;
	private Statement sentencia;
	
	public LogMovimientos(int codUsu, String nombreUsu, String tipoUsu) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.11.158/liverpool", "root", "");
			sentencia = (Statement) conexion.createStatement();
			
			try {
				ResultSet resul = sentencia.executeQuery("INSERT INTO movimientos VALUES ()");
				String tipo = "";
				while (resul.next()) {
					tipo = resul.getString(1);
					System.out.println(tipo);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
