import java.util.Scanner;

public class HongikUniv5 {
    static int N, x = 0, minIndex = 0;
    static int[] list, prefix;
    static double[] means;
    static double min = Double.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); list = new int[N];
        prefix = new int[N];means = new double[N + 2];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }
        for (int i = 0; i < N - 1; i++) {
            means[i] = (list[i] + list[i + 1]) / 2.;
            if (means[i] < min) {
                min = means[i];
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
//    public static double getSubMean(int s, int d) {
//        if (d == s) return list[s];
//        if (d - s == 1) return (list[d] + list[s]) / 2.;
//        else {
//            int t = ((d + s) / 2);
//            double l = getSubMean(s, t);
//            double r = getSubMean(t, d);
//            return (l > r) ? l : r;
//        }
//    }

}
