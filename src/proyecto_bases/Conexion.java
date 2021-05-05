package proyecto_bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	Connection conexion=null;
	
	public Conexion() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root","root");
			
		}catch(SQLException sqle) {
			
			System.out.println("ERROR: " + sqle);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		}
	
		public Connection getConnection() {
		
		return conexion;
	}
	
		public void desconectar() {
			
		conexion =null;
	}

	

		
}