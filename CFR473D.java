import java.io.*;
import java.util.StringTokenizer;

public class CFR473D {
    static int n, a[] = new int[100001], v = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            a[v++] = Integer.parseInt(st.nextToken());
        }



        bw.flush();bw.close();
    }
}
