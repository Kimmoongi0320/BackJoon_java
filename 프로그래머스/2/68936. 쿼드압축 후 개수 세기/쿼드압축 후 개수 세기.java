class Solution {
    int[] answer = new int[2];
    int n;
    public int[] solution(int[][] arr) {
        n = arr.length;
        divide(n,0,0,arr);
        return answer;
    }
    
    public void divide(int size, int x, int y, int[][] arr){
        int start = arr[x][y];
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(start != arr[i][j]){
                    divide(size/2,x,y,arr);
                    divide(size/2,x+size/2,y,arr);
                    divide(size/2,x,y+size/2,arr);
                    divide(size/2,x+size/2,y+size/2,arr);
                    return;
                }
            }
        }
        answer[start] += 1;
    }
}