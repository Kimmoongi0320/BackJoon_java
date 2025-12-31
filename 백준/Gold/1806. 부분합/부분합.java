import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int sum = nums[0];
        int startIdx = 0;
        int endIdx = 0;
        boolean changed = true;
        
        if(sum >= s){
            System.out.println(1);
            return;
        }

        while (changed){

            if(sum >= s){
                answer = Integer.min(answer, endIdx - startIdx + 1);
                sum -= nums[startIdx];
                startIdx++;
            }else if(endIdx < n - 1){
                endIdx++;
                sum += nums[endIdx];
            }else{
                changed = false;
            }
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }
    }
}