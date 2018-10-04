package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.Highlighter.Highlight;

import controlers.LoginControler;


public class Login extends JFrame{
	
	private static final long serialVersionUID = 7432826939820483800L;
	/**
	 * 
	 */
	private JButton login;
	private JTextField textoID;
	
		 Login(){
			dibujar();
			settings();
		}
	
		private void settings() {
			
			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
			this.setSize(450, 350);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setLayout( new FlowLayout() );
			
			this.setVisible(true);
		}
		
		private void dibujar() {
			JLabel	titulo = new JLabel( "Título Radiánte  " );
					titulo.setBorder( BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.RED));
			JPanel	panelLogin = new JPanel();
					panelLogin.setPreferredSize( new Dimension( 350 , 250 ) );
					panelLogin.setBackground( Color.BLUE );
			/*		
				login = new JButton(" Login ");
				login.setFocusable(false);
				textoID = new JTextField(10);
				LoginControler lc = new LoginControler(this);
				login.addActionListener(lc);
					
				panelLogin.add( textoID );
				panelLogin.add( login );
				*/	
			this.getContentPane().add( titulo );
			this.getContentPane().add( panelLogin );
		
	}
		
		public JTextField getTxt() {
			return textoID;
		}

		
	public static void main(String[] args) {
	
		new Login();

	}

}
