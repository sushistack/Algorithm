import java.io.*;
import java.util.StringTokenizer;

public class WoowaBrothers1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[200000];



        bw.write(new WoowaBrothers1().solution(a));
        bw.flush();bw.close();

    }
    public int solution(int[] a) {
        int max = 0;
        Stack s = new Stack();
        StringTokenizer st = new StringTokenizer("sdfdsf", " ");
        while (st.hasMoreTokens()) {
            String v = st.nextToken();
            switch (v) {
                case "POP" : s.pop(); break;
                case "DUP" : s.duplicate();break;
                case "+" : s.plus();break;
                case "-" : s.subtract();break;
                default: s.push(Integer.parseInt(v));break;
            }
        }
        return max;
    }


    private class Stack {
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

        public int plus() {
            int one = (this.isEmpty()) ? -1 : this.pop();
            if (one == -1) return -1;
            int two = (this.isEmpty()) ? -1 : this.pop();
            if (two == -1) return -1;
            this.push(one + two);
            return 1;

        }

        public int subtract() {
            int one = (this.isEmpty()) ? -1 : this.pop();
            if (one == -1) return -1;
            int two = (this.isEmpty()) ? -1 : this.pop();
            if (two == -1) return -1;
            if (one - two < 0) {
                return -1;
            }else {
                this.push(one - two);
                return 1;
            }
        }

        public int duplicate() {
            if (this.isEmpty()) return -1;
            int one = this.top.data;
            push(one);
            return 1;
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
