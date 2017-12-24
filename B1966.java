import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B1966 {
    static int T;
    static String in, ins[], documents[];
    static Queue<Document> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            in = br.readLine();ins = in.split(" ");
            in = br.readLine();documents = in.split(" ");
            for (int i = 0; i < documents.length; i++) {
                q.offer(new Document(Integer.parseInt(documents[i]), i));
            }
            Arrays.sort(documents);
            for (int i = documents.length - 1; i > -1;) {
                if (Integer.parseInt(documents[i]) == q.peek().priority) {
                    Document d = q.poll();
                    if (d.index == Integer.parseInt(ins[1])){
                        bw.write(documents.length - i + "\n");bw.flush();break;
                    }
                    i--;
                }else {
                    Document d = q.poll();q.offer(d);
                }
            }
            q.clear();
        }
        bw.close();
    }
    private static class Document{
        int priority, index;
        Document(int priority, int index) {
            this.priority = priority; this.index = index;
        }
    }
}
