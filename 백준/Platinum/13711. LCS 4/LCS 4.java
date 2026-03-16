import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> sequence;
    static List<Integer> LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int nums1[] = new int[n+1];
        int nums2[] = new int[n+1];
        sequence = new ArrayList<>();
        LIS = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i < n+1; i++){
            nums1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i < n+1; i++){
            nums2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n+1; i++){
            int num = nums1[i];
            for(int j = 1; j < n+1; j++){
                if(num == nums2[j]){
                    sequence.add(new int[]{i,j});
                    break;
                }
            }
        }

        LIS.add(sequence.get(0)[1]);
        for(int i = 1; i < n; i++){
            int to = sequence.get(i)[1];
            if(LIS.get(LIS.size()-1) < to){
                LIS.add(to);
            }else{
                int idx = binarySearch(LIS.size()-1, to);
                LIS.set(idx,to);
            }
        }

        System.out.print(LIS.size());

    }

    static int binarySearch(int end, int num){
        int start = 0;

        while(start < end){
            int mid = (start+end) /2;

            if(LIS.get(mid) < num){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        return end;
    }
}