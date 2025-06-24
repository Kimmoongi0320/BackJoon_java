import java.awt.*;
import  java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int[] dp = new int[n];
        int[] reverseDp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            numbers[i] = num;
        }

        Arrays.fill(dp,1);
        Arrays.fill(reverseDp,1);

        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (numbers[i] > numbers[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;

                }
            }
        }

        //역순으로 검사
        for (int i = n-2; i >= 0; i--){
            for (int j = n-1; j > i; j--){
                if (numbers[i] > numbers[j] && reverseDp[j]+1 > reverseDp[i]){
                    reverseDp[i] = reverseDp[j] + 1;

                }
            }
        }

        //각 배열의 증가 최대 길이를 더하면 최대 바이토닉 함수를 구할 수 있음
        int answer = 0;
        for (int i =0; i < n ; i++){
            int totalLength = dp[i]+reverseDp[i];
            if (answer < totalLength){
                answer = totalLength;
            }
        }
        // 최대 교차점은 2번 더해지므로 1 빼주기
        System.out.println(answer-1);
        

    }


}
