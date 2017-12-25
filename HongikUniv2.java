import java.util.Scanner;

public class HongikUniv2 {
    static int m;
    static String str, strs[];
    static int[] list;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        m = sc.nextInt();sc.nextLine();
        list = new int[m + 1];
        str = sc.nextLine();strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            double t = Double.parseDouble(strs[i]) * m;
            list[(int)Math.floor(t)]++;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(list[i]);
            if (i < m - 1) System.out.print(" ");
            else System.out.println();
        }
    }
}
