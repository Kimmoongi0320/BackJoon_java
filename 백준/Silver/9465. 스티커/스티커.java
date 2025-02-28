import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Case = Integer.parseInt(br.readLine());
        for (int i =0; i < Case; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new int[2][n];
            board = new int[2][n];

            for (int j =0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int k = 0; k < n; k++){
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];

            for (int j =1; j < n; j++){
                for (int k = 0; k < 2; k++){
                    if (k == 0){
                        if (j<2){
                            dp[k][j] = dp[1][j-1]+board[k][j];
                        }else dp[k][j] = Integer.max(dp[1][j-1],dp[1][j-2])+board[k][j];
                    }else {
                        if (j<2){
                            dp[k][j] = dp[0][j-1]+board[k][j];
                        }else dp[k][j] = Integer.max(dp[0][j-1],dp[0][j-2])+board[k][j];
                    }
                }
            }
            System.out.println(Integer.max(dp[0][n-1],dp[1][n-1]));

        }




    }

}
