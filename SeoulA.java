import java.util.Scanner;

public class SeoulA {
    static int T, P, M, F, C;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            P = sc.nextInt(); M = sc.nextInt();
            F = sc.nextInt(); C = sc.nextInt();
            int ch = M / P;
            int coupon = (ch * C);


        }
    }
}
