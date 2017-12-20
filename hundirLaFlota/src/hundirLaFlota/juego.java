package hundirLaFlota;
import java.util.Scanner;
public class juego {
	public static void main(String[] args) {
		int[][] terrenoPlayer1= new int[10][10];
		int[][] terrenoPlayer2= new int[10][10];
		
		
		
		
		terrenoPlayer1= ponerTodoNulo(terrenoPlayer1);
		terrenoPlayer2= ponerTodoNulo(terrenoPlayer2);
		
		
		terrenoPlayer1=generarTerreno(terrenoPlayer1);
		terrenoPlayer1=generarTerreno(terrenoPlayer1);
		
		
	}
//	pone todos los valores del terreno en nulo para que pueda comparar y usar cualquier posicion del array
	public static int[][] ponerTodoNulo(int[][] terreno) {
		for (int i=0;i<terreno.length;i++) {
			for (int j=0;j<terreno[0].length;j++) {
				terreno[i][j]=-1;
			}
		}
		return terreno;
	}
//	sirve para comparar el terreno anterior con el erroneo (paso por esta todos los valores en vez de llamar a la función de generar el "terrenoErroneo" directamente porque si no crearíamos en la función de crearFichas 
//	una variable que es posible que no usemos y gastaríamos un espacio, cosa que siempre que se pueda evitar mejor)
	public static void mostrarErrores(int[][] terreno, int[][] terrenoErroneo){
		int j;
		System.out.println("El terreno de la izquierda es como lo tenías antes de meter esta ficha y el de la derecha es cómo queda."+
		" Los valores que estén en negativo son los que están mal situados por el espacio incorrecto que has dejado y las posiciones que estén repetidas, para que quede más claro presentarán el valor antiguo * el nuevo "+
				"más 1, de esa manera aun que superpongamos un valor 2 por otro 2 no lo confundiremos con una pieza de valor 4");
		for (int i=0;i<10;i++) {
			for (j=0;j<10;j++) {
				System.out.print(terreno[i][j]+"  ");
			}
			System.out.print("								");
			for (j=0;j<10;j++) {
				
				System.out.print(terrenoErroneo[i][j]+"  ");
				
			}
			System.out.println("");
		}
	}
//	sirve para comprovar si estan repetidos los valores intermedios de las fichas
	public static Boolean[] comprobarIntermedios(int[][] terreno,int posicionY, int posicionX, int diferenciaY, int diferenciaX, int posicionYFinal, int posicionXFinal, int diferenciaIntermedios ){
		Boolean[] ListaOcupadoIntermedios={false,false,false};
		
		if(diferenciaX==0 && diferenciaY==diferenciaIntermedios){
			for(int y = 0; y<terreno.length; y++ ) {
				for(int x = 0; x < terreno[y].length; x++ ) {
					if((x> posicionX) &&  (y > posicionY) && (x<posicionXFinal) && (y<posicionYFinal)){
						if(terreno[x][y]!=-1) {
							ListaOcupadoIntermedios[y]=true;
						}
					}
				}
			}
		}
			
		
		if(diferenciaX==diferenciaIntermedios && diferenciaY==0){	
			for(int y = 0; y<terreno.length; y++ ) {
				for(int x = 0; x < terreno[y].length; x++ ) {
					if((x> posicionX) &&  (y > posicionY) && (x<posicionXFinal) && (y<posicionYFinal)){
						if(terreno[x][y]!=-1) {
							ListaOcupadoIntermedios[y]=true;
						}
					}
				}
			}	
		}
		
		
		return ListaOcupadoIntermedios;
		
	}
//	sirve para generar el terreno con los valores definitivos	
	public static int[][] generarTerreno(int[][] terreno) {
		Scanner sc=new Scanner(System.in);
		Boolean[] ListaOcupadoIntermedios={false,false,false};
		
		
		int[][] posiciones;
		int diferenciaY; 
		int diferenciaX;
		
//		posiciones=new int[2][2];
//		for (int i=0;i<3;i++){
//			System.out.println("Vamos a prceder a seleccionar la posición de las fichas que pertenecen a dos coordenadas contiguas");
//			posiciones=preguntarValores(terreno,1,20+i);
//			
//			diferenciaY=Math.abs(posiciones[0][0]-posiciones[1][0]);
//			diferenciaX=Math.abs(posiciones[0][1]-posiciones[1][1]);
//			
//			terreno=ponerBarco(terreno, posiciones[0][0], posiciones[0][1],  posiciones[1][0], posiciones[1][1],  20+i, diferenciaY, diferenciaX, 1, ListaOcupadoIntermedios, false, false, false);
//			
//		}
		for (int i=0;i<2;i++){
			System.out.println("Vamos a prceder a seleccionar la posición de las fichas que pertenecen a tres coordenadas contiguas");
			
			posiciones=preguntarValores(terreno,2,30+i);
			diferenciaY=Math.abs(posiciones[0][0]-posiciones[1][0]);
			diferenciaX=Math.abs(posiciones[0][1]-posiciones[1][1]);
			terreno=ponerBarco(terreno, posiciones[0][0], posiciones[0][1],  posiciones[1][0], posiciones[1][1],  30+i, diferenciaY, diferenciaX, 2, ListaOcupadoIntermedios, false, false, false);	
		}
		System.out.println("Vamos a prceder a seleccionar la posición de las fichas que pertenecen a cuatro coordenadas contiguas");
			
		posiciones=preguntarValores(terreno,3,40);
		diferenciaY=Math.abs(posiciones[0][0]-posiciones[1][0]);
		diferenciaX=Math.abs(posiciones[0][1]-posiciones[1][1]);
		terreno=ponerBarco(terreno, posiciones[0][0], posiciones[0][1],  posiciones[1][0], posiciones[1][1],  40, diferenciaY, diferenciaX, 3, ListaOcupadoIntermedios, false, false, false);	
		
		
		

		
		
		return terreno;
		
	}
	public static int[][] preguntarValores(int[][] terreno,int diferenciaIntermedios, int valor){
		Scanner sc=new Scanner(System.in);
		
		Boolean ocupadoInicial=false;
		Boolean ocupadoFinal=false;
		Boolean[] ListaOcupadoIntermedios={false,false,false};
		Boolean ocupadoIntermedios=false;
		Boolean ValoresMalEspaciados=false;

		
		String satisfecho;
		
		int[][] posiciones=new int[2][valor];
		int posicionY;
		int posicionX;
		int posicionYFinal;
		int posicionXFinal;
		int diferenciaX;
		int diferenciaY;
		int[][] terrenoErroneo=new int[10][10];
		int[][] terrenoPrueba=new int[10][10];
		terrenoPrueba=terreno;
		terrenoErroneo=terreno;
		int j;
		do {
			System.out.println("introduce valor Y de la ficha "+ valor + " por donde va a empezar la cardinalidad de la ficha");
			posicionY=sc.nextInt();
			posicionY=-posicionY+10;
			
			System.out.println("introduce valor X de la ficha "+ valor + " por donde va a empezar la cardinalidad de la ficha");
			posicionX=sc.nextInt();
			posicionX-=1;
			terrenoPrueba[posicionY][posicionX]=valor;
			for (int i=0;i<10;i++) {
				for (j=0;j<10;j++) {
					System.out.print(terrenoPrueba[i][j]+"  ");
				}
				System.out.println("");
			}
			System.out.println("introduce valor Y de la ficha "+ valor + " final de la cardinalidad de la ficha");
			posicionYFinal=sc.nextInt();
			posicionYFinal=-posicionYFinal+10;
			
			System.out.println("introduce valor X de la ficha "+ valor + " final de la cardinalidad de la ficha");
			posicionXFinal=sc.nextInt();
			posicionXFinal-=1;
			terrenoPrueba[posicionYFinal][posicionXFinal]=valor;
			for (int i=0;i<10;i++) {
				for (j=0;j<10;j++) {
					System.out.print(terrenoPrueba[i][j]+"  ");
				}
				System.out.println("");
			}
			
			diferenciaX=Math.abs(posicionX-posicionXFinal);
			diferenciaY=Math.abs(posicionY-posicionYFinal);
			System.out.println("diferenciaY ="+diferenciaY+ " diferenciaX="+ diferenciaX);
			
//			detecta el error de si has metido algún valor que no está comprendido entre el 0 y el 10 (no pongo el "hayError=true" porque no podría reflejar un valor fuera del array)
			if(posicionY<0 || posicionY>10 || posicionX<0 || posicionX>10 || posicionYFinal<0 || posicionYFinal>10 ||posicionXFinal<0 || posicionXFinal>10){
				System.out.println("has metido algún valor que no está comprendido entre el 0 y el 10. Tus registros introducidos son los siguientes: "+posicionY +" " + posicionX+" " + posicionYFinal+" " + posicionXFinal);
			}
//			te avisa de que tienes un error con los valores intermedios por su espaciado. En caso de que no lo tengas procede a rellenar los valores intermedios (a menos que sea una ficha de 2 posiciones solo), 
//			ya que para la siguiente prueba de error necesitaremos estos valores
			
			if((diferenciaX != 0 && diferenciaX != diferenciaIntermedios) || (diferenciaY != 0 && diferenciaY != diferenciaIntermedios)){
				System.out.println("Las coordenadas que has introducido tienen espacios de más o de menos, o están en oblicuo");
				ValoresMalEspaciados=true;
			}
			if((diferenciaX>1) || (diferenciaY>1)){
				
					ListaOcupadoIntermedios=comprobarIntermedios(terreno,posicionY, posicionX, diferenciaY, diferenciaX, posicionYFinal, posicionXFinal, diferenciaIntermedios);
					
//			int[][] terreno,int posicionY, int posicionX, int diferenciaEjes, int caso, int valor, int diferenciaY, int diferenciaX, int diferenciaIntermedios, int posicionYFinal, int posicionXFinal
		
		
		
		
//			te avisa de que el error es que se repite
				if (terreno[posicionY][posicionX]!=-1){
					ocupadoInicial=true;
					System.out.println("La coordenada inicial que has dado está ya siendo usada");
				}
				if (terreno[posicionYFinal][posicionXFinal]!=-1){
					ocupadoFinal=true;
					System.out.println("La coordenada final que has dado está ya siendo usada");
				}
				for (int i=0;i<ListaOcupadoIntermedios.length;i++){
					if(ListaOcupadoIntermedios[i]==true)
					ocupadoIntermedios=true;
				}
				if (ocupadoIntermedios==true){
					System.out.println("En alguna de las coordenadas que corresponderían a los valores intermedios se repiten");
				}
			}
//			como puede ser frustrante el equivocarte y que no te muestren donde está concreto el error lo siguiente sirve como una ayuda más, ya que muestra como estaba el terreno antes de introducir esta ficha y como
//			ha quedado después de introducirla
			if(ocupadoFinal==true || ocupadoInicial==true || ocupadoIntermedios==true || ValoresMalEspaciados==true ){
				terrenoErroneo=ponerBarco(terrenoErroneo, posicionY, posicionX, posicionYFinal, posicionXFinal, valor, diferenciaY, diferenciaX, diferenciaIntermedios, ListaOcupadoIntermedios, ocupadoInicial, ocupadoFinal, ValoresMalEspaciados);
				mostrarErrores(terreno, terrenoErroneo);
				
			}
			do{	
				System.out.println("¿Estás satisfecho con tu elección?");
				satisfecho=sc.next();
			}while(!satisfecho.equals("si") && !satisfecho.equals("no"));
		}while((posicionY<0 || posicionY>10 || posicionX<0 || posicionX>10 || posicionYFinal<0 || posicionYFinal>10 ||posicionXFinal<0 || posicionXFinal>10  ) ||  
				ocupadoFinal==true || ocupadoInicial==true || ocupadoIntermedios==true || ValoresMalEspaciados==true || satisfecho.equals("no"));
		
		posiciones[0][0]=posicionY;
		posiciones[0][1]=posicionX;
		posiciones[1][0]=posicionYFinal;
		posiciones[1][1]=posicionXFinal;
		return posiciones;
	}
	
