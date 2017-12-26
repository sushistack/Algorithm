import java.io.*;

public class B1065 {
    static int N;
    static int[] han = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        initHan();bw.write(han[N] + "\n");
        bw.flush();bw.close();

    }
    public static void initHan() {
        for (int i = 1; i < 100; i++) {
            han[i] = i;
        }
        String number, numbers[];
        for (int i = 100; i < 1000; i++) {
            number = "" + i;
            numbers = number.split("");
            int term = Integer.parseInt(numbers[1]) - Integer.parseInt(numbers[0]);
            han[i] = ((Integer.parseInt(numbers[0]) + 2 * term) == Integer.parseInt(numbers[2])) ?
                    han[i - 1] + 1 : han[i - 1];
        }
        han[1000] = han[999];
    }
}
