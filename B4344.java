import java.io.*;

public class B4344 {
    static int C, N, overMean;
    static String in, ins[];
    static float[] scores = new float[1001];
    static float mean, ratio;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        C = Integer.parseInt(br.readLine());
        while (C-- != 0) {
            in = br.readLine();ins = in.split(" ");
            N = Integer.parseInt(ins[0]);mean = 0;
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(ins[i + 1]);
                mean += scores[i];
            }
            mean /= N;overMean = 0;
            for (int i = 0;i < N; i++) {
                if (scores[i] > mean) overMean++;
            }
            ratio = (overMean / (float)N) * 100;
            String ans = String.format("%.3f%%", ratio);
            bw.write(ans + "\n");bw.flush();
        }
        bw.close();
    }
}
