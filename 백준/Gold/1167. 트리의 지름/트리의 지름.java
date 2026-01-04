import java.util.*;
import java.io.*;

public class Main {

    static List<List<Node>> edges;
    static int farthest;
    static int maxDist;

    public static class Node {
        int value;
        int cost;
        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int i = 0; i <= v; i++) edges.add(new ArrayList<>());

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                edges.get(from).add(new Node(next, cost));
            }
        }

        // 1) 임의의 정점에서 가장 먼 정점 A 찾기
        maxDist = -1;
        farthest = 1;
        boolean[] visited = new boolean[v + 1];
        dfs(1, 0, visited);
        int A = farthest;

        // 2) A에서 가장 먼 거리 = 지름
        maxDist = -1;
        visited = new boolean[v + 1];
        dfs(A, 0, visited);

        System.out.println(maxDist);
    }

    static void dfs(int cur, int dist, boolean[] visited) {
        visited[cur] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farthest = cur;
        }

        for (Node next : edges.get(cur)) {
            if (!visited[next.value]) {
                dfs(next.value, dist + next.cost, visited);
            }
        }
    }
}
