import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int midIdx = 0;

        int num = Integer.parseInt(br.readLine());
        list.add(num);
        sb.append(list.get(midIdx)).append("\n");

        for(int i = 1; i < n; i++){
            num = Integer.parseInt(br.readLine());
            if(i % 2 == 0) midIdx++;

            int pos = binarySearch(list,0,list.size()-1,num);
            list.add(pos,num);
            sb.append(list.get(midIdx)).append("\n");

        }

        System.out.println(sb);
    }

    static int binarySearch(List<Integer> list, int start, int end,int num) {
        while(start <= end){
            int mid = (start+end)/2;
            if(list.get(mid) < num){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}