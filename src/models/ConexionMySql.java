package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {
	
	private static  ConexionMySql  INSTANCE = null ; 
	
		private ConexionMySql() {
			
		}
	
		public static ConexionMySql instancia() {
			
			if (INSTANCE == null)
				INSTANCE = new ConexionMySql();
			return INSTANCE;
		}
		
		public Connection  conectarMySql() {
			
			Connection	conMysql = null;
			try {
				Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();
				String conexion = "jdbc:mysql://localhost:3306/gestion_libros?user=root&password=tiger&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				conMysql = DriverManager.getConnection( conexion );
				
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
					return conMysql;
			
		}
	

}
