package liverpool;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaError extends JFrame implements ActionListener{
	
	private JButton btnAceptar;
	private JLabel labelError;
	private JPanel panel, panel2;
	
	public VentanaError(String textoError) {
		setTitle("Error");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		setResizable(false);
		
		panel = new JPanel();
		//setContentPane(panel);
		panel2 = new JPanel();
		/*setContentPane(panel2);
		
		BoxLayout box = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(box);
		
		BoxLayout box2 = new BoxLayout(panel2,BoxLayout.X_AXIS);
		panel2.setLayout(box2);*/
		
		labelError = new JLabel(textoError);
		//labelError.setBounds(107, 25, 200, 25);
		panel.add(labelError);
		
		btnAceptar = new JButton("Aceptar");
		//btnAceptar.setBounds(150, 75, 100, 25);
		btnAceptar.addActionListener(this);
		panel2.add(btnAceptar);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();
	}

}
