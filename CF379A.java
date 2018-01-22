import java.io.*;

public class CF379A {
    static int a, b, ans, remain;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        ans = remain = a = Integer.parseInt(ins[0]);
        b = Integer.parseInt(ins[1]);
        while ((remain / b) > 0){
            int t = remain % b;
            remain /= b;
            ans += remain;
            remain += t;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
