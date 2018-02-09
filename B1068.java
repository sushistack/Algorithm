import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class B1068 {
    static int n, cut, start;
    static String ins[];
    static ArrayList<Integer>[] g = new ArrayList[51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int u = Integer.parseInt(ins[i]);
            if (u == -1) {
                start = i;continue;
            }
            g[i].add(u);g[u].add(i);
        }
        cut = Integer.parseInt(br.readLine());

        bw.write((cut == start) ? 0 + "\n" : dfs(start) + "\n");
        bw.flush();bw.close();

    }
    public static int dfs(int v) {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[n];
        s.push(v);visited[v] = true;
        int leaf = 0;
        while (!s.isEmpty()) {
            int cur = s.pop(), count = 0;
            for (int i = 0; i < g[cur].size(); i++) {
                int next = g[cur].get(i);
                if (!visited[next] && next != cut) {
                    s.push(next);visited[next] = true;count++;
                }
            }
            if (count == 0) leaf++;
        }
        return leaf;
    }
}
