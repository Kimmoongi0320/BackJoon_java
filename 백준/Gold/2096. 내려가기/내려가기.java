import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][3];
        dp = new int[n][3][2];

        for (int i =0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j=0; j < 3; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                dp[i][j] = new int[] {num,num};
            }
        }

        for (int j = 1; j <n; j++){
            for (int i =0; i < 3; i++){
                if (i == 0){
                    dp[j][i][0] = Integer.max(dp[j-1][i][0]+board[j][i], dp[j-1][i+1][0]+board[j][i]);
                    dp[j][i][1] = Integer.min(dp[j-1][i][1]+board[j][i], dp[j-1][i+1][1]+board[j][i]);
                } else if (i==1) {
                    dp[j][i][0] = Integer.max(dp[j-1][i+1][0]+board[j][i],Integer.max(dp[j-1][i-1][0]+board[j][i], dp[j-1][i][0]+board[j][i]));
                    dp[j][i][1] = Integer.min(dp[j-1][i+1][1]+board[j][i],Integer.min(dp[j-1][i-1][1]+board[j][i], dp[j-1][i][1]+board[j][i]));
                }else{
                    dp[j][i][0] = Integer.max(dp[j-1][i][0]+board[j][i], dp[j-1][i-1][0]+board[j][i]);
                    dp[j][i][1] = Integer.min(dp[j-1][i][1]+board[j][i], dp[j-1][i-1][1]+board[j][i]);
                }

            }
        }
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i =0; i  <3; i++){
            if (max < dp[n-1][i][0]) max = dp[n-1][i][0];
            if (min > dp[n-1][i][1]) min = dp[n-1][i][1];
        }
        System.out.print(max+" "+min);


    }

}