	public static int[][] ponerBarco(int[][] terreno, int posicionY, int posicionX, int posicionYFinal, int posicionXFinal, int valor, int diferenciaY, int diferenciaX, int diferenciaIntermedios, Boolean[] ListaOcupadoIntermedios, Boolean ocupadoInicial, Boolean ocupadoFinal, Boolean malEspaciado) {
		
		if(ocupadoInicial==true){
			terreno[posicionY][posicionX]+= valor;
		}else{
			terreno[posicionY][posicionX]=valor;
		 }
		
		if(ocupadoFinal==true){
			terreno[posicionYFinal][posicionXFinal]=+valor;
		}else{terreno[posicionYFinal][posicionXFinal]=valor;
		 }
		
		if(malEspaciado==true){
			terreno[posicionY][posicionX]=-valor;
		}
		
		
		
		
		
		
		if(diferenciaX>1 || diferenciaY>1){	
			if((posicionX - posicionXFinal)<0) {
			
				int recordatorio = posicionX;
				posicionX = posicionXFinal;
				posicionXFinal = recordatorio;
				
				
			}
		
			if((posicionY - posicionYFinal)<0) {
				
				int recordatorio = posicionY;
				posicionY = posicionYFinal;
				posicionYFinal = recordatorio;
				
			}
		
		
		
		
				
			if(diferenciaX==0 && diferenciaY==diferenciaIntermedios){
				for(int y = 0; y<terreno.length; y++ ) {
					for(int x = 0; x < terreno[y].length; x++ ) {
						if((x>= posicionX) &&  (y >= posicionY) && (x<=posicionXFinal) && (y<=posicionYFinal)) {
							if(ListaOcupadoIntermedios[x]==true){
								terreno[x][y] += valor;
							}else{terreno[x][y] = valor;}
						}
					}
				}
			}	
			
			if(diferenciaX==diferenciaIntermedios && diferenciaY==0){	
				for(int y = 0; y<terreno.length; y++ ) {
					for(int x = 0; x < terreno[y].length; x++ ) {
						if((x>= posicionX) &&  (y >= posicionY) && (x<=posicionXFinal) && (y<=posicionYFinal)) {
							if(ListaOcupadoIntermedios[x]==true){
								terreno[x][y] += valor;
							}else{terreno[x][y] = valor;}
						}
					}
				}	
			
			}
			
			
		}
			return terreno;
	}
		
}
	
