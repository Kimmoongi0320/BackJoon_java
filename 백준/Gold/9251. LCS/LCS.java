import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();

        int n = line1.length();
        int m = line2.length();
        dp = new int[Integer.max(n,m)+1][Integer.max(n,m)+1];
        for (int i =0; i < n; i++){
            char line1Character = line1.charAt(i);
            for (int j =0; j < m ; j++){
                char line2Character = line2.charAt(j);
                // 만약 추가하는 단어가 같은경우 AB'C', GB'C' 인 경우 같은 단어를 추가하는 것이므로 AB,GB를 비교한 누적합 값에 1을 더해준다.
                if (line1Character == line2Character){
                    dp[i+1][j+1] = dp[i][j] + 1;
                //만약 추가하는 단어가 다른 경우. AB 와 GBC의 공통 부분 수열 => A,GBC or AB,GB 의 공통 부부 수열중 최대 값 (추가하는 단어가 다르기 때문)
                }else {
                    dp[i+1][j+1] = Integer.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }



        System.out.print(dp[n][m]);
    }

}
