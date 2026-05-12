import java.util.*;

class Solution {
    static int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int solution(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        
        // oilList → int[] oilSize 배열로 교체 (인덱스로 바로 접근 O(1))
        int maxOils = land.length * land[0].length + 2;
        int[] oilSize = new int[maxOils];
        
        int idx = 2;
        
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    
                    int count = 0;
                    while(!queue.isEmpty()){
                        int[] curPos = queue.poll();
                        count++;
                        int x = curPos[0], y = curPos[1];
                        land[x][y] = idx;
                        
                        for(int[] move : moves){
                            int nx = x + move[0];
                            int ny = y + move[1];
                            if(nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) continue;
                            if(!visited[nx][ny] && land[nx][ny] == 1){
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    oilSize[idx] = count;  // ← 인덱스로 바로 저장
                    idx++;
                }
            }
        }
        
        int answer = 0;
        for(int pos = 0; pos < land[0].length; pos++){
            boolean[] used = new boolean[idx];
            int total = 0;
            for(int deep = 0; deep < land.length; deep++){
                int oilNum = land[deep][pos];
                if(oilNum >= 2 && !used[oilNum]){
                    total += oilSize[oilNum];  
                    used[oilNum] = true;
                }
            }
            answer = Math.max(answer, total);
        }
        return answer;
    }
}