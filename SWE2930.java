import java.io.*;
import java.util.Arrays;

public class SWE2930 {
    static int t, T, n;
    static String[] ins;
    static Heap maxHeap = new Heap();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = t = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            maxHeap.clear();
            n = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                ins = br.readLine().split(" ");
                if (ins.length == 1) sb.append(" " + maxHeap.poll());
                else maxHeap.offer(Integer.parseInt(ins[1]));
            }
            bw.write("#" + (t - T) + sb.toString() + "\n");
            bw.flush();
        }
        bw.close();
    }

    private static class Heap {
        int[] node;
        int size, maxSize;
        Heap() {
            node = new int[100003];
            size = 0;maxSize = 100002;
        }

        public int size() { return this.size; }

        public boolean isEmpty() {return this.size == 0;}

        public int offer(int data) {
            if (this.size < maxSize) {
                node[++size] = data;
                reHeapBottomUp();return 1;
            }else return -1;
        }

        public void reHeapBottomUp() {
            int curIdx = size;
            int pIdx = size / 2;
            while (node[curIdx] > node[pIdx]) {
                if (pIdx < 1) break;
                int tmp = node[curIdx];
                node[curIdx] = node[pIdx];
                node[pIdx] = tmp;
                tmp = pIdx;
                pIdx = pIdx / 2;
                curIdx = tmp;

            }
        }

        public int peek() { return (!isEmpty()) ? node[1] : -1; }

        public void clear() { size = 0;Arrays.fill(node, 0); }

        public int poll() {
            if (isEmpty()) return -1;
            else {
                int reVal = node[1];
                node[1] = node[size];
                node[size] = 0;
                size--;
                int curIdx = 1;
                int leftChild = 2 * curIdx;
                int rightChild = 2 * curIdx + 1;

                while (true) {
                    if (leftChild > size) break;
                    if (rightChild > size) {
                        if (node[curIdx] < node[leftChild]) {
                            int tmp = node[curIdx];
                            node[curIdx] = node[leftChild];
                            node[leftChild] = tmp;
                            break;
                        }else break;
                    }
                    if (node[curIdx] > node[leftChild] && node[curIdx] > node[rightChild]) break;
                    else if (node[rightChild] < node[leftChild]) {
                        int tmp = node[curIdx];
                        node[curIdx] = node[leftChild];
                        node[leftChild] = tmp;
                        curIdx = leftChild;
                    }else{
                        int tmp = node[curIdx];
                        node[curIdx] = node[rightChild];
                        node[rightChild] = tmp;
                        curIdx = rightChild;
                    }
                    leftChild = 2 * curIdx;
                    rightChild = 2 * curIdx + 1;
                }
                return reVal;
            }
        }

    }
}
