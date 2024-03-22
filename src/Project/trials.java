package Project;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class trials extends JPanel {
    private static Scanner leer = new Scanner(System.in);
    private static int skipAguja = 0, skipDardos = 0, dardos;
    private float n; // Almacena el número de agujas
    private static double hip;

    // Constructor para la clase trials
    public trials() {
        // Aquí puedes agregar inicializaciones adicionales si lo necesitas
    }

    // Método paintComponent para dibujar en el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Cast Graphics to Graphics2D
        g2d.setColor(Color.blue);
        g2d.drawLine(0, 200, 800, 200); // Dibuja las líneas divisoras
        g2d.drawLine(0, 400, 800, 400);
        g2d.drawLine(0, 600, 800, 600);
        g2d.drawLine(0, 800, 800, 800);

        if (skipAguja == 1) {
            DefaultPieDataset dataset = new DefaultPieDataset();

            int contador_a = 0; // contador de líneas que tocan
            for (int i = 0; i < n; i++) {
                int[] coordenadas = generarCoordenadasAleatorias(); // se crea un array con los valores de las
                                                                    // coordenadas de una línea
                dibujaAguja(g2d, coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);// se dibuja la línea
                                                                                                 // con los valores
                                                                                                 // generados
                if (coordenadas[1] / 200 != coordenadas[3] / 200) { // se divide y1 y y2 entre 200 y si son diferentes
                                                                    // significa que la línea comienza en un segmento y
                                                                    // termina en otro
                    contador_a++;
                }
            }

            String resultados = calcularResultados(contador_a, n);
            imprimirResultados(resultados);

            // Grafica de pastel
            dataset.setValue("Aciertos[" + contador_a + "]", contador_a);
            dataset.setValue("No Aciertos[" + n + "]", n);

            JFreeChart pieChart = ChartFactory.createPieChart("LANZAMIENTO DE AGUJAS DE BUFFON", dataset);

            JFrame frame = new JFrame("Gráfica de pastel");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(new ChartPanel(pieChart));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        if (skipDardos == 1) {
            int radio = 100, centroX = getWidth() / 2, centroY = getHeight() / 2, X, Y, totac = 0;

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

        skipAguja++;
        skipDardos++;
    }

    public static void main(String[] args) {
        int op = 0;
        while (op != 3) {
            System.out.print("======= QUE OBJETO DESEA LANZAR? =======\n1.- Agujas\n2.- Dardos\n3.- Salir\nInput: ");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    agujas();
                    break;
                case 2:
                    dardos();
                    break;
                case 3:
                    System.err.println("FIN DEL PROGRAMA :)");
                    break;
                default:
                    System.err.println("Error: valor incorrecto, ingrese un valor entre 1 y 3");
                    break;
            }
        }
        leer.close(); // Cierra el Scanner después de usarlo
    }

    public static void dardos() {
        System.out.print("Cuantos dardos desea lanzar? ");
        dardos = leer.nextInt();

        JFrame frame = new JFrame("Tablero de Dardos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new trials());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void agujas() {
        System.out.println("Cuantas agujas desea tirar?");
        int n = leer.nextInt();

        java.awt.EventQueue.invokeLater(() -> {
            try {
                trials frame = new trials();
                frame.n = n;
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private String calcularResultados(int contador_a, float n) {
        double comprobante = (2 * (double) n) / (double) contador_a;
        return "Las agujas que chocan son: " + contador_a + "\n" + "2*" + n + "/" + contador_a + "=" + comprobante;
    }

    private void imprimirResultados(String resultados) {
        if (skipAguja == 1) {
            System.out.println(resultados);
        }
        skipAguja++;
    }

    private int[] generarCoordenadasAleatorias() {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, longitud = 0;
        do {
            x1 = (int) (Math.random() * getWidth()); // se genera x1
            y1 = (int) (Math.random() * getHeight()); // se genera y1
            x2 = (int) (Math.random() * getWidth()); // se genera x2
            y2 = (int) (Math.random() * getHeight()); // se genera y2
            longitud = (int) (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))); // se calcula la longitud de la
                                                                                       // línea
        } while (longitud != 200); // se generara la línea hasta que la longitud de la línea sea igual a la
                                   // longitud entre las líneas divisoras
        return new int[] { x1, y1, x2, y2 }; // se regresan las coordenadas de la línea
    }

    private void dibujaAguja(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2); // Dibuja una línea con las coordenadas generadas
    }

    public static void resultados(int contador_a, float n) {
        if (skipAguja == 1) {
            trials bufon = new trials();
            String resultados = bufon.calcularResultados(contador_a, n);
            bufon.imprimirResultados(resultados);
        }
        skipAguja++;
    }
}
