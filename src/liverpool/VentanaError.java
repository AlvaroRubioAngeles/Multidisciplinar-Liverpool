package liverpool;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;

/**
 * Ventana de error Descripción: Ventana que saldra cuando salte un error en el
 * programa.
 * 
 * @author Gabriel Vizcaino, David Casado, Mario Vega
 * @version 1.0 Fecha 09/01/2021
 */
public class VentanaError extends JFrame implements ActionListener {

	private JButton btnAceptar;
	private JLabel labelError;
	private JPanel panel, panel2;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaError frame = new VentanaError("Error.Fallo en la conexión");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Crear la ventana de error.
	 */
	public VentanaError(String textoError) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaError.class.getResource("/image/icoes.png")));
		setForeground(Color.RED);
		setFont(new Font("Algerian", Font.ITALIC, 12));
		setTitle("Error");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		// setContentPane(panel);
		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout(0, 0));

		labelError = new JLabel(textoError);
		labelError.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelError.setFont(new Font("Arial", Font.PLAIN, 13));
		labelError.setForeground(Color.RED);
		// labelError.setBounds(107, 25, 200, 25);
		panel.add(labelError, BorderLayout.CENTER);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.RED);
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Forte", Font.BOLD, 11));
		// btnAceptar.setBounds(150, 75, 100, 25);
		btnAceptar.addActionListener(this);
		panel2.add(btnAceptar);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.getContentPane().add(panel2, BorderLayout.SOUTH);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.WEST);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaError.class.getResource("/image/error.png")));
		panel_1.add(lblNewLabel);
		String path = "src/sound/music-error.mp3";
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	         System.out.println("Error al reproducir el sonido.");
	       }


		//setVisible(true);
	}

	/*
	 * Evento del botón aceptar que cierra la ventana del error
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();
	}

}
