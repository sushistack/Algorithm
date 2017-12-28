import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B1181 {
    static int N;
    static String str;
    static ArrayList<String>[] list = new ArrayList[51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 51; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            list[str.length()].add(str);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 51; i++) {
            if (!list[i].isEmpty()) {
                Collections.sort(list[i], String::compareTo);
                for (int j = 0; j < list[i].size(); j++) {
                    if (j > 0) {
                        if (!list[i].get(j - 1).equals(list[i].get(j)))
                            sb.append(list[i].get(j) + "\n");
                    }else {
                        sb.append(list[i].get(j) + "\n");
                    }

                }
            }
        }
        bw.write(sb.toString());
        bw.flush();bw.close();


    }
}
