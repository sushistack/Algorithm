import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class B1874 {
    static int N;
    static int[] a = new int[100001];
    static ArrayList<Character> list = new ArrayList<>();
    static Stack<Integer> s = new Stack<>();
    static boolean makeSeries = true;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int t = 0, idx = 1;
        while (t < N) {
            if (s.isEmpty() || s.peek() < a[t]) {
                while (idx <= a[t]) {
                    s.push(idx);list.add('+');idx++;
                }
            }else if (s.peek() == a[t]) {
                s.pop();list.add('-');t++;
            }else {
                makeSeries = false;
            }
        }

        if (makeSeries) {
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + "\n");
                bw.flush();
            }
        }else {
            bw.write("NO\n");
            bw.flush();
        }
        bw.close();
    }
}
