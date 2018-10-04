package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.Login;
import interfaces.MainMenu;

public class LoginControler implements ActionListener{

	private Login log;
	private MainMenu main;
	
	public LoginControler( Login lo , MainMenu ma ){
		
		this.log = lo;
		this.main =ma;
	}
	
	public LoginControler( Login lo ){
		
		this.log = lo;
		
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		String id = log.getTxt().getText();
		main = new MainMenu();
		
			try {
				
				Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();
				Connection	conMysql = DriverManager.getConnection( "jdbc:mysql://localhost:3306/gestion_libros?user=root&password=tiger&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				
				PreparedStatement ps = conMysql.prepareStatement( "Select nombre, apellido from users where id = ?" );
					ps.setString(1, id );
				ResultSet rs = ps.executeQuery();
				while( rs.next() ) {
					if(rs.getString( "apellido" ) != null ) {
						main.getBienvenida().setText( main.getBienvenida().getText() + rs.getString( "nombre" ) + " " + rs.getString( "apellido" ) );	
					}else {
						main.getBienvenida().setText( main.getBienvenida().getText() + rs.getString( "nombre" ) );
					}
				}
				rs.close();
				ps.close();
				conMysql.close();
				log.dispose();
				
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
			 
			 	
		
	}
	

}
