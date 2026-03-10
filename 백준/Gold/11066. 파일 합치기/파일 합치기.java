import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int k  =Integer.parseInt(br.readLine());

            int[] fileSum = new int[k+1];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for(int i = 1; i < k+1; i++){
                fileSum[i] = fileSum[i-1]+Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[k+1][k+1];
            for(int gap = 1; gap < k; gap++){
                for(int start = 1; start+gap < k+1; start++){
                    int end = start + gap;
                    dp[start][end] = Integer.MAX_VALUE;

                    for(int mid = start; mid < end; mid++){
                        dp[start][end] = Integer.min(dp[start][end],dp[start][mid] + dp[mid+1][end] + fileSum[end] - fileSum[start-1]);
                    }
                }
            }

            sb.append(dp[1][k]).append("\n");
        }

        System.out.print(sb);
    }
}