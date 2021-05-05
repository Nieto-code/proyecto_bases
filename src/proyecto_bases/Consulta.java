package proyecto_bases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consulta {

	BufferedWriter Fichero_consulta;
	
	Conexion conex;
	
	Scanner teclado;
	
	String consulta;
	
	Connection Inicio_conex;
	
	Statement s;
	
	ResultSet rs;
	
	ResultSetMetaData rsmd;
		
	public Consulta() {
		
		try {
			Fichero_consulta=new BufferedWriter(new FileWriter("D:\\Downloads\\bases_programacion\\consulta.txt"));
	
			conex=new Conexion();
			
			teclado=new Scanner(System.in);
			
			System.out.println("Introduce consulta: ");
			
	     	 consulta=teclado.nextLine();
		
			 Inicio_conex=conex.getConnection();
			// Preparamos la consulta
			 s = Inicio_conex.createStatement();
			
			 rs = s.executeQuery (consulta);
			
			 rsmd=rs.getMetaData();
			 
			
		}catch (SQLException e) {
			System.out.println("SQL Exception: "+ e.toString());
		
		}catch(IOException ioe) {
		
		System.out.println(ioe + "Error");
		}
	}
public void Recorre_consulta() {
	
	try {
		
			int colCount= rsmd.getColumnCount();
			
			for (int j=1; j<=colCount;j++) {
				
				System.out.print(rsmd.getColumnName(j) + " | ");
				
				Fichero_consulta.write(rsmd.getColumnName(j) + " | ");
				
			}
		
			System.out.println("");
			
			Fichero_consulta.newLine();
			// Iteramos sobre los registros del resultado
			while (rs.next()) {
				
				
				//System.out.println("Datos para la fila: " + rowCount);
				for(int i=1;i <= colCount; i++) {
					
					System.out.print( rs.getString(i)  + "\t");
					Fichero_consulta.write(rs.getString(i)  + "\t");
					
				}
				
			System.out.println("");
			}
			
		
			rs.close();
			s.close();
			Fichero_consulta.flush();
			Fichero_consulta.close();
			
	
			}catch(IOException ioe2) {
	
			System.out.println(ioe2 + "Error");
			
			}catch (SQLException e2) {
				System.out.println("SQL Exception: "+ e2.toString());

			}
	}	
	
}
