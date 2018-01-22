import java.io.*;
import java.util.HashMap;

public class CF228A {
    static HashMap<String, Integer> hm = new HashMap<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        for (int i = 1; i < 5; i++) hm.put(ins[i - 1], 1);
        bw.write(4 - hm.size() + "\n");bw.flush();bw.close();
    }
}
