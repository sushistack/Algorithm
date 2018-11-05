import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SWE1242 {
    static int t, T, n, m;
    static String ins[], hex[] = new String[91], prev, curr;
    static char[][] table = new char[2001][501];
    static HashSet<String> hs = new HashSet<>();
    static int[][] codes = {{3, 2, 1, 1}, {2, 2, 2, 1}, {2, 1, 2, 2}, {1, 4, 1, 1}, {1, 1, 3, 2},
            {1, 2, 3, 1}, {1, 1, 1, 4}, {1, 3, 1, 2}, {1, 2, 1, 3}, {3, 1, 1, 2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        hex['0'] = "0000";hex['1'] = "0001";hex['2'] = "0010";hex['3'] = "0011";
        hex['4'] = "0100";hex['5'] = "0101";hex['6'] = "0110";hex['7'] = "0111";
        hex['8'] = "1000";hex['9'] = "1001";hex['A'] = "1010";hex['B'] = "1011";
        hex['C'] = "1100";hex['D'] = "1101";hex['E'] = "1110";hex['F'] = "1111";
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            m = Integer.parseInt(ins[1]);
            prev = "";hs.clear();
            for (int i = 0; i < n; i++) {
                curr = br.readLine();
                table[i] = curr.toCharArray();
                if (curr.equals(prev)) continue;
                char p = curr.charAt(0), c;
                StringBuilder code = new StringBuilder();
                code.append((p == '0') ? "" : p);
                for (int j = 1; j < m; j++) {
                    c = curr.charAt(j);
                    if (c != '0') code.append(c);
                    else if (p != '0') {
                        hs.add(code.toString());
                        code.setLength(0);
                    }
                    p = c;
                }
                prev = curr;
            }
            Iterator<String> it = hs.iterator();
            int ans = 0;
            while (it.hasNext()) {
                ans += getSumOfCode(hexToBinary(it.next()));
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static String hexToBinary(String h) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < h.length(); i++) binary.append(hex[h.charAt(i)]);
        /*
        * 1. 바이너리 스트링을 만듭니다
        * 2. 어떤 길이의 코드인지 알기위해 maxLength라는 값을 지정
        * (binary의 길이가 52, 56, 60, 108, 112, 116) 이런식으로 나올 수 있기 때문임.
        * 3. 암호코드의 뒤는 무조건 1이기 때문에 뒤의 0들은 모두 자름
        * 4. 이후 스트링의 길이가 maxLength보다 작은 경우 0을 추가해줌
        * 5. 큰 경우, 앞에서부터 자름
        * */
        int cur = binary.length() - 1;
        int maxLength = (binary.length() / 56) * 56;
        while (binary.charAt(cur) == '0') binary.deleteCharAt(cur--);
        if (binary.length() < maxLength) {
            while (binary.length() != maxLength) binary.insert(0, '0');
        } else if (binary.length() > maxLength) {
            while (binary.length() != maxLength) binary.deleteCharAt(0);
        }
        return binary.toString();
    }

    private static int getSumOfCode(String binary) {
        int l = binary.length() / 56;
        int term = 7 * l, t;// 배율에 따라 봐야하는 부분 스트링의 길이가 다르기 때문
        int even = 0, odd = 0;
        boolean flag = false;
        for (int i = 0; i < binary.length(); i += term) {
            t = decryption(binary.substring(i, i + term));
            if (t == -1) return 0;
            if (flag) even += t;
            else odd += t;
            flag = !flag;
        }
        int disc = odd * 3 + even;
        return (disc % 10 == 0) ? (odd + even) : 0;
    }

    private static int decryption(String bi) {
        // 문제에서 말한대로 비율을 검사하는 메소드
        // 문제가 있는 경우나 없는 경우 -1을 리턴, 있으면 그 숫자를 리턴
        int term = bi.length() / 7, a[] = new int[4], v = 0;
        Arrays.fill(a, 1);
        char p = bi.charAt(0), c;
        for (int i = term; i < bi.length(); i += term) {
            c = bi.charAt(i);
            if (c == p) a[v]++;
            else v++;
            p = c;
            if (v > 3) return -1;
        }
        for (int i = 0; i < 10; i++) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if (codes[i][j] != a[j]) flag = false;
            }
            if (flag) return i;
        }
        return -1;
    }
}
