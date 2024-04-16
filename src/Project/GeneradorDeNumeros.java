package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class GeneradorDeNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> midsqueredList = new ArrayList<>();
        ArrayList<Integer> varianzaList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean repeat = true, duplicate = false;
        int seed, n = 0, seedSquared;
        double media = 0, varianza = 0;
        String seedStr, seedSquaredStr = "";
        do {
            System.out.print("semilla inicial: ");
            seed = input.nextInt();
            seedStr = "" + seed;
        } while (seedStr.length() != 3);
        midsqueredList.add(seed);
        System.err.println("| N | SEMILLA | AL CUADRADO | N.INTERNO | SIG.NUM |");
        do {
            seedSquared = seed * seed;
            seedSquaredStr = Integer.toString(seedSquared);

            do {
                if (seedSquaredStr.length() % 2 == 0) {
                    seedSquaredStr = "0" + seedSquaredStr;
                } else if (seedSquaredStr.length() >= 3 && seedSquaredStr.length() < 7) {
                    seedSquaredStr = "0" + seedSquaredStr + "0";
                }
            } while (seedSquaredStr.length() != 7);

            StringBuilder sb = new StringBuilder(seedSquaredStr);
            while (sb.length() != 3) {
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
            }

            System.out.println("| " + n + " |   " + seedStr + "   |   " + seedSquaredStr + "   |    " + sb + "    |   "
                    + sb + "   |");

            seed = Integer.parseInt(sb.toString());
            seedStr = sb.toString();

            if (!midsqueredList.contains(seed)) { // si midsqueredList no tiene este valor
                midsqueredList.add(seed); // agrega este valor
            } else { // caso contrario
                duplicate = true; // se duplicó
            }
            if (seed == 0 || duplicate == true) {
                repeat = false;
                continue;
            }
            n++;
            media += seed;
            varianzaList.add(seed);
        } while (repeat);

        for (Integer integer : varianzaList) {
            varianza += Math.pow(integer - media, 2);
        }

        System.out.println("\n- MEDIA: " + (media / n));
        System.out.println("- VARIANZA: " + (varianza / n));
        input.close();
    }

}