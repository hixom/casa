package primerosEjercicios;
import java.util.*;
public class busquedaArraysBinarios {
	public static void main (String[] args) {
		int[] ristraN= new int[5];
		ristraN=ordenarArray(ristraN.length);
		for(int i=0; i<ristraN.length; i++) {
			System.out.println("la posicion "+ i + " es un "+ ristraN[i]);
		}
	}
	public static int[] rellenarArray(int veces) {
		Scanner sc=new Scanner(System.in);
		int[] ristra=new int[veces];		
		for(int i=0; i<veces; i++) {
			do {
				System.out.println("introduce un número");
				ristra[i]= sc.nextInt();
			}while(ristra[i]<=0);
		}
		return ristra;
	}
	public static int[] ordenarArray(int veces) {
		int[] ristra=new int[veces];
		ristra=rellenarArray(ristra.length);
		int recordatorio;
		for(int i=0;i<veces-1;i++) {
			for(int x=i+1;x<veces;x++)  {
				if (ristra[i]<ristra[x]) {
					recordatorio=ristra[i];
					ristra[i]=ristra[x];
					ristra[x]=recordatorio;
				}
			}
		}
		return ristra;
	}
}