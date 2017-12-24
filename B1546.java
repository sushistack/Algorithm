import java.io.*;

public class B1546 {
    static int N;
    static String in, ins[];
    static float[] scores = new float[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        in = br.readLine();ins = in.split(" ");
        for (int i = 0; i < ins.length; i++) {
            scores[i] = Float.parseFloat(ins[i]);
        }
        float max = 0, mean = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, scores[i]);
        }
        for (int i = 0; i < N; i++) {
            scores[i] /= max;scores[i] *= 100.;
            mean += scores[i];
        }
        mean /= (float)N;
        bw.write(mean + "\n");bw.flush();
        bw.close();

    }
}
