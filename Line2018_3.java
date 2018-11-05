import java.io.*;
import java.util.*;

public class Line2018_3 {
    static int n, u, v, uf[] = new int[20000];
    static Map<Integer, Integer> map = new HashMap<>();
    static Set<Integer> used = new HashSet<>();
    static List<Edge> edges = new ArrayList<>();
    static String in, ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Arrays.fill(uf, -1);
        edges.clear();
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < ins.length - 1; j++) {
                u = Integer.parseInt(ins[j]);
                v = Integer.parseInt(ins[j + 1]);
                if (map.containsKey(u)) {
                    if (map.get(u) != v) {
                        System.out.println(-1);
                        return;
                    }
                } else map.put(u, v);
                edges.add(new Edge(u, v));
            }
        }

        for (Edge e : edges) {
            merge(e.v, e.u);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
        for (int i = 1; i < 1001; i++) {
            if (uf[i] == -1) continue;
            if (uf[uf[i]] == -1 && !used.contains(uf[i])) {
                pq.add(uf[i]);
                used.add(uf[i]);
            }
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
            sb.append(" ");
        }
        if (sb.toString().length() == 0) {
            System.out.println(-1);
            return;
        }
        bw.write(sb.toString() + "\n");
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

    private static class Edge {
        int u, v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
