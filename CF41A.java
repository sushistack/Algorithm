import java.io.*;

public class CF41A {
    static StringBuffer s1 = new StringBuffer(), s2 = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s1.append(br.readLine());s2.append(br.readLine());
        bw.write((s1.reverse().toString().equals(s2.toString())) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
