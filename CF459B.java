import java.io.*;
import java.util.Collections;
import java.util.HashMap;

public class CF459B {
    static int n, b, max, min;
    static HashMap<Integer, Long> hm = new HashMap<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            b = Integer.parseInt(ins[i - 1]);
            if (hm.containsKey(b)) hm.put(b, hm.get(b) + 1);
            else hm.put(b, 1L);
        }
        max = Collections.max(hm.keySet());
        min = Collections.min(hm.keySet());
        long c = (max == min) ? (hm.get(max) * (hm.get(max) - 1)) >> 1 : hm.get(max) * hm.get(min);
        bw.write((max - min) + " " + c + "\n");
        bw.flush();bw.close();
    }
}
