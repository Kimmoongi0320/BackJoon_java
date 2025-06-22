import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();
        int length1 = word1.length();
        int length2 = word2.length();
        
        int maxLength = 0;
        int[] lastIdx = new int[0];
        List<Character> answer = new ArrayList<>();
        
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 1; i < length1+1; i++){
            for (int j = 1; j  <length2+1; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    //만약 최장인 경우 해당 위치 char result에 추가
                    if (dp[i][j] > maxLength){
                        lastIdx = new int[]{i,j};
                        maxLength = dp[i][j];
                    }
                }else {
                    dp[i][j] = Integer.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        

        if (maxLength == 0){
            System.out.println(0);
        }else {
            int i = lastIdx[0];
            int j = lastIdx[1];
            StringBuilder sb = new StringBuilder();
            while (i > 0 && j >0){
                char cha1 = word1.charAt(i-1);
                char cha2 = word2.charAt(j-1);

                if (cha1 == cha2){
                    sb.append(cha1);
                    i--;
                    j--;
                }else if (dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else j--;
            }

            System.out.println(maxLength);
            System.out.println(sb.reverse());
        }






    }

}
