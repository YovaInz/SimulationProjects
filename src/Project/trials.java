package Project;

import java.util.Scanner;

public class trials {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 400; i++) {
            if (i >= 100 && i <= 300 && i % 50 == 0)
                System.out.println(i);
        }

        input.close();
    }

}