package ventanaDirigente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerListModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class Dirigente extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField correo;
	private JTextField nomUsuarioB;
	private JTextField nomArchivoB;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dirigente frame = new Dirigente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dirigente() {
		setTitle("Dirigente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 506);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 51, 51));
		menuBar.setForeground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu crear = new JMenu("Crear");
		crear.setFont(new Font("Segoe UI", Font.BOLD, 18));
		crear.setForeground(Color.WHITE);
		crear.setBackground(new Color(240, 240, 240));
		menuBar.add(crear);

		JButton crearUsuario = new JButton("Crear Usuario");
		crearUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		crearUsuario.setForeground(Color.WHITE);
		crearUsuario.setBackground(new Color(255, 51, 51));
		crear.add(crearUsuario);

		JButton crearFichero = new JButton("Crear Fichero");
		crearFichero.setFont(new Font("Segoe UI", Font.BOLD, 16));
		crearFichero.setForeground(Color.WHITE);
		crearFichero.setBackground(new Color(255, 51, 51));
		crear.add(crearFichero);

		JButton crearArchivo = new JButton("Crear Archivo");
		crearArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		crearArchivo.setForeground(Color.WHITE);
		crearArchivo.setBackground(new Color(255, 51, 0));
		crear.add(crearArchivo);

		JMenu borrar = new JMenu("Borrar");
		borrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		borrar.setBackground(Color.RED);
		borrar.setForeground(Color.WHITE);
		menuBar.add(borrar);

		JButton borrarUsuario = new JButton("Borrar Usuario");
		borrarUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		borrarUsuario.setForeground(Color.WHITE);
		borrarUsuario.setBackground(new Color(255, 51, 51));
		borrar.add(borrarUsuario);

		JButton borrarArchivo = new JButton("Borrar Archivo");
		borrarArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		borrarArchivo.setBackground(new Color(255, 51, 51));
		borrarArchivo.setForeground(Color.WHITE);
		borrar.add(borrarArchivo);

		JMenu correoMenu = new JMenu("Correo");
		correoMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		correoMenu.setForeground(Color.WHITE);
		menuBar.add(correoMenu);
		
		JButton botonCorreo = new JButton("Correo");
		botonCorreo.setBackground(new Color(255, 51, 51));
		botonCorreo.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		botonCorreo.setForeground(new Color(255, 255, 255));
		correoMenu.add(botonCorreo);

		JMenu logout = new JMenu("Cerrar Sesi\u00F3n");
		logout.setFont(new Font("Segoe UI", Font.BOLD, 18));
		logout.setForeground(Color.WHITE);
		menuBar.add(logout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contenido = new JPanel();
		contenido.setBounds(15, 16, 575, 415);
		contentPane.add(contenido);
		contenido.setVisible(false);
		contenido.setLayout(null);

		JPanel Smtp = new JPanel();
		Smtp.setBackground(new Color(255, 51, 51));
		Smtp.setBounds(0, 0, 575, 415);
		contenido.add(Smtp);
		Smtp.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(12, 13, 418, 389);
		Smtp.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblDirecionMail = new JLabel("Direcion Mail:");
		lblDirecionMail.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		lblDirecionMail.setForeground(new Color(255, 51, 0));
		lblDirecionMail.setBounds(12, 13, 90, 21);
		panel_5.add(lblDirecionMail);

		JLabel lblNewLabel_6 = new JLabel("Asunto:");
		lblNewLabel_6.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		lblNewLabel_6.setForeground(new Color(255, 51, 0));
		lblNewLabel_6.setBounds(12, 54, 62, 21);
		panel_5.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Mensaje:");
		lblNewLabel_7.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		lblNewLabel_7.setForeground(new Color(255, 51, 0));
		lblNewLabel_7.setBounds(12, 95, 63, 25);
		panel_5.add(lblNewLabel_7);

		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		textField.setBounds(125, 10, 281, 24);
		panel_5.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		textField_1.setBounds(102, 54, 304, 21);
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		textArea.setBounds(12, 129, 394, 247);
		panel_5.add(textArea);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Dirigente.class.getResource("/image/escudo.png")));
		lblNewLabel_8.setBounds(463, 13, 100, 110);
		Smtp.add(lblNewLabel_8);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setForeground(new Color(255, 51, 51));
		btnNewButton.setBounds(458, 368, 105, 34);
		Smtp.add(btnNewButton);

		JPanel creacionFichero = new JPanel();
		creacionFichero.setBackground(new Color(255, 51, 51));
		creacionFichero.setBounds(0, 0, 575, 415);
		contenido.add(creacionFichero);
		creacionFichero.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(15, 16, 357, 355);
		creacionFichero.add(panel_3);
		panel_3.setLayout(null);

		JFileChooser fileFichero = new JFileChooser();
		fileFichero.setBounds(0, 0, 357, 355);
		panel_3.add(fileFichero);

		JButton btnCrearFichero = new JButton("Crear");
		btnCrearFichero.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCrearFichero.setBackground(new Color(255, 255, 255));
		btnCrearFichero.setForeground(new Color(255, 51, 51));
		btnCrearFichero.setBounds(388, 16, 153, 41);
		creacionFichero.add(btnCrearFichero);
		creacionFichero.setVisible(false);

		JPanel creacionArchivo = new JPanel();
		creacionArchivo.setBackground(new Color(255, 51, 51));
		creacionArchivo.setBounds(0, 0, 575, 415);
		contenido.add(creacionArchivo);
		creacionArchivo.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(15, 16, 355, 355);
		creacionArchivo.add(panel_4);
		panel_4.setLayout(null);

		JFileChooser fileArchivo = new JFileChooser();
		fileArchivo.setForeground(new Color(255, 255, 255));
		fileArchivo.setBackground(new Color(255, 255, 255));
		fileArchivo.setBounds(0, 0, 355, 355);
		panel_4.add(fileArchivo);

		JButton btnCrearArchivo = new JButton("Crear");
		btnCrearArchivo.setBackground(new Color(255, 255, 255));
		btnCrearArchivo.setForeground(new Color(255, 51, 102));
		btnCrearArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCrearArchivo.setBounds(388, 16, 153, 41);
		creacionArchivo.add(btnCrearArchivo);
		creacionArchivo.setVisible(false);

		JPanel borradoArchivo = new JPanel();
		borradoArchivo.setBackground(new Color(255, 51, 51));
		borradoArchivo.setBounds(0, 0, 575, 415);
		contenido.add(borradoArchivo);
		borradoArchivo.setLayout(null);
		borradoArchivo.setVisible(false);

		JLabel lblquArchivoDesea = new JLabel("\u00BFQu\u00E9 archivo desea eliminar?");
		lblquArchivoDesea.setForeground(new Color(153, 204, 204));
		lblquArchivoDesea.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblquArchivoDesea.setBounds(36, 33, 281, 20);
		borradoArchivo.add(lblquArchivoDesea);

		JLabel lblNewLabel_5 = new JLabel("Nombre Archivo: ");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_5.setForeground(new Color(255, 51, 51));
		lblNewLabel_5.setBounds(40, 72, 171, 34);
		borradoArchivo.add(lblNewLabel_5);

		nomArchivoB = new JTextField();
		nomArchivoB.setBounds(182, 80, 204, 26);
		borradoArchivo.add(nomArchivoB);
		nomArchivoB.setColumns(10);

		JButton btnBorrarArchivo = new JButton("Eliminar");
		btnBorrarArchivo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBorrarArchivo.setBackground(new Color(255, 255, 255));
		btnBorrarArchivo.setForeground(new Color(255, 51, 51));
		btnBorrarArchivo.setBounds(398, 72, 115, 34);
		borradoArchivo.add(btnBorrarArchivo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 150, 526, 221);
		borradoArchivo.add(scrollPane);

		JList listaEliminar = new JList();
		listaEliminar.setForeground(new Color(255, 51, 51));
		scrollPane.setViewportView(listaEliminar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(15, 16, 526, 118);
		borradoArchivo.add(panel_1);

		JPanel borradoUsuario = new JPanel();
		borradoUsuario.setBackground(new Color(255, 51, 51));
		borradoUsuario.setBounds(0, 0, 575, 415);
		contenido.add(borradoUsuario);
		borradoUsuario.setLayout(null);
		borradoUsuario.setVisible(false);

		JLabel lblNewLabel_3 = new JLabel("\u00BFQu\u00E9 usuario desea dar de baja?");
		lblNewLabel_3.setForeground(new Color(153, 204, 204));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(33, 34, 281, 20);
		borradoUsuario.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Usuario:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(255, 51, 51));
		lblNewLabel_4.setBounds(42, 79, 98, 20);
		borradoUsuario.add(lblNewLabel_4);

		nomUsuarioB = new JTextField();
		nomUsuarioB.setText("");
		nomUsuarioB.setBounds(117, 77, 275, 26);
		borradoUsuario.add(nomUsuarioB);
		nomUsuarioB.setColumns(10);

		JButton btnBorrarUsuario = new JButton("Dar de Baja");
		btnBorrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBorrarUsuario.setBackground(new Color(255, 255, 255));
		btnBorrarUsuario.setForeground(new Color(255, 51, 51));
		btnBorrarUsuario.setBounds(400, 71, 115, 34);
		borradoUsuario.add(btnBorrarUsuario);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 149, 526, 222);
		borradoUsuario.add(scrollPane_1);

		JList listaUsuario = new JList();
		scrollPane_1.setViewportView(listaUsuario);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(15, 16, 526, 116);
		borradoUsuario.add(panel_2);

		JPanel creacionUsuario = new JPanel();
		creacionUsuario.setBackground(new Color(255, 51, 51));
		creacionUsuario.setBounds(0, 0, 575, 415);
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
		crearUsu.setBackground(new Color(255, 255, 255));
		crearUsu.setForeground(new Color(255, 51, 51));
		crearUsu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		crearUsu.setBounds(382, 19, 159, 43);
		creacionUsuario.add(crearUsu);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(15, 16, 352, 355);
		creacionUsuario.add(panel);

		JLabel fondo = new JLabel("New label");
		fondo.setIcon(new ImageIcon("C:/Users/fran5/git/Multidisciplinar-Liverpool/src/image/despachoC.jpg"));
		fondo.setBounds(0, 0, 603, 510);
		contentPane.add(fondo);

		setVisible(true);

		botonCorreo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionUsuario.setVisible(false);
				creacionArchivo.setVisible(false);
				borradoArchivo.setVisible(false);
				borradoUsuario.setVisible(false);
				creacionFichero.setVisible(false);
				contenido.setVisible(true);
				Smtp.setVisible(true);

			}
		});

		crearFichero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionUsuario.setVisible(false);
				creacionArchivo.setVisible(false);
				borradoArchivo.setVisible(false);
				borradoUsuario.setVisible(false);
				Smtp.setVisible(false);
				contenido.setVisible(true);
				creacionFichero.setVisible(true);

			}
		});

		crearUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionFichero.setVisible(false);
				creacionArchivo.setVisible(false);
				borradoArchivo.setVisible(false);
				borradoUsuario.setVisible(false);
				Smtp.setVisible(false);
				contenido.setVisible(true);
				creacionUsuario.setVisible(true);

			}
		});

		crearArchivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionFichero.setVisible(false);
				creacionUsuario.setVisible(false);
				borradoUsuario.setVisible(false);
				borradoArchivo.setVisible(false);
				Smtp.setVisible(false);
				contenido.setVisible(true);
				creacionArchivo.setVisible(true);

			}
		});

		borrarUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionArchivo.setVisible(false);
				creacionFichero.setVisible(false);
				creacionUsuario.setVisible(false);
				borradoArchivo.setVisible(false);
				Smtp.setVisible(false);
				contenido.setVisible(true);
				borradoUsuario.setVisible(true);

			}
		});

		borrarArchivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creacionArchivo.setVisible(false);
				creacionFichero.setVisible(false);
				creacionUsuario.setVisible(false);
				borradoUsuario.setVisible(false);
				Smtp.setVisible(false);
				contenido.setVisible(true);
				borradoArchivo.setVisible(true);

			}
		});

		setResizable(false);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
