import java.io.*;

public class CF734B {
    static int k[] = new int[7], min, ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        k[2] = Integer.parseInt(ins[0]);k[3] = Integer.parseInt(ins[1]);
        k[5] = Integer.parseInt(ins[2]);k[6] = Integer.parseInt(ins[3]);
        min = (k[2] > k[5]) ? (k[5] > k[6]) ? k[6] : k[5] : (k[2] > k[6]) ? k[6] : k[2];
        k[2] -= min; k[5] -= min;k[6] -= min;ans += 256 * min;
        min = Math.min(k[2], k[3]);k[2] -= min;k[3] -= min;
        ans += 32 * min;
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
