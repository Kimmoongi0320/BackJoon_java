import  java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            edges.add(new ArrayList<>());
        }
        int[] visited = new int[n+1];
        for(int i = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges.get(start).add(end);
            edges.get(end).add(start);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1]=1;
        int answer = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int edge:edges.get(node)){
                if (visited[edge] != 1){
                    visited[edge] =1 ;
                    queue.add(edge);
                    answer += 1;
                }
            }
        }

        System.out.print(answer);

    }


}
