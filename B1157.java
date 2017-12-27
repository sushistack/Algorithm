import java.io.*;

public class B1157 {
    static String in;
    static int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine().toLowerCase();
        for (int i = 0; i < in.length(); i++) {
            alphabet[in.charAt(i) - 97]++;
        }
        int max = 0, count = 0, maxIdx = -1;
        for (int i = 0; i < alphabet.length; i++) {
            if (max < alphabet[i]) {
                max = alphabet[i];
                maxIdx = i;
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            count += (max == alphabet[i]) ? 1 : 0;
            if (count == 2) break;
        }
        bw.write((count < 2) ? (char)(maxIdx + 65) + "\n" : "?\n");
        bw.flush();bw.close();
    }
}
