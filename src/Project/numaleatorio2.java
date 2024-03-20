package Project;

import java.util.ArrayList;

public class numaleatorio2 {

    public static void main(String[] args) {
        int x0 = (int) (Math.random() * (1000 - 0) + 0);
        System.out.println("x0=" + x0);
        int m = generar_m();
        System.out.println("m=" + m);
        int a = generar_a();
        System.out.println("a=" + a);
        int c = generar_c();
        System.out.println("c=" + c);
        imprimir_tabla(x0, m, a, c);
    }

    public static int generar_m() {
        int m = 0;
        boolean primo = true;
        do {
            m = (int) (Math.random() * (1000));
            primo = esprimo(m);
        } while (!primo);
        return m;
    }

    public static int generar_a() {
        int a = 0;
        do {
            a = (int) (Math.random() * (1000));
            if (a % 2 == 0)
                continue; // quita numeros pares
            if (a % 3 != 0 && a % 5 != 0) { // que no sea divisible entre 3 ni 5
                return a;
            }
        } while (true);
    }

    public static int generar_c() {
        int c = 0;
        do {
            c = (int) (Math.random() * (10000));

            if (c / 200 == 21 && c % 200 == 0) {
                return c;
            }

        } while (true);

    }

    public static void imprimir_tabla(int x0, int m, int a, int c) {
        ArrayList<Integer> x0_generados = new ArrayList<>(); // array con todos los numeros generados
        int n = 0;

        System.out.println("n \t x \taxn+c \t(axn+c)/m \t xn+1");
        do {
            System.out.println(n + "\t" + x0 + "\t" + (a * x0 + c) + "\t " + ((a * x0 + c) / m) + "\t" + "\t "
                    + ((a * x0 + c) % m));
            if (!x0_generados.contains(x0)) {// comprueba si el numero no esta repetido
                x0_generados.add(x0); // Agrega el nuevo número si no está repetido
            } else {
                break;
            }
            x0 = ((a * x0 + c) % m);
            n++;

        } while (true);
    }

    public static boolean esprimo(double n) {
        // revisa si n es multiplo de 2
        if (n % 2 == 0)
            return false;
        // si no, solo revisa los impares
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
