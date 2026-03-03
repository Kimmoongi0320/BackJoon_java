import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int totalCheese = 0;
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m; j++){
                int cur =  Integer.parseInt(st.nextToken());
                if(cur == 1) totalCheese++;
                board[i][j] = cur;
            }
        }

        int time = 0;
        int beforeMelt = 0;
        while(totalCheese > 0){
            List<int[]> melt = new ArrayList<>();
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];

            queue.add(new int[]{0,0});
            visited[0][0] = true;

            int meltCount = 0;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int[] move : moves){
                    int nextX = cur[0] + move[0];
                    int nextY = cur[1] + move[1];

                    if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                    if (visited[nextX][nextY]) continue;

                    if(board[nextX][nextY] == 0){
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }else{
                        meltCount++;
                        melt.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }

            totalCheese -= meltCount;
            beforeMelt = meltCount;
            time++;
            for(int[] meltPoint : melt){
                board[meltPoint[0]][meltPoint[1]] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append("\n").append(beforeMelt);
        System.out.print(sb);

    }
}