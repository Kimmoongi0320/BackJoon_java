import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] fallPos = new int[t+1];
        int[][][] dp = new int[3][t+1][w+1]; // 위치, 시간, 움직임

        for(int time = 1; time < t+1; time++){
            int pos =  Integer.parseInt(br.readLine());
            fallPos[time] = pos;
        }

        if(fallPos[1] == 1){
            dp[1][1][0] = 1;
            dp[2][1][1] = 0;
        }else{
            dp[1][1][0] = 0;
            dp[2][1][1] = 1;
        }

        for(int time = 2; time < t+1; time++){
            int pos = fallPos[time];

            if(pos == 1){
                dp[1][time][0] = dp[1][time-1][0] + 1;
                dp[2][time][0] = dp[2][time-1][0];

                for(int moveCount = 1; moveCount <= Integer.min(time,w);  moveCount++){
                    dp[1][time][moveCount] = Integer.max(dp[1][time-1][moveCount],dp[2][time-1][moveCount-1]) + 1;
                    dp[2][time][moveCount] = Integer.max(dp[2][time-1][moveCount],dp[1][time-1][moveCount-1]);
                }
            }else {
                dp[1][time][0] = dp[1][time-1][0];
                dp[2][time][0] = dp[2][time-1][0] + 1;

                for(int moveCount = 1; moveCount <= Integer.min(time,w); moveCount++){
                    dp[1][time][moveCount] = Integer.max(dp[1][time-1][moveCount],dp[2][time-1][moveCount-1]);
                    dp[2][time][moveCount] = Integer.max(dp[2][time-1][moveCount],dp[1][time-1][moveCount-1])+1;
                }
            }

        }

        int answer = 0;
        for(int moveCount = 0; moveCount <= w; moveCount++){
            answer = Integer.max(answer,Integer.max(dp[1][t][moveCount],dp[2][t][moveCount]));
        }

        System.out.print(answer);


    }

}