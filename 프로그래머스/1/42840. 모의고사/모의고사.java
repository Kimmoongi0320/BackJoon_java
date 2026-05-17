import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            for(int j = 0 ; j < 3; j++){
                int answer = answers[i];
                if(answer == patterns[j][i%patterns[j].length]){
                    score[j]++;
                }
            }
        }
        
        int maxCount = Arrays.stream(score).max().getAsInt();
        
        int answerCount = 0;
        for(int count: score){
            if(count == maxCount) answerCount++;
        }
        
        int[] answer = new int[answerCount];
        int idx = 0;
        for(int i = 0 ; i < 3; i++){
            if(score[i] == maxCount){
                answer[idx] = i+1;
                idx++;
            }
        }
        
        return answer;
    }
}