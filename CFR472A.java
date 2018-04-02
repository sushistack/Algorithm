import java.io.*;
import java.util.ArrayList;

public class CFR472A {
    static int n, count = 0;
    static String in;
    static char[] colors = {'C', 'M', 'Y'};
    static ArrayList<Integer> unpainted = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        in = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '?') unpainted.add(i);
        }
        boolean already = false, flag = true;
        for (int i = 1; i < in.length() - 1; i++) {
            if (in.charAt(i) == '?') continue;
            if (in.charAt(i - 1) == in.charAt(i) ||
                    in.charAt(i) == in.charAt(i + 1)) {
                already = true; break;
            }
        }
        if (already)sb.append("No\n");
        else {


                int curIdx, prev, next;
                for (int i = 0; i < unpainted.size(); i++) {
                    curIdx = unpainted.get(i);
                    prev = curIdx - 1;
                    next = curIdx + 1;
                    if (in.equals("??")) {
                        sb.append("Yes\n");break;
                    }
                    if (prev < 0 && next > in.length() - 1) count += 2;
                    else {
                        if (prev < 0) count += (in.charAt(next) == '?') ? 0 : 2;
                        else if (next > in.length() - 1)
                            count += (in.charAt(prev) == '?') ? 0 : 2;
                        else {
                            count += (in.charAt(prev) != '?' &&
                                    in.charAt(next) != '?' &&
                                    in.charAt(prev) != in.charAt(next)) ? 0 : 2;
                        }
                    }
                    if (count > 0) {
                        sb.append("Yes\n");break;
                    }
                }
                if (sb.length() == 0) sb.append("No\n");

        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

}
