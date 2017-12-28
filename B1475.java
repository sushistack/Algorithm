import java.io.*;

public class B1475 {
    static int count = 0;
    static String N;
    static int[] numbers = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = br.readLine();
        for (int i = 0; i < N.length(); i++) {
            numbers[N.charAt(i) - 48]++;
        }
        while (!isEmpty()) {
            for (int i = 0; i < 10; i++) {
                if (i == 6 && numbers[i] == 0 && numbers[i + 3] > 0) {
                    numbers[i + 3]--;
                }else if (i == 9 && numbers[i] == 0 && numbers[i - 3] > 0) {
                    numbers[i - 3]--;
                } else {
                    if (numbers[i] > 0) numbers[i]--;
                }
            }
            count++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
    public static boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < 10; i++) {
            if (numbers[i] != 0) {
                empty = false;break;
            }
        }
        return empty;
    }
}
