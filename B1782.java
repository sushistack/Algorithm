import java.io.*;

public class B1782 {
    static long a, b, cnt = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        a = Long.parseLong(ins[0]);
        b = Long.parseLong(ins[1]);
        for (long i = a; i < b + 1; i++) {
            if (isReflect(i)) cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();bw.close();
    }

    private static boolean isReflect(long n) {
        StringBuilder o = new StringBuilder(n + "");
        for (int i = 0; i < o.length(); i++) {
            if (o.charAt(i) == '0' && o.reverse().charAt(i) != '0') return false;
            if (o.charAt(i) == '1' && o.reverse().charAt(i) != '1') return false;
            if (o.charAt(i) == '2' && o.reverse().charAt(i) != '5') return false;
            if (o.charAt(i) == '5' && o.reverse().charAt(i) != '2') return false;
            if (o.charAt(i) == '8' && o.reverse().charAt(i) != '8') return false;
            if (o.charAt(i) == '3' || o.charAt(i) == '4' || o.charAt(i) == '6' ||
                o.charAt(i) == '7' || o.charAt(i) == '9') return false;
        }
        return true;
    }
}
