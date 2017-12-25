import java.util.*;

public class BaekJoon13303 {
    static int N, curY, destX, curX = 0, count = 0, x, yh, yl;
    static ArrayList<Integer> ans = new ArrayList<>();
    static Obstacle[] obstacles;
    static HashMap<Integer, Integer>[] dp;
    static Queue<Obstacle> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); obstacles = new Obstacle[N + 1];
        dp = new HashMap[N + 2];
        curY = sc.nextInt(); destX = sc.nextInt();
        pq.offer(new Obstacle(0,0,0));dp[0] = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            x = sc.nextInt(); yl = sc.nextInt(); yh = sc.nextInt();
            pq.offer(new Obstacle(x, yl, yh));
            dp[i] = new HashMap<>();
        }
        dp[N + 1] = new HashMap<>();
        dp[0].put(curY, 0);
        for (int i = 0; i <= N; i++) {
            if (i < N) {
                Obstacle preObstacle = pq.poll(), postObstacle = pq.peek();
                for (int key : dp[i].keySet()) {
                    if (key > postObstacle.yl && key < postObstacle.yh) {
                        dp(i + 1, postObstacle.yl, dp[i].get(key) + (key - postObstacle.yl) + (postObstacle.x - preObstacle.x));
                        dp(i + 1, postObstacle.yh, dp[i].get(key) + (postObstacle.yh - key) + (postObstacle.x - preObstacle.x));
                    }else {
                        dp(i + 1, key, dp[i].get(key) + (postObstacle.x - preObstacle.x));
                    }
                }
            }else {
                Obstacle preObstacle = pq.poll(), postObstacle = pq.poll();
                for (int key : dp[i].keySet()) {
                    dp(i + 1, key, dp[i].get(key) + (destX - preObstacle.x));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int key : dp[N + 1].keySet()) {
            min = (min > dp[N + 1].get(key)) ? dp[N + 1].get(key) : min;
        }
        for (int key : dp[N + 1].keySet()) {
            if (dp[N + 1].get(key) == min) {
                ans.add(key);count++;
            }
        }
        Collections.sort(ans, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 < o2) ? -1 : (o1 > o2) ? 1 : 0;
            }
        });
        System.out.println(min);
        System.out.print(count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" " + ans.get(i));
        }

    }
    public static void dp(int i, int j, int d) {
        if (dp[i].containsKey(j)) {
            if (dp[i].get(j) > d) {
                dp[i].put(j, d);
            }
        }else {
            dp[i].put(j, d);
        }
    }

    static class Obstacle implements Comparable<Obstacle>{
        int x, yl, yh;
        Obstacle (int x, int yl, int yh) {
            this.x = x; this.yl = yl; this.yh = yh;
        }
        @Override
        public int compareTo(Obstacle o) {
            return x > o.x ? 1 : -1;
        }
    }
}
