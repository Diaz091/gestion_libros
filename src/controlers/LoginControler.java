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

public class LoginControler implements ActionListener{

	private Login log;
	
	public LoginControler(Login l){
		
		this.log = l;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = log.getTxt().getText();
		
				try {
					
					Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();
					Connection	conMysql = DriverManager.getConnection( "jdbc:mysql://localhost:3306/gestion_libros?user=root&password=tiger");
					
					PreparedStatement ps = conMysql.prepareStatement("Select nombre from users where id = ?");
						ps.setString(1, id );
					ResultSet rs = ps.executeQuery();
					while( rs.next() ) {
						
						JOptionPane.showMessageDialog(null, rs.getString("nombre"));
						
					}
					rs.close();
					ps.close();
					conMysql.close();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		
	}
	

}
