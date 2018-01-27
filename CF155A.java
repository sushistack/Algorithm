import java.io.*;

public class CF155A {
    static int n, max, min, count = 0;
    static int[] a = new int[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ins[i]);
        }
        max = min = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i]; count++;
            }
            if (min > a[i]) {
                min = a[i]; count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
