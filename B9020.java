import java.io.*;
import java.util.ArrayList;

public class B9020 {
    static int T, n;
    static SumOfPrime[] sp = new SumOfPrime[10001];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        initPrime();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            bw.write(sp[n].m + " " + sp[n].n + "\n");
            bw.flush();
        }
        bw.close();
    }
    public static void initPrime() {
        boolean isPrime;
        for (int i = 2; i < 10000; i++) {
            isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false; break;
                }
            }
            if (isPrime) list.add(i);
        }
        for (int i = 0; i < 10001; i++) {
            sp[i] = new SumOfPrime();
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int s = list.get(i) + list.get(j);
                if (s < 10001)
                    if (sp[s].m == -1) {
                        sp[s].m = (list.get(i) < list.get(j)) ? list.get(i) : list.get(j);
                        sp[s].n = (list.get(i) > list.get(j)) ? list.get(i) : list.get(j);
                    }else {
                        if (Math.abs(sp[s].m - sp[s].n) > Math.abs(list.get(i) - list.get(j))) {
                            sp[s].m = (list.get(i) < list.get(j)) ? list.get(i) : list.get(j);
                            sp[s].n = (list.get(i) > list.get(j)) ? list.get(i) : list.get(j);
                        }
                    }
            }
        }
    }
    private static class SumOfPrime {
        int m, n;
        SumOfPrime() {
            m = -1;n = -1;
        }
        SumOfPrime(int n, int m) {
            this.m = m;this.n = n;
        }
    }
}
