package Project;

import java.util.Scanner;

public class AgujaBuffon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Cuantas agujas desea lanzar? ");
        int n = input.nextInt(), a = 0;
        double rand, p, PI;
        for (int i = 0; i < n; i++) {
            rand = (Math.random() * 100);
            if (rand <= (2 * Math.PI))
                a++;
        }
        p = (double) a / (double) n;
        PI = ((double) 2 * n) / (double) a;
        System.out.println("- Probabilidad: " + p + "\n- A = " + a + "\n- N = " + n);
        System.out.println("PI ~ " + PI);
        input.close();
    }
}
