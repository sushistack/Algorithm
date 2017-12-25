import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FloydWarshall2606 {
    static int N, M, u, v;
    static boolean[] visit = new boolean[100001];
    static ArrayList<Integer>[] list = new ArrayList[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            u = sc.nextInt(); v = sc.nextInt();
            list[u].add(v);list[v].add(u);
        }
        System.out.println(bfs(1) - 1);
    }
    public static int bfs(int v) {
        Queue<Integer> q= new LinkedList<>();
        int count = 0;
        q.offer(v); visit[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();count++;
            for (int i = 0; i < list[cur].size(); i++) {
                int to = list[cur].get(i);
                if (!visit[to]) {visit[to] = true; q.offer(to);}
            }
        }
        return count;
    }
}
