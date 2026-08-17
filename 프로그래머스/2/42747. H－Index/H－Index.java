import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        for (int h = n; h >= 0; h--) {
            int count = 0;
            for (int c : citations) {
                if (c >= h) count++;
            }
            if (count >= h) return h;
        }
        return 0;
    }
}