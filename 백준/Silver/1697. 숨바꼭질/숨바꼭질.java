import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[200001];  // 범위를 0~100000으로 제한

        q.add(n);
        visited[n] = true;

        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int current = q.poll();

                // 가능한 이동
                int[] nextMoves = {current + 1, current - 1, current * 2};

                for (int next : nextMoves) {
                    if (next == m) {
                        System.out.println(answer + 1);
                        return;
                    }
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            answer++;
        }
    }
}
