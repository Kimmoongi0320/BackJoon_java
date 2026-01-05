import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][n+1];
        int[] d =  new int[n+1];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            d[i+1] = Integer.parseInt(st.nextToken());
        }

        for(int interval = 1; interval < n; interval++){
            for(int start = 1; start + interval < n+1; start++){
                int end = start + interval;
                dp[start][end] = Integer.MAX_VALUE;

                for(int i = start;  i < end; i++){
                    int totalCount = dp[start][i] + dp[i+1][end] + d[start-1]*d[i]*d[end];

                    dp[start][end] = Integer.min(dp[start][end],totalCount);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}