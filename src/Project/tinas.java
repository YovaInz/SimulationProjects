package Project;

import java.util.Scanner;

public class tinas {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Cuantos años desea simular: ");
        int n = leer.nextInt();
        for (int i = 1; i <= n; i++) {
            int acumulo = 0;
            System.out.printf("Año %d\n", i);
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("Dia\tTINA\t#ALEA\tPESO SIMULADO\tPESO SIM.ACUMULADO\tEXCEDE CAPACIDAD?\tACUMULO");
            for (int d = 1; d <= 260; d++) {
                float p_tina_acum = 0;

                for (int t = 1; t <= 5; t++) {
                    double p_tina = 0;
                    double n_alea = Math.random();

                    if (n_alea < 0.5) {
                        p_tina = 190 + Math.sqrt(800 * n_alea);
                    } else if (n_alea > 0.5) {
                        p_tina = 230 - Math.sqrt(800 * (1 - n_alea));
                    } else {
                        p_tina = 210;
                    }

                    p_tina_acum += p_tina;
                    System.out.printf("%d\t%d\t%.5f\t%.2f\t%.2f\t", d, t, n_alea, p_tina, p_tina_acum);

                    if (p_tina_acum > 1000) {
                        acumulo += 200;
                        System.out.print("Si\t");
                    } else {
                        System.out.print("No\t");
                    }

                    System.out.println(acumulo);
                }
            }
            if (acumulo >= 50000)
                System.out.println("SALE MEJOR COMPRAR UN CAMIÓN");
            System.out.println("-------------------------------------------------------------------------------------");
        }
        leer.close();
    }
}