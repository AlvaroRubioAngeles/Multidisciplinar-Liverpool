package Cliente_Servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import liverpool.Representante;
import liverpool.CerrarSesion;
import liverpool.Correo;
import liverpool.CrearContrato;
import liverpool.VerArchivos;
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
					Dirigente D = new Dirigente(L);
					/*
					for (int i = 0; i < D.getBotones().size(); i++) {
						D.getBotones().get(i).addActionListener(new ListenerDirigente(dataOut, dataIn, D, L));
					}
					*/
					break;
				} else if (tipoUsuario.equals("Representante")) {
					// Mostrar nueva ventana
					L.hacerInvisible();
					L.limpiarTextos();
					Representante R = new Representante(nombreUsuario,pass);
					CerrarSesion CloseSesion = new CerrarSesion(R, L);
					CloseSesion.cerrarSesion();
					Correo correo = new Correo(R);
					correo.correoRepresentante();
					CrearContrato crearContrato = new CrearContrato(R);
					crearContrato.botonCrearContrato();
					VerArchivos Verfich = new VerArchivos(R);
					Verfich.verFicheros();
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
