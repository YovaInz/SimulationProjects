package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class num_random {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("------------------------------");
            System.out.println("Numeros pseudo aleatorios:");
            System.out.println("------------------------------");
            System.out.println("1.-Medios cuadrados");
            System.out.println("2.-Newman");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.print("Introduzca la opcion: ");
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
        int opcion = 0;
        do {
            System.out.println("------------------------------");
            System.out.println("Medios cuadrados: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.print("Introduzca la opcion: ");
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
        int opcion = 0;
        do {
            System.out.println("------------------------------");
            System.out.println("Newman: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.print("Introduzca la opcion: ");
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
        ArrayList<Integer> numerosGenerados = new ArrayList<>();
        boolean repetido = true, escero = false;
        System.out.print("x0 = ");
        int semilla = leer.nextInt(),
                x1 = 0, cont = 1;
        String cadena_x1 = "";
        do {
            x1 = (int) Math.pow(semilla, 2); // se eleva x1 al cuadrado
            // System.out.println(x1);
            cadena_x1 = Integer.toString(x1);
            if (cadena_x1.length() < 8) {
                cadena_x1 = contarDigitos(cadena_x1);
            }
            cadena_x1 = cadena_x1.substring(2, 6);// toma los digitos del medio
            x1 = Integer.valueOf(cadena_x1);// se convierten los digitos del medio de string a int
            System.out.println("x" + cont + " = " + cadena_x1);// se imprime el numero nuevo generado
            if (!numerosGenerados.contains(x1)) {
                numerosGenerados.add(x1); // Agrega el nuevo número si no está repetido
            } else {
                repetido = false;
            }
            if (cadena_x1.charAt(0) == '0') {
                escero = true;
            }
            semilla = x1;
            cont++;
        } while (escero == false && repetido == true);
    }

    public static void medios_random() {
        ArrayList<Integer> numerosGenerados = new ArrayList<>();
        boolean repetido = true, escero = false;
        int semilla = (int) (Math.random() * (9999 - 1000 + 1) + 1000),
                x1 = 0, cont = 0;
        System.out.println("x0 = " + semilla);
        String cadena_x1 = "";

        do {
            x1 = (int) Math.pow(semilla, 2); // se eleva x1 al cuadrado
            // System.out.println(x1);
            cadena_x1 = Integer.toString(x1);
            if (cadena_x1.length() < 8) {
                cadena_x1 = contarDigitos(cadena_x1);
            }
            cadena_x1 = cadena_x1.substring(2, 6);// toma los digitos del medio
            x1 = Integer.valueOf(cadena_x1);// se convierten los digitos del medio de string a int
            System.out.println("x" + cont + " = " + cadena_x1);// se imprime el numero nuevo generado
            if (!numerosGenerados.contains(x1)) {
                numerosGenerados.add(x1); // Agrega el nuevo número si no está repetido
            } else {
                repetido = false;
            }
            if (cadena_x1.charAt(0) == '0') {
                escero = true;
            }
            semilla = x1;
            cont++;
        } while (escero == false && repetido == true);

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

    public static String contarDigitos(String cadenax1) {
        int ceros_faltantes = 0;
        String cadenamejorada = "";
        ceros_faltantes = 8 - cadenax1.length();

        for (int i = 0; i < ceros_faltantes; i++) {
            cadenamejorada = '0' + cadenax1;
        }

        return cadenamejorada;
    }

}
