import java.io.*;

public class CF208A {
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split("WUB");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ins.length; i++) {
            if (ins[i].length() != 0)sb.append(ins[i] + " ");
        }
        bw.write(sb.toString().substring(0, sb.length() - 1) + "\n");
        bw.flush();bw.close();

    }
}
