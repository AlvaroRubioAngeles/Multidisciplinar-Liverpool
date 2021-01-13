package liverpool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.ComponentOrientation;
import javax.swing.ScrollPaneConstants;
/**
 * Clase Representante
 * Descripción: Esta ventana es para el representante.
 * @author Gabriel Vizcaino Sánchez
 * @version 1.0
 * Fecha 14/12/2020
 */
public class Representante extends JFrame {

	private JPanel contentPane;
	private ArrayList<JTextField> cajas;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textFechaNaci;
	private JTextField textAge;
	private JMenu mnNewMenu;
	private JButton btnCrear;
	private JMenu mnNewMenu_1;
	private JButton btnVer;
	private JFileChooser fileChooser;
	private JButton btnCrearCont;
	private JButton btnCorreo;
	private JPanel panel_2;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblEscudo;
	private JMenu mnNewMenu_3;
	private JButton btnCerrarSesion;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnRedactar;
	private JButton btnCerrar;
	private JPanel panel_6;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Representante frame = new Representante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crear la ventana de representante.
	 */
	public Representante() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Representante.class.getResource("/image/icoes.png")));
		setTitle("Representante");		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 836, 635);
		setResizable(false);
		cajas = new ArrayList<>();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 51, 51)));
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(255, 51, 51));
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Crear");
		mnNewMenu.setBackground(new Color(255, 51, 51));
		mnNewMenu.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		btnCrear = new JButton("Crear Contrato");
		mnNewMenu.add(btnCrear);
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("MV Boli", Font.BOLD, 16));
		btnCrear.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnCrear.setBackground(new Color(255, 51, 51));
		
		mnNewMenu_1 = new JMenu("Ver");
		mnNewMenu_1.setBackground(new Color(255, 51, 51));
		mnNewMenu_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		btnVer = new JButton("Ver directorios");
		mnNewMenu_1.add(btnVer);
		btnVer.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnVer.setFont(new Font("MV Boli", Font.BOLD, 16));
		btnVer.setForeground(new Color(255, 255, 255));
		btnVer.setBackground(new Color(255, 51, 51));
		
		JMenu mnNewMenu_2 = new JMenu("Correo");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		mnNewMenu_2.setBackground(new Color(255, 51, 51));
		menuBar.add(mnNewMenu_2);
		
		btnCorreo = new JButton("E-Mail");
		btnCorreo.setFont(new Font("MV Boli", Font.BOLD, 16));
		btnCorreo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnCorreo.setForeground(new Color(255, 255, 255));
		btnCorreo.setBackground(new Color(255, 51, 51));
		mnNewMenu_2.add(btnCorreo);
		
		mnNewMenu_3 = new JMenu("Sesi\u00F3n");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		mnNewMenu_3.setBackground(new Color(255, 51, 51));
		menuBar.add(mnNewMenu_3);
		
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnCerrarSesion.setFont(new Font("MV Boli", Font.BOLD, 16));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(255, 51, 51));
		
		mnNewMenu_3.add(btnCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBounds(115, 29, 600, 505);
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));	
		panel_4.setVisible(false);
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(2, 1, 0, 6));		
		btnRedactar = new JButton("Redactar Correo Nuevo");
		btnRedactar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		btnRedactar.setBorder(new LineBorder(new Color(144, 238, 144), 3));
		btnRedactar.setForeground(Color.RED);
		btnRedactar.setHorizontalAlignment(SwingConstants.CENTER);		
		panel_5.add(btnRedactar);		
		btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		btnCerrar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnCerrar.setBorder(new LineBorder(new Color(127, 255, 0), 3));
		btnCerrar.setForeground(Color.RED);
		panel_5.add(btnCerrar);		
		panel_6 = new JPanel();		
		panel_6.setBackground(Color.WHITE);
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(30, 1, 0, 0));
		JScrollPane scrollPane2 = new JScrollPane(panel_6);
		panel_4.add(scrollPane2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(115, 29, 600, 505);
		contentPane.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 6));
		panel_7.setVisible(false);
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(152, 251, 152));
		panel_7.add(panel_8, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gabri\\Desktop\\ezgif.com-gif-maker.gif"));
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_7.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new GridLayout(2, 1, 0, 3));
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(152, 251, 152)));
		btnNewButton.setForeground(Color.RED);
		panel_9.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(152, 251, 152)));
		btnNewButton_1.setForeground(Color.RED);
		panel_9.add(btnNewButton_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.RED);
		panel_7.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new GridLayout(0, 2, 0, 3));
		
		JLabel lblNewLabel_2 = new JLabel("Correo Electronico");
		lblNewLabel_2.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_10.add(lblNewLabel_2);
		
		textField = new JTextField();
		panel_10.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 15));
		panel_10.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		panel_10.add(textField_1);
		textField_1.setColumns(10);
		lblEscudo = new JLabel("");
		lblEscudo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscudo.setIcon(new ImageIcon("C:\\Users\\gabri\\Desktop\\Grado Superior Multiplataforma\\Nueva carpeta\\Trabajo_Multidisciplinar\\src\\image\\liverescudo.jpg"));
		lblEscudo.setBounds(115, 25, 600, 517);
		contentPane.add(lblEscudo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(255, 51, 51)));
		panel.setBounds(110, 24, 610, 517);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		panel_1.setVisible(false);
		
		fileChooser = new JFileChooser();
		scrollPane.setViewportView(fileChooser);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(4, 1, 0, 0));
		panel_2.setVisible(false);
		
		JLabel lblNomb = new JLabel("Nombre:");
		lblNomb.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 51, 51)));
		lblNomb.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 20));
		panel_2.add(lblNomb);
		lblNomb.setForeground(new Color(255, 51, 51));
		lblNomb.setHorizontalAlignment(SwingConstants.CENTER);
		
		textNombre = new JTextField();
		panel_2.add(textNombre);
		textNombre.setColumns(10);
		cajas.add(textNombre);
		
		JLabel lblApelli = new JLabel("Apellidos:");
		lblApelli.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 51, 51)));
		lblApelli.setForeground(new Color(255, 51, 51));
		lblApelli.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 20));
		lblApelli.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblApelli);
		
		textApellidos = new JTextField();
		panel_2.add(textApellidos);
		textApellidos.setColumns(10);
		cajas.add(textApellidos);
		
		JLabel lblFechaNac = new JLabel("Fecha Nacimiento:");
		lblFechaNac.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 51, 51)));
		lblFechaNac.setForeground(new Color(255, 51, 51));
		lblFechaNac.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 20));
		lblFechaNac.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblFechaNac);
		
		textFechaNaci = new JTextField();
		panel_2.add(textFechaNaci);
		textFechaNaci.setColumns(10);
		cajas.add(textFechaNaci);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 51, 51)));
		lblEdad.setForeground(new Color(255, 51, 51));
		lblEdad.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 20));
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblEdad);
		
		textAge = new JTextField();
		panel_2.add(textAge);
		textAge.setColumns(10);
		cajas.add(textAge);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		panel_3.setBackground(new Color(255, 51, 51));
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setVisible(false);
		
		btnCrearCont = new JButton("Guardar");
		btnCrearCont.setForeground(new Color(255, 255, 255));
		btnCrearCont.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnCrearCont.setBackground(new Color(255, 51, 51));
		btnCrearCont.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_3.add(btnCrearCont);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Representante.class.getResource("/image/contrato.jpg")));
		lblNewLabel.setBounds(0, 0, 830, 567);
		contentPane.add(lblNewLabel);
	}

	//Getter y Setters
	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	public void setTextApellidos(JTextField textApellidos) {
		this.textApellidos = textApellidos;
	}

	public JTextField getTextFechaNaci() {
		return textFechaNaci;
	}

	public void setTextFechaNaci(JTextField textFechaNaci) {
		this.textFechaNaci = textFechaNaci;
	}

	public JTextField getTextAge() {
		return textAge;
	}

	public void setTextAge(JTextField textAge) {
		this.textAge = textAge;
	}

	public JButton getBtnVer() {
		return btnVer;
	}

	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}	

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public JButton getBtnCrearCont() {
		return btnCrearCont;
	}

	public void setBtnCrearCont(JButton btnCrearCont) {
		this.btnCrearCont = btnCrearCont;
	}

	public JButton getBtnCorreo() {
		return btnCorreo;
	}

	public void setBtnCorreo(JButton btnCorreo) {
		this.btnCorreo = btnCorreo;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JPanel getPanel_3() {
		return panel_3;
	}

	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	public JLabel getLblEscudo() {
		return lblEscudo;
	}

	public void setLblEscudo(JLabel lblEscudo) {
		this.lblEscudo = lblEscudo;
	}

	public ArrayList<JTextField> getCajas() {
		return cajas;
	}

	public void setCajas(ArrayList<JTextField> cajas) {
		this.cajas = cajas;
	}

	public JButton getBtnCerrarSesión() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesión(JButton btnCerrarSesión) {
		this.btnCerrarSesion = btnCerrarSesión;
	}
}
