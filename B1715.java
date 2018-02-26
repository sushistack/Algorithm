import java.io.*;
import java.util.PriorityQueue;

public class B1715 {
    static int n, v, ans = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        while (n-- != 0) {
            v = Integer.parseInt(br.readLine());
            pq.offer(v);
        }
        while (pq.size() != 1) {
            int p = pq.poll(), q = pq.poll();
            ans += p + q;
            pq.offer(p + q);
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
