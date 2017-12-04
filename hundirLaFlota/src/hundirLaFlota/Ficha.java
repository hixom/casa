package hundirLaFlota;

public class Ficha {
	private int[] valores;
	private int valorX;
	private int valorY;
	private int valorYFinal;
	private int valorXFinal;
	
	public Ficha(int valorX, int valorY, int valorXFinal, int valorYFinal,int[] valores ){
		this.valorX=valores[0];
		this.valorY=valores[1];
		this.valorXFinal= valores[2];
		this.valorYFinal= valores[3];
	}
	
	public int getValorX(){
		return valorX;
	}
	public int getValorY(){
		return valorY;
	}
}
