import java.io.*;

public class CFR471B {
    static String in;
    static int[] a = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        for (int i = 0; i < in.length(); i++) a[in.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] > 0) count++;
        }

        if(count == 1 || count > 4) sb.append("No\n");
        else {
            if(count == 3 || count == 4) sb.append("Yes\n");
            else {
                boolean flag = false;
                for(int i = 0; i < a.length; i++){
                    if(a[i] == 1){
                        sb.append("No\n");
                        flag = true;break;
                    }
                }
                if (!flag) sb.append("Yes\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
