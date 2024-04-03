package Project;

import java.util.*;

public class DominoGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos jugadores quieren participar? ");
        int numPlayers = sc.nextInt();

        int[][] playerHands = new int[numPlayers][14];
        Random rand = new Random();

        for (int i = 0; i < numPlayers; i++) {
            Set<String> usedCombos = new HashSet<>();
            for (int j = 0; j < 7; j++) {
                int[] combo = new int[2];
                String comboStr;
                do {
                    combo[0] = rand.nextInt(6) + 1;
                    combo[1] = rand.nextInt(6) + 1;
                    Arrays.sort(combo);
                    comboStr = combo[0] + "-" + combo[1];
                } while (usedCombos.contains(comboStr));
                usedCombos.add(comboStr);
                playerHands[i][2 * j] = combo[0];
                playerHands[i][2 * j + 1] = combo[1];
            }
        }

        int[] mesa = new int[2];
        boolean firstMove = true;
        int currentPlayer = 0;
        while (true) {
            boolean played = false;
            for (int i = 0; i < 7; i++) {
                int[] combo = { playerHands[currentPlayer][2 * i], playerHands[currentPlayer][2 * i + 1] };
                if (combo[0] == 0 && combo[1] == 0) {
                    continue;
                }
                if (firstMove || combo[0] == mesa[0] || combo[1] == mesa[0] ||
                        combo[0] == mesa[1] || combo[1] == mesa[1]) {
                    mesa[0] = combo[0];
                    mesa[1] = combo[1];
                    playerHands[currentPlayer][2 * i] = 0;
                    playerHands[currentPlayer][2 * i + 1] = 0;
                    System.out.printf("Jugador %d juega %d-%d\n", currentPlayer + 1, combo[0], combo[1]);
                    played = true;
                    if (combo[0] == combo[1]) {
                        firstMove = false;
                    }
                    break;
                }
            }
            if (!played) {
                System.out.printf("Jugador %d no puede jugar, pasa\n", currentPlayer + 1);
            }
            boolean hasTiles = false;
            for (int i = 0; i < 14; i++) {
                if (playerHands[currentPlayer][i] != 0) {
                    hasTiles = true;
                    break;
                }
            }
            if (!hasTiles) {
                System.out.printf("Jugador %d gana!\n", currentPlayer + 1);
                break;
            }
            currentPlayer = (currentPlayer + 1) % numPlayers;
        }

    }

}
