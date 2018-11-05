import java.io.*;
import java.util.*;

public class B2339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StoneBoard stoneBoard = new StoneBoard(n);
        for (int i = 0; i < n; i++) {
            stoneBoard.setLine(i, br.readLine().split(" "));
        }
        int ans = 0;
        ans += stoneBoard.cutBoard(false, new Point(0, 0), new Point(n - 1, n - 1));
        ans += stoneBoard.cutBoard(true, new Point(0, 0), new Point(n - 1, n - 1));
        bw.write((ans == 0 ? -1 : ans) + "\n");
        bw.flush();
        bw.close();
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class StoneBoard {
    int map[][];
    int size;

    public StoneBoard(int n) {
        this.size = n;
        map = new int[n][n];
    }

    public void setLine(int i, String[] strs) {
        for (int j = 0; j < size; j++) {
            map[i][j] = Integer.parseInt(strs[j]);
        }
    }

    public int cutBoard(boolean wasRow, Point s, Point e) {

        /*
        현재 영역의 상태를 조사해서
        만약 보석이 없으면 0을 리턴하고
        보석이 하나있고, 불순물이 없으면 1
        불순물이 없으면 0을 리턴한다.
        */
        Status status = getStatus(s, e);
        if (status.jewelry == 0) return 0;
        else if (status.jewelry == 1 && status.impurity == 0) return 1;
        else if (status.impurity == 0) return 0;

        /*
        불순물이 0보다 큰 경우 아직 나눌 경우가 있다는 것이다.
        현재 영역에서 불순물을 기준으로
        */
        int cnt = 0;
        for (Point im : status.impurities) {
            if (wasRow) {
                Status st = getStatus(new Point(s.x, im.y), new Point(e.x, im.y));
                /*
                세로로 자를 곳의 상태를 본다.
                자를 곳에 보석이 있거나 둘의 차이가 1보다 작은 경우 넘어간다.
                */
                if (st.jewelry > 0 || im.y - s.y < 1 || e.y - im.y < 1) continue;
                /*
                자른다. 그리고 나뉜 두 경우를 곱한다. 곱하는 이유는 만약 한 경우가 0 이고 한 경우가 1이 나왔다면?
                그 경우는 쓸 수 없다. 0 답도 0이어야한다.
                만약 나뉜 모든 경우가 1인 경우만 1가지 경우로 측정된다.
                영역의 모든 불순물에 대해서 하므로 그 값들을 더한다.
                */
                cnt += cutBoard(false, s, new Point(e.x, im.y - 1)) *
                        cutBoard(false, new Point(s.x, im.y + 1), e);
            } else {
                Status st = getStatus(new Point(im.x, s.y), new Point(im.x, e.y));
                if (st.jewelry > 0 || im.x - s.x < 1 || e.x - im.x < 1) continue;
                cnt += cutBoard(true, s, new Point(im.x - 1, e.y)) *
                        cutBoard(true, new Point(im.x + 1, s.y), e);
            }
        }
        return cnt;
    }

    public Status getStatus(Point s, Point e) {
        int jewelry = 0, impurity = 0;
        List<Point> impurities = new ArrayList<>();
        for (int i = s.x; i <= e.x; i++) {
            for (int j = s.y; j <= e.y; j++) {
                jewelry += (map[i][j] == 2) ? 1 : 0;
                impurity += (map[i][j] == 1) ? 1 : 0;
                if (map[i][j] == 1) impurities.add(new Point(i, j));
            }
        }
        return new Status(jewelry, impurity, impurities);
    }

    private static class Status {
        int jewelry, impurity;
        List<Point> impurities;

        public Status(int jewelry, int impurity, List<Point> impurities) {
            this.jewelry = jewelry;
            this.impurity = impurity;
            this.impurities = impurities;
        }
    }

}
