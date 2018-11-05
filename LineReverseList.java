import java.io.IOException;

public class LineReverseList {
    public static void main(String[] args) throws IOException {
        Node item = new Node(1, null);
        item = new Node(2, item);
        item = new Node(3, item);
        item = new Node(4, item);
        item = new Node(5, item);
        print(item);
        Node item2 = reverse(item);
        System.out.println();
        print(item2);
    }

    public static void print(Node node) {
        System.out.print(node.value + " -> ");
        if (node.next == null) return;
        print(node.next);
    }

    public static Node reverse(Node cur) {
        if (cur.next == null) return cur;
        Node rev = reverse(cur.next);
        cur.next.next = cur;
        cur.next = null;
        return rev;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }







}
