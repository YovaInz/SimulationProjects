package Project;

import java.util.Scanner;

import javax.swing.JFrame;

import java.text.DecimalFormat;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class Consulta {
    private static Scanner input = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.0000000000000000");

    public static void main(String[] args) {
        System.out.print("Cuantas veces desea realizar la simulacion? ");
        DefaultPieDataset dataset = new DefaultPieDataset();
        int n = input.nextInt(), nconsultas = 0, cero = 0, uno = 0, dos = 0, tres = 0, cuatro = 0, cinco = 0;
        double rand;
        System.out.println("n |       #aleagen       | consultas");
        System.err.println("====================================");
        for (int i = 1; i <= n; i++) {
            rand = Math.random();
            if (rand <= 0.05) {
                cero++;
                nconsultas = 0;
            } else if (rand <= 0.15) {
                uno++;
                nconsultas = 1;
            } else if (rand <= 0.35) {
                dos++;
                nconsultas = 2;
            } else if (rand <= 0.65) {
                tres++;
                nconsultas = 3;
            } else if (rand <= 0.85) {
                cuatro++;
                nconsultas = 4;
            } else if (rand <= 1.0) {
                cinco++;
                nconsultas = 5;
            }
            System.out.println(i + " |  " + df.format(rand) + "  |  " + nconsultas);
        }
        input.close();
        // Gráfica de pastel
        dataset.setValue("0 [" + cero + " veces]", cero);
        dataset.setValue("1 [" + uno + " veces]", uno);
        dataset.setValue("2 [" + dos + " veces]", dos);
        dataset.setValue("3 [" + tres + " veces]", tres);
        dataset.setValue("4 [" + cuatro + " veces]", cuatro);
        dataset.setValue("5 [" + cinco + " veces]", cinco);

        JFreeChart pieChart = ChartFactory.createPieChart("GRAFICA DE CONSULTAS", dataset);

        JFrame frame = new JFrame("GRAFICA DE CONSULTAS (DE PASTEL)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(pieChart));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("ABRIENDO GRAFICA DE PASTEL...");
    }
}