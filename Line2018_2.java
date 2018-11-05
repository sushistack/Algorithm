import java.io.*;
import java.util.StringTokenizer;

public class Line2018_2 {
    static int n, m, k;
    static String in, ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

        }


        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static class Node {
        int R, L, B, F;

        public Node(int r, int l, int b, int f) {
            R = r;L = l;B = b;F = f;
        }
    }
}
