import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[][] costs = {{1,1,1},{5,1,1},{25,5,1}};
    public int solution(int[] picks, String[] minerals) {
        
        for(int i = 0; i < 3; i++){
            if(picks[i] > 0){
                picks[i]--;
                backtracking(picks,minerals,i,0,0);
                picks[i]++;
            }
        }
        return answer;
    }
    
    public static void backtracking(int[] picks, String[] minerals, int pickIdx, int mineralIdx, int cost){       
        int end = Integer.min(mineralIdx+5, minerals.length);
        for(int idx = mineralIdx; idx < end; idx++){
            String currentStone = minerals[idx];
            int stoneIdx = getStone(currentStone);
            cost += costs[pickIdx][stoneIdx];            
        }
        
        if(end == minerals.length || Arrays.stream(picks).max().getAsInt() == 0){
            answer = Integer.min(answer,cost);
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(picks[i] > 0){
                picks[i]--;
                backtracking(picks,minerals,i,end,cost);
                picks[i]++;
            }
        }
        
        
    }
    
    public static int getStone(String stoneName){
        if(stoneName.equals("diamond")) return 0;
        else if(stoneName.equals("iron")) return 1;
        else return 2;
    }
}