import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] costs = new int[100001];
        int[] counts = new int[100001];
        Arrays.fill(costs,Integer.MAX_VALUE);

        costs[n] = 0;
        counts[n] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int cost = cur[1];


            if (pos * 2 < 100001) {
                if (costs[pos * 2] > cost + 1) {
                    costs[pos * 2] = cost + 1;
                    counts[pos * 2] = counts[pos];
                    queue.add(new int[]{pos * 2, cost + 1});
                } else if (costs[pos * 2] == cost + 1) {
                    counts[pos * 2] += counts[pos];
                }
            }
            if (pos + 1 < 100001) {
                if (costs[pos + 1] > cost + 1) {
                    costs[pos + 1] = cost + 1;
                    counts[pos + 1] = counts[pos];
                    queue.add(new int[]{pos + 1, cost + 1});
                } else if (costs[pos + 1] == cost + 1) {
                    counts[pos + 1] += counts[pos];
                }
            }
            if (pos - 1 >= 0) {
                if (costs[pos - 1] > cost + 1) {
                    costs[pos - 1] = cost + 1;
                    counts[pos - 1] = counts[pos];
                    queue.add(new int[]{pos - 1, cost + 1});
                } else if (costs[pos - 1] == cost + 1) {
                    counts[pos - 1] += counts[pos];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(costs[m]).append("\n").append(counts[m]);
        System.out.print(sb);
    }
}