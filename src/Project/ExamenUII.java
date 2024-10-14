package Project;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ExamenUII {

	public static void main(String[] args) {
		Scanner Leer = new Scanner(System.in);
		int cant, count = 0;
		double aleat = 0;
		DecimalFormat df = new DecimalFormat("0.00000");
		String win = "", goal = "";
		System.out.println("================== JUEGO DE LOS VOLADOS ==================\n");
		System.out.println("Que cantidad desea ganar?");
		cant = Leer.nextInt();
		for (int i = 0; i < 200; i++) {
			System.out.println(
					"\n# CORRIDA\t\t$ ANTES\t\tAPUESTA\t\tNUMERO ALEATORIO\t\t�GAN�?\t\t$ DESPUES\t\t�SE LLEG� A LA META?");
			int before = 30, bet = 10, after = 30;
			do {
				aleat = Math.random();
				if (bet > after) {
					bet = after;
				}
				if (aleat < 0.5) {
					win = "Si";
					after += bet;
				} else {
					win = "No";
					after -= bet;
				}
				System.out.println((i + 1) + "\t\t" + before + "\t\t" + bet + "\t\t" + aleat + "\t\t" + win + "\t\t"
						+ after + "\t\t" + goal);
				before = after;
				if (after == 0) {
					break;
				}
				if (win == "No") {
					bet *= 2;
				} else if (win == "Si") {
					bet = 10;
				}
			} while (after <= cant);
			if (after == cant) {
				goal = "Si";
				count++;
			} else {
				goal = "No";
			}
		}
		System.out.println("La probabilidad de llegar a la meta es: " + (double) count / 200);
		Leer.close();
	}

}
