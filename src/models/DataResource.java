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
	private static final String LIBROCAMPOS  = "Select codigo_barras , isbn , titulo , autor , editorial , asignatura , estado ";
	private DataResource() {
		conMysql = ConexionMySql.instancia().conectarMySql();		
	}
	
	private static DataResource instancia;
	
	public static DataResource instancia() {
		if (instancia == null) 
				instancia = new DataResource();
		return instancia; 
	}
											// 	ALUMNOS \\
	/**
	 * Método qué devuelve un ArrayList con los Alumnos dados de alta en la BBDD. Si no hay alumnos JOpcionPane con mensaje informativo.
	 * @return ArrayList<Alumno> 
	 */
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
			
			if( alumnos.isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Actualmente, no hay ningún alumno dado de alta en nuestra Base de Datos", "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return alumnos; 
	}
	
	/** 
	 * Método que devuelve un modelo con los Alumnos de la BBDD. Si no hay alumnos JOpcionPane con mensaje informativo.
	 * @return DefaultListModel<Alumno>
	 */
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
			if( alumnos.isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Actualmente, no hay ningún alumno dado de alta en nuestra Base de Datos", "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {}
		return alumnos;
	}
	/**
	 * Método para borrar un alumno de la BBDD
	 * @param alu
	 * @return JOptionPane con mensaje.
	 */
	public void borrarAlumno(Alumno alu) {
		Alumno al = alu;
		try {
			PreparedStatement ps = conMysql.prepareStatement("DELETE FROM alumnos where dni = ?" );
			ps.setString(1 , al.getDni());
			ps.executeUpdate();
			JOptionPane.showMessageDialog( null, "El alumno " + al.getNombre() + ", con DNI " +al.getDni() + " fué eliminado correctamente. " );
		} catch (SQLException e) {}
		
	}
	
	
							// FIN ALUMNOS \\
	
							// LIBROS \\
	/**
	 * Método que carga DefaultListModel
	 * @return DefaultListModel
	 */
	public DefaultListModel<Libro> cargarModelo(){
		DefaultListModel<Libro>  modeloLibs = new DefaultListModel<Libro>();
		EstadoLibro eLibro = null;
		try {	
			PreparedStatement ps = conMysql.prepareStatement( LIBROCAMPOS + "from libros" );
			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				 				
				 	Libro lib = new Libro(
								rs.getString( "codigo_barras" ),
								rs.getString( "isbn" ),
								rs.getString( "titulo" ),
								rs.getString( "autor" ),
								rs.getString( "editorial" ),
								rs.getString( "asignatura" ),
								EstadoLibro.getEstado(rs.getString( "estado" ) ) ); 
					
					modeloLibs.addElement( lib );
			}
			rs.close();
			if( modeloLibs.isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Actualmente, no hay ningún alumno dado de alta en nuestra Base de Datos", "AVISO", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {}
	
		
		
		
		return modeloLibs; 
	}
	
	
	
	
							// USUARIOS LOGIN\\
	/**
	 * @return ID Usuario + Nombre Usuario;
	 */
	public String idUsuarios() {
		String str = "<html>";
			PreparedStatement ps;
			try {
				ps = conMysql.prepareStatement("Select id , nombre from users" );
				ResultSet rs = ps.executeQuery();
				while ( rs.next() ) {
					str += "- ID: " + rs.getString( "id" ) + " - Nombre: " + rs.getString( "nombre" ) + "<br>";
				}
				str+="</html>";
				rs.close();
				ps.close();
					return str;
			} catch (SQLException e) {}
					
			return null;
	}
	
}
