package liverpool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cliente_Servidor.Cliente;
import Conexiones.ConexionFtp;
import ventanaDirigente.Dirigente;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import ventanaDirigente.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRenombre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConexionFtp conexion;
	private JPanel contentPane;
	private JTextField nombreCampo;
	private JLabel nombre;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { VentanaRenombre frame = new
	 * VentanaRenombre(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRenombre(ConexionFtp conexion, String nombreActualString) {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.conexion = conexion;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelArriba = new JPanel();
		panelArriba.setBackground(new Color(255, 255, 255));
		panelArriba.setBounds(15, 16, 398, 111);
		contentPane.add(panelArriba);
		panelArriba.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre actual:");
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(15, 16, 368, 20);
		panelArriba.add(lblNewLabel);

		JLabel nombreActual = new JLabel(nombreActualString);
		nombreActual.setFont(new Font("Segoe UI", Font.BOLD, 18));
		nombreActual.setForeground(new Color(255, 51, 51));
		nombreActual.setBounds(25, 59, 336, 20);
		panelArriba.add(nombreActual);

		JPanel panelAbajo = new JPanel();
		panelAbajo.setBackground(new Color(255, 255, 255));
		panelAbajo.setBounds(15, 134, 291, 94);
		contentPane.add(panelAbajo);
		panelAbajo.setLayout(null);

		nombre = new JLabel("Cambiar a:");
		nombre.setForeground(new Color(255, 51, 51));
		nombre.setBounds(15, 16, 99, 25);
		nombre.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelAbajo.add(nombre);

		nombreCampo = new JTextField();
		nombreCampo.setBounds(15, 52, 261, 26);
		panelAbajo.add(nombreCampo);
		nombreCampo.setColumns(10);

		JButton btnRenombrar = new JButton("Rename");
		btnRenombrar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnRenombrar.setForeground(new Color(255, 51, 51));
		btnRenombrar.setBackground(new Color(255, 255, 255));
		btnRenombrar.setBounds(313, 133, 100, 46);
		contentPane.add(btnRenombrar);
		btnRenombrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion.renombrarDocumento(conexion.obtenerDireccionActual() + "/" + nombreActualString,
						conexion.obtenerDireccionActual() + "/" + getNombre());
				dispose();
			}
		});

		JButton btnCancelar = new JButton("Cancel");
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCancelar.setForeground(new Color(255, 51, 51));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(313, 184, 100, 44);
		contentPane.add(btnCancelar);

		setVisible(true);
	}

	public String getNombre() {
		return nombreCampo.getText();
	}
}
