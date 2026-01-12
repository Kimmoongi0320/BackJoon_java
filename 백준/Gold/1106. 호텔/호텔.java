import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c+101];
        int[][] costInfo = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int cost = Integer.parseInt(st.nextToken());
            int person =  Integer.parseInt(st.nextToken());

            costInfo[i] = new int[]{cost,person};
        }

        Arrays.sort(costInfo,(a,b) -> a[1]-b[1]);

        for(int i = 1; i< c+101; i++){
            dp[i] = Integer.MAX_VALUE;

            for(int j = 0; j < n; j++){
                int person = costInfo[j][1];
                if(person <= i && dp[i-person] != Integer.MAX_VALUE){
                    dp[i] = Integer.min(dp[i],dp[i-person] + costInfo[j][0]);
                }
            }
        }

        int answer = dp[c];
        for(int i = c; i < c+101; i++){
            answer = Math.min(answer,dp[i]);
        }

        System.out.println(answer);

    }
}