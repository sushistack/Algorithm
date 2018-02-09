import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class B4803 {
    static int n, m, u, v, idx = 1;
    static String ins[];
    static ArrayList<Integer> g[] = new ArrayList[126001];
    static boolean[] visited = new boolean[501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 126000; i++) g[i] = new ArrayList<>();
        while (true) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            m = Integer.parseInt(ins[1]);
            if (n == 0 && m == 0) break;
            Arrays.fill(visited, false);
            for (int i = 1; i <= n; i++) g[i].clear();
            for (int i = 0; i < m; i++) {
                ins = br.readLine().split(" ");
                u = Integer.parseInt(ins[0]);
                v = Integer.parseInt(ins[1]);
                if (u == v) continue;
                g[u].add(v);g[v].add(u);
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                ans += dfs(i);
            }
            sb.append("Case ");sb.append(idx++);
            sb.append(": ");

            if (ans == 0) sb.append("No trees.");
            else if (ans == 1) sb.append("There is one tree.");
            else {
                sb.append("A forest of ");sb.append(ans);
                sb.append(" trees.");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static int dfs(int v) {
        Stack<Integer> s = new Stack<>();
        int node = 1, edge = 0;
        visited[v] = true;
        for (int i = 0; i < g[v].size(); i++) {
            int next = g[v].get(i);edge++;
            s.push(next);visited[next] = true;
        }

        while (!s.isEmpty()) {
            int cur = s.pop();node++;
            for (int i = 0; i < g[cur].size(); i++) {
                int next = g[cur].get(i);edge++;
                if (!visited[next]) {
                    s.push(next);visited[next] = true;
                }
            }
        }
        return ((edge >> 1) + 1 == node) ? 1 : 0;
    }
}
