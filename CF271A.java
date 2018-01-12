import java.io.*;

public class CF271A {
    static int y;
    static String year;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        y = Integer.parseInt(br.readLine());
        while (true) {
            y++;
            year = "" + y;
            flag = true;
            for (int i = 0; i < 4; i++) {
                char ch = year.charAt(i);
                for (int j = i + 1; j < 4; j++) {
                    if (ch == year.charAt(j)) {
                        flag = false;break;
                    }
                }
                if (!flag) break;
            }
            if (flag) break;
        }
        bw.write(year + "\n");
        bw.flush();bw.close();
        
    }

}
