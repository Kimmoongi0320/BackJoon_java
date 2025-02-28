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
            int cost = Integer.parseInt(st.nextToken());
            board[i] = cost;
            dp[i] = cost;
        }

        for (int i = 1; i < n; i++){
            int current = board[i];
            int max = -1;
            for (int j =0; j < i; j++){
                if (board[j] < current && dp[j] > max){
                    max = dp[j];
                }
            }
            if (max == -1) continue;
            dp[i] = max+current;

        }

        System.out.print(Arrays.stream(dp).max().getAsInt());


    }

}
