import java.io.*;

public class B10817 {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        A = Integer.parseInt(in.split(" ")[0]);
        B = Integer.parseInt(in.split(" ")[1]);
        C = Integer.parseInt(in.split(" ")[2]);
        int ans = (A > B) ? (A > C) ? (B > C) ? B : C : A : (A > C) ? A : (B > C) ? C : B;
        bw.write(ans + "\n");bw.flush();bw.close();
    }
}
