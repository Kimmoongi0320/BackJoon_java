class Solution {
    static int answer = 0;
    static int length;
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        DFS(-1, 0, target, numbers);
        return answer;
    }
    
    public static void DFS(int idx, int sum, int target,int[] numbers){
        if(idx == length-1){
            if (sum == target) answer++;
            return;
        }
        
        int nextNum = numbers[idx+1];
        DFS(idx+1, sum+nextNum, target, numbers);
        DFS(idx+1, sum-nextNum, target, numbers);
    }
}