import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        int[] position = new int[n];
        list.add(nums[0]);
        position[0] = 0;

        for(int i =1; i< n; i++){
            int length = list.size();

            if(list.get(length-1) < nums[i]){
                list.add(nums[i]);
                position[i] = length;
            }else{
                int pos = binarySearch(list,0,length-1,nums[i]);
                list.set(pos, nums[i]);
                position[i] = pos;
            }
        }

        int[] answer = new int[list.size()];
        int point  = list.size()-1;
        for(int i = n-1; i >=0 && point >=0; i--){
            if(position[i] == point){
                answer[point] = nums[i];
                point--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int i : answer){
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    static int binarySearch(List<Integer> list, int start, int end,int num){

        while(start < end){
            int mid = (start+end) /2;
            if(list.get(mid) < num){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}