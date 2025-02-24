import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];
        for (int i = 1; i <n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i-1][j] = num;
            }
        }
        dp[0][0] = board[0][0];

        for (int i = 1; i <n; i++){
            for (int j = 0; j <= i; j++){
                if (j==0){
                    dp[i][j] = dp[i-1][j] + board[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + board[i][j];
                }else {
                    dp[i][j] = Integer.max(dp[i-1][j-1],dp[i-1][j]) + board[i][j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++){
            if (dp[n-1][i] > max) max = dp[n-1][i];
        }

        System.out.print(max);
    }

}
