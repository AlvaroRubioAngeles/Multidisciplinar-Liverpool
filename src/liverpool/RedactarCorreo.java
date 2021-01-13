package liverpool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class RedactarCorreo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JButton btnEnviar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedactarCorreo frame = new RedactarCorreo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RedactarCorreo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RedactarCorreo.class.getResource("/image/icoes.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(217, 5, 210, 208);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RedactarCorreo.class.getResource("/image/escudosinfondo.png")));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(5, 5, 80, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPara = new JLabel("Para");
		lblPara.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		lblPara.setForeground(Color.RED);
		lblPara.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 14));
		lblPara.setBounds(0, 0, 80, 21);
		lblPara.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblPara);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		lblAsunto.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 14));
		lblAsunto.setForeground(Color.RED);
		lblAsunto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsunto.setBounds(0, 37, 80, 21);
		panel_1.add(lblAsunto);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(6, 5, 219, 208);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(79, 0, 132, 60);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 132, 22);
		panel_4.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 36, 132, 22);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 69, 0));
		panel_5.setBounds(79, 68, 132, 127);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(152, 251, 152)));
		textArea.setBounds(0, 0, 132, 127);
		panel_5.add(textArea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 69, 0));
		panel_3.setBounds(5, 213, 422, 35);
		contentPane.add(panel_3);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(255, 99, 71));
		btnEnviar.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 17));
		panel_3.add(btnEnviar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 99, 71));
		btnCancelar.setBorder(new LineBorder(new Color(152, 251, 152), 3));
		btnCancelar.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 17));
		btnCancelar.setForeground(Color.WHITE);
		panel_3.add(btnCancelar);
		Representante repre = new Representante();
		EnviarCorreo envio = new EnviarCorreo(this, repre);
		envio.envioCorreo();		
		CancelarEnvioCorreo cancel = new CancelarEnvioCorreo(repre, this);
		cancel.cancelarEnvio();
		setVisible(true);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	
}
