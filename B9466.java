import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class B9466 {
    static int T, n, cnt;
    static boolean[] visited = new boolean[100001], finished = new boolean[100001];
    static HashMap<Integer, Integer> g = new HashMap<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;g.clear();
            ins = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                g.put(i, Integer.parseInt(ins[i - 1]));
            }
            Arrays.fill(visited, false);
            Arrays.fill(finished, false);
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            bw.write(n - cnt + "\n");bw.flush();
        }
        bw.close();
    }

    public static void dfs(int v) {
        visited[v] = true;
        int next = g.get(v);
        if (visited[next]) {
            if (!finished[next]) {
                for (int i = next; i != v ; i = g.get(i)) {
                    cnt++;
                }
                cnt++;
            }
        }else dfs(next);
        finished[v] = true;
    }

}
