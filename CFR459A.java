import java.io.*;
import java.util.HashMap;

public class CFR459A {
    static int n;
    static int a[] = new int[1001];
    static HashMap<Integer, Boolean> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        a[1] = a[2] = 1;hm.put(1, true);
        for (int i = 3; i <= 100; i++) {
            a[i] = a[i - 1] + a[i - 2];
            hm.put(a[i], true);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append((hm.containsKey(i)) ? "O" : 'o');
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }


}
