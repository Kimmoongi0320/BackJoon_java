import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            char next = s.charAt(i);

            if(stack.size() != 0 && next == ')' && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(next);
            }            
        }
        
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}