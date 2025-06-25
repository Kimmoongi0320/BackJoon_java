import java.awt.*;
import  java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < n+1 ; i++){
            String line = br.readLine();
            for (int j = 1; j < m+1; j++){
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
            }
        }

        for (int i =1; i < n+1; i++){
            for (int j =1 ; j< m+1; j++){
                if (board[i][j] == 0) dp[i][j] = 0;
                else {
                    dp[i][j] = Integer.min(Integer.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < n+1; i++){
            int maxNum = Arrays.stream(dp[i]).max().getAsInt();
            if (answer < maxNum) answer = maxNum;
        }

        System.out.println(answer*answer);

    }


}
