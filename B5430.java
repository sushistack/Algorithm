import java.io.*;
import java.util.ArrayList;

public class B5430 {
    static int T, N;
    static String ins[], in;
    static ArrayList<Boolean> isR = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean reverse, isError;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            in = br.readLine();isR.clear();
            for (int i = 0; i < in.length(); i++) {
                isR.add(in.charAt(i) == 'R');
            }
            N = Integer.parseInt(br.readLine());
            in = br.readLine();list.clear();
            String s = in.replace("[", "");
            in = s.replace("]", "");
            ins = in.split(",");isError = false;
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(ins[i]));
            }
            reverse = false;
            for (int i = 0; i < isR.size(); i++) {
                if (isR.get(i)) reverse = !reverse;
                else {
                    if (!list.isEmpty())
                        delete(reverse);
                    else{
                        isError = true; break;
                    }
                }
            }
            bw.write((isError) ? "error\n" : print(reverse) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void delete(boolean r) {
        if (r) list.remove(list.size() - 1);
        else list.remove(0);
    }

    public static String print(boolean r) {
        StringBuffer sb = new StringBuffer("[");
        if (r) {
            for (int i = list.size() - 1; i > -1; i--) {
                sb.append((i > 0) ? list.get(i) + "," : list.get(i));
            }
        }else {
            for (int i = 0; i < list.size(); i++) {
                sb.append((i < list.size() - 1) ? list.get(i) + "," : list.get(i));
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
