import java.util.*;
import java.io.*;

public class Main {
    static class City {
        int city;
        long cost;

        City(int city, long cost){
            this.city = city;
            this.cost = cost;
        }
    }
    static class Node{
        int city;
        int before;
        long cost;

        Node(int city, int before, long cost){
            this.city = city;
            this.before = before;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] beforeCity = new int[n+1];
        long[] totalCost =  new long[n+1];

        Arrays.fill(totalCost,Long.MAX_VALUE);

        List<List<City>> path = new ArrayList<>();
        for(int i = 0; i< n+1; i++){
            path.add(new ArrayList<>());
        }

        for(int i = 0 ; i <m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            City city = new City(to,cost);
            path.get(from).add(city);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost,b.cost));
        pq.add(new Node(startCity,startCity,0));
        totalCost[startCity] = 0;


        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.cost > totalCost[node.city]) continue;

            for(City next : path.get(node.city)){
                long newCost = totalCost[node.city] + next.cost;

                // 더 짧은 경로를 발견했을 때만 갱신
                if(newCost < totalCost[next.city]){
                    totalCost[next.city] = newCost;
                    beforeCity[next.city] = node.city;  // 여기서 갱신!
                    pq.add(new Node(next.city, node.city, newCost));
                }
            }
        }
        System.out.println(totalCost[endCity]);

        int count = 1;
        int routeBeforeCity = beforeCity[endCity];
        List<Integer> route = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        route.add(endCity);

        while(routeBeforeCity != startCity){
            route.add(routeBeforeCity);
            count++;
            routeBeforeCity = beforeCity[routeBeforeCity];
        }
        route.add(startCity);
        count++;

        for(int i = route.size() - 1; i >= 0; i--){
            sb.append(route.get(i)).append(" ");
        }
        System.out.println(count);
        System.out.println(sb);
    }
}