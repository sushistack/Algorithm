import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CFR473B {
    static int n, k, m, v = 1, uf[] = new int[100001];
    final static int INF = -2000000000;
    static HashMap<String, Integer> hm = new HashMap<>();
    static long ans = 0;
    static String ins[], w;
    static Word[] words = new Word[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        m = Integer.parseInt(ins[2]);
        Arrays.fill(uf, INF);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            words[v++] = new Word(st.nextToken(), 0);
            hm.put(words[v - 1].w, v - 1);
        }
        v = 1;
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            words[v++].setScore(Integer.parseInt(st.nextToken()));
        }
        int r;
        for (int i = 0; i < k; i++) {
            ins = br.readLine().split(" ");
            r = Integer.parseInt(ins[1]);
            uf[r] = -words[r].score;
            for (int j = 2; j < ins.length; j++) {
                merge(r, Integer.parseInt(ins[j]));
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            ans += -uf[find(hm.get(st.nextToken()))];
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


    public static int find(int a){
        if(uf[a] < 0) return a;
        return uf[a] = find(uf[a]);
    }

    public static boolean merge(int a, int b){
        a = find(a);b = find(b);
        if(a == b) return false;
        uf[b] = a;
        if (words[b].score < -uf[a]) uf[a] = -words[b].score;
        return true;
    }


    private static class Word {
        String w;
        int score;
        Word(String w, int score) {
            this.w = w;this.score = score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
