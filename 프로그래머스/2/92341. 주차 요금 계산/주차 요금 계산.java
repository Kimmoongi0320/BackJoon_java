import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Queue<String>> map = new HashMap<>();
        
        for(String record: records){
            String time = record.substring(0,5);
            String car = record.substring(6,10);
            
            map.putIfAbsent(car, new LinkedList<String>());
            map.get(car).add(time);
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        int[] answer = new int[map.size()];
        
        int idx = 0;
        for(String key: keys){
            Queue<String> times = map.get(key);
            int sum = calculateMoney(times);
            System.out.println(sum+" 분 "+key +" 차 번호");
            if(sum <= fees[0]){
                answer[idx] = fees[1];
            }else{
                int totalMinute = (int) Math.ceil((double)(sum-fees[0])/fees[2]);
                int result = fees[1] + totalMinute * fees[3];
                answer[idx] = result;
            }
            idx++;
        }
        return answer;
    }
    
    public int transferMin(String record){
        int hour = Integer.parseInt(record.substring(0,2));
        int min = Integer.parseInt(record.substring(3,5));
        
        return  hour*60+min;
    }
    public int calculateMoney(Queue<String> times){
        int sum = 0;
        while(!times.isEmpty()){
            String start = times.poll();
            int startMinute = transferMin(start);
            
            int endMinute;
            if(!times.isEmpty()){
                String end = times.poll();
                endMinute = transferMin(end);
            }else{
                endMinute = 1439;
            }
            sum += (endMinute - startMinute);
        }
        return sum;
    }
}