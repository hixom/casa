package hundirLaFlota;

import java.util.Scanner;

public class pruebas {
	public static void main(String[] args) {
		int[][] arrayFichasDoble= new int[3][4];
		int[][] arrayFichasTriple= new int[2][6];
		int[][] arrayFichasCuadruple = new int[1][8];
		int[][] terrenoPlayer1= new int[10][10];
		int valor=3;
		terrenoPlayer1= ponerTodoNulo(terrenoPlayer1);
//		terrenoPlayer1[1][2]=25;
//		terrenoPlayer1[1][2]/=10;
//		terrenoPlayer1[1][2]= Math.abs(terrenoPlayer1[1][2]-10);
		System.out.println(terrenoPlayer1[1]);
//		Scanner sc=new Scanner(System.in);
	
//		int posicionY;
//		int posicionX;
//		int posicionYFinal;
//		int posicionXFinal;
//		int diferenciaX;
//		int diferenciaY;
//		int caso;
//		int[][] terrenoErroneo=new int[10][10];
//	
//		
//	
//			System.out.println("introduce valor Y por donde va a empezar la cardinalidad de la ficha");
//			posicionY=sc.nextInt();
//			posicionY=10-posicionY;
//			System.out.println("introduce valor X por donde va a empezar la cardinalidad de la ficha");
//			posicionX=sc.nextInt();
//			posicionX-=1;
//			System.out.println("introduce valor Y final de la cardinalidad de la ficha");
//			posicionYFinal=sc.nextInt();
//			posicionYFinal=-posicionYFinal+10;
//			System.out.println("introduce valor X final de la cardinalidad de la ficha");
//			posicionXFinal=sc.nextInt();
//			posicionXFinal-=1;
//			System.out.println("y "+posicionY+" x "+posicionX+" yfinal " + posicionYFinal+" xfinal "+ posicionXFinal);
		
		
		
		
//		int j;
//		for (int i=0;i<terrenoPlayer1.length;i++) {
//			for (j=0;j<terrenoPlayer1[0].length;j++) {
//				System.out.print(terrenoPlayer1[i][j]);
//			}
//			System.out.print("								");
//			for (j=0;j<terrenoPlayer1[0].length;j++) {
//				
//				System.out.print(terrenoPlayer1[i][j]);
//				
//			}
//			System.out.println("");
//		}
	}
	public static int[][] ponerTodoNulo(int[][] terreno) {
		for (int i=0;i<terreno.length;i++) {
			for (int j=0;j<terreno[0].length;j++) {
				terreno[i][j]=0;
			}
		}
		return terreno;
	}
}

