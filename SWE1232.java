import java.io.*;

public class SWE1232 {
    static int t = 10, n, idx, l, r;
    static Node[] nodes;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            nodes = new Node[1001];
            for (int i = 1; i <= n; i++) {
                ins = br.readLine().split(" ");
                idx = Integer.parseInt(ins[0]);
                if (ins.length == 2)  nodes[idx] = new Node(ins[1]);
                else {
                    l = Integer.parseInt(ins[2]);
                    r = Integer.parseInt(ins[3]);
                    nodes[idx] = new Node(ins[1], l, r);
                }
            }
            sb.append("#");sb.append(10 - t);sb.append(" ");
            sb.append(operation(1));sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static int operation(int node) {
        if (nodes[node].isOperator) {
            int l = operation(nodes[node].left);
            int r = operation(nodes[node].right);
            int ans = -1;
            switch (nodes[node].val) {
                case "+": ans = l + r; break;
                case "-": ans = l - r; break;
                case "*": ans = l * r; break;
                case "/": ans = l / r; break;
            }
            return ans;
        }else {
            return Integer.parseInt(nodes[node].val);
        }
    }

    private static class Node {
        String val;
        boolean isOperator;
        int left, right;
        Node(String val) {
            this.val = val;
            left = right = -1;
            isOperator = false;
        }
        Node(String val, int left, int right) {
            this.val = val;this.left = left;this.right = right;
            isOperator = true;
        }
    }
}
