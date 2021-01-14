package ventanaDirigente;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import liverpool.VentanaError;
import liverpool.VentanaRenombre;
import liverpool.login;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.commons.net.ftp.FTPFile;

import Conexiones.ConexionFtp;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

public class Dirigente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String archivoSeleccionado, tipoArchivo;
	private ConexionFtp conexion;
	private JPanel contentPane;
	private JTextField nombre, apellido, correo, campoDestinatario, asunto;
	private JButton cerrarSesion;
	JTextArea mensaje;

	private ArrayList<JButton> botones;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Dirigente frame = new Dirigente();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Dirigente(login L) {

		setTitle("Dirigente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 720);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 51, 51));
		menuBar.setForeground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu crear = new JMenu("Mis Documentos");
		crear.setFont(new Font("Segoe UI", Font.BOLD, 18));
		crear.setForeground(Color.WHITE);
		crear.setBackground(new Color(240, 240, 240));
		menuBar.add(crear);

		JButton crearArchivo = new JButton("Mis Documentos");
		crearArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		crearArchivo.setForeground(Color.WHITE);
		crearArchivo.setBackground(new Color(255, 51, 0));
		crear.add(crearArchivo);

		JMenu borrar = new JMenu("Gestion de Usuarios");
		borrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		borrar.setBackground(Color.RED);
		borrar.setForeground(Color.WHITE);
		menuBar.add(borrar);

		JButton borrarUsuario = new JButton("Gestion Usuario");
		borrarUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		borrarUsuario.setForeground(Color.WHITE);
		borrarUsuario.setBackground(new Color(255, 51, 51));
		borrar.add(borrarUsuario);

		JMenu correoMenu = new JMenu("Correo");
		correoMenu.setBackground(new Color(255, 51, 51));
		correoMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		correoMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(correoMenu);

		JButton enviarCorreoBtn = new JButton("Enviar Correo");
		correoMenu.add(enviarCorreoBtn);

		JMenu logout = new JMenu("Cerrar Sesi\u00F3n");
		logout.setFont(new Font("Segoe UI", Font.BOLD, 18));
		logout.setForeground(Color.WHITE);
		menuBar.add(logout);

		cerrarSesion = new JButton("Salir");
		cerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cerrarSesion.setForeground(new Color(255, 255, 255));
		cerrarSesion.setBackground(new Color(255, 51, 51));
		logout.add(cerrarSesion);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contenido = new JPanel();
		contenido.setBounds(15, 16, 995, 629);
		contentPane.add(contenido);
		contenido.setVisible(false);
		contenido.setLayout(null);

		JPanel creacionArchivo = new JPanel();
		creacionArchivo.setBackground(new Color(255, 51, 51));
		creacionArchivo.setBounds(0, 0, 995, 628);
		contenido.add(creacionArchivo);
		creacionArchivo.setLayout(null);

		JFileChooser fileArchivo = new JFileChooser();
		fileArchivo.setBounds(15, 67, 390, 548);
		creacionArchivo.add(fileArchivo);
		fileArchivo.setForeground(new Color(255, 255, 255));
		fileArchivo.setBackground(new Color(255, 255, 255));

		JLabel lblNewLabel_10 = new JLabel("Servidor FTP");
		lblNewLabel_10.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(500, 13, 258, 50);
		creacionArchivo.add(lblNewLabel_10);

		JLabel lblNewLabel_9 = new JLabel("Archivos Locales");
		lblNewLabel_9.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(40, 13, 333, 50);
		creacionArchivo.add(lblNewLabel_9);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(15, 67, 390, 548);
		creacionArchivo.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane ListadoFtp = new JScrollPane();
		ListadoFtp.setBounds(447, 67, 371, 548);
		creacionArchivo.add(ListadoFtp);

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Nombre");
		model.addColumn("Tipo");
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		ListadoFtp.setViewportView(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		JButton botonDescargar = new JButton("Descargar");

		botonDescargar.setBackground(new Color(255, 255, 255));
		botonDescargar.setForeground(Color.BLACK);
		botonDescargar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonDescargar.setBounds(830, 502, 153, 50);
		creacionArchivo.add(botonDescargar);

		JButton botonSubir = new JButton("Subir");
		botonSubir.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonSubir.setForeground(Color.BLACK);
		botonSubir.setBounds(830, 565, 153, 50);
		creacionArchivo.add(botonSubir);

		JButton botonAcceder = new JButton("Acceder");
		botonAcceder.setActionCommand("Acceder");
		botonAcceder.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonAcceder.setEnabled(false);
		botonAcceder.setBounds(830, 67, 153, 55);
		creacionArchivo.add(botonAcceder);

		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonBorrar.setBounds(830, 378, 153, 50);
		creacionArchivo.add(botonBorrar);

		JButton botonVolver = new JButton("Volver Atrás");
		botonVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonVolver.setBounds(830, 135, 155, 61);
		creacionArchivo.add(botonVolver);

		JButton botonCrear = new JButton("Crear");
		botonCrear.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonCrear.setBounds(830, 317, 153, 50);
		creacionArchivo.add(botonCrear);

		JButton botonRenombrar = new JButton("Renombrar");
		botonRenombrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonRenombrar.setBounds(830, 439, 153, 50);
		creacionArchivo.add(botonRenombrar);
		creacionArchivo.setVisible(false);

		JPanel envioCorreos = new JPanel();
		envioCorreos.setBackground(new Color(255, 51, 51));
		envioCorreos.setBounds(0, 0, 995, 628);
		contenido.add(envioCorreos);
		envioCorreos.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Destinatario: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setMinimumSize(new Dimension(82, 16));
		lblNewLabel_6.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(12, 13, 165, 65);
		envioCorreos.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Asunto:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(12, 91, 165, 64);
		envioCorreos.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Mensaje:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		lblNewLabel_8.setBounds(12, 168, 165, 64);
		envioCorreos.add(lblNewLabel_8);

		campoDestinatario = new JTextField();
		campoDestinatario.setBounds(199, 13, 645, 65);
		envioCorreos.add(campoDestinatario);
		campoDestinatario.setColumns(10);

		mensaje = new JTextArea();
		mensaje.setBounds(12, 245, 832, 370);
		envioCorreos.add(mensaje);

		asunto = new JTextField();
		asunto.setBounds(199, 95, 645, 60);
		envioCorreos.add(asunto);
		asunto.setColumns(10);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setActionCommand("Enviar");
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnNewButton.setBounds(882, 563, 101, 52);
		envioCorreos.add(btnNewButton);

		JPanel creacionUsuario = new JPanel();
		creacionUsuario.setBackground(new Color(255, 51, 51));
		creacionUsuario.setBounds(0, 0, 556, 387);
		contenido.add(creacionUsuario);
		creacionUsuario.setLayout(null);
		creacionUsuario.setVisible(false);

		JLabel label = new JLabel("Nombre: ");
		label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label.setForeground(new Color(255, 51, 51));
		label.setBounds(39, 30, 78, 20);
		creacionUsuario.add(label);

		nombre = new JTextField();
		nombre.setBounds(132, 28, 214, 26);
		creacionUsuario.add(nombre);
		nombre.setColumns(10);

		JLabel lblNewLabel = new JLabel("Apellido:");
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(38, 70, 69, 20);
		creacionUsuario.add(lblNewLabel);

		apellido = new JTextField();
		apellido.setBounds(132, 67, 214, 26);
		creacionUsuario.add(apellido);
		apellido.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tipo Usuario:");
		lblNewLabel_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(38, 106, 133, 20);
		creacionUsuario.add(lblNewLabel_1);

		JSpinner tipoUsu = new JSpinner();
		tipoUsu.setModel(new SpinnerListModel(new String[] { "Representante", "Dirigente" }));
		tipoUsu.setBounds(176, 103, 170, 26);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) tipoUsu.getEditor()).getTextField();
		tf.setEditable(false);
		creacionUsuario.add(tipoUsu);

		JLabel lblNewLabel_2 = new JLabel("Correo:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(255, 51, 51));
		lblNewLabel_2.setBounds(39, 142, 69, 20);
		creacionUsuario.add(lblNewLabel_2);

		correo = new JTextField();
		correo.setBounds(132, 139, 214, 26);
		creacionUsuario.add(correo);
		correo.setColumns(10);

		JButton crearUsu = new JButton("Crear");

		crearUsu = new JButton("Crear");

		crearUsu.setBackground(new Color(255, 255, 255));
		crearUsu.setForeground(new Color(255, 51, 51));
		crearUsu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		crearUsu.setBounds(382, 19, 159, 43);
		creacionUsuario.add(crearUsu);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(15, 16, 352, 355);
		creacionUsuario.add(panel);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Dirigente.class.getResource("/image/despachoC.jpg")));
		fondo.setBounds(0, 0, 1024, 658);
		contentPane.add(fondo);

		botonAcceder.setEnabled(false);
		botonSubir.setEnabled(true);
		botonRenombrar.setEnabled(false);
		botonDescargar.setEnabled(false);
		botonBorrar.setEnabled(false);

		setVisible(true);

		crearArchivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionUsuario.setVisible(false);
				envioCorreos.setVisible(false);
				contenido.setVisible(true);
				creacionArchivo.setVisible(true);
				vaciarTextos();
				conexion = new ConexionFtp();
				conexion.conectarServidor();
				conexion.iniciarSesion(L.getTextUsuario().getText(), L.getTextPassword().getText());
				obtenerListadoArchivos(model, "/");
			}

		});

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				if (row >= 0) {
					if (table.getValueAt(row, 1).equals("Directorio")) {
						botonAcceder.setEnabled(true);
						botonRenombrar.setEnabled(false);
						botonSubir.setEnabled(false);
						botonDescargar.setEnabled(false);
					} else if (table.getValueAt(row, 1).equals("Fichero")) {
						botonAcceder.setEnabled(false);
						botonRenombrar.setEnabled(true);
						botonDescargar.setEnabled(true);
						botonBorrar.setEnabled(true);
					} else {
						botonSubir.setEnabled(false);
						botonBorrar.setEnabled(false);
						botonDescargar.setEnabled(false);
						botonRenombrar.setEnabled(false);
						botonAcceder.setEnabled(false);
					}
					archivoSeleccionado = (String) table.getValueAt(row, 0);
					tipoArchivo = (String) table.getValueAt(row, 1);
				}
			}
		});
		
		botonCrear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botonAcceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obtenerListadoArchivos(model, "" + conexion.obtenerDireccionActual() + "/" + archivoSeleccionado);
			}
		});
		botonSubir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File fichero = fileArchivo.getSelectedFile();
					conexion.subirArchivo(fichero);
					obtenerListadoArchivos(model, conexion.obtenerDireccionActual());
				} catch (Exception e2) {
					VentanaError errorSubir = new VentanaError(
							"No ha seleccionado ningun fichero o ha seleccionado una carpeta");
				}

			}
		});

		borrarUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionArchivo.setVisible(false);
				creacionUsuario.setVisible(false);
				envioCorreos.setVisible(false);
				contenido.setVisible(true);
				vaciarTextos();
			}
		});
		enviarCorreoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionArchivo.setVisible(false);
				creacionUsuario.setVisible(false);
				contenido.setVisible(false);
				contenido.setVisible(true);
				envioCorreos.setVisible(true);
				vaciarTextos();
			}
		});
		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				L.limpiarTextos();
				L.setVisible(true);
				conexion.desconectarServidor();
				dispose();
			}
		});

		botonVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion.volverAtras();
				obtenerListadoArchivos(model, conexion.obtenerDireccionActual());
			}
		});

		botonDescargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion.descargarArchivo(
						fileArchivo.getCurrentDirectory().getAbsolutePath() + "/" + archivoSeleccionado,
						archivoSeleccionado);
				fileArchivo.updateUI();
			}
		});

		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (conexion.borrar(tipoArchivo, conexion.obtenerDireccionActual() + "/" + archivoSeleccionado)) {
					System.out.println("Atchivo borrado correctamente");
				} else {
					System.out.println("Error al borrar");
				}
				obtenerListadoArchivos(model, conexion.obtenerDireccionActual());
			}
		});
		botonRenombrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRenombre ventanaRenombre = new VentanaRenombre(conexion, archivoSeleccionado);
				ventanaRenombre.addWindowListener(new WindowListener() {
					@Override
					public void windowClosed(WindowEvent e) {
						obtenerListadoArchivos(model, conexion.obtenerDireccionActual());
					}
				});
			}
		});

		setResizable(false);
	}

	private void vaciarTextos() {
		nombre.setText("");
		apellido.setText("");
		correo.setText("");
		asunto.setText("");
		campoDestinatario.setText("");
		mensaje.setText("");
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}

	public void obtenerListadoArchivos(DefaultTableModel model, String ruta) {
		FTPFile[] listado = conexion.obtenerListado(ruta);
		int rows = model.getRowCount() - 1;
		for (int i = rows; i >= 0; i--) {
			model.removeRow(model.getRowCount() - 1);
		}
		String tipo;
		for (int i = 0; i < listado.length; i++) {
			if (listado[i].getType() == 0) {
				tipo = "Fichero";
			} else if (listado[i].getType() == 1) {
				tipo = "Directorio";
			} else {
				tipo = "Desconocido";
			}
			model.addRow(new Object[] { listado[i].getName(), tipo });
		}
		conexion.cambiarDirectoriO(ruta);
	}
}
