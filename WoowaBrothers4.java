import java.io.*;
import java.util.ArrayList;

public class WoowaBrothers4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a, b, c, d;
        a = 2;
        b = 4;
        c = 2;
        d = 4;
        bw.write(new WoowaBrothers4().solution(a, b, c, d) + "\n");
        bw.flush();bw.close();

    }
    static int max;
    public int solution(int a, int b, int c, int d) {
        max = -1;
        int t[] = new int[4];
        t[0] = a;t[1] = b;t[2] = c;t[3] = d;
        dfs(0, 0, t, 0);
        return max;
    }

    public void dfs (int idx, int status, int[] t, int check) {
        if (idx == 4) {
            if (check == 2) {
                ArrayList<Integer> point1 = new ArrayList<>();
                ArrayList<Integer> point2 = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    if ((status & (1 << i)) != 0) point1.add(t[i]);
                    else point2.add(t[i]);
                }
                int x1 = point1.get(0);
                int y1 = point1.get(1);
                int x2 = point2.get(0);
                int y2 = point2.get(1);
                max = Math.max(max, getSquireDist(x1, y1, x2, y2));
            }
            return;
        }
        if (check < 2) dfs(idx + 1, status + (1 << idx), t, check + 1);
        dfs(idx + 1, status, t, check);
    }

    public int getSquireDist(int x1, int y1, int x2, int y2) {
        return (int)(Math.pow(x1 - x2 , 2) + Math.pow(y1 - y2, 2));
    }


}
