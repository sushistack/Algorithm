import java.io.*;

public class B1991 {
    private static int n;
    private static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        Tree t = new Tree();
        while (n-- != 0) {
            ins = br.readLine().split(" ");
            t.insert(ins[0].charAt(0), ins[1].charAt(0), ins[2].charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.traversal('A', Tree.Type.PREORDER)).append("\n");
        sb.append(t.traversal('A', Tree.Type.INORDER)).append("\n");
        sb.append(t.traversal('A', Tree.Type.POSTORDER)).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Tree {
        Node[] nodes;

        public Tree() {
            nodes = new Node[26];
        }

        public void insert(char parent, char left, char right) {
            nodes[parent - 65] = new Node(left, right);
        }

        enum Type {PREORDER, INORDER, POSTORDER}

        class Node {
            char left, right;

            public Node(char left, char right) {
                this.left = left;
                this.right = right;
            }
        }

        public String traversal(char cur, Type type) {
            if (cur == '.') return "";
            StringBuilder sb = new StringBuilder();
            if (type == Type.PREORDER) sb.append(cur);
            sb.append(traversal(nodes[cur - 65].left, type));
            if (type == Type.INORDER) sb.append(cur);
            sb.append(traversal(nodes[cur - 65].right, type));
            if (type == Type.POSTORDER) sb.append(cur);
            return sb.toString();
        }
    }
}

