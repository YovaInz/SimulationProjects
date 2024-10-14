package Project;

import java.util.Scanner;

public class Simpson {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pregunta, unidad;
        double vReal, a, b;
        int n = 0;

        // System.out.print("Pregunta del problema: ");
        // pregunta = input.nextLine();
        // System.out.println("Unidad: ");
        // unidad = input.next();
        // System.out.print("Valor Real: ");
        // vReal = input.nextDouble();
        // System.out.print("a: ");
        // a = input.nextDouble();
        // System.out.print("b: ");
        // b = input.nextDouble();
        do {
            System.out.print(
                    "\tMetodo Reglas de Simpson\n*  Regla 1:  n=2. \n*  Regla 2:  n=3. \n*  Regla 3:  n>2 y n=par. \n*  Regla 4:  n>3, n=impar y n= *3. \n*   F I N :  n=0 \n\nCual es el numero de Divisones: ");
            n = input.nextInt();

            if (n == 2)
                A();
            else if (n == 3)
                B();
            else if (n > 2 && n % 2 == 0)
                C();
            else if (n > 3 && n % 3 == 0)
                D();
        } while (n != 0);

        input.close();
    }
}
