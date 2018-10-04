package interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controlers.LoginControler;

public class Login extends JFrame{
	
	private JButton login;
	private JTextField txt;
	
		 Login(){
			dibujar();
			settings();
		}
	
		private void settings() {
			
			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
			this.setSize(350, 250);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
			this.setVisible(true);
		}
		private void dibujar() {
			JPanel panelLogin = new JPanel();
			Border line = BorderFactory.createLineBorder(Color.BLACK);
			
				panelLogin.setBorder(BorderFactory.createTitledBorder(line, "Hey",TitledBorder.DEFAULT_JUSTIFICATION , TitledBorder.ABOVE_TOP));
					login = new JButton(" LOGIN ");
					login.setFocusable(false);
					txt = new JTextField(10);
					LoginControler lc = new LoginControler(this);
					login.addActionListener(lc);
					
					panelLogin.add( txt );
					panelLogin.add( login );
					
			this.getContentPane().add(panelLogin);
		
	}
		
		public JTextField getTxt() {
			return txt;
		}

		
	public static void main(String[] args) {
	
		new Login();

	}

}
