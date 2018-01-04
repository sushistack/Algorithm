import java.io.*;
import java.util.Arrays;

public class CF19B {
    static int n, t, c;
    static String[] ins;
    static Item[] items = new Item[2001];
    static long[] dp = new long[2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            ins = br.readLine().split(" ");
            t = Integer.parseInt(ins[0]);
            c = Integer.parseInt(ins[1]);
            items[i] = new Item(t, c);
        }
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > -1; j--) {
                if (dp[j] != -1) {
                    int to = j + items[i].t + 1;
                    if (to > n) to = n;
                    if (dp[to] == -1 || dp[to] > dp[j] + items[i].c) {
                        dp[to] = dp[j] + items[i].c;
                    }
                }
            }
        }

        bw.write(dp[n] + "\n");
        bw.flush();bw.close();


    }
    private static class Item implements Comparable<Item> {
        int t, c;
        Item(int t, int c) {
            this.t = t; this.c = c;
        }
        @Override
        public int compareTo(Item i) {
            return this.c > i.c ? 1 : -1;
        }
    }
}
