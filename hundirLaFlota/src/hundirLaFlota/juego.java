package hundirLaFlota;
import java.util.Scanner;
public class juego {
	public static void main(String[] args) {
		int[][] terrenoPlayer1= new int[10][10];
		int[][] terrenoPlayer2= new int[10][10];
		
		
		
		
		terrenoPlayer1= ponerTodoNulo(terrenoPlayer1);
		terrenoPlayer2= ponerTodoNulo(terrenoPlayer2);
		
		
		terrenoPlayer1=generarTerreno(terrenoPlayer1);
		terrenoPlayer2=generarTerreno(terrenoPlayer2);
		
		partida(terrenoPlayer1, terrenoPlayer2);
		
		
	}
	public static Boolean saberPar(int numero){
		Boolean respuesta=false;
		if (numero%2==0){
			respuesta=true;
		}
		return respuesta;
	}
	public static void partida(int[][] terrenoCompararPlayer1, int[][] terrenoCompararPlayer2){
		int[][] terreno;
		int[][] terrenoComparar;
		int[][] terrenoMuestraHundidosPorP1=new int[10][10];
		int[][] terrenoMuestraHundidosPorP2=new int[10][10];
		terrenoMuestraHundidosPorP1=ponerTodoNulo(terrenoMuestraHundidosPorP1);
		terrenoMuestraHundidosPorP2=ponerTodoNulo(terrenoMuestraHundidosPorP2);
		
		Boolean par=true;
		
		String satisfecho;
		
		
		Boolean hayContiguos=false;
		boolean acierto=false;
		boolean juegoTerminado=false;
		
		Scanner sc=new Scanner(System.in);
		
		int posicionY;
		int posicionX;
		int barcosHundidosPorPlayer1=0;
		int barcosHundidosPorPlayer2=0;
		int barcosHundidos;
		int numeroJugador;
		
		for(int i=0;juegoTerminado!=false;i++){
			par=saberPar(i);
			if (par==true){
				numeroJugador=1;
				terreno=terrenoMuestraHundidosPorP1;
				terrenoComparar=terrenoCompararPlayer2;
				barcosHundidos=barcosHundidosPorPlayer1;
				System.out.println("Es turno del Player"+numeroJugador+", di un coordenada.");
			}else{
				numeroJugador=2;
				terrenoComparar=terrenoCompararPlayer1;
				terreno=terrenoMuestraHundidosPorP2;
				barcosHundidos=barcosHundidosPorPlayer2;
				System.out.println("Es turno del Player2"+numeroJugador+", di un coordenada.");
			}
			do{
				do{
					do{
						
						System.out.println("Introduce el eje Y de la coordenada que quieres probar.");
						posicionY=sc.nextInt();
						posicionY=10-posicionY;
						System.out.println("Introduce el eje X de la coordenada que quieres probar.");
						posicionX=sc.nextInt();
						posicionX-= 1;
						
						terrenoComparar[posicionY][posicionX]=9;
						
						if(posicionY<1 || posicionY>10 || posicionX<1 || posicionX>10  ){
							System.out.println("Has introducido una coordenada que está fuera de las posibilidades");	
						}else{
							for (int y =0;y<10;y++) {
								if((i+1)>1){
									System.out.print(10-y+" | ");
								}else{
									System.out.print(10-y+"| ");
								}
								for (int x=0;x<10;x++) {
									System.out.print(terrenoComparar[y][x]+"  ");
								}
								System.out.println("");
							}
							System.out.println("__|_______________________________________");
							System.out.println("  |  "+1+"|  "+2+"|  "+3+"|  "+4+"|  "+5+"|  "+6+"|  "+7+"|  "+8+"|  "+9+"| "+10+"|");
							}
						
					}while(posicionY<1 || posicionY>10 || posicionX<1 || posicionX>10  );
					do{
						System.out.println("¿Estás satisfecho con tu elección? (si/no)");
						satisfecho=sc.next();
					}while(!satisfecho.equals("si")|| !satisfecho.equals("no"));
					if (satisfecho.equals("no")){
						terrenoComparar[posicionY][posicionX]=-1;
					}
				}while(satisfecho.equals("no"));
				terreno[posicionY][posicionX]=-1;
				if (terreno[posicionY][posicionX]>19){
					System.out.println("Barco tocado");
					hayContiguos=comprobarContiguos(terreno, posicionY, posicionX, terreno[posicionY][posicionX]);
					if(hayContiguos==false){
						System.out.println("Barco hundido o como diría Jasper Beardley <<A pique el portaviones>>");
						acierto=true;
						barcosHundidos++;
						if(barcosHundidos==6){
							juegoTerminado=true;
							System.out.println("La partida ha acabado, el jugador"+numeroJugador+" ha ganado la partida.");
							
						}
					}
				}else{
					System.out.println("Has caído en agua");
					terrenoComparar[posicionY][posicionX]=0;
				}
		}while(acierto==true && juegoTerminado==false );
		}
		
		
	}
//	funcion que comprueba si hay algun valor repetido alrededor de la posicion que le hemos dado
	public static Boolean comprobarContiguos(int[][] terreno, int posicionY, int posicionX, int valor){
		Boolean contestacion=false;
		for(int y=posicionY-1;(y<(y+3))|| contestacion==true ;y++){
			for(int x=posicionX-1;x<(x+3);x++){
				if(terreno[y][x]==valor){
					contestacion=true;
				}
			}
			
		}
		return contestacion;
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
			if((i+1)>1){
				System.out.print(10-i+" | ");
			}else{
				System.out.print(10-i+"| ");
			}
			System.out.print("								");
			if((i+1)>1){
				System.out.print(10-i+" | ");
			}else{
				System.out.print(10-i+"| ");
			}
			for (j=0;j<10;j++) {
				System.out.print(terrenoErroneo[i][j]+"  ");
			}
			System.out.print("								");
			
			for (j=0;j<10;j++) {
				System.out.print(terreno[i][j]+"  ");
			}
			System.out.println("");
		}
		System.out.println("__|_______________________________________");
		System.out.print("  |  "+1+"|  "+2+"|  "+3+"|  "+4+"|  "+5+"|  "+6+"|  "+7+"|  "+8+"|  "+9+"| "+10+"|");
		System.out.print("								");
		System.out.println("  |  "+1+"|  "+2+"|  "+3+"|  "+4+"|  "+5+"|  "+6+"|  "+7+"|  "+8+"|  "+9+"| "+10+"|");
	}
	
	
	
	
