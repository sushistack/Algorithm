import java.util.Scanner;

public class Problem4 {
    static String str1, str2;
    static char[] characterArray1, characterArray2;
    static int[] pi1, pi2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str1 = sc.nextLine();str2 = sc.nextLine();
        characterArray1 = str1.toCharArray();
        characterArray2 = str2.toCharArray();
        pi1 = new int[characterArray1.length];
        pi2 = new int[characterArray2.length];
    }


}
