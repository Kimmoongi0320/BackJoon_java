import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        long endIdx = 0;
        int answer = 0;

        long[][] water = new long[n][2];
        for (int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            water[i] = new long[]{start, end};
        }

        Arrays.sort(water, (a,b)->Long.compare(a[0],b[0]));

        for (int i = 0 ; i < n;i++){
            long[] currentWater = water[i];
            long waterStart = currentWater[0];
            long waterEnd = currentWater[1];

            if (endIdx <waterStart) endIdx = waterStart;

            while(endIdx < waterEnd){
                endIdx += l;
                answer++;
            }

        }

        System.out.print(answer);
    }
}
