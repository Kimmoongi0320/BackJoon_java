import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] heights = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < w; i++){
            int cur =  heights[i];
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++){
                left = Math.max(left, heights[j]);
            }
            for(int j = i+1; j < w; j++){
                right = Math.max(right, heights[j]);
            }

            int compare = Math.min(left,right);
            if(compare - cur > 0) answer+=(compare-cur);
        }
        System.out.println(answer);

    }

}