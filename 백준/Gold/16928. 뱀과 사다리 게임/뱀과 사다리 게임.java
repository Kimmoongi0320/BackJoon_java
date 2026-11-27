import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ladders = new int[101];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int down =  Integer.parseInt(st.nextToken());
            int up =  Integer.parseInt(st.nextToken());
            ladders[down] = up;
        }
        int[] snakes = new int[101];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int up =  Integer.parseInt(st.nextToken());
            int down =  Integer.parseInt(st.nextToken());

            snakes[up] = down;

        }

        boolean[] visited = new boolean[101];
        Queue<int[]> queue =new ArrayDeque<>();
        queue.add(new int[]{1,0});

        int answer = -1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int stair =  cur[0];
            int count = cur[1];

            if(stair == 100){
                answer = count;
                break;
            }

            for(int i = 1; i <= 6; i++){
                int next = stair+i;
                if(next > 100) continue;
                if(ladders[next] !=- 0) {
                    visited[next] = true;
                    next = ladders[next];
                }
                if(snakes[next] !=- 0) {
                    visited[next] = true;
                    next = snakes[next];
                }

                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next,count+1});
                }
            }
        }

        System.out.print(answer);


    }



}