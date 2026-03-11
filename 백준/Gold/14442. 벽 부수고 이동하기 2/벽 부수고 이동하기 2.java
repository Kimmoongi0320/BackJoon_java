import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][][]dp = new int[n+1][m+1][k+1];

        int[][] map = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            String line = br.readLine();
            for(int j=1;j<=m;j++){
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
            }
        }

        for(int i = 1; i <n+1; i++){
            for(int j = 1; j < m+1; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1,1,0});
        dp[1][1][0] = 1;

        int answer = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0],y = cur[1];
            int breakCount = cur[2];
            if(x == n && y == m){
                answer = dp[n][m][breakCount];
                break;
            }

            for(int[] move: moves){
                int nx = cur[0]+move[0];
                int ny = cur[1]+move[1];
                if(!inMap(map, nx, ny)) continue;

                // 벽 안부수는 경우
                if(dp[nx][ny][breakCount] > dp[x][y][breakCount] +1 && map[nx][ny] != 1){
                    dp[nx][ny][breakCount] = dp[x][y][breakCount] + 1;
                    queue.add(new int[] {nx,ny,breakCount});
                }
                //벽 부수는 경우
                if(breakCount < k){
                    if (dp[nx][ny][breakCount+1] > dp[x][y][breakCount] +1 && map[nx][ny] == 1){
                        dp[nx][ny][breakCount+1] = dp[x][y][breakCount] + 1;
                        queue.add(new int[] {nx,ny,breakCount+1});
                    }
                }
            }
        }

        if(answer == 0){
            System.out.print(-1);
        }else{
            System.out.print(answer);
        }
    }

    static boolean inMap(int[][] map, int x, int y){
        return x > 0 && y > 0 && x < map.length && y < map[0].length;
    }
}