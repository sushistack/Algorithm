import java.io.*;

public class B1065 {
    static String N;
    static int[] a = new int[4];
    static int[] b = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = br.readLine();
        for (int i = 0; i < N.length(); i++) {
            a[i] = N.charAt(i) - 48;
        }
        switch (N.length()) {
            case 1: bw.write(a[0] + "\n");break;
            case 2:
                if (a[0] <= a[1]) bw.write(N + "\n");
                else bw.write(a[0] - 1 + "9\n");
                break;
            case 3:

                break;
            case 4: bw.write("999\n");break;
        }
        bw.flush();bw.close();

    }
}
