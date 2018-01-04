import java.io.*;

public class CF16E {
    static int n;
    static double[][] p = new double[19][19];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                p[i][j] = Double.parseDouble(ins[j]);
            }
        }

    }
}
