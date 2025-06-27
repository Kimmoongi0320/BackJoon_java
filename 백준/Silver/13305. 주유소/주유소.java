import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lengths = new int[n-1];
        int[] costs = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n-1 ; i++){
            lengths[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int lastCost = 0;

        for (int i = 0; i < n; i++){
            if (i == 0){
                answer += costs[i] * lengths[i];
                lastCost = costs[i];
            } else if (i == n-1) {
                continue;
            } else {
                if (costs[i] > lastCost){
                    answer += lastCost*lengths[i];
                }else{
                    answer += costs[i] * lengths[i];
                    lastCost = costs[i];
                }
            }
        }

        System.out.print(answer);

    }


}
