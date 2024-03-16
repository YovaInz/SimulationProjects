package Project;

import java.util.Scanner;
import java.text.DecimalFormat;

public class LanzarMD {
    private static Scanner input = new Scanner(System.in);
    private static int op, x;
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static float rand;

    public static void main(String[] args) {

        do {
            System.out.print("======= QUE OBJETO DESEA LANZAR? =======\n1.- Moneda\n2.- Dado\nInput: ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    Moneda();
                    break;
                case 2:
                    Dado();
                    break;
                default:
                    System.err.println("Error: valor incorrecto, ingrese un valor entre 1 y 3");
                    break;
            }

        } while (op != 3);
    }

    public static void Moneda() {
        System.out.print("\n========= MONEDA =========\nCuantas veces desea lanzar la moneda? ");
        int aguila = 0, sello = 0;
        x = input.nextInt();
        System.out.println("N | RESULTADOS | LADO DE LA MONEDA");
        for (int i = 1; i <= x; i++) {
            rand = Float.parseFloat(df.format(Math.random()));
            if (rand > 0.5) {
                sello++;
                System.out.println(i + " |    " + rand + "    | SELLO");
            } else {
                aguila++;
                System.out.println(i + " |    " + rand + "    | AGUILA");
            }
        }
    }

    public static void Dado() {
        System.out.print("\n========= DADO =========\nCuantas veces desea lanzar el dado? ");
        x = input.nextInt();
    }

}
