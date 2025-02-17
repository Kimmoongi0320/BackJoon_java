import  java.util.*;
import java.io.*;
public class Main {
    static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        int[] visited = new int[n+1];
        visited[startNode] = 1;
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0 ; i < n+1;i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges.get(start).add(end);
            edges.get(end).add(start);
        }

        for(int i = 1 ; i < n+1;i++){
            Collections.sort(edges.get(i));
        }
        DFS(edges,startNode,visited);
        System.out.println();

        visited = new int[n+1];
        visited[startNode] = 1;

        for (int node: BFS(edges,startNode,visited)){
            System.out.print(node+" ");
        }


    }

    public static List<Integer> BFS(List<List<Integer>> edges,int startNode , int[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);

        List<Integer> result  = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(int edge: edges.get(node)){
                if (visited[edge] != 1){
                    queue.add(edge);
                    visited[edge] = 1;
                }
            }
        }
        return result;
    }

    public static void DFS(List<List<Integer>> edges,int startNode , int[] visited){
        System.out.print(startNode+" ");
        if (!edges.get(startNode).isEmpty()){
            for(int node: edges.get(startNode)){
                if (visited[node] != 1){
                    visited[node] = 1;
                    DFS(edges,node,visited);
                }
            }
        }
    }


}
