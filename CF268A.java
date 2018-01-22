import java.io.*;

public class CF268A {
    static int n, a[] = new int[31], h[] = new int[31];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            ins = br.readLine().split(" ");
            h[i] = Integer.parseInt(ins[0]);
            a[i] = Integer.parseInt(ins[1]);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (h[i] == a[j]) count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
