import java.io.*;

public class CF25A {
    static int n, even = 0, odd = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            if (Integer.parseInt(ins[i - 1]) % 2 == 0) even += i;
            else odd += i;
        }

        bw.write(Math.min(even, odd) + "\n");
        bw.flush();bw.close();

    }
}
