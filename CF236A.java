import java.io.*;

public class CF236A {
    static boolean a[] = new boolean[26];
    static String in;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        for (int i = 0; i < in.length(); i++) {
            a[in.charAt(i) - 97] = true;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i]) count++;
        }
        bw.write((count % 2 == 0) ? "CHAT WITH HER!\n" : "IGNORE HIM!\n");
        bw.flush();bw.close();
    }
}
