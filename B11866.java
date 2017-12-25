import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B11866 {
    static int N, M;
    static String in;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        N = Integer.parseInt(in.split(" ")[0]);
        M = Integer.parseInt(in.split(" ")[1]);
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            for (int i = 1; i < M; i++) {
                int t = q.poll();q.offer(t);
            }
            list.add(q.poll());
        }
        StringBuffer sb = new StringBuffer("<");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) sb.append(", ");
            else sb.append(">");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }
}
