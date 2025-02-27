import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        int[][] dp =new int[n+1][n+1];

        for (int i =0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //누적합 배열 생성
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < n+1; j++){
                //누적합 배열 해당 위치 값
                dp[i][j] = board[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];            }
        }

        for (int i =0 ; i< m; i++){
            st  = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            System.out.println(dp[x2+1][y2+1] - dp[x1][y2+1] - dp[x2+1][y1] + dp[x1][y1]);
        }
    }

}
