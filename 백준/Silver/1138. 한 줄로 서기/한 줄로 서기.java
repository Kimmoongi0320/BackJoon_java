import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n  = Integer.parseInt(br.readLine());

         StringTokenizer st = new StringTokenizer(br.readLine());
         int[] nums = new int[n+1];
         for (int i = 1; i < n+1; i++){
             nums[i] = Integer.parseInt(st.nextToken());
         }

         List<Integer> answer =  new LinkedList<>();

         for (int i = n; i>0; i--){
             answer.add(nums[i],i);
         }

         StringBuilder sb = new StringBuilder();

         for (int num: answer){
             sb.append(num).append(" ");
         }

         System.out.print(sb);
        }
    }

