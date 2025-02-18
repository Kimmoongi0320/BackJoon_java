
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int minutes;
        Node(int end, int minutes){
            this.end = end;
            this.minutes = minutes;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.minutes, o.minutes);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int startNode = 1;
        int endNode = n;
        int[] minCosts = new int[n+1];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[startNode] = 0;

        List<int[]>path = new ArrayList<>();

        List<List<Node>> costs = new ArrayList<>();
        for(int i = 0 ; i<n+1; i++){
            costs.add(new ArrayList<>());
        }
        for(int i = 0; i < m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int minutes = Integer.parseInt(st.nextToken());
            costs.get(start).add(new Node(end, minutes));
            costs.get(end).add(new Node(start, minutes));
        }
        // 마지막 노드와의 연결점이 한개인 경우
        if(costs.get(endNode).size() == 1){
            System.out.println(-1);
            return;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(minCosts[current.end] < current.minutes) continue;

            for(Node next: costs.get(current.end)){
                int nextMinutes = current.minutes + next.minutes;
                if(nextMinutes < minCosts[next.end]){
                    minCosts[next.end] = nextMinutes;
                    queue.add(new Node(next.end, nextMinutes));
                    path.add(new int[]{current.end, next.end});
                }
            }

        }
        //검문 없는 경우 최단 거리
        int result = minCosts[endNode];
        //검문 있는 경우 최단 거리
        List<Integer> bannedCost = new ArrayList<>();
        for(int[] bridge:path){
            minCosts = new int[n+1];
            Arrays.fill(minCosts, Integer.MAX_VALUE);
            int node1 = bridge[0];
            int node2 = bridge[1];

            queue = new PriorityQueue<>();
            queue.add(new Node(startNode, 0));
            while(!queue.isEmpty()){
                Node current = queue.poll();

                if(minCosts[current.end] < current.minutes) continue;

                for(Node next: costs.get(current.end)){
                    if (current.end == node1 && next.end == node2) {
                        continue;
                    } else if (current.end == node2 && next.end == node1) {
                        continue;
                    }
                    int nextMinutes = current.minutes + next.minutes;
                    if(nextMinutes < minCosts[next.end]){
                        minCosts[next.end] = nextMinutes;
                        queue.add(new Node(next.end, nextMinutes));
                    }
                }

            }
            if (minCosts[endNode] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }else {
                bannedCost.add(minCosts[endNode]);
            }
        }

        System.out.print(Collections.max(bannedCost)-result);
    }
}
