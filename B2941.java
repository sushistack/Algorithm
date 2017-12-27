import java.io.*;

public class B2941 {
    static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static String in, t;
    static int count = 0;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        for (int i = 0; i < croatia.length; i++) {
            t = in.replaceAll(croatia[i], " ");
            int pos = 0;
            while (pos > -1) {
                pos  = t.indexOf(" ", pos);
                if (pos > -1) {
                    count++; pos++;
                }
            }
            in = t.replaceAll(" ", "");
        }
        count += in.length();
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
