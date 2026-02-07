import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] lines;
    static List<Integer> connectedLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        lines = new int[n];
        for(int i = 0; i<n; i++){
            lines[i] = Integer.parseInt(st.nextToken());
        }

        connectedLine = new ArrayList<>();
        connectedLine.add(lines[0]);

        for(int i = 1; i < n; i++){
            int num = lines[i];
            int length = connectedLine.size();

            if(num > connectedLine.get(length-1)){
                connectedLine.add(num);
            }else{
                int pos = binarySearch(num,length);
                connectedLine.set(pos,num);
            }
        }

        System.out.print(n-connectedLine.size());

    }

    static int binarySearch(int num,int length){
        int low = 0;
        int hi = length-1;
        while(low < hi){
            int mid = (low+hi)/2;

            if(connectedLine.get(mid) < num){
                low = mid +1;
            }else{
                hi = mid;
            }
        }
        return low;
    }

}