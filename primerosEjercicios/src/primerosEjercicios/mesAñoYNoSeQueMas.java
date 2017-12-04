package primerosEjercicios;
import java.util.*;
public class mesAñoYNoSeQueMas {
	public static void main(String[] args) {
		int[] anio= new int[12];
		int mes;
		
	}
	public static boolean esPar(int n) {
		boolean numero=false;
		if (n%2==0) {
			numero=true;
		}
		return numero;
	}
	public static int[] pedirTempDia(int i) {
		Scanner sc=new Scanner(System.in);
		
		int[] dia= new int[i];
		int temperatura;
		
		for (int j=0;j<31;j++) {
			System.out.println("el dia " +j+ "que temperatura hizo (sin decimales)?");
			temperatura=sc.nextInt();
			dia[j]= temperatura;
		}
		return dia;
	}
	public static int[][] hacerAnio(){
		int[][] anio= new int [12][];
		for (int i=0;i<12; i++ ){
			if ((i<8 && esPar(i)==false)&&(i>7 && esPar(i)==true)) {
				anio[i]=new int[31];
				for (int j=0;j<31;j++) {
					System.out.println("del mes " + i+ "...");
					anio[i]= pedirTempDia(31);	
				}
			}else {
				anio[i]=new int[30];
				for (int j=0;j<30;j++) {
					System.out.println("del mes " + i+ "...");
					anio[i]= pedirTempDia(30);	
				}
			}
		}
		return anio;
	}
}