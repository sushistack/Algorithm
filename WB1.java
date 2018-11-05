import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class WB1 {
    static int n, d, k, j, v = 0, ans = 0, cur = 0, next;
    static String ins[], in;
    static ArrayList<Integer> q = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        d = Integer.parseInt(ins[1]);
        k = Integer.parseInt(ins[2]);
        j = Integer.parseInt(ins[3]);
        for (int i = 1; i <= n; i++) q.add(i);
        for (int i = 0; i < k; i++) rotation(d);
        q.remove(0);
        while (!q.isEmpty()) {
            k += j;
            if (q.size() == 1) {
                ans = q.get(0);
                break;
            }else {
                for (int i = 0; i < k - 1; i++) rotation(d);
                q.remove(0);
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    private static void rotation (int d) {
        if (d == 1) q.add(q.remove(0));
        else q.add(0, q.remove(q.size() - 1));
    }

}
