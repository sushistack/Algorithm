import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class B11725 {
    static int n, u, v, p[] = new int[100001];
    static String ins[];
    static ArrayList<Integer>[] g = new ArrayList[100001];
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            ins = br.readLine().split(" ");
            u = Integer.parseInt(ins[0]);
            v = Integer.parseInt(ins[1]);
            g[u].add(v);g[v].add(u);
        }

        dfs(1);
        for (int i = 2; i <= n; i++) {
            sb.append(p[i]);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();

    }

    public static void dfs(int s) {
        Stack<Data> st = new Stack<>();
        boolean visited[] = new boolean[n + 1];
        for (int i = 0; i < g[s].size(); i++) {
            int next = g[s].get(i);
            st.push(new Data(next, next));
            p[next] = s;
            visited[next] = true;
        }
        while (!st.isEmpty()) {
            Data cur = st.pop();
            for (int i = 0; i < g[cur.node].size(); i++) {
                int next = g[cur.node].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    st.push(new Data(next, cur.sParent));
                    p[next] = cur.node;
                }

            }
        }
    }

    private static class Data {
        private int node, sParent;
        Data(int node, int sParent) {
            this.node = node;this.sParent = sParent;
        }
    }
}
