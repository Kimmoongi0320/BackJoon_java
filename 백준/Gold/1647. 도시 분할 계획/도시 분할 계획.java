import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int num;
        int cost;

        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Node>> edges = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new Node(to,cost));
            edges.get(to).add(new Node(from,cost));
        }

        boolean[] visited = new boolean[n+1];
        int expensiveCost = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        queue.add(new Node(1,0));

        int totalCost = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nodeNum = node.num;
            int nodeCost = node.cost;

            if(visited[nodeNum]) continue;

            visited[nodeNum] = true;
            if (expensiveCost < nodeCost) expensiveCost = nodeCost;
            totalCost += nodeCost;

            for(Node next: edges.get(nodeNum)){
                if(!visited[next.num]){
                    queue.add(next);
                }
            }
        }

        System.out.println(totalCost-expensiveCost);

    }

}

