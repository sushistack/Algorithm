import java.io.*;
import java.util.Stack;

public class B9012 {
    static String in;
    static Stack<Character> s = new Stack<>();
    static int N;
    static boolean isVPS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            in = br.readLine();isVPS = true;
            for (int j = 0; j < in.length(); j++) {
                if (in.charAt(j) == '(') {
                    s.push(in.charAt(j));
                }else {
                    if (s.isEmpty()) {
                        isVPS = false;break;
                    }else {
                        s.pop();
                    }
                }
            }
            if (isVPS && s.isEmpty()){
                bw.write("YES\n");bw.flush();
            }else {
                bw.write("NO\n");bw.flush();
            }
            s.clear();
        }
        bw.close();
    }
}
