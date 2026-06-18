import java.util.*;
class Solution {
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        
        String[][] board = new String[n+2][m+2];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                board[i][j] = String.valueOf(storage[i-1].charAt(j-1));
            }
        }
        
        for(String request : requests){
            if(request.length() == 1){
                Queue<int[]> queue = new LinkedList<>();
                boolean[][] visited = new boolean[n+2][m+2];
                visited[0][0] = true;
                queue.add(new int[]{0,0});
                
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    
                    for(int[] move: moves){
                        int nx = x + move[0];
                        int ny = y + move[1];
                        if(nx < 0 || ny < 0 || nx > n+1 || ny > m+1) continue;
                        if(!visited[nx][ny]){
                            if(board[nx][ny] == null){
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx,ny});
                            }else{
                                if(board[nx][ny].equals(request)){
                                    board[nx][ny] = null;
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }else{
                String word = String.valueOf(request.charAt(0));
                for(int i = 1; i < n+1; i++){
                    for(int j = 1; j < m+1; j++){
                        if(board[i][j] != null &&board[i][j].equals(word)){
                            board[i][j] = null;
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(board[i][j] != null) answer++;
            }
        }
        return answer;
    }
}