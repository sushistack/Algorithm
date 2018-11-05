import java.io.*;

public class B15685 {
    static int n;
    static int[][][] dragonCurve = {
        {{1, 1}},
        {{0, 1}, {1, 1}},
        {{1, 0}, {1, 1}, {1, 1}},
        {{1, 1, 1, 0}, {1, 1, 1, 1}, {0, 0, 1, 1}}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {

        }


    }
}
