import java.util.*;
import  java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ports =  new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < n; i++){
            ports[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(ports[0]);

        for(int i = 1; i < n; i++){
            int size = dp.size();
            int num = ports[i];

            if(dp.get(size-1) < num){
                dp.add(num);
            }else{
                int pos = binarySearch(dp,0,size-1,num);
                dp.set(pos,num);
            }
        }

        System.out.print(dp.size());


    }
    public static int binarySearch(List<Integer> arr, int start, int end, int val){

        while(start < end){
            int mid = (start+end)/2;
            if(arr.get(mid) < val){
                start = mid +1;
            }else{
                end = mid;
            }
        }

        return end;
    }

}


