package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.Login;
import interfaces.MainMenu;

public class ControladorLogin implements ActionListener{

	private Login log;
	private MainMenu main;
	
	public ControladorLogin( Login lo ){
		this.log = lo;
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		String id = log.getTxt().getText();
		
		main = new MainMenu();
		log.dispose();
		/*
			try {
				
				Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();
				String conexion = "jdbc:mysql://localhost:3306/gestion_libros?user=root&password=tiger&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				Connection	conMysql = DriverManager.getConnection( conexion );
				PreparedStatement ps = conMysql.prepareStatement( "Select nombre, apellido from users where id = ?" );
					ps.setString(1, id );
				ResultSet rs = ps.executeQuery();
				
				if( id.equals("") ) {
					main.getBienvenida().setText( main.getBienvenida().getText() + "Unknown" );
				}
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
				
			} catch ( InstantiationException e1 ) {
				e1.printStackTrace();
			} catch ( IllegalAccessException e2 ) {
				e2.printStackTrace();
			} catch ( ClassNotFoundException e3 ) {
				e3.printStackTrace();
			} catch ( SQLException e4 ) {
				e4.printStackTrace();
			}*/
		}
}
