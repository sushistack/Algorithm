import java.io.*;

public class CF443A {
    static String ins[], in;
    static int a[] = new int[26], count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        ins = in.substring(1, in.length() - 1).split(", ");
        for (int i = 0; i < ins.length; i++) {
            if (ins[i].length() == 0) continue;
            a[ins[i].charAt(0)- 97]++;
        }
        for (int i = 0; i < 26; i++) {
            count += (a[i] > 0) ? 1 : 0;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
