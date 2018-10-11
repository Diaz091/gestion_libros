package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	private Connection conMysql;
	public static ControladorAlumnos instancia() {
		if (INSTANCIA == null) {
			return new ControladorAlumnos();
		}else {
			return INSTANCIA;
		}
	}
		
	private MainMenu main;
	private GestorAlumnos stManager;
	
	private ControladorAlumnos() {
		
	}
		
	public void setMain( MainMenu mainM ) {
		this.main = mainM;
	}

	public void setManager( GestorAlumnos stuM ) {
		this.stManager = stuM;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( main!=null && (JButton) e.getSource() == main.getBotonAlumnos( ) ){
			instancia().setManager( new GestorAlumnos() );
			main.dispose();
		}else {
			stManager.getPanelInicio().setVisible(false);
			if( (JButton) e.getSource() == stManager.getBotonVolver() ) {
				instancia().setMain( new MainMenu() );
				stManager.dispose();
			}
			
			// LISTENER PARA DAR DE ALTA ALUMNOS EN LA BASE DE DATOS \\
			if( (JButton) e.getSource() == stManager.getBotonAltas() ) {
				if( stManager.getPanelBajas().isVisible()) {
						stManager.getPanelBajas().setVisible(false);
				}else 
					if( stManager.getPanelModificar().isVisible()) {
							stManager.getPanelModificar().setVisible(false);
					}else
						if( stManager.getPanelConsultas().isVisible()) {
								stManager.getPanelConsultas().setVisible(false);
						}
				stManager.getPanelAltas().setVisible( true );
				}		
			
			if( (JButton) e.getSource() == stManager.getBotonGuardar() ) {
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
			
			if ( (JButton) e.getSource() == stManager.getBotonListar() ) {
				DefaultListModel<Alumno> alu = DataResource.instancia().modeloAlumno();
				stManager.getListaAlumnos().setModel(alu);
				stManager.getTextoDNI().setText("");
				stManager.getTextoNombre().setText(""); 
				stManager.getTextoApellido().setText("");
				stManager.getTextoApellido_2().setText("");
			}
			
			if ( (JButton) e.getSource() == stManager.getBotonLimpiar() ) {
				
				DefaultListModel<Alumno> alumno = (DefaultListModel<Alumno>) stManager.getListaAlumnos().getModel();
				alumno.removeAllElements();
				alumno.clear();
				stManager.getListaAlumnos().setModel( alumno );
				
				
			}
			// LISTENER PARA DAR DE BAJA ALUMNOS EN LA BASE DE DATOS \\
			if( (JButton) e.getSource() == stManager.getBotonBajas() ) {
				if( stManager.getPanelAltas().isVisible()) {
						stManager.getPanelAltas().setVisible(false);
				}else 
					if( stManager.getPanelModificar().isVisible()) {
						stManager.getPanelModificar().setVisible(false);
					}else
						if( stManager.getPanelConsultas().isVisible()) {
							stManager.getPanelConsultas().setVisible(false);
						}
				stManager.getPanelBajas().setVisible( true );
			}
			
		}
			
		
	}
}
