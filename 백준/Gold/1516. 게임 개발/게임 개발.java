import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] costs = new int[n+1];
        int[] degree = new int[n+1];
        List<List<Integer>> path = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            path.add(new ArrayList<>());
        }

        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;

            while(true){
                int beforeBuild = Integer.parseInt(st.nextToken());

                if(beforeBuild == -1) break;

                degree[i]++;
                path.get(beforeBuild).add(i);
            }
        }

        int[] totalCost = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(degree[i] == 0){
                queue.add(i);
                totalCost[i] = costs[i];
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next: path.get(cur)){
                degree[next]--;
                totalCost[next] = Integer.max(totalCost[next], totalCost[cur] + costs[next]);

                if(degree[next] == 0){
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(totalCost[i]).append("\n");
        }

        System.out.println(sb);
    }
}