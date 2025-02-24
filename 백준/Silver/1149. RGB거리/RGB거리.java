import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dp = new int[num][3];
        board = new int[num][3];
        for (int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j< 3; j++){
                int cost = Integer.parseInt(st.nextToken());
                board[i][j] = cost;
            }
        }
        for (int i = 0; i < 3; i++){
            dp[0][i] = board[0][i];
        }

        for (int i = 1; i < num; i++){
            for(int j = 0 ; j < 3; j++){
                if (j == 0){
                    dp[i][j] = Integer.min(dp[i-1][1],dp[i-1][2]) + board[i][j];
                }else if (j == 1){
                    dp[i][j] = Integer.min(dp[i-1][0],dp[i-1][2]) + board[i][j];
                }else {
                    dp[i][j] = Integer.min(dp[i-1][1],dp[i-1][0]) + board[i][j];
                }
            }
        }
        System.out.print(Arrays.stream(dp[num-1]).min().getAsInt());
    }
}
