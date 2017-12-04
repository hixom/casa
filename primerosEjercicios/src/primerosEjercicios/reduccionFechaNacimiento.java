package primerosEjercicios;
import java.util.Scanner;
public class reduccionFechaNacimiento {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int dia, mes, anio, fechaSuma;
		System.out.println("introduce dia");
		dia=sc.nextInt();
		System.out.println("introduce mes");
		mes=sc.nextInt();
		System.out.println("introduce año");
		anio=sc.nextInt();
		fechaSuma=dia+mes+anio;
		suma(fechaSuma);
		
		
	}	
	public static void suma(int fechaSuma){
		int valor=0;
		
		for (int i=0;i<4;i++) {
			valor=valor + fechaSuma%10;
			fechaSuma=fechaSuma/10;
		}
		System.out.println("la suma de todo eso es " + valor);
	}
	
}
