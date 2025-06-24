import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,1);

        int maxNum = 1;
        int maxIdx = 0;

        for (int i = 1; i<n; i++){
            for (int j = 0; j < i; j++){
                if (numbers[i] > numbers[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxNum){
                        maxNum = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(numbers[maxIdx]);
        int currentNum = maxNum;
        int currentIdx = maxIdx;

        for (int i = maxIdx-1; i >=0; i--){
            if (dp[i] == currentNum-1 && numbers[i] < numbers[currentIdx]){
                list.add(numbers[i]);
                currentNum = dp[i];
                currentIdx = i;
            }
        }

        System.out.println(maxNum);
        Collections.reverse(list);
        for (int num: list){
            System.out.print(num + " ");
        }


    }


}
