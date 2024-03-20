package Project;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class trials {
    private static Scanner input = new Scanner(System.in);
    private static int op, x;
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static float rand;

    public static void main(String[] args) {
        rand = 0.00f;

        int trunc = (int) (rand * 6) + 1;
        System.out.println(trunc);

        do {
            System.out.print("======= ¿QUÉ OBJETO DESEA LANZAR? =======\n1.- Moneda\n2.- Dado\nInput: ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    Moneda();
                    break;
                case 2:
                    Dado();
                    break;
                default:
                    System.err.println("Error: valor incorrecto, ingrese un valor entre 1 y 3");
                    break;
            }
        } while (op != 3);
    }

    public static void Moneda() {
        System.out.print("\n========= MONEDA =========\nCuantas veces desea lanzar la moneda? ");
        int aguila = 0, sello = 0;
        x = input.nextInt();

        // Crear un dataset para la gráfica de pastel
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (int i = 1; i <= x; i++) {
            rand = Float.parseFloat(df.format(Math.random()));
            if (rand > 0.5) {
                sello++;
            } else {
                aguila++;
            }
        }

        // Agregar los valores al dataset
        dataset.setValue("Águila", aguila);
        dataset.setValue("Sello", sello);

        // Crear la gráfica de pastel
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Resultados del lanzamiento de la moneda", dataset, true, true, true);

        // Mostrar la gráfica en una ventana
        JFrame frame = new JFrame("Gráfica de Pastel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new ChartPanel(pieChart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 400);
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void Dado() {
        System.out.print("\n========= DADO =========\nCuantas veces desea lanzar el dado? ");
        x = input.nextInt();
        // Implementa la lógica para el lanzamiento del dado aquí
    }
}
