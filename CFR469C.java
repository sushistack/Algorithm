import java.io.*;
import java.util.TreeSet;

public class CFR469C {
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        TreeSet<Integer> zeros = new TreeSet<>();
        TreeSet<Integer> ones = new TreeSet<>();

        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '1')
                ones.add(i + 1);
            else
                zeros.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!zeros.isEmpty()) {
            StringBuilder zebra = new StringBuilder();
            int size = 0;
            Integer zeroPos = zeros.pollFirst();
            zebra.append(zeroPos);zebra.append(" ");
            size++;
            while (true) {
                Integer onePos = ones.higher(zeroPos);
                if (onePos == null) break;
                zeroPos = zeros.higher(onePos);
                if (zeroPos == null) break;
                zeros.remove(zeroPos);
                ones.remove(onePos);
                zebra.append(onePos);zebra.append(" ");
                zebra.append(zeroPos);zebra.append(" ");
                size += 2;
            }
            count++;
            sb.append(size);sb.append(" ");
            sb.append(zebra);sb.append("\n");
        }

        if (ones.size() > 0) bw.write("-1\n");
        else {
            sb.insert(0, count + "\n");
            bw.write(sb.toString());
        }
        bw.flush();bw.close();
    }

}
