import java.io.*;

public class B10866 {
    static int N;
    static String[] ins;
    static Deque dq = new Deque();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            ins = br.readLine().split(" ");
            if (ins.length == 1) {
                switch (ins[0]) {
                    case "pop_back": bw.write(dq.pollRear() + "\n"); break;
                    case "pop_front": bw.write(dq.pollFront() + "\n"); break;
                    case "front": bw.write(dq.front() + "\n"); break;
                    case "back": bw.write(dq.rear() + "\n"); break;
                    case "size": bw.write(dq.size() + "\n"); break;
                    case "empty": bw.write((dq.isEmpty() ? 1 : 0) + "\n"); break;
                }
            }else {
                if (ins[0].equals("push_back")) dq.pushBack(Integer.parseInt(ins[1]));
                else dq.push(Integer.parseInt(ins[1]));
            }
            bw.flush();
        }
        bw.close();
    }
    private static class Deque {
        int size;
        Node front, rear;
        class Node {
            int data;
            Node next, prev;
            Node(int data) {
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return (size == 0);
        }

        public int front() {
            return (isEmpty()) ? -1 : front.data;
        }

        public int rear() {
            return (isEmpty()) ? -1 : rear.data;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = rear = newNode;
            }else if (size() == 1){
                newNode.next = rear;
                rear.prev = newNode;
                front = newNode;
            } else{
                front.prev = newNode;
                newNode.next = front;
                front = newNode;
            }
            size++;
        }

        public void pushBack(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = rear = newNode;

            }else if (size() == 1){
                newNode.prev = front;
                front.next = newNode;
                rear = newNode;
            }
            else {
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }
            size++;
        }

        public int pollFront() {
            if(isEmpty()) return -1;
            else {
                int data = front.data;
                front = front.next;
                size--;
                return data;
            }
        }

        public int pollRear() {
            if (isEmpty()) return -1;
            else {
                int data = rear.data;
                rear = rear.prev;
                size--;
                return data;
            }
        }

        Deque() {
            size = 0;
            front = rear = null;
        }
    }
}
