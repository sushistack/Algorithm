import java.io.*;
import java.util.StringTokenizer;

public class NHN4 {
    static int n, v, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static String map[][] = new String[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v = 0;
            while (st.hasMoreTokens()) {
                map[i][v++] = st.nextToken();
            }
        }



        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static class Cell {

    }
}
