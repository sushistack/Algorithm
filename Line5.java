import java.io.*;

public class Line5 {
    static int n, m, d, i;
    static String ins[], in;
    static PartTime[] p = new PartTime[501];
    static PartTime dp[] = new PartTime[202];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int j = 0; j < n; j++) {
            ins = br.readLine().split(" ");
            m = Integer.parseInt(ins[0]);
            d = Integer.parseInt(ins[1]);
            i = Integer.parseInt(ins[2]);
            p[j] = new PartTime(m , d, i);
        }



        bw.flush();bw.close();
    }




    private static class PartTime {
        int m, d ,i;
        PartTime(int m, int d, int  i) {
            this.m = m; this.d = d;this.i = i;
        }
    }


}
