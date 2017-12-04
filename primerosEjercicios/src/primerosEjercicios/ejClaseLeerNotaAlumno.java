package primerosEjercicios;
import java.util.Scanner;
public class ejClaseLeerNotaAlumno {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int nota;
		System.out.println("escribe la nota");
		nota=sc.nextInt();
		switch (nota) {
		case 10:
			System.out.println("MH");
			break;
		case 9:
			System.out.println("SB");
			break;
		case 8: 
		case 7:
			System.out.println("N");
			break;
		default:
			System.out.println("no suficiente");
			break;
			
		}
		
	}
}
