import java.io.*;
import java.util.HashMap;

public class B1152 {
    static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        String ins[] = in.split(" ");
        for (int i = 0; i < ins.length; i++) {
            if (!ins[i].equals("")) {
                if (hm.containsKey(ins[i])) {
                    hm.put(ins[i], hm.get(ins[i]) + 1);
                }else {
                    hm.put(ins[i], 1);
                }

            }
        }
        int count = 0;
        for (String key : hm.keySet()) {
            count += hm.get(key);
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
