import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[] board;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        board = new int[n];
        dp = new int[n];
        for (int i =0; i < n; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,-1);
        dp[0] = 1;

        for (int i = 1; i<n;i++){
            int current = board[i];
            for (int j = 0; j < i;j++){
                if (board[j] > current && dp[j] >= dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            if (dp[i] == -1) dp[i] = 1;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());


    }

}
