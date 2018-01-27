import java.io.*;

public class CF478A {
    static int c = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        for (int i = 0; i < 5; i++) c += Integer.parseInt(ins[i]);
        bw.write((c % 5 == 0 && c != 0) ? c / 5 + "\n" : "-1\n");
        bw.flush();bw.close();
    }
}
