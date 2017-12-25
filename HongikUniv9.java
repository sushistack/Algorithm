import java.util.*;

public class HongikUniv9 {
    final static int MOD = 1000000007;
    static int N, one = 0;
    static ArrayList<Integer>[] graph;
    static int[] factorial = new int[501];
    static int[] inverseFactorial = new int[501];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        factorialInit();
        N = sc.nextInt();
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                graph[i].add(j);graph[j].add(i);
            }
        }
        bfs(1);
        System.out.println("a1");

    }
    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        int[][] visitEdge = new int[N + 1][N + 1];
        q.offer(v);int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll(); count++;
            System.out.print("a" + cur + " ");
            for (int i = 0; i < graph[cur].size(); i++) {
                if (one < N - 2) {
                    if (nextNode(visitEdge, cur, i, q)) break;
                }else {
                    if (graph[cur].get(i) == 1) {
                        if (count == combination(N,2) - 1) {
                            if (nextNode(visitEdge, cur, i, q)) break;
                        }
                    }else {
                        if (nextNode(visitEdge, cur, i, q)) break;
                    }
                }
            }
        }
    }
    public static boolean nextNode(int[][] v, int c, int i, Queue<Integer> q) {
        if (v[c][graph[c].get(i)] != 1) {
            v[c][graph[c].get(i)] = 1;
            v[graph[c].get(i)][c] = 1;
            if (graph[c].get(i) == 1 || c == 1) one++;
            q.offer(graph[c].get(i));
            return true;
        }else return false;
    }


    public static void factorialInit() {
        factorial[0] = inverseFactorial[0] = 1;
        long t = 1;
        for (int i = 1; i < 501; i++) {
            t = (t * i) % MOD;
            factorial[i] = (int)t;
            inverseFactorial[i] = (int)exp(t, MOD - 2);
        }
    }
    public static int combination(int a, int b){
        long e= factorial[a];
        e = (e*inverseFactorial[b]) % 1000000007;
        e = (e*inverseFactorial[a-b]) % 1000000007;
        return (int)e;
    }
    public static long exp(long x, int m) {
        if(m==1)
            return x;
        long t = exp(x,m/2);
        long result = t;
        result = (result * t) %1000000007;
        if(m % 2 == 1 ){
            result = (result * x) %1000000007;
        }
        return (int) result;
    }

}
