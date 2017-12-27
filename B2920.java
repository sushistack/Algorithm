import java.io.*;

public class B2920 {
    static String in, ins[];
    static int[] numbers = new int[8];
    static boolean isAscend, isDescend;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();ins = in.split(" ");
        for (int i = 0; i < ins.length; i++) {
            numbers[i] = Integer.parseInt(ins[i]);
        }
        isAscend = true; isDescend = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                isAscend = false; break;
            }
        }
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                isDescend = false; break;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (isAscend) {
            sb.append("ascending\n");
        }else if(isDescend) {
            sb.append("descending\n");
        }else {
            sb.append("mixed\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
