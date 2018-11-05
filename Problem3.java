import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problem3 {
    static int n, x, y;
    static Point[] points;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();points = new Point[n];
        flag = true;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            x = sc.nextInt(); y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        Arrays.sort(points);
        for (int i = n - 1; i > -1; i--) {
            if (points[n - 1].y < points[i].y) {
                flag = false; break;
            }
        }
        System.out.println((flag) ? "YES" : "NO");
    }

}

