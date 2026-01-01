import java.util.*;
import java.io.*;

public class Main{

    static List<List<Node>> costs = new ArrayList<>();

    static class Node{
        int value;
        int cost;

        public Node(int value, int cost){
            this.value = value;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] backPathCost =  new int[n+1];
        Arrays.fill(backPathCost, Integer.MAX_VALUE);
        backPathCost[x] = 0;

        for(int i = 0; i < n+1; i++){
            costs.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            costs.get(from).add(new Node(to, cost));
        }

        dijkstra(x,backPathCost);

        int answer = 0;

        for(int i = 1; i < n+1; i++){
            int[] goPathCost =  new int[n+1];
            Arrays.fill(goPathCost, Integer.MAX_VALUE);
            goPathCost[i] = 0;
            dijkstra(i,goPathCost);

            answer = Integer.max(answer, goPathCost[x]+ backPathCost[i]);
        }

        System.out.println(answer);
    }

    static void dijkstra(int start,int[] costPath){

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        pq.add(new Node(start,0));
        while(!pq.isEmpty()){

            Node node = pq.poll();

            for(Node next: costs.get(node.value)){

                int nextCost = node.cost + next.cost;
                if(nextCost < costPath[next.value]){
                    costPath[next.value] = nextCost;
                    pq.add(new Node(next.value,nextCost));
                }
            }
        }
    }
}