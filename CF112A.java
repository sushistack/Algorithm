import java.io.*;

public class CF112A {
    static String s1, s2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s1 = br.readLine().toLowerCase(); s2 = br.readLine().toLowerCase();
        int t = Math.abs(s1.compareTo(s2)), ans = 0;
        if (t != 0) ans = s1.compareTo(s2) / t;
        bw.write( ans + "\n");
        bw.flush();bw.close();
    }
}
