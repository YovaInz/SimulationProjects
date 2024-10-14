package Project;

import java.text.DecimalFormat;

public class randNum {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#0.00000");
        for (int i = 1; i <= 50; i++) {
            System.out.print(i + ".- " + df.format((Math.random() * 50) + 50) + "\t");
        }
    }
}
