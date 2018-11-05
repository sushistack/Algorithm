import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class TMONServerSide {
    static int t = 0, s = 21, loadCapacity = 500, returnTime = 200 * 60, loadGoods = 50, idleTime = 10 * 60;
    static int increaseCapacity = 50, increaseReturnTime = 30 * 60;
    static long box;
    static int minutes = 180 * 24 * 60;                         // 한달을 30일이라고 가정
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Long> data = new ArrayList<>();
        while (t++ < s) {
            Ship sh[] = new Ship[t], loading = null;
            Queue<Ship> q = new LinkedList<>();
            ArrayList<Ship> driving = new ArrayList<>();
            boolean isAvailablePort = true;
            box = 0;
            for (int i = 0; i < t; i++) {
                q.offer(sh[i] = new Ship(loadCapacity, 0, returnTime, 120,
                        200 * 60, 0));
            }
            int m = 0;
            while ((m += 10) < minutes) {
                // 시설이 사용가능하며, 기다리는 선박이 있다면
                if (isAvailablePort && !q.isEmpty()) {
                    if (q.peek().getIdleTime() > 0) continue;
                    loading = q.poll();
                    loading.setLoading(true);
                    isAvailablePort = false;
                }
                // 적재
                if (loading != null) {
                    load(loading);          //goods load in ship
                    // 적재량을 채웠다면 운송 시작
                    if (loading.getCurCapacity() >= loading.getLoadCapacity()) {
                        loading.setCurCapacity(loading.getLoadCapacity());
                        loading.setLoading(false);
                        loading.setDriving(true);
                        driving.add(loading);
                        isAvailablePort = true;
                        loading = null;
                    }
                }

                if (driving.isEmpty()) continue;
                // service
                operation(driving, q);

            }
            data.add(box);

        }
        StringBuilder sb = new StringBuilder("{\"data\": [");

        for (int i = 1; i < data.size(); i++) {
            sb.append("{\"" + i + "척\" : ");
            sb.append("\"" + data.get(i - 1) + "개\"}");
            if (i < data.size() - 1) sb.append(", ");
        }
        sb.append("]}");
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void load(Ship l) {
        l.setCurCapacity(l.getCurCapacity() + loadGoods);
    }

    private static void operation(ArrayList<Ship> l, Queue<Ship> q) {
        for (int i = 0; i < l.size(); i++) {
            Ship sh = l.get(i);
            sh.setTimeToNextPlace(sh.getTimeToNextPlace() - 10);            // 10분 감소
            sh.setCurReturnTime(sh.getCurReturnTime() - 10);                // 남은 복귀 시간 감소
            if (sh.getTimeToNextPlace() == 0) {                             // 다음 지역에 도착
                box += 10;

                /*
                * 다음 지역을 가는 시간 보다 남은 복귀 시간이 적은 경우 복귀
                * 바로 queue에 넣음
                * 복귀를 안해도 되는 경우는 다음 지역으로 이동
                * */

                if ((sh.getPlace() + 1) * 60 > sh.getCurReturnTime()) { // 복귀
                    q.offer(new Ship(sh.getLoadCapacity() + increaseCapacity,
                            sh.getCurCapacity(),sh.getReturnTime() + increaseReturnTime,
                            120, sh.getReturnTime() + increaseReturnTime, idleTime));
                    sh.setDelete(true);


                }else { //복귀 X
                    sh.setTimeToNextPlace((sh.getPlace() + 1) * 60);
                }
            }
        }
        // 복귀 시킨다. java 8 이상에서 작동 가능
        Predicate<Ship> predicate = s-> s.isDelete();
        l.removeIf(predicate);

    }

    private static class Ship {
        int loadCapacity, curCapacity, curReturnTime;
        int returnTime, timeToNextPlace;
        int idleTime, place;
        boolean isLoading, isDriving, isFirstPlace;
        boolean delete;


        Ship(int loadCapacity, int curCapacity, int curReturnTime, int timeToNextPlace, int returnTime, int idleTime) {
            this.loadCapacity = loadCapacity; this.curCapacity = curCapacity;
            this.curReturnTime = curReturnTime; this.timeToNextPlace = timeToNextPlace;
            this.isLoading = false; this.isDriving = false;this.idleTime = idleTime; isFirstPlace = true;
            this.place = 0;this.returnTime = returnTime;
            this.delete = false;
        }

        public int getLoadCapacity() { return loadCapacity; }

        public void setLoadCapacity(int loadCapacity) { this.loadCapacity = loadCapacity; }

        public int getCurCapacity() { return curCapacity; }

        public void setCurCapacity(int curCapacity) { this.curCapacity = curCapacity; }

        public int getReturnTime() { return returnTime; }

        public void setReturnTime(int returnTime) { this.returnTime = returnTime; }

        public int getTimeToNextPlace() { return timeToNextPlace; }

        public void setTimeToNextPlace(int curDeliverPlace) { this.timeToNextPlace = curDeliverPlace; }

        public boolean isLoading() { return isLoading; }

        public void setLoading(boolean loading) { isLoading = loading; }

        public boolean isDriving() { return isDriving; }

        public void setDriving(boolean driving) { isDriving = driving; }

        public int getIdleTime() { return idleTime; }

        public void setIdleTime(int idleTime) { this.idleTime = idleTime; }

        public boolean isFirstPlace() { return isFirstPlace; }

        public void setFirstPlace(boolean firstPlace) { isFirstPlace = firstPlace; }

        public int getPlace() { return place; }

        public void setPlace(int place) { this.place = place; }

        public int getCurReturnTime() { return curReturnTime; }

        public void setCurReturnTime(int curReturnTime) { this.curReturnTime = curReturnTime; }

        public boolean isDelete() { return delete; }

        public void setDelete(boolean delete) { this.delete = delete; }
    }
}

