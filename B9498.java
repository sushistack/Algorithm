import java.io.*;

public class B9498 {
    static int N;
    static String score = "F";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        switch (N / 10) {
            case 10: case 9: score = "A"; break;
            case 8: score = "B"; break;
            case 7: score = "C"; break;
            case 6: score = "D"; break;
        }
        bw.write(score + "\n");bw.flush();
        bw.close();
    }
}
