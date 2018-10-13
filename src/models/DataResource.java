package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DataResource {
	
	private Connection conMysql;
	private static final String ALUMNOCAMPOS = "Select dni , nombre, apellido , apellido_2 ";
	private DataResource() {
		conMysql = ConexionMySql.instancia().conectarMySql();		
	}
	
	private static DataResource instancia;
	
	public static DataResource instancia() {
		if (instancia == null) 
				instancia = new DataResource();
		return instancia; 
	}
	
	public ArrayList<Alumno> verAlumnos(){
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		try {
			PreparedStatement ps = conMysql.prepareStatement( ALUMNOCAMPOS + "from alumnos" );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				Alumno al = new Alumno(
							rs.getString("dni"),
							rs.getString("nombre"),
							rs.getString("apellido"),
							rs.getString("apellido_2") ); 				
				alumnos.add( al );
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return alumnos; 
	}
	
	public DefaultListModel<Alumno> modeloAlumno(){
		DefaultListModel<Alumno> alumnos = new DefaultListModel<Alumno>();
		try {	
			PreparedStatement ps = conMysql.prepareStatement( ALUMNOCAMPOS + "from alumnos" );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				if(!rs.getString("dni").isEmpty() ){
					Alumno al = new Alumno(
								rs.getString( "dni" ),
								rs.getString( "nombre" ),
								rs.getString( "apellido" ),
								rs.getString( "apellido_2" ) ); 
					
					alumnos.addElement( al );
				}
			}
			rs.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	public void borrarAlumno(Alumno alu) {
		Alumno al = alu;
		try {
			PreparedStatement ps = conMysql.prepareStatement("DELETE FROM alumnos where dni = ?" );
			ps.setString(1 , al.getDni());
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog( null, "El alumno " + al.getNombre() + ", con DNI " +al.getDni() + " fué eliminado correctamente. " );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
