import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1541 {
    static String str;
    static char[] chars = new char[10];
    static String[] strs = new String[55];
    static String[] numbers = new String[55];
    static boolean isMinus;
    static int Answer, o, m, sLength, t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        isMinus = false;Arrays.fill(numbers, "");
        str = sc.nextLine();o = 0;m = 0; t = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                // 연산자라면 strs[]의 홀수 index에 부호를 위치 시킴
                strs[t] = "" + str.charAt(i);
                t += 2;
                for (int j = 0; j < o; j++) {
                    //숫자를 numbers[]에 순서대로 넣음
                    numbers[m] += chars[j];
                }
                m++;
                o = 0;
            }else {// 연산자가 아니라면 chars[] 숫자를 누적시킴, 하나의 숫자가 들어감
                chars[o++] = str.charAt(i);
            }
        }
        for (int i = 0; i < o; i++) {
            numbers[m] += chars[i];
        }
        m++;
        for (int i = 0; i < m; i++) {
            strs[i * 2] = numbers[i];
        }
        sLength = m * 2 - 1;
        // 숫자와 부호가 구별되는 String array가 만들어짐
        Answer = Integer.parseInt(strs[0]);
        for (int i = 1; i < sLength; i++) {
            if (isMinus) {
                if (strs[i - 1].equals("+")) {
                    Answer -= Integer.parseInt(strs[i]);
                } else if (strs[i - 1].equals("-")) {
                    Answer -= Integer.parseInt(strs[i]);
                }
            }else {
                if (strs[i - 1].equals("+")) {
                    Answer += Integer.parseInt(strs[i]);
                }else if (strs[i - 1].equals("-")){
                    isMinus = true;
                    Answer -= Integer.parseInt(strs[i]);
                }
            }
        }
        System.out.println(Answer);
    }
}
