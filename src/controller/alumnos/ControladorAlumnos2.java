package controller.alumnos;
/*package controllers.alumnos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import models.Alumno;
import models.ConexionMySql;
import models.DataResource;

import interfaces.MainMenu;
import interfaces.GestorAlumnos;

public class ControladorAlumnos2 implements ActionListener{
	private static ControladorAlumnos2 INSTANCIA;
	
	private static GestorAlumnos stManager;
	private Connection conMysql;
	private MainMenu main;
	
	public static ControladorAlumnos2 instancia() {
		if ( INSTANCIA == null ) 
			INSTANCIA =  new ControladorAlumnos2();
		return INSTANCIA;
	}
		
	private ControladorAlumnos2() {}
		
	public void setMain( MainMenu mainM ) {
		this.main = mainM;
	}	

	public static void setManager( GestorAlumnos stuM ) {
		stManager = stuM;
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
	
			if( ( JButton ) e.getSource() == stManager.getBotonVolver() ) {
				instancia().setMain( MainMenu.instancia() );
				stManager.dispose();
			}
			// LISTENER PARA DAR DE ALTA ALUMNOS EN LA BASE DE DATOS \\
					if( ( JButton ) e.getSource() == stManager.getBotonAltas() ) {
						if( stManager.getPanelConsultas().isVisible()) 
								stManager.getPanelConsultas().setVisible( false );
							
							stManager.getPanelAltas().setVisible( true );
						}		
					// BOTON A�ADIR ALUMNO | A�ADE UN ALUMNO A LA BASE DE DATOS
					if( ( JButton ) e.getSource() == stManager.getBotonGuardar() ) {
						PreparedStatement	ps;
						try {
							conMysql = ConexionMySql.instancia().conectarMySql();
							if(stManager.getTextoDNI().getText().length() == 8 ) {
								ps = conMysql.prepareStatement( "Insert into alumnos values (?,?,?,?)" );
									ps.setString( 1 , stManager.getTextoDNI().getText()+Alumno.calculaLetra( Integer.parseInt( stManager.getTextoDNI().getText() ) ) );
									ps.setString( 2 , stManager.getTextoNombre().getText() );
									ps.setString( 3 , stManager.getTextoApellido().getText() );
									ps.setString( 4 , stManager.getTextoApellido_2().getText() );
								JOptionPane.showMessageDialog(null, "El alumno " + stManager.getTextoNombre().getText() + " se a�adio correctamente.");
							}else {
								ps = conMysql.prepareStatement( "Insert into alumnos values (?,?,?,?)" );
										ps.setString( 1 , stManager.getTextoDNI().getText() );
										ps.setString( 2 , stManager.getTextoNombre().getText() );
										ps.setString( 3 , stManager.getTextoApellido().getText() );
										ps.setString( 4 , stManager.getTextoApellido_2().getText() );
								JOptionPane.showMessageDialog(null, "El alumno " + stManager.getTextoNombre().getText() + " se a�adio correctamente.");
								}
							ps.executeUpdate();
							conMysql.close();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "El Alumno con DNI " + stManager.getTextoDNI().getText() + ". Ya existe en nuestra Base de Datos. ");
						}
					}
					
					if ( ( JButton ) e.getSource() == stManager.getBotonListar() ) {
						DefaultListModel < Alumno > alu = DataResource.instancia().modeloAlumno();
							stManager.getListaAlumnos().setModel(alu);
							stManager.getTextoDNI().setText("");
							stManager.getTextoNombre().setText(""); 
							stManager.getTextoApellido().setText("");
							stManager.getTextoApellido_2().setText("");
					}
					
					if ( ( JButton ) e.getSource() == stManager.getBotonLimpiar() ) {
						
						DefaultListModel < Alumno > alumno = ( DefaultListModel < Alumno > ) stManager.getListaAlumnos().getModel();
						alumno.removeAllElements();
						alumno.clear();
						
											
					}
					
					if ( ( JButton ) e.getSource() == stManager.getBotonBorrar() ) {
						
						Alumno alu = stManager.getListaAlumnos().getSelectedValue();
						DataResource.instancia().borrarAlumno( alu );
						
						int indice = stManager.getListaAlumnos().getSelectedIndex();
						DefaultListModel < Alumno > aluMod = (DefaultListModel<Alumno>) stManager.getListaAlumnos().getModel();
						aluMod.removeElementAt(indice);
						
					}
					
			}

	public GestorAlumnos getStManager() {
		return stManager;
	}
	
	}
*/
