import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];


        for (int i =0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if (num > k){
                continue;
            }
            dp[num] = 1;
        }

        for (int i =1; i < k+1; i++){
            for(int j = 0; j<= i/2; j++){
                if (dp[j] == 0 || dp[i-j] == 0) continue;
                int sum = dp[j] + dp[i-j];
                if (dp[i] == 0) dp[i] = sum;
                else if (sum != 0 && dp[i] > sum) {
                    dp[i] = Integer.min(dp[i],sum);
                }
            }
        }

        if (dp[k] == 0) {
            System.out.print(-1);
            return;
        }else System.out.print(dp[k]);

    }
}
