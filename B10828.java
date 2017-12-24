import java.util.Scanner;

public class B10828 {
    static int N;
    static String in, ins[];
    static Stack s = new Stack();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();sc.nextLine();
        for (int i = 0; i < N; i++) {
            in = sc.nextLine();
            ins = in.split(" ");
            if (ins.length == 1) {
                switch (ins[0]) {
                    case "top": System.out.println(s.top()); break;
                    case "size": System.out.println(s.size()); break;
                    case "empty": System.out.println((s.isEmpty()) ? 1 : 0); break;
                    case "pop": System.out.println(s.pop()); break;
                }
            }else {
                s.push(Integer.parseInt(ins[1]));
            }
        }
    }

    private static class Stack {
        Node top;
        int size;

        class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;next = null;
            }
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = this.top;
            this.top = newNode;
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }else {
                int data = this.top.data;
                this.top = this.top.next;
                size--;
                return data;
            }

        }

        public int top() {
            return (isEmpty()) ? -1 : this.top.data;
        }

        public int size() {
            return this.size;
        }
        public boolean isEmpty() {
            return (this.size == 0);
        }

        Stack() {
            this.size = 0;top = null;
        }
    }
}
