package liverpool;

import java.io.IOException;

import javax.swing.JOptionPane;

public class OpenManual {

	int opcion;

	public OpenManual(int opcion) {

		this.opcion = opcion;

		switch (opcion) {

		case 1:
			try {
				Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Manual-Liverpool.pdf");
			} catch (IOException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Check your file details");
			}
			break;
		case 2:
			try {
				Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Manual-Liverpool-EN.pdf");
			} catch (IOException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Check your file details");
			}
			break;
		}
	}

}
