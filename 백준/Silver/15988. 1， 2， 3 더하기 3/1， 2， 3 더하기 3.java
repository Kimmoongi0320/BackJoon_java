import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        // 각각 1,2,3 을 더해주는 경우
        // dp[4] = dp[3] 에 1 더하는 경우 + dp[2] 에 2 더하는 경우 + dp[1] 에 3 더하는 경우
        for (int i = 4; i < 1000001; i++){
            dp[i] += ((dp[i-1] + dp[i-2]) % 1000000009 + dp[i-3])%1000000009;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }


}
