import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B2108 {
    static int N, t, min = 4001, max = -4001, count, mid, d = 0;
    static double mean = 0.0;
    static int[] a = new int[8001];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            t = Integer.parseInt(br.readLine());
            min = Math.min(min, t);
            max = Math.max(max, t);
            a[t + 4000]++;
            mean += t;
        }
        mean /= (double)N;
        String t = String.format("%.0f", mean);
        StringBuffer sb = new StringBuffer();
        sb.append(t + "\n");
        //sb.append((int)mean + "\n");
        count = 0;
        for (int i = 0; i < 8001; i++) {
            count += a[i];
            if (count >= (N / 2) + 1) {
                mid = i;break;
            }
        }
        sb.append(mid - 4000 + "\n");
        for (int i = 0; i < 8001; i++) {
            d = Math.max(d, a[i]);
        }
        for (int i = 0; i < 8001; i++) {
            if (a[i] == d) list.add(i);
        }
        if (list.size() > 1)
            Collections.sort(list, Integer::compareTo);
        d = (list.size() > 1) ? list.get(1) : list.get(0);
        sb.append(d - 4000 + "\n");
        sb.append(max - min + "\n");
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
