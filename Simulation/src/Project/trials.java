package Project;

import java.util.ArrayList;
//import java.util.Scanner;

public class trials {
    // private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
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

}
