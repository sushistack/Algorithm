import java.util.Random;
import java.util.Scanner;

public class Testting {
    static int[][] cardTable = new int[5][5];
    static int[] cards = new int[16];
    static boolean[][] isCard = new boolean[5][5];
    static int x1, y1, x2, y2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createCard();
        while(true) {
            x1 = sc.nextInt(); y1 = sc.nextInt();
            if (x1 < 1 || x1 > 4 || y1 < 1 || y1 > 4) {
                System.out.println("rewrite!");continue;
            }
            x2 = sc.nextInt(); y2 = sc.nextInt();
            if (x2 < 1 || x2 > 4 || y2 < 1 || y2 > 4) {
                System.out.println("rewrite!");continue;
            }
            if (x1 == x2 && y1 == y2) {
                System.out.println("rewrite!");continue;
            }
            System.out.println("[" + x1 + ", " + y1 + "]: " + cardTable[x1][y1]);
            System.out.println("[" + x2 + ", " + y2 + "]: " + cardTable[x2][y2]);
            if (cardTable[x1][y1] == cardTable[x2][y2]) {
                isCard[x1][y1] = true; isCard[x2][y2] = true;
            }
            printCard();
            if (isAllCard()) break;
        }
    }
    public static void createCard() {
        for (int i = 0; i < 8; i++) {
            cards[i] = i + 1;cards[i + 8] = i + 1;
        }
        mixCard();
        for (int i = 1; i < cardTable.length; i++) {
            for (int j = 1; j < cardTable[i].length; j++) {
                cardTable[i][j] = cards[(i-1)*4 + (j-1)];
            }
        }
    }
    public static void mixCard() {
        Random r = new Random();
        for (int i = 0; i < cards.length - 1; i++) {
            int randomIndex = r.nextInt(15);
            int tmp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = cards[i];
        }
    }
    public static void printCard() {
        System.out.println("| 1 2 3 4");
        for (int i = 1;i < cardTable.length; i++) {
            System.out.print(i + " |");
            for (int j = 1; j < cardTable[i].length; j++) {
                System.out.print((isCard[i][j]) ? cardTable[i][j] + " " : "* ");
            }
            System.out.println();
        }
    }
    public static boolean isAllCard() {
        boolean flag = true;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (!isCard[i][j]) {
                    flag = false; break;
                }
            }
        }
        return flag;
    }
}
