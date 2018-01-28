import java.io.*;

public class CF230B {
    static int n;
    static String ins[];
    static StringBuffer sb = new StringBuffer();
    static boolean[] isTPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        initTPrime();
        for (int i = 0; i < n; i++) {
            long t = Long.parseLong(ins[i]);
            sb.append((t % Math.sqrt(t) == 0 && !isTPrime[(int)Math.sqrt(t)]) ? "YES\n" : "NO\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static void initTPrime() {
        isTPrime[0] = true;
        isTPrime[1] = true;
        for(int i = 2 ; i < 1000001 ; i++){
            for(int j = (i << 1) ; j < 1000001 ; j += i){
                isTPrime[j] = true;
            }

        }
    }
}
