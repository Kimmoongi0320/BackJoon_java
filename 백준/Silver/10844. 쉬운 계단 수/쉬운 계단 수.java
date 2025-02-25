import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[101][10];
        if (n==1) {
            System.out.print(9);
            return;
        }
        for (int i =1;i < 10; i++){
            dp[1][i] = 1;
        }
        for (int i =2; i < n+1; i++){
            for (int j =0; j <10; j++){
                if (j == 0){
                    dp[i][j] = dp[i-1][1]%1000000000;
                }else if (j == 9){
                    dp[i][j] = dp[i-1][8]%1000000000;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% 1000000000;
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++){
            answer += dp[n][i];
        }

        System.out.print(answer%1000000000);

    }

}
