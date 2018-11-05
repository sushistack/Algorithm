import java.io.*;

public class CFR466C {
    static int n, k;
    static String s, ins[];
    static boolean a[] = new boolean[26], isFind = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 97] = true;
        }
        StringBuilder sb = new StringBuilder();

        if (n < k) {
            sb.append(s);
            int t = -1;
            for (int i = 0; i < 26; i++) {
                if (a[i]) {
                    t = i; break;
                }
            }
            for (int i = 0; i < k - n; i++) {
                sb.append((char)(t + 97));
            }
            sb.append("\n");
        }else {
            char[] ca = s.toCharArray();
            int idx = k - 1;
            while (true) {
                boolean isBigger = false;
                int t = -1;
                for (int i = ca[idx] - 96; i < 26; i++) {
                    if (a[i]) {
                        t = i;
                        isBigger = true; break;
                    }
                }
                if (isBigger) {
                    ca[idx] = (char)(t + 97);
                    break;
                }else {
                    int first = -1;
                    for (int i = 0; i < 26; i++) {
                        if (a[i]) {
                            first = i; break;
                        }
                    }
                    ca[idx--] = (char)(first + 97);
                }
            }
            for (int i = 0; i < k; i++) {
                sb.append(ca[i]);
            }
            sb.append("\n");
        }



        bw.write(sb.toString());
        bw.flush();bw.close();
    }

}
