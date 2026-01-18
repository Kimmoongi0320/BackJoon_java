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

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Node>> edges = new ArrayList<>();
        for(int i = 0; i < v+1; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine()," ");

            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new Node(to,cost));
            edges.get(to).add(new Node(from,cost));
        }

        int[] visited = new int[v+1];
        int answer = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.cost,b.cost));
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.num] == 1) continue;

            visited[cur.num] = 1;
            answer += cur.cost;

            for(Node next : edges.get(cur.num)){
                if(visited[next.num] == 0){
                    pq.add(next);
                }
            }
        }

        System.out.println(answer);
    }

}

