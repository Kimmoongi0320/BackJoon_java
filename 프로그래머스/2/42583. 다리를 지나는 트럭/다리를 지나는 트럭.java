import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] time = new int[truck_weights.length];
        int totalWeight = 0;
        
        int idx = 0;
        while(idx < truck_weights.length){
            if(totalWeight+truck_weights[idx] <= weight){
                totalWeight += truck_weights[idx];
                for(int i = 0 ; i <= idx; i++){
                    time[i] += 1;
                    if(time[i] == bridge_length){
                        totalWeight -= truck_weights[i];
                    }
                }
                answer++;
                idx++;
            }else{
                for(int i = 0 ; i < idx; i++){
                    if(time[i] < bridge_length){
                        int left = bridge_length - time[i];
                        for(int j = i ; j < idx; j++){
                            time[j] += left;
                        }
                        answer+= left;
                        totalWeight -= truck_weights[i];
                        break;
                    }
                }
            }
        }
        
        for(int i = truck_weights.length-1 ; i >=0 ; i--){
            if(time[i] < bridge_length){
                answer += (bridge_length - time[i]);
                break;
            }
        }
        return answer+1;
    }

}