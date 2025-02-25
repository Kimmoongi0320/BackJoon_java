import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        int[] stair = new int[n+1];
        for (int i =1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int score = Integer.parseInt(st.nextToken());
            stair[i] = score;
        }
        if (n==1){
            System.out.print(stair[1]);
            return;
        } else if (n==2) {
            System.out.print(stair[1]+stair[2]);
            return;
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Integer.max(stair[1]+stair[3],stair[2]+stair[3]);

        for (int i = 4; i < n+1; i++){
            dp[i] = Integer.max(dp[i-3]+stair[i-1]+stair[i],dp[i-2]+stair[i]);
        }

        System.out.print(dp[n]);

    }

}
