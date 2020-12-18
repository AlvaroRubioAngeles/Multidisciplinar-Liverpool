package liverpool;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;

/**
 * Clase login Descripci�n: Esta ventana es el inicio de sesi�n de los usuarios.
 * 
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0 Fecha 14/12/2020
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textPassword;
	private JButton btnInicio;
	private JButton btnAcerca;
	private JButton btnManual;

	/**
	 * Creaci�n de la ventana de login.
	 */
	public Login() {
		setTitle("You'll never walk alone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 401);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 51, 51));
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Ayuda");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setBackground(new Color(255, 51, 51));
		menuBar.add(mnNewMenu);

		btnAcerca = new JButton("Acerca de");
		btnAcerca.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnAcerca.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		btnAcerca.setForeground(new Color(255, 255, 255));
		btnAcerca.setBackground(new Color(255, 51, 51));
		mnNewMenu.add(btnAcerca);

		btnManual = new JButton("Manual");
		btnManual.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnManual.setHorizontalAlignment(SwingConstants.LEADING);
		btnManual.setBackground(new Color(255, 51, 51));
		btnManual.setForeground(new Color(255, 255, 255));
		btnManual.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		mnNewMenu.add(btnManual);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel eslogan = new JLabel("You'll never walk alone");
		eslogan.setBackground(new Color(255, 255, 255));
		eslogan.setFont(new Font("Blackadder ITC", Font.BOLD | Font.ITALIC, 41));
		eslogan.setHorizontalAlignment(SwingConstants.CENTER);
		eslogan.setForeground(new Color(255, 255, 255));
		eslogan.setBounds(125, 269, 376, 58);
		contentPane.add(eslogan);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 30, 614, 247);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 51, 51)));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(new Color(255, 51, 51));
		lblUser.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		panel_1.add(lblUser);

		textUsuario = new JTextField();
		panel_1.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblPassword = new JLabel("Contrase\u00f1a");
		lblPassword.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 51, 51)));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(255, 51, 51));
		lblPassword.setFont(new Font("Lucida Console", Font.BOLD, 20));
		panel_1.add(lblPassword);

		textPassword = new JTextField();
		panel_1.add(textPassword);
		textPassword.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 51, 51));
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_2, BorderLayout.SOUTH);

		btnInicio = new JButton("Iniciar Sesi\u00f3n");
		btnInicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnInicio.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setOpaque(false);
		btnInicio.setBackground(new Color(255, 51, 51));
		panel_2.add(btnInicio);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 51, 51));
		lblNewLabel.setIcon(new ImageIcon(
				"C:/Users/fran5/git/Multidisciplinar-Liverpool/src/image/escudo.png"));
		panel_4.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 51, 51));
		panel.add(panel_3, BorderLayout.NORTH);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setSize(200, 300);
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 19));
		panel_3.add(lblLogin);

		JLabel lblImagenPrincipal = new JLabel("");
		lblImagenPrincipal.setIcon(new ImageIcon(
				"C:/Users/fran5/git/Multidisciplinar-Liverpool/src/image/Liverpool.jpg"));
		lblImagenPrincipal.setBounds(0, 0, 638, 354);
		contentPane.add(lblImagenPrincipal);
		setVisible(true);
	}

	public void limpiarTextos() {
		textUsuario.setText("");
		textPassword.setText("");
	}
	
	public void mostrarError() {
		JOptionPane.showMessageDialog(null, "Error. Usuario o Contrase�a invalidas", "Inicio de sesi�n",
				JOptionPane.WARNING_MESSAGE);
	}

	public void hacerInvisible() {
		setVisible(false);
	}

	// Getters y Setters
	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public JTextField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(JTextField textPassword) {
		this.textPassword = textPassword;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public void setBtnInicio(JButton btnInicio) {
		this.btnInicio = btnInicio;
	}

	public JButton getBtnAcerca() {
		return btnAcerca;
	}

	public void setBtnAcerca(JButton btnAcerca) {
		this.btnAcerca = btnAcerca;
	}

	public JButton getBtnManual() {
		return btnManual;
	}

	public void setBtnManual(JButton btnManual) {
		this.btnManual = btnManual;
	}
}
