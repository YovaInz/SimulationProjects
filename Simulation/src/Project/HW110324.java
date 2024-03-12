package Project;

import java.util.Scanner;

public class HW110324 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("MANUAL... CANT_NUM: ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ".- " + (int) (Math.random() * 1000));
        }
        n = (int) (Math.random() * 1000);
        System.out.println("\nRANDOM... CANT_NUM_RAND: " + n);
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ".- " + (int) (Math.random() * 1000));
        }

        input.close();
    }
}
