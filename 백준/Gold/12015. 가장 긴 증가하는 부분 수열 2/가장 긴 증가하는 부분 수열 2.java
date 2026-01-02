import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] binary =  new int[n];

        binary[0] = nums[0];
        int curIdx = 1;

        for(int i=1;i<n;i++){
            int nextNum = nums[i];

            if(nextNum > binary[curIdx- 1]){
                binary[curIdx] = nextNum;
                curIdx++;
            }else{
                int lowIdx = 0;
                int highIdx = curIdx;

                while(lowIdx<highIdx){

                    int mid = (lowIdx+highIdx)/2;

                    if(binary[mid]>=nextNum){
                        highIdx = mid;
                    }else{
                        lowIdx = mid+1;
                    }
                }

                binary[lowIdx] = nextNum;
            }
        }

        System.out.println(curIdx);

    }
}