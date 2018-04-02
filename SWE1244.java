import java.io.*;
import java.util.ArrayList;

public class SWE1244 {
    static int t, T, ex, a[], max, b[], c[];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            a = new int[ins[0].length()];max = 0;
            b = new int[ins[0].length()];
            for (int i = 0; i < ins[0].length(); i++) {
                b[i] = a[i] = ins[0].charAt(i) - 48;
            }
            ins[1] = ins[1].replace("\t", "");
            ex = Integer.parseInt(ins[1]);
            dfs(0, a, 0);
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(max);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void dfs(int idx, int[] a, int c) {
        int l = a.length;
        if (c == ex) {
            int ans = 0;
            for (int i = 0; i < l; i++) {
                ans += a[i] * Math.pow(10,l - i - 1);
            }
            max = Math.max(max, ans);
            return;
        }
        int chIdx = -1;
        if (idx < l) chIdx = getIndexOfMax(a, idx);
        if (chIdx == -1) {
            if (idx == l - 1) {
                int b[] = new int[10];
                boolean flag = false;
                for (int i = 0; i < l; i++) b[a[i]]++;
                for (int i = 0; i < 10; i++) {
                    if (b[i] > 1) flag = true;
                }
                if (flag) dfs(idx, a, c + 1);
                else {
                    swap(idx, idx - 1, a);
                    dfs(idx, a, c + 1);
                    swap(idx, idx - 1, a);
                }
            }else dfs(idx + 1, a, c);
        }
        else {
            swap(idx, chIdx, a);
            dfs(idx + 1, a, c + 1);
            swap(idx, chIdx, a);
        }
    }

    private static int getIndexOfMax(int a[], int s) {
        int max = a[s], lastIndex = -1;
        int count = 0, firstIndex = -1;
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = s + 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        for (int i = s + 1; i < a.length; i++) {
            if (max == a[i]) {
                lastIndex = i;
                indices.add(i);
            }
            if (firstIndex == -1 && max == a[i]) firstIndex = i;
        }
        for (int i = s + 1; i < lastIndex; i++) {
            if (a[s] > a[i]) count++;
        }
        return (indices.size() <= count) ? firstIndex :
                indices.get(indices.size() - count - 1);
    }

    private static void swap(int x, int y, int[] a) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
