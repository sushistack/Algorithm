import java.io.*;
import java.util.PriorityQueue;

public class Line2 {
    static int uX, uY, s;
    static String ins[];
    static PriorityQueue<Store> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        uX = Integer.parseInt(ins[0]);
        uY = Integer.parseInt(ins[1]);
        s = Integer.parseInt(ins[2]);
        int tx, ty, tc;
        for (int i = 0; i < s; i++) {
            ins = br.readLine().split(" ");
            tx = Integer.parseInt(ins[0]);
            ty = Integer.parseInt(ins[1]);
            tc = Integer.parseInt(ins[3]);
            pq.offer(new Store(tx, ty, ins[2], tc));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Store store = pq.poll();
            sb.append(store.x);sb.append(" ");
            sb.append(store.y);sb.append(" ");
            sb.append(store.name);sb.append(" ");
            sb.append(store.c);sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static class Store implements Comparable<Store> {
        int x, y, c;
        String name;
        Store (int x, int y, String name, int c) {
            this.x = x;this.y = y;this.name = name;this.c = c;
        }

        @Override
        public int compareTo(Store o) {
            long d1 = getDist(this.x, this.y, uX, uY);
            long d2 = getDist(o.x, o.y, uX, uY);
            if (d1 > d2) return 1;
            else if (d1 < d2) return -1;
            else {
                if (this.c < o.c) return 1;
                else if (this.c > o.c) return -1;
                else {
                    return this.name.compareTo(o.name);
                }
            }
        }

        public long getDist(int x1, int y1, int x2, int y2) {
            int ans = (int)Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            ans -= (ans % 100);
            return ans;
        }
    }
}
