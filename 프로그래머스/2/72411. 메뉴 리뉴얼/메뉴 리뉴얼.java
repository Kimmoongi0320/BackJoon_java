import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        for(int i = 0 ; i < orders.length;i++){
            String order = orders[i];
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            orders[i] = String.valueOf(orderArr);
        }
        
        List<String> answers = new ArrayList<>();
        for(int length: course){
            Map<String,Integer> counts = new HashMap<>();
            for(String order: orders){
                conbination(counts,length,0,"",order);
            }
            
            int max = 0;
            for(String key : counts.keySet()){
                int value = counts.get(key);
                max = Integer.max(max,value);
            }
            if(max < 2) continue;
            for(String key : counts.keySet()){
                int value = counts.get(key);
                if(value == max) answers.add(key);
            }
            
        }
        
        String[] answer = new String[answers.size()];
        Collections.sort(answers);
        
        for(int i = 0; i < answers.size(); i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }
    
    public void conbination(Map<String,Integer> counts, int length, int idx, String conbi, String order){
        if(length == conbi.length()){
            counts.put(conbi,counts.getOrDefault(conbi,0)+1);
            return;
        }
        
        if(length < conbi.length()) return;
        
        for(int i = idx; i < order.length(); i++){
            conbination(counts,length,i+1,conbi+order.charAt(i),order);
        }
    }
}