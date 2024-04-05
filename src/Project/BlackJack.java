package Project;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int players = input.nextInt();
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
        int turn = 0, stay = 0, house = 0, winNumber;
        int[] newCard = new int[players], hand = new int[players];
        boolean[] toStay = new boolean[players], out = new boolean[players];
        boolean houseWin = true;
        while (stay != players) {
            turn++;
            for (int i = 0; i < players; i++) {
                if (toStay[i] || out[i])
                    continue;
                int card1 = convertCard(handPlayer, i, 0), card2 = convertCard(handPlayer, i, 1);
                hand[i] = card1 + card2 + newCard[i];
                if (turn == 1) {
                    System.out.println("Mano inicial del jugador #" + (i + 1) + ": " + hand[i]);
                    continue;
                }
                System.out.println("===========================================");
                System.out.println("Turno del jugador #" + (i + 1) + "\n-mano actual: " + hand[i]);
                if (hand[i] == 21) {
                    System.out.println("BLACK JACK");
                    stay++;
                    toStay[i] = true;
                }
                if (hand[i] < 19) {
                    handPlayer[i][turn] = maso[(int) (Math.random() * 52)];
                    newCard[i] = convertCard(handPlayer, i, turn);
                    hand[i] += newCard[i];
                    System.out.println("-nueva carta: " + (char) handPlayer[i][turn] + " \n-nueva mano: " + hand[i]);
                }
                if (hand[i] >= 19 && hand[i] <= 21 && toStay[i] != true) {
                    stay++;
                    toStay[i] = true;
                    System.out.println("Se planta");
                }
                if (hand[i] > 21) {
                    System.out.println("perdió el jugador #" + (i + 1));
                    out[i] = true;
                    stay++;
                }
            }
        }

        for (int i = 0; i < players; i++) {
            if (toStay[i])
                System.out.println("jugador #" + (i + 1) + " se quedó con " + hand[i]);
            else if (out[i])
                System.out.println("jugador #" + (i + 1) + " se pasó con " + hand[i]);
        }

        while (house < 20) {
            char cardHouse = maso[(int) (Math.random() * 52)];
            switch (cardHouse) {
                case 65:
                    house += 11;
                    break;
                case 49, 50, 51, 52, 53, 54, 55, 56, 57:
                    house += Integer.parseInt(cardHouse + "");
                    break;
                case 74, 75, 81:
                    house += 10;
                default:
                    break;
            }
            System.out.println(cardHouse + " : " + house);
        }
        if (house == 21)
            System.out.println("LA CASA GANA");
        if (house < 21) {
            for (int i = 0; i < players; i++) {
                if (hand[i] >= house) {
                    System.out.println("GANA JUGADOR #" + (i + 1));
                    houseWin = false;
                }
            }
            if (houseWin)
                System.out.println("LA CASA GANA CON " + house);
        }
        if (house > 21) {
            System.out.println("LA CASA SE PASÓ");
        }
        input.close();
    }

    public static int convertCard(int[][] handPlayer, int player, int card) {
        int value = 0;
        switch (handPlayer[player][card]) {
            case 65:
                value = 11;
                break;
            case 49, 50, 51, 52, 53, 54, 55, 56, 57:
                value = Integer.parseInt((char) handPlayer[player][card] + "");
                break;
            case 74, 75, 81:
                value = 10;
            default:
                break;
        }
        return value;
    }
}
