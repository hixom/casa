package primerosEjercicios;

import java.util.Scanner;

public class notasAlumnosBinarios {
	public static void main (String[] args) {
		int respuesta;
		Scanner sc=new Scanner(System.in);
		System.out.println("si quieres ordenar por mates escribe 0, si quieres por lengua 1");
		respuesta = sc.nextInt();
		int[][] notas = new int[3][2];
		String[] alumnos = new String[3];
		alumnos = rellenarAlumnos(3);
		if (respuesta == 0) {
			
		}
		
		
	}
	/*public static int[][] ordenarArray(int vecesX, int vecesY) {
		int[][] ristra=new int[vecesY][vecesX];
		ristra=rellenarArray(vecesY, vecesX);
		int recordatorio;
		for(int i=0;i<vecesY-1;i++) {
			for(int x=i+1;x<vecesX;x++)  {
				if (ristra[i][x]<ristra[x]) {
					recordatorio=ristra[i];
					ristra[i]=ristra[x];
					ristra[x]=recordatorio;
				}
			}
		}
		return ristra;
	}*/
	public static int[][] rellenarArray(int vecesX, int vecesY) {
		Scanner sc=new Scanner(System.in);
		int[][] ristra=new int[vecesY][vecesX];		
		
		for(int y=0;y<vecesY-1;y++) {
			for(int x=0;x<vecesX;x++)  {
				do {
					System.out.println("introduce un número");
					ristra[y][x]= sc.nextInt();
				}while(ristra[y][x]<=0);
			}
		}
		return ristra;
	}
	public static String[] rellenarAlumnos(int veces) {
		Scanner sc=new Scanner(System.in);
		String[] ristra=new String[veces];		
		
		for(int x=0;x<veces;x++)  {
					System.out.println("introduce un nombre");
					ristra[x]= sc.next();
			}
		return ristra;
	}
}
