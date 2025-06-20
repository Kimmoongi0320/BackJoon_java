import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static long[][]dp;
    static long[][]board;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //board, dp 초기화
        board = new long[n][n];
        dp = new long[n][n];

        //board 채우기
        for (int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //시작 칸은 1로 초기화
        dp[0][0] = 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (dp[i][j] == 0) continue;
                else {
                    //움직일 수 있는 거리
                    long move = board[i][j];

                    if (i == n-1 && j == n-1) {
                        continue;
                    }
                    //아래로 움직이는 경우
                    if (i+move < n){
                        dp[(int) (i+move)][j] += dp[i][j];
                    }
                    // 오른쪽 이동
                    if (j+move < n){
                        dp[i][(int) (j+move)] += dp[i][j];
                    }

                }
            }
        }
        System.out.print(dp[n-1][n-1]);


    }
}
