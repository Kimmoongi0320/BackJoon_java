import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();
        for(int i = 0 ; i < queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
        }
        long total = sum1 + sum2;

        
        if(total % 2 == 1) return -1;
        int t = queue1.length*3;
        while(t-- > 0){
            if(sum1 == total/2) return answer;
            
            if(sum1 > total/2){
                long num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
                answer++;
            }else if(sum2 > total/2){
                long num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
                answer++;
            }
        }
        
        return -1;
    }
}