import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        int[] scores = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++){
            int score = Integer.parseInt(st.nextToken());
            scores[i] =score;
        }
        dp[0] = scores[0];
        for(int i =1; i < n; i++){
            dp[i] = Integer.max(dp[i-1]+scores[i],scores[i]);
        }
        System.out.print(Arrays.stream(dp).max().getAsInt());

    }

}
