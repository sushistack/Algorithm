import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CFR458B {
    static int n, a, count[] = new int[100001];
    static HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
    static String ins[];
    static boolean isWinConan = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(ins[i]);
            count[a]++;
        }
        for (int i = 0; i < 100001; i++) {
            if ((count[i] & 1) != 0) {
                isWinConan = true;break;
            }
        }
        bw.write(isWinConan ? "Conan\n" : "Agasa\n");
        bw.flush();bw.close();
    }
}
