import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[] dp;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        board = new int[n+1];
        dp = new int[n+1];
        for (int i =1; i < n+1;i ++){
            board[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = board[1];
        for (int i =2; i < n+1 ; i++){
            for (int j =0; j < i; j++){
                dp[i] = Integer.max(dp[i],dp[j]+board[i-j]);
            }
        }

        System.out.print(dp[n]);



    }

}
