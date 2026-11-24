import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> edges;
    static int[] arrive;
    static int order = 1;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        edges = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            edges.add(new ArrayList<>());
        }
        arrive = new int[n+1];


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from =  Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges.get(from).add(to);
            edges.get(to).add(from);
        }
        for(int i = 1; i < n+1; i++){
            edges.get(i).sort(null);
        }
        visited[r] = true;
        dfs(r);

        for(int i = 1; i < n+1; i++){
            System.out.println(arrive[i]);
        }
    }

    static void dfs(int cur){
        arrive[cur] = order++;

        for(int next: edges.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);

            }
        }
    }

}