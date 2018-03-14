import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B1922 {
    static int n, m, a, b, c, uf[] = new int[100001], count;
    static String ins[];
    static ArrayList<Edge> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        Arrays.fill(uf, -1);
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            a = Integer.parseInt(ins[0]);
            b = Integer.parseInt(ins[1]);
            c = Integer.parseInt(ins[2]);
            edges.add(new Edge(a, b, c));
        }
        Collections.sort(edges);
        int ans = 0;count = 0;
        for (int i = 0; ; i++) {
            if (merge(edges.get(i).u, edges.get(i).v)) {
                ans += edges.get(i).w;
                if (++count == n - 1) break;
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


    public static int find(int a){
        if(uf[a] < 0) return a;
        return uf[a] = find(uf[a]);
    }

    public static boolean merge(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        uf[b] = a;
        return true;
    }

    private static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;this.v = v;this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w > o.w ? 1 : (this.w == o.w ? 0 : -1);
        }
    }

}
