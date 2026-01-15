import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int num;
        double cost;

        public Node(int num, double cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n];
        double[][] path = new double[n][n];

        List<double[]> stars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new double[]{x, y});
        }

        // 모든 쌍의 거리 계산
        for (int i = 0; i < n; i++) {
            double[] from = stars.get(i);
            for (int j = i + 1; j < n; j++) {
                double[] to = stars.get(j);
                double length = Math.sqrt(Math.pow(from[0] - to[0], 2) + Math.pow(from[1] - to[1], 2));
                path[i][j] = length;
                path[j][i] = length;
            }
        }

        // Prim 알고리즘
        double answer = 0;
        double[] minCost = new double[n];
        Arrays.fill(minCost, Double.MAX_VALUE);
        minCost[0] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Double.compare(a.cost, b.cost));
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (visited[cur.num]) continue;  // 이미 방문한 노드 스킵
            
            visited[cur.num] = true;
            answer += cur.cost;  

            for (int i = 0; i < n; i++) {
                if (!visited[i] && path[cur.num][i] < minCost[i]) {
                    minCost[i] = path[cur.num][i];
                    queue.add(new Node(i, minCost[i]));
                }
            }
        }

        System.out.printf("%.2f%n", answer);
    }
}