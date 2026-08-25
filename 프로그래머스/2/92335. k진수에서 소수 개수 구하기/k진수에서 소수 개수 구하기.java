import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;        
        String convertNum = convert(n,k);
        int length = convertNum.length();
        Queue<Character> queue = new LinkedList<>();
        
        for(int i = 0; i < length; i++){
            char cur = convertNum.charAt(i);
            if(cur == '0'){
                StringBuilder sb = new StringBuilder();
                while(!queue.isEmpty()){
                    sb.append(queue.poll());
                }
                if(isPrime(sb.toString())) answer++;
                
            }else if(i == length-1){
                StringBuilder sb = new StringBuilder();
                queue.add(convertNum.charAt(i));
                while(!queue.isEmpty()){
                    sb.append(queue.poll());
                }
                if(isPrime(sb.toString())) answer++;
            }else{
                queue.add(convertNum.charAt(i));
            }
        }
        
        return answer;
        
    }
    public String convert(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%k);
            n = n/k;
        }
        return sb.reverse().toString();
    }
    
    public boolean isPrime(String strnum){
        if(strnum.isEmpty()) return false;
    
        long num = Long.parseLong(strnum);
        if(num < 2) return false;
        for(long i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}