import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String,Integer> dir = new HashMap<>();
        for(int i = 65; i < 91; i++){
            dir.put(String.valueOf((char) i), i-64);
        }
        
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while(idx < msg.length()-1){
            int length = 1;
            String cur = msg.substring(idx,idx+length);
            int value = dir.getOrDefault(cur,0);
            boolean finish = false;
            
            while(value != 0){
                length++;
                if(idx+length > msg.length()){
                    finish = true;
                    break;
                }
                cur = msg.substring(idx,idx+length);
                value = dir.getOrDefault(cur,0);
            }
            
            if(finish){
                answer.add(value);
                idx = msg.length();
            }else{
                dir.put(cur,dir.size()+1);
                answer.add(dir.get(cur.substring(0,cur.length()-1)));
                idx = idx+length-1;
            }
        }
        if(idx == msg.length()-1){
            answer.add(dir.get(msg.substring(idx,idx+1)));
        }
        
        
        int[] result = new int[answer.size()];
        
        for(int i = 0; i <  answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}