import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> getLine;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        for(int i = 0 ; i < n; i++){
            heights[i] = Integer.parseInt(br.readLine());
        }

        getLine = new ArrayList<>();
        getLine.add(heights[0]);

        for(int i = 1; i < n; i++){
            if (getLine.get(getLine.size()-1) < heights[i]){
                getLine.add(heights[i]);
            }else{
                int idx = binarySearch(getLine.size()-1, heights[i]);
                getLine.set(idx, heights[i]);
            }
        }
        System.out.print(n-getLine.size());
    }

    public static int binarySearch(int end, int num){
        int start = 0;

        while(start < end){
            int mid = (start+end)/2;

            if (getLine.get(mid) < num){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        return end;
    }
}