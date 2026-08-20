import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i] ){// stack이 비어있거나 가격이 떨어진경우
                int idx = stack.pop();
                answer[idx] = i-idx;
            }
            stack.add(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = n-1-idx;
        }
        return answer;
    }
}