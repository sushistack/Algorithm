import java.io.*;
import java.util.ArrayList;

public class CF490A {
    static int n, t[] = new int[5001];
    static String ins[];
    static ArrayList<Integer>[] list = new ArrayList[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i < 4; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(ins[i - 1]);
            list[t[i]].add(i);
        }
        int min = Integer.MAX_VALUE, minIdx = -1;
        for (int i = 1; i < 4; i++) {
            if (min > list[i].size()) {
                minIdx = i; min = list[i].size();
            }
        }
        StringBuffer sb = new StringBuffer(min + "\n");
        for (int i = 0; i < list[minIdx].size(); i++) {
            for (int j = 1; j < 4; j++) {
                sb.append(list[j].get(i));
                if (j < 3) sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
