import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
// 이유 꼭알기
public class B9375 {
    static int T, N, w;
    static String in, ins[];
    static int[] wearType = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            N = Integer.parseInt(br.readLine());w = 0;
            HashMap<String, Integer> hm = new HashMap<>();
            Arrays.fill(wearType, 0);
            for (int i = 0; i < N; i++) {
                in = br.readLine();
                ins = in.split(" ");
                if (hm.containsKey(ins[1])) wearType[hm.get(ins[1])]++;
                else {
                    wearType[w]++;
                    hm.put(ins[1], w++);
                }
            }
            int ans = 1;
            for (int i = 0; i < w; i++) {
                ans *= (wearType[i] + 1);
            }
            ans--;
            bw.write(ans + "\n");bw.flush();
        }
        bw.close();
    }
}
