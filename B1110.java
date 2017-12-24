import java.io.*;

public class B1110 {
    static String N, made = "";
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = br.readLine();
        N = (N.length() == 1) ? "0" + N : N;
        made = N;
        do{
            int num = made.charAt(0) + made.charAt(1) - 96;
            String tmp = num + "";
            made = made.charAt(1) - 48 + "" + tmp.charAt(tmp.length() - 1);
            count++;
        }
        while (!N.equals(made));
        bw.write(count + "\n");bw.flush();bw.close();
    }
}
