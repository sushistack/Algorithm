import java.util.Scanner;

public class BaekJoon2875 {
    static int N, M, K, team;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();K = sc.nextInt();
        team = (N / 2 < M) ? N / 2 : M;
        N -= team * 2;M -= team;
        K -= N;K -= M;
        while (K > 0 && team != 0) {
            team--;K -= 3;
        }
        System.out.println(team);
    }
}
