package controller.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.mainMenu.ControladorMainMenu;
import interfaces.Login;
import interfaces.MainMenu;
import models.ConexionMySql;
import models.DataResource;

public class ControladorLogin {

	private Login log;
	private MainMenu main;
	private Connection conMysql;
	private static ControladorLogin instancia;
	
	private ControladorLogin() {}

	public static ControladorLogin instancia() {
		if(instancia== null) 
			instancia = new ControladorLogin();
		return instancia;
	}
	
	public void setLogin( Login lo ){
		this.log = lo;
		login();
	}
	
	
	private void login() {
		
		log.getLogin().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = log.getTxt().getText();
				
				main = MainMenu.instancia();
				
				ControladorMainMenu.instancia().setMain(main);
				
				ControladorMainMenu.instancia().iniciar();
				
				log.dispose();
				
				if( id.equals("") ) {
					main.getBienvenida().setText( main.getBienvenida().getText() + "Unknown" );
				}else {
					try {
						conMysql = ConexionMySql.instancia().conectarMySql();
						
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
						log.dispose();
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	
		log.getIdUsus().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if( e.getClickCount() >0 ) {
					
					JOptionPane.showMessageDialog(null, DataResource.instancia().idUsuarios(), "ID Usuarios", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
			
			
			
		});
	
	
	}


	public Login getLog() {
		return log;
	}
	
}
