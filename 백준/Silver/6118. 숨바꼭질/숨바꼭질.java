import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> paths = new ArrayList<>();
        for(int i= 0; i < n+1; i++){
            paths.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            paths.get(from).add(to);
            paths.get(to).add(from);
        }

        boolean[] visited = new boolean[n+1];
        int[] arrive =  new int[n+1];
        int max = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.add(new int[]{1,0});

        while(!queue.isEmpty()){
            int[] cur =  queue.poll();
            int num = cur[0];
            int dist =  cur[1];

            max = Math.max(max, dist);
            arrive[num] = dist;

            for(int next : paths.get(num)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next,dist+1});
                }
            }
        }

        int destination = 0;
        int total = 0;

        for(int i = 1; i < n+1; i++){
            if(arrive[i] == max){
                if(destination == 0){
                    destination = i;
                }
                total++;
            }
        }

        System.out.printf("%d %d %d",destination,max,total);

    }


}