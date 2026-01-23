import java.util.*;
import  java.io.*;
public class Main {
    static int[][] dp;
    static int[][] checkFirstColor;
    static int[][] cost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][3];
        cost = new int[n+1][3];

        for(int i = 1; i < n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < 3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int firstColor = 0; firstColor < 3; firstColor++){

            for(int i = 0 ; i < 3; i++){
                if(i == firstColor){
                    dp[1][i] = cost[1][firstColor];
                }else{
                    dp[1][i] = 1000000;
                }
            }

            for(int i = 2; i < n+1; i++){
                dp[i][0] = Integer.min(dp[i-1][1],dp[i-1][2]) + cost[i][0];
                dp[i][1] = Integer.min(dp[i-1][0],dp[i-1][2]) + cost[i][1];
                dp[i][2] = Integer.min(dp[i-1][0],dp[i-1][1]) + cost[i][2];
            }
            for(int i = 0; i < 3; i++){
                if(i != firstColor){
                    answer = Integer.min(dp[n][i],answer);
                }
            }
        }

        System.out.println(answer);
    }


}
