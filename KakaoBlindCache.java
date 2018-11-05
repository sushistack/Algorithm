import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class KakaoBlindCache {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        String[] m = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        bw.write(s.solution(5, m) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        public int solution(int cacheSize, String[] cities) {
            Map<String, Integer> cache = new HashMap<>();
            int answer = 0;

            for (String s : cities) {
                s = s.toLowerCase();
                if (cache.containsKey(s)) {
                    answer++;
                    cache.put(s, 0);
                } else {
                    answer += 5;
                    if (cache.size() >= cacheSize) {
                        String lruIdx = "";
                        int max = 0;
                        for (String key : cache.keySet()) {
                            if (max < cache.get(key)) {
                                max = cache.get(key);
                                lruIdx = key;
                            }
                        }
                        cache.remove(lruIdx);
                    }
                    cache.put(s, 0);
                }
                for (String key : cache.keySet()) {
                    cache.put(key, cache.get(key) + 1);
                }
            }

            return answer;
        }
    }
}
