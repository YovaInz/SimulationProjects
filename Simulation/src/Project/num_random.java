package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class num_random {
    private static Scanner leer = new Scanner(System.in);
    private static int opcion = 0;
    private static long semilla;

    public static void main(String[] args) {

        do {
            System.out.println("------------------------------");
            System.out.println("Numeros pseudo aleatorios:");
            System.out.println("------------------------------");
            System.out.println("1.-Medios cuadrados");
            System.out.println("2.-Newman");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.print("Introduzca la opcion:");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    menu2();
                    break;

                case 2:
                    menu3();
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void menu2() {
        opcion = 0;
        do {
            System.out.println("------------------------------");
            System.out.println("Medios cuadrados: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.println("Introduzca la opcion:");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    medios_teclado();
                    break;

                case 2:
                    medios_random();
                    ;
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void menu3() {
        opcion = 0;
        do {
            System.out.println("------------------------------");
            System.out.println("Newman: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.println("Introduzca la opcion:");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    newman_teclado();
                    break;

                case 2:
                    newman_random();
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void medios_teclado() {
        /*
         * System.out.println("Introduce la semilla");
         * semilla = leer.nextInt();
         * int x1 = 0;
         * System.out.println(semilla);
         * String cadena_semilla = Integer.toString(semilla),
         * cadena_x1 = "";
         * // do {
         * x1 = (int) Math.pow(semilla, 2);
         * cadena_x1 = Integer.toString(x1);
         * contarDigitos(cadena_x1);
         * System.out.println(cadena_x1);
         * // } while (cadena_x1!="0000");
         */
    }

    public static void medios_random() {
        /*
         * semilla = (int) (Math.random() * (9999 - 1000 + 1) + 1000),
         * x1 = 0;
         * System.out.println(semilla);
         * String cadena_semilla = Integer.toString(semilla),
         * cadena_x1 = "";
         * // do {
         * x1 = (int) Math.pow(semilla, 2);
         * cadena_x1 = Integer.toString(x1);
         * String cadena_mejorada = contarDigitos(cadena_x1);
         * System.out.println(cadena_mejorada);
         * // } while (cadena_x1!="0000");
         */

    }

    public static void newman_teclado() {
        ArrayList<Long> NewmanList = new ArrayList<>();
        boolean repetido = false, escero = false;
        System.out.print("x0 = ");
        long semilla = leer.nextLong();
        String str = Newman(Long.toString(semilla * semilla));
        NewmanList.add(Long.parseLong(str));
        int cont = 1;
        do {
            long x = Long.parseLong(str);
            System.out.println("x" + cont + " = " + x);
            str = Newman(Long.toString(x * x));
            cont++;
            if (!NewmanList.contains(Long.parseLong(str))) {
                NewmanList.add(Long.parseLong(str));
            } else {
                System.out.println("x" + cont + " = " + str + "   ===REPETIDOOOO===");
                repetido = true;
            }
            if (str.charAt(0) == '0') {
                System.out.println("x" + cont + " = " + str + "   ===ES CEROOOOO===");
                escero = true;
            }
        } while (repetido == false && escero == false);
    }

    public static void newman_random() {
        ArrayList<Long> NewmanList = new ArrayList<>();
        boolean repetido = false, escero = false;
        long semilla = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
        System.out.println("x0 = " + semilla);
        String str = Newman(Long.toString(semilla * semilla));
        NewmanList.add(Long.parseLong(str));
        int cont = 1;
        do {
            long x = Long.parseLong(str);
            System.out.println("x" + cont + " = " + x);
            str = Newman(Long.toString(x * x));
            cont++;
            if (!NewmanList.contains(Long.parseLong(str))) {
                NewmanList.add(Long.parseLong(str));
            } else {
                System.out.println("x" + cont + " = " + str + "   ===REPETIDOOOO===");
                repetido = true;
            }
            if (str.charAt(0) == '0') {
                System.out.println("x" + cont + " = " + str + "   ===ES CEROOOOO===");
                escero = true;
            }
        } while (repetido == false && escero == false);
    }

    public static String Newman(String str) {
        if (str.length() % 2 == 0)
            str = "0" + str;

        StringBuilder sb = new StringBuilder(str);
        while (sb.length() != 5) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    /*
     * public static String contarDigitos(String str) {
     * int contador = 0;
     * for (char caracter : str.toCharArray()) {
     * if (Character.isDigit(caracter)) {
     * contador++;
     * }
     * }
     * 
     * if (contador < 8) {
     * }
     * return str;
     * }
     */

}
