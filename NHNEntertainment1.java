import java.util.Scanner;

public class NHNEntertainment1 {
    static String str, max = "", min = "";
    static String[] strs, maxsOfstrs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();strs = str.split(" ");
        maxsOfstrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            maxsOfstrs[i] = maxOfString(strs[i]);
        }
        sort();
        for (int i = 0; i < strs.length;i++ ) {
            max += strs[i];
            min += strs[(strs.length - 1) - i];
        }
        System.out.println(Integer.parseInt(max) + Integer.parseInt(min));
    }
    public static String maxOfString(String s) {
        int maxNum = 0;
        for (int i = 0; i < s.length(); i++) {
            maxNum = Math.max((int)s.charAt(i), maxNum) - 48;
        }
        return "" + maxNum;
    }
    public static void sort() {
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (maxsOfstrs[i].charAt(0) < maxsOfstrs[j].charAt(0)) {
                    String tmp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = tmp;
                    String tmp2 = maxsOfstrs[i];
                    maxsOfstrs[i] = maxsOfstrs[j];
                    maxsOfstrs[j] = tmp2;
                }
            }
        }
    }



}
