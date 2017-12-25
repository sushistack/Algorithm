import java.util.Scanner;

public class HongikUniv7 {
    static int S, T, D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt(); T = sc.nextInt();
        D = sc.nextInt();
        int time = D / (2*S);
        System.out.println(time * T);
    }
}
