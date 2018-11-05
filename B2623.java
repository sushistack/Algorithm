import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2623 {
    static int n, m, cur, next, inDegrees[] = new int[1001];
    static String ins[];
    static ArrayList<Integer>[] nodes = new ArrayList[1001];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 1; i <= n; i++) nodes[i] = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cur = -1;
            st.nextToken();
            while(st.hasMoreTokens()) {
                next = Integer.parseInt(st.nextToken());
                if (cur != -1) {
                    nodes[cur].add(next);
                    inDegrees[next]++;
                }
                cur = next;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (q.isEmpty()) {
                flag = false;break;
            }
            int num = q.poll();
            sb.append(num);sb.append("\n");
            for (int j = 0; j < nodes[num].size(); j++) {
                inDegrees[nodes[num].get(j)]--;
                if (inDegrees[nodes[num].get(j)] == 0) q.add(nodes[num].get(j));
            }
            nodes[num].clear();
        }

        bw.write(flag ? sb.toString() : "0\n");
        bw.flush();bw.close();
    }

}
