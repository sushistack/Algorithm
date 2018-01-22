import java.io.*;
import java.util.ArrayList;

public class CF82A {
    static int n, idx = -1, t;
    static String s[] = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
    static ArrayList<Long> l = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());init();
        for (int i = 1; i < l.size(); i++) {
            if (n <= l.get(i)) {
                idx = i - 1;break;
            }
        }
        n -= l.get(idx);t = 1 << (idx - 1);
        int count = 0;
        while (n > t) {
           n -= t;
           count++;
        }

        bw.write(s[count] + "\n");
        bw.flush();bw.close();
    }
    public static void init() {
        l.add((long)0);l.add((long)0);l.add((long)5);
        while (l.get(l.size() - 1) < 10e9) {
            l.add((l.get(l.size() - 1) - (l.get(l.size() - 2)) << 1) + l.get(l.size() - 1));
        }
    }
}
