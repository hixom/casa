package hundirLaFlota;
import java.util.Scanner;
public class juego {
	public static void main(String[] args) {
		//posiicondel barco
		int valorX;
		int valorY;
		int valorYFinal;
		int valorXFinal;
		int[] arrayFichasDoble= new int[3];
		int[] arrayFichasTriple= new int[2];
		int[] arrayFichasCuadruple = new int[1];
		
		
		
		//Preguntas tamaño barco
		Scanner sc=new Scanner(System.in);
		
		
		arrayFichasDoble=valoresFichas(4);
		
	
		arrayFichasTriple=valoresFichas(3);
		

		arrayFichasTriple=valoresFichas(1);
	
		terreno tablero= new terreno(10,10);
		
		for(int i = 0; i>4; i++) {
			
			tablero.InsertarFichas(valor, posicionArrayX, posicionArrayY)
			
		}
		
		
		for (int y=0; y < tablero.getTerreno().length ;y++){
			for (int x=0; x < tablero.getTerreno().length ;x++){
				System.out.print(tablero.getTerreno()[y][x]);
			} 
			System.out.println();
		}
		
		
	}

	
	public static int[] pedirValores() {
		int valorX;
		int valorY;
		int valorXFinal;
		int valorYFinal;
		int[] arrayValores= new int[4];
		
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Vamos a elegir la ficha que solo ocupa una casilla, procedamos...");
			System.out.println("introduce valor X");
			valorX = sc.nextInt();
			System.out.println("introduce valor y");
			valorY=sc.nextInt();
			System.out.println("introduce hasta que valor X");
			valorXFinal = sc.nextInt();
			System.out.println("introduce hasta que valor y");
			valorYFinal =sc.nextInt();
		}	while((valorX<0 || valorX>10 || valorY<0 || valorY>10) || (valorX != valorXFinal && valorY != valorYFinal ) );
		arrayValores[0] = valorX;
		arrayValores[1] = valorY;
		arrayValores[2] = valorXFinal;
		arrayValores[3] = valorYFinal;
		
		return arrayValores;
	}
	public static int[] valoresFichas(int nRepeticiones) {
		 int valorX;
		 int valorY; 
		 int valorXFinal; 
		 int valorYFinal;
		// int[] arrayValores=new int[4];
		Scanner sc=new Scanner(System.in);
		
		nRepeticiones -= 1;
		
		int[] arrayFichas=new int[nRepeticiones];
		
		for (int i=nRepeticiones; i>0; i--) {
		
	
		//crea un objeto en cada posicion del array y los valores de este los pasamos con una funcion-array
			Ficha arrayFichas[i] =  new Ficha( pedirValores() );
			
			
		}
		
		return arrayFichas;
	}
}