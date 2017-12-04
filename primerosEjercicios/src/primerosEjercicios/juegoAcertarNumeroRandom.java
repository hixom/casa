package primerosEjercicios;
import java.util.Scanner;
public class juegoAcertarNumeroRandom {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double numero, aleatorio;
		
		for (int i=0;i<5; i++) {
			System.out.print("di numero");
			numero =sc.nextDouble();
			aleatorio=Math.random();
			if (numero == aleatorio){
				System.out.println("pog kjaro jque si jcooooñooo, asertasteeeeee");
			}else {
				System.out.println("nooooooooooooooooo, no asertasteeeeee, el numero indicado era " + aleatorio);
			}
		}
	
	}
}
