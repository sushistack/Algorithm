import java.io.*;

public class CFR468B {
    static int n, a, b, l, r, min, max, fi;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        a = Integer.parseInt(ins[1]);
        b = Integer.parseInt(ins[2]);
        l = 1;r = n;
        int f = log(n, 2), mid;
        fi = log(n, 2);
        min = Math.min(a, b);
        max = Math.max(a, b);
        while (f > 1) {
            mid = (l + r) >> 1;
            if (min <= mid && max > mid) break;
            else {
                f--;
                if (min > mid) l = mid;
                else r = mid;
            }
        }
        bw.write((f == fi) ? "Final!\n" : f + "\n");
        bw.flush();bw.close();
    }

    private static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
}
