import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CFER37C {
    static int n, a[] = new int[200005], b[] = new int[200005];
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static String ins[], s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
        }
        System.arraycopy(a, 0, b, 0, n + 1);
        Arrays.parallelSort(a, 1, n + 1);


        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (a[i] != b[i]) list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            int idx = Arrays.binarySearch(a, 1, n + 1, b[list.get(i)]);
            hm.put(list.get(i), idx);
        }

        s = br.readLine();
        int p[] = new int[200005];
        for (int i = 1; i < n; i++) {
            p[i] = (s.charAt(i - 1) == '0') ? p[i - 1] + 1 : p[i - 1];
        }


        boolean isSwap = true;
        for (int key : hm.keySet()) {
            int max = Math.max(key, hm.get(key));
            int min = Math.min(key, hm.get(key));
            if (p[max - 1] - p[min - 1] != 0) {
                isSwap = false;break;
            }
        }

        bw.write((isSwap) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
