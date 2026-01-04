import java.util.*;
import java.io.*;

public class Main {

    static int[][] board;
    static int[][] dp;  
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y) {

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1; 

        for(int[] move : moves) {
            int nextX = x + move[0];
            int nextY = y + move[1];

            if (nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board.length
                    && board[nextX][nextY] > board[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(nextX, nextY));
            }
        }

        return dp[x][y];
    }
}