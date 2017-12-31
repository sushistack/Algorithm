import java.io.*;
import java.util.Arrays;

public class CF6A {
    static int[] s = new int[4];
    static String ins[];
    static boolean isTriangle = false, isSegment = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            s[i] = Integer.parseInt(ins[i]);
        }
        for (int i = 0; i < 2; i++) {
            for(int j = i + 1; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    triangle(s[i], s[j], s[k]);
                }
            }
        }
        String s = "";
        if (isTriangle) s = "TRIANGLE";
        else if (isSegment) s = "SEGMENT";
        else s = "IMPOSSIBLE";
        bw.write(s + "\n");
        bw.flush();bw.close();
    }
    public static void triangle(int a, int b, int c) {
        int[] t = {a, b, c};
        Arrays.sort(t);
        if (t[2] < t[0] + t[1]) isTriangle = true;
        if (t[2] == t[0] + t[1]) isSegment = true;
    }
}
