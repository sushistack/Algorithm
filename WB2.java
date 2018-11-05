import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class WB2 {
    static int n, ans = 0, a, b;
    static String ins[], in;
    static final int ST_MAX = 1<<21;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        SegTree st = new SegTree();
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            a = Integer.parseInt(ins[0]);
            b = Integer.parseInt(ins[1]);
            st.add(a - 1, b, 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(-, 1)");sb.append("\n");
        sb.append("[2, 3]");sb.append("\n");
        sb.append("(4, 5)");sb.append("\n");
        sb.append("(6, +)");sb.append("\n");

        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static class SegTree {
        int start;
        long arr[], lazy[];

        // 생성자
        SegTree(){
            start = ST_MAX/2;
            arr = new long[ST_MAX];
            lazy = new long[ST_MAX];
            Arrays.fill(arr, 0);
            Arrays.fill(lazy, 0);
        }

        void construct(){
            for(int i=start-1; i>0; i--)
                arr[i] = arr[i*2] + arr[i*2+1];
        }


        void propagate(int node, int ns, int ne){
            if(lazy[node] != 0){

                if(node < start){
                    lazy[node*2] += lazy[node];
                    lazy[node*2+1] += lazy[node];
                }
                arr[node] += lazy[node] * (ne-ns);
                lazy[node] = 0;
            }
        }

        void add(int s, int e, int k){ add(s, e, k, 1, 0, start); }
        void add(int s, int e, int k, int node, int ns, int ne){
            propagate(node, ns, ne);

            if(e <= ns || ne <= s) return;
            if(s <= ns && ne <= e){
                lazy[node] += k;
                propagate(node, ns, ne);
                return;
            }
            int mid = (ns+ne)/2;
            add(s, e, k, node*2, ns, mid);
            add(s, e, k, node*2+1, mid, ne);
            arr[node] = arr[node*2] + arr[node*2+1];
        }

        long sum(int s, int e){ return sum(s, e, 1, 0, start); }
        long sum(int s, int e, int node, int ns, int ne){
            propagate(node, ns, ne);

            if(e <= ns || ne <= s) return 0;
            if(s <= ns && ne <= e) return arr[node];
            int mid = (ns+ne)/2;
            return sum(s, e, node*2, ns, mid) + sum(s, e, node*2+1, mid, ne);
        }
    }

}
