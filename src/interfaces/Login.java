package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.Highlighter.Highlight;

import controllers.LoginController;
import resources.Fonts;
import resources.Image;


public class Login extends JFrame{
	
	private static final long serialVersionUID = 7432826939820483800L;
	/**
	 * 
	 */
	private JButton login;
	private JTextField txtID;
	
	
		 Login(){
			dibujar();
			settings();
		}
	
		private void settings() {
			
			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
			this.setSize( 320 , 270 );
			this.setLocationRelativeTo( null );
			this.setResizable(false);
			this.setLayout( new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS ) );
			this.setVisible( true );
		}
		
		private void dibujar() {
			this.add(Box.createRigidArea( new Dimension( 0 , 15 ) ) );
			
			JLabel	titulo = new JLabel( "Inicio de Sesión  " );
					titulo.setFont( Fonts.fontText );
					titulo.setAlignmentX( CENTER_ALIGNMENT );
					
			JPanel	panelLogin = new JPanel();
					
			JLabel	textoID = new JLabel( "ID Usuario: " )	;								
					login = new JButton(" Login ");
					login.setFocusable( false );
				
					txtID = new JTextField(10);
					LoginController lc = new LoginController(this);
					login.addActionListener(lc);
						
					panelLogin.add( textoID );
					panelLogin.add( txtID );
					panelLogin.add( login );
					
				this.getContentPane().add( titulo );	
				this.getContentPane().add( panelLogin );
		
		}
		
		public JTextField getTxt() {
			return txtID;
		}

		
		public static void main(String[] args) {
		
			new Login();
	
		}

}
