import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516 {
    static int n, time[] = new int[501], v, inDegrees[] = new int[501], result[] = new int[501];
    static ArrayList<Integer>[] edges = new ArrayList[501];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                v = Integer.parseInt(st.nextToken());
                if (v != -1) {
                    edges[v].add(i);
                    inDegrees[i]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                result[i] = time[i];
                q.offer(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            int cur = q.poll();
            for (int j = 0; j < edges[cur].size(); j++) {
                int next = edges[cur].get(j);
                result[next] = Math.max(result[next], result[cur] + time[next]);
                if (--inDegrees[next] == 0) q.offer(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
