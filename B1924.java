import java.io.*;

public class B1924 {
    static int x, y, month = 0;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        x = Integer.parseInt(in.split(" ")[0]);
        y = Integer.parseInt(in.split(" ")[1]);
        for (int i = 1; i < x; i++) {
            switch (i) {
                case 1: case 3: case 5: case 7:
                case 8: case 10: case 12:
                    month += 31;break;
                case 2: month += 28;break;
                case 4: case 6: case 9: case 11:
                    month += 30; break;
                default: break;
            }
        }
        int days = month + y - 1;
        switch (days % 7) {
            case 0: bw.write("MON");break;
            case 1: bw.write("TUE");break;
            case 2: bw.write("WED");break;
            case 3: bw.write("THU");break;
            case 4: bw.write("FRI");break;
            case 5: bw.write("SAT");break;
            case 6: bw.write("SUN");break;
        }
        bw.flush();bw.write("\n");bw.flush();
        bw.close();


    }
}
