import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        Map<Integer, Long> map = new HashMap<>();

        for (int w : weights) {

            // 1 : 1
            answer += map.getOrDefault(w, 0L);

            // 2 : 3
            if (w % 3 == 0) {
                answer += map.getOrDefault(w * 2 / 3, 0L);
            }

            // 1 : 2
            if (w % 2 == 0) {
                answer += map.getOrDefault(w / 2, 0L);
            }

            // 3 : 4
            if (w % 4 == 0) {
                answer += map.getOrDefault(w * 3 / 4, 0L);
            }

            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        return answer;
    }
}