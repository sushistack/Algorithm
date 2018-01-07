import java.io.*;

public class SWE1928 {
    static int t;
    static String in;
    static char[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            in = br.readLine();
            c = in.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < c.length; j++) {
                int v;
                if (c[j] > 64 && c[j] < 91) v = c[j] - 65;
                else if(c[j] > 96 && c[j] < 123) v = c[j] - 71;
                else if (c[j] > 47 && c[j] < 58) v = c[j] + 4;
                else v = c[j] + 19;
                String s = Integer.toBinaryString(v);
                while (s.length() < 6) s = "0" + s;
                sb.append(s);
            }
            String byteString;
            StringBuffer ans = new StringBuffer();
            for (int j = 0; j < sb.length(); j+=8) {
                byteString = sb.toString().substring(j, j + 8);
                int dec = Integer.parseInt(byteString, 2);
                ans.append((char)dec);
            }
            bw.write("#" + i + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }
}
