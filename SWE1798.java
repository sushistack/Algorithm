import java.io.*;

public class SWE1798 {
    static int t, T, n, m;
    static String ins[];
    static int[][] times = new int[36][36];
    static Location[] l = new Location[36];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            m = Integer.parseInt(ins[1]);
            for (int i = 1; i < n; i++) {
                ins = br.readLine().split(" ");
                for (int j = 1; j < ins.length + 1; j++) {
                    times[i][i + j] = times[i + j][i] = Integer.parseInt(ins[j - 1]);
                }
            }
            for (int i = 1; i <= n; i++) {
                ins = br.readLine().split(" ");
                l[i] = (ins.length == 1) ? new Location(ins[0], 0, 0) :
                        new Location(ins[0], Integer.parseInt(ins[1]), Integer.parseInt(ins[2]));
            }

        }
    }



    private static class Location {
        String type;
        int playTime, satisfaction;
        Location(String type, int playTime, int satisfaction) {
            this.type = type;this.playTime = playTime;
            this.satisfaction = satisfaction;
        }
    }
}
