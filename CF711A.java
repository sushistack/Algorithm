import java.io.*;

public class CF711A {
    static int n;
    static String ins[] = new String[1001];
    static boolean isDoubleSeat = false;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins[i] = br.readLine();
            if (!isDoubleSeat && ins[i].contains("OO")) {
                isDoubleSeat = true;ins[i] = ins[i].replaceFirst("OO", "++");
            }
            sb.append(ins[i] + "\n");
        }
        bw.write((isDoubleSeat ? "YES\n" + sb.toString() : "NO\n"));
        bw.flush();bw.close();
    }
}
