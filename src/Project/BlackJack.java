package Project;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int players = input.nextInt();
        boolean winner = false;
        int[][] handPlayer = new int[players][5];
        char[] maso = { 'A', 'A', 'A', 'A', '1', '1', '1', '1', '2', '2', '2', '2', '3', '3', '3', '3', '4', '4', '4',
                '4',
                '5', '5', '5', '5', '6', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '8', '9', '9', '9', '9',
                'J', 'J', 'J', 'J', 'K', 'K', 'K', 'K', 'Q', 'Q', 'Q', 'Q' };
        // int before = 0;
        // for (char c : maso) {
        // if (before == c)
        // continue;
        // System.out.println(c + " ascii: " + ((int) c));
        // before = (int) c;
        // }

        for (int i = 0; i < players; i++) {
            handPlayer[i][0] = maso[(int) (Math.random() * 52)];
            handPlayer[i][1] = maso[(int) (Math.random() * 52)];
        }
        for (int i = 0; i < players; i++) {
            System.out.println(
                    "Jugador #" + (i + 1) + ": [" + (char) handPlayer[i][0] + "][" + (char) handPlayer[i][1] + "]");
        }
        while (!winner) {
            for (int i = 0; i < players; i++) {
                System.out.println("Turno del jugador #" + (i + 1));
                int card1 = 0, card2 = 0, card3 = 0, hand;
                switch (handPlayer[i][0]) {
                    case 65:
                        card1 = 11;
                        break;
                    case 49, 50, 51, 52, 53, 54, 55, 56, 57:
                        card1 = Integer.parseInt((char) handPlayer[i][0] + "");
                        break;
                    case 74, 75, 81:
                        card1 = 10;
                    default:
                        break;
                }
                switch (handPlayer[i][1]) {
                    case 65:
                        card2 = 11;
                        break;
                    case 49, 50, 51, 52, 53, 54, 55, 56, 57:
                        card2 = Integer.parseInt((char) handPlayer[i][1] + "");
                        break;
                    case 74, 75, 81:
                        card2 = 10;
                    default:
                        break;
                }
                System.out.println(card1 + " : " + card2);
                hand = card1 + card2 + card3;
                if (hand == 21)
                    winner = true;
                if (hand < 19) {
                    handPlayer[i][2] = maso[(int) (Math.random() * 52)];
                    card3 = Integer.parseInt((char) handPlayer[i][2] + "");
                }
                if (hand >= 19 && hand <= 21)
                    winner = true;
                if (hand > 21)
                    System.out.println("perdió el jugador #" + (i + 1));
            }
        }

        input.close();
    }
}
