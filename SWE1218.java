import java.io.*;
import java.util.Stack;

public class SWE1218 {
    static int t = 10, n;
    static String in;
    static boolean isVPS;
    static Stack<Character> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            in = br.readLine();isVPS = true;
            for (int i = 0; i < in.length(); i++) {
                switch (in.charAt(i)) {
                    case '(':case '[':case '<':case '{': s.push(in.charAt(i));break;
                    case ')': if (s.peek() == '(') s.pop();else isVPS = false;break;
                    case ']': if (s.peek() == '[') s.pop();else isVPS = false;break;
                    case '>': if (s.peek() == '<') s.pop();else isVPS = false;break;
                    case '}': if (s.peek() == '{') s.pop();else isVPS = false;break;
                }
            }
            bw.write("#" + (10 - t) + " " + (isVPS && s.isEmpty() ? "1" : "0") + "\n");
            bw.flush();s.clear();
        }
        bw.close();
    }
}
