import java.io.*;
import java.util.ArrayList;

public class CFER37B {
    static int t, n, l, r;
    static People[] ps = new People[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                ins = br.readLine().split(" ");
                l = Integer.parseInt(ins[0]);
                r = Integer.parseInt(ins[1]);
                ps[i] = new People(l, r);
            }
            StringBuffer sb = new StringBuffer();
            
            int q = 0, a[] = new int[1001];
            ArrayList<Po> que = new ArrayList<>();
            for (int i = 1; i < 5000; i++) {
                for (int j = 1; j <= n; j++) {
                    if (ps[j].l == i) {
                        q++;que.add(new Po(j, ps[j].r));
                    }
                }
                if (que.size() > 0) {
                    a[que.remove(0).idx] = i;
                    ArrayList<Integer> re = new ArrayList<>();
                    for (int j = 0; j < que.size(); j++) {
                        if (que.get(j).time - i == 0) {
                            re.add(j);
                        }
                    }
                    for (int j = 0; j < re.size(); j++) {
                        a[que.get(re.get(j)).idx] = 0;
                        que.remove((int)re.get(j));
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                sb.append(a[i]);
                if (i < n) sb.append(" ");
            }
            bw.write(sb.toString() + "\n");bw.flush();
        }
        bw.close();
    }

    private static class People implements Comparable<People> {
        int l, r;
        People(int l, int r) {
            this.l = l; this.r = r;
        }

        @Override
        public int compareTo(People o) {
            return this.l > o.l ? 1 : -1;
        }
    }
    private static class Po {
        int idx, time;
        Po(int l, int r) {
            this.idx = l; this.time = r;
        }


    }
}
