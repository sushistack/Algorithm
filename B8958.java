import java.io.*;

public class B8958 {
    static int N, continuous, score;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            in = br.readLine();
            continuous = 0;score = 0;
            for (int j = 0; j < in.length(); j++) {
                score += (in.charAt(j) == 'O') ? continuous + 1 : 0;
                continuous = (in.charAt(j) == 'O') ? continuous + 1 : 0;
            }
            bw.write(score + "\n");
            bw.flush();
        }
        bw.close();
    }
}
