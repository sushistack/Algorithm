import java.util.HashMap;
import java.util.Scanner;

public class BaekJoon2261 {
    static int n, x, y;
    static long min = Long.MAX_VALUE;
    static HashMap<Integer, Point> hm = new HashMap<>();
    static Point prePoint, nextPoint;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x = sc.nextInt(); y = sc.nextInt();
            hm.put(i, new Point(x, y));
        }
        for (int i = 0; i < n; i++) {
            prePoint = hm.get(i);
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    nextPoint = hm.get(j);
                    min = Math.min(min,
                            (long)(Math.pow(nextPoint.x - prePoint.x, 2) +
                    Math.pow(nextPoint.y - prePoint.y, 2)));
                }
            }
        }
        System.out.println(min);
    }
    private static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if (x > o.x) return 1;
            else if (x < o.x) return -1;
            else {
                if (y > o.y) return 1;
                else if (y < o.y) return -1;
                else return 0;
            }
        }
    }
}

