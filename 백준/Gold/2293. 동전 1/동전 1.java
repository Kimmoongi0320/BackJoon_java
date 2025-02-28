import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];
        int[] coins = new int[n];
        for (int i =0; i < n; i++){
            int coin = Integer.parseInt(br.readLine());
            coins[i] =coin;
        }

        for (int coin: coins){
            for (int i=1; i < k+1 ; i++){
                if (i == coin){
                    dp[i] = dp[i] + 1;
                } else if (i > coin) {
                    dp[i] = dp[i] + dp[i-coin];
                }
            }
        }
        System.out.print(dp[k]);




    }

}