//	sirve para comprovar si estan repetidos los valores intermedios de las fichas
	public static Boolean[] comprobarOcupados(int[][] terreno,int posicionY, int posicionX, int diferenciaY, int diferenciaX, int posicionYFinal, int posicionXFinal, int diferenciaIntermedios, Boolean[] ListaOcupados ){

		
		if((posicionX - posicionXFinal)>0) {
			
			int recordatorio = posicionX;
			posicionX = posicionXFinal;
			posicionXFinal = recordatorio;
			
			
		}
	
		if((posicionY - posicionYFinal)>0) {
			
			int recordatorio = posicionY;
			posicionY = posicionYFinal;
			posicionYFinal = recordatorio;
			
		}
		
		if(diferenciaX==0 && diferenciaY==diferenciaIntermedios){
			for(int y = 0; y<terreno.length; y++ ) {
				for(int x = 0; x < terreno[y].length; x++ ) {
					if((x>= posicionX) &&  (y >= posicionY) && (x<=posicionXFinal) && (y<=posicionYFinal)){
						if(terreno[x][y]!=-1) {
							ListaOcupados[y]=true;
						}
					}
				}
			}
		}
			
		
		if(diferenciaX==diferenciaIntermedios && diferenciaY==0){	
			for(int y = 0; y<terreno.length; y++ ) {
				for(int x = 0; x < terreno[y].length; x++ ) {
					if((x>= posicionX) &&  (y >= posicionY) && (x<=posicionXFinal) && (y<=posicionYFinal)){
						if(terreno[x][y]!=-1) {
							ListaOcupados[y]=true;
						}
					}
				}
			}	
		}
		
		
		return ListaOcupados;
		
	}
	
	
	
	
	
