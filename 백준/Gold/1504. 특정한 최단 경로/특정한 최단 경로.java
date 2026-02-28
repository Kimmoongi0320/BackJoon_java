import java.io.*;
import java.util.*;

public class Main {
    static int n,e;
    static List<List<Node>> paths = new ArrayList<>();
    static class Node{
        int next;
        int cost;

        public Node(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n+1; i++) {
            paths.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            paths.get(from).add(new Node(to, cost));
            paths.get(to).add(new Node(from, cost));
        }


        st = new StringTokenizer(br.readLine()," ");
        int firstRoute = Integer.parseInt(st.nextToken());
        int secondRoute = Integer.parseInt(st.nextToken());

        int betweenRoute = findPath(firstRoute,secondRoute);

        int res1 = 0;
        res1 += findPath(1,firstRoute);
        res1+= betweenRoute;
        res1 += findPath(secondRoute,n);

        int res2 = 0;
        res2 += findPath(1,secondRoute);
        res2+= betweenRoute;
        res2 += findPath(firstRoute,n);

        if(res1 >= 200000000 || res2 >= 200000000){
            System.out.println("-1");
        }else{
            System.out.println(Integer.min(res1,res2));
        }




    }

    public static int findPath(int start,int end){
        int[] costs = new int[n+1];
        Arrays.fill(costs, 200000000);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(costs[node.next] <= node.cost) continue;

            costs[node.next] = node.cost;

            for(Node next: paths.get(node.next)){
                int nextCost = costs[node.next]+next.cost;
                if(costs[next.next] > nextCost){
                    pq.add(new Node(next.next,nextCost));
                }
            }
        }

        return costs[end];
    }

}
