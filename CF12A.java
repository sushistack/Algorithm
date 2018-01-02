import java.io.*;

public class CF12A {
    static char[][] table = new char[3][3];
    static String ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i++) {
            ins = br.readLine();
            for (int j = 0; j < 3; j++) {
                table[i][j] = ins.charAt(j);
            }
        }
        boolean isSymmetric = true;
        for (int i = 0; i < 3; i++) {
            if (table[0][i] != table[2][2 - i]) {
                isSymmetric = false; break;
            }
        }
        if (table[1][0] != table[1][2]) isSymmetric = false;
        bw.write(((isSymmetric) ? "YES" : "NO") + "\n");
        bw.flush();bw.close();

    }
}
