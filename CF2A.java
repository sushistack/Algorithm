import java.io.*;
import java.util.Collections;
import java.util.HashMap;

public class CF2A {
    static int N, maxScore = 0;
    static HashMap<String, Integer> hm = new HashMap<>();
    static String in, ins[];
    static String winner;
    static String[] n = new String[1001];
    static int[] s = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        N = Integer.parseInt(in);
        for (int i = 0; i < N; i++) {
            ins = br.readLine().split(" ");
            n[i] = ins[0];s[i] = Integer.parseInt(ins[1]);
            s[i] += (hm.containsKey(ins[0])) ? hm.get(ins[0]) : 0;
            hm.put(n[i], s[i]);
        }
        maxScore = Collections.max(hm.values());
        for (int i = 0; i < N; i++) {
            if (hm.get(n[i]) == maxScore && s[i] >= maxScore) {
                winner = n[i]; break;
            }
        }
        bw.write(winner + "\n");
        bw.flush();bw.close();
    }

}
