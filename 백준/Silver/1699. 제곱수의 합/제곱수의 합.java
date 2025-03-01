import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[] board;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 1;


        for (int i = 2; i < n+1; i++){
            dp[i] = i;
            for (int j = 1; j*j <= i; j++){
                if (dp[i] > dp[i-j*j] + 1) dp[i] = dp[i-j*j] + 1;
            }
        }
        System.out.println(dp[n]);


    }

}
