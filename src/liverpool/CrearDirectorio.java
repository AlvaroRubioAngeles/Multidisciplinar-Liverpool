package liverpool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

import Conexiones.ConexionFtp;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Clase CrearDirectorio
 * Descripci�n: Ventana para dar nombre a los directorios a crear.
 * @author Gabriel Vizcaino S�nchez
 * @version 1.0
 * Fecha 14/01/2021
 *
 */
public class CrearDirectorio extends JFrame {
	private ConexionFtp conexion;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JButton btnAceptarNombre;
	private JButton btnCancelarNombre;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearDirectorio frame = new CrearDirectorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Crear ventana.
	 */
	public CrearDirectorio(ConexionFtp conexion) {
		this.conexion = conexion;
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearDirectorio.class.getResource("/image/icoes.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 517, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Nombre directorio:");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setForeground(Color.RED);
		panel.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnAceptarNombre = new JButton("Aceptar");
		btnAceptarNombre.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		btnAceptarNombre.setForeground(Color.RED);
		btnAceptarNombre.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btnAceptarNombre);
		
		btnCancelarNombre = new JButton("Cancelar");
		btnCancelarNombre.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		btnCancelarNombre.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnCancelarNombre.setForeground(Color.RED);
		panel_1.add(btnCancelarNombre);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CrearDirectorio.class.getResource("/image/escudosinfondo.png")));
		panel_2.add(lblNewLabel_1);
		setVisible(true);
		setResizable(false);
		
		btnAceptarNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				conexion.crearCarpeta(textFieldNombre.getText());
				dispose();
			}
		});
		btnCancelarNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	//Getters y Setters
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JButton getBtnAceptarNombre() {
		return btnAceptarNombre;
	}

	public void setBtnAceptarNombre(JButton btnAceptarNombre) {
		this.btnAceptarNombre = btnAceptarNombre;
	}

	public JButton getBtnCancelarNombre() {
		return btnCancelarNombre;
	}

	public void setBtnCancelarNombre(JButton btnCancelarNombre) {
		this.btnCancelarNombre = btnCancelarNombre;
	}
		
	

}
