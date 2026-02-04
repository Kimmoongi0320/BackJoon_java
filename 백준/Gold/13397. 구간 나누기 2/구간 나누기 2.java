import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            minVal = Integer.min(minVal,num);
            maxVal = Integer.max(maxVal,num);
        }

        int low = 0;
        int high = maxVal-minVal;

        while(low < high){
            int mid = (low+high)/2;
            if(canDivde(mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        System.out.print(low);
    }

    public static boolean canDivde(int limit){
        int count = 1;
        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < n; i++){
            int newMin = Integer.min(min,nums[i]);
            int newMax = Integer.max(max,nums[i]);
            if(newMax-newMin > limit){
                count++;
                min = nums[i];
                max = nums[i];
            }else{
                min = newMin;
                max = newMax;
            }
        }

        return count <= m;
    }
}