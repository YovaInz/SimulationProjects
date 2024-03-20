package Project;

import java.util.Scanner;

public class Parachutist {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double m, V1 = 0, V2 = -2;
        int T = 0;
        final double g = 9.81, cf = 12.5;
        System.out.println(" ==================== SIMULACION DE UN PARACAHIDISTA ====================");

        System.out.println("PESO DEL PARACAHIDISTA");
        m = input.nextDouble();

        do {
            V2 = V1;
            V1 = ((m * g) / cf) * (1 - (Math.pow(Math.E, (-(cf / m) * T))));

            if ((Math.abs(V1 - V2) < 0.001) && T > 0)
                System.out.println(
                        "El paracaídas se abre en " + T + " segundos, al llevar una velocidad de " + V1 + "m/s");
            T++;
        } while (T <= 1 || Math.abs(V1 - V2) >= 0.001);

        input.close();
    }
}
