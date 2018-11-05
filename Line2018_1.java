import java.io.*;
import java.util.StringTokenizer;

public class Line2018_1 {
    static int dist, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ans = 0;
        while (st.hasMoreTokens()) {
            dist = Integer.parseInt(st.nextToken());
            if (dist < 4 || dist > 178 || ans + 720 > 20000) {
                System.out.println(20000 - ans);
                return;
            }
            ans += 720;
            if (dist > 40) {
                dist -= 40;
                if (ans + (dist / 8) * 80 + ((dist % 8 != 0) ? 80 : 0) > 20000) {
                    System.out.println(20000 - (ans - 720));
                    return;
                }
                ans += (dist / 8) * 80;
                ans += (dist % 8 != 0) ? 80 : 0;
            }
        }
        bw.write(20000 - ans + "\n");
        bw.flush();bw.close();
    }
}


