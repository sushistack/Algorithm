import java.io.*;

public class CF8A {
    static String in, s1, s2;
    static boolean isForward = false, isBackward = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();s1 = br.readLine();
        s2 = br.readLine();
        int idx = isSequence(in, s1);
        if (idx > 0 && idx < in.length()) {
            String ns1 = in.substring(idx, in.length());
            isForward = (isSequence(ns1, s2) > -1);
        }
        idx = isSequence(reverse(in), s1);
        if (idx > 0 && idx < in.length()) {
            String ns2 = reverse(in).substring(idx, in.length());
            isBackward = (isSequence(ns2, s2) > -1);
        }
        String ans = "";
        if (isForward && isBackward) ans = "both";
        else {
            if (isForward) ans = "forward";
            else if (isBackward) ans = "backward";
            else ans = "fantasy";
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static int isSequence(String all, String sub) {
        int idx = all.indexOf(sub);
        idx = (idx < 0) ? -1 : idx + sub.length();
        return idx;
    }

    public static String reverse(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
