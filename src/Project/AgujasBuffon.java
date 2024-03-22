package Project;

import java.awt.*;
import java.util.Scanner;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AgujasBuffon extends JFrame {
    private static Scanner leer = new Scanner(System.in);
    private static int skipAguja = 0;
    private JPanel contentPane;
    private float n; // Almacena el número de agujas

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
                    // dardos();
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
        // dardos = leer.nextInt();

        JFrame frame = new JFrame("Tablero de Dardos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DardosBuffon());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void agujas() {
        System.out.println("Cuantas agujas desea tirar?");
        int n = leer.nextInt();

        java.awt.EventQueue.invokeLater(() -> {
            try {
                AgujasBuffon frame = new AgujasBuffon(n);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AgujasBuffon(int n) { // Creacion el panel
        this.n = n; // Asigna el número de agujas a la variable de instancia
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0, 0, 800, 1000);
    }

    public void paint(Graphics g) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; // Cast Graphics to Graphics2D
        g2d.setColor(Color.blue);
        g2d.drawLine(0, 200, 800, 200); // Dibuja las lineas divisoras
        g2d.drawLine(0, 400, 800, 400);
        g2d.drawLine(0, 600, 800, 600);
        g2d.drawLine(0, 800, 800, 800);
        int contador_a = 0; // contador de lineas que tocan
        for (int i = 0; i < n; i++) {
            int[] coordenadas = generarCoordenadasAleatorias(); // se crea un array con los valores de las cordenadas de
                                                                // una
            dibujaaguja(g2d, coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);// se dibuja la linea con
                                                                                             // los valores generados
            if (coordenadas[1] / 200 != coordenadas[3] / 200) { // se divide y1 y y2 entre doscientos y si son
                                                                // diferentes significa que la linea comienza en un
                                                                // segmento y termina en otro
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
        if (skipAguja == 2)
            frame.setVisible(true);
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
                                                                                       // linea
        } while (longitud != 200); // se generara la linea hasta que la longitud de la linea sea igual a la
                                   // longitud entre las lineas divisiroras
        return new int[] { x1, y1, x2, y2 }; // se regresan las coordenadas de la linea
    }

    private void dibujaaguja(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2); // Dibuja una línea con las coordenadas generadas
    }
}
