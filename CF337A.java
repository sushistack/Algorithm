import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CF337A {
    static ArrayList<Integer> c = new ArrayList<>();
    static int n, m;
    static int[] f = new int[51];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            f[i] = Integer.parseInt(ins[i]);
        }
        Arrays.sort(f,0, m);
        for (int i = 0; i < n; i++) c.add(f[i]);
        int curMin = Collections.min(c, Integer::compareTo);
        int curMax = Collections.max(c, Integer::compareTo);
        int diff = curMax - curMin;
        for (int i = n; i < m; i++) {
            c.remove(0);c.add(f[i]);
            curMin = Collections.min(c, Integer::compareTo);
            curMax = Collections.max(c, Integer::compareTo);
            diff = Math.min(diff, curMax - curMin);
        }
        bw.write(diff + "\n");
        bw.flush();bw.close();
    }
}
