import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line =  br.readLine();
        int n = line.length();

        boolean[][] palindrome = new boolean[n+1][n+1];

        for(int i = 1; i < n; i++){
            palindrome[i][i] = true;
            if(line.charAt(i-1) == line.charAt(i)) palindrome[i][i+1] = true;
        }
        palindrome[n][n] = true;

        for(int i = 2; i < n+1; i++){
            for (int j = 1; j < i; j++){
                if(line.charAt(j-1) == line.charAt(i-1) && palindrome[j+1][i-1]) {
                    palindrome[j][i] = true;
                }
            }
        }

        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1] + 1;
        }

        for(int i = 2; i < n+1; i++){
            for(int j = 1; j <= i; j++){
                if(palindrome[j][i]) dp[i] = Integer.min(dp[i],dp[j-1]+1);
            }
        }

        System.out.print(dp[n]);

    }

}

