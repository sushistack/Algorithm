import java.io.*;

public class CF61A {
    static String s1, s2, s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s1 = br.readLine();s2 =br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s1.length(); i++) {
            sb.append("" + ((s1.charAt(i) - 48) ^ (s2.charAt(i) - 48)));
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }
}
