import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        int cheeseCount = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                int cur  =  Integer.parseInt(st.nextToken());
                board[i][j] = cur;
                if(cur == 1){
                    cheeseCount++;
                }
            }
        }
        int answer = 0;
        while(cheeseCount>0){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true;
            int[][] touchedAir =  new int[n][m];

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                for(int[] move : moves){
                    int x = cur[0] + move[0];
                    int y = cur[1] + move[1];

                    if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) continue;
                    if(board[x][y] == 0 && !visited[x][y]){
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }else if(board[x][y] == 1){
                        touchedAir[x][y]++;
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(touchedAir[i][j] >= 2){
                        board[i][j] = 0;
                        cheeseCount--;
                    }
                }
            }
            answer++;
        }

        System.out.print(answer);


    }
}