import java.io.*;

public class WoowaBrothers2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = "23A84Q", b = "K2Q25J";

        bw.write(new WoowaBrothers2().solution(a, b) + "\n");
        bw.flush();bw.close();

    }

    public int solution(String A, String B) {
        int[] a = new int[A.length()], b = new int[B.length()];
        setDeck(a, A);
        setDeck(b, B);
        return winAlec(a, b);
    }

    public int winAlec(int[] a, int[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count += (a[i] > b[i]) ? 1 : 0;
        }
        return count;
    }

    public void setDeck(int[] array, String s) {
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'T' : array[i] = 10;break;
                case 'J' : array[i] = 11;break;
                case 'Q' : array[i] = 12;break;
                case 'K' : array[i] = 13;break;
                case 'A' : array[i] = 14;break;
                default: array[i] = s.charAt(i) - 48;break;
            }
        }
    }

}
