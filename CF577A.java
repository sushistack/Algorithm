import java.io.*;
import java.util.ArrayList;

public class CF577A {
    static int n, x, count = 0;
    static ArrayList<Integer> divisors = new ArrayList<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        x = Integer.parseInt(ins[1]);
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (i != Math.sqrt(x)) divisors.add(x / i);
            }

        }

        for (int i = 0; i < divisors.size(); i++) {
            int t = divisors.get(i);
            if (t <= n && x / t <= n) count++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
