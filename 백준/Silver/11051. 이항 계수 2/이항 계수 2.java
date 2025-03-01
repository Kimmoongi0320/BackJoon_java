import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][n+1];
        if (k == 1){
            System.out.print(n);
            return;
        }
        if (k==0){
            System.out.print(1);
            return;
        }
        for (int i = 1; i < n+1; i ++){
            for (int j =1; j < i+1; j++){
                if (j == 1 || j == i-1) dp[i][j] = i;
                else if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i =2; i < n+1; i++){
            for (int j = 1; j < i+1;j++){
                if (i == n && j == k){
                    System.out.print(dp[i-1][j-1]%10007);
                    return;
                }
                if (dp[i][j] == 0) dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
                else {
                    dp[i][j] = (dp[i][j] + dp[i-1][j])%10007;
                }
            }
        }


    }

}
