import java.io.*;

public class CF131A {
    static String in, after;
    static boolean isFirstCapital, isAllCapital = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        isFirstCapital = (in.charAt(0) < 91 && in.charAt(0) > 64);
        if (in.length() == 1) {
            if (!isFirstCapital) after = in.toUpperCase();
            else after = in.toLowerCase();
        }else {
            for (int i = 1; i < in.length(); i++) {
                if (in.charAt(i) > 95) {
                    isAllCapital = false;break;
                }
            }
            if (isAllCapital)
                after = (isFirstCapital) ? in.toLowerCase() :
                        in.substring(0, 1).toUpperCase() + in.substring(1, in.length()).toLowerCase();
            else after = in;
        }

        bw.write(after + "\n");
        bw.flush();bw.close();
    }
}
