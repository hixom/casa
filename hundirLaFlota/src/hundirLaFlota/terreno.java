package hundirLaFlota;

public class terreno {
	
	private int sizeX;
	private int sizeY;
	private String[][] campo;
	private Ficha[] fichas;
	
	public terreno(int  sizeX, int sizeY){
		campo = new String[sizeY][sizeX];
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		generarMapa();
		
		
	}
	
	private void generarMapa() {
		for (int y=0; y < sizeY ;y++){
			for (int x=0; x < sizeX ;x++){
				campo[y][x]="X";
			}
		}
	}
	
	public String[][] getTerreno() {
		
		return campo;
		
		
	}
	
	public  String[][] InsertarFichas(int[] valor, int posicionArrayX,int posicionArrayY) {
		valor[posicionArrayX] -= 1;
	
		valor[posicionArrayY] = Math.abs(valor[2] -10);
		
		for (int y=0; y < campo.length ;y++){
			for (int x=0; x < campo.length ;x++){
				if (valor[2] == y && valor[2] == x){
					campo[y][x]="O";
				}
			}
		}
		return campo;	
	}
	
}
