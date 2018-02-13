import java.io.*;

public class B1629 {
    static int A, B, C;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        A = Integer.parseInt(ins[0]);
        B = Integer.parseInt(ins[1]);
        C = Integer.parseInt(ins[2]);
        bw.write(pow(B) + "\n");
        bw.flush();bw.close();
    }

    public static long pow(int b) {
        if (b == 1) return A % C;
        long t = pow(b >> 1);
        long ans = t * t;
        ans %= C;
        if (b % 2 != 0) {
            ans *= A;ans %= C;
        }
        return ans;
    }
}
