package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class ruleta {
    public static void main(String[] args) {
        ArrayList<String> a_evento = new ArrayList<String>();
        Scanner leer = new Scanner(System.in);
        System.out.println("Coloque el numero de eventos:");
        double n_eventos = leer.nextInt();
        for (int i = 0; i < n_eventos; i++) {
            System.out.println("Coloque el nombre del evento: ");
            if (i == 0)
                leer.next();
            String evento = leer.nextLine();
            a_evento.add(evento);
        }
        double frec_abs = 1 / n_eventos; // Se define la frec abs, 1/n_eventos 1 porque todos tienen la misma
                                         // probabilidad de caer

        System.out.println("Coloque el numero de simulaciones:");
        int simulaciones = leer.nextInt();
        System.out.println("N.Sim\tN.elegido\tEvento elegido");
        for (int s = 1; s <= simulaciones; s++) {
            double intervalo_men = 0; // Se definen intervalos
            double intervalo_may = frec_abs;
            int n_evento = 1;
            double n_elegido = Math.random();// se elige un numero de 0 a 1
            String numeroFormateado = String.format("%.3f", n_elegido);
            do {
                if (n_elegido > intervalo_men && n_elegido < intervalo_may) { // Se compara numero elegido con los
                                                                              // intervalos
                    System.out.println(s + "\t" + numeroFormateado + "\t\t" + a_evento.get(n_evento));
                    break;
                }
                intervalo_men = intervalo_may; // Si el numero elegido no se encuentra dentro de los intervalos estos se
                                               // incrementan
                intervalo_may = intervalo_may + frec_abs;
                n_evento++;
            } while (true);
        }
        leer.close();
    }
}
