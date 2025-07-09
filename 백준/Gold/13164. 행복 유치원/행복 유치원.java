import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n==k){
            System.out.println(0);
            return;
        }

        List<Integer> gap = new ArrayList<>();
        int[] heights = new int[n+1];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++){
            int height = Integer.parseInt(st.nextToken());
            heights[i] = height;
        }

        for (int i = 0; i < n-1; i++){
            gap.add(heights[i+1] - heights[i]);
        }

        gap.sort((a,b)->Integer.compare(a,b));
        int answer = 0;
        for (int i =0 ; i < gap.size()-k+1; i++){
            answer += gap.get(i);
        }

        System.out.println(answer);
    }
}