//	sirve para generar el terreno con los valores definitivos	
	public static int[][] generarTerreno(int[][] terreno) {
		Scanner sc=new Scanner(System.in);
		
		boolean[] ListaOcupados;
		
		int[][] posiciones;
		int diferenciaY; 
		int diferenciaX;
		
		posiciones=new int[2][2];
		ListaOcupados=new boolean[posiciones.length];
//		for (int i=0;i<3;i++){
//			System.out.println("Vamos a prceder a seleccionar la posición de las fichas que pertenecen a dos coordenadas contiguas");
//			posiciones=preguntarValores(terreno,1,20+i,posiciones);
//			
//			diferenciaY=Math.abs(posiciones[0][0]-posiciones[1][0]);
//			diferenciaX=Math.abs(posiciones[0][1]-posiciones[1][1]);
//			
//			terreno=ponerBarco(terreno, posiciones[0][0], posiciones[0][1],  posiciones[1][0], posiciones[1][1],  20+i, diferenciaY, diferenciaX, 1, ListaOcupados);
//			
//		}
		posiciones=new int[3][2];
		ListaOcupados=new boolean[posiciones.length];
		for (int i=0;i<2;i++){
			System.out.println("Vamos a prceder a seleccionar la posición de las fichas que pertenecen a tres coordenadas contiguas");
			
			posiciones=preguntarValores(terreno,2,30+i,posiciones);
			diferenciaY=Math.abs(posiciones[0][0]-posiciones[1][0]);
			diferenciaX=Math.abs(posiciones[0][1]-posiciones[1][1]);
			terreno=ponerBarco(terreno, posiciones[0][0], posiciones[0][1],  posiciones[1][0], posiciones[1][1],  30+i, diferenciaY, diferenciaX, 2, ListaOcupados,false);	
			
			
			System.out.println("esto es lo que llevas introducido hasta ahora");
			
			for (int x=0;x<10;x++) {
				for (int y =0;y<10;y++) {
					System.out.print(terreno[x][y]+"  ");
				}
				System.out.println("");
			}
		}
		posiciones=new int[4][2];
		ListaOcupados=new boolean[posiciones.length];
		System.out.println("Vamos a prceder a seleccionar la posición de las fichas que pertenecen a cuatro coordenadas contiguas");
			
		posiciones=preguntarValores(terreno,3,40,posiciones);
		diferenciaY=Math.abs(posiciones[0][0]-posiciones[1][0]);
		diferenciaX=Math.abs(posiciones[0][1]-posiciones[1][1]);
		terreno=ponerBarco(terreno, posiciones[0][0], posiciones[0][1],  posiciones[1][0], posiciones[1][1],  40, diferenciaY, diferenciaX, 3, ListaOcupados, false);	
		
		return terreno;	
	}
	
//	esta función sirve para generar automáticamente los valores intermedios de las fichas para que no los tenga que escribir el usuario, y  de esa manera, haya menos probabilidades de meter una coordenada mal
	public static int[][] generarIntermedios(int[][] terreno, int diferenciaY, int diferenciaX, int posicionY, int posicionX, int posicionYFinal, int posicionXFinal,int diferenciaIntermedios, int[][] posiciones){
		
		if(diferenciaX==diferenciaIntermedios && diferenciaY==0){
			for(int i=0;i<(posiciones.length-1);i++){
				for(int y = 0; y<terreno.length; y++ ) {
					for(int x = 0; x < terreno[0].length; x++ ) {
						if((x> posicionX) &&  (y == posicionY) && (x<posicionXFinal) && (y==posicionYFinal)){
							posiciones[i][0]=posicionY;	
							posiciones[i][1]=x;
						}
					}
				}
			}
		}
			
	
		if(diferenciaX==0 && diferenciaY==diferenciaIntermedios){
			for(int i=0;i<(posiciones.length-1);i++){
				for(int y = 0; y<terreno.length; y++ ) {
					for(int x = 0; x < terreno[0].length; x++ ) {
						if((x== posicionX) &&  (y > posicionY) && (x==posicionXFinal) && (y<posicionYFinal)){
							posiciones[i][1]=posicionX;
							posiciones[i][0]=y; 
						}
					}
				}
			}
		}
		return posiciones;
	}
	
	
