package interfaces;


import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ControladorLogin;
import resources.Colors;
import resources.Fonts;
import resources.ImageTest;

public class Login extends JFrame{
	
	private static final long serialVersionUID = 7432826939820483800L;
	
	private JButton 	login;
	private JTextField 	txtID;
	private JLabel	 	idUsus;
	
	
		 Login(){
			ImageTest img = new ImageTest("img/loginBack.jpg");
			this.setContentPane(img );
				
			dibujar();
			settings();
		}
	
		private void settings() {
			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
			this.setSize( 320 , 240 );
			this.setLocationRelativeTo( null );
			this.setResizable(false);
			this.setLayout( new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS ) );
			this.setVisible( true );
		
		}
		
		private void dibujar() {
			this.add(Box.createRigidArea( new Dimension( 0 , 15 ) ) );
			ImageTest img = new ImageTest("img/loginBack.jpg");
			
			JLabel	titulo = new JLabel( "Inicio de Sesión  " );
					titulo.setFont( Fonts.fontText2 );
					titulo.setForeground( Colors.textWhite );
					titulo.setAlignmentX( CENTER_ALIGNMENT );
					
			JPanel	panelLogin = img;
					
			panelLogin.add(Box.createRigidArea( new Dimension( 0 , 50 ) ) );
			JLabel	textoID = new JLabel( "ID Usuario: " )	;	
					textoID.setFont( Fonts.fontText );
					textoID.setForeground( Colors.textWhite );
					login = new JButton(" Login ");
					login.setFocusable( false );
				
					idUsus = new JLabel( new ImageIcon( "img/help.png" ) ) ;
					idUsus.setCursor( Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					txtID = new JTextField(13);
					ControladorLogin lc = new ControladorLogin(this);
					login.addActionListener(lc);
				
					panelLogin.add( textoID );
					panelLogin.add( txtID );
					panelLogin.add( login );
					panelLogin.add( idUsus );
					
				this.getContentPane().add( titulo );	
				this.getContentPane().add( panelLogin );
		
		}
		
		public JTextField getTxt() {
			return txtID;
		}

		
		public JLabel getIdUsus() {
			return idUsus;
		}

		public static void main(String[] args) {
		
			new Login();
	
		}

}