import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long d = y-x;

            long k =(long) Math.sqrt(d);

            if(d == k*k){
                System.out.println(2*k-1);
            }else if(d <= k*k + k){
                System.out.println(2*k);
            }else System.out.println(2*k+1);

        }
    }

}