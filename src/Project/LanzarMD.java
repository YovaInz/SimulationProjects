package Project;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

import java.text.DecimalFormat;

public class LanzarMD {
    private static Scanner input = new Scanner(System.in);
    private static int op, x;
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static float rand;

    public static void main(String[] args) {

        do {
            System.out.print("======= QUE OBJETO DESEA LANZAR? =======\n1.- Moneda\n2.- Dado\n3.- Salir\nInput: ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    Moneda();
                    break;
                case 2:
                    Dado();
                    break;
                case 3:
                    System.err.println("FIN DEL PROGRAMA :)");
                    break;
                default:
                    System.err.println("Error: valor incorrecto, ingrese un valor entre 1 y 3");
                    break;
            }

        } while (op != 3);
    }

    public static void Moneda() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        ImageIcon img = new ImageIcon("Simulation/img/moneda.png");
        int aguila = 0, sello = 0;

        System.out.print("\n========= MONEDA =========\nCuantas veces desea lanzar la moneda? ");
        x = input.nextInt();
        System.out.println("N | RESULTADOS | LADO DE LA MONEDA");
        for (int i = 1; i <= x; i++) {
            rand = Float.parseFloat(df.format(Math.random()));
            if (rand > 0.5) {
                sello++;
                System.out.println(i + " |    " + rand + "    | SELLO");
            } else {
                aguila++;
                System.out.println(i + " |    " + rand + "    | AGUILA");
            }
        }

        dataset.setValue("Aguila (" + aguila + " veces)", aguila);
        dataset.setValue("Sello (" + sello + " veces)", sello);

        JFreeChart pieChart = ChartFactory.createPieChart("LANZAMIENTO DE MONERA", dataset);

        JFrame frame = new JFrame("Gráfica de pastel");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new ChartPanel(pieChart));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void Dado() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        ImageIcon img = new ImageIcon("Simulation/img/Dado.png");
        System.out.print("\n========= DADO =========\nCuantas veces desea lanzar el dado? ");
        int uno = 0, dos = 0, tres = 0, cuatro = 0, cinco = 0, seis = 0;
        x = input.nextInt();
        System.out.println("N | RESULTADOS | LADO DEL DADO");
        for (int i = 1; i <= x; i++) {
            rand = Float.parseFloat(df.format(Math.random())); // Genera un número aleatorio entre 0 y 1
            int trunc = (int) (rand * 6) + 1; // Asigna el valor al resultado del dado
            System.out.println(i + " |    " + rand + "    |       " + trunc);
            switch (trunc) {
                case 1:
                    uno++;
                    break;
                case 2:
                    dos++;
                    break;
                case 3:
                    tres++;
                    break;
                case 4:
                    cuatro++;
                    break;
                case 5:
                    cinco++;
                    break;
                case 6:
                    seis++;
                    break;
            }
        }

        dataset.setValue("1 (" + uno + " veces)", uno);
        dataset.setValue("2 (" + dos + " veces)", dos);
        dataset.setValue("3 (" + tres + " veces)", tres);
        dataset.setValue("4 (" + cuatro + " veces)", cuatro);
        dataset.setValue("5 (" + cinco + " veces)", cinco);
        dataset.setValue("6 (" + seis + " veces)", seis);

        JFreeChart pieChart = ChartFactory.createPieChart("LANZAMIENTO DE DADO", dataset);

        JFrame frame = new JFrame("Gráfica de pastel");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new ChartPanel(pieChart));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
