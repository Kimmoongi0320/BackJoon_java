import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k][n+1];
        Arrays.fill(dp[0],1);
        for (int i =0; i < k; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i < k; i++){
            for(int j = 1; j < n+1; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }

        System.out.print(dp[k-1][n] % 1000000000);


    }
}
