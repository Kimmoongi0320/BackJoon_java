import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = numbers[i] + "";
        }
        Arrays.sort(arr,(a,b)-> (b+a).compareTo(a+b));
        if(arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(String num: arr){
            sb.append(num);
        }
        return sb.toString();
    }
}