import java.util.*;
class Solution {
    boolean[] checked;
    int n;
    Set<Integer> answers;
    public int solution(String numbers) {
        n = numbers.length();
        checked = new boolean[n];
        answers = new HashSet<>();
        
        for(int i = 0 ; i < n; i++){
            checked[i] = true;
            DFS(String.valueOf(numbers.charAt(i)),numbers);
            checked[i] = false;
        }
        int answer = answers.size();
        return answer;
    }
    
    public void DFS(String numStr,String numbers){
        int num = Integer.parseInt(numStr);
        if(isPrime(num)){
            answers.add(num);
        }
        
        for(int i = 0; i < n; i++){
            if(!checked[i]){
                checked[i] = true;
                DFS(numStr+String.valueOf(numbers.charAt(i)),numbers);
                checked[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num){
        if(num == 1 || num == 0) return false;
        if(num == 2) return true;
        
        for(int i = 2; i < Math.sqrt(num)+1; i++){
            if(num % i ==0) return false;
        }
        return true;
    }
}