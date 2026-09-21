class Solution {
    int[][] directions = {{1,0},{0,1},{-1,-1}};
    public int[] solution(int n) {
        if(n == 1) return new int[]{1};
        
        int length = 0;
        for(int i = 1; i <=n; i++){
            length += i;
        }
        int[] answer = new int[length];
        
        int dir = 0;
        int x = 0, y = 0;
        int[][] board = new int[n][n];
        int num = 1;
        while(num < length){
            int[] direction = directions[dir];
            while(true){
                board[x][y] = num;
                num += 1;
                
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                
                if(nextX >= n || nextX <0 || nextY >= n || nextY < 0) {
                    num -=1;
                    break;
                };
                if(board[nextX][nextY] != 0){
                    num -=1;
                    break;
                }
                
                x = nextX;
                y = nextY;
            }
            dir = (dir+1) % 3;
        }
        
        int idx = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(board[i][j] == 0) board[i][j] = length;
                answer[idx++] = board[i][j];
            }
        }
        return answer;
    }
}