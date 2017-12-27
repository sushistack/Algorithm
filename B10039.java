import java.io.*;

public class B10039 {
    static int mean;
    static int[] score = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        mean = 0;
        for (int i = 0; i < 5; i++) {
            score[i] = Integer.parseInt(br.readLine());
            score[i] = (score[i] < 40) ? 40 : score[i];
            mean += score[i];
        }
        bw.write(mean / 5 + "\n");
        bw.flush();bw.close();
    }
}
