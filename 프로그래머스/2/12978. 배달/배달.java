import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] time = new int[N+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[1] = 0;
        
        int[][] bridge = new int[N+1][N+1];
        for(int i = 1; i < N+1; i++){
            Arrays.fill(bridge[i],Integer.MAX_VALUE);
        }
        
        for(int[] r: road){
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            
            bridge[from][to] = Integer.min(bridge[from][to],cost);
            bridge[to][from] = Integer.min(bridge[to][from],cost);
        };
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{1,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int city = cur[0];
            int cost = cur[1];
            
            if(cost > time[city]) continue; 
            
            for(int i = 1; i < N+1; i++){
                int nextCost = bridge[city][i];
                if(nextCost != Integer.MAX_VALUE && cost + nextCost < time[i]){
                    time[i] = cost + nextCost;
                    queue.add(new int[] {i,time[i]});
                }
            }
            
        }
        for(int i = 2; i < N+1; i++){
            if(time[i] <= K) {
                answer++;
            };
        };
        
        

        return answer+1;
    }
}