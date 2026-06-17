import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int time = 0 ; time < players.length; time++){
            int player = players[time];
            while(!queue.isEmpty() && queue.peek() <= time){
                queue.poll();
            }
            
            int need = player/m;
            int serverCount = queue.size();
            for(int i = 0; i < need - serverCount; i++){
                queue.add(time+k);
                answer++;
            }
        }
        return answer;
    }
}