import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){

            String commands = br.readLine();

            int n =  Integer.parseInt(br.readLine());
            String lines = br.readLine();
            String[] ns = lines.substring(1,lines.length()-1).split(",");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(ns[i]);
            }



            boolean success = true;
            int l = 0;
            int r = n-1;
            boolean reverse = false;
            for(int i = 0; i < commands.length(); i++){
                char c = commands.charAt(i);
                if(c == 'R') reverse = !reverse;
                else{
                    if(l > r){
                        success = false;
                        break;
                    }

                    if(reverse) r--;
                    else l++;
                }
            }
            if(!success){
                System.out.println("error");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(!reverse){
                for(int i= l; i <= r; i++){
                    if(i == r){
                        sb.append(nums[i]);
                        break;
                    }
                    sb.append(nums[i]).append(",");
                }
            }else{
                for(int i= r; i >=l; i--){
                    if(i == l){
                        sb.append(nums[i]);
                        break;
                    }
                    sb.append(nums[i]).append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }

    }


}