import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n+1][m+1];
        board = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j =1 ; j < m+1; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작점
        dp[1][1] = board[1][1];
        for (int i = 2; i < m+1; i++){
            dp[1][i] = dp[1][i-1] + board[1][i];
        }
        for (int i = 2; i <n+1; i++){
            dp[i][1] = dp[i-1][1] + board[i][1];
        }

        for (int i = 2; i < n+1 ; i++){
            for (int j = 2; j < m+1; j++){
                dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]) + board[i][j];
            }
        }

        System.out.print(dp[n][m]);
    }

}
