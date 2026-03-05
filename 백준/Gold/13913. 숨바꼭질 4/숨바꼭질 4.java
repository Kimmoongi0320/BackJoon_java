import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        // 경로 역추적
        List<Integer> path = new ArrayList<>();
        int index = K;
        while (index != N) {
            path.add(index);
            index = parent[index];
        }
        path.add(N);

        StringBuilder sb = new StringBuilder();
        sb.append(time[K]).append("\n");
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(N);
        time[N] = 0;  // 시작점 0으로 명확하게

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) return;  // 목적지 도달 시 즉시 종료

            int[] next = {now + 1, now - 1, now * 2};
            for (int nx : next) {
                if (nx < 0 || nx > 100000) continue;
                if (time[nx] == 0 && nx != N) {  // 미방문 체크
                    q.add(nx);
                    time[nx] = time[now] + 1;
                    parent[nx] = now;
                }
            }
        }
    }
}