package hundirLaFlota;
import java.util.Scanner;
public class juego {
	/*public static void main(String[] args) {
		//posiicondel barco
		int valorX;
		int valorY;
		int valorYFinal;
		int valorXFinal;
		int[][] arrayFichasDoble= new int[3][4];
		int[][] arrayFichasTriple= new int[2][6];
		int[][] arrayFichasCuadruple = new int[1][8];
		
		
		
		//Preguntas tamaño barco
		Scanner sc=new Scanner(System.in);
		
		
		arrayFichasDoble=valoresFichas(arrayFichasDoble.length,arrayFichasDoble[0].length);
		arrayFichasDoble=ponerTodoNulo(arrayFichasDoble,arrayFichasDoble.length,arrayFichasDoble[0].length);
	
		arrayFichasTriple=valoresFichas(arrayFichasTriple.length,arrayFichasTriple[0].length);
		arrayFichasTriple=ponerTodoNulo(arrayFichasTriple,arrayFichasDoble.length,arrayFichasDoble[0].length);

		arrayFichasCuadruple=valoresFichas(arrayFichasCuadruple.length,arrayFichasCuadruple[0].length);
		arrayFichasCuadruple=ponerTodoNulo(arrayFichasCuadruple,arrayFichasDoble.length,arrayFichasDoble[0].length);
	
		terreno tablero= new terreno(10,10);
		
		for(int i = 0; i>4; i++) {
			
			tablero.InsertarFichas(valor, 10, 10);
			
		}
		
		
		for (int y=0; y < tablero.getTerreno().length ;y++){
			for (int x=0; x < tablero.getTerreno().length ;x++){
				System.out.print(tablero.getTerreno()[y][x]);
			} 
			System.out.println();
		}
		
		
	}
	public static int[][] ponerTodoNulo(int[][] arrayFichas, int repeticiones1, int repeticiones2) {
		for (int i=0;i<repeticiones1;i++) {
			for (int j=0;j<repeticiones1;j++) {
				arrayFichas[i][j]=-1;
			}
		}
		return arrayFichas;
	}
	
	public static int[] valoresFichas(int nCoordenadas) {
		final int ULTIMO = nCoordenadas;
		final int PENULTIMO = nCoordenadas-1;
		
		int cantidadIntermediosX;
		int cantidadIntermediosY;
		int[] arrayValores= new int[nCoordenadas];
		int diferenciaX;
		int diferenciaY;
		
		
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Vamos a elegir la ficha que solo ocupa una casilla, procedamos...");
			for(int i=0; i<nCoordenadas;i++) {
				switch(i){
					case 0:	
						System.out.println("introduce valor X por donde va a empezar la cardinalidad de la ficha");
						arrayValores[i] = sc.nextInt();
						break;
					case 1:	
						System.out.println("introduce valor Y por donde va a empezar la cardinalidad de la ficha");
						arrayValores[i] = sc.nextInt();
						break;
					
					case PENULTIMO:  
						System.out.println("introduce valor X final de la cardinalidad de la ficha");
						arrayValores[i] = sc.nextInt();
						break;
					case ULTIMO:
						System.out.println("introduce valor Y final de la cardinalidad de la ficha");
						arrayValores[i] = sc.nextInt();
						break;
							
				}
			
			
			}
			
			diferenciaX=Math.abs(arrayValores[0]-arrayValores[PENULTIMO]);
			diferenciaY=Math.abs(arrayValores[1]-arrayValores[ULTIMO]);
			cantidadIntermediosX= nCoordenadas - diferenciaX;
			cantidadIntermediosY= nCoordenadas - diferenciaY;
			
/*			las lineas de abajo lo que hace es: en el while, en el primer paréntesis lo que hace es que se va a repetir mientras se
			haya introducido un valor fuera de 0...10. 
			El segundo, que se repita mientras no coincidan ni el valor de x 
			con xFinal ni y con yFinal.
			El siguiente paréntesis está compuesto de varios y para lo que sirven es para comparar la distancia que hay
			entre la primera cordenada y la final y si es diferente de 0 o diferente de la cantidad que debería tener 
			(si la ficha es de 3 coordenadas debería de haber una diferencia de 0 o 2) significa que o bien ha dejado 
			espacio de más o de menos o ha puesto uno en oblicuo
			
			los if son para avisar que tipo de error es ya que hay bastantes tipos y puede ser muy desquiciante
			estar equivocándose muchas veces sin saber un poco por qué
			
*/		
			/*if(arrayValores[0]<0 || arrayValores[0]>10 || arrayValores[1]<0 || arrayValores[1]>10 || 
			arrayValores[2]<0 || arrayValores[2]>10 || arrayValores[3]<0 || arrayValores[3]>10  ) {
				System.out.println("has introducido algún valor que no corresponde al intervalo que hay entre 0 y 10");
			}
			if((diferenciaX != 0 || diferenciaX != cantidadIntermediosX) && 
				(diferenciaY != 0 || diferenciaY != cantidadIntermediosY)) {
				System.out.println("has ha dejado espacio de más o de menos entre el valor inicial y el valor final de"+ 
				" alguna coordenada, o ha puesto alguna en oblicuo");
			}
		}while((arrayValores[0]<0 || arrayValores[0]>10 || arrayValores[1]<0 || arrayValores[1]>10 || 
				arrayValores[2]<0 || arrayValores[2]>10 || arrayValores[3]<0 || arrayValores[3]>10  ) ||  
				((diferenciaX != 0 || diferenciaX != cantidadIntermediosX) && 
				(diferenciaY != 0 || diferenciaY != cantidadIntermediosY)));
	
		
		return arrayValores;
	}
	/*public static int[][] valoresFichas(int nRepeticiones, int nCoordenadas) {
		
		int[][] arrayFichas=new int[nRepeticiones][nCoordenadas];
		
		for (int i=0; i<nRepeticiones; i--) {
			do {
				Ficha arrayFichas[i][] =  new Ficha( pedirValores(nCoordenadas) );
			}while (arrayFichas[i][])
			
			
			
		}
		
		return arrayFichas;
	}*/
}