package proyecto_bases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insercion {

	BufferedWriter Fichero_insercion;
	
	Conexion conex_insercion;
	
	Scanner teclado_insercion;
	
	String Haz_insercion;
	
	Connection Inicio_conex;
	
	Statement s_insercion;
	
	
	public Insercion() {
		
		try {
			Fichero_insercion=new BufferedWriter(new FileWriter("D:\\Downloads\\bases_programacion\\Insercion.txt"));
	
			conex_insercion=new Conexion();
			
			teclado_insercion=new Scanner(System.in);
			
			System.out.println("Introduce consulta: ");
			
	     	 Haz_insercion=teclado_insercion.nextLine();
		
			 Inicio_conex=conex_insercion.getConnection();
			// Preparamos la consulta
			 s_insercion = Inicio_conex.createStatement();
			
			 s_insercion.executeUpdate (Haz_insercion);
			 
			 Fichero_insercion.write(Haz_insercion);
			 
			 Fichero_insercion.flush();
			 
			 Fichero_insercion.close();
			 
			 
			
		}catch (SQLException e) {
			System.out.println("SQL Exception: "+ e.toString());
		
		}catch(IOException ioe) {
		
		System.out.println(ioe + "Error");
		}
	}
}
