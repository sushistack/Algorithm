import java.io.*;

public class CFR474A {
    static String in;
    static boolean isCorrect = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        if (in.indexOf('a') < 0 || in.indexOf('b') < 0 || in.indexOf('c') < 0) {
            bw.write("NO\n");return;
        }
        if (!(in.lastIndexOf('a') < in.indexOf('b') &&
            in.lastIndexOf('b') < in.indexOf('c'))) {
            bw.write("NO\n");return;
        }
        int a, b, c;
        a = b = c = 0;
        for (int i = 0; i < in.length(); i++) {
            switch (in.charAt(i)) {
                case 'a' : a++; break;
                case 'b' : b++; break;
                case 'c' : c++; break;
            }
        }
        bw.write(a == c || b == c ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
