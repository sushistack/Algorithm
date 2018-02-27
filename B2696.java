import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B2696 {
    static int t, m, n, mid, count;
    static String ins[];
    static boolean first;
    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- != 0) {
            m = Integer.parseInt(br.readLine());
            maxPq.clear();minPq.clear();
            sb.append((m % 2 == 0) ? m >> 1 : (m >> 1) + 1);sb.append("\n");
            n = (m / 10) + (m % 10 == 0 ? 0 : 1);
            first = true;count = 0;
            while (n-- != 0) {
                ins = br.readLine().split(" ");
                for (int i = 0; i < ins.length; i++) {
                    int cur = Integer.parseInt(ins[i]);
                    if (first) {
                        mid = cur;first = false;
                        sb.append(mid);sb.append(" ");
                    }else {
                        if (count % 2 == 0) {
                            if (maxPq.peek() < cur) {
                                if (minPq.peek() > cur) mid = cur;
                                else {
                                    mid = minPq.poll();
                                    minPq.offer(cur);
                                }
                            }else {
                                mid = maxPq.poll();
                                maxPq.offer(cur);
                            }
                            sb.append(mid);
                            if (i < ins.length - 1) sb.append(" ");
                        }else {
                            if (mid < cur) {
                                minPq.offer(cur);
                                maxPq.offer(mid);
                            }else {
                                maxPq.offer(cur);
                                minPq.offer(mid);
                            }
                        }
                    }
                    count++;
                    if (count % 20 == 0) sb.append("\n");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
