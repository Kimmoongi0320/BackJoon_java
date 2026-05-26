import java.util.*;
class Solution {
    static int[] answer;
    static int highDiff = 0;
    static boolean changed = false;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        backTracking(info,n,0,new int[11]);
        if(!changed){
            answer = new int[]{-1};
        }
        return answer;
    }
    
    static void backTracking(int[] info, int lastShot, int idx, int[] shotCount){
        if(idx ==10){
            shotCount[10] = lastShot;
            
            int lionScore = 0;
            int apeachScore = 0;
            for(int i = 0; i <11; i++){
                if(info[i] < shotCount[i]){
                    lionScore += (10-i);
                }else{
                    if(info[i] > 0){
                        apeachScore += (10-i);
                    }
                }
            }
            if(lionScore > apeachScore){
                int diff = lionScore-apeachScore;
                if(diff > highDiff){
                    answer = shotCount.clone();
                    changed = true;
                    highDiff = diff;
                }else if(diff == highDiff){
                    for (int i = 10; i >= 0; i--) {
                        if (shotCount[i] > answer[i]) {
                            answer = shotCount.clone();
                            changed = true;
                            break;
                        } else if (shotCount[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
            return;
        }
        
        if(info[idx] < lastShot){
            shotCount[idx] = info[idx] + 1;
            backTracking(info,lastShot-(info[idx] + 1),idx+1,shotCount);
            shotCount[idx] = 0;
        }
        
        backTracking(info,lastShot,idx+1,shotCount);
    }
}