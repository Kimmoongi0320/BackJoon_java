import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> LCS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LCS = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        LCS.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > LCS.get(LCS.size()-1)) {
                LCS.add(num);
            }else{
                int pos = binarySearch(0,LCS.size()-1,num);
                LCS.set(pos,num);
            }

        }

        System.out.println(LCS.size());

    }

    static int binarySearch(int start,int end,int num){
        while (start <= end){
            int mid = (start + end)/2;

            if(LCS.get(mid) < num){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }

        return start;
    }
}