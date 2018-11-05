import java.io.*;

public class CFR466B {
    static long n, k, a, b;
    static long ans = 0, cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());
        a = Long.parseLong(br.readLine());
        b = Long.parseLong(br.readLine());
        cur = n;
        while (cur > 1) {
            long remain = cur % k;
            cur -= remain;
            ans += remain * a;
            if (cur > 1 && (cur - cur / k) * a > b){
                cur /= k;
                ans += b;
            }else{
                ans += (cur - 1) * a;
                cur = 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
    
}
