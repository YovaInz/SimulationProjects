package Project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class licencias {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000000");
        int licCompradas = 0, licVen = 0, licDev = 0, ingVnt, ingDev, costo, media = 0, varianza = 0;
        double randGen = 0;
        String randStr = "";
        System.err.print("Cuantas veces deseas realizar la simulacion? ");
        int simulaciones = input.nextInt();
        int[] utilidades = new int[simulaciones];
        do {
            System.err.print("cuantas licencias desea comprar? [100/150/200/250/300]: ");
            licCompradas = input.nextInt();
        } while (licCompradas < 100 || licCompradas > 300 || licCompradas % 50 != 0);

        System.out.println(
                "N | #aleagen | Lic vendidas | Lic devueltas | Costo | Ing X Vta | Ing X Dev | Utilidad");

        for (int i = 0; i < simulaciones; i++) {
            randStr = df.format(Math.random());
            randGen = Double.parseDouble(randStr);

            if (randGen < 0.3)
                licVen = 100;
            else if (randGen < 0.5)
                licVen = 150;
            else if (randGen < 0.8)
                licVen = 200;
            else if (randGen < 0.95)
                licVen = 250;
            else
                licVen = 300;

            if (licVen > licCompradas)
                licVen = licCompradas;
            licDev = licCompradas - licVen;
            costo = (75 * licCompradas);
            ingVnt = (100 * licVen);
            ingDev = (25 * licDev);
            utilidades[i] = (ingDev + ingVnt) - costo;
            media += utilidades[i];
            System.out.println(
                    (i + 1) + " | " + randStr + " |     " + licVen + "      |      " + licDev + "      | "
                            + costo + " |   " + ingVnt + "   |   " + ingDev + "    |   " + utilidades[i]);
        }
        media /= simulaciones;
        for (int i = 0; i < utilidades.length; i++) {
            varianza += (utilidades[i] - media) * (utilidades[i] - media);
        }

        System.out.println("Media de las utilidades: " + media);
        System.out.println("Varianza de las utilidades: " + varianza / simulaciones);

        input.close();
    }
}
