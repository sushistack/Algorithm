import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class WoowaBrothers5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
        int v = 0;
        while (st.hasMoreTokens()) {
            a[v++] = Integer.parseInt(st.nextToken());
        }
        int k, l;
        k = 3;
        l = 2;

        bw.write(new WoowaBrothers5().solution(a, k, l) + "\n");
        bw.flush();bw.close();

    }
    static int prefix[], max;
    public int solution(int[] A, int K, int L) {
        max = -1;
        prefix = new int[A.length];
        ArrayList<Data> a = new ArrayList<>();
        ArrayList<Data> b = new ArrayList<>();
        for (int i = 0; i < prefix.length; i++) {
            prefix[i] =  (i == 0) ? A[i] : prefix[i - 1] + A[i];
        }
        for (int i = 0; i < A.length - K + 1; i++) {
            a.add(new Data(i, i + K - 1, sumOfRange(i, K)));
        }
        for (int i = 0; i < A.length - L + 1; i++) {
            b.add(new Data(i, i + L - 1, sumOfRange(i, L)));
        }
        Collections.sort(a);
        Collections.sort(b);

        Data aa, bb;
        for (int i = 0; i < a.size(); i++) {
            aa = a.get(i);
            for (int j = 0; j < b.size(); j++) {
                bb = b.get(j);
                if (!isOverWrapped(aa, bb)) {
                    max = Math.max(max, aa.v + bb.v);
                    break;
                }
            }
        }
        return max;
    }

    public boolean isOverWrapped(Data d1, Data d2) {
        return !(d1.e < d2.s || d2.e < d1.s);
    }

    public int sumOfRange(int s, int l) {
        return (s == 0) ? prefix[l + s - 1] : prefix[l + s - 1] - prefix[s - 1];
    }


    private class Data implements Comparable<Data> {
        int s, e, v;
        Data(int s, int e, int v) {
            this.s = s;this.e = e;this.v = v;
        }
        @Override
        public int compareTo(Data o) {
            return -Integer.compare(this.v, o.v);
        }
    }
}
