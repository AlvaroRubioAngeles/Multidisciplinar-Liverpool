package liverpool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
/**
 * Clase login
 * Descripci�n: Esta ventana es el inicio de sesi�n de los usuarios.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 14/12/2020
 */
public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textPassword;
	private JButton btnInicio;
	private JLabel lblImagenGif;

	/**
	 * Lanzar de la aplicaci�n.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphics grafico = null;
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Creaci�n de la ventana de login.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		JLabel eslogan = new JLabel("You'll never walk alone");
		eslogan.setBackground(new Color(0, 0, 0));
		eslogan.setFont(new Font("Blackadder ITC", Font.BOLD | Font.ITALIC, 41));
		eslogan.setHorizontalAlignment(SwingConstants.CENTER);
		eslogan.setForeground(Color.BLUE);
		eslogan.setBounds(98, 65, 376, 16);
		contentPane.add(eslogan);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(132, 94, 342, 165);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Ink Free", Font.BOLD, 14));
		panel_1.add(lblUser);
		
		textUsuario = new JTextField();
		panel_1.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Lucida Calligraphy", Font.BOLD, 14));
		panel_1.add(lblPassword);
		
		textPassword = new JTextField();
		panel_1.add(textPassword);
		textPassword.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 230, 140));
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_2, BorderLayout.SOUTH);
		
		btnInicio = new JButton("Iniciar Sesi\u00F3n");
		btnInicio.setBackground(new Color(153, 204, 255));
		panel_2.add(btnInicio);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		lblImagenGif= new JLabel("");
		lblImagenGif.setIcon(new ImageIcon("C:\\Users\\fran5\\git\\Multidisciplinar-Liverpool\\src\\image\\carga.gif"));
		panel_4.add(lblImagenGif);
		ocultarCarga();
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 204));
		panel.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.RED);
		lblLogin.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 20));
		panel_3.add(lblLogin);
		
		JLabel lblImagenPrincipal = new JLabel("");
		lblImagenPrincipal.setIcon(new ImageIcon("C:\\Users\\fran5\\git\\Multidisciplinar-Liverpool\\src\\image\\Liverpool.jpg"));
		lblImagenPrincipal.setBounds(0, 0, 638, 354);
		contentPane.add(lblImagenPrincipal);
		hacerVisible();
		
	}
	public void mostrarCarga() {
		lblImagenGif.setVisible(true);
	}
	public void ocultarCarga() {
		lblImagenGif.setVisible(false);
	}
	public void hacerVisible() {
		setVisible(true);
	}
	public void hacerInvisible() {
		setVisible(false);
	}
	public void limpiarTextos() {
		textUsuario.setText("");
		textPassword.setText("");
	}
	public void mostrarError() {
		JOptionPane.showMessageDialog(null, "Error. Usuario o Contraseña invalidas", "Inicio de sesión", JOptionPane.WARNING_MESSAGE);
	}
	//Getters y Setters	
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
}
