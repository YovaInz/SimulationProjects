package Project;

import java.util.Scanner;

public class trials {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        while (str.length() != 3) {
            str = str.substring(1, str.length() - 1);
        }

        System.out.println(Math.pow(5, 6));

        System.out.println("SISISI: " + str);
        input.close();
    }

}