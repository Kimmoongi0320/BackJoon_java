import java.util.*;
import java.io.*;

public class Main {
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int blackCount = 0;
        int[][] board = new int[n][n];
        for(int i = 0 ; i < n; i++){
            String line = br.readLine();
            for(int j = 0 ; j < n; j++){
                int cur = Integer.parseInt(String.valueOf(line.charAt(j)));
                board[i][j] = cur;

                if(cur == 0) blackCount++;
            }
        }

        int answer = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
        queue.add(new int[]{0,0,0}); // x,y,부순 횟수

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int breakCount = cur[2];

            if (x == n-1 && y == n-1){
                answer = Integer.min(answer,breakCount);
                continue;
            }

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for(int[] move: moves){
                int nx = x + move[0];
                int ny = y+ move[1];

                if(nx < 0 || ny < 0 || nx >=n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 0){
                    queue.add(new int[]{nx,ny,breakCount+1});
                }else{
                    queue.add(new int[]{nx,ny,breakCount});
                }
            }
        }

        System.out.print(answer);
    }

}