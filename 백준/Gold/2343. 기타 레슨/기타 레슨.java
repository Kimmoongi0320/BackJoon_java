import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] classes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        classes = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        int hi = 0;
        for(int i=0;i<n;i++){
            int length = Integer.parseInt(st.nextToken());
            classes[i] = length;
            hi += length;
        }

        int low = classes[n-1];

        while(low < hi){
            int mid = (low+hi)/2;

            if(canDivide(mid)){
                hi = mid;
            }else{
                low = mid + 1;
            }
        }

        System.out.println(low);

    }

    static boolean canDivide(int length){
        int count = 1;
        int sum = classes[0];

        for(int i=1; i < n; i++){
            int nextLength = classes[i];
            if(nextLength > length) return false;
            if(sum + nextLength > length){
                count++;
                sum = nextLength;
            }else{
                sum += nextLength;
            }
        }

        return count <= m;
    }
}