package Project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ExamenUnidad2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.print("Cual es  la cantidad que desea ganar? ");
        int meta = input.nextInt(), corridas = 0, llega = 0;
        double randGen = 0;
        String gano = "", llego = "";
        System.out.println("#corrida   $antes   apuesta   #algen   gano?   $despues   llegó a la meta?");
        for (int i = 1; i <= 200; i++) {
            int antes = 30, despues = 30, apuesta = 10;
            do {
                randGen = Math.random();

                if (randGen < 0.5) {
                    despues += apuesta;
                    gano = "si";
                } else {
                    despues -= apuesta;
                    gano = "no";
                }
                if (despues >= meta) {
                    llega++;
                    llego = "si";
                } else
                    llego = "no";
                System.out
                        .println(i + "          " + antes + "       " + apuesta + "        "
                                + df.format(randGen) + " " + gano + "       "
                                + despues
                                + "           " + llego);
                if (randGen < 0.5) {
                    apuesta = 10;
                } else {
                    apuesta = apuesta * 2;
                }
                antes = despues;
                corridas++;
            } while (despues < meta && despues >= 0);
            System.out.println("---------------------------------------------");
        }
        System.out.println("La probabilidad de llegar a la meta es: " + ((double) llega / (double) corridas));
        input.close();
    }
}
