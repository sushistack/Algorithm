import java.io.*;

public class CF144A {
    static int n, maxIdx = -1, minIdx = -1, max = 0, min = 101;
    static int[] a = new int[101];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ins[i]);
            if (max < a[i]) {
                max = a[i];maxIdx = i;
            }
            if (min >= a[i]) {
                min = a[i];minIdx = i;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (maxIdx < minIdx)  sb.append(maxIdx + ((n - 1) - minIdx));
        else if (maxIdx == minIdx) sb.append("0");
        else sb.append(maxIdx + ((n - 1) - minIdx) - 1);
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }
}
