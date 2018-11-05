import java.io.*;
import java.util.*;

public class SWE2383 {
    static int t, T, n, v, ans, map[][] = new int[10][10];
    static int dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1};
    static ArrayList<People> p = new ArrayList<>();
    static ArrayList<Stair> s = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            p.clear();s.clear();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v = 0;
                while (st.hasMoreTokens()) {
                    map[i][v] = Integer.parseInt(st.nextToken());
                    if (map[i][v] == 1) p.add(new People(i, v));
                    if (map[i][v] > 1) s.add(new Stair(i, v, map[i][v]));
                    v++;
                }
            }
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < p.size(); i++) {
                People cur = p.get(i);
                for (int j = 0; j < s.size(); j++) {
                    Stair stair = s.get(j);
                    cur.s[j].t = Math.abs(cur.x - stair.x) + Math.abs(cur.y - stair.y);
                    cur.s[j].l = stair.l;
                }
            }

            dfs(0, 0);

            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(--ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }


    private static void dfs(int idx, int status) {
        if (idx == p.size()) {
            PriorityQueue<People> s1 = new PriorityQueue<>(new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    return Integer.compare(o1.s[0].t, o2.s[0].t);
                }
            });
            PriorityQueue<People> s2 = new PriorityQueue<>(new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    return Integer.compare(o1.s[1].t, o2.s[1].t);
                }
            });

            for (int i = 0; i < p.size(); i++) {
                if ((status & (1 << i)) != 0) s1.offer(p.get(i));
                else s2.offer(p.get(i));
            }
            int max = Math.max(maxTime(s1, 0), maxTime(s2, 1));

            ans = Math.min(ans, max);
            return;
        }
        dfs(idx + 1, status);
        dfs(idx + 1, status | (1 << idx));
    }

    private static int maxTime(PriorityQueue<People> st, int k) {
        if (st.isEmpty()) return 0;
        int maxTime = 0, used = 0, c = 0, size = st.size();
        Queue<People> waiting = new LinkedList<>();
        ArrayList<People> com = new ArrayList<>();
        int l = st.peek().s[k].l;
        int time = st.peek().s[k].t;
        while (true) {
            if (!com.isEmpty()) {
                for (int i = 0; i < com.size(); i++) {
                    if (com.get(i).remain == 0) continue;
                    com.get(i).remain--;
                    if (com.get(i).remain == 0) {
                        used--;
                        People p = com.get(i);
                        maxTime = Math.max(maxTime, p.s[k].t + p.wt + l);
                        c++;
                    }
                }
            }
            while (used < 3) {
                if (waiting.isEmpty()) break;
                if (time  >= waiting.peek().s[k].t + 1) {
                    People p = waiting.poll();
                    p.wt = time - p.s[k].t + 1;
                    p.remain = l;
                    com.add(p);
                    used++;
                }
            }
            while (!st.isEmpty()) {
                if (time == st.peek().s[k].t) waiting.add(st.poll());
                else break;
            }

            time++;
            if (st.isEmpty() && waiting.isEmpty() && c == size) break;
        }

        return maxTime;
    }


    private static class Stair {
        int x, y, l;
        Stair (int x, int y, int l) {
            this.x = x;this.y = y;this.l = l;
        }
    }

    private static class People {
        int x, y, wt, remain;
        Stair s[];
        People (int x, int y) {
            this.x = x;this.y = y;
            s = new Stair[2];remain = wt = 0;
            s[0] = new Stair(-1,-1);
            s[1] = new Stair(-1,-1);

        }
        private static class Stair {
            int l, t;
            Stair (int l, int t) {
                this.l = l;this.t = t;
            }
        }
    }

}
