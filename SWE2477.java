import java.io.*;
import java.util.*;

public class SWE2477 {
    static int t, T, n, m, k, a[] = new int[10], b[] = new int[10], ans, v, A, B;
    static String ins[];
    static Customer[] c = new Customer[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            m = Integer.parseInt(ins[1]);
            k = Integer.parseInt(ins[2]);
            A = Integer.parseInt(ins[3]);
            B = Integer.parseInt(ins[4]);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            v = 1;
            while (st.hasMoreTokens()) {
                a[v++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            v = 1;
            while (st.hasMoreTokens()) {
                b[v++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            v = 1;
            Queue<Customer> aq = new LinkedList<>();
            while (st.hasMoreTokens()) {
                int time = Integer.parseInt(st.nextToken());
                aq.offer(new Customer(v++, time));
            }

            PriorityQueue<Customer> apq = new PriorityQueue<>(new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return Integer.compare(o1.n, o2.n);
                }
            });
            PriorityQueue<Customer> bpq = new PriorityQueue<>(new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    if (o1.endOfA > o2.endOfA) return 1;
                    else if (o1.endOfA == o2.endOfA) {
                        return Integer.compare(o1.booth[0], o2.booth[0]);
                    }else return -1;
                }
            });
            ans = 0;
            int time = 0, used[] = new int[2], cnt = 0;
            boolean sA[] = new boolean[10], sB[] = new boolean[10];
            ArrayList<Customer> aa = new ArrayList<>();
            ArrayList<Customer> bb = new ArrayList<>();
            while (true) {
                enter(aa, apq, bpq, used, 0, sA, time);
                cnt += enter(bb, bpq, null, used, 1, sB, time);
                while (!aq.isEmpty()) {
                    if (time == aq.peek().arrivalTime) apq.offer(aq.poll());
                    else break;
                }
                time++;
                if (cnt == k) break;
            }

            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append((ans == 0) ? -1 : ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static int enter(ArrayList<Customer> al, PriorityQueue<Customer> pq,
                              PriorityQueue<Customer> pq2, int[] used, int x, boolean[] ss, int time) {
        int cnt = 0;
        if (!al.isEmpty()) {
            for (int i = 0; i < al.size(); i++) {
                Customer c = al.get(i);
                if (c.t[x] == 0) continue;
                c.t[x]--;
                if (c.t[x] == 0) {
                    if (x == 0) {
                        c.endOfA = time;
                        pq2.offer(c);
                    }

                    else {
                        if (c.booth[0] == A && c.booth[1] == B) {
                            ans += c.n;
                        }
                        cnt++;
                    }
                    used[x]--;
                    ss[c.booth[x]] = false;
                }
            }
        }
        int limit = (x == 0) ? n : m;
        while (used[x] < limit) {
            if (pq.isEmpty()) break;
            for (int i = 1; i <= limit; i++) {
                if (!ss[i]) {
                    Customer c = pq.poll();
                    c.booth[x] = i;
                    c.t[x] = (x == 0) ? a[i] : b[i];
                    al.add(c);
                    ss[i] = true;
                    used[x]++;
                    break;
                }
            }
        }
        return cnt;
    }



    private static class Customer {
        int n, arrivalTime, endOfA;
        int[] t, booth;
        Customer(int n, int arrivalTime) {
            this.n = n;this.arrivalTime = arrivalTime;
            t = new int[2]; booth = new int[2];
        }

    }

}
