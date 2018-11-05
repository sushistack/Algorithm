import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class CFR459C {
    static String in;
    static int a[] = new int[3], count = 0;
    static char[] ca = new char[5001];
    static Stack<Character> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();

        for (int i = 0; i < in.length() - 1; i++) {
            for (int j = i + 2; j <= in.length(); j++) {
                ca = in.substring(i, j).toCharArray();
                Arrays.fill(a, 0);
                for (int k = 0; k < ca.length; k++) {
                    switch (ca[k]) {
                        case '(': a[0]++; break;
                        case ')': a[1]++; break;
                        case '?': a[2]++; break;
                    }
                }
                if (a[0] == 0 && a[1] == 0 && a[2] % 2 == 0) count++;

                int l = a[0], r = a[1], q = a[2];
                int lc = 0, rc = 0;
                if (l < r) {
                    q -= (r - l);l = r;
                    boolean flag = true;
                    for (int k = 0; k < ca.length; k++) {
                        if (ca[k] == '(') s.push('(');
                        else {
                            if (s.isEmpty()) {
                                if (ca[k] == ')') {
                                    flag = false;break;
                                }else {
                                    s.push('(');q--;
                                }
                            }else {
                                if (ca[k] == ')') {
                                    s.pop();
                                }else {
                                    if (q > 0) {
                                        s.push('(');q--;
                                    }
                                    else s.pop();
                                }
                            }
                        }
                    }
                    count += (s.isEmpty() && flag) ? 1 : 0;
                }else {
                    q -= (l - r);r = l;
                    boolean flag = true;
                    for (int k = 0; k < ca.length; k++) {
                        if (ca[k] == '(') s.push('(');
                        else {
                            if (s.isEmpty()) {
                                if (ca[k] == ')') {
                                    flag = false;break;
                                }else {
                                    s.push('(');
                                }
                            }else {
                                if (ca[k] == ')') {
                                    s.pop();
                                }else {
                                    s.pop();q--;
                                }
                            }
                        }
                    }
                    count += (s.isEmpty() && flag) ? 1 : 0;
                }
                s.clear();
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
