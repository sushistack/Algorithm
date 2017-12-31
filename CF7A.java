import java.io.*;

public class CF7A {
    static int ans = 0;
    static char[][] table = new char[9][9];
    static boolean row[] = new boolean[9];
    static boolean col[] = new boolean[9];
    static boolean isBlack;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < 9; i++) {
            in = br.readLine();isBlack = true;
            for (int j = 1; j < 9; j++) {
                table[i][j] = in.charAt(j - 1);
                if (isBlack) isBlack = (table[i][j] == 'B');
            }
            row[i] = isBlack;
            if (row[i]) {
                ans++;
                for (int j = 1; j < 9; j++) {
                    table[i][j] = 'W';
                }
            }
        }
        for (int j = 1; j < 9; j++) {
            isBlack = false;
            for (int i = 1; i < 9; i++) {
                if (table[i][j] == 'B') {
                    isBlack = true;break;
                }
            }
            col[j] = isBlack;
            if (col[j]) {
                ans++;
                for (int i = 1; i < 9; i++) {
                    table[i][j] = 'W';
                }
            }
        }




        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
