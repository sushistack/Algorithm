import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NHN1 {
    static int c, p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        c = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList();
        for (int i = 1; i <= c; i++) {
            d.addLast(i);
        }
        for (int i = 0; i < p; i++) {
            shuffle(Integer.parseInt(br.readLine()), d);
        }
        for (int i = 0; i < 5; i++) {
            sb.append(d.pollFirst());
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void shuffle(int n, Deque<Integer> q) {
        List<Integer> head = new ArrayList<>();
        List<Integer> rear = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            head.add(q.pollFirst());
        }
        for (int i = 0; i < n; i++) {
            rear.add(q.pollLast());
        }

        if (q.size() > (n << 1)) shuffle(n, q);
        for (int i = 0; i < n; i++) {
            q.addLast(head.get(i));
        }
        for (int i = n - 1; i > -1; i--) {
            q.addLast(rear.get(i));
        }
    }
}
