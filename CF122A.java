import java.io.*;

public class CF122A {
    static int n;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        if (n % 4 == 0 || n % 7 ==0 || n % 47 == 0 || n % 74 == 0 ||
                n % 77 == 0 || n % 477 == 0) flag = true;

        bw.write((flag) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
