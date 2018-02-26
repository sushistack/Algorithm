import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B2075 {
    static int n, c = 4;
    static String ins[];
    static PriorityQueue<Long> pq  = new PriorityQueue<Long>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < n; j++) pq.offer(Long.parseLong(ins[j]));
        }
        while (n-- != 1) pq.poll();
        bw.write(pq.poll() + "\n");
        bw.flush();bw.close();
    }

}
