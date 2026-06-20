import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->a[1]-b[1]);
        
        int endTime = 0;
        for(int[] target: targets){
            int start = target[0];
            int end = target[1];
            
            if(endTime <= start){
                answer++;
                endTime = end;
            }
            
        }
        return answer;
    }
}