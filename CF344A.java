import java.io.*;

public class CF344A {
    static int n, count = 1;
    static String ins[] = new String[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins[i] = br.readLine();
        }
        for (int i = 1; i < n; i++) {
            count += (!ins[i - 1].equals(ins[i])) ? 1 : 0;

        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
