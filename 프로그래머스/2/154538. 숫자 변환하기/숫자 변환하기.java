import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        boolean[] visited = new boolean[y + 1];
        visited[x] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                int[] nexts = { cur + n, cur * 2, cur * 3 };

                for (int next : nexts) {
                    if (next == y) return count;
                    if (next < y && !visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        return -1;
    }
}