import java.io.*;

public class CFR461B {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int c = i;
            for (int b = 1; b <= i; b++) {
                int a = c ^ b;
                if (a + b <= i) continue;
                if (a > b) continue;
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
