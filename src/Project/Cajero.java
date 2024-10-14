package Project;

import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String ope = "";
        int simula = 0;
        double ale1 = 0, ale2 = 0, molleg = 0, mollegant = 0, ti = 0, tie = 0, tt = 0, tte = 0, telleg = 0, tope = 0,
                topem = 0;
        // Pide al usuario la cantidad de simulaciones
        System.out.print("¿Cuántas simulaciones quieres realizar?");
        simula = leer.nextInt();
        for (int i = 1; i <= simula; i++) {
            System.out.println("Simulación #" + i);
            System.out.println(String.format("%-8s %-8s %-21s %-20s %-23s %-25s %-8s %-18s %-20s %-23s",
                    "Usuario", "#alea1", "Tiempo entre llegada", "Momento de llegada", "Tiempo inicia servicio",
                    "Tiempo espera / atención", "#ale2", "Operación", "Tiempo de Operación",
                    "Tiempo Termina el Servicio"));
            // Simulacion de los 100 clientes
            for (int j = 0; j < 100; j++) {
                ale1 = Math.random();
                ale2 = Math.random();
                telleg = (-Math.log(1 - ale1) / 30) * 60;
                molleg = telleg + mollegant;
                // Calculo de la operación
                if (ale2 <= 0.25) {
                    ope = "Consulta de Saldo";
                    tope = 80;
                    topem = 1.33;
                } else if (ale2 <= 0.5) {
                    ope = "Otros";
                    tope = 50;
                    topem = 0.83;
                } else if (ale2 <= 0.85) {
                    ope = "Retiros";
                    tope = 120;
                    topem = 2;
                } else {
                    ope = "Transferencia";
                    tope = 60;
                    topem = 1;
                }
                ti = molleg >= tt ? molleg : tt;
                tie = ti - molleg;
                tt = ti + topem;
                tte += tie;

                System.out.println(
                        String.format("%-8d %-8.5f %-21.5f %-20.5f %-23.5f %-25.5f %-8.5f %-18s %-20.0f %-27.5f",
                                (j + 1), ale1, telleg, molleg, ti, tie, ale2, ope, tope, tt));
                mollegant = molleg;
            }
            System.out.println("\nTiempo de espera: " + tte + "\n");
        }
        leer.close();
    }
}