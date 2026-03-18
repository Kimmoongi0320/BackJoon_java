import java.util.*;
import java.io.*;

public class Main {
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] board;
    static int[][][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        count = new int[n+1][m+1][k+1];
        for(int i = 1; i < n+1; i++){
            String line = br.readLine();
            for(int j = 1 ; j < m+1; j++){
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
                Arrays.fill(count[i][j],Integer.MAX_VALUE);
            }
        }

        count[1][1][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1,1,0,0}); // 위치x,y , dist, 낮 = 0, 밤 = 1, 벽 부순 횟수

        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            int afternoon = cur[3];
            int breakCount = cur[4];

            if(x == n && y == m){
                answer = count[x][y][breakCount];
                break;
            }

            for(int[] move: moves){
                int nx = x+move[0];
                int ny = y+move[1];

                if(!inBoard(nx,ny)) continue;
                boolean cantBreak = false;
                if(afternoon == 0){ // 낮인 경우
                    if(board[nx][ny] == 1 && breakCount < k && dist+1 < count[nx][ny][breakCount+1]){
                        queue.add(new int[]{nx,ny,dist+1,1,breakCount+1});
                        count[nx][ny][breakCount+1] = dist+1;
                    }else if(board[nx][ny] == 0 && dist+1 < count[nx][ny][breakCount]){
                        queue.add(new int[]{nx,ny,dist+1,1,breakCount});
                        count[nx][ny][breakCount] = dist+1;
                    }
                }else{//밤인 경우
                    if(board[nx][ny] == 1){
                        cantBreak = true;
                    }else{
                        if(dist+1 < count[nx][ny][breakCount]){
                            queue.add(new int[]{nx,ny,dist+1,0,breakCount});
                            count[nx][ny][breakCount] = dist+1;
                        }
                    }
                }
                if(cantBreak){
                    queue.add(new int[]{x,y,dist+1,0,breakCount});
                }
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }

    static boolean inBoard(int x, int y){
        return x>=1 && y >=1 && x < board.length && y < board[0].length;
    }
}