package proyecto_bases;
import java.util.Scanner;
public class Ejecucion_sql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner S_menu =new Scanner(System.in);
		boolean salir_menu =false;
		int opcion;
		
		while(!salir_menu) {
			System.out.println("Introduce nu numero entre 1 y 4:");
			System.out.println("1. Consulta");
			System.out.println("2. Insercion");
			System.out.println("3. Actualizacion");
			System.out.println("4. Borrado");
			System.out.println("5. Salir del programa");
			
			opcion=S_menu.nextInt();
			
			switch(opcion) {
			
			case 1:
				
				Consulta Haz_consulta=new Consulta();
				Haz_consulta.Recorre_consulta();
				
				break;
			
			case 2:
				
				Insercion Haz_insercion=new Insercion();
				
				break;
			
			case 3:
				
				Actualizacion Haz_actualizaxion=new Actualizacion();
				
				break;
			
			case 4:
				
				Borrado Haz_borrado=new Borrado();
				
				break;
				
			case 5:
				
				salir_menu=true;
				
				break;
				
			default:
				
				System.out.println("Introduce un numero del 1 al 5:");
			}
			
		}
			
	}

}
