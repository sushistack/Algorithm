import java.io.*;

public class B2965 {
    static int A, B, C, min, mid, max;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        A = Integer.parseInt(in.split(" ")[0]);
        B = Integer.parseInt(in.split(" ")[1]);
        C = Integer.parseInt(in.split(" ")[2]);
        int tmp, count = 0;
        while (true) {
            if (B - A > C - B) {
                tmp = B - 1;
                if (tmp == A) break;
                C = B;B = tmp;
            } else {
                tmp = B + 1;
                if (tmp == C) break;
                A = B;B = tmp;
            }
            count++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
