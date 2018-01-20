import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class CF500A {
    static int n, t;
    static int[] a = new int[30000];
    static String ins[];
    static ArrayList<Integer>[] g = new ArrayList[30001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        t = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < 30001; i++) g[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) a[i] = Integer.parseInt(ins[i - 1]);
        for (int i = 1; i < n; i++) {
            g[i].add(i + a[i]);
        }
        bw.write((dfs() ? "YES" : "NO") + "\n");
        bw.flush();bw.close();
    }
    public static boolean dfs() {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[30001];
        boolean isArrive = false;
        visited[1] = true;
        s.push(1);
        while (!s.isEmpty()) {
            int cur = s.pop();
            if (cur == t) {
                isArrive = true;break;
            }
            for (int i = 0; i < g[cur].size(); i++) {
                if (!visited[g[cur].get(i)]) {
                    s.push(g[cur].get(i));
                }
            }
        }
        return isArrive;
    }

}
