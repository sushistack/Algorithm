import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class B2014 {
    static int k, n, count = 0;
    static String ins[];
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static ArrayList<Long> primes = new ArrayList<>();
    static HashSet<Long> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        k = Integer.parseInt(ins[0]);
        n = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            long v = Long.parseLong(ins[i]);
            primes.add(v);pq.offer(v);
        }
        long ans = -1;
        while (count != n) {
            long v = pq.poll();
            if (!hs.contains(v)) {
                hs.add(v);count++;
                for (int i = 0; i < primes.size(); i++) {
                    pq.offer(v * primes.get(i));
                }
            }
            if (count == n) ans = v;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
