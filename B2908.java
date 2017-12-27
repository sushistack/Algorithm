import java.io.*;

public class B2908 {
    static int[] a = new int[3], b = new int[3];
    static int max;
    static String in, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        A = in.split(" ")[0];
        B = in.split(" ")[1];
        for (int i = a.length - 1; i > -1; i--) {
            a[i] = A.charAt(A.length() - 1 - i) - 48;
            b[i] = B.charAt(B.length() - 1 - i) - 48;
        }
        max = Math.max(toInteger(a), toInteger(b));
        bw.write(max + "\n");bw.flush();
        bw.close();
    }
    public static int toInteger(int[] a) {
        int val = 0;
        for (int i = 0; i < a.length; i++) {
            val += a[i] * (int)Math.pow(10, a.length - 1 - i);
        }
        return val;
    }
}
