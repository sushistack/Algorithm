import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B1539 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        BinarySearchTree bst = new BinarySearchTree();
        int ans = 0;
        while (n-- != 0) {
            ans += bst.add(Integer.parseInt(br.readLine())) + 1;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    private static class BinarySearchTree {
        private Node root;

        BinarySearchTree() {
            this.root = null;
        }

        private Node getNode(Node find) {
            Node cur = root;
            while (true) {
                int c = cur.compareTo(find);
                if (c == 0) return cur;
                cur = (c > 0) ? cur.left : cur.right;
                if (cur == null) return null;
            }
        }

        public <T extends Number> int add(T number) {
            Node cur = new Node(number);
            if (root == null) {
                root = cur;
                return 0;
            }
            if (getNode(cur) != null) return 0;
            Node compare = this.root;
            int cnt = 0;
            while (true) {
                if ((compare.compareTo(cur) > 0)) {
                    if (compare.left == null) {
                        compare.left = cur;
                        break;
                    } else compare = compare.left;
                } else {
                    if (compare.right == null) {
                        compare.right = cur;
                        break;
                    } else compare = compare.right;
                }
                cnt++;
            }
            return cnt + 1;
        }

        public <T extends Number> void remove(T number) {
            Node cur = new Node(number);
            Node nodeToBeErased = getNode(cur);
            if (nodeToBeErased == null) return;
            if (nodeToBeErased.right == null && nodeToBeErased.left == null) nodeToBeErased = null;
            else if (nodeToBeErased.left == null) changeNode(nodeToBeErased, nodeToBeErased.right);
            else if (nodeToBeErased.right == null) changeNode(nodeToBeErased, nodeToBeErased.left);
            else {
                Node minInRight = getMinNodeInRight(nodeToBeErased.right);
                Number temp = minInRight.data;
                remove(minInRight.data);
                nodeToBeErased.data = temp;
            }
        }

        private void changeNode(Node node1, Node node2) {
            node1.data = node2.data;
            node1.left = node2.left;
            node1.right = node2.right;
        }

        private Node getMinNodeInRight(Node cur) {
            if (cur.left == null) return cur;
            return getMinNodeInRight(cur.left);
        }

        /**
         *
         * @param order pre = 0, in = 1, post = 2
         * @return list
         */

        public List<Object> traversal(int order) {
            List<Node> list = new ArrayList<>();
            addOrder(list, this.root, order);
            List<Object> l = new ArrayList<>();
            for (Node n : list) l.add(n.data);
            return l;
        }

        private void addOrder(List<Node> list, Node cur, int order) {
            if (cur == null) return;
            if (order == 0) list.add(cur);
            addOrder(list, cur.left, order);
            if (order == 1) list.add(cur);
            addOrder(list, cur.right, order);
            if (order == 2) list.add(cur);
        }

        private class Node<T extends Number & Comparable<? super T>> {
            private T data;
            private Node left, right;

            public Node(T data) {
                this.data = data;
                left = right = null;
            }

            private int compareTo(Node<T> node) {
                return this.data.compareTo(node.data);
            }
        }
    }
}