//	función que sirve para preguntar lo valores de las coordenadas de los barcos al jugador, después se confirmará mediante otras llamadas a funciones si hay o nó errores y en caso de que no, el jugador dirá si está conforme con su elección
//	El hecho de usar variables como posicionX y demás cuando valdría con posiciones[][] y su correspondiente posición, es básicamente comodidad a la hora de leer el código del programa, si lees posiciones[0][1] no es tan intuitivo.		
	public static int[][] preguntarValores(int[][] terreno,int diferenciaIntermedios, int valor, int[][] posiciones){
		Scanner sc=new Scanner(System.in);
		
		Boolean[] ListaOcupados=new Boolean[valor/10];
		
		for(int i=0;i<(valor/10);i++){
			ListaOcupados[i]=false;
		}
		
		boolean algunOcupado=false;
		boolean ValoresMalEspaciados=false;

		
		String satisfecho;
		
		int posicionY;
		int posicionX;
		int posicionYFinal;
		int posicionXFinal;
		int diferenciaX;
		int diferenciaY;
		int aux;
		int[][] terrenoErroneo=new int[10][10];
		int[][] terrenoPrueba=new int[10][10];
//		creamos un terreno de prueba al que le damos los valores del terreno primario, donde se iría mostrando como quedaría el terreno con las elecciones, con la comodidad de que solo alteramos los valores de terreno primigenio cuando todo está confirmado solo
		for(int i = 0; i<10; i++ ) {
			for(int j = 0; j < 10; j++ ) {
				aux=terreno[i][j];
				terrenoPrueba[i][j]=aux;
			}
		terrenoErroneo=ponerTodoNulo(terrenoErroneo);
			}
		int i;
		int j;
		do{
			do {
				System.out.println("introduce valor Y de la ficha "+ valor + " por donde va a empezar la cardinalidad de la ficha");
				posicionY=sc.nextInt();
				posicionY=-posicionY+10;
				posiciones[0][0]=posicionY;
				
				System.out.println("introduce valor X de la ficha "+ valor + " por donde va a empezar la cardinalidad de la ficha");
				posicionX=sc.nextInt();
				posicionX-=1;
				posiciones[0][1]=posicionX;
				terrenoPrueba[posicionY][posicionX]=valor;
				
				for ( i=0;i<10;i++) {
		
					if((i+1)>1){
						System.out.print(10-i+" | ");
					}else{
						System.out.print(10-i+"| ");
					}
					for (j=0;j<10;j++) {
						System.out.print(terrenoPrueba[i][j]+"  ");
					}
					System.out.println("");
				}
				System.out.println("__|_______________________________________");
				System.out.println("  |  "+1+"|  "+2+"|  "+3+"|  "+4+"|  "+5+"|  "+6+"|  "+7+"|  "+8+"|  "+9+"| "+10+"|");
				
				
				System.out.println("introduce valor Y de la ficha "+ valor + " final de la cardinalidad de la ficha");
				posicionYFinal=sc.nextInt();
				posicionYFinal=-posicionYFinal+10;
				posiciones[posiciones.length-1][0]=posicionYFinal;
				
				System.out.println("introduce valor X de la ficha "+ valor + " final de la cardinalidad de la ficha");
				posicionXFinal=sc.nextInt();
				posicionXFinal-=1;
				posiciones[posiciones.length-1][1]=posicionXFinal;
				
				diferenciaX=Math.abs(posicionX-posicionXFinal);
				diferenciaY=Math.abs(posicionY-posicionYFinal);
				
				posiciones=generarIntermedios(terreno, diferenciaY, diferenciaX, posicionY, posicionX, posicionYFinal, posicionXFinal, diferenciaIntermedios, posiciones);
				
				terrenoPrueba[posicionYFinal][posicionXFinal]=valor;
				
				for ( i=0;i<10;i++) {
					if((i+1)>1){
						System.out.print(10-i+" | ");
					}else{
						System.out.print(10-i+"| ");
					}
					for (j=0;j<10;j++) {
						System.out.print(terrenoPrueba[i][j]+"  ");
					}
					System.out.println("");
				}
				System.out.println("__|_______________________________________");
				System.out.println("  |  "+1+"|  "+2+"|  "+3+"|  "+4+"|  "+5+"|  "+6+"|  "+7+"|  "+8+"|  "+9+"| "+10+"|");
				
				
				
				
				
	//			detecta el error de si has metido algún valor que no está comprendido entre el 0 y el 10 (no pongo el "hayError=true" porque no podría reflejar un valor fuera del array)
				if(posicionY<1 || posicionY>10 || posicionX<1 || posicionX>10 || posicionYFinal<1 || posicionYFinal>10 ||posicionXFinal<1 || posicionXFinal>10){
					System.out.println("has metido algún valor que no está comprendido entre el 0 y el 10. Tus registros introducidos son los siguientes: "+posicionY +" " + posicionX+" " + posicionYFinal+" " + posicionXFinal);
				}
	//			te avisa de que tienes un error con los valores intermedios por su espaciado. En caso de que no lo tengas procede a rellenar los valores intermedios (a menos que sea una ficha de 2 posiciones solo), 
	//			ya que para la siguiente prueba de error necesitaremos estos valores
				
				if((diferenciaX != 0 && diferenciaX != diferenciaIntermedios) || (diferenciaY != 0 && diferenciaY != diferenciaIntermedios)){
					System.out.println("Las coordenadas que has introducido tienen espacios de más o de menos, o están en oblicuo");
					ValoresMalEspaciados=true;
				}
					
						ListaOcupados=comprobarOcupados(terreno,posicionY, posicionX, diferenciaY, diferenciaX, posicionYFinal, posicionXFinal, diferenciaIntermedios, ListaOcupados);
						
	
			
			
			
			
	//			te avisa de que el error es que se repite
						
						if (ListaOcupados[0]==true){
							algunOcupado=true;
							System.out.println("La coordenada que está más próxima del punto (1,1) que has dado, está ya siendo usada");
						}
						if(ListaOcupados.length>2){
							for ( i=1;i<ListaOcupados.length-1;i++){
								if(ListaOcupados[i]==true){
									System.out.println("La coordenada Intermedia nº "+i+" que has dado está ya siendo usada");
									algunOcupado=true;
								}
							}
						}
						if (ListaOcupados[ListaOcupados.length-1]==true){
							System.out.println("La coordenada que está más próxima del punto (10,10) que has dado, ya siendo usada");
						}
	//			como puede ser frustrante el equivocarte y que no te muestren donde está concreto el error lo siguiente sirve como una ayuda más, ya que muestra como estaba el terreno antes de introducir esta ficha y como
	//			ha quedado después de introducirla
				if(ListaOcupados[0]==true || ListaOcupados[ListaOcupados.length-1]==true || ocupadoIntermedios==true || ValoresMalEspaciados==true ){
					terrenoErroneo=ponerBarco(terrenoErroneo, posicionY, posicionX, posicionYFinal, posicionXFinal, valor, diferenciaY, diferenciaX, diferenciaIntermedios, ListaOcupados, ValoresMalEspaciados);
					mostrarErrores(terreno, terrenoErroneo);
					
				}
				
			}while((posicionY<1 || posicionY>10 || posicionX<1 || posicionX>10 || posicionYFinal<1 || posicionYFinal>10 ||posicionXFinal<1 || posicionXFinal>10  ) ||  
					ocupadoFinal==true || ocupadoInicial==true || ocupadoIntermedios==true || ValoresMalEspaciados==true);
			
			do{	
				System.out.println("¿Estás satisfecho con tu elección?");
				satisfecho=sc.next();
			}while(!satisfecho.equals("si") && !satisfecho.equals("no"));
			if(satisfecho.equals("no")){
				terrenoPrueba[posicionY][posicionX]=-1;
				terrenoPrueba[posicionYFinal][posicionXFinal]=-1;
			}
		}while(satisfecho.equals("no"));
		
		
		return posiciones;
	}
	
	public static int[][] ponerBarco(int[][] terreno, int posicionY, int posicionX, int posicionYFinal, int posicionXFinal, int valor, int diferenciaY, int diferenciaX, int diferenciaIntermedios, boolean[] ListaOcupados, boolean malEspaciado) {
		
		if(diferenciaX>1 || diferenciaY>1){	
			
			if((posicionX - posicionXFinal)>0) {
			
				int recordatorio = posicionX;
				posicionX = posicionXFinal;
				posicionXFinal = recordatorio;
				
				
			}
		
			if((posicionY - posicionYFinal)>0) {
				
				int recordatorio = posicionY;
				posicionY = posicionYFinal;
				posicionYFinal = recordatorio;
				
			}
		
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
		
		
	
		
		
		
		
				
			if(diferenciaX==0 && diferenciaY==diferenciaIntermedios){
				for(int y = 0; y<terreno.length; y++ ) {
					for(int x = 0; x < terreno[y].length; x++ ) {
						if(x >= posicionX &&  y >= posicionY && x <= posicionXFinal && y <= posicionYFinal) {
							if(ListaOcupados[x]==true){
								terreno[x][y] += valor;
							}else{terreno[x][y] = valor;}
						}
					}
				}
			}	
			
			if(diferenciaX==diferenciaIntermedios && diferenciaY==0){	
				for(int y = 0; y<terreno.length; y++ ) {
					for(int x = 0; x < terreno[y].length; x++ ) {
						System.out.println("en la posicion y="+y+" y en la posicion x="+x );
						
						if(x> posicionX){
							System.out.println("x> posicionX == true 			");
						}
						if(y > posicionY){
							System.out.println("y > posicionY == true			");
						}
						if(x<posicionXFinal){
							System.out.println("x<posicionXFinal == true			");
						}
						if(y<posicionYFinal){
							System.out.println("y<posicionYFinal == true			");
						}
						System.out.println("						");
						
						System.out.println("y="+posicionY+" x="+posicionX+" yF="+posicionYFinal+" xF="+posicionXFinal);
						if(x > posicionX &&  y == posicionY && x < posicionXFinal && y == posicionYFinal) {
							if(ListaOcupados[x]==true){
								terreno[y][x] += valor;
							}else{terreno[y][x] = valor;}
						}
					}
				}	
			
			}
		}
			return terreno;
	}
		
}
