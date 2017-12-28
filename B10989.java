import java.io.*;

public class B10989 {
    static int N, t;
    static int[] a = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            t = Integer.parseInt(br.readLine());
            a[t]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a[i]; j++) {
                sb.append(i + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
