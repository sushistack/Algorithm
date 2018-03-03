import java.io.*;

public class SWE1231 {
    static int t = 10, n;
    static Tree[] tree;
    static String ins[];
    static StringBuilder sb, ans = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            tree = new Tree[401];
            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ins = br.readLine().split(" ");
                int idx, l, r;
                switch (ins.length) {
                    case 2:
                        idx = Integer.parseInt(ins[0]);
                        tree[idx] = new Tree(ins[1], -1, -1);
                        break;
                    case 3:
                        idx = Integer.parseInt(ins[0]);
                        l = Integer.parseInt(ins[2]);
                        tree[idx] = new Tree(ins[1], l, -1);
                        break;
                    case 4:
                        idx = Integer.parseInt(ins[0]);
                        l = Integer.parseInt(ins[2]);
                        r = Integer.parseInt(ins[3]);
                        tree[idx] = new Tree(ins[1], l, r);
                        break;
                }

            }
            inOrder(1);
            ans.append("#");ans.append(10 - t);ans.append(" ");
            ans.append(sb);ans.append("\n");
        }
        bw.write(ans.toString());
        bw.flush();bw.close();

    }

    public static void inOrder(int node) {
        if (node == -1) return;
        inOrder(tree[node].left);
        sb.append(tree[node].s);
        inOrder(tree[node].right);
    }

    private static class Tree {
        String s;
        int left, right;
        Tree(String s, int left, int right) {
            this.s = s;this.left = left;this.right = right;
        }
    }
}
