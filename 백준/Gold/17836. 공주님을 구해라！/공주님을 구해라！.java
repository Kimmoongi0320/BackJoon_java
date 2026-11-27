import java.io.*;
import java.util.*;

public class Main {
    static int n,m,t;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] visited = new boolean[n][m][2];
        Queue<int[]> queue= new ArrayDeque<>();
        queue.add(new int[]{0,0,0,0});
        visited[0][0][0] = true;

        int answer = -1;
        while(!queue.isEmpty()) {
            int[] cur=  queue.poll();
            int x =  cur[0];
            int y = cur[1];
            int dist =  cur[2];
            int weapon = cur[3];

            if(x == n-1 && y == m-1) {
                answer = dist;
                break;
            }
            if(dist + 1 > t) continue;
            for(int[] move: moves){
                int nx = x+ move[0];
                int ny = y + move[1];
                if(inRange(nx,ny) && board[nx][ny] != 1 && !visited[nx][ny][weapon]) {
                    visited[nx][ny][weapon] = true;
                    if(board[nx][ny] == 2) queue.add(new int[]{nx,ny,dist+1,1});
                    else queue.add(new int[]{nx,ny,dist+1,weapon});

                }
            }

            if(weapon == 1){
                for(int[] move: moves){
                    int nx = x+ move[0];
                    int ny = y + move[1];
                    if(inRange(nx,ny) && !visited[nx][ny][weapon]) {
                        visited[nx][ny][weapon] = true;
                        queue.add(new int[]{nx,ny,dist+1,weapon});
                    }
                }
            }
        }
        if(answer == -1) System.out.print("Fail");
        else System.out.print(answer);


    }

    static boolean inRange(int x, int y){
        if(x < 0 || y < 0 || x>= n || y >= m) return false;
        return true;
    }



}