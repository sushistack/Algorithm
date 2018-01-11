import java.io.*;

public class CF110A {
    static int count = 0;
    static String in;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '4' || in.charAt(i) == '7') count++;
        }
        bw.write((count == 4 || count == 7) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
