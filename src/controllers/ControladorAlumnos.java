package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.MainMenu;
import models.Alumno;
import models.ConexionMySql;
import models.DataResource;
import interfaces.GestorAlumnos;

public class ControladorAlumnos implements ActionListener{
	private static ControladorAlumnos INSTANCIA;
	private GestorAlumnos stManager;
	private Connection conMysql;
	private MainMenu main;
	
	public static ControladorAlumnos instancia() {
		if ( INSTANCIA == null ) 
			INSTANCIA =  new ControladorAlumnos();
		return INSTANCIA;
	}
	
	private ControladorAlumnos() {}
		
	public void setMain( MainMenu mainM ) {
		this.main = mainM;
	}	

	public void setManager( GestorAlumnos stuM ) {
		this.stManager = stuM;
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		if( main!=null && ( JButton ) e.getSource() == main.getBotonAlumnos( ) ){
			instancia().setManager( new GestorAlumnos() );
			main.dispose();
		}else {
			stManager.getPanelInicio().setVisible( false );
			if( ( JButton ) e.getSource() == stManager.getBotonVolver() ) {
				instancia().setMain( new MainMenu() );
				stManager.dispose();
			}
			
			// LISTENER PARA DAR DE ALTA ALUMNOS EN LA BASE DE DATOS \\
					if( ( JButton ) e.getSource() == stManager.getBotonAltas() ) {
						if( stManager.getPanelConsultas().isVisible()) 
								stManager.getPanelConsultas().setVisible( false );
							
							stManager.getPanelAltas().setVisible( true );
						}		
					
					if( ( JButton ) e.getSource() == stManager.getBotonGuardar() ) {
						try {
							conMysql = ConexionMySql.instancia().conectarMySql();
							
							PreparedStatement	ps = conMysql.prepareStatement( "Insert into alumnos values (?,?,?,?)" );
												ps.setString( 1 , stManager.getTextoDNI().getText() );
												ps.setString( 2 , stManager.getTextoNombre().getText() );
												ps.setString( 3 , stManager.getTextoApellido().getText() );
												ps.setString( 4 , stManager.getTextoApellido_2().getText() );
							ps.executeUpdate();
							conMysql.close();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "El Alumno con DNI " + stManager.getTextoDNI().getText() + ". Ya existe en nuestra Base de Datos. ");
						}
																
					}
					
					if ( ( JButton ) e.getSource() == stManager.getBotonListar() ) {
						//DefaultListModel<Alumno> alu = DataResource.instancia().modeloAlumno();
						DefaultListModel<Alumno> alu = new DefaultListModel <Alumno>();
							alu.addElement( new Alumno("72750583L", "Unai", "Díaz de Garayo", "Jiménez" ) );
						stManager.getListaAlumnos().setModel(alu);
						/*stManager.getTextoDNI().setText("");
						stManager.getTextoNombre().setText(""); 
						stManager.getTextoApellido().setText("");
						stManager.getTextoApellido_2().setText("");*/
					}
					
					if ( ( JButton ) e.getSource() == stManager.getBotonLimpiar() ) {
						
						DefaultListModel < Alumno > alumno = ( DefaultListModel < Alumno > ) stManager.getListaAlumnos().getModel();
						alumno.removeAllElements();
						alumno.clear();
						stManager.getListaAlumnos().setModel( alumno );
											
					}
					
			}
	}
}
