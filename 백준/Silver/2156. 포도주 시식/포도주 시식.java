import java.awt.*;
import java.nio.Buffer;
import  java.util.*;
import java.io.*;



public class Main {
    static int[] dp;
    static int[] glass;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        glass = new int[n];

        for (int i =0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            glass[i] = num;
        }
        if (n == 1) {
            System.out.println(glass[0]);
            return;
        }
        if (n == 2) {
            System.out.println(glass[0] + glass[1]);
            return;
        }
        dp[0] = glass[0];
        dp[1] = glass[0] + glass[1];
        dp[2] = Math.max(dp[1], Math.max(glass[0] + glass[2], glass[1] + glass[2]));

        for (int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + glass[i], dp[i - 3] + glass[i - 1] + glass[i]));

        }
        System.out.print(Arrays.stream(dp).max().getAsInt());
    }

}
