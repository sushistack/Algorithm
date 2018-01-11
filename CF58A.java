import java.io.*;

public class CF58A {
    static String in;
    static byte[] hello = new byte[5];
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        for (int i = 0; i < in.length(); i++) {
            switch (in.charAt(i)) {
                case 'h': hello[0] = 1; break;
                case 'e': if (hello[0] == 1) hello[1] = 1; break;
                case 'l':
                    if (hello[1] == 1) {
                        if (hello[2] == 1) hello[3] = 1;
                        else hello[2] = 1;
                    }break;
                case 'o': if (hello[3] == 1) hello[4] = 1;break;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (hello[i] != 1) { flag = false;break; }
        }
        bw.write(((flag) ? "YES" : "NO") + "\n");
        bw.flush();bw.close();
    }
}
