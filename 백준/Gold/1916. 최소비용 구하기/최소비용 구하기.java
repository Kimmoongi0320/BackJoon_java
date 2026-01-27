import java.util.*;
import  java.io.*;
public class Main {
    static class Node{
        int cityNum;
        int cost;

        public Node(int cityNum, int cost){
            this.cityNum = cityNum;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> edges = new ArrayList<>();
        for(int i = 0 ; i < n+1; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int startCity =  Integer.parseInt(st.nextToken());
        int endCity =  Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.cost,b.cost));
        pq.add(new Node(startCity,0));

        while(!pq.isEmpty()){

            Node node = pq.poll();
            if(visited[node.cityNum]) continue;
            visited[node.cityNum] = true;
            dist[node.cityNum] = node.cost;

            for(Node next: edges.get(node.cityNum)){
                if(dist[next.cityNum] > dist[node.cityNum] + next.cost){
                    dist[next.cityNum] = dist[node.cityNum] + next.cost;
                    pq.add(new Node(next.cityNum, dist[next.cityNum]));
                }
            }
        }

        System.out.print(dist[endCity]);

    }

}
