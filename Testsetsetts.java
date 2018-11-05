public class Testsetsetts {

    static int fac[] = new int[50000], inverseFac[] = new int[50000];
    public static void main(String[] args) {
//        OrderedList list = new OrderedList();
//        System.out.println((-1 % 4) + "dsfdsfdf");
//        list.insert(10);
//        list.print(); // 결과: 10
//        list.insert(5);
//        list.print(); // 결과: 5, 10
//        list.insert(15);
//        list.print(); // 결과: 5, 10, 15
//        list.insert(8);
//        list.print(); // 결과: 5, 8, 10, 15
//        list.insert(10);
//        list.print(); // 결과: 5, 8, 10, 10, 15

    }

    private static class Node {
        int value;
        Node next = null;

        Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static class OrderedList {
        Node sentinel = null;
        Node head = null;

        OrderedList() {
            this.sentinel = this.head = new Node(100001, null);
        }

        public void insert(int value) {
            head = rinsert(head, value);
        }

        public Node rinsert(Node node,int value) {
            if (node.value >= value) {
                node = new Node(value, node);
            } else {
                node.next = rinsert( node.next, value);
            }
            return node;
        }

        public void print() {
            Node node = this.head;
            while(node != sentinel) {
                System.out.println(node.value + " ");
                node = node.next;
            }
            System.out.println("\n");
        }
    }


    private static void factInit() {
        fac[0] = fac[1] = 1;
        long e = 1;
        for (int i = 2; i < 50000; i++) {
            e = e * i % 100000;
            fac[i] = (int) e;
            inverseFac[i] = (int) exp(e, 100000 - 2);
        }
    }

    private static long exp(long x, int m) {
        if (m == 1) return x;
        long t = exp(x, m >> 1);
        long result = t;
        result = result * t % 100000;
        if (m % 2 == 1) {
            result = result * x % 100000;
        }
        return result;
    }

    private static long sum(int[] tree, int i) {
        long ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }

    private static void update(int[] tree, int i, int diff) {
        while (i < tree.length) {
            tree[i] += diff;
            i += (i & -i);
        }
    }
}
