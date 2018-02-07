import java.io.*;
import java.util.ArrayList;

public class B2661 {
    static int n;
    static StringBuffer ans = new StringBuffer();
    static boolean set = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        dfs(0, a);
        bw.write(ans.toString() + "\n");
        bw.flush();bw.close();

    }

    public static void dfs(int idx, ArrayList<Integer> a) {
        if (idx == n) {
            for (int i = 0; i < a.size(); i++) ans.append(a.get(i));
            set = true;
            return;
        }

        for (int i = 1; i < 4; i++) {
            ArrayList<Integer> l = new ArrayList<>(a);
            l.add(i);
            if (isNotSameSub(l)) dfs(idx + 1, l);
            if (set) return;
        }
    }

    public static boolean isNotSameSub(ArrayList<Integer> a) {
        for (int i = 1; i <= (a.size() >> 1); i++) {
            int maxIdx = a.size() - 2 * i + 1;
            for (int j = 0; j < maxIdx; j++) {
                StringBuffer sb = new StringBuffer();
                for (int k = j; k < j + i; k++) {
                    sb.append(a.get(k));
                }
                StringBuffer sb2 = new StringBuffer();
                for (int k = j + i; k < j + 2 * i; k++) {
                    sb2.append(a.get(k));
                }
                if (sb.toString().equals(sb2.toString())) return false;
            }
        }
        return true;
    }
}
