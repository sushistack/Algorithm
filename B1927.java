import java.io.*;
import java.util.PriorityQueue;

public class B1927 {
    static int q, x;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- != 0) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                Object v = pq.poll();
                sb.append((v == null) ? 0 : (int)v);sb.append("\n");
            } else pq.offer(x);
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
