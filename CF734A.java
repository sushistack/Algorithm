import java.io.*;

public class CF734A {
    static int n, a = 0, d = 0;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            a += (s.charAt(i) == 'A') ? 1 : 0;
            d += (s.charAt(i) == 'D') ? 1 : 0;
        }

        bw.write((a > d) ? "Anton\n" : (a == d) ? "Friendship\n" : "Danik\n");
        bw.flush();bw.close();
    }
}
