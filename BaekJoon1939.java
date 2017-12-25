import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BaekJoon1939 {
    static int N, M, A, B, C, S, E;
    static LinkedList<HashMap<Integer, Integer>>[] list = new LinkedList[10005];
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            A = sc.nextInt();B = sc.nextInt();C = sc.nextInt();
            list[A] = new LinkedList<>();list[B] = new LinkedList<>();
            map.put(B, C);list[A].add(map);map.put(A, C);list[B].add(map);
        }
        S = sc.nextInt();E = sc.nextInt();


    }
}
