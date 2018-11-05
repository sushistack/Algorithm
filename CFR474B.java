import java.io.*;
import java.util.StringTokenizer;

public class CFR474B {
    static int n, k1, k2, v = 0, sumOfDif = 0, abs[] = new int[1001], ans = 0;
    static int[] a = new int[1001], b = new int[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k1 = Integer.parseInt(ins[1]);
        k2 = Integer.parseInt(ins[2]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            a[v++] = Integer.parseInt(st.nextToken());
        }
        v = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            b[v] = Integer.parseInt(st.nextToken());
            sumOfDif += Math.abs(a[v] - b[v]);
            v++;
        }


        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


}
