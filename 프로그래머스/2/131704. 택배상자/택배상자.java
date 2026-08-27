import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int box = 1; //컨베이너 위 박스
        for(int i = 0; i < order.length; i++){
            int size = order[i];// 넣어야할 박스 사이즈
            while(box != size){
                if(stack.isEmpty()){
                    stack.add(box);
                    box++;
                }else{
                    if(stack.peek() == size){
                        stack.pop();
                        answer++;
                        break;
                    }else{
                        if(size < box) return answer;
                        else{
                            stack.add(box);
                            box++;
                        }
                    }
                }
            }
            if(box == size){  
                answer++;
                box++;
}
        }
        return answer;
    }
}