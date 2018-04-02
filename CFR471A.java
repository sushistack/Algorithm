import java.io.*;

public class CFR471A {
    static int h, m, H, D, N, remain;
    static double cost, discountedCost;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ins = br.readLine().split(" ");
        h = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        H = Integer.parseInt(ins[0]);D = Integer.parseInt(ins[1]);
        cost = Double.parseDouble(ins[2]);N = Integer.parseInt(ins[3]);
        discountedCost = 0.8 * cost;
        double requiredBuns = (H % N == 0) ? H / N :H / N + 1;
        if (h >= 20) sb.append(requiredBuns * discountedCost);
        else {
            double case1 = requiredBuns * cost;
            remain = (m == 0) ? (20 - h) * 60 : (19 - h) * 60;
            remain += (m == 0) ? 0 : 60 - m;
            int penalty = remain * D;
            H += penalty;
            requiredBuns = (H % N == 0) ? H / N :H / N + 1;
            double case2 = requiredBuns * discountedCost;
            sb.append((case1 < case2) ? case1 : case2);
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
