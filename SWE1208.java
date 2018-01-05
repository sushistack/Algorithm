import java.io.*;

public class SWE1208 {
    static int T = 10, n, max, min, maxIdx, minIdx;
    static int[] a = new int[100];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            ins = br.readLine().split(" ");
            for (int i = 0; i < 100; i++) {
                a[i] = Integer.parseInt(ins[i]);
            }
            while (n-- != 0) {
                boolean t = dump();
                if (!t) break;
            }
            max = -1; min = 101;
            for (int i = 0; i < 100; i++) {
                max = Math.max(max, a[i]);
                min = Math.min(min, a[i]);
            }
            bw.write("#" + (10 - T) + " " + (max - min) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static boolean dump() {
        boolean isDump = true;
        max = -1; min = 101;
        maxIdx = -1;minIdx = -1;
        for (int i = 0; i < 100; i++) {
            if (max < a[i]) {
                max = a[i]; maxIdx = i;
            }
            if (min > a[i]) {
                min = a[i];minIdx = i;
            }
        }
        if (max - min == 1) isDump = false;
        else {
            a[maxIdx]--;a[minIdx]++;
        }
        return isDump;
    }
}
