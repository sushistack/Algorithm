import java.io.*;

public class WB3 {
    static int n, v = 0, ans = 0, x1, y1, x2, y2;
    static Rect[] r = new Rect[3];
    static String ins[], in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        for (int i = 0; i < ins.length; i += 4) {
            x1 = Integer.parseInt(ins[i]);
            y1 = Integer.parseInt(ins[i + 1]);
            x2 = Integer.parseInt(ins[i + 2]);
            y2 = Integer.parseInt(ins[i + 3]);
            r[i / 4] = new Rect(x1, y1, x2, y2);
            if (i == 0) ans = r[i].getArea();
        }
        ans -= overlappedArea(r[0], r[1]);
        ans -= overlappedArea(r[0], r[2]);
        ans += overlappedArea(r[0], r[1], r[2]);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    private static int overlappedArea(Rect r1, Rect r2) {
        Rect o = new Rect(Math.max(r1.x1, r2.x1), Math.max(r1.y1, r2.y1), Math.min(r1.x2, r2.x2), Math.min(r2.y2, r2.y2));
        return o.getArea();
    }

    private static Rect overlappedRect(Rect r1, Rect r2) {
        return new Rect(Math.max(r1.x1, r2.x1), Math.max(r1.y1, r2.y1), Math.min(r1.x2, r2.x2), Math.min(r2.y2, r2.y2));
    }

    private static int overlappedArea(Rect r1, Rect r2, Rect r3) {
        return overlappedArea(overlappedRect(r1, r2), overlappedRect(r1, r3));
    }

    private static class Rect {
        int x1, y1, x2, y2;
        public Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;this.y1 = y1;this.x2 = x2;this.y2 = y2;
        }

        public int getArea() {
            return (x2 - x1) * (y2 - y1);
        }
    }
}
