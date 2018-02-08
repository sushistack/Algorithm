import java.io.*;

public class B11723 {
    static long status = 0;
    static int n;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            if (ins.length == 2) {
                int m = Integer.parseInt(ins[1]);
                switch (ins[0]) {
                    case "add" : status |= (1 << m); break;
                    case "remove" : status &= ~(1 << m); break;
                    case "check" : sb.append(((status & (1 << m)) == 0) ? 0 : 1);sb.append("\n"); break;
                    case "toggle" :
                        if ((status & (1 << m)) == 0) status |= (1 << m);
                        else status &= ~(1 << m);break;
                }
            }else {
                if (ins[0].equals("all")) status |= (1 << 21) - 1;
                else status &= 0;
            }
        }
        bw.write(sb.toString());bw.flush();bw.close();
    }

}
