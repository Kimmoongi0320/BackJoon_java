import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        for(long num: numbers){
            String binary = convertBinary(num);
            char[] binaryArray = binary.toCharArray();
            
            boolean changed = false;
            for(int i = binary.length()-1; i >= 0; i--){
                if(binaryArray[i] == '0'){
                    if(i == binary.length()-1){
                        binaryArray[i] = '1';
                        answer[idx] =  convertNum(binaryArray);
                        changed = true;
                        break;
                    }else{
                        binaryArray[i] = '1';
                        binaryArray[i+1] = '0';
                        answer[idx] =  convertNum(binaryArray);
                        changed = true;
                        break;
                    }
                }
            }
            if(!changed){
                binaryArray[0] = '0';
                answer[idx] = convertNum(binaryArray) + (long)Math.pow(2,binaryArray.length);   
            }
            idx++;
        }
        return answer;
    }
    public String convertBinary(long num){
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "0";
        while(num > 0){
            sb.append(num % 2);
            num = num / 2;
        }
        
        return sb.reverse().toString();
    }
    
    public long convertNum(char[] binaryArray){
        long result = 0;
        for(int i = 0; i < binaryArray.length; i++){
            int num = Integer.parseInt(String.valueOf(binaryArray[i]));
            if(num == 0) continue;
            result += (long) Math.pow(2,binaryArray.length-1-i) * num;
        }
        return result;
    }
}