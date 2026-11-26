import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    static int m,n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for(int i = 0; i < n; i++){
            if(board[0][i] == 0 && !visited[0][i]){
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{0,i});
                visited[0][i] = true;

                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for(int[] move : moves){
                        int nx = x + move[0];
                        int ny = y + move[1];

                        if(inRange(nx,ny) && !visited[nx][ny] && board[nx][ny] == 0){
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }

        boolean possible = false;
        for(int i= 0; i < n; i++){
            if(board[m-1][i] == 0 && visited[m-1][i]){
                possible = true;
                break;
            }
        }

        if(possible) System.out.println("YES");
        else System.out.println("NO");

    }
    static boolean inRange(int x, int y){
        if(x < 0|| y < 0 || x >= m || y >= n) return false;
        return true;
    }


}