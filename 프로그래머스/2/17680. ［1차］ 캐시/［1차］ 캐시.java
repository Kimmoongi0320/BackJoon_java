import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cach = new ArrayList<>();
        
        if(cacheSize == 0) return 5* cities.length;
        
        for(String rawCity: cities){
            String city = rawCity.toLowerCase();
            int idx = cach.indexOf(city);
            
            if(idx != -1){
                cach.remove(idx);
                cach.add(city);
                answer+=1;
            }else{
                if(cach.size() < cacheSize){
                    cach.add(city);
                }else{
                    cach.remove(0);
                    cach.add(city);
                }
                answer += 5;
            }
        }
        return answer;
    }
}