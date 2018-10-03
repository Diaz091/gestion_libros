package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Login extends JFrame{
	
	private JButton login;
	
	Login(){
		
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		
		dibujar();
		
		this.setSize(250, 250);
		this.setVisible(true);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		
	}
	
		private void dibujar() {
		
		login = new JButton(" LOGIN ");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 new MainMenu();
				 dispose();
				
			}
		});
		
		this.getContentPane().add(login);
		
	}
	
	public static void main(String[] args) {
	
		new Login();

	}

}
