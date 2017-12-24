import java.io.*;
//이런 간단한 문제도 어렵게 생각하는 경우가 있음
public class B2839 {
    static int N, remain, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N/5; i++) {
            remain = N - i * 5;
            if (remain % 3 == 0) min = Math.min(min, i + (remain/3));
        }
        bw.write((min == Integer.MAX_VALUE) ? "-1\n" : min + "\n");
        bw.flush();bw.close();
    }

}
