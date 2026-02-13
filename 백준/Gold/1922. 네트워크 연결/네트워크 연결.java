import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<int[]>> paths = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            paths.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n+1];

        for(int i = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            paths.get(from).add(new int[]{to,cost});
            paths.get(to).add(new int[]{from,cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{1,0});

        int totalCost = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int nodeNum = cur[0];
            int cost = cur[1];

            if(visited[nodeNum]) continue;
            visited[nodeNum] = true;
            totalCost += cost;

            for(int[] next : paths.get(nodeNum)){
                pq.add(new int[]{next[0],next[1]});
            }
        }

        System.out.print(totalCost);
    }


}