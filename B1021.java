import java.io.*;
import java.util.ArrayList;

public class B1021 {
    static int N, M, count = 0, first;
    static String in, ins[];
    static ArrayList<Integer> numbers = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        N = Integer.parseInt(in.split(" ")[0]);
        M = Integer.parseInt(in.split(" ")[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            numbers.add(Integer.parseInt(ins[i]));
        }
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        boolean isPoll = true;
        int ans = 0;
        while (!numbers.isEmpty()) {
            if (isPoll) {
                count = 0;
                first = list.get(0);
            }
            if (numbers.get(0).equals(list.get(0))) {
                list.remove(0);numbers.remove(0);
                ans += (count > list.size() / 2) ? list.size() - count + 1 : count;
                isPoll = true;
            }else {
                leftRotate();count++;
                isPoll = false;
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();

    }
    public static void leftRotate() {
        int t = list.remove(0);
        list.add(t);
    }
}
