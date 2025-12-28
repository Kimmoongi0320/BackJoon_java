import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int block = cur[2];
            int length = cur[3];

            if(x == N-1 && y == M-1){
                System.out.println(length);
                return;
            }

            for(int[] move: moves){
                int nx = x + move[0];
                int ny = y + move[1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 빈 칸이고, 현재 block 상태로 방문 안 했으면
                if(board[nx][ny] == 0 && !visited[nx][ny][block]){
                    visited[nx][ny][block] = true;
                    queue.add(new int[]{nx, ny, block, length + 1});
                }
                // 벽이고, 아직 벽을 안 부쉈고, 부순 상태로 방문 안 했으면
                else if(board[nx][ny] == 1 && block == 0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, 1, length + 1});
                }
            }
        }

        System.out.println(-1);
    }
}