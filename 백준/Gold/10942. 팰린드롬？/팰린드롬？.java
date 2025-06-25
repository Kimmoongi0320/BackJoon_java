import java.awt.*;
import  java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n+1; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // i ~j 가 팰린드롬이면 1을 저장하는 2차원 dp 배열
        boolean[][] dp  = new boolean[n+1][n+1];

        // 기본적으로 i,i 는 팰린드롬, i, i+1 의 숫자가 같으면 팰린드롬
        for (int i = 1; i < n+1; i++){
            dp[i][i] = true;
            if (i < n && numbers[i] == numbers[i+1] ) dp[i][i+1] = true;
        }

        for (int i = 2; i < n; i++){
            for (int j = 1; j < n-i+1; j++){
                if (numbers[j]== numbers[j+i] && dp[j + 1][j + i - 1]){
                    dp[j][j+i] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end] ? "1\n" : "0\n");
        }
        System.out.println(sb);

    }


}
