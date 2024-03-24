package Project;

import javax.swing.*;
import java.awt.*;
//import java.util.Scanner;

public class DardosBuffon extends JPanel {
    // private static Scanner input = new Scanner(System.in);
    private static int dardos = 0, skip = 0;
    private static double hip;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int radio = 100, centroX = getWidth() / 2, centroY = getHeight() / 2, X, Y, totac = 0;
        if (skip == 1) {
            for (int i = 5; i > 0; i--) {
                if (i % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillOval(centroX - i * radio / 5, centroY - i * radio / 5, i * radio / 5 * 2, i * radio / 5 * 2);
            }
            centroX -= 5;
            centroY -= 5;
            // Dibujar un punto verde en el centro del tablero
            g.setColor(Color.RED);
            g.fillOval(centroX, centroY, 10, 10);

            for (int i = 0; i < dardos; i++) {
                g.setColor(Color.RED);
                X = (int) (Math.random() * 100);
                Y = (int) (Math.random() * 100);
                if (i % 2 == 0) {
                    X *= -1;
                    Y *= -1;
                } else if (i % 3 == 0)
                    X *= -1;
                else if (i % 5 == 0)
                    Y *= -1;
                hip = Math.sqrt((X * X) + (Y * Y));
                if (hip <= 100) {
                    totac++;
                    System.out.println("total aciertos: " + totac + "\t hip: " + hip + "\t i: " + i);
                    g.setColor(Color.BLUE);
                }
                g.fillOval(centroX + X, centroY + Y, 6, 6);

            }

            System.out.println("totac: " + totac + "\tn: " + dardos);
            System.out.println("PI ~ " + ((double) totac / (double) dardos) * 4);
        }
        skip++;
    }

    public static void main(String[] args) {
        // System.out.print("Cuantos dardos desea lanzar? ");
        // dardos = input.nextInt();
        String inputStr = JOptionPane.showInputDialog("Cuantos dardos desea lanzar?");
        dardos = Integer.parseInt(inputStr);

        JFrame frame = new JFrame("Tablero de Dardos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DardosBuffon());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
