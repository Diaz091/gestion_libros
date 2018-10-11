package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import interfaces.Login;
import interfaces.MainMenu;
import models.ConexionMySql;

public class ControladorLogin implements ActionListener{

	private Login log;
	private MainMenu main;
	private Connection conMysql;
	public ControladorLogin( Login lo ){
		this.log = lo;
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		String id = log.getTxt().getText();
		
		main = new MainMenu();
		log.dispose();
		
			try {
				conMysql = ConexionMySql.instancia().conectarMySql();
				
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
				log.dispose();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				
			
			
		}
}
